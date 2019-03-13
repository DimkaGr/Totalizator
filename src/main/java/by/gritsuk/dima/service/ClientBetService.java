package by.gritsuk.dima.service;

import by.gritsuk.dima.domain.ClientBet;
import by.gritsuk.dima.dto.ClientBetResponse;
import by.gritsuk.dima.service.exception.ServiceException;

public interface ClientBetService {

    void makeBet(ClientBet bet) throws ServiceException;

    ClientBetResponse showClientBets(Integer user_id) throws ServiceException;
}
