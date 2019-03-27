package by.gritsuk.dima.dao.impl;

import by.gritsuk.dima.dao.ConnectionPool;
import by.gritsuk.dima.dao.exception.ConnectionPoolException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayDeque;
import java.util.Properties;
import java.util.Queue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Implementation of Connection Pool
 */
public class ConnectionPoolImpl implements ConnectionPool {
    private static final Logger LOGGER = LogManager.getLogger(ConnectionPoolImpl.class);
    private static ConnectionPool instance;
    private static final Lock LOCK = new ReentrantLock();
    private final int POOL_CAPACITY = 20;
    private final Semaphore SEMAPHORE;
    private final Queue<Connection> POOL;
    private static final DAOProperties PROPERTIES = new DAOProperties();
    private Properties props;
    private static final String DB_FILE = "db.properties";

    private ConnectionPoolImpl() throws SQLException {
        POOL = new ArrayDeque<>(POOL_CAPACITY);
        SEMAPHORE = new Semaphore(POOL_CAPACITY);
        props = PROPERTIES.getDAOProperties(DB_FILE);
        initDriver();
        for (int i = 0; i < POOL_CAPACITY; i++) {
            Connection connection = DriverManager.getConnection(props.getProperty("url"), props);
            POOL.add(connection);
            SEMAPHORE.release();
        }
    }

    public static synchronized ConnectionPool getInstance() {
        if (instance == null) {
            LOCK.lock();
            try {
                if (instance == null) {
                    try {
                        instance = new ConnectionPoolImpl();
                    } catch (SQLException e) {
                        LOGGER.error("Failed to create connection", e);
                    }
                }
            } finally {
                LOCK.unlock();
            }
        }

        return instance;
    }

    @Override
    public Connection retrieveConnection() throws ConnectionPoolException {
        try {
            SEMAPHORE.acquire();
            LOCK.lock();
            Connection connection = POOL.poll();
            if (!connection.isValid(3)) {
                connection = DriverManager.getConnection(props.getProperty("url"), props);
            }
            InvocationHandler handler =new  Handler(connection);
            Class[] classes = {Connection.class};
            return (Connection) Proxy.newProxyInstance(Connection.class.getClassLoader(), classes, handler);
        } catch (Exception e) {
            LOGGER.error(e);
            throw new ConnectionPoolException("Error while getting connection to DataBase", e);
        } finally {
            LOCK.unlock();
        }
    }

    @Override
    public void putBackConnection(Connection connection) {
        try {
            LOGGER.info("releaseConnection");
            LOCK.lock();
            POOL.add(connection);
        } finally {
            SEMAPHORE.release();
            LOCK.unlock();

        }
    }

    @Override
    public void destroyPool() throws ConnectionPoolException {
        try {
            for (Connection connection : POOL) {
                connection.close();
            }
        } catch (SQLException e) {
            throw new ConnectionPoolException("Failed while close all connections", e);
        }
    }

    private void initDriver() {
        try {
            Class.forName(props.getProperty("driver"));
        } catch (ClassNotFoundException e) {
            LOGGER.error(e);
            throw new IllegalStateException("Driver cannot be found", e);
        }
    }

    private class Handler implements InvocationHandler {
        private Connection connection;

        public Handler(Connection connection){
            this.connection=connection;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            String methodName = method.getName();
            if (methodName.equals("close")) {
                putBackConnection((Connection) proxy);
                return null;
            } else {
                return method.invoke(connection, args);
            }
        }
    }
}
