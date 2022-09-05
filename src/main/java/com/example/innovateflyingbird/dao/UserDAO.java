package com.example.innovateflyingbird.dao;

import com.example.innovateflyingbird.util.ConnectionUtil;

import java.sql.*;

public class UserDAO {



    public  int addUser(String email,String userName,String password){     //用户注册函数
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

    public int highScore(int score,String userName){         //更新最高分
        Connection cn= ConnectionUtil.getConnection();
        String sql="update userInform set highestScore="+score+" where userName='"+userName+"'";
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

    public int getInfo(String userName,String info){       //查询并返回数据
     Connection cn=ConnectionUtil.getConnection();
        Statement pstmt=null;
        try {
            pstmt=cn.createStatement();
            String sql;
            sql = "SELECT "+info+" FROM userInform where userName='"+userName+"'";
            ResultSet rs = pstmt.executeQuery(sql);
            while (rs.next()){
                String ans=rs.getString(info);
         System.out.println(ans);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

return 0;
    }

    public void getInfo_rank(String type,String []results) {
        Connection cn = ConnectionUtil.getConnection();
        Statement pstmt = null;
        int i=0;
        try {
            pstmt = cn.createStatement();
            String sql;
            sql = "select * from userInform order by highestScore DESC";
            ResultSet rs = pstmt.executeQuery(sql);

            while (rs.next()) {
                String result = rs.getString(type);
                results[i]=result;
                i++;
                System.out.println(result);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }



    public boolean loginUser(String userName,String password){      //用户登录函数
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

