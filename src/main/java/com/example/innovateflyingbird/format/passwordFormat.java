package com.example.innovateflyingbird.format;

import java.util.regex.Pattern;

public class passwordFormat {
    public static boolean validatePassword(String password) {
        return Pattern.compile("[0-9]+").matcher(password).find() &&
                Pattern.compile("[a-z]+").matcher(password).find() &&
                Pattern.compile("[A-Z]+").matcher(password).find() &&
                Pattern.compile("[\\p{Punct}]+").matcher(password).find() &&
                !Pattern.compile("[^0-9a-zA-Z\\p{Punct}]+").matcher(password).find();
    }
}
