package Executors;

import java.util.ArrayList;
import java.util.Arrays;

import org.bukkit.ChatColor;

import com.thedreamsanctuary.dreamtools.data.Data;
import com.thedreamsanctuary.dreamtools.data.Info;

public class remGroup implements Executor
{

	public String Name() {
		// TODO Auto-generated method stub
		return null;
	}

	public void executor(Info i, String[] args) 
	{
		ArrayList<String> groupList= new ArrayList<String>(Arrays.asList(Data.getPerm().getGroups()));
		ArrayList<String> arg = new ArrayList<String>(Arrays.asList(args));
		ArrayList<String> checkList = new ArrayList<String>();
		arg.remove(0);
		
		if (args.length >=1)
		{
			for (String s : arg)
			{
				if (groupList.contains(s))
				{
					if (i.getPlayer().hasPermission(permNode() +"." + s))
					{
						if (i.getGroupList().contains(s))
						{
							i.getGroupList().remove(s);
							checkList.add(ChatColor.DARK_RED + s + ChatColor.WHITE + "....." + ChatColor.GREEN + "Success");
						}
						else
							checkList.add(ChatColor.DARK_RED + s + ChatColor.WHITE + "....." + ChatColor.RED + "Failed - " + ChatColor.GRAY + "not added");
					}
					else
						checkList.add(ChatColor.DARK_RED + s + ChatColor.WHITE + "....." + ChatColor.RED + "Failed - " + ChatColor.GRAY + "no perms");
				}
				else
					checkList.add(ChatColor.DARK_RED + s + ChatColor.WHITE + "....." + ChatColor.RED + "Failed - " + ChatColor.GRAY + "null");
			}
			for (String s : checkList)
			{
				i.getPlayer().sendMessage(s);
			}
		}		
	}
		

	public String permNode() {
		// TODO Auto-generated method stub
		return "dreamTools.remGroup";
	}

}
