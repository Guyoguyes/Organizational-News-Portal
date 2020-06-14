package dao;

import models.News;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oNewsDao implements NewsDao{
    private Sql2o sql2o;

    public Sql2oNewsDao(Sql2o sql2o){
        this.sql2o = sql2o;
    }

    @Override
    public void add(News news) {
        String sql = "INSERT INTO news (headline, content, author, departmentId) VALUES (:headline, :content, :author, departmentId)";
        try(Connection connection = sql2o.open()) {
            int id = (int) connection.createQuery(sql, true)
                    .bind(news)
                    .executeUpdate()
                    .getKey();
            news.setId(id);
        }catch (Sql2oException e){
            System.out.println(e);
        }
    }

    @Override
    public List<News> getAll() {
        try(Connection connection = sql2o.open()){
            return connection.createQuery("SELECT * FROM news")
                    .executeAndFetch(News.class);
        }
    }

    @Override
    public News findById(int id) {
        try(Connection connection = sql2o.open()){
            return connection.createQuery("SELECT * FROM news WHERE id=:id")
                    .addParameter("id", id)
                    .executeAndFetchFirst(News.class);
        }
    }

}
