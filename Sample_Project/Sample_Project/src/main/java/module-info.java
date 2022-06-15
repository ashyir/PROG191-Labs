module com.example.sample_project {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.sample_project to javafx.fxml;
    exports com.example.sample_project;
}