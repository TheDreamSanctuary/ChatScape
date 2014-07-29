package com.thedreamsanctuary.dreamtools.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.thedreamsanctuary.dreamtools.data.Data;
import com.thedreamsanctuary.dreamtools.data.Info;

import configuration.Logger;

public class ToggleGroupChat implements CommandExecutor
{
	public boolean onCommand(CommandSender sender, Command cmd, String arg, String[] args) 
	{
		try
		{
			Info i = Data.getInfo((Player) sender);
			if (i.isGroupEnabled())
			{
				i.setGroupEnabled(false);
				sender.sendMessage(ChatColor.AQUA + "Whisperlist chat is now disabled!");
				Logger.logIt("gcEnabled: " + sender.getName(), "log");
			}
			else
				i.setGroupEnabled(true);
				sender.sendMessage(ChatColor.AQUA + "Whisperlist chat is now Enabled!");
				Logger.logIt("gcDisabled: " + sender.getName(), "log");
		} catch (Exception e)
		{
			Logger.logIt("player: " + sender.getName() + " :: " +  e.toString(), "errorLog");
		}
		return false;
		
			
	}
}
