package by.gritsuk.dima.service;

import by.gritsuk.dima.domain.Sport;
import by.gritsuk.dima.service.exception.ServiceException;

import java.util.List;

public interface KindOfSportService {

    List<Sport> getAll() throws ServiceException;
}
