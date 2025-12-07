package org.example.cardsassignment;

/*
Cannon Rivera
JavaFX Cards Assignment
This Program displays 4 random cards from
52 cards(full deck) and has the ability to refresh
and display 4 new cards.
 */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class AssignmentCards extends Application {

    private static final int deckamount = 52;
    private static final int cards = 4;

    private final ImageView[] cardViews = new ImageView[cards];

    @Override
    public void start(Stage primaryStage) {

        HBox pane = new HBox(10);

        //creates 4 ImageViews for cards
        for (int i = 0; i < cards; i++) {
            ImageView view = new ImageView();
            cardViews[i] = view;
            pane.getChildren().add(view);
        }

        //refreshbutton
        Button refreshButton = new Button("Refresh Cards");
        refreshButton.setTextFill(Color.RED);

        refreshButton.setOnAction(e -> showRandomCards());

        StackPane buttonPane = new StackPane(refreshButton);

        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(pane);
        borderPane.setBottom(buttonPane);

        //Scene
        Scene scene = new Scene(borderPane, 500, 250);
        primaryStage.setTitle("Random Card Display");
        primaryStage.setScene(scene);
        primaryStage.show();

        //Creates first 4 cards
        showRandomCards();
    }

    private void showRandomCards() {
        //Makes a list of 1-52
        List<Integer> deck = new ArrayList<>();
        for (int i = 1; i <= deckamount; i++) {
            deck.add(i);
        }
        //Shuffles list of 1-52
        Collections.shuffle(deck);

        //Gets images and sets image into the pane
        for (int i = 0; i < cards; i++) {
            //grabs number
            int cardNumber = deck.get(i);
            //finds image
            String path =
                    "/org/example/cardsassignment/AssignmentCards/" + cardNumber + ".png";

            //sets image
            Image img = new Image(
                    Objects.requireNonNull(getClass().getResource(path)).toString());


            //puts it in an imageView
            cardViews[i].setImage(img);
        }
    }

    //launches program
    public static void main(String[] args) {
        launch(args);
    }
}
