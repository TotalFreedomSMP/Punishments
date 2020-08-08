package me.totalfreedom.punishments;

import me.totalfreedom.punishments.command.BanCommand;
import me.totalfreedom.punishments.command.KickCommand;
import me.totalfreedom.punishments.command.MuteCommand;
import me.totalfreedom.punishments.command.PunishCommand;
import me.totalfreedom.punishments.command.PunishmentsCommand;
import me.totalfreedom.punishments.command.UnbanCommand;
import me.totalfreedom.punishments.command.UnmuteCommand;
import me.totalfreedom.punishments.command.WarnCommand;
import me.totalfreedom.punishments.config.Config;
import me.totalfreedom.punishments.listener.BanListener;
import me.totalfreedom.punishments.listener.MuteListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class Punishments extends JavaPlugin
{
    private static Punishments plugin;

    public static Punishments getPlugin()
    {
        return plugin;
    }

    public Config config;

    @Override
    public void onEnable()
    {
        plugin = this;
        config = new Config("config.yml");
        loadCommands();
        loadListeners();
    }

    private void loadCommands()
    {
        this.getCommand("ban").setExecutor(new BanCommand());
        this.getCommand("kick").setExecutor(new KickCommand());
        this.getCommand("unban").setExecutor(new UnbanCommand());
        this.getCommand("warn").setExecutor(new WarnCommand());
        this.getCommand("mute").setExecutor(new MuteCommand());
        this.getCommand("unmute").setExecutor(new UnmuteCommand());
        this.getCommand("punish").setExecutor(new PunishCommand());
        this.getCommand("punishments").setExecutor(new PunishmentsCommand());
    }

    private void loadListeners()
    {
        this.getServer().getPluginManager().registerEvents(new BanListener(), this);
        this.getServer().getPluginManager().registerEvents(new MuteListener(), this);
    }

    @Override
    public void onDisable()
    {
        plugin = null;
        config.save();
    }
}