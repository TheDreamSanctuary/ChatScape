package com.thedreamsanctuary.dreamtools.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.thedreamsanctuary.dreamtools.data.Data;
import com.thedreamsanctuary.dreamtools.data.Info;

import configuration.Logger;

public class PlayerInfo implements CommandExecutor
{

	public boolean onCommand(CommandSender sender, Command cmd, String arg, String[] args) 
	{
		try
		{
			if (args.length == 1)
			{
				Info i = Data.getInfo((Player) sender);
				
				if (!i.getPlayerName().isEmpty()) 
				{
					sender.sendMessage("Name: " + (Player) sender);
				} 
				else 
				{
					sender.sendMessage(ChatColor.RED + "The user you are trying to look up does not exist");
				}
			}
			
		} catch (Exception e)
		{
			Logger.logIt("player: " + sender.getName() + " :: " +  e.toString(), Logger.error());
		}
		return false;
	}

}
