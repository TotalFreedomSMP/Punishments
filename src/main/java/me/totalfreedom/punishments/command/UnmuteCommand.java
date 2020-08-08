package me.totalfreedom.punishments.command;

import me.totalfreedom.punishments.listener.MuteListener;
import me.totalfreedom.punishments.util.Util;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class UnmuteCommand implements CommandExecutor
{
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
    {
        if (args.length == 0)
        {
            return false;
        }

        if (sender.hasPermission("punishments.unmute"))
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

        if (!MuteListener.isMuted(player))
        {
            sender.sendMessage(ChatColor.GRAY + "This player isn't muted");
            return true;
        }

        MuteListener.removeMute(player);
        Util.broadcast(ChatColor.GREEN + sender.getName() + ChatColor.GRAY + " » Unmuting " + ChatColor.GREEN + player.getName());
        return true;
    }
}