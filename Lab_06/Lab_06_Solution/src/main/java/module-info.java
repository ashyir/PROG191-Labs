module com.example.lab_06_solution {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.lab_06_solution to javafx.fxml;
    exports com.example.lab_06_solution;
}