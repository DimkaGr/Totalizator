package by.gritsuk.dima.service.impl;

import by.gritsuk.dima.dao.CompetitionEventDAO;
import by.gritsuk.dima.dao.DaoFactoryType;
import by.gritsuk.dima.dao.FactoryProducer;
import by.gritsuk.dima.dao.exception.DaoException;
import by.gritsuk.dima.dao.exception.DaoFactoryException;
import by.gritsuk.dima.dao.exception.PersistException;
import by.gritsuk.dima.domain.Bet;
import by.gritsuk.dima.service.CompetitionEventService;
import by.gritsuk.dima.service.exception.ServiceException;

public class CompetitionEventServiceImpl implements CompetitionEventService {

    public CompetitionEventServiceImpl(){}

    @Override
    public void add(Bet.CompetitionEvent event) throws ServiceException {
        try {
            CompetitionEventDAO competitionEventDAO= (CompetitionEventDAO)FactoryProducer.getDaoFactory(DaoFactoryType.JDBC).getDao(Bet.CompetitionEvent.class);
            competitionEventDAO.persist(event);
        } catch (PersistException e) {
            throw new ServiceException("Failed to save competition event. ", e);
        } catch (DaoException|DaoFactoryException e) {
            throw new ServiceException("Failed to connect to database",e);
        }
    }
}
