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

public class CourseController implements Initializable {
    @FXML
    private Label lblId;

    @FXML
    private TableView listTable;

    @FXML
    private TextField txtCode;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtHour;

    @FXML
    private TextField txtCredit;

    @FXML
    private TextField txtProgramId;

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
        txtCode.setText("");
        txtName.setText("");
        txtHour.setText("");
        txtCredit.setText("");
        txtProgramId.setText("");
    }

    @FXML
    protected void add() {
        if (btnAdd.getText().equals("Add")) {
            var course = new Course(0,
                    txtCode.getText(),
                    txtName.getText(),
                    Integer.parseInt(txtHour.getText()),
                    Integer.parseInt(txtCredit.getText()),
                    Integer.parseInt(txtProgramId.getText()));

            CourseList.add(course);

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
        var course = new Course(id,
                txtCode.getText(),
                txtName.getText(),
                Integer.parseInt(txtHour.getText()),
                Integer.parseInt(txtCredit.getText()),
                Integer.parseInt(txtProgramId.getText()));

        CourseList.edit(id, course);

        clearTextView();

        btnAdd.setText("Add");
        btnEdit.setDisable(true);
    }

    private void viewDetail(Course course) {
        txtCode.setText(course.getCode());
        txtName.setText(course.getName());
        txtCredit.setText(String.valueOf(course.getCredit()));
        txtHour.setText(String.valueOf(course.getHour()));
        txtProgramId.setText(String.valueOf(course.getProgramId()));

        btnAdd.setText("Cancel");
        btnEdit.setDisable(false);

        // For editting.
        lblId.setText(String.valueOf(course.getId()));
    }

    private void remove(Course course) {
        CourseList.remove(course);
    }

    @FXML
    protected void viewAll() {
        TableColumn<Course, Course> colAction = new TableColumn<>("Action");
        colAction.setMinWidth(50);
        colAction.setStyle("-fx-alignment: CENTER;");
        colAction.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue()));
        colAction.setCellFactory(param -> new TableCell<Course, Course>() {
            private final HBox hBox = new HBox();
            private final Button btnRemove = new Button("x");
            private final Button btnViewDetail = new Button("View");

            @Override
            protected void updateItem(Course course, boolean empty) {
                super.updateItem(course, empty);

                if (course == null) {
                    setGraphic(null);
                    return;
                }

                hBox.getChildren().clear();

                hBox.setSpacing(5);
                hBox.setAlignment(Pos.CENTER);
                hBox.getChildren().add(btnRemove);
                hBox.getChildren().add(btnViewDetail);

                setGraphic(hBox);

                btnRemove.setOnAction(event -> remove(course));
                btnViewDetail.setOnAction(event -> viewDetail(course));
            }
        });

        TableColumn<Course, String> colId = new TableColumn<>("ID");
        colId.setMinWidth(50);
        colId.setStyle("-fx-alignment: CENTER;");
        colId.setCellValueFactory(new PropertyValueFactory<>("Id"));

        TableColumn<Course, String> colCode = new TableColumn<>("Code");
        colCode.setMinWidth(100);
        colCode.setStyle("-fx-alignment: CENTER;");
        colCode.setCellValueFactory(new PropertyValueFactory<>("Code"));

        TableColumn<Course, String> colName = new TableColumn<>("Name");
        colName.setMinWidth(150);
        colName.setStyle("-fx-alignment: CENTER;");
        colName.setCellValueFactory(new PropertyValueFactory<>("Name"));

        listTable.setItems(CourseList.getList());
        listTable.getColumns().addAll(colAction, colId, colCode, colName);
    }
}