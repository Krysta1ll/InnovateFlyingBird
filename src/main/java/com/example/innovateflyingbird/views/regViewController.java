package com.example.innovateflyingbird.views;

import com.example.innovateflyingbird.dao.UserDAO;
import com.example.innovateflyingbird.format.emailFormat;
import com.example.innovateflyingbird.format.passwordFormat;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.*;
public class regViewController {

    public static Connection sqlConn;

    @FXML
    private PasswordField confirmPwd;

    @FXML
    private Button regConfirm;

    @FXML
    private TextField userEmail;

    @FXML
    private TextField userName;

    @FXML
    private PasswordField userPwd;
    @FXML
    void regConfirmBtn(ActionEvent event) {


        String password,confirmPassword,email,user;

       password=userPwd.getText();              //密码字符串
       confirmPassword=confirmPwd.getText();    //密码确认
       email=userEmail.getText();               //用户邮箱
       user=userName.getText();                 //用户名

        if(!emailFormat.isEmail(email)){         //检测邮箱格式
            Alert emailAlert =new Alert(Alert.AlertType.ERROR);
            emailAlert.setContentText("邮箱信息错误");
            emailAlert.show();
            return;
        }

        if(!password.equals(confirmPassword)){

            Alert alert =new Alert(Alert.AlertType.ERROR);
            alert.setContentText("两次密码输入不同");
            alert.show();
            return;
       }

        if(!passwordFormat.validatePassword(password)){
            Alert alert =new Alert(Alert.AlertType.ERROR);
            alert.setContentText("密码至少需要一个大写字母，数字，特殊符号");
            alert.show();
            return;


        }

        UserDAO userDAO=new UserDAO();
        int i=userDAO.addUser(email,user,confirmPassword);
        if(i!=-1){
            System.out.println("success,registered");
            Alert alert =new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("注册成功");
            alert.show();
            Stage stage=(Stage) regConfirm.getScene().getWindow();
            stage.close();

        }

    }


}
