package by.gritsuk.dima.dao.impl;

import by.gritsuk.dima.dao.AbstractJdbcDao;
import by.gritsuk.dima.dao.exception.PersistException;
import by.gritsuk.dima.domain.Competition;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Optional;

public class CompetitionDAO extends AbstractJdbcDao<Competition,Long> {

    @Override
    protected List<Competition> parseResultSet(ResultSet rs) throws PersistException {
        return null;
    }

    @Override
    protected void prepareStatementForInsert(PreparedStatement statement, Competition object) throws PersistException {

    }

    @Override
    protected void prepareStatementForUpdate(PreparedStatement statement, Competition object) throws PersistException {

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
