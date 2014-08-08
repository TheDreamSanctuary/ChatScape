package com.thedreamsanctuary.dreamtools.eventhandlers;


import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import com.thedreamsanctuary.dreamtools.commands.Private;
import com.thedreamsanctuary.dreamtools.data.Data;
import com.thedreamsanctuary.dreamtools.data.Info;

import configuration.Logger;

public class ConDiscon implements Listener
{
	Private pr = new Private();
	
	@EventHandler
	public void onConnectEvent(PlayerJoinEvent loginEvent)
	{
		try
		{
			Player p = loginEvent.getPlayer();
			Info i = Data.getInfo(loginEvent.getPlayer());
			
			if (!i.isChatEnabled())
			{
			    if (Bukkit.getOnlinePlayers().contains(p))
			    {
				Bukkit.dispatchCommand(p, "/private");
			    }
			    else
				Logger.logIt("player: " + sender.getName() + "is not currently logged into the server");
				loginEvent.SetCancelled(true);
			}
		} catch (Exception e)
		{
			Logger.logIt(e.getMessage(), Logger.error());
		}
	}
	public void onDisconnectEvent(PlayerQuitEvent logoutEvent)
	{
		Info i = Data.getInfo(logoutEvent.getPlayer());
		
		if (!i.isChatEnabled())
		{
			if (Bukkit.getOnlinePlayers().contains(i.getPlayerName())
				Bukkit.dispatchCommand(logoutEvent.getPlayer(), "/private");
			else
				Logger.logit("Error user " + i.getPlayerName() + " is not currently logged in")
		}
		if (i.isWhisperEnabled() == false)
		{
			Logger.logIt("Event whisper Disabled on logout: " + logoutEvent.getPlayer().getName(), Logger.playerInfo());
		}
	}
}
