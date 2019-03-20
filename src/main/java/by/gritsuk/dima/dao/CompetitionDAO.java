package by.gritsuk.dima.dao;

import by.gritsuk.dima.dao.exception.DaoException;
import by.gritsuk.dima.dao.exception.PersistException;
import by.gritsuk.dima.domain.Competition;

import java.util.List;

public interface CompetitionDAO extends GenericDao<Competition,Integer>{
    List<Competition> getBySport(Integer kind_of_sport_id) throws DaoException;

    List<Competition> getAllWithoutResult(Integer sportId) throws DaoException;

    void updateResult(Integer id,String result) throws PersistException;
}
