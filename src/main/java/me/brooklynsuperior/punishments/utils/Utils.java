package me.brooklynsuperior.punishments.utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

public class Utils {

    public static String chatcolor(String string)
    {
        return ChatColor.translateAlternateColorCodes('&', string);
    }

    public static void broadcast(String string)
    {
        Bukkit.broadcastMessage(string);
    }

}