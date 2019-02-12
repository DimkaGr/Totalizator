package by.gritsuk.dima.dao.impl;

import by.gritsuk.dima.dao.AbstractJdbcDao;
import by.gritsuk.dima.dao.Identified;
import by.gritsuk.dima.dao.exception.DaoException;
import by.gritsuk.dima.dao.exception.PersistException;
import by.gritsuk.dima.domain.Bet;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BetDAO extends AbstractJdbcDao<Bet,Long> {

    @Override
    protected List<Bet> parseResultSet(ResultSet rs) throws PersistException,SQLException {
        List<Bet>bets=new ArrayList<>();
        while(rs.next()){
            Bet bet=new Bet();
            bet.setId(rs.getLong("id"));
            bet.setMinValue(rs.getDouble("min_value"));
            Bet.CompetitionEvent event=new Bet.CompetitionEvent();
            event.setEvent(rs.getString("event_name"));
            event.setFactor(rs.getDouble("factor"));
            bet.setEvent(event);
            bet.setCompetition_id(rs.getLong("competition_id"));
            bets.add(bet);
        }
        return bets;
    }

    @Override
    protected void prepareStatementForInsert(PreparedStatement statement, Bet object) throws PersistException, SQLException {
        int i=0;
        statement.setDouble(++i,object.getMinValue());
        statement.setLong(++i,object.getCompetition_id());
        statement.setLong(++i,object.getEvent().getId());
        statement.setLong(++i,object.getCompetition_id());
    }

    @Override
    protected void prepareStatementForUpdate(PreparedStatement statement, Bet object) throws PersistException, SQLException {
        int i=0;
        statement.setDouble(++i,object.getMinValue());
        statement.setLong(++i,object.getCompetition_id());
        statement.setLong(++i,object.getEvent().getId());
        statement.setLong(++i,object.getCompetition_id());
    }

    @Override
    public String getSelectQuery() {
        return "SELECT * FROM bet INNER JOIN competition_events ON bet.competition_events_id=competition_events.id"+
                "INNER JOIN competition ON competition.id=bet.competition_id WHERE id=?";
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

    @Override
    public String getSelectAllQuery(){
        return "SELECT * FROM bet INNER JOIN competition_events ON bet.competition_events_id=competition_events.id"+
                "INNER JOIN competition ON competition.id=bet.competition_id";
    }
}
