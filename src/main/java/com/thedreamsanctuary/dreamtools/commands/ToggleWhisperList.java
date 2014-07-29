package com.thedreamsanctuary.dreamtools.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.thedreamsanctuary.dreamtools.data.Data;
import com.thedreamsanctuary.dreamtools.data.Info;

import configuration.Logger;

public class ToggleWhisperList implements CommandExecutor
{

	
	public boolean onCommand(CommandSender sender, Command cmd, String arg, String[] args) 
	{
		Info i = Data.getInfo((Player) sender);
		
		try
		{
			if (i.isGroupEnabled())
			{
				i.setWhisperEnabled(false);
				sender.sendMessage(ChatColor.AQUA + "The group chat is now disabled");
				Logger.logIt("wlToggleEnabled: " + sender.getName(), "log");
			}
			else
			{
				i.setWhisperEnabled(true);
				sender.sendMessage(ChatColor.AQUA + "The group chat is now Enabled");
				Logger.logIt("wlToggleDisabled: " + sender.getName(), "log");
			}
		} catch (Exception e)
		{
			Logger.logIt("player: " + sender.getName() + " :: " +  e.toString(), "errorLog");
		}
		return false;
		
	}
}
