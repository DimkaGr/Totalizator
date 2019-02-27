package by.gritsuk.dima.dao;

import by.gritsuk.dima.dao.impl.CompetitionEventDAO;
import by.gritsuk.dima.domain.Bet;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.sql.Connection;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class AbstractJdbcDaoTest {
    ConnectionPool connectionPool;
    private Connection connection;
    private AbstractJdbcDao dao;

    @Before
    public void create() throws Exception {
        connectionPool=ConnectionPoolFactory.getInstance().getConnectionPool();
        connection=connectionPool.retrieveConnection();
        dao=new CompetitionEventDAO();
        dao.setConnection(connection);
    }

    @Test
    public void getAll()throws Exception {
        create();
//        Bet.CompetitionEvent event=new Bet.CompetitionEvent();
//        event.setEvent("Participant 1 win");
//        event.setFactor(1.6);
        assertTrue(dao.getAll().size()>0);
    }

    @Test
    public void persist() throws Exception{
        create();
        Bet.CompetitionEvent event=new Bet.CompetitionEvent();
        event.setEvent("Participant 3 win");
        event.setFactor(1.6);
        assertEquals(event,dao.persist(event));
    }

    @Test
    public void update() throws Exception{
        create();
        Bet.CompetitionEvent event=new Bet.CompetitionEvent();
        event.setEvent("Participant 2 win");
        event.setFactor(1.6);
        event.setId(2);
        dao.update(event);
        Bet.CompetitionEvent bet= (Bet.CompetitionEvent)(dao.getAll().get(1));
        assertEquals("Participant 2 win",bet.getEvent());
    }

    @Test
    public void delete() throws Exception{
        Bet.CompetitionEvent event=new Bet.CompetitionEvent();
        int before=dao.getAll().size();
//        event.setEvent("Participant 1 win");
//        event.setFactor(1.6);
        event.setId(3);
        dao.delete(event);
        int size=(dao.getAll().size());
        assertEquals(before-1,size);
    }
}