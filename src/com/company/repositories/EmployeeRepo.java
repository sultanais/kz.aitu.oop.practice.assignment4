package com.company.repositories;

import com.company.data.interfaces.IDB;
import com.company.entities.Employees;
import com.company.repositories.interfaces.IEmployeesRepo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepo implements IEmployeesRepo {
    private final IDB db;

    public EmployeeRepo(IDB db) {
        this.db = db;
    }

    @Override
    public boolean createEmployees(Employees employees) {
        Connection con = null;
        try {
        con = db.getConnection();
        String sql = "INSERT INTO employees(fname, lname, number, cost) VALUES (?,?,?)";
        PreparedStatement st = con.prepareStatement(sql);

        st.setString(1, employees.getFname());
        st.setString(2, employees.getLname());
        st.setInt(3, employees.getCost());
        st.setInt(4, employees.getNumber());

        boolean executed = st.execute();
        return executed;
    } catch (SQLException throwables) {
        throwables.printStackTrace();
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    } finally {
        try {
            con.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
        return false;
    }

    @Override
    public Employees getEmployeesById(int id) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id,fname, lname, number, cost FROM employees WHERE id=?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, id);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Employees employees = new Employees(rs.getInt("id"),
                        rs.getString("lname"),
                        rs.getString("fname"),
                        rs.getInt("number"),
                        rs.getInt("cost"));

                return employees;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public List<Employees> getAllEmployees() {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id,fname, lname, number, cost FROM employees";
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);
            List<Employees> employees = new ArrayList<>();
            while (rs.next()) {
                Employees employee = new Employees(rs.getInt("id"),
                        rs.getString("fname"),
                        rs.getString("lname"),
                        rs.getInt("number"),
                        rs.getInt("cost"));

                employees.add(employee);
            }

            return employees;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }
}
