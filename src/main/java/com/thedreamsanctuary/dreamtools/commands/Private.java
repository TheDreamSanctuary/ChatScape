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

public class Private implements CommandExecutor
{
	public boolean onCommand(CommandSender sender, Command cmd, String str,String[] args)
	{

		try
		{
			Info i= Data.getInfo((Player) sender);
			i.setPlayerName((Player) sender);
			Preconditions.checkArgument(sender instanceof Player);
			if (args.length > 2)
			{
				sender.sendMessage(ChatColor.RED + "Error too many arguements!");
				
			}
			else
			{
				if (i.isChatEnabled())
				{
					//handles the variables  you can choose
					Logger.logIt("private : + " + sender.getName(), "log");
					i.setChatEnabled(false);
					
					//handles the variables  you can choose
					System.out.println("args +++++ " + args[0]);
					if (!args[0].isEmpty())
					{
						//Vanish All
						if (args[0].equalsIgnoreCase("-vl"))
						{
							sender.sendMessage(ChatColor.AQUA + "You have gone into private mode + Vanished All non whisperlisted");
							for (Player p : Data.nonWL((Player) sender))
							{
								i.getPlayerName().hidePlayer(p);
								p.hidePlayer(i.getPlayerName());
							}
						}
						if (args[0].equalsIgnoreCase("-sa"))
						{
							sender.sendMessage(ChatColor.AQUA + "You have gone into private mode + Show All Players");
							for (Player p : Data.nonWL((Player) sender))
							{
								i.getPlayerName().showPlayer(p);
							}
						}
						else
							sender.sendMessage(ChatColor.AQUA + "You have gone into private mode");
					}
					//removes the player from the list who are not on the whisper lists
					for (Player p : Data.nonWL((Player) sender))
					{
						p.hidePlayer((Player) sender);
					}
				}
				else
				{
					sender.sendMessage(ChatColor.RED + "You are already running in private mode");
				}						
			}
		
		} catch (Exception e)
		{
			e.printStackTrace();
			Logger.logIt("player: " + sender.getName() + " :: " +  e.toString(), Logger.error());
		}
		return false;
		
	}

}
