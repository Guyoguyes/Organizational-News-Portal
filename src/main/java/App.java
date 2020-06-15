import com.google.gson.Gson;
import dao.Sql2oDepartmentDao;
import dao.Sql2oEmployeesDao;
import dao.Sql2oNewsDao;
import exceptions.ApiException;
import models.Departments;
import models.News;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

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

        //post a department
        post("/department/new", "application/json", (req, res) ->{
            Departments departments = gson.fromJson(req.body(), Departments.class);
            departmentDao.add(departments);
            res.status(201);
            return gson.toJson(departments);
        });

        //get departments
        get("/department", "application/json", (req, res) ->{
            return gson.toJson(departmentDao.getAll());
        });

        //get by id
        get("/department/:id", "application/json", (req, res) ->{
            int departmentId = Integer.parseInt(req.queryParams("id"));
            Departments departments = departmentDao.findById(departmentId);

            if(departments == null){
                throw new ApiException(404, String.format("No restaurant with the id: \"%s\" exists", req.params("id")));

            }
            return gson.toJson(departments);
        });

        post("/department/:departmentId/news/new", "application/json", (req, res) ->{
            int departmentId = Integer.parseInt(req.queryParams("departmentId"));
            News news = gson.fromJson(req.body(), News.class);
            news.setDepartmentId(departmentId);

            newsDao.add(news);
            res.status(201);
            return gson.toJson(news);
        });

        //post normal news
        post("/news/new", "application/json", (req, res) ->{
            News news = gson.fromJson(req.body(), News.class);
            newsDao.add(news);
            return gson.toJson(news);
        });

        get("/news", "application/json", (req, res) ->{
            return gson.toJson(newsDao.getAll());
        });

        get("/news/:id", "application/json", (req, res) ->{
            int newsId = Integer.parseInt(req.queryParams("id"));
            News news = newsDao.findById(newsId);

            if(news == null){
                throw new ApiException(404, String.format("No restaurant with the id: \"%s\" exists", req.params("id")));

            }
            return gson.toJson(news);
        });

        //Filters
        exception(ApiException.class, (exception, req, res) -> {
            ApiException err = exception;
            Map<String, Object> jsonMap = new HashMap<>();
            jsonMap.put("status", err.getStatusCode());
            jsonMap.put("errorMessage", err.getMessage());
            res.type("application/json");
            res.status(err.getStatusCode());
            res.body(gson.toJson(jsonMap));
        });


        after((req, res) ->{
            res.type("application/json");
        });
    }
}
