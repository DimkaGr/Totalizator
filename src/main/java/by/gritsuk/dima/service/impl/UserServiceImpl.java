package by.gritsuk.dima.service.impl;

import by.gritsuk.dima.dao.*;
import by.gritsuk.dima.dao.exception.DaoException;
import by.gritsuk.dima.dao.exception.DaoFactoryException;
import by.gritsuk.dima.dao.exception.PersistException;
import by.gritsuk.dima.dao.impl.JdbcDaoFactory;
import by.gritsuk.dima.dao.impl.TransactionManager;
import by.gritsuk.dima.domain.User;
import by.gritsuk.dima.service.UserService;
import by.gritsuk.dima.service.exception.ServiceException;
import by.gritsuk.dima.service.exception.UserRegisterException;
import by.gritsuk.dima.util.PasswordEncryptor;
import by.gritsuk.dima.validation.UserValidation;
import by.gritsuk.dima.validation.exception.LoginPersistException;
import by.gritsuk.dima.validation.exception.ValidationException;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Example of user service implementation
 */
public class UserServiceImpl implements UserService {

    public UserServiceImpl(){}

    @Override
    public User signUp(User user) throws ServiceException, UserRegisterException, LoginPersistException, SQLException {
        TransactionManager manager=new TransactionManager();
        try {
            UserDAO userDao = (UserDAO)((JdbcDaoFactory)FactoryProducer.getDaoFactory(DaoFactoryType.JDBC)).getTransactionalDao(User.class);
            if(UserValidation.validate(user)&&UserValidation.isReservedLogin(user.getLogin())) {
                String password= PasswordEncryptor.encrypt(user.getPassword()+user.getLogin());
                user.setPassword(password);
                manager.begin(userDao);
                Integer clientAccountId=userDao.setClientAccount();
                if(clientAccountId==null){
                    manager.rollback();
                    throw new UserRegisterException("Invalid data to registrate this user");
                }
                user.setClientAccountId(clientAccountId);
                userDao.persist(user);
                manager.commit();
            }else{
                throw new UserRegisterException("Invalid data to registrate this user");
            }
        } catch (PersistException| SQLException e) {
            manager.rollback();
            throw new ServiceException("Failed to save user. ", e);
        } catch (DaoFactoryException|DaoException e){
            throw new ServiceException("Failed to connect to database",e);
        }catch (ValidationException e){
            throw new ServiceException("Failed while validate user data",e);
        }finally {
            manager.end();
        }
        return user;
    }

    public List<User> getAll()throws ServiceException{
        List<User> users=new ArrayList<>();
        try {
            UserDAO userDao = (UserDAO)FactoryProducer.getDaoFactory(DaoFactoryType.JDBC).getDao(User.class);
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
        User user = getByLogin(login);
        if(user!=null) {
            String encryptPassword = PasswordEncryptor.encrypt(password + login);
            if (user.getLogin().equals(login) && user.getPassword().equals(encryptPassword)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public User getUserForRestoring(String login,String email) throws ServiceException{
        User user = getByLogin(login);
        if(user!=null) {
            if (user.getLogin().equals(login) && user.getEmail().equals(email)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public void deleteUser(User user) throws ServiceException {
        try {
            UserDAO userDao=(UserDAO)FactoryProducer.getDaoFactory(DaoFactoryType.JDBC).getDao(User.class);
            userDao.delete(user);
        } catch (PersistException e) {
            throw new ServiceException("Failed to delete users. ", e);
        } catch (DaoFactoryException|DaoException e) {
            throw new ServiceException("Failed to connect to database",e);
        }
    }

    @Override
    public List<User> getAllClients() throws ServiceException {
        List<User> users=new ArrayList<>();
        try {
            UserDAO userDao = (UserDAO)FactoryProducer.getDaoFactory(DaoFactoryType.JDBC).getDao(User.class);
            users=userDao.getAllClients();
        } catch (DaoException e) {
            throw new ServiceException("Failed to get users. ", e);
        } catch (DaoFactoryException e){
            throw new ServiceException("Failed to connect to database",e);
        }
        return users;
    }

    @Override
    public User getByLogin(String login) throws ServiceException {
        try {
            UserDAO userDAO=(UserDAO)FactoryProducer.getDaoFactory(DaoFactoryType.JDBC).getDao(User.class);
            return userDAO.getByLogin(login);
        } catch (DaoException e) {
            throw new ServiceException("Failed to get user. ", e);
        } catch (DaoFactoryException e) {
            throw new ServiceException("Failed to connect to database",e);
        }
    }

    @Override
    public void changePassword(String password, Integer id, String login) throws ServiceException {
        try {
            UserDAO userDAO=(UserDAO)FactoryProducer.getDaoFactory(DaoFactoryType.JDBC).getDao(User.class);
            String encryptPassword= PasswordEncryptor.encrypt(password+login);
            userDAO.updatePassword(encryptPassword,id);
        } catch (DaoException e) {
            throw new ServiceException("Failed to update user password. ", e);
        } catch (DaoFactoryException e) {
            throw new ServiceException("Failed to connect to database",e);
        }
    }

    @Override
    public void updateCash(Integer id,double cash) throws ServiceException {
        try {
            UserDAO userDAO=(UserDAO)FactoryProducer.getDaoFactory(DaoFactoryType.JDBC).getDao(User.class);
            userDAO.updateCash(id,cash);
        } catch (PersistException e) {
            throw new ServiceException("Failed to update user cash. ", e);
        } catch (DaoException|DaoFactoryException e) {
            throw new ServiceException("Failed to connect to database",e);
        }
    }
}
