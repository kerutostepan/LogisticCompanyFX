package com.javafx.logisticcompanyfx.jdbc;

import com.javafx.logisticcompanyfx.entities.Company;

import java.sql.*;

public class CompanyDatabase {

    public static final String URL = "jdbc:postgresql://localhost:5432/logistic_company";
    public static final String NAME = "postgres";
    public static final String PASSWORD = "1111";

    public void createCompany(Company company) {
        Connection connection;
        String Insert = "INSERT INTO \"Company\"\n(country_name) VALUES (?)";
        try {
            connection = DriverManager.getConnection(URL, NAME, PASSWORD);
            PreparedStatement preparedStatement = connection.prepareStatement(Insert);
            preparedStatement.setString(1, company.getName());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet showCompany() {
        ResultSet resultSet = null;
        String show = "SELECT * FROM \"Company\"";
        try {
            Connection connection = DriverManager.getConnection(URL, NAME, PASSWORD);
            PreparedStatement preparedStatement = connection.prepareStatement(show);
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    public void deleteCompany(int id) {
        String delete = "delete from \"Company\" Where country_id = ?";

        Connection connection;
        try {
            connection = DriverManager.getConnection(URL, NAME, PASSWORD);
            PreparedStatement preparedStatement = connection.prepareStatement(delete);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
