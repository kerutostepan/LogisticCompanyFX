package com.javafx.logisticcompanyfx.controller;

import com.javafx.logisticcompanyfx.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class HelloController {

    @FXML
    private Button Customer;

    @FXML
    private Button LogisticCompany;

    @FXML
    void initialize(ActionEvent event) {

    }

    @FXML
    void initialize() {
        LogisticCompany.setOnAction(actionEvent -> Main.SwitchScene("LogisticCompany.fxml", LogisticCompany));
        Customer.setOnAction(actionEvent -> Main.SwitchScene("Customer.fxml", Customer));
    }

}
