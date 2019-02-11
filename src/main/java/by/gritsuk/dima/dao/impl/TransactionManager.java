package by.gritsuk.dima.dao.impl;

import by.gritsuk.dima.dao.GenericDao;

import java.sql.Connection;

/**
 * Implementation of transaction with DAO
 */
public final class TransactionManager {
    private Connection connection;

    public void begin(GenericDao dao, GenericDao ... daos) {

        //provide your code here

        throw new UnsupportedOperationException();
    }

    public void end() {

        //provide your code here

        throw new UnsupportedOperationException();
    }

    public void commit() {

        //provide your code here

        throw new UnsupportedOperationException();
    }

    public void rollback() {

        //provide your code here

        throw new UnsupportedOperationException();
    }

}
