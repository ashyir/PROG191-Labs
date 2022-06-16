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

public class LecturerController implements Initializable {
    @FXML
    private Label lblId;

    @FXML
    private TableView listTable;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtStaffId;

    @FXML
    private TextField txtPhone;

    @FXML
    private TextField txtEmail;

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
        txtStaffId.setText("");
        txtPhone.setText("");
        txtEmail.setText("");
    }

    @FXML
    protected void add() {
        if (btnAdd.getText().equals("Add")) {
            Lecturer lecturer = new Lecturer(0,
                    txtName.getText(),
                    txtStaffId.getText(),
                    txtPhone.getText(),
                    txtEmail.getText());

            LecturerList.add(lecturer);

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
        var lecturer = new Lecturer(id,
                txtName.getText(),
                txtStaffId.getText(),
                txtPhone.getText(),
                txtEmail.getText());

        LecturerList.edit(id, lecturer);

        clearTextView();

        btnAdd.setText("Add");
        btnEdit.setDisable(true);
    }

    private void viewDetail(Lecturer lecturer) {
        txtName.setText(lecturer.getName());
        txtStaffId.setText(lecturer.getStaffId());
        txtPhone.setText(lecturer.getPhone());
        txtEmail.setText(lecturer.getEmail());

        btnAdd.setText("Cancel");
        btnEdit.setDisable(false);

        // For editting.
        lblId.setText(String.valueOf(lecturer.getId()));
    }

    private void remove(Lecturer lecturer) {
        LecturerList.remove(lecturer);
    }

    @FXML
    protected void viewAll() {
        var lecturers = LecturerList.getList();
        for (var lecturer : lecturers) {
            System.out.println(lecturer.getId());
            System.out.println(lecturer.getStaffId());
            System.out.println(lecturer.getName());
            System.out.println(lecturer.getPhone());
            System.out.println(lecturer.getEmail());
        }
        TableColumn<Lecturer, Lecturer> colAction = new TableColumn<>("Action");
        colAction.setMinWidth(50);
        colAction.setStyle("-fx-alignment: CENTER;");
        colAction.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue()));
        colAction.setCellFactory(param -> new TableCell<Lecturer, Lecturer>() {
            private final HBox hBox = new HBox();
            private final Button btnRemove = new Button("x");
            private final Button btnViewDetail = new Button("View");

            @Override
            protected void updateItem(Lecturer lecturer, boolean empty) {
                super.updateItem(lecturer, empty);

                if (lecturer == null) {
                    setGraphic(null);
                    return;
                }

                hBox.getChildren().clear();

                hBox.setSpacing(5);
                hBox.setAlignment(Pos.CENTER);
                hBox.getChildren().add(btnRemove);
                hBox.getChildren().add(btnViewDetail);

                setGraphic(hBox);

                btnRemove.setOnAction(event -> remove(lecturer));
                btnViewDetail.setOnAction(event -> viewDetail(lecturer));
            }
        });

        TableColumn<Lecturer, String> colId = new TableColumn<>("ID");
        colId.setMinWidth(50);
        colId.setStyle("-fx-alignment: CENTER;");
        colId.setCellValueFactory(new PropertyValueFactory<>("Id"));

        TableColumn<Lecturer, String> colName = new TableColumn<>("Name");
        colName.setMinWidth(150);
        colName.setStyle("-fx-alignment: CENTER;");
        colName.setCellValueFactory(new PropertyValueFactory<>("Name"));

        TableColumn<Lecturer, String> colStaffId = new TableColumn<>("Staff ID");
        colName.setMinWidth(100);
        colName.setStyle("-fx-alignment: CENTER;");
        colName.setCellValueFactory(new PropertyValueFactory<>("StaffId"));

        listTable.setItems(LecturerList.getList());
        listTable.getColumns().addAll(colAction, colId, colName, colStaffId);
    }
}