package me.totalfreedom.punishments.config;

import me.totalfreedom.punishments.Punishments;

public enum ConfigEntry
{
    SERVER_WEBSITE_OR_FORUM("server.website_or_forum");

    private final String path;

    ConfigEntry(String path)
    {
        this.path = path;
    }

    private static Config config = Punishments.getPlugin().config;

    public String getString()
    {
        return config.getString(path);
    }
}
