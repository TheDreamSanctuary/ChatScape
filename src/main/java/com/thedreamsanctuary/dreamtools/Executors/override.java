package com.thedreamsanctuary.dreamtools.Executors;

import org.bukkit.ChatColor;

import com.thedreamsanctuary.dreamtools.configuration.Logger;
import com.thedreamsanctuary.dreamtools.data.Info;

public class override implements Executor
{

	public String Name() {
		// TODO Auto-generated method stub
		return null;
	}

	public void executor(Info i, String[] args) 
	{
		try
		{
			if (i.isOverriding() == true)
			{
				i.setOverriding(false);
				i.getPlayer().sendMessage(ChatColor.DARK_AQUA + "Override is now" + ChatColor.RED + "Disabled");
				Logger.logIt("OverrideEnabled: " + i.getPlayer().getName(), "log");
			}
			else
			{
				i.setOverriding(true);
				i.getPlayer().sendMessage(ChatColor.AQUA + "Override is now " + ChatColor.GREEN + "Enabled");
				Logger.logIt("OverrideDisabled: " + i.getPlayer().getName(), "log");
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		
	}

	public String permNode() {
		// TODO Auto-generated method stub
		return null;
	}

}
