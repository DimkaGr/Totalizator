package by.gritsuk.dima.dao.impl;

import by.gritsuk.dima.dao.AbstractJdbcDao;
import by.gritsuk.dima.dao.AutoConnection;
import by.gritsuk.dima.dao.BetDAO;
import by.gritsuk.dima.dao.exception.DaoException;
import by.gritsuk.dima.domain.Bet;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BetDAOImpl extends AbstractJdbcDao<Bet,Integer> implements BetDAO {

    @Override
    protected List<Bet> parseResultSet(ResultSet rs) throws SQLException {
        List<Bet>bets=new ArrayList<>();
        while(rs.next()){
            Bet bet=new Bet();
            bet.setId(rs.getInt("id"));
            bet.setMinValue(rs.getDouble("min_value"));
            Bet.CompetitionEvent event=new Bet.CompetitionEvent();
            event.setId(rs.getInt("id"));
            event.setEvent(rs.getString("event_name"));
            event.setFactor(rs.getDouble("factor"));
            bet.setEvent(event);
            bet.setCompetitionId(rs.getInt("competition_id"));
            bets.add(bet);
        }
        return bets;
    }

    @Override
    protected void prepareStatementForInsert(PreparedStatement statement, Bet object) throws SQLException {
        int i=0;
        statement.setDouble(++i,object.getMinValue());
        statement.setInt(++i,object.getCompetitionId());
        statement.setInt(++i,object.getEvent().getId());
    }

    @Override
    protected void prepareStatementForUpdate(PreparedStatement statement, Bet object) throws SQLException {
        int i=0;
        statement.setDouble(++i,object.getMinValue());
        statement.setInt(++i,object.getCompetitionId());
        statement.setInt(++i,object.getEvent().getId());
        statement.setInt(++i,object.getId());
    }

    @Override
    public String getSelectQuery() {
        return "SELECT * FROM bet INNER JOIN competition_events ON bet.competition_events_id=competition_events.id "+
                "INNER JOIN competition ON competition.id=bet.competition_id WHERE bet.id=?";
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
        return "SELECT * FROM bet INNER JOIN competition_events ON bet.competition_events_id=competition_events.id "+
                "INNER JOIN competition ON competition.id=bet.competition_id";
    }

    @Override
    @AutoConnection
    public List<Bet> getByCompetition(Integer competition_id) throws DaoException {
        try (PreparedStatement selectStatement = this.connection.prepareStatement(getSelectedByCompetition())) {
            selectStatement.setInt(1,competition_id);
            try (ResultSet resQuery = selectStatement.executeQuery()) {
                return parseResultSet(resQuery);
            }
        } catch (SQLException e) {
            throw new DaoException("Failed while select element by id="+competition_id, e);
        }
    }

    private String getSelectedByCompetition(){
        return "SELECT * FROM bet INNER JOIN competition_events ON bet.competition_events_id=competition_events.id "+
                "INNER JOIN competition ON competition.id=bet.competition_id WHERE bet.competition_id=?";
    }
}
