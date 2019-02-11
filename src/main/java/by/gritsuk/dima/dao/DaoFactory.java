package by.gritsuk.dima.dao;

import by.gritsuk.dima.dao.exception.DaoException;

/**
 * Dao Factory
 */
public interface DaoFactory {
    /**
     * Return implementation of DAO for entity class
     * @param entityClass - entity class
     * @return - implementation of DAO for entity class
     * @throws DaoException - should be clarify
     */
    GenericDao getDao(Class entityClass) throws DaoException;
}
