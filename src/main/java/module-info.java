module com.example.getscraped {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.jsoup;

    opens com.example.getscraped to javafx.fxml;
    exports com.example.getscraped;
}