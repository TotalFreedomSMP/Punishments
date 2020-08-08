package me.totalfreedom.punishments.util;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

public class Util
{
    public static String chatcolor(String string)
    {
        return ChatColor.translateAlternateColorCodes('&', string);
    }

    public static void broadcast(String string)
    {
        Bukkit.broadcastMessage(string);
    }
}