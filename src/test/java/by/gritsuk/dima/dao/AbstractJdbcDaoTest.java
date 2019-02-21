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
        Bet.CompetitionEvent event=new Bet.CompetitionEvent();
        event.setEvent("Participant 1 win");
        event.setFactor(1.6);
        Bet.CompetitionEvent bet= (Bet.CompetitionEvent)(dao.getAll().get(0));
        assertEquals(event.getEvent(),bet.getEvent());
    }

    @Test
    public void persist() throws Exception{
        create();
        Bet.CompetitionEvent event=new Bet.CompetitionEvent();
        event.setEvent("Draw");
        event.setFactor(10.6);
        assertEquals(event,dao.persist(event));
    }

    @Test
    public void update() throws Exception{
        create();
        Bet.CompetitionEvent event=new Bet.CompetitionEvent();
        event.setEvent("Participant 2 win");
        event.setFactor(1.6);
        event.setId(0);
        dao.update(event);
        Bet.CompetitionEvent bet= (Bet.CompetitionEvent)(dao.getAll().get(0));
        assertEquals("Participant 2 win",bet.getEvent());
    }

    @Test
    public void delete() throws Exception{
        Bet.CompetitionEvent event=new Bet.CompetitionEvent();
        event.setEvent("Participant 1 win");
        event.setFactor(1.6);
        dao.delete(event);
        int size=(dao.getAll().size());
        assertEquals(0,size);
    }
}