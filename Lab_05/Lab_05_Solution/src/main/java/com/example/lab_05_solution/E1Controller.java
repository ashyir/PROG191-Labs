package com.example.lab_05_solution;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;

public class E1Controller {
    private static final int _SIZE_DIFF = 5;

    @FXML
    private Pane pane;

    @FXML
    private Circle circle;

    @FXML
    private Button btnShrink;

    @FXML
    private Button btnEnlarge;

    @FXML
    protected void btnEnlargeClick() {
        double circleSize = circle.getRadius() + _SIZE_DIFF;

        if (circleSize * 2 < pane.getHeight()) {
            circle.setRadius(circleSize);
            btnShrink.setDisable(false);

            return;
        }

        btnEnlarge.setDisable(true);
    }

    @FXML
    protected void btnShrinkClick() {
        double circleSize = circle.getRadius() - _SIZE_DIFF;

        if (circleSize > 0) {
            circle.setRadius(circleSize);
            btnEnlarge.setDisable(false);

            return;
        }

        btnShrink.setDisable(true);
    }
}