package com.example.lab_05_solution;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class E2Controller {
    @FXML
    private Pane pane;

    @FXML
    private Circle circle;

    @FXML
    private Circle newCircle;

    @FXML
    protected void btnLeftClick() {
        moveCircleHorizontally(-2);
    }

    @FXML
    protected void btnRightClick() {
        moveCircleHorizontally(2);
    }

    @FXML
    protected void btnUpClick() {
        moveCircleVertically(-2);
    }

    @FXML
    protected void btnDownClick() {
        moveCircleVertically(2);
    }

    @FXML
    protected void keyPress(KeyEvent ke) {
        switch (ke.getCode()) {
            case W: moveCircleVertically(-2); break;
            case S: moveCircleVertically(2); break;
            case A: moveCircleHorizontally(-2); break;
            case D: moveCircleHorizontally(2); break;
        }
    }

    private void moveCircleHorizontally(int moveStep) {
        double circleNewPosition = (circle.getLayoutX() + moveStep);

        double leftEdgeOfPane = pane.getLayoutX();
        double rightEdgeOfPane = leftEdgeOfPane + pane.getWidth();
        double leftEdgeOfCircle = circleNewPosition - circle.getRadius();
        double rightEdgeOfCircle = circleNewPosition + circle.getRadius();

        circle.setLayoutX(circleNewPosition);
        newCircle.setLayoutX(circle.getLayoutX());

        if (leftEdgeOfCircle < leftEdgeOfPane) {
            double extra = leftEdgeOfPane - leftEdgeOfCircle;
            double xOfNewCircle = (rightEdgeOfPane - extra) + circle.getRadius();

            newCircle.setLayoutX(xOfNewCircle);

            if (xOfNewCircle + circle.getRadius() <= rightEdgeOfPane) {
                circle.setLayoutX(xOfNewCircle);
            }

            return;
        }

        if (rightEdgeOfPane < rightEdgeOfCircle) {
            double extra = rightEdgeOfCircle - rightEdgeOfPane;
            double xOfNewCircle = (leftEdgeOfPane + extra) - circle.getRadius();

            newCircle.setLayoutX(xOfNewCircle);

            if (xOfNewCircle - circle.getRadius() >= leftEdgeOfPane) {
                circle.setLayoutX(xOfNewCircle);
            }

            return;
        }
    }

    private void moveCircleVertically(int moveStep) {
        double circleNewPosition = circle.getLayoutY() + moveStep;

        double topEdgeOfPane = pane.getLayoutY();
        double bottomEdgeOfPane = topEdgeOfPane + pane.getHeight();
        double topEdgeOfCircle = circleNewPosition - circle.getRadius();
        double bottomEdgeOfCircle = circleNewPosition + circle.getRadius();

        circle.setLayoutY(circleNewPosition);
        newCircle.setLayoutY(circle.getLayoutY());

        if (topEdgeOfCircle < topEdgeOfPane) {
            double extra = topEdgeOfPane - topEdgeOfCircle;
            double yOfNewCircle = bottomEdgeOfPane - extra + circle.getRadius();

            newCircle.setLayoutY(yOfNewCircle);

            if (yOfNewCircle + circle.getRadius() <= bottomEdgeOfPane) {
                circle.setLayoutY(yOfNewCircle);
            }

            return;
        }

        if (bottomEdgeOfPane < bottomEdgeOfCircle) {
            double extra = bottomEdgeOfCircle - bottomEdgeOfPane;
            double yOfNewCircle = (topEdgeOfPane + extra) - circle.getRadius();

            newCircle.setLayoutY(yOfNewCircle);

            if (yOfNewCircle - circle.getRadius() >= topEdgeOfPane) {
                circle.setLayoutY(yOfNewCircle);
            }

            return;
        }
    }
}