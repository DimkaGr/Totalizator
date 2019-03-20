package by.gritsuk.dima.service.impl;

import by.gritsuk.dima.dao.*;
import by.gritsuk.dima.dao.exception.DaoException;
import by.gritsuk.dima.dao.exception.DaoFactoryException;
import by.gritsuk.dima.dao.exception.PersistException;
import by.gritsuk.dima.dao.impl.JdbcDaoFactory;
import by.gritsuk.dima.dao.impl.TransactionManager;
import by.gritsuk.dima.domain.*;
import by.gritsuk.dima.dto.ClientBetResponse;
import by.gritsuk.dima.service.ClientBetService;
import by.gritsuk.dima.service.exception.ServiceException;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClientBetServiceImpl implements ClientBetService {

    public ClientBetServiceImpl() {}

    @Override
    public void makeBet(ClientBet bet,Integer id,double cash) throws ServiceException, SQLException {
        TransactionManager manager= new TransactionManager();
        try {
            ClientBetDAO clientBetDAO= (ClientBetDAO)((JdbcDaoFactory)FactoryProducer.getDaoFactory(DaoFactoryType.JDBC)).getTransactionalDao(ClientBet.class);
            UserDAO userDAO=(UserDAO)((JdbcDaoFactory)FactoryProducer.getDaoFactory(DaoFactoryType.JDBC)).getTransactionalDao(User.class);
            manager.begin(userDAO,(AbstractJdbcDao)clientBetDAO);
            clientBetDAO.persist(bet);
            userDAO.updateCash(id,cash);
            manager.commit();
        } catch (PersistException e) {
            throw new ServiceException("Failed to save client bet ", e);
        } catch (DaoException|DaoFactoryException e) {
            manager.rollback();
            throw new ServiceException("Failed to connect to database",e);
        }finally {
            manager.end();
        }
    }

    @Override
    public List<ClientBetResponse> showClientBets(Integer userId) throws ServiceException {
        List<ClientBetResponse>responses=new ArrayList<>();
        try {
            ClientBetDAO clientBetDAO= (ClientBetDAO)FactoryProducer.getDaoFactory(DaoFactoryType.JDBC).getDao(ClientBet.class);
            CompetitionDAO competitionDAO=(CompetitionDAO)FactoryProducer.getDaoFactory(DaoFactoryType.JDBC).getDao(Competition.class);
            BetDAO betDAO=(BetDAO)FactoryProducer.getDaoFactory(DaoFactoryType.JDBC).getDao(Bet.class);
            List<ClientBet>clientBets=clientBetDAO.getByUserId(userId);
            for(ClientBet clientBet:clientBets){
                ClientBetResponse response=new ClientBetResponse();
                response.setDeposit(clientBet.getDeposit());
                response.setIncome(clientBet.getIncome());
                response.setStatus(clientBet.getStatus());
                Bet bet=betDAO.getByPK(clientBet.getBetId());
                response.setFactor(bet.getEvent().getFactor());
                response.setEvent(bet.getEvent().getEvent());
                Competition competition=competitionDAO.getByPK(bet.getCompetitionId());
                response.setCompetitionName(competition.getParticipant1()+"-"+competition.getParticipant1());
                response.setKindOfSport(competition.getKindOfSport());
                responses.add(response);
            }
        } catch (DaoException|DaoFactoryException e) {
            throw new ServiceException("Failed to connect to database",e);
        }
        if(responses.isEmpty()){
            return null;
        }
        return responses;
    }

    @Override
    public void updateStatus(Integer id, String status) throws ServiceException {
        try {
            ClientBetDAO clientBetDAO= (ClientBetDAO)FactoryProducer.getDaoFactory(DaoFactoryType.JDBC).getDao(ClientBet.class);
            List<ClientBet>bets=clientBetDAO.getByBet(id);
            for(ClientBet bet:bets){
                clientBetDAO.updateStatus(bet.getId(),status);
            }
        } catch (PersistException e) {
            throw new ServiceException("Failed to update client bet ", e);
        } catch (DaoException|DaoFactoryException e) {
            throw new ServiceException("Failed to connect to database",e);        }
    }
}
