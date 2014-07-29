package com.thedreamsanctuary.dreamtools.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.google.common.base.Preconditions;
import com.thedreamsanctuary.dreamtools.data.Data;
import com.thedreamsanctuary.dreamtools.data.Info;

import configuration.Logger;


public class wlList implements CommandExecutor
{
	
	public boolean onCommand(CommandSender sender, Command cmd, String str,String[] args)
	{
		Preconditions.checkArgument(sender instanceof Player);
		Info i = Data.getInfo((Player) sender);
		try
		{
		for (Player playerDat : i.getWhisperList())
			sender.sendMessage(ChatColor.BLUE + playerDat.getName());
		} catch (Exception e)
		{
			Logger.logIt("player: " + sender.getName() + " :: " +  e.toString(), "errorLog");
		}
		return false; 
			

		
	}
}
