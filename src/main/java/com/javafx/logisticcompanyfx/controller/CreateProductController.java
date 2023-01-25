package com.javafx.logisticcompanyfx.controller;

import com.javafx.logisticcompanyfx.Main;
import com.javafx.logisticcompanyfx.entities.Product;
import com.javafx.logisticcompanyfx.jdbc.ProductDatabase;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class CreateProductController {

    @FXML
    private Button CancelButton;

    @FXML
    private TextField CreateNameTextField;

    @FXML
    private TextField CreatePriceTextField;

    @FXML
    private Button SubmitButton;

    @FXML
    void initialize() {
        CancelButton.setOnAction(actionEvent -> Main.SwitchScene("LogisticCompanyProduct.fxml", CancelButton));
        SubmitButton.setOnAction(actionEvent -> {
            String name = CreateNameTextField.getText();
            Integer price = Integer.valueOf(CreatePriceTextField.getText());
            Product product = new Product(name, price);
            ProductDatabase db = new ProductDatabase();
            db.addProduct(product);
            Main.SwitchScene("LogisticCompanyProduct.fxml", SubmitButton);
        });
    }

}
