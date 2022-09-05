
    package com.example.innovateflyingbird.views;

import com.example.innovateflyingbird.dao.UserDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
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
         String user,password;
         user=userId.getText();
         password=userPwd.getText();
         UserDAO userDAO=new UserDAO();

         if(userDAO.loginUser(user,password)) {

             Stage gaming = new Stage();
             try {
                 AnchorPane anchorPane = FXMLLoader.load(this.getClass().getResource("gamingView.fxml"));
                 Scene scene = new Scene(anchorPane);
                 gaming.setScene(scene);
                 gaming.setTitle("InnovateFlyingBird(线上)");
                 gaming.show();
             } catch (IOException e) {
                 e.printStackTrace();
             }
         }else{
             Alert alert =new Alert(Alert.AlertType.ERROR);
             alert.setContentText("用戶名或密碼錯誤或用户不存在");
             alert.show();
             return;
         }
            Alert alert =new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("登录成功");
            alert.show();
            Stage stage=(Stage) loginConfirm.getScene().getWindow();
            stage.close();


        }
        }




