package com.windeaves.commands;

import com.windeaves.managers.LoginManager;
import com.windeaves.managers.MessageManager;
import com.windeaves.managers.PlayerManager;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class RegisterCmd implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] args) {
        if(!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "Only Players Can Use This Command!");
            return true;
        }

        Player p = (Player) sender;
        if(cmd.getName().equalsIgnoreCase("register")) {

            // to-do: deal with case: no spawn location

            if(PlayerManager.getInstance().isRegistered(p)) {
                MessageManager.getInstance().showAlreadyResMes(p);
                return true;
            }

            if(args.length != 2) {
                MessageManager.getInstance().showRegisterMes(p);
                return true;
            }

            if(!args[0].equals(args[1])) {
                MessageManager.getInstance().showRegisterDiffPasswordMes(p);
                return true;
            }

            if(args[0].length() < 6 || args[0].length() > 16) {
                MessageManager.getInstance().showRegisterInvalidPasswordMes(p);
                return true;
            }

            PlayerManager.getInstance().setPlayerPassword(p, args[0]);
            MessageManager.getInstance().showRegisterSuccessMes(p);
            LoginManager.getInstance().authPlayer(p);

            return true;
        }

        return false;
    }

}