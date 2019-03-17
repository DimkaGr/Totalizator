package by.gritsuk.dima.service.impl;

import by.gritsuk.dima.dao.DaoFactoryType;
import by.gritsuk.dima.dao.FactoryProducer;
import by.gritsuk.dima.dao.SportsDAO;
import by.gritsuk.dima.dao.exception.DaoException;
import by.gritsuk.dima.dao.exception.DaoFactoryException;
import by.gritsuk.dima.domain.Sport;
import by.gritsuk.dima.service.KindOfSportService;
import by.gritsuk.dima.service.exception.ServiceException;

import java.util.ArrayList;
import java.util.List;

public class KindOfSportServiceImpl implements KindOfSportService {

    public KindOfSportServiceImpl(){}

    @Override
    public List<Sport> getAll() throws ServiceException {
        List<Sport> sports;
        try {
            SportsDAO sportDao = (SportsDAO) FactoryProducer.getDaoFactory(DaoFactoryType.JDBC).getDao(Sport.class);
            sports=sportDao.getAll();
            if(sports.isEmpty()){
                sports=null;
            }
        } catch (DaoException e) {
            throw new ServiceException("Failed to get kind of sports. ", e);
        } catch (DaoFactoryException e){
            throw new ServiceException("Failed to connect to database",e);
        }
        return sports;
    }
}
