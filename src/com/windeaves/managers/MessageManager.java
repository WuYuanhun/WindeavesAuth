package com.windeaves.managers;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MessageManager {

    private MessageManager() {

    }

    static MessageManager instance = new MessageManager();

    public static MessageManager getInstance() {
        return instance;
    }

    private String prefix = "[WindeavesAuth] ";

    public String getPrefix() {
        return this.prefix;
    }

    public void showLoginMes(Player p) {
        p.sendMessage(prefix + "Please login use \\login [password]");
    }

    public void showRegisterMes(Player p) {
        p.sendMessage(prefix + "Please register use \\register [password] [repeated password]");
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

    public void showResetCADUsageMes(Player p) {
        p.sendMessage(prefix + "Reset Usage");
    }

    public void showResetPasswordWrongWarn(Player p) {
        p.sendMessage(prefix + "Old Password Wrong. Attempt times record.");
    }

    public void showResetPasswordSucMes(Player p) {
        p.sendMessage(prefix + "Reset Successfully");
    }

    public void showResetCADUsage(Player p) {
        p.sendMessage(prefix + "Reset CAD Usage");
    }

    public void showCommandHelp(Player p) {
        p.sendMessage(prefix + "Command Help");
    }

    public void showSetSpawnMes(Player p) {
        p.sendMessage(prefix + "Set Spawn Mes");
    }

    public void PluginInfo(Player p) {
        p.sendMessage(prefix + " is running");
    }
}
