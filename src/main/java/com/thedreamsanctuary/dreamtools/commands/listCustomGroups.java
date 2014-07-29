package com.thedreamsanctuary.dreamtools.commands;

import java.util.Map.Entry;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.thedreamsanctuary.dreamtools.data.Data;
import com.thedreamsanctuary.dreamtools.data.Info;

import configuration.Logger;

public class listCustomGroups implements CommandExecutor
{
	public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] args) 
	{
		try
		{
			if (args.length >=1)
			{				
				Info i = Data.getInfo((Player) sender);
				
				sender.sendMessage("Members of " + args[0]);
				for (Entry<String, Player> entry : i.getCustomGroups().entries())
				{
					if (entry.getKey().contains(args[0]))
					{
							sender.sendMessage(ChatColor.AQUA + "" + entry.getValue());
					}
				}			
			}
		} catch (Exception e)
		{
			Logger.logIt("player: " + sender.getName() + " :: " +  e.toString(), Logger.error());
		}
		return false;
	}
}
