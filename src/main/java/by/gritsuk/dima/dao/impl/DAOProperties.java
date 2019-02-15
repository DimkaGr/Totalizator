package by.gritsuk.dima.dao.impl;

import by.gritsuk.dima.dao.exception.DaoException;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DAOProperties {
    public DAOProperties(){}

    public Properties getDAOProperties(String fileName)throws DaoException{
        ClassLoader classLoader = getClass().getClassLoader();
        try(InputStream iStream=classLoader.getResourceAsStream(fileName)){
            Properties properties=new Properties();
            properties.load(iStream);
            return properties;
        }catch(IOException e){
            throw new DaoException("Property file is not found",e);
        }
    }
}
