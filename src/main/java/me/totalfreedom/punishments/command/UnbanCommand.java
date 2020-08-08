package me.totalfreedom.punishments.command;

import me.totalfreedom.punishments.util.Util;
import org.bukkit.BanList;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class UnbanCommand implements CommandExecutor
{
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
    {
        if (args.length == 0)
        {
            return false;
        }

        if (!sender.hasPermission("punishments.unban"))
        {
            sender.sendMessage(Util.color("&cYou do not have permission to run this command."));
            return true;
        }

        OfflinePlayer player = Bukkit.getOfflinePlayer(args[0]);

        if (!player.isBanned())
        {
            sender.sendMessage(ChatColor.GRAY + "That player is not banned");
            return true;
        }

        Bukkit.getBanList(BanList.Type.NAME).pardon(player.getName());
        Util.broadcast(ChatColor.GREEN + sender.getName() + ChatColor.GRAY + " » Unbanning " + ChatColor.GREEN + player.getName());
        return true;
    }
}