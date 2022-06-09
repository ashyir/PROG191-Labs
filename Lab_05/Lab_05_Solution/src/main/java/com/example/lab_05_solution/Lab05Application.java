package com.example.lab_05_solution;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Lab05Application extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Lab05Application.class.getResource("exercise-2.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        //stage.setFullScreen(true);
        stage.setTitle("Lab 05");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}