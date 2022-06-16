package com.example.sample_project;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class LoginController {
    @FXML
    private Label lblError;

    @FXML
    private Pane mainPane;

    @FXML
    private TextField txtUsername;

    @FXML
    private PasswordField txtPassword;

    @FXML
    protected void login() throws IOException {
        var username = txtUsername.getText();
        var password = txtPassword.getText();

        if (username.equals("admin") && password.equals("admin")) {
            mainPane.getChildren().clear();
            Pane newLoadedPane =  FXMLLoader.load(SampleProjectApplication.class.getResource("admin-view.fxml"));
            mainPane.getChildren().add(newLoadedPane);

            return;
        }

        lblError.setText("Login Failed.");

        txtUsername.setText("");
        txtPassword.setText("");

        txtUsername.requestFocus();
    }
}