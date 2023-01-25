package com.javafx.logisticcompanyfx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {


    public static void SwitchScene(String str, Button button) {
        button.getScene().getWindow().hide();
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(str));
        try {
            fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage stage = new Stage();
        stage.setTitle("App");
        stage.setScene(new Scene(fxmlLoader.getRoot()));
        stage.setResizable(true);
        stage.show();
    }

    public static void CloseScene(Button button) {
        Stage stage = (Stage) button.getScene().getWindow();
        stage.close();
    }

    public static void main(String[] args) {
        launch();
    }


    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 720, 500);
        stage.setTitle("App");
        stage.setScene(scene);
        stage.setResizable(true);
        stage.show();
    }
}