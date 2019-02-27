package by.gritsuk.dima.service;

import by.gritsuk.dima.domain.User;
import by.gritsuk.dima.service.exception.ServiceException;
import by.gritsuk.dima.service.exception.UserRegisterException;

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
    User signUp(User user) throws ServiceException, UserRegisterException;

    List<User> getAll() throws ServiceException;

    User getUserForLogin(String login, String password)throws ServiceException;

    User getUserForRestoring(String login, String email)throws ServiceException;
}
