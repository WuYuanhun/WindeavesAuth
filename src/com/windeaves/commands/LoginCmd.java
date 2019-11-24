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

public class LoginCmd implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] args) {
        if(!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "Only Players Can Use This Command!");
            return true;
        }

        Player p = (Player) sender;
        if(cmd.getName().equalsIgnoreCase("login")) {

            // to-do: deal with case: no spawn location

            if(args.length != 1) {
                MessageManager.getInstance().showLoginMes(p);
                return true;
            }

            if(!PlayerManager.getInstance().isRegistered(p)) {
                MessageManager.getInstance().showRegisterMes(p);
                return true;
            }

            if(LoginManager.getInstance().isAuthPlayer(p)) {
                MessageManager.getInstance().showAlreadyLoginMes(p);
                return true;
            }

            if(!PlayerManager.getInstance().attemptAuthPlayer(p, args[0])) {
                MessageManager.getInstance().showWrongPasswordMes(p);
                MessageManager.getInstance().showLoginMes(p);
                PlayerManager.getInstance().failAttempt(p);

                int attemptTimes = PlayerManager.getInstance().getPlayerAttemptTimes(p);
                if(attemptTimes >= 5) {
                    BanManager.getInstance().passwordBan(p);
                    p.kickPlayer(ChatColor.RED + "Banned: Contact Server Operator");
                } else if(attemptTimes >= 3) {
                    p.kickPlayer(ChatColor.RED + "Invalid Password: Too Many Times");
                }
                return true;
            }

            PlayerManager.getInstance().successAttempt(p);
            LoginManager.getInstance().authPlayer(p);

        }

        return false;
    }
}
