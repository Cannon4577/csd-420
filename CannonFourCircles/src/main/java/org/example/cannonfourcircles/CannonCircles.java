package org.example.cannonfourcircles;

//Cannon Rivera
//2/8/2026
//CSD420-T301 Advanced Java Programming
//The Purpose of this program is to create 4 circles
// and style then white with black, red, and green


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class CannonCircles extends Application {

    @Override
    public void start(Stage stage) {
        Pane root = new Pane();
        root.setPrefSize(320, 320);

        // 4 circles
        Circle c1 = new Circle(90, 90, 55);
        Circle c2 = new Circle(230, 90, 55);
        Circle c3 = new Circle(90, 230, 55);
        Circle c4 = new Circle(230, 230, 55);

        c1.getStyleClass().add("plaincircle");
        c2.getStyleClass().add("plaincircle");
        c3.getStyleClass().add("plaincircle");
        c4.getStyleClass().add("plaincircle");

        c2.setId("redcircle");
        c3.setId("greencircle");

        root.getChildren().addAll(c1, c2, c3, c4);

        Scene scene = new Scene(root);

        var css = CannonCircles.class.getResource("mystyle.css");
        assert css != null;
        scene.getStylesheets().add(css.toExternalForm());


        stage.setTitle("Four Circles");
        stage.setScene(scene);
        stage.show();

        root.applyCss();
        root.layout();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
