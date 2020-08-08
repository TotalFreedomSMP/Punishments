package me.totalfreedom.punishments.config;

import me.totalfreedom.punishments.Punishments;
import org.bukkit.configuration.file.FileConfiguration;

public class ConfigEntry
{
    public static FileConfiguration config = Punishments.getPlugin(Punishments.class).getConfig();

    public static String getWebsiteOrForum()
    {
        return config.getString("server.website_or_forum");
    }
}
