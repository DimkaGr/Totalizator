package by.gritsuk.dima.service;

import by.gritsuk.dima.domain.User;
import by.gritsuk.dima.service.exception.ServiceException;

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
    User signUp(User user) throws ServiceException;

    // Provide your code here

}
