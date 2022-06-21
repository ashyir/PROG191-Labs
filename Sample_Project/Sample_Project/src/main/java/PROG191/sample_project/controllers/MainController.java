package PROG191.sample_project.controllers;

import PROG191.sample_project.data.CourseList;
import PROG191.sample_project.data.ProgramList;
import PROG191.sample_project.data.SessionList;
import PROG191.sample_project.data.UserList;
import PROG191.sample_project.models.*;
import PROG191.sample_project.MainApplication;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;
import java.io.*;
import java.net.URL;
import java.security.NoSuchAlgorithmException;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    @FXML
    private Pane mainPane;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            try {
                readData();
            } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException(e);
            }

            mainPane.getChildren().clear();
            Pane newLoadedPane = FXMLLoader.load(MainApplication.class.getResource("login-view.fxml"));
            mainPane.getChildren().add(newLoadedPane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readData() throws NoSuchAlgorithmException {
        ProgramList.readData();
        CourseList.readData();
        UserList.readData();
        SessionList.readData();
    }
}