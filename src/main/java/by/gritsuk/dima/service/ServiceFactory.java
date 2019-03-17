package by.gritsuk.dima.service;

import by.gritsuk.dima.service.impl.*;


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

    public KindOfSportService getKindOfSportService(){return new KindOfSportServiceImpl();
    }

    public BetService getBetService(){
        return new BetServiceImpl();
    }

    public ClientBetService getClientBetService(){return new ClientBetServiceImpl();}

    public CompetitionEventService getCompetitionEventService(){return new CompetitionEventServiceImpl();}
}
