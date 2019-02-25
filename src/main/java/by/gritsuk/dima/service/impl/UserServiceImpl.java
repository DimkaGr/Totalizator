package by.gritsuk.dima.service.impl;

import by.gritsuk.dima.dao.*;
import by.gritsuk.dima.dao.exception.ConnectionPoolException;
import by.gritsuk.dima.dao.exception.DaoException;
import by.gritsuk.dima.dao.exception.PersistException;
import by.gritsuk.dima.dao.impl.UserDAO;
import by.gritsuk.dima.domain.User;
import by.gritsuk.dima.service.UserService;
import by.gritsuk.dima.service.exception.ServiceException;
import by.gritsuk.dima.service.exception.UserRegisterException;

import java.sql.Connection;
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
        ConnectionPool connectionPool=ConnectionPoolFactory.getInstance().getConnectionPool();;
        Connection connection=null;
        try {
            connection=connectionPool.retrieveConnection();
            AbstractJdbcDao userDao = new UserDAO();
            userDao.setConnection(connection);
            if(UserValidation.validate(user)) {
                userDao.persist(user);
            }else{
                throw new UserRegisterException("Invalid data to registrate this user");
            }
        } catch (PersistException e) {
            throw new ServiceException("Failed to save user. ", e);
        } catch (ConnectionPoolException e){
            throw new SecurityException("Failed to get connection",e);
        }finally {
            connectionPool.putBackConnection(connection);
        }
        return user;
    }

    public List<User> getAll()throws ServiceException{
        List<User> users=new ArrayList<>();
        ConnectionPool connectionPool=ConnectionPoolFactory.getInstance().getConnectionPool();;
        Connection connection=null;
        try {
            connection=connectionPool.retrieveConnection();
            AbstractJdbcDao userDao = new UserDAO();
            userDao.setConnection(connection);
            users=userDao.getAll();
        } catch (DaoException e) {
            throw new ServiceException("Failed to save user. ", e);
        } catch (ConnectionPoolException e){
            throw new SecurityException("Failed to get connection",e);
        }finally {
            connectionPool.putBackConnection(connection);
        }
        return users;
    }

    @Override
    public User getUser(String login,String password) throws ServiceException {
        List<User> userList = getAll();
        for (User user : userList) {
            if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }
}
