package PROG191.sample_project.controllers.admin;

import PROG191.sample_project.data.UserList;
import PROG191.sample_project.models.Global;
import PROG191.sample_project.models.User;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import java.net.URL;
import java.security.NoSuchAlgorithmException;
import java.util.ResourceBundle;

public class UserController implements Initializable {
    @FXML
    private Label lblId;

    @FXML
    private TableView listTable;

    @FXML
    private TextField addUsername, addPassword, addName, addPhone, addEmail, addNumber, searchName;

    @FXML
    private ComboBox addRole;

    @FXML
    private Button btnAdd, btnEdit;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        viewAll();

        addRole.setItems(FXCollections.observableArrayList(Global.Role.values()));
        addRole.setValue(Global.Role.NONE);
    }

    private void clearInput() {
        addUsername.setText("");
        addPassword.setText("");
        addName.setText("");
        addPhone.setText("");
        addEmail.setText("");
        addNumber.setText("");
        addRole.setValue(Global.Role.NONE);
    }

    @FXML
    protected void addEnter(KeyEvent ke) throws NoSuchAlgorithmException {
        if (ke.getCode() == KeyCode.ENTER)
            add();
    }

    @FXML
    protected void add() throws NoSuchAlgorithmException {
        if (btnAdd.getText().equals("Add")) {
            User user = new User(0,
                    addUsername.getText(),
                    addPassword.getText(),
                    addName.getText(),
                    addPhone.getText(),
                    addEmail.getText(),
                    addNumber.getText(),
                    (Global.Role) addRole.getValue());

            UserList.add(user);

            clearInput();

            return;
        }

        resetForm();
    }

    private void resetForm() {
        clearInput();

        btnAdd.setText("Add");
        btnEdit.setDisable(true);
        addUsername.setDisable(false);
        addPassword.setDisable(false);
    }

    @FXML
    protected void edit() throws NoSuchAlgorithmException {
        var id = Integer.parseInt(lblId.getText());
        User user = new User(id,
                addUsername.getText(),
                addPassword.getText(),
                addName.getText(),
                addPhone.getText(),
                addEmail.getText(),
                addNumber.getText(),
                (Global.Role) addRole.getValue());

        UserList.edit(user);

        resetForm();
    }

    private void viewDetail(User user) {
        addUsername.setText(user.getUsername());
        addPassword.setText(user.getPassword());
        addName.setText(user.getName());
        addPhone.setText(user.getPhone());
        addEmail.setText(user.getEmail());
        addNumber.setText(user.getNumber());
        addRole.valueProperty().set(user.getRole());

        btnAdd.setText("Cancel");
        btnEdit.setDisable(false);
        addUsername.setDisable(true);
        addPassword.setDisable(true);

        // For editing.
        lblId.setText(String.valueOf(user.getId()));
    }

    private void remove(int id) {
        UserList.remove(id);
        clearInput();
    }

    @FXML
    protected void viewAll() {
        TableColumn<User, User> col_1 = new TableColumn<>("Action");
        col_1.setMinWidth(50);
        col_1.setStyle("-fx-alignment: CENTER;");
        col_1.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue()));
        col_1.setCellFactory(param -> new TableCell<User, User>() {
            private final HBox hBox = new HBox();
            private final Button btnRemove = new Button("x");
            private final Button btnViewDetail = new Button("View");

            @Override
            protected void updateItem(User user, boolean empty) {
                super.updateItem(user, empty);

                if (user == null) {
                    setGraphic(null);
                    return;
                }

                hBox.getChildren().clear();

                hBox.setSpacing(5);
                hBox.setAlignment(Pos.CENTER);
                hBox.getChildren().add(btnRemove);
                hBox.getChildren().add(btnViewDetail);

                setGraphic(hBox);

                btnRemove.setOnAction(event -> remove(user.getId()));
                btnViewDetail.setOnAction(event -> viewDetail(user));
            }
        });

        TableColumn<User, String> col_2 = new TableColumn<>("ID");
        col_2.setMinWidth(50);
        col_2.setStyle("-fx-alignment: CENTER;");
        col_2.setCellValueFactory(new PropertyValueFactory<>("Id"));

        TableColumn<User, String> col_3 = new TableColumn<>("Username");
        col_3.setMinWidth(150);
        col_3.setStyle("-fx-alignment: CENTER;");
        col_3.setCellValueFactory(new PropertyValueFactory<>("Username"));

        TableColumn<User, String> col_4 = new TableColumn<>("Name");
        col_4.setMinWidth(100);
        col_4.setStyle("-fx-alignment: CENTER;");
        col_4.setCellValueFactory(new PropertyValueFactory<>("Name"));

        listTable.setItems(UserList.getList());
        listTable.getColumns().addAll(col_1, col_2, col_3, col_4);
    }
}