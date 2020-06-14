package dao;

import models.News;

import java.util.List;

public interface NewsDao {

    //Add news
    void add(News news);

    //get All
    List<News> getAll();

    News findById(int id);
}
