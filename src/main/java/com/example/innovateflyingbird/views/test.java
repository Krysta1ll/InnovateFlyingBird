package com.example.innovateflyingbird.views;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class test extends Application {
    public void start(Stage stage) throws IOException {
        AnchorPane anchorPane= FXMLLoader.load(this.getClass().getResource("Ranking.fxml"));
        Scene scene = new Scene(anchorPane);

        stage.setTitle("InnovateFlyingBird登录器");//设置游戏标题




        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
