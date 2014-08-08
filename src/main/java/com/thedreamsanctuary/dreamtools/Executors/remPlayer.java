package com.thedreamsanctuary.dreamtools.Executors;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import com.google.common.base.Preconditions;
import com.thedreamsanctuary.dreamtools.configuration.Logger;
import com.thedreamsanctuary.dreamtools.data.Info;

public class remPlayer implements Executor
{
	
	public String Name() {
		// TODO Auto-generated method stub
		return null;
	}

	public void executor(Info i, String[] args) 
	{
		Set<String> checkList = new HashSet<String>();
		ArrayList<String> arg = new ArrayList<String>(Arrays.asList(args));
		arg.remove(0);
		
		Preconditions.checkArgument(i.getPlayer() instanceof Player);
		try
		{
			if (i.getPlayer().hasPermission(permNode()))
			{
				for (String s : arg)
				{			
					if (i.getWhisperList().contains(s))
					{
						i.getWhisperList().remove(s);
						checkList.add(ChatColor.BLUE + s + ChatColor.WHITE +  "....." +  ChatColor.GREEN + "Succeeded");

					}
					else
						checkList.add(ChatColor.BLUE + s + ChatColor.WHITE +  "....." + ChatColor.RED +"Failed");
				}
				for (String s : checkList)
					i.getPlayer().sendMessage(s);
			}
			else
				i.getPlayer().sendMessage(ChatColor.RED + "You do not have permission to do this");
		} catch (Exception e)
		{
			Logger.logIt("player: " + i.getPlayer().getName() + " :: " +  e.toString(), "errorLog");
		}		
	}

	public String permNode() {
		// TODO Auto-generated method stub
		return "dreamTools.remPlayer";
	}
	
}
