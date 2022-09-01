package com.example.innovateflyingbird.util;

import java.sql.*;

public class ConnectionUtil {
    public static Connection getConnection(){
        Connection cn =null;
        String url="jdbc:mysql://localhost:3306/InnovateFlyingBirdUsers";
        String userName ="root";
        String password="tassadarwty2003";
        try{
            //加载驱动类
            Class.forName("com.mysql.cj.jdbc.Driver");
            cn=DriverManager.getConnection(url,userName,password);
        }catch(ClassNotFoundException e){
            e.printStackTrace();

        } catch (SQLException e) {
            e.printStackTrace();
        }
return cn;

    }

    public static void main(String[] args) throws ClassNotFoundException {
        getConnection();
    }
}
