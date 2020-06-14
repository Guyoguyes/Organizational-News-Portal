package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class EmployeesTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void EmployeesInstatiatesCorrectly() {
        Employees employees = setUpAssistant();
        assertEquals(true, employees instanceof Employees);
    }

    @Test
    public void getNames(){
        Employees employees = setUpAssistant();
        assertEquals("Alex", employees.getName());
    }

    @Test
    public void setsName(){
        Employees employees = setUpAssistant();
        employees.setName("John");
        assertEquals("John", employees.getName());
    }

    @Test
    public void getsPosition(){
        Employees employees = setUpAssistant();
        assertEquals("ICT director", employees.getPosition());
    }

    @Test
    public void setsPosition(){
        Employees employees = setUpAssistant();
        employees.setPosition("Human resource director");
        assertEquals("Human resource director", employees.getPosition());
    }

    @Test
    public void getsRole(){
        Employees employees = setUpAssistant();
        assertEquals("Heading the ict", employees.getRole());
    }

    @Test
    public void setsRole(){
        Employees employees = setUpAssistant();
        employees.setRole("Review of codes");
        assertEquals("Review of codes", employees.getRole());
    }

    @Test
    public void setId(){
        Employees employees = setUpAssistant();
        employees.setId(1);
        assertEquals(1, employees.getId());
    }

    @Test
    public void newsReturnsTrueIfNamesAreEqual(){
        Employees employees = setUpAssistant();
        Employees employees1 = setUpAssistant();
        assertTrue(employees.equals(employees1));
    }

    //helper method
    public Employees setUpAssistant(){

        return new Employees("Alex", "ICT director", "Heading the ict", 1);
    }
}