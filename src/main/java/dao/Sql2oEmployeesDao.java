package dao;

import models.Employees;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oEmployeesDao implements EmployeesDao{
    private Sql2o sql2o;

    public Sql2oEmployeesDao(Sql2o sql2o){
        this.sql2o = sql2o;
    }

    @Override
    public void add(Employees employees) {
        String sql = "INSERT INTO employees (name, position, role, departmentId) VALUES (:name, :position, :role, :departmentId)";
        try(Connection connection = sql2o.open()){
            int id = (int) connection.createQuery(sql, true)
                    .bind(employees)
                    .executeUpdate()
                    .getKey();
            employees.setId(id);
        }catch (Sql2oException e){
            System.out.println(e);
        }
    }

    @Override
    public List<Employees> getAll() {
        try(Connection connection = sql2o.open()){
            return connection.createQuery("SELECT * FROM employees")
                    .executeAndFetch(Employees.class);
        }
    }

    @Override
    public Employees findById(int id) {
        try(Connection connection = sql2o.open()){
            return connection.createQuery("SELECT * FROM employees WHERE id=:id")
                    .addParameter("id", id)
                    .executeAndFetchFirst(Employees.class);
        }
    }

}
