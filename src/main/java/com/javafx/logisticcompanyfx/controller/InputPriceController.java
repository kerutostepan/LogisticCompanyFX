package com.javafx.logisticcompanyfx.controller;

import com.javafx.logisticcompanyfx.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;


public class InputPriceController {
    public static Integer max = 100000;
    public static Integer min = 1;

    @FXML
    private Button CancelButton;

    @FXML
    private TextField MaximumTextField;

    @FXML
    private TextField MinimumTextField;

    @FXML
    private Button SubmitButton;

    @FXML
    void initialize() {
        CancelButton.setOnAction(actionEvent -> Main.SwitchScene("CustomerProductController.fxml", CancelButton));
        SubmitButton.setOnAction(actionEvent -> {
            max = Integer.valueOf(MaximumTextField.getText());
            min = Integer.valueOf(MinimumTextField.getText());
            Main.SwitchScene("DiapasonPriceResult.fxml", SubmitButton);
        });

    }

}

