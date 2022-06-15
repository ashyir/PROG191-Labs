package com.example.sample_project;

import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class SessionController implements Initializable {
    @FXML
    private TableView listTable;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtSearch;

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnEdit;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        viewAll();
    }

    @FXML
    protected void add() {
        //Session session = new Session();
        //SessionList.add(session);
    }

    @FXML
    protected void viewAll() {
        TableColumn<Session, Session> colAction = new TableColumn<>("Action");
        colAction.setMinWidth(50);
        colAction.setStyle("-fx-alignment: CENTER;");
        colAction.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue()));
        colAction.setCellFactory(param -> new TableCell<Session, Session>() {
            private final Button btnRemove = new Button("Remove");

            @Override
            protected void updateItem(Session session, boolean empty) {
                super.updateItem(session, empty);

                if (session == null) {
                    setGraphic(null);
                    return;
                }

                setGraphic(btnRemove);
                btnRemove.setOnAction(event -> SessionList.remove(session));
            }
        });

        TableColumn<Session, String> colId = new TableColumn<>("ID");
        colId.setMinWidth(50);
        colId.setStyle("-fx-alignment: CENTER;");
        colId.setCellValueFactory(new PropertyValueFactory<>("Id"));

        TableColumn<Session, String> colName = new TableColumn<>("Name");
        colName.setMinWidth(150);
        colName.setStyle("-fx-alignment: CENTER;");
        colName.setCellValueFactory(new PropertyValueFactory<>("Name"));

        listTable.setItems(SessionList.getList());
        listTable.getColumns().addAll(colAction, colId, colName);
    }
}