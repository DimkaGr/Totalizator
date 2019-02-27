package by.gritsuk.dima.service;

import by.gritsuk.dima.service.impl.CompetitionServiceImpl;
import by.gritsuk.dima.service.impl.RegistrationKeysServiceImpl;
import by.gritsuk.dima.service.impl.UserServiceImpl;


/**
 * Service factory
 */
public class ServiceFactory {
    private static ServiceFactory instance = new ServiceFactory();

    public static ServiceFactory getInstance() {
        return instance;
    }

    public UserService getUserService() {
        return new UserServiceImpl();
    }

    public RegistrationKeysService getRegistrationService(){
        return new RegistrationKeysServiceImpl();
    }

    public  CompetitionService getCompetitionService(){
        return new CompetitionServiceImpl();
    }
}
