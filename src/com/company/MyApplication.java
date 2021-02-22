package com.company;

import com.company.controllers.ProjectController;
import com.company.entities.Company;
import com.company.repositories.interfaces.*;

import java.util.Scanner;

public class MyApplication {
    private final ProjectController controller;
    private final Scanner scanner;

    public MyApplication(IEmployeesRepo employeeRepo, ICompanyRepo companyRepo) {
        controller = new ProjectController(employeeRepo, companyRepo);
        scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            System.out.println();
            System.out.println("Welcome to my Application");
            System.out.println("Select option:");
            System.out.println("1. Get all employees");
            System.out.println("2. Get employees by id");
            System.out.println("3. Create employee");
            System.out.println("4. Create company");
            System.out.println("5. Get all companies");
            System.out.println("6. Get company by ID");
            System.out.println("0. Exit");
            System.out.println();
            try {
                System.out.print("Enter 1-6: ");
                int option = scanner.nextInt();
                if (option == 1) {
                    getAllEmployeesMenu();
                } else if (option == 2) {
                    getEmployeesByIdMenu();
                } else if (option == 3) {
                    createEmployeesMenu();
                } else if (option == 4) {
                    createCompanyMenu();
                } else if(option == 5){
                    getAllCompanyMenu();
                } else if(option == 6){
                    getCompaniesByIdMenu();
                }
                else {
                    break;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                scanner.next(); // to ignore incorrect input
            }

            System.out.println("*************************");

        }
    }
    //get all Employees using controller and repo
    public void getAllEmployeesMenu() {
        String response = controller.getAllEmployees();
        System.out.println(response);
    }
    //get one Employee by ID
    public void getEmployeesByIdMenu() {
        System.out.println("Please enter id");

        int id = scanner.nextInt();
        String response = controller.getEmployeesById(id);
        System.out.println(response);
    }
    //Creating Employee
    public void createEmployeesMenu() {
        System.out.println("Enter employee ID");
        int id = scanner.nextInt();
        try {
            var locoId = controller.getCompanyById(id).getId();
        } catch (Exception ex){
            System.out.println("Company is not found");
            return;
        }

        System.out.println("Please enter last name");
        String lname = scanner.next();
        System.out.println("Please enter first name");
        String fname = scanner.next();
        System.out.println("Please enter phone number of employee");
        int number = scanner.nextInt();
        System.out.println("Please enter cost of the project");
        int cost = scanner.nextInt();



        String response = controller.createEmployee(lname, fname, number, cost);
        System.out.println(response);
    }
//creating Company
    public void createCompanyMenu() {
        System.out.println("Please enter name of company");
        String name = scanner.next();
        String response = controller.createCompany(name);
        System.out.println(response);
    }
//get all Companies
    public void getAllCompanyMenu(){
        String response = controller.getAllCompany();
        System.out.println(response);
    }
//Get one Company using ID
    public void getCompaniesByIdMenu() {
        System.out.println("Please enter id of company:");

        int id = scanner.nextInt();
        Company com = controller.getCompanyById(id);
        String response = (com == null ? "Company was not found!" : com.toString());

        System.out.println(response);
    }
}
