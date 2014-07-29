package com.thedreamsanctuary.dreamtools.commands;

import java.util.ArrayList;

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

public class WlRemg implements CommandExecutor
{
	Permission p;
	public boolean onCommand(CommandSender sender, Command cmd, String arg, String[] args) 
	{
		Info i = Data.getInfo((Player) sender);

		ArrayList<String> fl = new ArrayList<String>();
		try
		{
			Preconditions.checkArgument(sender instanceof Player);
			
			if (args.length >=1)
			{
				for (String input : args)
				{
					i.getGroupList().remove(input);
				}
				sender.sendMessage(ChatColor.RED + "" + fl.size() + " groups failed to be removed (Are they even listed?");
				if (!(fl.size() >= 1))
				{
					for (String p : fl)
					sender.sendMessage(p);
				}
				else
				{}
					
			}
		} catch (Exception e)
		{
			Logger.logIt("player: " + sender.getName() + " :: " +  e.toString(), "errorLog");
		}
		return false;
	}
}
