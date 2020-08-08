package me.totalfreedom.punishments.command;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class PunishmentsCommand implements CommandExecutor
{
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
    {
        sender.sendMessage(ChatColor.GRAY
                + "--------------------\n" +
                "List of Punishments:\n" +
                "- ban\n" +
                "- kick\n" +
                "- mute\n" +
                "- punish\n" +
                "- unban\n" +
                "- unmute\n" +
                "- warn\n" +
                "--------------------");
        return true;
    }
}