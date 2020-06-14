package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class NewsTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }


    @Test
    public void newsInstantiatesCorrectly_true(){
        News news = setUpAssistance();
        assertEquals(true, news instanceof News);
    }

    @Test
    public void newsGetsHeadline_true(){
        News news = setUpAssistance();
        assertEquals("Voice of The Black", news.getHeadline());
    }

    @Test
    public void newsSetsHeadline_true(){
        News news = setUpAssistance();
        news.setHeadline("Department changes");
        assertEquals("Department changes", news.getHeadline());
    }

    @Test
    public void newsGetsContent_true(){
        News news = setUpAssistance();
        assertEquals("Black live matter demonstration", news.getContent());
    }

    @Test
    public void newsSetsContent_true(){
        News news = setUpAssistance();
        news.setContent("New CEO to be appointed");
        assertEquals("New CEO to be appointed", news.getContent());
    }

    @Test
    public void newsSetsIdCorrectly(){
        News news = setUpAssistance();
        news.setId(1);
        assertEquals(1, news.getId());
    }

    @Test
    public void newsReturnsTrueIfHeadlinesAreEqual(){
        News news = setUpAssistance();
        News news1 = setUpAssistance();
        assertTrue(news.equals(news1));
    }

    @Test
    public void newsReturnsTrueIfContentsAreEqual(){
        News news = setUpAssistance();
        News news1 = setUpAssistance();
        assertTrue(news.equals(news1));
    }

    @Test
    public void newsGetsAuthor(){
        News news = setUpAssistance();
        assertEquals("James Bond", news.getAuthor());
    }

    @Test
    public void newsSetsAuthor(){
        News news = setUpAssistance();
        news.setAuthor("john Doe");
        assertEquals("john Doe", news.getAuthor());
    }

    @Test
    public void newsGetsDepartmentsId(){
        News news = setUpAltAssistant();
        assertEquals(1, news.getDepartmentId());
    }

    @Test
    public void newsSetsDepartmentsId(){
        News news = setUpAltAssistant();
        news.setDepartmentId(2);
        assertEquals(2, news.getDepartmentId());
    }



    //helper method
    public News setUpAssistance(){
        return new News("Voice of The Black", "Black live matter demonstration", "James Bond");
    }

    public News setUpAltAssistant(){
        return  new News("Voice of The Black", "Black live matter demonstration", "James Bond", 1);
    }
}