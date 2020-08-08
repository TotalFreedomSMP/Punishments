package me.totalfreedom.punishments.command;

import me.totalfreedom.punishments.util.Util;
import org.apache.commons.lang.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class KickCommand implements CommandExecutor
{
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
    {
        if (args.length == 0)
        {
            return false;
        }

        if (!sender.hasPermission("punishments.kick"))
        {
            sender.sendMessage(Util.color("&cYou do not have permission to run this command."));
            return true;
        }

        Player player = Bukkit.getPlayer(args[0]);
        if (player == null)
        {
            sender.sendMessage(ChatColor.GRAY + "Player not found");
            return true;
        }

        StringBuilder message = new StringBuilder()
                .append(ChatColor.GRAY)
                .append("You've been kicked from this server")
                .append("\nKicked by: ")
                .append(ChatColor.GREEN)
                .append(sender.getName());

        String reason = "No reason provided";
        if (args.length > 1)
        {
            reason = StringUtils.join(args, " ", 1, args.length);
            message.append(ChatColor.GRAY)
                    .append("\nReason: ")
                    .append(ChatColor.GREEN)
                    .append(reason);
        }

        player.kickPlayer(message.toString());
        Util.broadcast(ChatColor.GREEN + sender.getName() + ChatColor.GRAY + " » Kicking " + ChatColor.GREEN + player.getName() + ChatColor.GRAY + " with reason: " + "'" + ChatColor.GREEN + reason + ChatColor.GRAY + "'");
        return true;
    }
}