package com.thedreamsanctuary.chatscape.executors;

import org.bukkit.ChatColor;

import com.thedreamsanctuary.chatscape.config.Logger;
import com.thedreamsanctuary.chatscape.data.Info;

public class ToggleWhisperList implements Executor
{

	public String Name() {
		// TODO Auto-generated method stub
		return null;
	}

	public void executor(Info i, String[] args) 
	{
		try
		{
			if (i.isWhisperEnabled() == true)
			{
				i.setWhisperEnabled(false);
				i.getPlayer().sendMessage(ChatColor.DARK_AQUA + "Your Whisper chat is now " + ChatColor.RED + "Disabled");
				Logger.logIt("wlToggleEnabled: " + i.getPlayer().getName(), "log");
			}
			else
			{
				i.setWhisperEnabled(true);
				i.getPlayer().sendMessage(ChatColor.AQUA + "Your Whisper chat is now " + ChatColor.GREEN + "Enabled");
				Logger.logIt("wlToggleDisabled: " + i.getPlayer().getName(), "log");
			}
		} catch (Exception e)
		{
			Logger.logIt("player: " + i.getPlayer().getName() + " :: " +  e.toString(), "errorLog");
		}
		
	}

	public String permNode() {
		// TODO Auto-generated method stub
		return "chatScape.toggleWhisper";
	}

}
