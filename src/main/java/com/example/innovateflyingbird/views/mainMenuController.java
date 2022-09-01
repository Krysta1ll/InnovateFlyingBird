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

public class mainMenuController {

    @FXML
    private Button exitBtn;

    @FXML
    private ImageView gameLogo;

    @FXML
    private Button loginBtn;

    @FXML
    private AnchorPane mainMenu;

    @FXML
    private Button regBtn;

    @FXML
    void exitButton(ActionEvent event) {                     //关闭按钮
         Stage stage=(Stage) exitBtn.getScene().getWindow();
         stage.close();

    }

    @FXML
    void loginButton(ActionEvent event) {                        //登录按钮
        Stage loginStage=new Stage();
        try {
            AnchorPane anchorPane= FXMLLoader.load(this.getClass().getResource("loginView.fxml"));
            Scene scene=new Scene(anchorPane);
            loginStage.setScene(scene);
            loginStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void regButton(ActionEvent event) {
       Stage regStage=new Stage();
        try {
            AnchorPane anchorPane= FXMLLoader.load(this.getClass().getResource("regView.fxml"));
            Scene scene=new Scene(anchorPane);
            regStage.setScene(scene);
            regStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }



    }

}
