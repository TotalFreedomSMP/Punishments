package me.totalfreedom.punishments.command;

import me.totalfreedom.punishments.listener.MuteListener;
import me.totalfreedom.punishments.util.Util;
import org.apache.commons.lang.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MuteCommand implements CommandExecutor
{
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
    {
        if (args.length == 0)
        {
            return false;
        }

        if (!sender.hasPermission("punishments.mute"))
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

        if (MuteListener.isMuted(player))
        {
            sender.sendMessage(ChatColor.GRAY + "This player is already muted");
            return true;
        }

        String reason = "No reason provided";
        if (args.length > 1)
        {
            reason = StringUtils.join(args, " ", 1, args.length);
        }

        MuteListener.addMute(player);

        Util.broadcast(ChatColor.GREEN + sender.getName() + ChatColor.GRAY + " » Muting " + ChatColor.GREEN + player.getName() + ChatColor.GRAY + " with reason: " + "'" + ChatColor.GREEN + reason + ChatColor.GRAY + "'");
        player.sendMessage(ChatColor.GRAY + "You've been muted by " + ChatColor.GREEN + sender.getName() + ChatColor.GRAY + " with reason: " + "'" + ChatColor.GREEN + reason + ChatColor.GRAY + "'");
        return true;
    }
}