package by.gritsuk.dima.dao;

import by.gritsuk.dima.dao.exception.ConnectionPoolException;

import java.sql.Connection;

/**
 * Connection Pool
 */
public interface ConnectionPool {

    /**
     * Return connection from CP if exists
     * @return - connection from CP if exists
     * @throws ConnectionPoolException - should be clarify
     */
    Connection retrieveConnection() throws ConnectionPoolException;

    /**
     * Put back connection after using
     * @param connection - connection
     */
    void putBackConnection(Connection connection);

    /**
     * Destroy CP. Method close all connections.
     * @throws ConnectionPoolException should be clarify
     */
}
