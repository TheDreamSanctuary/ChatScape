package com.thedreamsanctuary.dreamtools.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.thedreamsanctuary.dreamtools.data.Data;
import com.thedreamsanctuary.dreamtools.data.Info;

import Executors.addGroup;
import Executors.gInfo;
import Executors.remGroup;
import Executors.toggleGroupList;

public class GroupList implements CommandExecutor
{
	addGroup ag = new addGroup();
	remGroup rg = new remGroup();
	gInfo gi = new gInfo();
	toggleGroupList tgl = new toggleGroupList();
	
	public boolean onCommand(CommandSender sender, Command cmd, String str,String[] args)
	{
		if (sender instanceof Player)
		{
			if (args.length >= 1)
			{
				Info i = Data.getInfo((Player) sender);
				if (args[0].equalsIgnoreCase("add"))
				{
					ag.executor(i,args);
				}
				else if (args[0].equalsIgnoreCase("rem"))
				{
					rg.executor(i, args);
				}
				else if (args[0].equalsIgnoreCase("info"))
				{
					gi.executor(i, args);
				}
				else if (args[0].equalsIgnoreCase("toggle"))
				{
					tgl.executor(i, args);
				}
			}
			else
			{
				sender.sendMessage(ChatColor.DARK_AQUA + "add" + ChatColor.BLUE + "- Adds a group to your group list");
				sender.sendMessage(ChatColor.DARK_AQUA + "rem" + ChatColor.BLUE + "- Removes a group from your group list");
				sender.sendMessage(ChatColor.DARK_AQUA + "toggle" + ChatColor.BLUE + "- Toggles group list on or off");
				sender.sendMessage(ChatColor.DARK_AQUA + "info" + ChatColor.BLUE + "- Lists all groups you currently have added");
			}
			
		}
		return false;
	}
}
