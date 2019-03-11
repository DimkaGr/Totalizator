package by.gritsuk.dima.service;

import by.gritsuk.dima.domain.RegistrationKey;
import by.gritsuk.dima.service.exception.ServiceException;

public interface RegistrationKeysService {

    void add(RegistrationKey key) throws ServiceException;

    RegistrationKey getByUserId(Integer user_id) throws ServiceException;

    void remove(RegistrationKey key) throws ServiceException;
}
