package com.company.repositories;

import com.company.data.interfaces.IDB;
import com.company.entities.Company;
import com.company.entities.Employees;
import com.company.repositories.interfaces.ICompanyRepo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
//writing SQL code
public class CompanyRepo implements ICompanyRepo {
    private final IDB db;

    public CompanyRepo(IDB db) {
        this.db = db;
    }

    @Override
    public boolean createCompany(Company company) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "INSERT INTO company(name) VALUES (?)";
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, company.getName());

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
    public Company getCompanyById(int id) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id,name, cost FROM company WHERE id=?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, id);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Company company= new Company(rs.getString("name"),
                        rs.getInt("id"));

                return company;
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
    public List<Employees> getAllEmployees(int id) {

        return null;
    }

    @Override
    public List<Company> getAllCompany() {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id,name, cost FROM company";
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);
            List<Company> companies = new ArrayList<>();
            while (rs.next()) {
                Company company = new Company(rs.getString("name"),
                        rs.getInt("id"));

                companies.add(company);
            }

            return companies;
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
