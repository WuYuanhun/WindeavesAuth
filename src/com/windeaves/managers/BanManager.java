package com.windeaves.managers;

import org.bukkit.BanList;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class BanManager {

    private BanManager() {

    }

    static BanManager instance = new BanManager();

    public static BanManager getInstance() {
        return instance;
    }

    public void passwordBan(Player p) {
        Bukkit.getBanList(BanList.Type.NAME).addBan(p.getName(), "Too Many Wrong Password", null, "[WindeavesAuth]:BanManager");
        Bukkit.getBanList(BanList.Type.IP).addBan(p.getAddress().toString(), "Too Many Wrong Password When Login " + p.getName(), null, "[WindeavesAuth]:BanManager");
    }
}
