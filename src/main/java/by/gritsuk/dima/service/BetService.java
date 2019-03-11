package by.gritsuk.dima.service;

import by.gritsuk.dima.domain.Bet;
import by.gritsuk.dima.service.exception.ServiceException;

import java.util.List;

public interface BetService {

    List<Bet> getAllByCompetition(Integer competition_id) throws ServiceException;

    Bet getById(Integer id) throws ServiceException;
}
