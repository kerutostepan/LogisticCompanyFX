package com.javafx.logisticcompanyfx.jdbc;

import com.javafx.logisticcompanyfx.entities.Product;

import java.sql.*;

import static com.javafx.logisticcompanyfx.controller.LogisticController.Id;

public class ProductDatabase {
    public static final String URL = "jdbc:postgresql://localhost:5432/logistic_company";
    public static final String NAME = "postgres";
    public static final String PASSWORD = "1111";

    public void addProduct(Product product) {
        String insert = "INSERT INTO country_info (products,price,country_id) VALUES (?,?,?);";
        Connection connection;
        try {
            connection = DriverManager.getConnection(URL, NAME, PASSWORD);
            PreparedStatement statement = connection.prepareStatement(insert);
            statement.setString(1, product.getProducts());
            statement.setInt(2, product.getPrice());
            statement.setInt(3, Id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet showProduct(int id) {
        ResultSet resultSet = null;
        String show = "SELECT * FROM country_info WHERE country_id = ?";
        try {
            Connection connection = DriverManager.getConnection(URL, NAME, PASSWORD);
            PreparedStatement preparedStatement = connection.prepareStatement(show);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    public void deleteProduct(int id) {
        String delete = "DELETE FROM country_info WHERE products_id = ?";
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

    public ResultSet showProductDiapason(int id, Integer min, Integer max) {
        ResultSet resultSet = null;
        String show = "SELECT * FROM country_info WHERE country_id = ? AND price_for_clients BETWEEN ? AND ?";
        try {
            Connection connection = DriverManager.getConnection(URL, NAME, PASSWORD);
            PreparedStatement preparedStatement = connection.prepareStatement(show);
            preparedStatement.setInt(1, id);
            preparedStatement.setInt(2, min);
            preparedStatement.setInt(3, max);
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    public void addWishes(String whishes, Integer id) {
        String insert = "UPDATE country_info SET clients_wishes = ? WHERE products_id = ?;";
        Connection connection;
        try {
            connection = DriverManager.getConnection(URL, NAME, PASSWORD);
            PreparedStatement statement = connection.prepareStatement(insert);
            statement.setString(1, whishes);
            statement.setInt(2, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
