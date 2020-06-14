package dao;

import models.Departments;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static org.junit.Assert.*;

public class Sql2oDepartmentDaoTest {
    private Connection connection;
    private Sql2oDepartmentDao departmentDao;


    @Before
    public void setUp() throws Exception {
        String connectionString = "jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "", "");
        departmentDao = new Sql2oDepartmentDao(sql2o);
        connection = sql2o.open();
    }

    @After
    public void tearDown() throws Exception {
        connection.close();
    }

    @Test
    public void addsDepartmentToDatabase(){
        Departments departments = setUpDepartmentAssistant();
        departmentDao.add(departments);
        assertEquals(1, departmentDao.getAll().size());
    }

    //helper method
    public Departments setUpDepartmentAssistant(){
        return new Departments("Human resource", "the personnel of a business or organization, regarded as a significant asset in terms of skills and abilities.\n");
    }
}