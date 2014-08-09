package com.thedreamsanctuary.chatscape.executors;

import org.bukkit.ChatColor;

import com.thedreamsanctuary.chatscape.data.Data;
import com.thedreamsanctuary.chatscape.data.Info;

public class SetGLList 
{
	public String Name() 
	{
		// TODO Auto-generated method stub
		return null;
	}
	public void executor(Info i, String[] args) 
	{
		if (args.length == 1)
		{
			i.getPlayer().sendMessage(ChatColor.DARK_AQUA + "Current limit is" +  Data.getGroupLimit());
		}
		else if (args.length == 2)
		{
			Data.setGroupLimit(Integer.parseInt(args[1]));
		}
		else
			i.getPlayer().sendMessage(ChatColor.RED + "Too many arguements");
	}

	public String permNode() {
		// TODO Auto-generated method stub
		return null;
	}
}
