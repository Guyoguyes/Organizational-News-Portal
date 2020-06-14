package dao;

import models.Departments;
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

    @Test
    public void getsAllEmployeesFromDatabase(){
        Employees employees = setUpAssistant();
        employeesDao.add(employees);
        Employees employees1 = setUpAssistant();
        employeesDao.add(employees1);
        assertEquals(2, employeesDao.getAll().size());
    }

    @Test
    public void findsSpecificEmployeesById(){
        Employees employees = setUpAssistant();
        employeesDao.add(employees);
        Employees employees1 = setUpAssistant();
        employeesDao.add(employees1);
        Employees foundEmployees = employeesDao.findById(employees1.getId());
        assertEquals(employees1, foundEmployees);
    }

    @Test
    public void getsAllEmployeesInDepartment(){
        Departments departments = new Departments("ICT", "information communication Technology");
        departmentDao.add(departments);
        Employees employees = setUpAltAssistant(departments);
        employeesDao.add(employees);
        assertEquals(1, employeesDao.getAllEmployeesInDepartment(departments.getId()).size());
    }

    @Test
    public void deletesById(){
        Employees employees = setUpAssistant();
        employeesDao.add(employees);
        Employees employees1 = setUpAssistant();
        employeesDao.add(employees1);
        assertEquals(2, employeesDao.getAll().size());
        employeesDao.deleteById(employees.getId());
        assertEquals(1, employeesDao.getAll().size());
    }

    @Test
    public void clearAll(){
        Employees employees = setUpAssistant();
        employeesDao.add(employees);
        Employees employees1 = setUpAssistant();
        employeesDao.add(employees1);
        employeesDao.clearAll();
        assertEquals(0, employeesDao.getAll().size());
    }

    @After
    public void tearDown() throws Exception {
        connection.close();
    }

    //helper method
    public Employees setUpAssistant(){
        return new Employees("John Doe", "Ict director", "supervise IT", 1);
    }

    public Employees setUpAltAssistant(Departments departments){
            return new Employees("John Doe", "Ict director", "supervise IT", departments.getId());
    }

}