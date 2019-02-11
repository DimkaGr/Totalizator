package by.gritsuk.dima.dao.impl;

import by.gritsuk.dima.dao.AbstractJdbcDao;
import by.gritsuk.dima.dao.exception.PersistException;
import by.gritsuk.dima.domain.ClientBet;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Optional;

public class ClientBetDAO extends AbstractJdbcDao<ClientBet,Long> {

    @Override
    protected List<ClientBet> parseResultSet(ResultSet rs) throws PersistException {
        return null;
    }

    @Override
    protected void prepareStatementForInsert(PreparedStatement statement, ClientBet object) throws PersistException {

    }

    @Override
    protected void prepareStatementForUpdate(PreparedStatement statement, ClientBet object) throws PersistException {

    }

    @Override
    public String getSelectQuery() {
        return null;
    }

    @Override
    public String getCreateQuery() {
        return null;
    }

    @Override
    public String getUpdateQuery() {
        return null;
    }

    @Override
    public String getDeleteQuery() {
        return null;
    }
}
