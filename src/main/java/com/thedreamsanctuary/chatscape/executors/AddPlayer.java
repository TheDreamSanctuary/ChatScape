package com.thedreamsanctuary.chatscape.executors;

import java.util.ArrayList;
import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import com.thedreamsanctuary.chatscape.data.Data;
import com.thedreamsanctuary.chatscape.data.Info;


public class AddPlayer implements Executor
{
	String limitArg = " ";
	public String Name() {
		// TODO Auto-generated method stub
		return "addp";
	}

	public void executor(Info i, String args[]) 
	{		
		//failed user list + player online list
		//Player sndr = (Player) i.getPlayer();
		ArrayList<String> checkList = new ArrayList<String>();
		ArrayList<Player> online = new ArrayList<Player>(Arrays.asList(Bukkit.getOnlinePlayers()));
		ArrayList<String> arg = new ArrayList<String>(Arrays.asList(args));
		arg.remove(0);
		
		try
		{
			if (i.getPlayer().hasPermission(this.permNode()))
			{
				//System.out.println("SIZE OF" + args.length);
				if (arg.size() >= 1)
				{
					for (String s : arg)
					{
						System.out.println("Count" + s);
					Player player = Bukkit.getPlayer(s);
						
						
						//checks to see if the player is currenly online, it also checks to see if the 
						if (online.contains(player))
						{
							//Checks if player is contained on whisperlist
							if (!i.getWhisperList().contains(player.getName()))
							{
								//Checks to see if they have reached limit or not
								if (i.getWhisperList().size() <= Data.getWhisperLimit() )
								{
									i.getWhisperList().add(player.getName());
									checkList.add(ChatColor.BLUE + s + "....." +  ChatColor.GREEN + "Succeeded");
								
									//Sets the player visible both ways
									if (!i.isChatEnabled())
									{
										player.showPlayer(i.getPlayer());
										i.getPlayer().showPlayer(player);
									}	
								}
								else
									checkList.add(ChatColor.BLUE + s + ChatColor.WHITE + "....." +  ChatColor.RED + "Failed -Limit Reached");
								
							}
							else
							{
								checkList.add(ChatColor.BLUE + s + ChatColor.WHITE + "....." +  ChatColor.RED + "Failed -Player already exists");
								
								
							}
						}
						else
						{
							checkList.add(ChatColor.BLUE + s + ChatColor.WHITE + "....." +  ChatColor.RED + "Failed - not online");
						
						}
						
					}
					
					for (String s : checkList)
					{
						i.getPlayer().sendMessage(s);
					}

					
					//executes the list to return back the list of players who were not added to the list
				}
				else
					i.getPlayer().sendMessage("Unable to add anything when you dont actually add any names...");
			}
			else
				i.getPlayer().sendMessage("You do not have permission to execute this command!");
			
		} catch (Exception e)
		{
			e.printStackTrace();//Logger.logIt("player: " + i.getPlayer().getName() + " :: " +  e.toString(), "errorLog");
		}
	}
	

	public String permNode() {
		// TODO Auto-generated method stub
		return "chatScape.addPlayer";
	}
}
