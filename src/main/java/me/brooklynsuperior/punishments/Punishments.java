package me.brooklynsuperior.punishments;


import me.brooklynsuperior.punishments.commands.*;
import me.brooklynsuperior.punishments.listeners.*;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public final class Punishments extends JavaPlugin {

    ConsoleCommandSender console = getServer().getConsoleSender();

    @Override
    public void onEnable() {
        enableCommands();
        enableListeners();
        console.sendMessage("[Punishments] Enabled Punishments v1.0");
    }

    private void enableCommands() {
        this.getCommand("ban").setExecutor(new command_ban());
        this.getCommand("kick").setExecutor(new command_kick());
        this.getCommand("unban").setExecutor(new command_unban());
        this.getCommand("warn").setExecutor(new command_warn());
        this.getCommand("mute").setExecutor(new command_mute());
        this.getCommand("unmute").setExecutor(new command_unmute());
    }

    private void enableListeners() {
        this.getServer().getPluginManager().registerEvents(new BanListener(), this);
        this.getServer().getPluginManager().registerEvents(new MuteListener(), this);
    }

    @Override
    public void onDisable() {
        console.sendMessage("[Punishments] Disabled Punishments v1.0");
    }
}