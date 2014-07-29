package com.thedreamsanctuary.dreamtools.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.thedreamsanctuary.dreamtools.data.Data;
import com.thedreamsanctuary.dreamtools.data.Info;

import configuration.Logger;

public class RemCustomPlayer implements CommandExecutor
{
	public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] args) 
	{
		try
		{
			if (args.length >= 1)
			{
				Info i = Data.getInfo((Player) sender);
				
				if (i.getCustomGroups().containsEntry(args[0], ((Player) sender)))
				{
					sender.sendMessage(ChatColor.AQUA + "User has successfully been added");
					i.getCustomGroups().remove(args[0], Bukkit.getPlayer(args[1]));
				}
				else
					sender.sendMessage(ChatColor.RED + "unable to remove the player because they are not on that list.");
			}
		} catch (Exception e)
		{
			Logger.logIt("player: " + sender.getName() + " :: " +  e.toString(), "errorLog");
		}
		return false;
	}
}
