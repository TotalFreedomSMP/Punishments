package me.brooklynsuperior.punishments.commands;

import me.brooklynsuperior.punishments.utils.Utils;
import org.apache.commons.lang.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class command_warn implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (args.length == 0) {
            sender.sendMessage(ChatColor.RED + "Supply a username to warn");
            return true;
        }

        Player player = Bukkit.getPlayer(args[0]);

        if (player == null) {
            sender.sendMessage(ChatColor.RED + "Player not found");
            return true;
        }

        String reason = "No reason provided";
        if (args.length > 1)
        {
            reason = StringUtils.join(args, " ", 1, args.length);
        }

        if (player.hasPermission("punishments.warn")) {
            Utils.broadcast(ChatColor.LIGHT_PURPLE + sender.getName() + ChatColor.RED + " - Warning " + ChatColor.LIGHT_PURPLE + player.getName() + ChatColor.RED + " with reason: " + ChatColor.LIGHT_PURPLE + reason);
            player.sendMessage(ChatColor.RED + "You've been warned by " + ChatColor.LIGHT_PURPLE + sender.getName() + ChatColor.RED + " with reason: " + ChatColor.LIGHT_PURPLE + reason);
        } else {
            sender.sendMessage(Utils.chatcolor("&cYou do not have valid permissions to run this command"));
        }
        return true;
    }
}