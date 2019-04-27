package me.brooklynsuperior.punishments.commands;

import me.brooklynsuperior.punishments.utils.Utils;
import org.apache.commons.lang.StringUtils;
import org.bukkit.BanList;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class command_ban implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (args.length == 0) {
            sender.sendMessage(ChatColor.RED + "Supply a username to ban");
            return true;
        }

        Player player = Bukkit.getPlayer(args[0]);

        if (player == null) {
            sender.sendMessage(ChatColor.RED + "Player not found");
            return true;
        }

        StringBuilder message = new StringBuilder()
                .append(ChatColor.RED)
                .append("You've been banned from this server")
                .append("\nBanned by: ")
                .append(ChatColor.LIGHT_PURPLE)
                .append(sender.getName());

        String reason = "No reason provided";
        if (args.length > 1) {
            reason = StringUtils.join(args, " ", 1, args.length);
            message.append(ChatColor.RED);
            message.append("\nReason: ")
                    .append(ChatColor.LIGHT_PURPLE)
                    .append(reason);
        }
        if (player.hasPermission("punishments.ban")) {
            Bukkit.getBanList(BanList.Type.NAME).addBan(player.getName(), reason, null, sender.getName());
            player.kickPlayer(message.toString());
            Utils.broadcast(ChatColor.LIGHT_PURPLE + sender.getName() + ChatColor.RED + " - Banning " + ChatColor.LIGHT_PURPLE + player.getName() + ChatColor.RED + " with reason: " + "'" + ChatColor.LIGHT_PURPLE + reason + ChatColor.RED + "'");
        } else {
            sender.sendMessage(Utils.chatcolor("&cYou do not have valid permissions to run this command"));
        }
        return true;
    }
}