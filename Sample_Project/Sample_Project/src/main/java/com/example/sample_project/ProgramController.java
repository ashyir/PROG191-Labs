package com.example.sample_project;

import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import java.net.URL;
import java.util.ResourceBundle;

public class ProgramController implements Initializable {
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
        var program = new Program(0, txtName.getText());
        ProgramList.add(program);
    }

    @FXML
    protected void viewAll() {
        TableColumn<Program, Program> colAction = new TableColumn<>("Action");
        colAction.setMinWidth(50);
        colAction.setStyle("-fx-alignment: CENTER;");
        colAction.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue()));
        colAction.setCellFactory(param -> new TableCell<Program, Program>() {
            private final Button btnRemove = new Button("Remove");

            @Override
            protected void updateItem(Program program, boolean empty) {
                super.updateItem(program, empty);

                if (program == null) {
                    setGraphic(null);
                    return;
                }

                setGraphic(btnRemove);
                btnRemove.setOnAction(event -> ProgramList.remove(program));
            }
        });

        TableColumn<Program, String> colId = new TableColumn<>("ID");
        colId.setMinWidth(50);
        colId.setStyle("-fx-alignment: CENTER;");
        colId.setCellValueFactory(new PropertyValueFactory<>("Id"));

        TableColumn<Program, String> colName = new TableColumn<>("Name");
        colName.setMinWidth(150);
        colName.setStyle("-fx-alignment: CENTER;");
        colName.setCellValueFactory(new PropertyValueFactory<>("Name"));

        listTable.setItems(ProgramList.getList());
        listTable.getColumns().addAll(colAction, colId, colName);
    }
}