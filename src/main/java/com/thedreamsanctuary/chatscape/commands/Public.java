
package com.thedreamsanctuary.chatscape.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.google.common.base.Preconditions;
import com.thedreamsanctuary.chatscape.config.Logger;
import com.thedreamsanctuary.chatscape.data.Data;
import com.thedreamsanctuary.chatscape.data.Info;
import com.thedreamsanctuary.chatscape.eventhandlers.ChatEventListener;


public class Public implements CommandExecutor
{
	static final String Public = "public";
	
	ChatEventListener cel = new ChatEventListener();
	public boolean onCommand(CommandSender sender, Command cmd, String str,String[] args)
	{
		Preconditions.checkArgument(sender instanceof Player);
		Info i = Data.getInfo((Player) sender);
		try
		{
			Preconditions.checkArgument(sender instanceof Player);
			Player snd = (Player) sender;
				if (!i.isChatEnabled())
				{
					sender.sendMessage(ChatColor.AQUA + "You have gone into public mode");
					Bukkit.broadcastMessage("�7" + sender.getName() + " is now in public mode");
					Logger.logIt("Public: " + sender.getName(), "log");
					i.setChatEnabled(true);
					
					//showplayer for both when player is hidden or not
					for (Player p : Data.nonWL((Player) sender))
					{
						p.showPlayer(snd);
						snd.showPlayer(p);
					}
				}
				else
				{
					sender.sendMessage(ChatColor.RED + "You are not in private mode!");
					Logger.logIt(cmd.toString() + " :: " + sender.getName() + " :: " + "Failed", Logger.playerInfo());
				}
				
		} catch (Exception e)
		{
			e.printStackTrace();
			Logger.logIt("player: " + sender.getName() + " :: " +  e.toString(), Logger.error());
		}
		return false;		
	}
}
