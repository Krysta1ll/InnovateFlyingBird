module com.example.innovateflyingbird {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.innovateflyingbird to javafx.fxml;
    exports com.example.innovateflyingbird;
}