package me.brooklynsuperior.punishments.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class command_punishments implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
                player.sendMessage(ChatColor.GRAY + "--------------------\n" + "List of Punishments:\n" + "-ban\n" + "-kick\n" + "-mute\n" + "-punish\n" + "-unban\n" + "-unmute\n" + "-warn\n" + "--------------------");
            }
        return true;
    }
}