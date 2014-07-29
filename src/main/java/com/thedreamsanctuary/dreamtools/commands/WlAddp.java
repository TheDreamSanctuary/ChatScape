package com.thedreamsanctuary.dreamtools.commands;

import java.util.ArrayList;
import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.thedreamsanctuary.dreamtools.data.Data;
import com.thedreamsanctuary.dreamtools.data.Info;

import configuration.Logger;

public class WlAddp implements CommandExecutor
{
	public boolean onCommand(CommandSender sender, Command cmd, String arg, String[] args) 
	{
		Info i = Data.getInfo((Player) sender);
		//failed user list + player online list
		Player sndr = (Player) sender;
		ArrayList<Player> fl = new ArrayList<Player>();
		ArrayList<Player> arr = new ArrayList<Player>(Arrays.asList(Bukkit.getOnlinePlayers()));
		try
		{
			if (args.length >=1)
			{
				for (String p : args)
				{
					Player player = Bukkit.getPlayer(p);
					
					//checks to see if the player is currenly online, it also checks to see if the 
					if (arr.contains(player))
					{
						if (!i.getWhisperList().contains(player))
						{
							i.getWhisperList().add(player);
							System.out.println("WL ADDED" + player);
							sender.sendMessage("added user" + player.getName());
							
							if (!i.isChatEnabled())
							{
								player.showPlayer(sndr);
								sndr.showPlayer(player);
							}
							return true;
							
							
						}
						{
							fl.add(player);
							
							
						}
					}
					else
					{
						fl.add(player);
						System.out.println("FL size " + fl.size());
					}
					
				}
				
				//executes the list to return back the list of players who were not added to the list
				
				if (fl.isEmpty())
				{
					
				}
				else
				{
					sender.sendMessage(ChatColor.RED + "" + fl.size() + ChatColor.WHITE + " failed to be added to your whisperlist" );
					for (Player p : fl)
						sender.sendMessage(" " + p.getName());
				}
			}
			else
				sender.sendMessage("Unable to add anything when you dont actually add any names...");
		} catch (Exception e)
		{
			Logger.logIt("player: " + sender.getName() + " :: " +  e.toString(), "errorLog");
		}
		return false;
	}
}
