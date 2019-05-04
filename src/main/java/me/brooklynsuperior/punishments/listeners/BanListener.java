package me.brooklynsuperior.punishments.listeners;

import me.brooklynsuperior.punishments.utils.Config;
import org.bukkit.BanList;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;

public class BanListener implements Listener {

    @EventHandler
    public void onPlayerLogin(PlayerLoginEvent event) {
        Player player = event.getPlayer();

        if (Bukkit.getBanList(BanList.Type.NAME).isBanned(event.getPlayer().getName())) {
            String reason = Bukkit.getBanList(BanList.Type.NAME).getBanEntry(event.getPlayer().getName()).getReason();
            String source = Bukkit.getBanList(BanList.Type.NAME).getBanEntry(event.getPlayer().getName()).getSource();
            String appeal = Config.getWebsiteOrForum();
            {
                StringBuilder kick = new StringBuilder()
                        .append(ChatColor.GRAY)
                        .append("You've been banned from this server")
                        .append("\nBanned by: ")
                        .append(ChatColor.GREEN)
                        .append(source)
                        .append(ChatColor.GRAY)
                        .append("\nReason: ")
                        .append(ChatColor.GREEN)
                        .append(reason)
                        .append(ChatColor.GRAY)
                        .append("\nYou may appeal your ban at: ")
                        .append(ChatColor.GREEN)
                        .append(appeal);
                event.disallow(PlayerLoginEvent.Result.KICK_BANNED, kick.toString());
            }
        }
    }
}