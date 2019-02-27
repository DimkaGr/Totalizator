package by.gritsuk.dima.service.impl;

import by.gritsuk.dima.dao.AbstractJdbcDao;
import by.gritsuk.dima.dao.ConnectionPool;
import by.gritsuk.dima.dao.ConnectionPoolFactory;
import by.gritsuk.dima.dao.exception.ConnectionPoolException;
import by.gritsuk.dima.dao.exception.DaoException;
import by.gritsuk.dima.dao.exception.PersistException;
import by.gritsuk.dima.dao.impl.SendKeysDAO;
import by.gritsuk.dima.domain.RegistrationKey;
import by.gritsuk.dima.service.RegistrationKeysService;
import by.gritsuk.dima.service.exception.ServiceException;

import java.sql.Connection;

public class RegistrationKeysServiceImpl implements RegistrationKeysService {

    public RegistrationKeysServiceImpl(){}

    @Override
    public void add(RegistrationKey key) throws ServiceException {
        ConnectionPool connectionPool= ConnectionPoolFactory.getInstance().getConnectionPool();;
        Connection connection=null;
        try {
            connection=connectionPool.retrieveConnection();
            AbstractJdbcDao keyDao = new SendKeysDAO();
            keyDao.setConnection(connection);
            keyDao.persist(key);
        } catch (PersistException e) {
            throw new ServiceException("Failed to save registration key. ", e);
        } catch (ConnectionPoolException e){
            throw new ServiceException("Failed to get connection",e);
        }finally {
            connectionPool.putBackConnection(connection);
        }
    }

    @Override
    public RegistrationKey getByUserId(Integer user_id) throws ServiceException {
        ConnectionPool connectionPool= ConnectionPoolFactory.getInstance().getConnectionPool();;
        Connection connection=null;
        try {
            connection=connectionPool.retrieveConnection();
            AbstractJdbcDao keyDao = new SendKeysDAO();
            keyDao.setConnection(connection);
            return (RegistrationKey)keyDao.getByPK(user_id);
        } catch (DaoException e) {
            throw new ServiceException("Failed to find registration key ", e);
        } catch (ConnectionPoolException e){
            throw new ServiceException("Failed to get connection",e);
        }finally {
            connectionPool.putBackConnection(connection);
        }
    }

    @Override
    public void remove(RegistrationKey key) throws ServiceException {
        ConnectionPool connectionPool= ConnectionPoolFactory.getInstance().getConnectionPool();;
        Connection connection=null;
        try {
            connection=connectionPool.retrieveConnection();
            AbstractJdbcDao keyDao = new SendKeysDAO();
            keyDao.setConnection(connection);
            keyDao.delete(key);
        } catch (PersistException e) {
            throw new ServiceException("Failed to delete registration key ", e);
        } catch (ConnectionPoolException e){
            throw new ServiceException("Failed to get connection",e);
        }finally {
            connectionPool.putBackConnection(connection);
        }
    }
}
