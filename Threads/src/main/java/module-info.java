module org.example.threads {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.threads to javafx.fxml;
    exports org.example.threads;
}