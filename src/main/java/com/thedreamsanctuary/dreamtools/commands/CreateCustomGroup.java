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

public class CreateCustomGroup implements CommandExecutor
{

	public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] args) 
	{
		int failed = 0;
		int suceeded = 0;
		int entries = args.length -1;
		
		try
		{
			if (args.length >=1)
			{
				Info i = Data.getInfo((Player) sender);
				
				for (int count = 1; count < args.length; count++)
				{
					if (!i.getCustomGroups().containsEntry(args[0], args[count]))
					{
						//adds a player to the map if they don't already exist
						sender.sendMessage(args[0] + "has been created");
						i.getCustomGroups().put(args[0], Bukkit.getPlayer(args[count]));
						suceeded +=1;
					}
					else
						failed += 2;		 
				}
				sender.sendMessage(ChatColor.GREEN + "" + suceeded + " Suceeded" + ChatColor.RED + failed + " Failed" + ChatColor.WHITE + " Out of " + entries);
			}
		} catch (Exception e)
		{
			Logger.logIt("player: " + sender.getName() + " :: " +  e.toString(), Logger.error());
		}
		return false;
	}

}
