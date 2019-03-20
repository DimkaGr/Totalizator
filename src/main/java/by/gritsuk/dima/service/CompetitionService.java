package by.gritsuk.dima.service;

import by.gritsuk.dima.domain.Competition;
import by.gritsuk.dima.service.exception.ServiceException;

import java.util.List;

public interface CompetitionService {

    void add(Competition competition) throws ServiceException;

    List<Competition> getAll() throws ServiceException;

    void remove(Competition competition) throws ServiceException;

    List<Competition> getAllBySport(Integer kindOfSportId) throws ServiceException;

    List<Competition> getAllWithoutResult(Integer sportId) throws ServiceException;

    String updateResult(Integer id,String result) throws ServiceException;
}
