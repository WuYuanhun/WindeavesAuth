package com.windeaves.utils;

public class Tool {

    private Tool() {

    }

    static Tool instance = new Tool();

    public static Tool getInstance() {
        return instance;
    }

    public String encryptedPassword(String org) {
        return Integer.valueOf(org.hashCode()).toString();
    }
}
