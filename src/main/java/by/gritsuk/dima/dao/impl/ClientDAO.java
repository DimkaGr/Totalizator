package by.gritsuk.dima.dao.impl;

import by.gritsuk.dima.dao.AbstractJdbcDao;
import by.gritsuk.dima.dao.exception.PersistException;
import by.gritsuk.dima.domain.ClientBet;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ClientDAO extends AbstractJdbcDao<ClientBet,Long> {
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
        return "SELECT * FROM  users INNER JOIN client_account ON users.id=client_account.users_id WHERE id=?";
    }

    @Override
    public String getCreateQuery() {
        return "INSERT INTO users (login,password,email,first_name,last_name,role_id) VALUES (?,?,?,?,?,?)";
    }

    @Override
    public String getUpdateQuery() {
        return "UPDATE users SET login=?, password=?, email=?  first_name=? last_name=? role_id=? WHERE id=?";
    }

    @Override
    public String getDeleteQuery() {
        return "DELETE FROM users WHERE id=?";
    }

    @Override
    public String getSelectAllQuery(){
        return "SELECT * FROM users INNER JOIN client_account ON users.id=client_account.users_id";
    }
}
