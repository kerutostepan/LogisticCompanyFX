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

public class LogisticController {
    public static int Id = 0;
    ObservableList<Company> list = FXCollections.observableArrayList();
    @FXML
    private TableColumn<Company, String> Country;
    @FXML
    private TableColumn<Company, String> CountryID;
    @FXML
    private TableView<Company> CountryTable;
    @FXML
    private Button CreateCountryButton;
    @FXML
    private Button DeleteButton;
    @FXML
    private Button EditButton;
    @FXML
    private Button MenuReturnButton;
    @FXML
    private TableColumn<Company, String> Products;
    @FXML
    private Button StartMenuExitButton;

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
                list.add(new Company(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3)));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        CountryID.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getId().toString()));
        Country.setCellValueFactory(cellDataFeatures -> new SimpleStringProperty(cellDataFeatures.getValue().getName()));
        Products.setCellValueFactory(cellDataFeatures -> new SimpleStringProperty(cellDataFeatures.getValue().getProducts()));
        CountryTable.setItems(list);
        DeleteButton.setOnAction(actionEvent -> {
            Id = CountryTable.getSelectionModel().getSelectedItem().getId();
            db.deleteCompany(Id);
            Main.SwitchScene("LogisticCompany.fxml", DeleteButton);
        });
        CreateCountryButton.setOnAction(actionEvent -> Main.SwitchScene("CreateCountry.fxml", CreateCountryButton));
        EditButton.setOnAction(actionEvent -> {
            Id = CountryTable.getSelectionModel().getSelectedItem().getId();
            Main.SwitchScene("LogisticCompanyProduct.fxml", EditButton);
        });
        MenuReturnButton.setOnAction(actionEvent -> Main.SwitchScene("hello-view.fxml", MenuReturnButton));
        StartMenuExitButton.setOnAction(actionEvent -> {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            if (alert.showAndWait().get() == ButtonType.OK) {
                Main.CloseScene(StartMenuExitButton);
            }
        });
    }

}
