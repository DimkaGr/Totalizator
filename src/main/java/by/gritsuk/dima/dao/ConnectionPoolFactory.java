package by.gritsuk.dima.dao;

import by.gritsuk.dima.dao.impl.ConnectionPoolImpl;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Connection Pool Factory
 */
public class ConnectionPoolFactory {
    private static volatile ConnectionPoolFactory instance;
    private static Lock LOCK = new ReentrantLock();

    private ConnectionPoolFactory() {
    }

    public static ConnectionPoolFactory getInstance() {
        if (instance == null) {
            LOCK.lock();
            try {
                if (instance == null) {
                    instance = new ConnectionPoolFactory();
                }
            } finally {
                LOCK.unlock();
            }
        }

        return instance;
    }

    public ConnectionPool getConnectionPool() {
        return ConnectionPoolImpl.getInstance();
    }
}
