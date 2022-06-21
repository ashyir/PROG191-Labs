package PROG191.sample_project.controllers.admin;

import PROG191.sample_project.MainApplication;
import PROG191.sample_project.data.UserList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
import java.io.IOException;

public class AdminController {
    @FXML
    private Pane mainPane;

    @FXML
    protected void logout() throws IOException {
        UserList.setCurrentUser(null);

        mainPane.getChildren().clear();
        Pane newLoadedPane =  FXMLLoader.load(MainApplication.class.getResource("login-view.fxml"));
        mainPane.getChildren().add(newLoadedPane);
    }
}