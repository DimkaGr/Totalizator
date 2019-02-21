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
import java.util.Queue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Implementation of Connection Pool
 */
public class ConnectionPoolImpl implements ConnectionPool {
    private static final Logger LOGGER = LogManager.getLogger(ConnectionPoolImpl.class);
    private static volatile ConnectionPool instance;
    private static final Lock LOCK = new ReentrantLock();
    private final String DRIVER = "com.mysql.jdbc.Driver";
    private final String URL = "jdbc:mysql://207.154.220.222:3306/totalizator";
    private final String USER = "dmitry_gritsuk";
    private final String PASSWORD = "x8ejD39Ndk32";
//    private final String DRIVER = "org.hsqldb.jdbcDriver";
//    private final String URL = "jdbc:hsqldb:mem:testdb;DB_CLOSE_DELAY=-1";
//    private final String USER = "SA";
//    private final String PASSWORD = null;
    private final int POOL_CAPACITY = 20;
    private final Semaphore SEMAPHORE;
    private final Queue<Connection> POOL;
    private int createdConnections = 0;

    private ConnectionPoolImpl() {
        POOL = new ArrayDeque<>(POOL_CAPACITY);
        SEMAPHORE = new Semaphore(POOL_CAPACITY);
        initDriver();
    }

    public static synchronized ConnectionPool getInstance() {
        if (instance == null) {
            LOCK.lock();
            try {
                if (instance == null) {
                    instance = new ConnectionPoolImpl();
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
            if (createdConnections < POOL_CAPACITY) {
                createdConnections++;
                InvocationHandler handler = this.getHandler();
                Class[] classes = {Connection.class};
                return (Connection) Proxy.newProxyInstance(null, classes, handler);
            }
            return POOL.poll();
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

    private void initDriver() {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            LOGGER.error(e);
            throw new IllegalStateException("Driver cannot be found", e);
        }
    }

    private InvocationHandler getHandler() throws SQLException {
        final ConnectionPoolImpl connectionPool = this;
        return new InvocationHandler() {
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                String methodName = method.getName();
                final ConnectionPoolImpl connectPool = connectionPool;
                if (methodName.equals("close")) {
                    connectPool.putBackConnection((Connection) proxy);
                    return null;
                } else {
                    return method.invoke(connection, args);
                }
            }
        };
    }
}
