package me.brooklynsuperior.punishments.utils;

import me.brooklynsuperior.punishments.Punishments;
import org.bukkit.configuration.file.FileConfiguration;

public class Config {
    
    public static FileConfiguration config = Punishments.getPlugin(Punishments.class).getConfig();

    public static String getWebsiteOrForum()
    {
        return config.getString("server.website_or_forum");
    }

}
