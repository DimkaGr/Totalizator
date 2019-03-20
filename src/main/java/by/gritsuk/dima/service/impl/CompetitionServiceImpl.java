package by.gritsuk.dima.service.impl;

import by.gritsuk.dima.dao.*;
import by.gritsuk.dima.dao.exception.DaoException;
import by.gritsuk.dima.dao.exception.DaoFactoryException;
import by.gritsuk.dima.dao.exception.PersistException;
import by.gritsuk.dima.domain.Competition;
import by.gritsuk.dima.service.CompetitionService;
import by.gritsuk.dima.service.exception.ServiceException;

import java.util.List;

public class CompetitionServiceImpl implements CompetitionService {

    public CompetitionServiceImpl(){}

    @Override
    public void add(Competition competition) throws ServiceException {
        try {
            CompetitionDAO competitionDao = (CompetitionDAO)FactoryProducer.getDaoFactory(DaoFactoryType.JDBC).getDao(Competition.class);
            competitionDao.persist(competition);
        } catch (PersistException e) {
            throw new ServiceException("Failed to save competition. ", e);
        } catch (DaoFactoryException|DaoException e){
            throw new ServiceException("Failed to connect to database",e);
        }
    }

    @Override
    public List<Competition> getAll() throws ServiceException {
        List<Competition> competitions;
        try {
            CompetitionDAO competitionDao = (CompetitionDAO)FactoryProducer.getDaoFactory(DaoFactoryType.JDBC).getDao(Competition.class);
            competitions=competitionDao.getAll();
            if(competitions.isEmpty()){
                competitions=null;
            }
        } catch (DaoException e) {
            throw new ServiceException("Failed to get competitions. ", e);
        } catch (DaoFactoryException e){
            throw new ServiceException("Failed to connect to database",e);
        }
        return competitions;
    }

    @Override
    public void remove(Competition competition) throws ServiceException {
        try {
            CompetitionDAO competitionDao = (CompetitionDAO)FactoryProducer.getDaoFactory(DaoFactoryType.JDBC).getDao(Competition.class);
            competitionDao.delete(competition);
        } catch (PersistException e) {
            throw new ServiceException("Failed to delete competition ", e);
        } catch (DaoFactoryException|DaoException e){
            throw new ServiceException("Failed to connect to database",e);
        }
    }

    @Override
    public List<Competition> getAllBySport(Integer kindOfSportId) throws ServiceException {
        List<Competition> competitions;
        try {
            CompetitionDAO competitionDao = (CompetitionDAO)FactoryProducer.getDaoFactory(DaoFactoryType.JDBC).getDao(Competition.class);
            competitions=competitionDao.getBySport(kindOfSportId);
            if(competitions.isEmpty()){
                competitions=null;
            }
        } catch (DaoException e) {
            throw new ServiceException("Failed to get competitions. ", e);
        } catch (DaoFactoryException e){
            throw new ServiceException("Failed to connect to database",e);
        }
        return competitions;
    }

    @Override
    public List<Competition> getAllWithoutResult(Integer sportId) throws ServiceException {
        List<Competition> competitions;
        try {
            CompetitionDAO competitionDao = (CompetitionDAO)FactoryProducer.getDaoFactory(DaoFactoryType.JDBC).getDao(Competition.class);
            competitions=competitionDao.getAllWithoutResult(sportId);
            if(competitions.isEmpty()){
                competitions=null;
            }
        } catch (DaoException e) {
            throw new ServiceException("Failed to get competitions. ", e);
        } catch (DaoFactoryException e){
            throw new ServiceException("Failed to connect to database",e);
        }
        return competitions;
    }

    @Override
    public String updateResult(Integer id, String result) throws ServiceException {
        String res;
        try {
            CompetitionDAO competitionDao = (CompetitionDAO)FactoryProducer.getDaoFactory(DaoFactoryType.JDBC).getDao(Competition.class);
            Competition competition=competitionDao.getByPK(id);
            int resultId=competition.getCompetitionResultId();
            if(competition.getKindOfSportId()==4){
                if(result.contains("team 1")){
                    res=competition.getParticipant1()+" win";
                } else {
                    res=competition.getParticipant2()+" win";
                }
            } else {
                res = competition.getParticipant1() + " " + result + " " + competition.getParticipant2();
            }
            competitionDao.updateResult(resultId,res);
        } catch (PersistException e) {
            throw new ServiceException("Failed to save competition. ", e);
        } catch (DaoFactoryException|DaoException e){
            throw new ServiceException("Failed to connect to database",e);
        }
        return res;
    }
}
