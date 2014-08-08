package com.thedreamsanctuary.dreamtools.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.thedreamsanctuary.dreamtools.data.Data;
import com.thedreamsanctuary.dreamtools.data.Info;
import com.thedreamsanctuary.dreamtools.data.MessageWriter;

import configuration.Logger;

public class Private implements CommandExecutor
{
	static final String className = "Private";

	public boolean onCommand(CommandSender sender, Command cmd, String str,String[] args)
	{
		@SuppressWarnings("unused")
		String limitArg = " ";
		try
		{			
			Info i = Data.getInfo((Player) sender);
			if (args.length > 2)
			{
				sender.sendMessage(ChatColor.RED + "Error too many arguements!");
				
			}
			else
			{
				if (i.isChatEnabled())
				{
					//handles the variables  you can choose
					Logger.logIt("private : + " + sender.getName(), "log");
					
					//handles the variables  you can choose
					//System.out.println("args +++++ " + args[0]);
					if (args.length > 0)
					{
						limitArg = args[0];
						//Vanish All
						if (args[0].equalsIgnoreCase("vl"))
						{
							
						}
						if (args[0].equalsIgnoreCase("sa"))
						{
							i.setArgs(args[0]);
							//MessageWriter.modeStatus(this.getClass().getName(), (Player) sender, null, cmd.getName(), args[0]);
							for (Player p : Data.nonWL((Player) sender))
							{
								i.getPlayer().showPlayer(p);
							}
						}
						if (args[0].equalsIgnoreCase("info"))
						{
							MessageWriter.modeStatus((Player) sender);
						}
						
					}
					else
					{
						i.setChatEnabled(false);
					}
					MessageWriter.modeStatus((Player) sender);
				}
				else
				{
					sender.sendMessage(ChatColor.RED + "you are already running in private mode");
				}
				
			}
		
		} catch (Exception e)
		{
			e.printStackTrace();
			Logger.logIt("player: " + sender.getName() + " :: " +  e.toString(), Logger.error());
		}
		return false;
		
	}

}
