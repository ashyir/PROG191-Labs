module com.example.sample_project {
    requires javafx.controls;
    requires javafx.fxml;

    opens PROG191.sample_project to javafx.fxml;
    exports PROG191.sample_project;
    exports PROG191.sample_project.models;
    opens PROG191.sample_project.models to javafx.fxml;
    exports PROG191.sample_project.controllers.admin;
    opens PROG191.sample_project.controllers.admin to javafx.fxml;
    exports PROG191.sample_project.controllers.lecturer;
    opens PROG191.sample_project.controllers.lecturer to javafx.fxml;
    exports PROG191.sample_project.controllers;
    opens PROG191.sample_project.controllers to javafx.fxml;
    exports PROG191.sample_project.data;
    opens PROG191.sample_project.data to javafx.fxml;
}