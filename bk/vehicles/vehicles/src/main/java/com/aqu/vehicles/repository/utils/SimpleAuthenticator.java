package com.aqu.vehicles.repository.utils;

import java.net.PasswordAuthentication;
import java.util.Base64;

public class SimpleAuthenticator {
    public static PasswordAuthentication getPasswordAuthentication(String userName, String password) {
        return new PasswordAuthentication("user", "password".toCharArray());
    }

    public static String GetAuthenticationHeader(String userName, String password) {
        PasswordAuthentication auth = getPasswordAuthentication(userName, password);
        return auth.toString();
    }

    public static final String getBasicAuthenticationHeader(String userName, String password) {
        if (password.isEmpty()) {
            return "Basic " + Base64.getEncoder().encodeToString(userName.getBytes());
        } else {
            Base64.Encoder var10000 = Base64.getEncoder();
            String var10001 = userName + ":" + password;
            return "Basic " + var10000.encodeToString(var10001.getBytes());
        }
    }
}
