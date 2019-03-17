package by.gritsuk.dima.dao;

import by.gritsuk.dima.dao.exception.DaoException;
import by.gritsuk.dima.dao.exception.PersistException;
import by.gritsuk.dima.domain.User;

import java.util.List;

public interface UserDAO extends GenericDao<User,Integer> {
    List<User> getAllClients() throws DaoException;

    User getByLogin(String login) throws DaoException;

    void updatePassword(String password, Integer id) throws DaoException;

    void updateCash(Integer id,double cash) throws PersistException;
}
