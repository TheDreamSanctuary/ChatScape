package com.thedreamsanctuary.chatscape.executors;

import java.util.ArrayList;
import java.util.Arrays;

import org.bukkit.ChatColor;

import com.thedreamsanctuary.chatscape.data.Data;
import com.thedreamsanctuary.chatscape.data.Info;

public class GetGroups implements Executor
{
	
	public String Name() 
	{
		// TODO Auto-generated method stub
		return null;
	}

	public void executor(Info i, String[] args) 
	{
		ArrayList<String> groups = new ArrayList<String>(Arrays.asList(Data.getPerm().getGroups()));
		ArrayList<String> results = new ArrayList<String>();
		try
		{
			if (args.length >= 2)
			{
				for (String s : Data.getPerm().getGroups())
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
				i.getPlayer().sendMessage(ChatColor.BLUE + "Groups - Note this will only show those you are allowed to add");
				for (int c = 0; c >= groups.size(); c++)
				{
					if (i.getPlayer().hasPermission("chatscape.addGroup." + groups.get(c).toLowerCase()))
					{
						
					}
					else
						groups.remove(c);
				}
				
				if (groups.size() >  0)
				{
					for (String s : groups)
						i.getPlayer().sendMessage(ChatColor.DARK_PURPLE + s);
				}
				else
					i.getPlayer().sendMessage(ChatColor.RED + "You do not have permission to add any group, check to see if you have chatscape.addgroup.<groupname>");
			}
		} catch (Exception e)
		{
			
		}
		
	}

	public String permNode() {
		// TODO Auto-generated method stub
		return null;
	}

}
