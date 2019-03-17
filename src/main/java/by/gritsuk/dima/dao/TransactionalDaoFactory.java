package by.gritsuk.dima.dao;

import by.gritsuk.dima.dao.exception.DaoException;

import java.io.Serializable;

/**
 * Transactional DAO Factory
 */
public interface TransactionalDaoFactory {
    /**
     * Get generic DAO of entity without connection
     * @param entityClass- entity class
     * @return transactional DAO
     * @throws DaoException should be clarify
     */
    <T extends Identified<PK>, PK extends Serializable> GenericDao<T, PK> getTransactionalDao(Class<T> entityClass) throws DaoException;}
