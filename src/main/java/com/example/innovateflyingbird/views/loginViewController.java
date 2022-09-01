
    package com.example.innovateflyingbird.views;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

    public class loginViewController {

        @FXML
        private Button loginConfirm;

        @FXML
        private TextField userId;

        @FXML
        private TextField userPwd;

        @FXML
        void loginConfirmBtn(ActionEvent event) {
            Stage gaming=new Stage();
            try {
                AnchorPane anchorPane= FXMLLoader.load(this.getClass().getResource("gamingView.fxml"));
                Scene scene=new Scene(anchorPane);
                gaming.setScene(scene);
                gaming.show();
            } catch (IOException e) {
                e.printStackTrace();
            }



        }
        }




