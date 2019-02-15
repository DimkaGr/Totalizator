package by.gritsuk.dima.dao;

import by.gritsuk.dima.dao.exception.DaoException;
import by.gritsuk.dima.dao.exception.PersistException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Abstract JDBC DAO
 * @param <T> - Identified entity
 * @param <PK> - Type primary key of entity
 */
public abstract class AbstractJdbcDao<T extends Identified<PK>, PK extends Number> implements GenericDao<T, PK> {
    protected Connection connection;

    protected abstract List<T> parseResultSet(ResultSet rs) throws PersistException,SQLException;

    protected abstract void prepareStatementForInsert(PreparedStatement statement, T object) throws PersistException, SQLException;

    protected abstract void prepareStatementForUpdate(PreparedStatement statement, T object) throws PersistException,SQLException;

    public abstract String getSelectQuery();

    public abstract String getCreateQuery();

    public abstract String getUpdateQuery();

    public abstract String getDeleteQuery();

    public abstract String getSelectAllQuery();

    public void setConnection(Connection connection){
        this.connection=connection;
    }

    @Override
    public Optional<T> getByPK(PK key) throws DaoException {
        try(PreparedStatement selectStatement=connection.prepareStatement(getSelectQuery())){
            selectStatement.setLong(1,(Long)key);
            try(ResultSet resQuery=selectStatement.executeQuery()) {
                List<T> list = parseResultSet(resQuery);
                if (list.size() == 1) {
                    return Optional.ofNullable(list.get(0));
                } else {
                    return Optional.empty();
                }
            }
        }catch(PersistException|SQLException e){
            throw new DaoException("Failed while select element by id="+key,e);
        }
    }

    @Override
    public List<T> getAll() throws DaoException {
        try(PreparedStatement selectStatement=connection.prepareStatement(getSelectAllQuery())){
            try(ResultSet resQuery=selectStatement.executeQuery()) {
                return parseResultSet(resQuery);
            }
        }catch(PersistException |SQLException e){
            throw new DaoException("Failed while select elements",e);
        }
    }

    @Override
    public boolean persist(T object) throws PersistException {
        try(PreparedStatement persistStatement=connection.prepareStatement(getCreateQuery())){
            prepareStatementForInsert(persistStatement,object);
            return persistStatement.execute();
        }catch(SQLException e){
            throw new PersistException("Failed while insert element",e);
        }
    }

    @Override
    public void update(T object) throws PersistException {
        try(PreparedStatement updateStatement=connection.prepareStatement(getUpdateQuery())){
            prepareStatementForUpdate(updateStatement,object);
            updateStatement.executeUpdate();
        }catch(SQLException e){
            throw new PersistException("Failed while update element",e);
        }
    }

    @Override
    public void delete(T object) throws PersistException {
        try(PreparedStatement deleteStatement=connection.prepareStatement(getDeleteQuery())){
            deleteStatement.setLong(1,(Long)object.getId());
            deleteStatement.executeUpdate();
        }catch (SQLException e){
            throw new PersistException("Failed while delete element",e);
        }
    }
}
