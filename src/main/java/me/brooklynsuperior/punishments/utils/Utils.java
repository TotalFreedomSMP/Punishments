package me.brooklynsuperior.punishments.utils;

import me.brooklynsuperior.punishments.Punishments;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;

public class Utils {

    public static FileConfiguration config = Punishments.getPlugin(Punishments.class).getConfig();

    public static String getWebsiteOrForum()
    {
        return config.getString("server.website_or_forum");
    }

    public static String chatcolor(String string)
    {
        return ChatColor.translateAlternateColorCodes('&', string);
    }

    public static void broadcast(String string)
    {
        Bukkit.broadcastMessage(string);
    }

}