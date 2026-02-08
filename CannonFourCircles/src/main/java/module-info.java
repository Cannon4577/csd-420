module org.example.cannonfourcircles {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.junit.jupiter.api;


    opens org.example.cannonfourcircles to javafx.fxml;
    exports org.example.cannonfourcircles;
}