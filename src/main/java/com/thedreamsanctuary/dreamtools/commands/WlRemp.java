package com.thedreamsanctuary.dreamtools.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.google.common.base.Preconditions;
import com.thedreamsanctuary.dreamtools.data.Data;
import com.thedreamsanctuary.dreamtools.data.Info;

import configuration.Logger;

public class WlRemp implements CommandExecutor
{
	public boolean onCommand(CommandSender sender, Command cmd, String arg, String[] args) 
	{
		Info i = Data.getInfo((Player) sender);
		System.out.println("=========================");
		Preconditions.checkArgument(sender instanceof Player);
		try
		{
			for (String p : args)
			{			
				if (i.getWhisperList().contains(Bukkit.getPlayer(p)))
				{
					i.getWhisperList().remove(Bukkit.getPlayer(p));
					sender.sendMessage(p + "has been removed from your whisper list");
				}
				else
					sender.sendMessage("that player isn't currently on your whisper list");
			}
		} catch (Exception e)
		{
			Logger.logIt("player: " + sender.getName() + " :: " +  e.toString(), "errorLog");
		}
		return false;
	}

}
