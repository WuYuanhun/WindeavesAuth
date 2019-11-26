package com.windeaves.commands;

import com.windeaves.managers.Config;
import com.windeaves.managers.LoginManager;
import com.windeaves.managers.MessageManager;
import com.windeaves.managers.PlayerManager;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class WDAuthCmd implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] args) {
        if(cmd.getName().equalsIgnoreCase("WDAuth")) {

            if(!sender.hasPermission("WindeavesAuth.WindeavesAuth")) {
                sender.sendMessage(ChatColor.RED + "No Permissions");
                return true;
            }

            if(args.length == 0) {
                MessageManager.getInstance().showCommandHelp((Player) sender);
                return true;
            }

            if(args[0].equalsIgnoreCase("setSpawn")) {
                if(args.length == 1) {
                    if(sender instanceof Player) {
                        Player p = (Player) sender;
                        Config.getInstance().setSpawnLocation(p.getLocation());
                    } else {
                        sender.sendMessage(ChatColor.RED + "You Must Be A Player!");
                    }
                    return true;
                } else if(args.length == 4) {
                    // to-do: active input the location
                } else {
                    MessageManager.getInstance().showCommandHelp((Player) sender);
                }
            }

            if(args[0].equalsIgnoreCase("unreg")) {
                if(args.length == 2) {
                    LoginManager.getInstance().unauthPlayer(args[1]);
                    PlayerManager.getInstance().removeRegInfo(args[1]);
                } else {
                    MessageManager.getInstance().showCommandHelp((Player) sender);
                }
            }

            // to-do: more command
        }

        return false;
    }
}
