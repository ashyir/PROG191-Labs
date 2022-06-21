package PROG191.sample_project.controllers;

import PROG191.sample_project.MainApplication;
import PROG191.sample_project.data.UserList;
import PROG191.sample_project.models.User;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

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
    protected void loginEnter(KeyEvent ke) throws IOException, NoSuchAlgorithmException {
        if (ke.getCode() == KeyCode.ENTER)
            login();
    }

    @FXML
    protected void login() throws IOException, NoSuchAlgorithmException {
        UserList.setCurrentUser(null);

        var username = txtUsername.getText();
        var password = txtPassword.getText();

        if (username.isBlank()) {
            showError("Username is blank.");
            return;
        }

        if (password.isBlank()) {
            showError("Password is blank.");
            return;
        }

        if (!UserList.authenticate(username, password)) {
            showError("Login Failed.");
            return;
        }

        var user = UserList.find(username);

        switch (user.getRole()) {
            case ADMIN: loadUI("admin/admin-view", user); return;
            case LECTURER: loadUI("lecturer/lecturer-view", user); return;
            default:  showError("No Role Found."); return;
        }
    }

    private void loadUI(String fileName, User user) throws IOException {
        UserList.setCurrentUser(user);

        mainPane.getChildren().clear();
        Pane newLoadedPane = FXMLLoader.load(MainApplication.class.getResource(fileName + ".fxml"));
        mainPane.getChildren().add(newLoadedPane);
    }

    private void showError(String error) {
        lblError.setText(error);
        txtPassword.setText("");
        txtUsername.requestFocus();
    }
}