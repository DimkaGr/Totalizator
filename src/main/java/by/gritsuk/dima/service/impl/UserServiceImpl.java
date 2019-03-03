package by.gritsuk.dima.service.impl;

import by.gritsuk.dima.dao.*;
import by.gritsuk.dima.dao.exception.DaoException;
import by.gritsuk.dima.dao.exception.DaoFactoryException;
import by.gritsuk.dima.dao.exception.PersistException;
import by.gritsuk.dima.domain.User;
import by.gritsuk.dima.service.UserService;
import by.gritsuk.dima.service.exception.ServiceException;
import by.gritsuk.dima.service.exception.UserRegisterException;
import by.gritsuk.dima.validation.UserValidation;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Example of user service implementation
 */
public class UserServiceImpl implements UserService {
    private static UserServiceImpl instance;
    private static final Lock LOCK=new ReentrantLock();

    public UserServiceImpl(){}

//    public static UserServiceImpl getInstance(){
//            LOCK.lock();
//            try {
//                if (instance == null) {
//                    instance = new UserServiceImpl();
//                }
//            } finally {
//                LOCK.unlock();
//            }
//            return instance;
//    }

    @Override
    public User signUp(User user) throws ServiceException,UserRegisterException {
        try {
            GenericDao<User,Integer> userDao = FactoryProducer.getDaoFactory(DaoFactoryType.JDBC).getDao(User.class);
            if(UserValidation.validate(user)) {
                userDao.persist(user);
            }else{
                throw new UserRegisterException("Invalid data to registrate this user");
            }
        } catch (PersistException e) {
            throw new ServiceException("Failed to save user. ", e);
        } catch (DaoFactoryException|DaoException e){
            throw new ServiceException("Failed to connect to database",e);
        }
        return user;
    }

    public List<User> getAll()throws ServiceException{
        List<User> users=new ArrayList<>();
        try {
            GenericDao<User,Integer> userDao = FactoryProducer.getDaoFactory(DaoFactoryType.JDBC).getDao(User.class);
            users=userDao.getAll();
        } catch (DaoException e) {
            throw new ServiceException("Failed to get users. ", e);
        } catch (DaoFactoryException e){
            throw new ServiceException("Failed to connect to database",e);
        }
        return users;
    }

    @Override
    public User getUserForLogin(String login,String password) throws ServiceException {
        List<User> userList = getAll();
        for (User user : userList) {
            if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public User getUserForRestoring(String login,String email) throws ServiceException{
        List<User> userList = getAll();
        for (User user : userList) {
            if (user.getLogin().equals(login) && user.getEmail().equals(email)) {
                return user;
            }
        }
        return null;
    }
}
