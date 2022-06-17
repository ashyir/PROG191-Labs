package com.example.sample_project;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class LecturerController {
    @FXML
    private Pane mainPane;

    @FXML
    protected void logout() throws IOException {
        this.
        mainPane.getChildren().clear();
        Pane newLoadedPane =  FXMLLoader.load(SampleProjectApplication.class.getResource("login-view.fxml"));
        mainPane.getChildren().add(newLoadedPane);
    }
}