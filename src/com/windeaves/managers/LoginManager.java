package com.windeaves.managers;

import org.bukkit.entity.Player;

import java.util.ArrayList;

public class LoginManager {

    private LoginManager() {

    }

    static LoginManager instance = new LoginManager();

    public static LoginManager getInstance() {
        return instance;
    }

    private ArrayList<String> authed = new ArrayList<>();

    public boolean isAuthPlayer(Player p) {
        return this.authed.contains(p.getName());
    }

    public void authPlayer(Player p) {
        this.authed.add(p.getName());
        // print info
    }

    public void unauthPlayer(Player p) {
        this.authed.remove(p.getName());
    }

    public void unauthPlayer(String p) {
        this.authed.remove(p);
    }
}
