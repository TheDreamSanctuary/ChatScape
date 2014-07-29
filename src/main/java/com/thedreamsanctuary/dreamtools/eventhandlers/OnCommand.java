package com.thedreamsanctuary.dreamtools.eventhandlers;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import com.google.common.base.Preconditions;
import com.thedreamsanctuary.dreamtools.data.Data;
import com.thedreamsanctuary.dreamtools.data.Info;

import configuration.Logger;

public class OnCommand implements Listener
{
	
	private Map<Player,Player> wlHandles = new HashMap<Player,Player>();
	
	@EventHandler
	public void onCommandProccess(PlayerCommandPreprocessEvent event)
	{	
		//ArrayList<String> str = new ArrayList<String>(Arrays.asList(event.getMessage()));
		String[] str = event.getMessage().split("\\s");
		String cmd = str[0];

		try
		{
			
			if (str.length >= 2)
			{
				if (cmd.equalsIgnoreCase("/tell"))
					execProcess(event,str, cmd);
	
				else if (cmd.equalsIgnoreCase("/w"))
					execProcess(event,str, cmd);	
				
				else if (cmd.equalsIgnoreCase("/msg"))
					execProcess(event,str, cmd);	
				
				else if (cmd.equalsIgnoreCase("/r"))
					execProcess(event,str, cmd);	
				else if (cmd.equalsIgnoreCase("/reply"))
					execProcess(event,str, cmd);	
			}
		} catch (Exception e)
		{
			Logger.logIt(e.toString(), Logger.error());
		}
	}
	
	private void execProcess(PlayerCommandPreprocessEvent event, String[] str, String cmd)
	{		
		Preconditions.checkArgument(Bukkit.getPlayer(str[1]) instanceof Player);
		Player player = Bukkit.getPlayer(str[1]);
		//Player sender = event.getPlayer();
		
		//Info i = Data.getInfo(player);
		if ((cmd.equalsIgnoreCase("/r")) || (cmd.equalsIgnoreCase("/reply")))
		{
			Player recipient = getReceived(player);
			
			if (!recipient.isEmpty())
			{
				Info i = Data.getInfo(recipient);
				if (!i.isWhisperEnabled())
				{
					if (i.getWhisperList().contains(event.getPlayer()))
					{
						recipient.sendMessage(event.getMessage());
					}
					else
					{
						event.getPlayer().sendMessage(ChatColor.RED + "You cannot message this player because they are set to private");
						event.setCancelled(true);
					}
				}
			}
			else
				event.getPlayer().sendMessage("This player doesn't exist");
		}
		else
		{
			Player p = Bukkit.getPlayer(str[1]);
			Info i = Data.getInfo(p); 
			if (!i.isChatEnabled())
			{
				if (i.getWhisperList().contains(event.getPlayer()))
				{
					 p.sendMessage(event.getMessage());
				}
				else
				{
					event.getPlayer().sendMessage(ChatColor.RED + "You cannot message this player because they are set to private");
					event.setCancelled(true);
				}
			}
			
		}
	}
	private Player getReceived(Player p)
	{
		for (Entry<?, ?> e : wlHandles.entrySet())
		{
			if (e.getKey().equals(p)) 
				return (Player) e.getValue();
		}
		return null;
		
	}
}
