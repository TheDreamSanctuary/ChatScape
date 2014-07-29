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

public class AddCustomPlayer implements CommandExecutor
{
	public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] args) 
	{
		try
		{
			if (args.length >= 1)
			{
				Info i = Data.getInfo((Player) sender);
				
				if (!i.getCustomGroups().containsEntry(args[0], ((Player) sender)))
				{
					sender.sendMessage(args[1] + "has been added to " + args[0]);
					i.getCustomGroups().put(args[0], Bukkit.getPlayer(args[1]));
				}
				else
					sender.sendMessage(ChatColor.RED + "unable to add the player they are already on that list.");
			}
		} catch (Exception e)
		{
			Logger.logIt("player: " + sender.getName() + " :: " +  e.toString(), Logger.error());
		}
		return false;
	}
}
