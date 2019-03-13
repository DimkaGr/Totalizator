package by.gritsuk.dima.dao;

import by.gritsuk.dima.dao.exception.DaoException;
import by.gritsuk.dima.domain.ClientBet;

import java.util.List;

public interface ClientBetDAO extends GenericDao<ClientBet,Integer> {
    List<ClientBet> getByUserId(Integer user_id) throws DaoException;

}
