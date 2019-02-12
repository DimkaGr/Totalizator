package by.gritsuk.dima.dao.impl;

import by.gritsuk.dima.dao.AbstractJdbcDao;
import by.gritsuk.dima.dao.exception.PersistException;
import by.gritsuk.dima.domain.Competition;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CompetitionDAO extends AbstractJdbcDao<Competition,Long> {

    @Override
    protected List<Competition> parseResultSet(ResultSet rs) throws PersistException, SQLException {
        List<Competition> competitions=new ArrayList<>();
        while(rs.next()){
            Competition competition=new Competition();
            competition.setId(rs.getLong("id"));
            LocalDate date=LocalDate.parse(rs.getNString("date"));
            competition.setDate(date);
            competition.setParticipant1(rs.getString("participant_1"));
            competition.setParticipant2(rs.getString("participant_2"));
            competition.setKindOfSport(rs.getString("name"));
            competition.setResult(rs.getString("result"));
            competitions.add(competition);
        }
        return competitions;
    }

    @Override
    protected void prepareStatementForInsert(PreparedStatement statement, Competition object) throws PersistException {

    }

    @Override
    protected void prepareStatementForUpdate(PreparedStatement statement, Competition object) throws PersistException {

    }

    @Override
    public String getSelectQuery() {
        return "SELECT * FROM competition INNER JOIN kind_of_sport ON kind_of_sport.id=competition.kind_of_sport_id"+
                "INNER JOIN competition_result ON competition_result.id=competition.competition_result_id WHERE id=?";
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
        return "SELECT * FROM competition INNER JOIN kind_of_sport ON kind_of_sport.id=competition.kind_of_sport_id"+
                "INNER JOIN competition_result ON competition_result.id=competition.competition_result_id";
    }
}
