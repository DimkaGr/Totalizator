package by.gritsuk.dima.service;

import by.gritsuk.dima.domain.Client;
import by.gritsuk.dima.domain.User;
import by.gritsuk.dima.service.exception.ServiceException;
import by.gritsuk.dima.service.exception.UserRegisterException;
import by.gritsuk.dima.validation.exception.LoginPersistException;
import by.gritsuk.dima.validation.exception.ValidationException;

import java.sql.SQLException;
import java.util.List;

/**
 * Example of user service
 */
public interface UserService {

    /**
     * Sign up user
     * @param user - User
     * @return - saved user
     * @throws ServiceException should be clarify
     */
    User signUp(User user) throws ServiceException, UserRegisterException, LoginPersistException, SQLException;

    List<User> getAll() throws ServiceException;

    User getUserForLogin(String login, String password)throws ServiceException;

    User getUserForRestoring(String login, String email)throws ServiceException;

    void deleteUser(User user) throws ServiceException;

    List<Client> getAllClients() throws ServiceException;

    User getByLogin(String login) throws ServiceException;

    void changePassword(String password, Integer id, String login) throws ServiceException;

    void updateCash(Integer id,double cash) throws ServiceException;
}
