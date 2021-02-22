package com.company.repositories.interfaces;

import com.company.entities.Company;
import com.company.entities.Employees;

import java.util.List;

public interface ICompanyRepo {
//skeleton for database
    boolean createCompany(Company company);
    Company getCompanyById(int id);
    List<Employees> getAllEmployees(int id);
    List<Company> getAllCompany();
}
