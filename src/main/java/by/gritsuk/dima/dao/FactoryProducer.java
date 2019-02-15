package by.gritsuk.dima.dao;

import by.gritsuk.dima.dao.exception.DaoFactoryException;
import by.gritsuk.dima.dao.impl.JdbcDaoFactory;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Factory producer
 * Provide DAO Factory by type
 */
public class FactoryProducer {
    private static volatile FactoryProducer instance;
    private static final Lock LOCK=new ReentrantLock();

    private FactoryProducer() {}

    public FactoryProducer getInstance() {
        if (instance == null) {
            LOCK.lock();
            try {
                if (instance == null) {
                    instance = new FactoryProducer();
                }
            }finally {
                LOCK.unlock();
            }
        }
        return instance;
    }

    public static DaoFactory getDaoFactory(DaoFactoryType type) throws DaoFactoryException{
        if(type==DaoFactoryType.JDBC){
            return JdbcDaoFactory.getInstance();
        }
        else{
            throw new DaoFactoryException("There is no such DaoFactory "+type);
        }
    }
}
