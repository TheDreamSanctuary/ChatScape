package com.thedreamsanctuary.dreamtools.commands;

import java.util.ArrayList;
import java.util.Arrays;

import net.milkbowl.vault.permission.Permission;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.google.common.base.Preconditions;
import com.thedreamsanctuary.dreamtools.data.Data;
import com.thedreamsanctuary.dreamtools.data.Info;

import configuration.Logger;

public class WlAddg implements CommandExecutor
{
	Permission p;

	public boolean onCommand(CommandSender sender, Command cmd, String arg, String[] args) 
	{
		Preconditions.checkArgument(sender instanceof Player);
		Info i = Data.getInfo((Player) sender);
		{
			ArrayList<String> fl = new ArrayList<String>();
			try
			{
				if (args.length >=1)
				{
					for (String g : args)
					{
							if (!i.getGroupList().contains(g))
							{
								//Group Override
								if (!sender.hasPermission("DreamTools.groups.*"))
									sender.sendMessage("Error you do not have the permission to add this group!");
								//allows you to add specific groups to allow a user to add to their whisper list
								else if (!sender.hasPermission("DreamTools.groups." + g))
									sender.sendMessage("Error you do not have the permission to add this group!");
								
								else
									i.getGroupList().add(g);

							
								return true;
							}
							else
							{
								sender.sendMessage(ChatColor.BLUE + g + "has been added");
								fl.add(g);
							}		
					}
					//executes the list to return back the list of players who were not added to the list
				}
				else
					sender.sendMessage(ChatColor.RED + "Error unable to add group if you dont type one to add...");
			} catch (Exception e)
			{
				Logger.logIt("player: " + sender.getName() + " :: " +  e.toString(), "errorLog");
			}
			return false;
		}
	}
	public boolean groupExists(String groupName)
	{
		ArrayList<String> groups = new ArrayList<String>(Arrays.asList(p.getGroups()));
		if (groups.contains(groupName.toLowerCase()))
			return true;
		else
			return false;		
	}
	public boolean checkGroup(Player player)
	{
		return false;
		
	}

	
}
