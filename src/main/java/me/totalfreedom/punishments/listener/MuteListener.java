package me.totalfreedom.punishments.listener;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.util.ArrayList;
import java.util.List;

public class MuteListener implements Listener
{

    private static List<Player> mutelist = new ArrayList<>();

    public static boolean isMuted(Player player)
    {
        return mutelist.contains(player);
    }

    public static void addMute(Player player)
    {
        mutelist.add(player);
    }

    public static void removeMute(Player player)
    {
        mutelist.remove(player);
    }

    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event)
    {
        Player player = event.getPlayer();
        if (isMuted(player))
        {
            player.sendMessage(ChatColor.GRAY + "You have been muted, you may not talk");
            event.setCancelled(true);
        }
    }
}