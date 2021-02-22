package com.company.entities;

import java.util.List;

public class Employees {
    private int id;
    private String fname;
    private String lname;
    private int number;
    private int cost;

    public Employees() {

    }

    public Employees(int id, String fname, String lname, int number, int cost) {
        setId(id);
        setFname(fname);
        setLname(lname);
        setNumber(number);
        setCost(cost);
    }

    public Employees(String fname, String lname, int number, int cost) {
        setFname(fname);
        setLname(lname);
        setNumber(number);
        setCost(cost);
    }

    public Employees(int id, String lname, String fname, int number) {
    }

    public void setId(int id) {
        this.id = id;
    }
    private void setCost(int cost) {
        this.cost=cost;
    }
    public void setFname(String fname) {
        this.fname = fname;
    }
    public void setLname(String lname) {
        this.lname = lname;
    }
    public void setNumber(int number) {
        this.number = number;
    }



    public int getId() {
        return id;
    }
    public String getFname() {
        return fname;
    }
    public String getLname() {
        return lname;
    }

    public int getNumber() {
        return number;
    }

    public int getCost() {
        return cost;
    }

    @Override
    public String toString() {
        return "Employees{" +
                "id=" + id +
                ", fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                ", number=" + number +
                ", cost=" + cost +
                '}';
    }
}