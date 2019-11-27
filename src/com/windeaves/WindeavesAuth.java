package com.windeaves;

import com.windeaves.commands.LoginCmd;
import com.windeaves.commands.RegisterCmd;
import com.windeaves.commands.ResetPasswordCmd;
import com.windeaves.commands.WDAuthCmd;
import com.windeaves.eventListeners.PlayerJoinListener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class WindeavesAuth extends JavaPlugin {

    PluginManager pm = this.getServer().getPluginManager();
    public static Plugin main;
    public static WindeavesAuth m;

    @Override
    public void onLoad() {
    }

    @Override
    public void onEnable() {
        this.init();
    }

    @Override
    public void onDisable() {

    }

    private void init() {
        main = this;
        m = this;
        this.loadListeners();
        this.regCommand();
    }

    private void regCommand() {
        this.getCommand("login").setExecutor(new LoginCmd());
        this.getCommand("register").setExecutor(new RegisterCmd());
        this.getCommand("resetPassword").setExecutor(new ResetPasswordCmd());
        this.getCommand("WDauth").setExecutor(new WDAuthCmd());
    }

    private void loadListeners() {
        this.pm.registerEvents(new PlayerJoinListener(), this);
    }
}
