package com.example.lab_06_solution;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;

public class E5Controller {
    @FXML
    private Label label;

    @FXML
    private Circle circle;

    @FXML
    protected void mouseMove(MouseEvent e) {
        double xOfMouse = e.getSceneX();
        double yOfMouse = e.getSceneY();

        double xOfCircle = circle.getLayoutX();
        double yOfCircle = circle.getLayoutY();

        double a = xOfCircle - xOfMouse;
        double b = yOfCircle - yOfMouse;

        double a2 = Math.pow(a, 2);
        double b2 = Math.pow(b, 2);
        double c2 = a2 + b2;

        double distance = Math.sqrt(c2);

        if (distance <= circle.getRadius()) {
            label.setText("Inside");
        }
        else {
            label.setText("Outside");
        }

        label.setLayoutX(xOfMouse + 5);
        label.setLayoutY(yOfMouse - 10);
    }
}