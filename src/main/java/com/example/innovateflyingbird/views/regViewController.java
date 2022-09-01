package com.example.innovateflyingbird.views;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
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

        if(password.equals(confirmPassword)){

           System.out.println("success!");
       }

System.out.println(password);
    }


}
