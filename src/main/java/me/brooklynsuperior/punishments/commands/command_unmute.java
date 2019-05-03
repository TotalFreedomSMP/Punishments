package me.brooklynsuperior.punishments.commands;

import me.brooklynsuperior.punishments.listeners.MuteListener;
import me.brooklynsuperior.punishments.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class command_unmute implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (args.length == 0) {
            sender.sendMessage(ChatColor.GRAY + "Supply a username to unmute");
            return true;
        }

        Player player = Bukkit.getPlayer(args[0]);

        if (player == null) {
            sender.sendMessage(ChatColor.GRAY + "Player not found");
            return true;
        }

        if (!MuteListener.isMuted(player)) {
            sender.sendMessage(ChatColor.GRAY + "This player isn't muted");
            return true;
        }

        if (player.hasPermission("punishments.unmute")) {
            MuteListener.removeMute(player);

            Utils.broadcast(ChatColor.GREEN + sender.getName() + ChatColor.GRAY + " » Unmuting " + ChatColor.GREEN + player.getName());
        } else {
            sender.sendMessage(Utils.chatcolor("&7You do not have valid permissions to run this command"));
        }
        return true;
    }
}
