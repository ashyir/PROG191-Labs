package PROG191.sample_project.controllers.admin;

import PROG191.sample_project.data.ProgramList;
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

public class ProgramController implements Initializable {
    @FXML
    private Label lblId;

    @FXML
    private TableView listTable;

    @FXML
    private TextField addName, searchName;

    @FXML
    private Button btnAdd, btnEdit;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        viewAll();
    }

    private void clearInput() {
        addName.setText("");
    }

    @FXML
    protected void addEnter(KeyEvent ke) {
        if (ke.getCode() == KeyCode.ENTER)
            add();
    }

    @FXML
    protected void add() {
        if (btnAdd.getText().equals("Add")) {
            var program = new Program(0, addName.getText());
            ProgramList.add(program);
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
        var program = new Program(id, addName.getText());

        ProgramList.edit(program);

        resetForm();
    }

    private void viewDetail(Program program) {
        addName.setText(program.getName());

        btnAdd.setText("Cancel");
        btnEdit.setDisable(false);

        // For editing.
        lblId.setText(String.valueOf(program.getId()));
    }

    private void remove(Program program) {
        ProgramList.remove(program.getId());
        clearInput();
    }

    @FXML
    protected void viewAll() {
        TableColumn<Program, Program> col_1 = new TableColumn<>("Action");
        col_1.setMinWidth(50);
        col_1.setStyle("-fx-alignment: CENTER;");
        col_1.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue()));
        col_1.setCellFactory(param -> new TableCell<Program, Program>() {
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

        TableColumn<Program, String> col_2 = new TableColumn<>("ID");
        col_2.setMinWidth(50);
        col_2.setStyle("-fx-alignment: CENTER;");
        col_2.setCellValueFactory(new PropertyValueFactory<>("Id"));

        TableColumn<Program, String> col_3 = new TableColumn<>("Name");
        col_3.setMinWidth(150);
        col_3.setStyle("-fx-alignment: CENTER;");
        col_3.setCellValueFactory(new PropertyValueFactory<>("Name"));

        listTable.setItems(ProgramList.getList());
        listTable.getColumns().addAll(col_1, col_2, col_3);
    }
}