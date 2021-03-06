package by.gritsuk.dima.dao.impl;

import by.gritsuk.dima.dao.AbstractJdbcDao;
import by.gritsuk.dima.dao.AutoConnection;
import by.gritsuk.dima.dao.CompetitionDAO;
import by.gritsuk.dima.dao.exception.DaoException;
import by.gritsuk.dima.dao.exception.PersistException;
import by.gritsuk.dima.domain.Competition;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CompetitionDAOImpl extends AbstractJdbcDao<Competition,Integer> implements CompetitionDAO {

    @Override
    protected List<Competition> parseResultSet(ResultSet rs) throws SQLException {
        List<Competition> competitions=new ArrayList<>();
        while(rs.next()){
            Competition competition=new Competition();
            competition.setId(rs.getInt("id"));
            competition.setDate(rs.getString("date"));
            competition.setParticipant1(rs.getString("participant_1"));
            competition.setParticipant2(rs.getString("participant_2"));
            competition.setKindOfSport(rs.getString("name"));
            competition.setResult(rs.getString("result"));
            competition.setCompetitionResultId(rs.getInt("competition_result_id"));
            competition.setKindOfSportId(rs.getInt("kind_of_sport_id"));
            competitions.add(competition);
        }
        return competitions;
    }

    @Override
    protected void prepareStatementForInsert(PreparedStatement statement, Competition object) throws SQLException {
        int i=0;
        statement.setString(++i, object.getDate());
        statement.setString(++i,object.getParticipant1());
        statement.setString(++i,object.getParticipant2());
        statement.setInt(++i,object.getKindOfSportId());
        statement.setInt(++i,object.getCompetitionResultId());
    }

    @Override
    protected void prepareStatementForUpdate(PreparedStatement statement, Competition object) throws SQLException {
        int i=0;
        statement.setString(++i, object.getDate());
        statement.setString(++i,object.getParticipant1());
        statement.setString(++i,object.getParticipant2());
        statement.setInt(++i,object.getKindOfSportId());
        statement.setInt(++i,object.getCompetitionResultId());
        statement.setInt(++i,object.getId());
    }

    @Override
    public String getSelectQuery() {
        return "SELECT * FROM competition INNER JOIN kind_of_sport ON kind_of_sport.id=competition.kind_of_sport_id "+
                "INNER JOIN competition_result ON competition_result.id=competition.competition_result_id WHERE competition.id=?";
    }

    @Override
    public String getCreateQuery() {
        return "INSERT INTO competition (date,participant_1,participant_2,kind_of_sport_id,competition_id) VALUES (?,?,?,?,?)";
    }

    @Override
    public String getUpdateQuery() {
        return "UPDATE competition SET date=?, participant_1=?, participant_2=?  kind_of_sport_id=? competition_id=? WHERE id=?";
    }

    @Override
    public String getDeleteQuery() {
        return "DELETE FROM competition WHERE id=?";
    }

    @Override
    public String getSelectAllQuery() {
        return "SELECT * FROM competition INNER JOIN kind_of_sport ON kind_of_sport.id=competition.kind_of_sport_id "+
                "INNER JOIN competition_result ON competition_result.id=competition.competition_result_id";
    }

    @Override
    @AutoConnection
    public List<Competition> getBySport(Integer kind_of_sport_id) throws DaoException {
        try (PreparedStatement selectStatement = this.connection.prepareStatement(getSelectedBySport())) {
            selectStatement.setInt(1,kind_of_sport_id);
            try (ResultSet resQuery = selectStatement.executeQuery()) {
                return parseResultSet(resQuery);
            }
        } catch (SQLException e) {
            throw new DaoException("Failed while select element by id="+kind_of_sport_id, e);
        }
    }

    private String getSelectedBySport(){
        return "SELECT * FROM competition INNER JOIN kind_of_sport ON kind_of_sport.id=competition.kind_of_sport_id "+
                "INNER JOIN competition_result ON competition_result.id=competition.competition_result_id " +
                "WHERE competition.kind_of_sport_id=?";
    }

    @Override
    @AutoConnection
    public List<Competition> getAllWithoutResult(Integer sportId) throws DaoException {
        try (PreparedStatement selectStatement = this.connection.prepareStatement(getSelectedWithoutResult())) {
            selectStatement.setInt(1,sportId);
            try (ResultSet resQuery = selectStatement.executeQuery()) {
                return parseResultSet(resQuery);
            }
        } catch (SQLException e) {
            throw new DaoException("Failed while select elements", e);
        }
    }

    private String getSelectedWithoutResult(){
        return "SELECT * FROM totalizator.competition " +
                "INNER JOIN totalizator.kind_of_sport ON kind_of_sport.id=competition.kind_of_sport_id " +
                "INNER JOIN totalizator.competition_result ON competition_result.id=competition.competition_result_id " +
                "WHERE competition_result.result='not played' AND kind_of_sport_id=?";
    }

    @Override
    @AutoConnection
    public void updateResult(Integer id, String result) throws PersistException {
        try (PreparedStatement updateStatement = this.connection.prepareStatement(getResultUpdate())) {
            updateStatement.setString(1,result);
            updateStatement.setInt(2,id);
            updateStatement.executeUpdate();
        } catch (SQLException e) {
            throw new PersistException("Failed while update element", e);
        }
    }

    private String getResultUpdate(){
        return "UPDATE competition_result SET result=? WHERE id=?";
    }
}
