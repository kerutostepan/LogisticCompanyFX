package com.javafx.logisticcompanyfx.controller;

import com.javafx.logisticcompanyfx.Main;
import com.javafx.logisticcompanyfx.entities.Company;
import com.javafx.logisticcompanyfx.jdbc.CompanyDatabase;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class CreateCountryController {

    @FXML
    private Button CancelButton;

    @FXML
    private TextField CreateCountryText;

    @FXML
    private Button SubmitButton;

    @FXML
    void initialize() {
        CancelButton.setOnAction(actionEvent -> Main.SwitchScene("LogisticCompany.fxml",CancelButton));
        SubmitButton.setOnAction(actionEvent -> {
            String name = CreateCountryText.getText();
            Company company = new Company(name);
            CompanyDatabase db = new CompanyDatabase();
            db.createCompany(company);
            Main.SwitchScene("LogisticCompany.fxml", SubmitButton);
        });
    }

}
