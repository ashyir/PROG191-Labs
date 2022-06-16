package com.example.sample_project;

import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;

import java.net.URL;
import java.util.ResourceBundle;

public class ProgramController implements Initializable {
    @FXML
    private Label lblId;

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

    private void clearTextView() {
        txtName.setText("");
    }

    @FXML
    protected void add() {
        if (btnAdd.getText().equals("Add")) {
            var program = new Program(0, txtName.getText());
            ProgramList.add(program);
            clearTextView();

            return;
        }

        clearTextView();

        btnAdd.setText("Add");
        btnEdit.setDisable(true);
    }

    @FXML
    protected void edit() {
        var id = Integer.parseInt(lblId.getText());
        var program = new Program(id,
                txtName.getText());

        ProgramList.edit(id, program);

        clearTextView();

        btnAdd.setText("Add");
        btnEdit.setDisable(true);
    }

    private void viewDetail(Program program) {
        txtName.setText(program.getName());

        btnAdd.setText("Cancel");
        btnEdit.setDisable(false);

        // For editting.
        lblId.setText(String.valueOf(program.getId()));
    }

    private void remove(Program program) {
        ProgramList.remove(program);
    }

    @FXML
    protected void viewAll() {
        TableColumn<Program, Program> colAction = new TableColumn<>("Action");
        colAction.setMinWidth(50);
        colAction.setStyle("-fx-alignment: CENTER;");
        colAction.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue()));
        colAction.setCellFactory(param -> new TableCell<Program, Program>() {
            private final HBox hBox = new HBox();
            private final Button btnRemove = new Button("x");
            private final Button btnViewDetail = new Button("View");

            @Override
            protected void updateItem(Program program, boolean empty) {
                super.updateItem(program, empty);

                if (program == null) {
                    setGraphic(null);
                    return;
                }

                hBox.getChildren().clear();

                hBox.setSpacing(5);
                hBox.setAlignment(Pos.CENTER);
                hBox.getChildren().add(btnRemove);
                hBox.getChildren().add(btnViewDetail);

                setGraphic(hBox);

                btnRemove.setOnAction(event -> remove(program));
                btnViewDetail.setOnAction(event -> viewDetail(program));
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