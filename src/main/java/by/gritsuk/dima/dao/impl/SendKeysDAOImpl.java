package by.gritsuk.dima.dao.impl;

import by.gritsuk.dima.dao.AbstractJdbcDao;
import by.gritsuk.dima.dao.GenericDao;
import by.gritsuk.dima.dao.exception.PersistException;
import by.gritsuk.dima.domain.RegistrationKey;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SendKeysDAOImpl extends AbstractJdbcDao<RegistrationKey,Integer> implements GenericDao<RegistrationKey,Integer> {
    @Override
    protected List<RegistrationKey> parseResultSet(ResultSet rs) throws PersistException, SQLException {
        List<RegistrationKey>keys=new ArrayList<>();
        while(rs.next()){
            RegistrationKey key=new RegistrationKey();
            key.setId(rs.getInt("user_id"));
            key.setKey(rs.getString("user_key"));
            keys.add(key);
        }
        return keys;
    }

    @Override
    protected void prepareStatementForInsert(PreparedStatement statement, RegistrationKey object) throws PersistException, SQLException {
        int i=0;
        statement.setInt(++i,object.getId());
        statement.setString(++i,object.getKey());
    }

    @Override
    protected void prepareStatementForUpdate(PreparedStatement statement, RegistrationKey object) throws PersistException, SQLException {
        int i=0;
        statement.setString(++i,object.getKey());
        statement.setInt(++i,object.getId());
    }

    @Override
    public String getSelectQuery() {
        return "SELECT * FROM registration_keys WHERE user_id=?";
    }

    @Override
    public String getCreateQuery() {
        return "INSERT INTO registration_keys (user_id,user_key) VALUES (?,?)";
    }

    @Override
    public String getUpdateQuery() {
        return "UPDATE registration_keys SET user_key=? WHERE user_id=?";
    }

    @Override
    public String getDeleteQuery() {
        return "DELETE FROM registration_keys WHERE user_id=?";
    }

    @Override
    public String getSelectAllQuery() {
        return "SELECT * FROM registration_keys";
    }
}
