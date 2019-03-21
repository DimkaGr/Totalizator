package by.gritsuk.dima.dao.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DAOProperties {
    public DAOProperties(){}

    public Properties getDAOProperties(String fileName){
        ClassLoader classLoader = getClass().getClassLoader();
        try(InputStream iStream=classLoader.getResourceAsStream(fileName)){
            Properties properties=new Properties();
            properties.load(iStream);
            return properties;
        }catch(IOException e){
            throw new RuntimeException("Property file is not found",e);
        }
    }
}
