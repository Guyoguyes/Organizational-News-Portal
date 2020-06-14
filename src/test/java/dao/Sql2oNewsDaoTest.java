package dao;

import models.Departments;
import models.News;
import org.h2.util.New;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static org.junit.Assert.*;

public class Sql2oNewsDaoTest {
    private Connection connection;
    private Sql2oNewsDao newsDao;
    private Sql2oDepartmentDao departmentDao;

    @Before
    public void setUp() throws Exception {
        String connectionString = "jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "", "");
        newsDao = new Sql2oNewsDao(sql2o);
        departmentDao = new Sql2oDepartmentDao(sql2o);
        connection = sql2o.open();
    }

    @After
    public void tearDown() throws Exception {
        connection.close();
    }

    @Test
    public void addsNewsToDatabase(){
        Departments departments = setUpDepartmentAssistant();
        departmentDao.add(departments);
        News news = setUpAltAssistant(departments);
        newsDao.add(news);
        assertEquals(1, newsDao.getAll().size());
    }

    @Test
    public void getsAllNewsFromDatabase(){
        News news = setUpAssistance();
        newsDao.add(news);
        News news1 = setUpAssistance();
        newsDao.add(news1);
        assertEquals(2, newsDao.getAll().size());
    }

    @Test
    public void FindsSpecificNewsById(){
        News news = setUpAssistance();
        newsDao.add(news);
        News news1 = setUpAssistance();
        newsDao.add(news1);
        News foundNews = newsDao.findById(news1.getId());
        assertEquals(news1, foundNews);
    }

    @Test
    public void getsAllDepartmentInTheNews(){
        Departments departments = setUpDepartmentAssistant();
        departmentDao.add(departments);
        Departments departments1 = setUpDepartmentAssistant();
        departmentDao.add(departments1);
        News news = setUpAltAssistant(departments);
        newsDao.add(news);
        News news1 = setUpAltAssistant(departments1);
        newsDao.add(news1);

        assertEquals(1, newsDao.getAllNewsByDepartment(departments.getId()).size());
    }

    @Test
    public void deleteById(){
        News news = setUpAssistance();
        newsDao.add(news);
        News news1 = setUpAssistance();
        newsDao.add(news1);
        assertEquals(2, newsDao.getAll().size());
        newsDao.deleteById(news1.getId());
        assertEquals(1, newsDao.getAll().size());
    }

    @Test
    public void clearAll(){
        News news = setUpAssistance();
        newsDao.add(news);
        News news1 = setUpAssistance();
        newsDao.add(news1);
        newsDao.clearAll();
        assertEquals(0, newsDao.getAll().size());
    }

    //helper method
    public News setUpAssistance(){
        return new News("Voice of The Black", "Black live matter demonstration", "James Bond");
    }

    public News setUpAltAssistant(Departments departments){
        return  new News("Voice of The Black", "Black live matter demonstration", "James Bond", departments.getId());
    }

    public Departments setUpDepartmentAssistant(){
        return new Departments("Human resource", "the personnel of a business or organization, regarded as a significant asset in terms of skills and abilities.\n");
    }
}