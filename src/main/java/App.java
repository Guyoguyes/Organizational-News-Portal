import com.google.gson.Gson;
import dao.Sql2oDepartmentDao;
import dao.Sql2oEmployeesDao;
import dao.Sql2oNewsDao;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

public class App {
    public static void main(String[] args) {
        Sql2oDepartmentDao departmentDao;
        Sql2oEmployeesDao employeesDao;
        Sql2oNewsDao newsDao;
        Connection connection;
        Gson gson = new Gson();

        String connectionString = "jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "", "");

        departmentDao = new Sql2oDepartmentDao(sql2o);
        employeesDao = new Sql2oEmployeesDao(sql2o);
        newsDao = new Sql2oNewsDao(sql2o);

        connection = sql2o.open();
    }
}
