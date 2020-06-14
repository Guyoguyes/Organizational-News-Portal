package dao;

import models.Employees;

import java.util.List;

public interface EmployeesDao {

    //Add Employees
    void add(Employees employees);

    //Get All
    List<Employees> getAll();

    // find By Id
    Employees findById(int id);

    //get All Employees in a department
    List<Employees> getAllEmployeesInDepartment(int departmentId);

    //delete by id
    void deleteById(int id);

    //clear All
    void clearAll();

}
