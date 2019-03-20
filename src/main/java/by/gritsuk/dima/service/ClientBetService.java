package by.gritsuk.dima.service;

import by.gritsuk.dima.domain.ClientBet;
import by.gritsuk.dima.dto.ClientBetResponse;
import by.gritsuk.dima.service.exception.ServiceException;

import java.sql.SQLException;
import java.util.List;

public interface ClientBetService {

    void makeBet(ClientBet bet,Integer id, double cash) throws ServiceException, SQLException;

    List<ClientBetResponse> showClientBets(Integer userId) throws ServiceException;

    void updateStatus(Integer id,String status) throws ServiceException;
}
