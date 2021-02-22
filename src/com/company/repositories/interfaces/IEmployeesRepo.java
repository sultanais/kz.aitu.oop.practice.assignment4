package com.company.repositories.interfaces;

import com.company.entities.Employees;

import java.util.List;

public interface IEmployeesRepo {
    boolean createEmployees(Employees employees);
    Employees getEmployeesById(int id);
    List<Employees> getAllEmployees();

}
