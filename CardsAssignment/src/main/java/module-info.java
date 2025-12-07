module org.example.cardsassignment {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.cardsassignment to javafx.fxml;
    exports org.example.cardsassignment;
}