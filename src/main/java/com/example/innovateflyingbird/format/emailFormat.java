package com.example.innovateflyingbird.format;

public class emailFormat {
    public static boolean isEmail(String str) {


        String tegex="[a-zA-Z0-9_]+@\\w+(\\.com|\\.cn){1}";
        boolean flag=str.matches(tegex);
        return flag;
    }

}
