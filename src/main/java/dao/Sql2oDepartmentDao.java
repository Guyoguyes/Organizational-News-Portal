package dao;

import models.Departments;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oDepartmentDao implements DepartmentDao{
    private Sql2o sql2o;

    public Sql2oDepartmentDao(Sql2o sql2o){
        this.sql2o = sql2o;
    }

    @Override
    public void add(Departments departments) {
        String sql = "INSERT INTO departments (name, description) VALUES (:name, :description)";
        try(Connection connection = sql2o.open()){
            int id = (int) connection.createQuery(sql, true)
                    .bind(departments)
                    .executeUpdate()
                    .getKey();
            departments.setId(id);
        }catch (Sql2oException e){
            System.out.println(e);
        }
    }

    @Override
    public List<Departments> getAll() {
        try(Connection connection = sql2o.open()){
            return connection.createQuery("SELECT * FROM departments")
                    .executeAndFetch(Departments.class);
        }
    }

    @Override
    public Departments findById(int id) {
        try(Connection connection = sql2o.open()) {
            return connection.createQuery("SELECT * FROM departments WHERE id=:id")
                    .addParameter("id", id)
                    .executeAndFetchFirst(Departments.class);
        }
    }


}
