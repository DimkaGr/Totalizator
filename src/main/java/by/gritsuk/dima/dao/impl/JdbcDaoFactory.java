package by.gritsuk.dima.dao.impl;

import by.gritsuk.dima.dao.*;
import by.gritsuk.dima.dao.exception.DaoException;
import by.gritsuk.dima.domain.*;

import java.io.Serializable;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Supplier;

/**
 * Jdbc DAO Factory
 */
public class JdbcDaoFactory implements DaoFactory, TransactionalDaoFactory {
    private static JdbcDaoFactory instance;
    private static  final Lock LOCK = new ReentrantLock();
    private Map<Class, Supplier<GenericDao>> creators = new HashMap<>();

    private class DaoInvocationHandler implements InvocationHandler {
        private final GenericDao dao;

        DaoInvocationHandler(GenericDao dao) {
            this.dao = dao;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            Object result;

            if (Arrays.stream(dao.getClass().getMethods())
                    .filter(m -> m.isAnnotationPresent(AutoConnection.class))
                    .map(Method::getName)
                    .anyMatch(m -> m.equals(method.getName()))) {

                ConnectionPool connectionPool = ConnectionPoolFactory.getInstance().getConnectionPool();
                Connection connection = connectionPool.retrieveConnection();

                TransactionManager.setConnectionWithReflection(dao, connection);

                result = method.invoke(dao, args);

                connectionPool.putBackConnection(connection);
                TransactionManager.setConnectionWithReflection(dao, null);

            } else {
                result = method.invoke(dao, args);
            }

            return result;
        }

    }

    private JdbcDaoFactory() {
        creators.put(User.class, UserDAO::new);
        creators.put(Bet.class,BetDAO::new);
        creators.put(ClientBet.class,ClientBetDAO::new);
        creators.put(Competition.class,CompetitionDAO::new);
        creators.put(Bet.CompetitionEvent.class,CompetitionEventDAO::new);
        creators.put(RegistrationKey.class,SendKeysDAO::new);
    }

    public static JdbcDaoFactory getInstance() {
        LOCK.lock();
        try {
            if (instance == null) {
                instance = new JdbcDaoFactory();
            }

        } finally {
            LOCK.unlock();
        }

        return instance;
    }

    @Override
    public <T extends Identified<PK>, PK extends Serializable> GenericDao<T, PK> getDao(Class<T> entityClass) throws DaoException {
        Supplier<GenericDao> daoCreator = creators.get(entityClass);
        if (daoCreator == null) {
            throw new DaoException("Entity Class cannot be find");
        }
        GenericDao dao = daoCreator.get();

        return (GenericDao) Proxy.newProxyInstance(dao.getClass().getClassLoader(),
                dao.getClass().getInterfaces(),
                new DaoInvocationHandler(dao));
    }

    @Override
    public <T extends Identified<PK>, PK extends Serializable> GenericDao<T, PK> getTransactionalDao(Class<T> entityClass) throws DaoException {
        Supplier<GenericDao> daoCreator = creators.get(entityClass);
        if (daoCreator == null) {
            throw new DaoException("Entity Class cannot be find");
        }

        return daoCreator.get();
    }
}
