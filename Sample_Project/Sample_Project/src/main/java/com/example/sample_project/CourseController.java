package com.example.sample_project;

import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class CourseController implements Initializable {
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
        var course = new Course(0, txtName.getText());
        CourseList.add(course);
    }

    @FXML
    protected void viewAll() {
        TableColumn<Course, Course> colAction = new TableColumn<>("Action");
        colAction.setMinWidth(50);
        colAction.setStyle("-fx-alignment: CENTER;");
        colAction.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue()));
        colAction.setCellFactory(param -> new TableCell<Course, Course>() {
            private final Button btnRemove = new Button("Remove");

            @Override
            protected void updateItem(Course course, boolean empty) {
                super.updateItem(course, empty);

                if (course == null) {
                    setGraphic(null);
                    return;
                }

                setGraphic(btnRemove);
                btnRemove.setOnAction(event -> CourseList.remove(course));
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