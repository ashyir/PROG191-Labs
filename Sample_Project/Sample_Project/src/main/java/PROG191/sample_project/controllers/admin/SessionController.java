package PROG191.sample_project.controllers.admin;

import PROG191.sample_project.data.CourseList;
import PROG191.sample_project.data.SessionList;
import PROG191.sample_project.data.UserList;
import PROG191.sample_project.models.Course;
import PROG191.sample_project.models.Global;
import PROG191.sample_project.models.Session;
import PROG191.sample_project.models.User;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import java.net.URL;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.ResourceBundle;

public class SessionController implements Initializable {
    @FXML
    private Label lblId;

    @FXML
    private TableView listTable;

    @FXML
    private TextField searchCode, addCode;

    @FXML
    private DatePicker addStartDate, addEndDate;

    @FXML
    private ComboBox addSemester, addYear, addLecturer, addCourse;

    @FXML
    private Button btnAdd, btnEdit;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        viewAll();

        ObservableList<Object> years = FXCollections.observableArrayList();

        var currentYear = Calendar.getInstance().get(Calendar.YEAR);
        var numberOfYear = currentYear + 5;

        for (int i = 1990; i < numberOfYear; ++i)
            years.add(i);

        addLecturer.setItems(UserList.getLecturers());
        addCourse.setItems(CourseList.getList());
        addSemester.setItems(FXCollections.observableArrayList(Global.Semester.values()));
        addSemester.setValue(Global.Semester.NONE);
        addYear.setItems(years);
        addYear.setValue(currentYear);
        addStartDate.setValue(LocalDate.now());
        addEndDate.setValue(LocalDate.now());
    }

    @FXML
    protected void addEnter(KeyEvent ke) {
        if (ke.getCode() == KeyCode.ENTER)
            add();
    }

    @FXML
    protected void add() {
        if (btnAdd.getText().equals("Add")) {
            var lecturer = (User) addLecturer.getValue();
            var course = (Course) addCourse.getValue();
            var session = new Session(0,
                    addCode.getText(),
                    addStartDate.getValue(),
                    addEndDate.getValue(),
                    (Global.Semester) addSemester.getValue(),
                    (int) addYear.getValue(),
                    lecturer.getId(),
                    course.getId()
            );

            SessionList.add(session);

            clearInput();

            return;
        }

        resetForm();
    }

    private void clearInput() {
        addCode.setText("");
        addStartDate.setValue(LocalDate.now());
        addEndDate.setValue(LocalDate.now());
        addLecturer.setValue(null);
        addCourse.setValue(null);
        addSemester.setValue(Global.Semester.NONE);
        addYear.setValue(Calendar.getInstance().get(Calendar.YEAR));
    }

    private void resetForm() {
        clearInput();

        btnAdd.setText("Add");
        btnEdit.setDisable(true);
    }

    @FXML
    protected void edit() {
        var id = Integer.parseInt(lblId.getText());
        var lecturer = (User) addLecturer.getValue();
        var course = (Course) addCourse.getValue();
        var session = new Session(id,
                addCode.getText(),
                addStartDate.getValue(),
                addEndDate.getValue(),
                (Global.Semester) addSemester.getValue(),
                (int) addYear.getValue(),
                lecturer.getId(),
                course.getId()
        );

        SessionList.edit(session);

        resetForm();
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

        btnAdd.setText("Cancel");
        btnEdit.setDisable(false);

        // For editing.
        lblId.setText(String.valueOf(session.getId()));
    }

    private void remove(int id) {
        SessionList.remove(id);
        clearInput();
    }

    @FXML
    protected void viewAll() {
        TableColumn<Session, Session> col_1 = new TableColumn<>("Action");
        col_1.setMinWidth(50);
        col_1.setStyle("-fx-alignment: CENTER;");
        col_1.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue()));
        col_1.setCellFactory(param -> new TableCell<Session, Session>() {
            private final HBox hBox = new HBox();
            private final Button btnRemove = new Button("x");
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
                hBox.getChildren().add(btnRemove);
                hBox.getChildren().add(btnViewDetail);

                setGraphic(hBox);

                btnRemove.setOnAction(event -> remove(session.getId()));
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

        listTable.setItems(SessionList.getList());
        listTable.getColumns().addAll(col_1, col_2, col_3, col_4, col_5);
    }
}