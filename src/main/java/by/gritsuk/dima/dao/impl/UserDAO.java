package by.gritsuk.dima.dao.impl;

import by.gritsuk.dima.dao.AbstractJdbcDao;
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

public class UserDAO extends AbstractJdbcDao<User, Long> {

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
            users.add(user);
        }
        return users;
    }

    @Override
    protected void prepareStatementForInsert(PreparedStatement statement, User object) throws PersistException {

    }

    @Override
    protected void prepareStatementForUpdate(PreparedStatement statement, User object) throws PersistException {

    }

    @Override
    public String getSelectQuery() {
        return "SELECT * FROM users INNER JOIN role ON role.id=users.role_id WHERE id=?";
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
    public String getSelectAllQuery() {
        return "SELECT * FROM users INNER JOIN role ON role.id=users.role_id";
    }
}
