package com.example.sample_project;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SampleProjectController implements Initializable {
    @FXML
    private Pane mainPane;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            mainPane.getChildren().clear();
            Pane newLoadedPane = FXMLLoader.load(SampleProjectApplication.class.getResource("login-view.fxml"));
            mainPane.getChildren().add(newLoadedPane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}