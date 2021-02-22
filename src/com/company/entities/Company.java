package com.company.entities;

import java.util.List;

public class Company {
    //declaration of variables
    private int id;
    private String name;
    private int cost;
    private List<Employees> employeesList;
    public Company(String name) {
    }

    public Company(int id, String name, int cost) {
        setId(id);
        setName(name);
        setCost(cost);
        //Method
    }

    public Company(String name, int cost) {
        setName(name);
        setCost(cost);
    }
    // making private variable available for the this variables. Encapsulation/safety
    public void setId(int id) {
        this.id = id;
    }//

    public void setName(String name) {
        this.name = name;
    }

    public void setCost(int Cost) {
        this.cost = cost;
    }

    public void setEmployeesList(List<Employees> employeesList) { this.employeesList = employeesList; }


    //return values by getters. Encapsulation/safety
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getCost() {
        return cost;
    }
    public List<Employees> getWorkerList() { return employeesList; }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cost=" + cost +
                ", employeesList=" + employeesList +
                '}';
    }
}