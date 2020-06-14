package dao;

import models.Departments;

import java.util.List;

public interface DepartmentDao {

    //add department
    void add(Departments departments);

    //get all
    List<Departments> getAll();

    //Find by id
    Departments findById(int id);

    //delete by id
    void deleteById(int id);

    //clear all
    void clearAll();

}
