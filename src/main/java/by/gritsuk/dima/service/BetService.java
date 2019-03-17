package by.gritsuk.dima.service;

import by.gritsuk.dima.domain.Bet;
import by.gritsuk.dima.service.exception.ServiceException;

import java.util.List;

public interface BetService {

    List<Bet> getAllByCompetition(Integer competitionId) throws ServiceException;

    Bet getById(Integer id) throws ServiceException;

    void add(Bet bet) throws ServiceException;
}
