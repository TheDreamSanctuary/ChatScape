package com.thedreamsanctuary.dreamtools.eventhandlers;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;





import com.thedreamsanctuary.dreamtools.data.Data;
import com.thedreamsanctuary.dreamtools.data.Info;



//import net.milkbowl.vault.permission.Permission;
//import net.milkbowl.vault.permission.Permission;


public class ChatEventListener implements Listener
{
	public Player player;
	
	//protected static Permission perm;	
	
	
	/*public void setPermData(Permission p)
	{
		if (p.isEnabled())
			ChatEventListener.perm = p;
	} */

	
	@EventHandler(priority = EventPriority.HIGHEST)
	public boolean chatHandler(AsyncPlayerChatEvent event)
	{
		Player player = event.getPlayer();
		boolean executed = false;
		ArrayList<Player> disList = new ArrayList<Player>(Data.wlDisabled());
			
		for (Player p : disList)
		{
			event.getRecipients().remove(p);			
		}
		
		for (Player disPlayer : disList)
		{
			Info i = Data.getInfo(disPlayer);
			Info j = Data.getInfo(player);
			
			if (i.getWhisperList().contains(player.getName()))
			{
				disPlayer.sendMessage(ChatColor.DARK_GRAY + "["+  ChatColor.DARK_BLUE + "WL" + ChatColor.DARK_GRAY +"]" + " " + ChatColor.DARK_AQUA + player.getName()+  ": " + ChatColor.WHITE + event.getMessage());
				executed = true;
			}
			if (i.isGroupEnabled() == true)
			{
				if (i.getGroupList().contains(Data.getPerm().getPrimaryGroup(disPlayer)) && executed != true)
				{
					disPlayer.sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.DARK_GREEN + "Group" + ChatColor.DARK_GRAY +"]" +  ChatColor.BLUE + " " +  player.getName() + ": " + ChatColor.WHITE + event.getMessage());
					executed = true;
				}
			}
			if (player.hasPermission("dreamTools.override"))
			{
				if ((j.isOverriding() == true) && (executed != true))
				{
						disPlayer.sendMessage(ChatColor.DARK_GRAY + "["+ ChatColor.DARK_PURPLE + player.getName() + ChatColor.GRAY +"] " + ChatColor.WHITE + event.getMessage());
				}
			}
		}
		
		return false;
	}
}
