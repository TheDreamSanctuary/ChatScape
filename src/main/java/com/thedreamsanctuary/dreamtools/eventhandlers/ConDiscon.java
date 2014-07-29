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
				Bukkit.dispatchCommand(p, "/private");
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
			Bukkit.dispatchCommand(logoutEvent.getPlayer(), "/private");
		}
		if (i.isWhisperEnabled() == false)
		{
			Logger.logIt("Event whisper Disabled on logout: " + logoutEvent.getPlayer().getName(), Logger.playerInfo());
		}
	}
}