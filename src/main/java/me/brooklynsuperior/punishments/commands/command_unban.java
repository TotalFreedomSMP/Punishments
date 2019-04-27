package me.brooklynsuperior.punishments.commands;

import me.brooklynsuperior.punishments.utils.Utils;
import org.bukkit.BanList;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class command_unban implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (args.length == 0) {
            sender.sendMessage(ChatColor.RED + "Supply a username to unban");
        }

        Player player = Bukkit.getPlayer(args[0]);

        if (player == null) {
            sender.sendMessage(ChatColor.RED + "Player not found");
        }
        if (player.hasPermission("punishments.unban")) {
            Bukkit.getBanList(BanList.Type.NAME).pardon(player.getName());
            Utils.broadcast(ChatColor.LIGHT_PURPLE + sender.getName() + ChatColor.RED + " - Unbanning " + ChatColor.LIGHT_PURPLE + player.getName());

        } else {
            player.sendMessage(Utils.chatcolor("&cYou do not have valid permissions to run this command"));
        }
        return true;
    }
}