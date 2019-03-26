package by.gritsuk.dima.service.impl;

import by.gritsuk.dima.dao.BetDAO;
import by.gritsuk.dima.dao.CompetitionEventDAO;
import by.gritsuk.dima.dao.DaoFactoryType;
import by.gritsuk.dima.dao.FactoryProducer;
import by.gritsuk.dima.dao.exception.DaoException;
import by.gritsuk.dima.dao.exception.DaoFactoryException;
import by.gritsuk.dima.dao.exception.PersistException;
import by.gritsuk.dima.domain.Bet;
import by.gritsuk.dima.service.BetService;
import by.gritsuk.dima.service.exception.ServiceException;

import java.util.List;

public class BetServiceImpl implements BetService {

    public BetServiceImpl(){}

    @Override
    public List<Bet> getAllByCompetition(Integer competitionId) throws ServiceException {
        List<Bet>bets;
        try {
            BetDAO betDao=(BetDAO) FactoryProducer.getDaoFactory(DaoFactoryType.JDBC).getDao(Bet.class);
            bets=betDao.getByCompetition(competitionId);
            if (bets.isEmpty()) {
                bets=null;
            }
        } catch (DaoException e) {
            throw new ServiceException("Failed to get bets. ", e);
        } catch (DaoFactoryException e){
            throw new ServiceException("Failed to connect to database",e);
        }
        return bets;
    }

    @Override
    public Bet getById(Integer id) throws ServiceException {
        try{
            BetDAO betDao=(BetDAO) FactoryProducer.getDaoFactory(DaoFactoryType.JDBC).getDao(Bet.class);
            return betDao.getByPK(id);
        } catch (DaoException e) {
            throw new ServiceException("Failed to get bet. ", e);
        } catch (DaoFactoryException e) {
            throw new ServiceException("Failed to connect to database",e);
        }
    }

    @Override
    public void add(Bet bet) throws ServiceException {
        try {
            BetDAO betDao=(BetDAO)FactoryProducer.getDaoFactory(DaoFactoryType.JDBC).getDao(Bet.class);
            CompetitionEventDAO eventDao=(CompetitionEventDAO)FactoryProducer.getDaoFactory(DaoFactoryType.JDBC).getDao(Bet.CompetitionEvent.class);
            Bet.CompetitionEvent event=eventDao.persist(bet.getEvent());
            bet.setEvent(event);
            betDao.persist(bet);
        } catch (PersistException e) {
            throw new ServiceException("Failed to save bet event data. ", e);
        } catch (DaoFactoryException|DaoException e) {
            throw new ServiceException("Failed to connect to database",e);
        }
    }
}
