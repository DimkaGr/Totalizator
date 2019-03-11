package by.gritsuk.dima.service.impl;

import by.gritsuk.dima.dao.ClientBetDAO;
import by.gritsuk.dima.dao.DaoFactoryType;
import by.gritsuk.dima.dao.FactoryProducer;
import by.gritsuk.dima.dao.exception.DaoException;
import by.gritsuk.dima.dao.exception.DaoFactoryException;
import by.gritsuk.dima.dao.exception.PersistException;
import by.gritsuk.dima.domain.ClientBet;
import by.gritsuk.dima.service.ClientBetService;
import by.gritsuk.dima.service.exception.ServiceException;

public class ClientBetServiceImpl implements ClientBetService {

    public ClientBetServiceImpl() {}

    @Override
    public void makeBet(ClientBet bet) throws ServiceException {
        try {
            ClientBetDAO clientBetDAO= (ClientBetDAO)FactoryProducer.getDaoFactory(DaoFactoryType.JDBC).getDao(ClientBet.class);
            clientBetDAO.persist(bet);
        } catch (PersistException e) {
            throw new ServiceException("Failed to sace client bet ", e);
        } catch (DaoException|DaoFactoryException e) {
            throw new ServiceException("Failed to connect to database",e);
        }
    }
}
