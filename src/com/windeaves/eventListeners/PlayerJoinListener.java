package com.windeaves.eventListeners;

import com.mysql.jdbc.ConnectionGroup;
import com.windeaves.managers.Config;
import com.windeaves.managers.MessageManager;
import com.windeaves.managers.PlayerManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener implements Listener {

    @EventHandler(priority = EventPriority.LOWEST, ignoreCancelled = true)
    public void onPlayerJoin(final PlayerJoinEvent e) {
        final Player p = e.getPlayer();

        if(p.isOp()) {
            MessageManager.getInstance().PluginInfo(p);
        }

        if(PlayerManager.getInstance().isRegistered(p)) {
            MessageManager.getInstance().showLoginMes(p);
        } else {
            MessageManager.getInstance().showRegisterMes(p);
        }

        if(Config.getInstance().getSpawnLocation() == null) {
            MessageManager.getInstance().showSetSpawnMes(p);
        } else {
            p.teleport(Config.getInstance().getSpawnLocation());
        }
    }
}
