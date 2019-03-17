package by.gritsuk.dima.dao.impl;

import by.gritsuk.dima.dao.AbstractJdbcDao;
import by.gritsuk.dima.dao.AutoConnection;
import by.gritsuk.dima.dao.UserDAO;
import by.gritsuk.dima.dao.exception.DaoException;
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

public class UserDAOImpl extends AbstractJdbcDao<User, Integer> implements UserDAO {

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
                case "user":
                    user=new Client();
                    ((Client) user).setCash(rs.getDouble("user_cash"));
                    ((Client) user).setStatus(rs.getString("status"));
                    break;
                default:throw new PersistException("There is no such user's type");
            }
            user.setId(rs.getInt("id"));
            user.setRole_id(rs.getInt("role_id"));
            user.setLogin(rs.getString("login"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setFirstName(rs.getString("first_name"));
            user.setLastName(rs.getString("last_name"));
            user.setClient_account_id(rs.getInt("client_account_id"));
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
        statement.setInt(++i,object.getRole_id());
        statement.setInt(++i,object.getClient_account_id());
    }

    @Override
    protected void prepareStatementForUpdate(PreparedStatement statement, User object) throws SQLException {
        int i=0;
        statement.setString(++i,object.getLogin());
        statement.setString(++i,object.getPassword());
        statement.setString(++i,object.getEmail());
        statement.setString(++i,object.getFirstName());
        statement.setString(++i,object.getLastName());
        statement.setInt(++i,object.getRole_id());
        statement.setInt(++i,object.getClient_account_id());
        statement.setInt(++i,object.getId());
    }

    @Override
    public String getSelectQuery() {
        return "SELECT * FROM users INNER JOIN role ON role.id=users.role_id " +
                "LEFT JOIN client_account ON users.client_account_id=client_account.id WHERE users.id=?";
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

    @Override
    @AutoConnection
    public List<User> getAllClients() throws DaoException {
        try (PreparedStatement selectStatement = this.connection.prepareStatement(getSelectedClientQuery())) {
            try (ResultSet resQuery = selectStatement.executeQuery()) {
                return parseResultSet(resQuery);
            }
        } catch (PersistException | SQLException e) {
            throw new DaoException("Failed while select elements", e);
        }
    }

    private String getSelectedClientQuery(){
        return "SELECT * FROM users INNER JOIN role ON role.id=users.role_id " +
                "LEFT JOIN client_account ON users.client_account_id=client_account.id " +
                "WHERE users.client_account_id>-1";
    }

    @Override
    @AutoConnection
    public User getByLogin(String login) throws DaoException {
        try (PreparedStatement selectStatement = this.connection.prepareStatement(getSelectedByLogin())) {
            selectStatement.setString(1,login);
            try (ResultSet resQuery = selectStatement.executeQuery()) {
                List<User>users=parseResultSet(resQuery);
                if(users.isEmpty()){
                    return null;
                }else {
                    return parseResultSet(resQuery).get(0);
                }
            }
        } catch (PersistException | SQLException e) {
            throw new DaoException("Failed while select element by login="+login, e);
        }
    }

    private String getSelectedByLogin(){
        return "SELECT * FROM users INNER JOIN role ON role.id=users.role_id " +
                "LEFT JOIN client_account ON users.client_account_id=client_account.id " +
                "WHERE users.login=?";
    }

    @Override
    @AutoConnection
    public void updatePassword(String password,Integer id) throws DaoException {
        try (PreparedStatement updateStatement = this.connection.prepareStatement(getUpdatePassword())) {
            updateStatement.setString(1,password);
            updateStatement.setInt(2,id);
            updateStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException("Failed while update element", e);
        }
    }

    private String getUpdatePassword(){
        return "UPDATE users SET password=? WHERE id=?";
    }

    @Override
    public void updateCash(Integer id, double cash) throws PersistException {
        try (PreparedStatement updateStatement = this.connection.prepareStatement(getUpdateCash())) {
            updateStatement.setDouble(1,cash);
            updateStatement.setInt(2,id);
            updateStatement.executeUpdate();
        } catch (SQLException e) {
            throw new PersistException("Failed while update element", e);
        }
    }
    private String getUpdateCash(){
        return "UPDATE client_account SET user_cash=? WHERE id=?";
    }
}
