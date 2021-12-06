package com.example.dragdot;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;
import javafx.geometry.Point2D;
import javafx.scene.paint.Paint;
import java.awt.MouseInfo;

import java.io.IOException;

public class HelloApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        double x = 180; double y = 180;

        Circle circle = new Circle(x, y, 80);
        circle.setStroke(Color.BLACK);
        circle.setFill(Color.WHITE);

        Circle dot = new Circle(260, y, 20);
        dot.setFill(Color.YELLOW);

        dot.setOnMouseDragged((MouseEvent z) -> {
            Point2D circleCenter = new Point2D(circle.getCenterX(), circle.getCenterY());
            Point2D mouse = new Point2D(z.getX(), z.getY());
            Point2D toMouse = mouse.subtract(circleCenter);
            Point2D newPlaceCenter = toMouse.normalize().multiply(circle.getRadius());
            Point2D newPlace = newPlaceCenter.add(circleCenter);
            dot.setCenterY(newPlace.getY());
            dot.setCenterX(newPlace.getX());

            double z1 = ((dot.getCenterX() - 100)/(260 - 100));
            double z2 = ((dot.getCenterY() - 100)/(260 - 100));

            //Tried getting the third variable (z3) to change relative to the cursor's distance from the center of the circle, in order to
            //implement all colors. The code below causes slight errors, so it is omitted from the final program.

            /*double z3;
            if(MouseInfo.getPointerInfo().getLocation().y > 255 || MouseInfo.getPointerInfo().getLocation().x > 255)
            {
                z3 = 1;
            }
            else{
            double parsedX = (MouseInfo.getPointerInfo().getLocation().x);
            double parsedY = (MouseInfo.getPointerInfo().getLocation().y);
            z3 = Math.sqrt(Math.pow(parsedY - 180.0, 2) + Math.pow(160.0 - parsedX, 2))/1000;
            }
            dot.setFill(Color.color(dot.getCenterX()/1000, dot.getCenterY()/1000, Math.random()/1000));*/

            dot.setFill(Color.color(z1, z2, 0));
        });

        Pane pane = new Pane();
        pane.getChildren().addAll(circle, dot);

        Scene scene = new Scene(pane, 360, 360);
        stage.setTitle("Dragging Dot Program");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}