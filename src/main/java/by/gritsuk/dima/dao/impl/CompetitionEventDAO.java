package by.gritsuk.dima.dao.impl;

import by.gritsuk.dima.dao.AbstractJdbcDao;
import by.gritsuk.dima.dao.GenericDao;
import by.gritsuk.dima.domain.Bet;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CompetitionEventDAO extends AbstractJdbcDao<Bet.CompetitionEvent,Long>
        implements GenericDao<Bet.CompetitionEvent,Long> {

    @Override
    protected List<Bet.CompetitionEvent> parseResultSet(ResultSet rs) throws SQLException {
        List<Bet.CompetitionEvent> events=new ArrayList<>();
        while(rs.next()){
            Bet.CompetitionEvent event=new Bet.CompetitionEvent();
            event.setId(rs.getLong("id"));
            event.setEvent(rs.getString("event_name"));
            event.setFactor(rs.getDouble("factor"));
            events.add(event);
        }
        return events;
    }

    @Override
    protected void prepareStatementForInsert(PreparedStatement statement, Bet.CompetitionEvent object) throws SQLException {
        int i=0;
        statement.setString(++i,object.getEvent());
        statement.setDouble(++i,object.getFactor());
    }

    @Override
    protected void prepareStatementForUpdate(PreparedStatement statement, Bet.CompetitionEvent object) throws SQLException {
        int i=0;
        statement.setString(++i,object.getEvent());
        statement.setDouble(++i,object.getFactor());
        statement.setLong(++i,object.getId());
    }

    @Override
    public String getSelectQuery() {
        return "SELECT * FROM competition_events WHERE id=?";
    }

    @Override
    public String getCreateQuery() {
        return "INSERT INTO competition_events (event_name,factor) VALUES (?,?)";
    }

    @Override
    public String getUpdateQuery() {
        return "UPDATE competition_events SET event_name=?, factor=? WHERE id=?";
    }

    @Override
    public String getDeleteQuery() {
        return "DELETE FROM competition_events WHERE id=?";
    }

    @Override
    public String getSelectAllQuery() {
        return "SELECT * FROM competition_events";
    }
}
