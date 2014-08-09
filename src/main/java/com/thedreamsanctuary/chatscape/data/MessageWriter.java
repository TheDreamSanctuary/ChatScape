package com.thedreamsanctuary.chatscape.data;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;


public class MessageWriter 
{
	static public boolean modeStatus(Player sender)
	{
		Info i = Data.getInfo(sender);
		
		if (i.isChatEnabled())
			sender.sendMessage(ChatColor.DARK_AQUA+ "Current Mode: " + ChatColor.AQUA + "Public \n");
		else
			sender.sendMessage(ChatColor.DARK_AQUA + "Current Mode: " + ChatColor.GREEN + "Private \n");
		
		if (!(i.getArgs() == " "))
			sender.sendMessage(ChatColor.DARK_AQUA + "Arguements: " + ChatColor.WHITE + i.getArgs());
		else
			sender.sendMessage(ChatColor.DARK_AQUA + "Arguements: " + ChatColor.GRAY + "none");
		
		if (i.isWhisperEnabled())
			sender.sendMessage(ChatColor.DARK_AQUA + "Whisperlist: " + ChatColor.GREEN + "Enabled");
		else
			sender.sendMessage(ChatColor.DARK_AQUA + "Whisperlist: " + ChatColor.RED + "Disabled");
		
		if (i.isGroupEnabled())
			sender.sendMessage(ChatColor.DARK_AQUA + "GroupList: " + ChatColor.GREEN + "Enabled");
		else
			sender.sendMessage(ChatColor.DARK_AQUA + "GroupList: " + ChatColor.RED + "Disabled");
		
		if (i.isOverriding())
			sender.sendMessage(ChatColor.DARK_AQUA + "Overriding: " + ChatColor.GREEN + "Enabled");
		else
			sender.sendMessage(ChatColor.DARK_AQUA + "Overriding: " + ChatColor.RED + "Disabled");
		
		return false;	
	}
	static public void nonPlayerMember(Player sender)
	{
		sender.sendMessage("You cannot execute this command through console");
	}
	static public void listData(Player[][] info)
	{
		//sender.sendMessage("Player suc")
	}
	static public void PlayerSucceed(Player sender, Player[] suceedList, String info)
	{
		sender.sendMessage("Users failed to add to your list");
		for (Player p : suceedList)
		{
			sender.sendMessage(p.getName());
		}
	}
}
