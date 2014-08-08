package Executors;

import org.bukkit.ChatColor;

import com.thedreamsanctuary.dreamtools.data.Info;

public class gInfo implements Executor
{

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
				for (String g : i.getGroupList())
				{
					i.getPlayer().sendMessage(ChatColor.BLUE + g);
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
		return "dreamTools.gInfo";
	}


}
