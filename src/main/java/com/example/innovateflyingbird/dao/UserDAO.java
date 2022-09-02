package com.example.innovateflyingbird.dao;

import com.example.innovateflyingbird.util.ConnectionUtil;

import java.sql.*;

public class UserDAO {
    public  int addUser(String email,String userName,String password){
        Connection cn= ConnectionUtil.getConnection();
        String sql="insert into userInform(email,userName,userPwd) values('"+email+"','"+userName+"','"+password+"') ";
        int n=-1;
        PreparedStatement pstmt=null;
        try {
            pstmt=cn.prepareStatement(sql);
            n=pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
finally {
            if(cn!=null){
                try {
                    cn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return n;
    }


    public boolean loginUser(String userName,String password){
        boolean isValid=false;
        Connection cn= ConnectionUtil.getConnection();
        String sql="select * from userInform where userName='"+userName+"' and userPwd='"+password+"'";


        try {
            Statement stm = cn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            if(rs.next()){
                isValid = true;
                System.out.println(isValid);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(isValid){      //判断用户名以及密码是否与设定相符
            return true;
        }
        else return false;


    }

}
