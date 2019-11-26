package com.windeaves.commands;

import com.windeaves.managers.BanManager;
import com.windeaves.managers.LoginManager;
import com.windeaves.managers.MessageManager;
import com.windeaves.managers.PlayerManager;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ResetPasswordCmd implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] args) {
        if(!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "Only Players Can Use This Command!");
            return true;
        }

        Player p = (Player) sender;

        if(cmd.getName().equalsIgnoreCase("ResetPassword")) {

            // to-do: deal with case: no spawn location

            if(!PlayerManager.getInstance().isRegistered(p)) {
                MessageManager.getInstance().showRegisterMes(p);
                return true;
            }

            if(!LoginManager.getInstance().isAuthPlayer(p)) {
                MessageManager.getInstance().showRegisterMes(p);
                return true;
            }

            if(args.length != 3) {
                MessageManager.getInstance().showResetCADUsage(p);
                return true;
            }

            if(!PlayerManager.getInstance().attemptAuthPlayer(p, args[0])) {
                MessageManager.getInstance().showResetPasswordWrongWarn(p);
                PlayerManager.getInstance().failAttempt(p);
                return true;
            }

            if(!args[1].equals(args[2])) {
                MessageManager.getInstance().showResetCADUsage(p);
                return true;
            }

            if(args[1].length() < 6 || args[1].length() > 16) {
                MessageManager.getInstance().showRegisterInvalidPasswordMes(p);
                return true;
            }

            PlayerManager.getInstance().setPlayerPassword(p, args[1]);
            MessageManager.getInstance().showResetPasswordSucMes(p);
            PlayerManager.getInstance().successAttempt(p);

            return true;
        }

        return false;
    }
}
