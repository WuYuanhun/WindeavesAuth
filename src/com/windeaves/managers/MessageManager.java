package com.windeaves.managers;

import org.bukkit.entity.Player;

public class MessageManager {

    private MessageManager() {

    }

    static MessageManager instance = new MessageManager();

    public static MessageManager getInstance() {
        return instance;
    }

    private String prefix = "[WindeavesAuth]";

    public String getPrefix() {
        return this.prefix;
    }

    public void showLoginMes(Player p) {
        p.sendMessage(prefix + "Login");
    }

    public void showRegisterMes(Player p) {
        p.sendMessage(prefix + "Register");
    }


    public void showAlreadyLoginMes(Player p) {
        p.sendMessage(prefix + "Already Login");
    }

    public void showWrongPasswordMes(Player p) {
        p.sendMessage(prefix + "Wrong Password");
    }

    public void showAlreadyResMes(Player p) {
        p.sendMessage(prefix + "Already Register");
    }

    public void showRegisterDiffPasswordMes(Player p) {
        p.sendMessage(prefix + "Different Password");
    }

    public void showRegisterInvalidPasswordMes(Player p) {
        p.sendMessage(prefix + "Password not match with standard");
    }

    public void showRegisterSuccessMes(Player p) {
        p.sendMessage(prefix + "Register Success");
    }
}
