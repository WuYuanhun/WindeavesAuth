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

    ArrayList<Player> authed = new ArrayList<>();

    public boolean isAuthPlayer(Player p) {
        return this.authed.contains(p);
    }

    public void authPlayer(Player p) {
        this.authed.add(p);
        // print info
    }

    public void unauthPlayer(Player p) {
        this.authed.remove(p);
    }


}
