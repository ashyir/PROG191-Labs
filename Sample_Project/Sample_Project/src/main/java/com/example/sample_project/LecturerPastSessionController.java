package com.example.sample_project;

import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class LecturerPastSessionController implements Initializable {
    @FXML
    private TableView listTable;

    @FXML
    private TextField searchCode;

    @FXML
    private TextField addCode;

    @FXML
    private DatePicker addStartDate;

    @FXML
    private DatePicker addEndDate;

    @FXML
    private ComboBox addSemester;

    @FXML
    private ComboBox addYear;

    @FXML
    private ComboBox addLecturer;

    @FXML
    private ComboBox addCourse;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        viewAll();
    }

    private void viewDetail(Session session) {
        var lecturer = UserList.find(session.getLecturerId());
        var course = CourseList.find(session.getCourseId());

        addCode.setText(session.getCode());
        addStartDate.setValue(session.getStartDate());
        addEndDate.setValue(session.getEndDate());
        addSemester.setValue(session.getSemester());
        addYear.setValue(session.getYear());
        addLecturer.setValue(lecturer);
        addCourse.setValue(course);
    }

    @FXML
    protected void viewAll() {
        TableColumn<Session, Session> col_1 = new TableColumn<>("Action");
        col_1.setMinWidth(50);
        col_1.setStyle("-fx-alignment: CENTER;");
        col_1.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue()));
        col_1.setCellFactory(param -> new TableCell<Session, Session>() {
            private final HBox hBox = new HBox();
            private final Button btnViewDetail = new Button("View");

            @Override
            protected void updateItem(Session session, boolean empty) {
                super.updateItem(session, empty);

                if (session == null) {
                    setGraphic(null);
                    return;
                }

                hBox.getChildren().clear();

                hBox.setSpacing(5);
                hBox.setAlignment(Pos.CENTER);
                hBox.getChildren().add(btnViewDetail);

                setGraphic(hBox);

                btnViewDetail.setOnAction(event -> viewDetail(session));
            }
        });

        TableColumn<Session, String> col_2 = new TableColumn<>("ID");
        col_2.setMinWidth(50);
        col_2.setStyle("-fx-alignment: CENTER;");
        col_2.setCellValueFactory(new PropertyValueFactory<>("Id"));

        TableColumn<Session, String> col_3 = new TableColumn<>("Code");
        col_3.setMinWidth(150);
        col_3.setStyle("-fx-alignment: CENTER;");
        col_3.setCellValueFactory(new PropertyValueFactory<>("Code"));

        TableColumn<Session, String> col_4 = new TableColumn<>("Semester");
        col_4.setMinWidth(75);
        col_4.setStyle("-fx-alignment: CENTER;");
        col_4.setCellValueFactory(new PropertyValueFactory<>("Semester"));

        TableColumn<Session, String> col_5 = new TableColumn<>("Year");
        col_5.setMinWidth(75);
        col_5.setStyle("-fx-alignment: CENTER;");
        col_5.setCellValueFactory(new PropertyValueFactory<>("Year"));

        var sessions = SessionList.getList().filtered(s -> s.getEndDate().isBefore(LocalDate.now()));

        listTable.setItems(sessions);
        listTable.getColumns().addAll(col_1, col_2, col_3, col_4, col_5);
    }
}