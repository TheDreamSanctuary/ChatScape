package com.thedreamsanctuary.chatscape.executors;

import org.bukkit.ChatColor;

import com.thedreamsanctuary.chatscape.data.Data;
import com.thedreamsanctuary.chatscape.data.Info;

public class SetWLLimit implements Executor
{
	public String Name() {
		// TODO Auto-generated method stub
		return null;
	}

	public void executor(Info i, String[] args) 
	{
		if (args.length == 1)
		{
			i.getPlayer().sendMessage(ChatColor.DARK_AQUA + "Current limit is " +  Data.getWhisperLimit());
		}
		else if (args.length == 2)
		{
			System.out.print(args);
			int arg = Integer.parseInt(args[1]);
			Data.setWhisperLimit(arg);
		}
		else
			i.getPlayer().sendMessage(ChatColor.RED + "Error too many arguements -- Type /wl limit to get current value or /wl limit <#> to set a new one");
	}

	public String permNode() {
		// TODO Auto-generated method stub
		return null;
	}

}
