package by.gritsuk.dima.service.impl;

import by.gritsuk.dima.dao.BetDAO;
import by.gritsuk.dima.dao.DaoFactoryType;
import by.gritsuk.dima.dao.FactoryProducer;
import by.gritsuk.dima.dao.exception.DaoException;
import by.gritsuk.dima.dao.exception.DaoFactoryException;
import by.gritsuk.dima.domain.Bet;
import by.gritsuk.dima.service.BetService;
import by.gritsuk.dima.service.exception.ServiceException;

import java.util.ArrayList;
import java.util.List;

public class BetServiceImpl implements BetService {

    public BetServiceImpl(){}

    @Override
    public List<Bet> getAllByCompetition(Integer competition_id) throws ServiceException {
        List<Bet>bets=new ArrayList<>();
        try {
            BetDAO betDao=(BetDAO) FactoryProducer.getDaoFactory(DaoFactoryType.JDBC).getDao(Bet.class);
            bets=betDao.getByCompetition(competition_id);
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
}
