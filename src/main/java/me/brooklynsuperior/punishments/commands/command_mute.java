package me.brooklynsuperior.punishments.commands;

import me.brooklynsuperior.punishments.listeners.MuteListener;
import me.brooklynsuperior.punishments.utils.Utils;
import org.apache.commons.lang.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class command_mute implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (args.length == 0) {
            sender.sendMessage(ChatColor.GRAY + "Supply a username to mute");
            return true;
        }

        Player player = Bukkit.getPlayer(args[0]);

        if (player == null) {
            sender.sendMessage(ChatColor.GRAY + "Player not found");
            return true;
        }

        String reason = "No reason provided";
        if (args.length > 1)
        {
            reason = StringUtils.join(args, " ", 1, args.length);
        }

        if (player.hasPermission("punishments.mute")) {
            MuteListener.addMute(player, MuteListener.isMuted(player));

        if (MuteListener.isMuted(player)) {
            sender.sendMessage(ChatColor.GRAY + "This player is already muted");
            return true;
        }
            Utils.broadcast(ChatColor.GREEN + sender.getName() + ChatColor.GRAY + " » Muting " + ChatColor.GREEN + player.getName() + ChatColor.GRAY + " with reason: " + "'" + ChatColor.GREEN + reason + ChatColor.GRAY + "'");
            player.sendMessage(ChatColor.GRAY + "You've been muted by " + ChatColor.GREEN + sender.getName() + ChatColor.GRAY + " with reason: " + "'" + ChatColor.GREEN + reason + ChatColor.GRAY + "'");
        } else {
            sender.sendMessage(Utils.chatcolor("&7You do not have valid permissions to run this command"));
        }
        return true;
    }
}