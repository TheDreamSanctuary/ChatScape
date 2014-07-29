package com.thedreamsanctuary.dreamtools.data;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;


public class MessageWriter 
{
	static public boolean modeStatus(String className, Player sender, Player receiver, String cmd, String args)
	{
		Info i = Data.getInfo(sender);
		sender.sendMessage(ChatColor.AQUA + "Current Mode: " + className + "\n");
		
		if (!args.isEmpty())
			sender.sendMessage(ChatColor.AQUA + "Arguements: " + ChatColor.BLUE + args);
		else
			sender.sendMessage(ChatColor.AQUA + "Arguements: " + ChatColor.GRAY + "none");
		
		
		if (i.isWhisperEnabled())
			sender.sendMessage(ChatColor.AQUA + "Whisperlist: " + ChatColor.GREEN + "Enabled");
		else
			sender.sendMessage(ChatColor.AQUA + "Whisperlist:" + ChatColor.RED + "Disabled");
		
		if (i.isGroupEnabled())
			sender.sendMessage(ChatColor.AQUA + "GroupList:" + ChatColor.GREEN + "Enabled");
		else
			sender.sendMessage(ChatColor.AQUA + "GroupList:" + ChatColor.RED + "Disabled");
		
		if (i.isOverriding())
			sender.sendMessage(ChatColor.AQUA + "Overriding:" + ChatColor.GREEN + "Enabled");
		else
			sender.sendMessage(ChatColor.AQUA + "Overriding:" + ChatColor.RED + "Disabled");
		return false;
		
	}
	
}
