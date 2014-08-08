package com.thedreamsanctuary.dreamtools.commands;

import java.util.ArrayList;
import java.util.Arrays;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import Executors.addPlayer;
import Executors.pInfo;
import Executors.remPlayer;
import Executors.toggleWhisperList;

import com.thedreamsanctuary.dreamtools.data.Data;
import com.thedreamsanctuary.dreamtools.data.Info;

public class WhisperList implements CommandExecutor
{
	public boolean onCommand(CommandSender sender, Command cmd, String arg, String[] args) 
	{
		Info i = Data.getInfo((Player) sender);
		addPlayer ap = new addPlayer();
		remPlayer rp = new remPlayer();
		pInfo pi = new pInfo();
		toggleWhisperList twl = new toggleWhisperList();		
		
		System.out.println("THE PLAYER" + i.getPlayer());
		if (args.length >= 1)
		{
			if (args[0].equalsIgnoreCase("add"))
			{
				ap.executor(i, args);
			}
			else if (args[0].equalsIgnoreCase("rem"))
			{
				rp.executor(i, args);
			}
			else if (args[0].equalsIgnoreCase("info"))
			{
				pi.executor(i, args);
			}
			else if (args[0].equalsIgnoreCase("toggle"))
			{
				twl.executor(i, args);
			}
			else if (args[0].equalsIgnoreCase("override"))
			{
				
			}
		}
		else
		{
			sender.sendMessage(ChatColor.DARK_AQUA + "add" + ChatColor.BLUE + "- Adds a player to your group list");
			sender.sendMessage(ChatColor.DARK_AQUA + "rem" + ChatColor.BLUE + "- Removes a player from your group list");
			sender.sendMessage(ChatColor.DARK_AQUA + "toggle" + ChatColor.BLUE + "- Toggles player list on or off");
			sender.sendMessage(ChatColor.DARK_AQUA + "info" + ChatColor.BLUE + "- Lists all players you currently have added");
		}
		return false;
	}
}
