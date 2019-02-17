package by.gritsuk.dima.dao;

import by.gritsuk.dima.dao.exception.DaoException;
import by.gritsuk.dima.dao.exception.PersistException;

import java.sql.*;
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
    @AutoConnection
    public Optional<T> getByPK(PK key) throws DaoException {
        try(PreparedStatement selectStatement=this.connection.prepareStatement(getSelectQuery())){
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
    @AutoConnection
    public List<T> getAll() throws DaoException {
        try(PreparedStatement selectStatement=this.connection.prepareStatement(getSelectAllQuery())){
            try(ResultSet resQuery=selectStatement.executeQuery()) {
                return parseResultSet(resQuery);
            }
        }catch(PersistException |SQLException e){
            throw new DaoException("Failed while select elements",e);
        }
    }

    @Override
    @AutoConnection
    public T persist(T object) throws PersistException {
        try(PreparedStatement persistStatement=this.connection.prepareStatement(getCreateQuery(),PreparedStatement.RETURN_GENERATED_KEYS)){
            prepareStatementForInsert(persistStatement,object);
            ResultSet keysSet=persistStatement.getGeneratedKeys();
            if(keysSet.next()){
                PK id=(PK)keysSet.getObject(1);
                object.setId(id);
                return object;
            }else return null;
        }catch(SQLException e){
            throw new PersistException("Failed while insert element",e);
        }
    }

    @Override
    @AutoConnection
    public void update(T object) throws PersistException {
        try(PreparedStatement updateStatement=this.connection.prepareStatement(getUpdateQuery())){
            prepareStatementForUpdate(updateStatement,object);
            updateStatement.executeUpdate();
        }catch(SQLException e){
            throw new PersistException("Failed while update element",e);
        }
    }

    @Override
    @AutoConnection
    public void delete(T object) throws PersistException {
        try(PreparedStatement deleteStatement=this.connection.prepareStatement(getDeleteQuery())){
            deleteStatement.setLong(1,(Long)object.getId());
            deleteStatement.executeUpdate();
        }catch (SQLException e){
            throw new PersistException("Failed while delete element",e);
        }
    }
}
