package by.gritsuk.dima.dao.impl;

import by.gritsuk.dima.dao.AbstractJdbcDao;
import by.gritsuk.dima.dao.GenericDao;
import by.gritsuk.dima.dao.exception.PersistException;
import by.gritsuk.dima.domain.Admin;
import by.gritsuk.dima.domain.Bookmaker;
import by.gritsuk.dima.domain.Client;
import by.gritsuk.dima.domain.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO extends AbstractJdbcDao<User, Long> implements GenericDao<User,Long> {

    @Override
    protected List<User> parseResultSet(ResultSet rs) throws PersistException, SQLException {
        List<User> users = new ArrayList<>();
        User user;
        while (rs.next()) {
            String role=rs.getString("name");
            switch (role) {
                case "admin":
                    user = new Admin();
                    break;
                case "bookmaker":
                    user=new Bookmaker();
                    break;
                case "client":
                    user=new Client();
                    ((Client) user).setCash(rs.getDouble("user_cash"));
                    ((Client) user).setStatus(rs.getString("status"));
                    break;
                default:throw new PersistException("There is no such user's type");
            }
            user.setId(rs.getLong("id"));
            user.setRole_id(rs.getLong("role_id"));
            user.setLogin(rs.getString("login"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setFirstName(rs.getString("first_name"));
            user.setLastName(rs.getString("last_name"));
            user.setClient_account_id(rs.getLong("client_account_id"));
            users.add(user);
        }
        return users;
    }

    @Override
    protected void prepareStatementForInsert(PreparedStatement statement, User object) throws SQLException {
        int i=0;
        statement.setString(++i,object.getLogin());
        statement.setString(++i,object.getPassword());
        statement.setString(++i,object.getEmail());
        statement.setString(++i,object.getFirstName());
        statement.setString(++i,object.getLastName());
        statement.setLong(++i,object.getRole_id());
        statement.setLong(++i,object.getClient_account_id());
    }

    @Override
    protected void prepareStatementForUpdate(PreparedStatement statement, User object) throws SQLException {
        int i=0;
        statement.setString(++i,object.getLogin());
        statement.setString(++i,object.getPassword());
        statement.setString(++i,object.getEmail());
        statement.setString(++i,object.getFirstName());
        statement.setString(++i,object.getLastName());
        statement.setLong(++i,object.getRole_id());
        statement.setLong(++i,object.getClient_account_id());
        statement.setLong(++i,object.getId());
    }

    @Override
    public String getSelectQuery() {
        return "SELECT * FROM users INNER JOIN role ON role.id=users.role_id " +
                "LEFT JOIN client_account ON users.client_account_id=client_account.id WHERE id=?";
    }

    @Override
    public String getCreateQuery() {
        return "INSERT INTO users (login,password,email,first_name,last_name,role_id,client_account_id) " +
                "VALUES (?,?,?,?,?,?,?)";
    }

    @Override
    public String getUpdateQuery() {
        return "UPDATE users SET login=?, password=?, email=?  first_name=? last_name=? " +
                "role_id=? client_account_id=? WHERE id=?";
    }

    @Override
    public String getDeleteQuery() {
        return "DELETE FROM users WHERE id=?";
    }

    @Override
    public String getSelectAllQuery() {
        return "SELECT * FROM users INNER JOIN role ON role.id=users.role_id " +
                "LEFT JOIN client_account ON users.client_account_id=client_account.id";
    }
}
