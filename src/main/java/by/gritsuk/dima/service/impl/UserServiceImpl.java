package by.gritsuk.dima.service.impl;

import by.gritsuk.dima.dao.DaoFactory;
import by.gritsuk.dima.dao.DaoFactoryType;
import by.gritsuk.dima.dao.FactoryProducer;
import by.gritsuk.dima.dao.GenericDao;
import by.gritsuk.dima.dao.exception.DaoException;
import by.gritsuk.dima.dao.exception.DaoFactoryException;
import by.gritsuk.dima.dao.exception.PersistException;
import by.gritsuk.dima.domain.User;
import by.gritsuk.dima.service.UserService;
import by.gritsuk.dima.service.exception.ServiceException;

/**
 * Example of user service implementation
 */
public class UserServiceImpl implements UserService {
    @Override
    public User signUp(User user) throws ServiceException {
        DaoFactory daoFactory=null;
        try {
            daoFactory = FactoryProducer.getDaoFactory(DaoFactoryType.JDBC);
        } catch (DaoFactoryException e) {

        }
        //provide your code here

        try {
            GenericDao<User, Long> userDao = daoFactory.getDao(User.class);
            userDao.persist(user);

        } catch (DaoException e) {
            throw new ServiceException("Failed to get user DAO. ", e);

        } catch (PersistException e) {
            throw new ServiceException("Failed to save user. ", e);
        }

        //provide your code here

        throw new UnsupportedOperationException();
    }
}
