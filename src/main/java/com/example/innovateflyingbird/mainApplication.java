package com.example.innovateflyingbird;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class mainApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        AnchorPane anchorPane=FXMLLoader.load(this.getClass().getResource("views/mainMenu.fxml"));
        Scene scene = new Scene(anchorPane);
        scene.getStylesheets().addAll(this.getClass().getResource("views/style.css").toExternalForm());
        stage.setTitle("InnovateFlyingBird");//设置游戏标题




        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}