package Executors;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import com.thedreamsanctuary.dreamtools.data.Info;

public class pInfo implements Executor {

	public String Name() {
		// TODO Auto-generated method stub
		return null;
	}

	public void executor(Info i, String[] args) 
	{
		try
		{
			if (i.getPlayer().hasPermission(permNode()))
			{
				i.getPlayer().sendMessage("Users in grouplist");
				for (String p : i.getWhisperList())
				{
					i.getPlayer().sendMessage(ChatColor.BLUE + p);
				}
			}
			else
				i.getPlayer().sendMessage("You do not have access to execute this command");
		} catch (Exception e)
		{
			
		}	
	}

	public String permNode() {
		// TODO Auto-generated method stub
		return "dreamTools.pInfo";
	}

}
