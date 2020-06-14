package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DepartmentsTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void departmentsInstantiatesCorrectly(){
        Departments departments = setUpAssistant();
        assertEquals(true, departments instanceof Departments);
    }


    @Test
    public void departmentsInstantiatesWithId(){
        Departments departments = setUpAssistant();
        departments.setId(1);
        assertEquals(1, departments.getId());
    }

    @Test
    public void getsNameCorrectly() throws Exception{
        Departments departments = setUpAssistant();
        assertEquals("Human resource", departments.getName());
    }

    @Test
    public void setsNameCorrectly() throws Exception{
        Departments departments = setUpAssistant();
        departments.setName("ICT");
        assertNotEquals("Human Resource", departments.getName());
    }

    @Test
    public void getsDescriptionCorrectly() throws Exception{
        Departments departments = setUpAssistant();
        assertEquals("the personnel of a business or organization, regarded as a significant asset in terms of skills and abilities.\n", departments.getDescription());
    }

    @Test
    public void setsDescriptionCorrectly() throws Exception{
        Departments departments = setUpAssistant();
        departments.setDescription("Help in technical issues");
        assertNotEquals("the personnel of a business or organization, regarded as a significant asset in terms of skills and abilities.\n", departments.getDescription());
    }

    @Test
    public void departmentReturnsTrueIfEqual(){
        Departments departments = setUpAssistant();
        Departments departments1 = setUpAssistant();
        assertTrue(departments.equals(departments1));
    }


    //helper method
    public Departments setUpAssistant(){
        return new Departments("Human resource", "the personnel of a business or organization, regarded as a significant asset in terms of skills and abilities.\n");
    }
}