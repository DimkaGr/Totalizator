package by.gritsuk.dima.dao.impl;

import by.gritsuk.dima.dao.AbstractJdbcDao;
import by.gritsuk.dima.dao.GenericDao;
import by.gritsuk.dima.dao.exception.PersistException;
import by.gritsuk.dima.domain.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

/**
 * Example User DAO implementation
 */
public class UserDaoImpl extends AbstractJdbcDao<User, Long> implements GenericDao<User, Long> {

    @Override
    protected List<User> parseResultSet(ResultSet rs) throws PersistException {

        //provide your code here

        throw new UnsupportedOperationException();
    }

    @Override
    protected void prepareStatementForInsert(PreparedStatement statement, User object) throws PersistException {

        //provide your code here

        throw new UnsupportedOperationException();
    }

    @Override
    protected void prepareStatementForUpdate(PreparedStatement statement, User object) throws PersistException {

        //provide your code here

        throw new UnsupportedOperationException();
    }

    @Override
    public String getSelectQuery() {

        //provide your code here

        throw new UnsupportedOperationException();
    }

    @Override
    public String getCreateQuery() {

        //provide your code here

        throw new UnsupportedOperationException();
    }

    @Override
    public String getUpdateQuery() {

        //provide your code here

        throw new UnsupportedOperationException();
    }

    @Override
    public String getDeleteQuery() {

        //provide your code here

        throw new UnsupportedOperationException();
    }

    @Override
    public String getSelectAllQuery() {

        //provide your ode here

        throw new UnsupportedOperationException();
    }
}
