package by.gritsuk.dima.service.impl;

import by.gritsuk.dima.dao.*;
import by.gritsuk.dima.dao.exception.DaoException;
import by.gritsuk.dima.dao.exception.DaoFactoryException;
import by.gritsuk.dima.dao.exception.PersistException;
import by.gritsuk.dima.domain.RegistrationKey;
import by.gritsuk.dima.service.RegistrationKeysService;
import by.gritsuk.dima.service.exception.ServiceException;

import java.util.List;


public class RegistrationKeysServiceImpl implements RegistrationKeysService {

    public RegistrationKeysServiceImpl(){}

    @Override
    public void add(RegistrationKey key) throws ServiceException {
        try {
            GenericDao<RegistrationKey,Integer> keyDao= FactoryProducer.getDaoFactory(DaoFactoryType.JDBC).getDao(RegistrationKey.class);
            RegistrationKey dbLey=keyDao.getByPK(key.getId());
            if (dbLey != null) {
                keyDao.update(key);
            }else {
                keyDao.persist(key);
            }
        } catch (PersistException|DaoException e) {
            throw new ServiceException("Failed to save registration key. ", e);
        } catch (DaoFactoryException e){
            throw new ServiceException("Failed to connect to database",e);
        }
    }

    @Override
    public RegistrationKey getByUserId(Integer user_id) throws ServiceException {
        try {
            GenericDao<RegistrationKey,Integer> keyDao= FactoryProducer.getDaoFactory(DaoFactoryType.JDBC).getDao(RegistrationKey.class);
            return keyDao.getByPK(user_id);
        } catch (DaoException e) {
            throw new ServiceException("Failed to find registration key ", e);
        } catch (DaoFactoryException e){
            throw new ServiceException("Failed to connect to database",e);
        }
    }

    @Override
    public void remove(RegistrationKey key) throws ServiceException {
        try {
            GenericDao<RegistrationKey,Integer> keyDao= FactoryProducer.getDaoFactory(DaoFactoryType.JDBC).getDao(RegistrationKey.class);
            keyDao.delete(key);
        } catch (PersistException e) {
            throw new ServiceException("Failed to delete registration key ", e);
        } catch (DaoFactoryException|DaoException e){
            throw new ServiceException("Failed to connect to database",e);
        }
    }
}
