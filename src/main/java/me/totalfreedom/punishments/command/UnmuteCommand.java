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

        if (sender.hasPermission("punishments.unmute"))
        {
            MuteListener.removeMute(player);
            Util.broadcast(ChatColor.GREEN + sender.getName() + ChatColor.GRAY + " » Unmuting " + ChatColor.GREEN + player.getName());
        }
        else
        {
            sender.sendMessage(Util.chatcolor("&7You do not have valid permissions to run this command"));
        }
        return true;
    }
}