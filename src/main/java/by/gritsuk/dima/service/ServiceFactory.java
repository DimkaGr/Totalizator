package by.gritsuk.dima.service;

import by.gritsuk.dima.service.exception.ServiceException;;
import by.gritsuk.dima.service.impl.UserServiceImpl;

import java.sql.SQLException;

/**
 * Service factory
 */
public class ServiceFactory {
    private static ServiceFactory instance = new ServiceFactory();

    public static ServiceFactory getInstance() {
        return instance;
    }

    public UserService getUserService() throws SQLException, ServiceException {
        return new UserServiceImpl();
    }
}
