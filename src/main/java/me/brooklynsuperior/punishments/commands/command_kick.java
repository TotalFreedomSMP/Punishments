package me.brooklynsuperior.punishments.commands;

import me.brooklynsuperior.punishments.utils.Utils;
import org.apache.commons.lang.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class command_kick implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

            if (args.length == 0)
            {
                sender.sendMessage(ChatColor.RED + "Supply a username to kick");
            }

            Player player = Bukkit.getPlayer(args[0]);

            if (player == null)
            {
                sender.sendMessage(ChatColor.RED + "Player not found");
            }

            StringBuilder message = new StringBuilder()
                    .append(ChatColor.RED)
                    .append("You've been kicked from this server")
                    .append("\nKicked by: ")
                    .append(ChatColor.LIGHT_PURPLE)
                    .append(sender.getName());

            String reason = "No reason provided";
            if (args.length > 1)
            {
                reason = StringUtils.join(args, " ", 1, args.length);
                message.append(ChatColor.RED);
                message.append("\nReason: ")
                        .append(ChatColor.LIGHT_PURPLE)
                        .append(reason);
            }
        if (player.hasPermission("punishments.kick")) {
            player.kickPlayer(message.toString());
            Utils.broadcast(ChatColor.LIGHT_PURPLE + sender.getName() + ChatColor.RED +" - Kicking " + ChatColor.LIGHT_PURPLE + player.getName() + ChatColor.RED + " with reason: " + "'" + ChatColor.LIGHT_PURPLE + reason + ChatColor.RED + "'");
        } else {
            player.sendMessage(Utils.chatcolor("&cYou do not have valid permissions to run this command"));
        }
        return true;
    }
}