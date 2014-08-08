package Executors;

import org.bukkit.ChatColor;

import com.thedreamsanctuary.dreamtools.data.Info;

import configuration.Logger;

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
				Logger.logIt("wlToggleEnabled: " + i.getPlayer().getName(), "log");
			}
			else
			{
				i.setGroupEnabled(true);
				i.getPlayer().sendMessage(ChatColor.AQUA + "Override is now " + ChatColor.GREEN + "Enabled");
				Logger.logIt("wlToggleDisabled: " + i.getPlayer().getName(), "log");
			}
		} catch (Exception e)
		{
			Logger.logIt("player: " + i.getPlayer().getName() + " :: " +  e.toString(), "errorLog");
		}
		
	}

	public String permNode() {
		// TODO Auto-generated method stub
		return null;
	}

}
