package by.gritsuk.dima.service.impl;

import by.gritsuk.dima.dao.*;
import by.gritsuk.dima.dao.exception.DaoException;
import by.gritsuk.dima.dao.exception.DaoFactoryException;
import by.gritsuk.dima.dao.exception.PersistException;
import by.gritsuk.dima.domain.Bet;
import by.gritsuk.dima.domain.Client;
import by.gritsuk.dima.domain.ClientBet;
import by.gritsuk.dima.domain.Competition;
import by.gritsuk.dima.dto.ClientBetResponse;
import by.gritsuk.dima.service.ClientBetService;
import by.gritsuk.dima.service.exception.ServiceException;

import java.util.List;

public class ClientBetServiceImpl implements ClientBetService {

    public ClientBetServiceImpl() {}

    @Override
    public void makeBet(ClientBet bet) throws ServiceException {
        try {
            ClientBetDAO clientBetDAO= (ClientBetDAO)FactoryProducer.getDaoFactory(DaoFactoryType.JDBC).getDao(ClientBet.class);
            clientBetDAO.persist(bet);
        } catch (PersistException e) {
            throw new ServiceException("Failed to save client bet ", e);
        } catch (DaoException|DaoFactoryException e) {
            throw new ServiceException("Failed to connect to database",e);
        }
    }

    @Override
    public ClientBetResponse showClientBets(Integer user_id) throws ServiceException {
        ClientBetResponse clientBetResponse=new ClientBetResponse();
        try {
            ClientBetDAO clientBetDAO= (ClientBetDAO)FactoryProducer.getDaoFactory(DaoFactoryType.JDBC).getDao(ClientBet.class);
            CompetitionDAO competitionDAO=(CompetitionDAO)FactoryProducer.getDaoFactory(DaoFactoryType.JDBC).getDao(Competition.class);
            BetDAO betDAO=(BetDAO)FactoryProducer.getDaoFactory(DaoFactoryType.JDBC).getDao(Bet.class);
            List<ClientBet>clientBets=clientBetDAO.getByUserId(user_id);
//            List<Competition>competitions=
//        } catch () {
//            throw new ServiceException("Failed to save client bet ", e);
        } catch (DaoException|DaoFactoryException e) {
            throw new ServiceException("Failed to connect to database",e);
        }
        return clientBetResponse;
    }
}
