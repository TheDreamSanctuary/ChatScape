package com.thedreamsanctuary.chatscape.executors;

import java.util.ArrayList;

import org.bukkit.ChatColor;

import com.thedreamsanctuary.chatscape.data.Info;

public class GList implements Executor
{
	public String Name() 
	{
		// TODO Auto-generated method stub
		return null;
	}

	public void executor(Info i, String[] args) 
	{
		ArrayList<String> results = new ArrayList<String>();
		if (args.length > 1)
		{
			for (String s : i.getGroupList())
			{
				if (s.toLowerCase().startsWith(args[1].toLowerCase()))
					results.add(s);
			}
			if (results.size() >= 1)
			{
				i.getPlayer().sendMessage(ChatColor.DARK_AQUA + "Query Results: ");
				for (String s : results)
				{
					i.getPlayer().sendMessage(ChatColor.DARK_PURPLE + s);
				}
			}
			else
			{
				i.getPlayer().sendMessage(ChatColor.DARK_RED + "no results found");
			}
			
		}
		else 
		{
			i.getPlayer().sendMessage(ChatColor.DARK_AQUA + "grouplist: ");
			if (i.getWhisperList().size() >= 1)
			{
				for (String s : i.getGroupList())
				i.getPlayer().sendMessage(s);
			}
			else
				i.getPlayer().sendMessage(ChatColor.DARK_RED + "No players found");
		}
	}

	public String permNode() {
		// TODO Auto-generated method stub
		return "chatscape.glist";
	}

}
 