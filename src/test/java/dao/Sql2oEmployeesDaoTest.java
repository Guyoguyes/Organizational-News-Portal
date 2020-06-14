package dao;

import models.Employees;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static org.junit.Assert.*;

public class Sql2oEmployeesDaoTest {
    private Connection connection;
    private Sql2oEmployeesDao employeesDao;
    private Sql2oDepartmentDao departmentDao;

    @Before
    public void setUp() throws Exception {
        String connectionString = "jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "", "");
        employeesDao = new Sql2oEmployeesDao(sql2o);
        departmentDao = new Sql2oDepartmentDao(sql2o);
        connection = sql2o.open();
    }

    @Test
    public void addsEmployeesToDatabase(){
        Employees employees = setUpAssistant();
        employeesDao.add(employees);
        assertEquals(1, employeesDao.getAll().size());
    }

    @After
    public void tearDown() throws Exception {
        connection.close();
    }

    //helper method
    public Employees setUpAssistant(){
        return new Employees("John Doe", "Ict director", "supervise IT", 1);
    }
}