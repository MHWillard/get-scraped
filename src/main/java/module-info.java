module com.example.getscraped {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.getscraped to javafx.fxml;
    exports com.example.getscraped;
}