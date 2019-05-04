package me.brooklynsuperior.punishments.commands;

import me.brooklynsuperior.punishments.utils.Utils;
import org.apache.commons.lang.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class command_punish implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (args.length == 0) {
            sender.sendMessage(ChatColor.GRAY + "Supply a username to punish");
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

        if (player.hasPermission("punishments.punish")) {
            player.setHealth(0.0);
            Location location = player.getLocation();
            World world = player.getWorld();
            for (int i = 0; i < 3; i++)
            {
                world.strikeLightning(location);
            }
            Utils.broadcast(ChatColor.GREEN + sender.getName() + ChatColor.GRAY + " » Punishing " + ChatColor.GREEN + player.getName() + ChatColor.GRAY + " with reason: " + "'" + ChatColor.GREEN + reason + ChatColor.GRAY + "'");
        } else {
            sender.sendMessage(Utils.chatcolor("&7You do not have valid permissions to run this command"));
        }
        return true;
    }
}
