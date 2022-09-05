package com.example.innovateflyingbird.views;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class gamingViewController {

    @FXML
    private Button exitBtn;

    @FXML
    private ImageView gameLogo;

    @FXML
    private Button gameStartBtn;

    @FXML
    private AnchorPane mainMenu;

    @FXML
    void exitButton(ActionEvent event) {
        Stage stage=(Stage) exitBtn.getScene().getWindow();
        stage.close();

    }

    @FXML
    void gameStart(ActionEvent event) {

    }

    @FXML
    void rankingList(ActionEvent event) {
        Stage regStage=new Stage();
        try {
            AnchorPane anchorPane= FXMLLoader.load(this.getClass().getResource("Ranking.fxml"));
            Scene scene=new Scene(anchorPane);
            regStage.setScene(scene);
            regStage.setTitle("注册");
            regStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
