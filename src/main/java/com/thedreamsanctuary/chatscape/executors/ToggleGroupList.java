package com.thedreamsanctuary.chatscape.executors;

import org.bukkit.ChatColor;

import com.thedreamsanctuary.chatscape.config.Logger;
import com.thedreamsanctuary.chatscape.data.Info;

public class ToggleGroupList implements Executor
{

	public String Name() {
		// TODO Auto-generated method stub
		return null;
	}

	public void executor(Info i, String[] args) 
	{
		try
		{
			if (i.isGroupEnabled() == true)
			{
				i.setGroupEnabled(false);
				i.getPlayer().sendMessage(ChatColor.DARK_AQUA + "Your Group chat is now " + ChatColor.RED + "Disabled");
				Logger.logIt("wlToggleEnabled: " + i.getPlayer().getName(), "log");
			}
			else
			{
				i.setGroupEnabled(true);
				i.getPlayer().sendMessage(ChatColor.AQUA + "Your Group chat is now " + ChatColor.GREEN + "Enabled");
				Logger.logIt("wlToggleDisabled: " + i.getPlayer().getName(), "log");
			}
		} catch (Exception e)
		{
			Logger.logIt("player: " + i.getPlayer().getName() + " :: " +  e.toString(), "errorLog");
		}
		
	}

	public String permNode() {
		// TODO Auto-generated method stub
		return "chatScape.ToggleGroup";
	}

}
