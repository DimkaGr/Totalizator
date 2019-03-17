package by.gritsuk.dima.service;

import by.gritsuk.dima.domain.Bet;
import by.gritsuk.dima.service.exception.ServiceException;

public interface CompetitionEventService {

    void add(Bet.CompetitionEvent event) throws ServiceException;
}
