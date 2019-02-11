package by.gritsuk.dima.dao.impl;

import by.gritsuk.dima.dao.AbstractJdbcDao;
import by.gritsuk.dima.dao.Identified;
import by.gritsuk.dima.dao.exception.DaoException;
import by.gritsuk.dima.dao.exception.PersistException;
import by.gritsuk.dima.domain.Bet;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class BetDAO extends AbstractJdbcDao<Bet,Long> {

    @Override
    protected List<Bet> parseResultSet(ResultSet rs) throws PersistException {
        return null;
    }

    @Override
    protected void prepareStatementForInsert(PreparedStatement statement, Bet object) throws PersistException, SQLException {
        int i=0;
        statement.setDouble(++i,object.getMinValue());
        statement.setLong(++i,object.getCompetition_id());
        statement.setLong(++i,object.getEvent().getId());
        statement.setLong(++i,object.getCompetition_id());
        statement.executeUpdate();
    }

    @Override
    protected void prepareStatementForUpdate(PreparedStatement statement, Bet object) throws PersistException, SQLException {
        int i=0;
        statement.setDouble(++i,object.getMinValue());
        statement.setLong(++i,object.getCompetition_id());
        statement.setLong(++i,object.getEvent().getId());
        statement.setLong(++i,object.getCompetition_id());
        statement.executeUpdate();
    }

    @Override
    public String getSelectQuery() {
        return "SELECT * FROM bet WHERE id=?";
    }

    @Override
    public String getCreateQuery() {
        return "INSERT INTO bet (min_value,competition_id,competition_events_id) VALUES (?,?,?)";
    }

    @Override
    public String getUpdateQuery() {
        return "UPDATE bet SET min_value=?, competition_id=?, competition_event_id=? WHERE id=?";
    }

    @Override
    public String getDeleteQuery() {
        return "DELETE FROM bet WHERE id=?";
    }
}
