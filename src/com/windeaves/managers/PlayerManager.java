package com.windeaves.managers;

import com.windeaves.utils.Tool;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.HashMap;

public class PlayerManager {

    private PlayerManager() {

    }

    static PlayerManager instance = new PlayerManager();

    public static PlayerManager getInstance() {
        return instance;
    }

    ArrayList<String> registeredPlayer = new ArrayList<>();
    HashMap<String, Integer> attemptTimes = new HashMap<>();

    public boolean isRegistered(Player p) {
        return this.registeredPlayer.contains(p.getName());
    }

    public boolean isRegistered(String p) {
        return this.registeredPlayer.contains(p);
    }

    public boolean attemptAuthPlayer(Player p, String password) {
        if(this.getPlayerRawPassword().equals(Tool.getInstance().encryptedPassword(password))) {
            return true;
        }
        return false;
    }

    private String getPlayerRawPassword() {
        // to-do: implement get player raw password
        return "DefaultPassword";
    }

    public void failAttempt(Player p) {
        if(this.attemptTimes.containsKey(p.getName())) {
            this.attemptTimes.replace(p.getName(), this.attemptTimes.get(p.getName()) + 1);
        } else {
            this.attemptTimes.put(p.getName(), 1);
        }
        int attemptTimes = PlayerManager.getInstance().getPlayerAttemptTimes(p);
        if(attemptTimes >= 5) {
            BanManager.getInstance().passwordBan(p);
            p.kickPlayer(ChatColor.RED + "Banned: Contact Server Operator");
        } else if(attemptTimes >= 3) {
            p.kickPlayer(ChatColor.RED + "Invalid Password: Too Many Times");
        }
    }

    public void successAttempt(Player p) {
        this.attemptTimes.remove(p.getName());
    }

    public int getPlayerAttemptTimes(Player p) {
        if(!this.attemptTimes.containsKey(p.getName())) {
            return 0;
        }
        return this.attemptTimes.get(p.getName());
    }

    public void setPlayerPassword(Player p, String arg) {
        this.registeredPlayer.add(p.getName());
        // to-do: set player password
    }

    public void removeRegInfo(Player p) {
        this.registeredPlayer.remove(p.getName());
        this.attemptTimes.remove(p.getName());
    }

    public void removeRegInfo(String p) {
        this.registeredPlayer.remove(p);
        this.attemptTimes.remove(p);
    }
}
