package com.javafx.logisticcompanyfx.controller;

import com.javafx.logisticcompanyfx.Main;
import com.javafx.logisticcompanyfx.entities.Company;
import com.javafx.logisticcompanyfx.jdbc.CompanyDatabase;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerController {
    public static int Id = 0;
    ObservableList<Company> list = FXCollections.observableArrayList();
    @FXML
    private TableColumn<Company, String> CountryName;
    @FXML
    private TableColumn<Company, String> ProductsID;
    @FXML
    private TableView<Company> ProductsTable;
    @FXML
    private Button ShowProductsButton;
    @FXML
    private Button ExitButton;
    @FXML
    private Button MenuReturnButton;

    @FXML
    void initialize() {
        CompanyDatabase db = new CompanyDatabase();
        ResultSet resultSet = db.showCompany();
        while (true) {
            try {
                if (!resultSet.next())
                    break;
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                list.add(new Company(resultSet.getInt(1), resultSet.getString(2)));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        ProductsID.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getId().toString()));
        CountryName.setCellValueFactory(cellDataFeatures -> new SimpleStringProperty(cellDataFeatures.getValue().getName()));
        ProductsTable.setItems(list);
        ShowProductsButton.setOnAction(actionEvent -> {
            Id = ProductsTable.getSelectionModel().getSelectedItem().getId();
            Main.SwitchScene("CustomerProduct.fxml", ShowProductsButton);
        });
        ExitButton.setOnAction(actionEvent -> {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            if (alert.showAndWait().get() == ButtonType.OK) {
                Main.CloseScene(ExitButton);
            }
        });
        MenuReturnButton.setOnAction(actionEvent -> Main.SwitchScene("hello-view.fxml", MenuReturnButton));
    }

}
