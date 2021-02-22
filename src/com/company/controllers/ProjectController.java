package com.company.controllers;

import com.company.entities.Company;
import com.company.entities.Employees;
import com.company.repositories.interfaces.ICompanyRepo;
import com.company.repositories.interfaces.IEmployeesRepo;

import java.util.List;

public class ProjectController {
    private final IEmployeesRepo employeesRepo;
    private final ICompanyRepo companyRepo;


    public ProjectController(IEmployeesRepo employeesRepo, ICompanyRepo companyRepo) {
        this.employeesRepo = employeesRepo;
        this.companyRepo = companyRepo;
    }

    public String createEmployee(String fname, String lname, int number, int cost) {
        Employees employees = new Employees(fname, lname, number, cost);

        boolean isCreated = employeesRepo.createEmployees(employees);

        return (isCreated ? "Employee creation was successful !" : "Employee creation was failed!");
    }

    public String getEmployeesById(int id) {
        Employees employees = employeesRepo.getEmployeesById(id);

        return (employees == null ? "Employee was not found!" : employees.toString());
    }

    public String getAllEmployees() {
        List<Employees> employees1 = employeesRepo.getAllEmployees();

        return employees1.toString();
    }

    public String createCompany(String name){
        Company company = new Company(name);
        boolean created = companyRepo.createCompany(company);
        return (created ? "Company creation was successful" : "Company creation was failed!");
    }

    public Company getCompanyById(int id){
        Company company = companyRepo.getCompanyById(id);

        return company;
    }

    public String getAllCompany(){
        List<Company> Companies = companyRepo.getAllCompany();

        return Companies.toString();
    }


}
