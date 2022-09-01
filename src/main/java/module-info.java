module com.example.innovateflyingbird {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.innovateflyingbird to javafx.fxml;
    opens com.example.innovateflyingbird.views to javafx.fxml;




    exports com.example.innovateflyingbird;
    exports com.example.innovateflyingbird.views;
}