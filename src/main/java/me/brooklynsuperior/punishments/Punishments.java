package me.brooklynsuperior.punishments;


import me.brooklynsuperior.punishments.commands.*;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public final class Punishments extends JavaPlugin {

    ConsoleCommandSender console = getServer().getConsoleSender();

    @Override
    public void onEnable() {
        enableCommands();
        console.sendMessage("[Punishments] Enabled Punishments v1.0");
    }

    private void enableCommands() {
        this.getCommand("ban").setExecutor(new command_ban());
        this.getCommand("kick").setExecutor(new command_kick());
        this.getCommand("unban").setExecutor(new command_unban());
        this.getCommand("warn").setExecutor(new command_warn());
    }

    @Override
    public void onDisable() {
        console.sendMessage("[Punishments] Disabled Punishments v1.0");
    }
}