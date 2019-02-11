package by.gritsuk.dima.dao;

import by.gritsuk.dima.dao.exception.DaoException;
import by.gritsuk.dima.dao.exception.PersistException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

/**
 * Abstract JDBC DAO
 * @param <T> - Identified entity
 * @param <PK> - Type primary key of entity
 */
public abstract class AbstractJdbcDao<T extends Identified<PK>, PK extends Number> implements GenericDao<T, PK> {
    protected Connection connection;

    protected abstract List<T> parseResultSet(ResultSet rs) throws PersistException;

    protected abstract void prepareStatementForInsert(PreparedStatement statement, T object) throws PersistException, SQLException;

    protected abstract void prepareStatementForUpdate(PreparedStatement statement, T object) throws PersistException,SQLException;

    public abstract String getSelectQuery();

    public abstract String getCreateQuery();

    public abstract String getUpdateQuery();

    public abstract String getDeleteQuery();

    @Override
    public Optional<T> getByPK(PK key) throws DaoException {

        // Write your code here

        return null;
    }

    @Override
    public List<T> getAll() throws DaoException {

        // Write your code here

        throw new UnsupportedOperationException();
    }

    @Override
    public Optional<T> persist(T object) throws PersistException {

        // Write your code here

        throw new UnsupportedOperationException();
    }

    @Override
    public void update(T object) throws PersistException {

        // Write your code here

        throw new UnsupportedOperationException();
    }

    @Override
    public void delete(T object) throws PersistException {

        // Write your code here

        throw new UnsupportedOperationException();
    }
}
