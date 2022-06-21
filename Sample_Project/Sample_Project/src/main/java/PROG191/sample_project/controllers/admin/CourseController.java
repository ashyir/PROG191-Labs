package PROG191.sample_project.controllers.admin;

import PROG191.sample_project.data.CourseList;
import PROG191.sample_project.data.ProgramList;
import PROG191.sample_project.models.Course;
import PROG191.sample_project.models.Program;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import java.net.URL;
import java.util.ResourceBundle;

public class CourseController implements Initializable {
    @FXML
    private ComboBox addProgram;

    @FXML
    private Label lblId;

    @FXML
    private TableView listTable;

    @FXML
    private TextField addCode, addName, addHour, addCredit, searchCode;

    @FXML
    private Button btnAdd, btnEdit;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        viewAll();

        addProgram.setItems(ProgramList.getList());
    }

    private void clearInput() {
        addCode.setText("");
        addName.setText("");
        addHour.setText("");
        addCredit.setText("");
        addProgram.setValue(null);
    }

    @FXML
    protected void addEnter(KeyEvent ke) throws ClassNotFoundException {
        if (ke.getCode() == KeyCode.ENTER)
            add();
    }

    @FXML
    protected void add() throws ClassNotFoundException {
        if (btnAdd.getText().equals("Add")) {
            var program = (Program) addProgram.getValue();
            var course = new Course(0,
                    addCode.getText(),
                    addName.getText(),
                    Integer.parseInt(addHour.getText()),
                    Integer.parseInt(addCredit.getText()),
                    program.getId());

            CourseList.add(course);

            clearInput();

            return;
        }

        resetForm();
    }

    private void resetForm() {
        clearInput();

        btnAdd.setText("Add");
        btnEdit.setDisable(true);
    }

    @FXML
    protected void edit() {
        var id = Integer.parseInt(lblId.getText());
        var program = (Program) addProgram.getValue();
        var course = new Course(id,
                addCode.getText(),
                addName.getText(),
                Integer.parseInt(addHour.getText()),
                Integer.parseInt(addCredit.getText()),
                program.getId());

        CourseList.edit(course);

        resetForm();
    }

    private void viewDetail(Course course) {
        var program = ProgramList.find(course.getProgramId());
        addCode.setText(course.getCode());
        addName.setText(course.getName());
        addCredit.setText(String.valueOf(course.getCredit()));
        addHour.setText(String.valueOf(course.getHour()));
        addProgram.setValue(program);

        btnAdd.setText("Cancel");
        btnEdit.setDisable(false);

        // For editing.
        lblId.setText(String.valueOf(course.getId()));
    }

    private void remove(Course course) {
        CourseList.remove(course.getId());
        clearInput();
    }

    @FXML
    protected void viewAll() {
        TableColumn<Course, Course> col_1 = new TableColumn<>("Action");
        col_1.setMinWidth(50);
        col_1.setStyle("-fx-alignment: CENTER;");
        col_1.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue()));
        col_1.setCellFactory(param -> new TableCell<Course, Course>() {
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

        TableColumn<Course, String> col_2 = new TableColumn<>("ID");
        col_2.setMinWidth(50);
        col_2.setStyle("-fx-alignment: CENTER;");
        col_2.setCellValueFactory(new PropertyValueFactory<>("Id"));

        TableColumn<Course, String> col_3 = new TableColumn<>("Code");
        col_3.setMinWidth(100);
        col_3.setStyle("-fx-alignment: CENTER;");
        col_3.setCellValueFactory(new PropertyValueFactory<>("Code"));

        TableColumn<Course, String> col_4 = new TableColumn<>("Name");
        col_4.setMinWidth(150);
        col_4.setStyle("-fx-alignment: CENTER;");
        col_4.setCellValueFactory(new PropertyValueFactory<>("Name"));

        listTable.setItems(CourseList.getList());
        listTable.getColumns().addAll(col_1, col_2, col_3, col_4);
    }
}