package by.gritsuk.dima.service.impl;

import by.gritsuk.dima.dao.AbstractJdbcDao;
import by.gritsuk.dima.dao.ConnectionPool;
import by.gritsuk.dima.dao.ConnectionPoolFactory;
import by.gritsuk.dima.dao.exception.ConnectionPoolException;
import by.gritsuk.dima.dao.exception.DaoException;
import by.gritsuk.dima.dao.exception.PersistException;
import by.gritsuk.dima.dao.impl.CompetitionDAO;
import by.gritsuk.dima.domain.Competition;
import by.gritsuk.dima.service.CompetitionService;
import by.gritsuk.dima.service.exception.ServiceException;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class CompetitionServiceImpl implements CompetitionService {

    public CompetitionServiceImpl(){}

    @Override
    public void add(Competition competition) throws ServiceException {
        ConnectionPool connectionPool= ConnectionPoolFactory.getInstance().getConnectionPool();;
        Connection connection=null;
        try {
            connection=connectionPool.retrieveConnection();
            AbstractJdbcDao competitionDao = new CompetitionDAO();
            competitionDao.setConnection(connection);
            competitionDao.persist(competition);
        } catch (PersistException e) {
            throw new ServiceException("Failed to save competition. ", e);
        } catch (ConnectionPoolException e){
            throw new ServiceException("Failed to get connection",e);
        }finally {
            connectionPool.putBackConnection(connection);
        }
    }

    @Override
    public List<Competition> getAll() throws ServiceException {
        List<Competition> competitions=new ArrayList<>();
        ConnectionPool connectionPool=ConnectionPoolFactory.getInstance().getConnectionPool();;
        Connection connection=null;
        try {
            connection=connectionPool.retrieveConnection();
            AbstractJdbcDao competitionDao = new CompetitionDAO();
            competitionDao.setConnection(connection);
            competitions=competitionDao.getAll();
        } catch (DaoException e) {
            throw new ServiceException("Failed to get competitions. ", e);
        } catch (ConnectionPoolException e){
            throw new ServiceException("Failed to get connection",e);
        }finally {
            connectionPool.putBackConnection(connection);
        }
        return competitions;
    }

    @Override
    public void remove(Competition competition) throws ServiceException {
        ConnectionPool connectionPool= ConnectionPoolFactory.getInstance().getConnectionPool();;
        Connection connection=null;
        try {
            connection=connectionPool.retrieveConnection();
            AbstractJdbcDao competitionDao = new CompetitionDAO();
            competitionDao.setConnection(connection);
            competitionDao.delete(competition);
        } catch (PersistException e) {
            throw new ServiceException("Failed to delete competition ", e);
        } catch (ConnectionPoolException e){
            throw new ServiceException("Failed to get connection",e);
        }finally {
            connectionPool.putBackConnection(connection);
        }
    }
}
