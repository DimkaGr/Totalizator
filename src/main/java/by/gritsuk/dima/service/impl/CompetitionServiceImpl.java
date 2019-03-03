package by.gritsuk.dima.service.impl;

import by.gritsuk.dima.dao.*;
import by.gritsuk.dima.dao.exception.DaoException;
import by.gritsuk.dima.dao.exception.DaoFactoryException;
import by.gritsuk.dima.dao.exception.PersistException;
import by.gritsuk.dima.domain.Competition;
import by.gritsuk.dima.service.CompetitionService;
import by.gritsuk.dima.service.exception.ServiceException;

import java.util.ArrayList;
import java.util.List;

public class CompetitionServiceImpl implements CompetitionService {

    public CompetitionServiceImpl(){}

    @Override
    public void add(Competition competition) throws ServiceException {
        try {
            GenericDao<Competition,Integer>competitionDao= FactoryProducer.getDaoFactory(DaoFactoryType.JDBC).getDao(Competition.class);
            competitionDao.persist(competition);
        } catch (PersistException e) {
            throw new ServiceException("Failed to save competition. ", e);
        } catch (DaoFactoryException|DaoException e){
            throw new ServiceException("Failed to connect to database",e);
        }
    }

    @Override
    public List<Competition> getAll() throws ServiceException {
        List<Competition> competitions=new ArrayList<>();
        try {
            GenericDao<Competition,Integer>competitionDao= FactoryProducer.getDaoFactory(DaoFactoryType.JDBC).getDao(Competition.class);
            competitions=competitionDao.getAll();
        } catch (DaoException e) {
            throw new ServiceException("Failed to get competitions. ", e);
        } catch (DaoFactoryException e){
            throw new ServiceException("Failed to connect to database",e);
        }
        return competitions;
    }

    @Override
    public void remove(Competition competition) throws ServiceException {
        try {
            GenericDao<Competition,Integer>competitionDao= FactoryProducer.getDaoFactory(DaoFactoryType.JDBC).getDao(Competition.class);
            competitionDao.delete(competition);
        } catch (PersistException e) {
            throw new ServiceException("Failed to delete competition ", e);
        } catch (DaoFactoryException|DaoException e){
            throw new ServiceException("Failed to connect to database",e);
        }
    }
}
