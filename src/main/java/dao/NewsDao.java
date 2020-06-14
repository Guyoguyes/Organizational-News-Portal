package dao;

import models.News;

import java.util.List;

public interface NewsDao {

    //Add news
    void add(News news);

    //get All
    List<News> getAll();

    //get by id
    News findById(int id);

    //get department news
    List<News> getAllNewsByDepartment(int departmentId);

    //delete news by id
    void deleteById(int id);

    //deleteAll news
    void clearAll();
}
