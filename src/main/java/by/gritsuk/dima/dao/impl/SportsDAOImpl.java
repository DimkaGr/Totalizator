package by.gritsuk.dima.dao.impl;

import by.gritsuk.dima.dao.AbstractJdbcDao;
import by.gritsuk.dima.dao.SportsDAO;
import by.gritsuk.dima.dao.exception.PersistException;
import by.gritsuk.dima.domain.Sport;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SportsDAOImpl extends AbstractJdbcDao<Sport,Integer> implements SportsDAO {
    @Override
    protected List<Sport> parseResultSet(ResultSet rs) throws PersistException, SQLException {
        List<Sport>sports=new ArrayList<>();
        while(rs.next()){
            Sport sport=new Sport();
            sport.setId(rs.getInt("id"));
            sport.setName(rs.getString("name"));
            sports.add(sport);
        }
        return sports;
    }

    @Override
    protected void prepareStatementForInsert(PreparedStatement statement, Sport object) throws PersistException, SQLException {
        int i=0;
        statement.setString(++i,object.getName());
    }

    @Override
    protected void prepareStatementForUpdate(PreparedStatement statement, Sport object) throws PersistException, SQLException {
        throw new UnsupportedOperationException("Forbidden to change kinds of sports");
    }

    @Override
    public String getSelectQuery() {
        return "SELECT * FROM kind_of_sport WHERE id=?";
    }

    @Override
    public String getCreateQuery() {
        return "INSERT INTO kind_of_sport (name) VALUES (?)";
    }

    @Override
    public String getUpdateQuery() {
        return "UPDATE kind_of_sport SET name=? WHERE id=?";
    }

    @Override
    public String getDeleteQuery() {
        return "DELETE FROM kind_of_sport WHERE id=?";
    }

    @Override
    public String getSelectAllQuery() {
        return "SELECT * FROM kind_of_sport";
    }
}
