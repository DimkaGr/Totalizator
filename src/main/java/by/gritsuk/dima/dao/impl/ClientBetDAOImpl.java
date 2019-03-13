package by.gritsuk.dima.dao.impl;

import by.gritsuk.dima.dao.AbstractJdbcDao;
import by.gritsuk.dima.dao.ClientBetDAO;
import by.gritsuk.dima.dao.GenericDao;
import by.gritsuk.dima.dao.exception.DaoException;
import by.gritsuk.dima.domain.ClientBet;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClientBetDAOImpl extends AbstractJdbcDao<ClientBet,Integer> implements ClientBetDAO {

    @Override
    protected List<ClientBet> parseResultSet(ResultSet rs) throws SQLException {
        List<ClientBet> clientBets=new ArrayList<>();
        while(rs.next()){
            ClientBet bet=new ClientBet();
            bet.setId(rs.getInt("id"));
            bet.setDeposit(rs.getDouble("deposit"));
            bet.setStatus(rs.getString("status"));
            bet.setIncome(rs.getDouble("income"));
            bet.setBet_id(rs.getInt("bet_id"));
            bet.setUser_id(rs.getInt("users_id"));
            clientBets.add(bet);
        }
        return clientBets;
    }

    @Override
    protected void prepareStatementForInsert(PreparedStatement statement, ClientBet object) throws SQLException {
        int i=0;
        statement.setDouble(++i,object.getDeposit());
        statement.setString(++i,object.getStatus());
        statement.setDouble(++i,object.getIncome());
        statement.setInt(++i,object.getBet_id());
        statement.setInt(++i,object.getUser_id());
    }

    @Override
    protected void prepareStatementForUpdate(PreparedStatement statement, ClientBet object) throws SQLException {
        int i=0;
        statement.setDouble(++i,object.getDeposit());
        statement.setString(++i,object.getStatus());
        statement.setDouble(++i,object.getIncome());
        statement.setInt(++i,object.getBet_id());
        statement.setInt(++i,object.getUser_id());
        statement.setInt(++i,object.getId());
    }

    @Override
    public String getSelectQuery() {
        return "SELECT * FROM  client_bet INNER JOIN bet ON bet.id=client_bet.bet_id "+
                "INNER JOIN users ON users.id=client_bet.users_id WHERE client_bet.id=?";
    }

    @Override
    public String getCreateQuery() {
        return "INSERT INTO client_bet (deposit,status,income,bet_id,users_id) VALUES (?,?,?,?,?)";
    }

    @Override
    public String getUpdateQuery() {
        return "UPDATE client_bet SET deposit=?, status=?, income=?  bet_id=? users_id=? WHERE id=?";
    }

    @Override
    public String getDeleteQuery() {
        return "DELETE FROM client_bet WHERE id=?";
    }

    @Override
    public String getSelectAllQuery(){
        return "SELECT * FROM client_bet INNER JOIN bet ON bet.id=client_bet.bet_id "+
                "INNER JOIN users ON users.id=client_bet.users_id";
    }

    @Override
    public List<ClientBet> getByUserId(Integer user_id) throws DaoException {
        try (PreparedStatement selectStatement = this.connection.prepareStatement(getSelectedByUserId())) {
            selectStatement.setInt(1,user_id);
            try (ResultSet resQuery = selectStatement.executeQuery()) {
                return parseResultSet(resQuery);
            }
        } catch (SQLException e) {
            throw new DaoException("Failed while select element by id="+user_id, e);
        }
    }

    private String getSelectedByUserId(){
        return "SELECT * FROM  client_bet INNER JOIN bet ON bet.id=client_bet.bet_id "+
                "INNER JOIN users ON users.id=client_bet.users_id WHERE client_bet.users_id=?";
    }
}
