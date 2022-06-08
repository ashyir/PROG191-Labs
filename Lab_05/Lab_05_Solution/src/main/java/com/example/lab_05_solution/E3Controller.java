package com.example.lab_05_solution;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;

public class E3Controller {
    @FXML
    private Line line;

    @FXML
    private Label label;

    @FXML
    private Circle circle_1;

    @FXML
    private Circle circle_2;

    private double mouseStartX, mouseStartY;

    @FXML
    protected void setMouseStartingPoint(MouseEvent e) {
        mouseStartX = e.getSceneX();
        mouseStartY = e.getSceneY();
    }

    @FXML
    protected void moveCircle1(MouseEvent e) {
        // Get distance of mouse from its starting point.
        double offsetX = e.getSceneX() - mouseStartX;
        double offsetY = e.getSceneY() - mouseStartY;

        // Move circle.
        circle_1.setLayoutX(circle_1.getLayoutX() + offsetX);
        circle_1.setLayoutY(circle_1.getLayoutY() + offsetY);

        // Move line.
        line.setStartX(line.getStartX() + offsetX);
        line.setStartY(line.getStartY() + offsetY);

        moveLabel();

        // Set starting point for the next move.
        setMouseStartingPoint(e);
    }

    @FXML
    protected void moveCircle2(MouseEvent e) {
        // Get distance of mouse from its starting point.
        double offsetX = e.getSceneX() - mouseStartX;
        double offsetY = e.getSceneY() - mouseStartY;

        // Move circle.
        circle_2.setLayoutX(circle_2.getLayoutX() + offsetX);
        circle_2.setLayoutY(circle_2.getLayoutY() + offsetY);

        // Move line.
        line.setEndX(line.getEndX() + offsetX);
        line.setEndY(line.getEndY() + offsetY);

        moveLabel();

        // Set starting point for the next move.
        setMouseStartingPoint(e);
    }

    private void moveLabel() {
        // Calculate distance of two circles: c^2 = a^2 + b^2.
        double a = line.getStartX() - line.getEndX();
        double b = line.getStartY() - line.getEndY();
        double distance = Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));

        // Move distance label.
        label.setText(String.valueOf(distance));

        double xOfLabel = Math.abs(circle_1.getLayoutX() - circle_2.getLayoutX()) / 2;
        double yOfLabel = Math.abs(circle_1.getLayoutY() - circle_2.getLayoutY()) / 2;

        xOfLabel += circle_1.getLayoutX() < circle_2.getLayoutX() ? circle_1.getLayoutX() : circle_2.getLayoutX();
        yOfLabel += circle_1.getLayoutY() < circle_2.getLayoutY() ? circle_1.getLayoutY() : circle_2.getLayoutY();

        label.setLayoutX(xOfLabel);
        label.setLayoutY(yOfLabel);
    }
}