package com.javafx.logisticcompanyfx.controller;

import com.javafx.logisticcompanyfx.Main;
import com.javafx.logisticcompanyfx.entities.Product;
import com.javafx.logisticcompanyfx.jdbc.ProductDatabase;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.sql.ResultSet;
import java.sql.SQLException;

import static com.javafx.logisticcompanyfx.controller.LogisticController.Id;

public class LogisticCompanyProductController {

    ObservableList<Product> list = FXCollections.observableArrayList();
    @FXML
    private TableColumn<Product, String> ClientsWishes;
    @FXML
    private TableColumn<Product, String> CountryID;
    @FXML
    private Button CreateButton;
    @FXML
    private Button DeleteButton;
    @FXML
    private Button ExitButton;
    @FXML
    private Button MenuReturnButton;
    @FXML
    private TableColumn<Product, String> Price;
    @FXML
    private TableColumn<Product, String> Price_for_client;
    @FXML
    private TableColumn<Product, String> Products;
    @FXML
    private TableColumn<Product, String> ProductsID;
    @FXML
    private TableView<Product> ProductsTable;

    @FXML
    void initialize() {
        ProductDatabase db = new ProductDatabase();
        ResultSet resultSet = db.showProduct(Id);
        while (true) {
            try {
                if (!resultSet.next())
                    break;
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                list.add(new Product(resultSet.getInt(1), resultSet.getInt(2), resultSet.getString(3), resultSet.getInt(4), resultSet.getInt(5), resultSet.getString(6)));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        ProductsID.setCellValueFactory(cellDataFeatures -> new SimpleStringProperty(cellDataFeatures.getValue().getId().toString()));
        CountryID.setCellValueFactory(productIntegerCellDataFeatures -> new SimpleStringProperty(productIntegerCellDataFeatures.getValue().getCountryId().toString()));
        Products.setCellValueFactory(productStringCellDataFeatures -> new SimpleStringProperty(productStringCellDataFeatures.getValue().getProducts()));
        Price.setCellValueFactory(productStringCellDataFeatures -> new SimpleStringProperty(productStringCellDataFeatures.getValue().getPrice().toString()));
        Price_for_client.setCellValueFactory(productStringCellDataFeatures -> new SimpleStringProperty(productStringCellDataFeatures.getValue().getPriceForClients().toString()));
        ClientsWishes.setCellValueFactory(productStringCellDataFeatures -> new SimpleStringProperty(productStringCellDataFeatures.getValue().getWishes()));
        ProductsTable.setItems(list);
        CreateButton.setOnAction(actionEvent -> Main.SwitchScene("CreateProduct.fxml", CreateButton));
        DeleteButton.setOnAction(actionEvent -> {
            int i = ProductsTable.getSelectionModel().getSelectedItem().getId();
            db.deleteProduct(i);
            Main.SwitchScene("LogisticCompanyProduct.fxml", DeleteButton);
        });
        ExitButton.setOnAction(actionEvent -> {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            if(alert.showAndWait().get() == ButtonType.OK){
                Main.CloseScene(ExitButton);
            }
        });
        MenuReturnButton.setOnAction(actionEvent -> Main.SwitchScene("LogisticCompany.fxml", MenuReturnButton));
    }

}
