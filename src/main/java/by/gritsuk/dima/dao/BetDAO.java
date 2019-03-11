package by.gritsuk.dima.dao;

import by.gritsuk.dima.dao.exception.DaoException;
import by.gritsuk.dima.domain.Bet;

import java.util.List;

public interface BetDAO extends GenericDao<Bet,Integer> {

    List<Bet> getByCompetition(Integer competition_id) throws DaoException;
}
