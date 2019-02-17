package by.gritsuk.dima.dao.impl;

import by.gritsuk.dima.dao.AbstractJdbcDao;
import by.gritsuk.dima.dao.ConnectionPool;
import by.gritsuk.dima.dao.ConnectionPoolFactory;
import by.gritsuk.dima.dao.GenericDao;
import by.gritsuk.dima.dao.exception.ConnectionPoolException;
import by.gritsuk.dima.dao.exception.DaoException;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Implementation of transaction with DAO
 */
public final class TransactionManager {
    private Connection proxyConnection;

    public void begin(GenericDao dao, GenericDao... daos) throws DaoException{
        try {
            ConnectionPool connectionPool = ConnectionPoolFactory.getInstance().getConnectionPool();
            proxyConnection = connectionPool.retrieveConnection();
            setConnectionWithReflection(dao, proxyConnection);
            for (GenericDao d : daos) {
                setConnectionWithReflection(d, proxyConnection);
            }
        } catch (ConnectionPoolException e) {
            throw new DaoException("Failed to get a connection from CP.", e);
        }
    }

    public void end() throws SQLException{
        proxyConnection.setAutoCommit(true);
        proxyConnection.close();
    }

    public void commit() throws SQLException{
        proxyConnection.commit();
    }

    public void rollback() throws SQLException {
        proxyConnection.rollback();
    }

    static void setConnectionWithReflection(Object dao, Connection connection) throws DaoException {
        if (!(dao instanceof AbstractJdbcDao)) {
            throw new DaoException("DAO implementation does not extend AbstractJdbcDao.");
        }

        try {
            Field connectionField = AbstractJdbcDao.class.getDeclaredField("connection");
            if (!connectionField.isAccessible()) {
                connectionField.setAccessible(true);
            }
            connectionField.set(dao, connection);

        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new DaoException("Failed to set connection for transactional DAO. ", e);
        }
    }
}
