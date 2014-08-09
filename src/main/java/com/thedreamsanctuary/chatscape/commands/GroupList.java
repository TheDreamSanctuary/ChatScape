package com.thedreamsanctuary.chatscape.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.thedreamsanctuary.chatscape.executors.AddGroup;
import com.thedreamsanctuary.chatscape.executors.GList;
import com.thedreamsanctuary.chatscape.executors.GetGroups;
import com.thedreamsanctuary.chatscape.executors.Pinfo;
import com.thedreamsanctuary.chatscape.executors.RemGroup;
import com.thedreamsanctuary.chatscape.executors.ToggleGroupList;
import com.thedreamsanctuary.chatscape.data.Data;
import com.thedreamsanctuary.chatscape.data.Info;
import com.thedreamsanctuary.chatscape.data.MessageWriter;

public class GroupList implements CommandExecutor
{
	AddGroup ag = new AddGroup();
	RemGroup rg = new RemGroup();
	GList gl = new GList();
	GetGroups gg = new GetGroups();
	ToggleGroupList tgl = new ToggleGroupList();
	
	public boolean onCommand(CommandSender sender, Command cmd, String str,String[] args)
	{
		if (sender instanceof Player)
		{
			Info i = Data.getInfo((Player) sender);
			if (args.length >= 1)
			{
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
					MessageWriter.modeStatus(i);
				}
				else if (args[0].equalsIgnoreCase("toggle"))
				{
					tgl.executor(i, args);
				}
				else if (args[0].equalsIgnoreCase("mylist"))
				{
					gl.executor(i, args);
				}
				else if (args[0].equalsIgnoreCase("listgroups"))
				{
					gg.executor(i, args);
				}
				else
				{
					i.getPlayer().sendMessage(ChatColor.DARK_RED + args[0] + ChatColor.DARK_AQUA + " is not a valid arguement");
				}
			}
			else
			{
				sender.sendMessage(ChatColor.DARK_AQUA + "add" + ChatColor.BLUE + "- Adds a group to your group list");
				sender.sendMessage(ChatColor.DARK_AQUA + "rem" + ChatColor.BLUE + "- Removes a group from your group list");
				sender.sendMessage(ChatColor.DARK_AQUA + "toggle" + ChatColor.BLUE + "- Toggles group list on or off");
				sender.sendMessage(ChatColor.DARK_AQUA + "info" + ChatColor.BLUE + "- gets your info.....");
				sender.sendMessage(ChatColor.DARK_AQUA + "listgroups" + ChatColor.BLUE + "- Lists groups you have access to");
				sender.sendMessage(ChatColor.DARK_AQUA + "list" + ChatColor.BLUE + "- \n"
						+ ChatColor.DARK_AQUA +"/gl list " + ChatColor.WHITE + "-" + ChatColor.BLUE +" Returns all users on your group list \n"
						+ ChatColor.DARK_AQUA +"/gl list <string> " + ChatColor.WHITE + "-" + ChatColor.BLUE + "searches for whole names or partial matches");
			}
		}	
		return false;
	}
}
