package com.thedreamsanctuary.chatscape.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.thedreamsanctuary.chatscape.data.Data;
import com.thedreamsanctuary.chatscape.data.Info;
import com.thedreamsanctuary.chatscape.data.MessageWriter;
import com.thedreamsanctuary.chatscape.executors.AddPlayer;
import com.thedreamsanctuary.chatscape.executors.Override;
import com.thedreamsanctuary.chatscape.executors.Pinfo;
import com.thedreamsanctuary.chatscape.executors.RemPlayer;
import com.thedreamsanctuary.chatscape.executors.SetWLLimit;
import com.thedreamsanctuary.chatscape.executors.ToggleGroupList;
import com.thedreamsanctuary.chatscape.executors.ToggleWhisperList;
import com.thedreamsanctuary.chatscape.executors.WList;

public class WhisperList implements CommandExecutor
{
	public boolean onCommand(CommandSender sender, Command cmd, String arg, String[] args) 
	{
		Info i = Data.getInfo((Player) sender);
		AddPlayer ap = new AddPlayer();
		RemPlayer rp = new RemPlayer();
		Override ovr = new Override();
		ToggleWhisperList twl = new ToggleWhisperList();
		SetWLLimit swl = new SetWLLimit();
		WList wl = new WList();

		
		System.out.println("THE PLAYER" + i.getPlayer());
		if (args.length >= 1)
		{
			if (args[0].equalsIgnoreCase("add"))
			{
				ap.executor(i, args);
			}
			else if (args[0].equalsIgnoreCase("rem"))
			{
				rp.executor(i, args);
			}
			else if (args[0].equalsIgnoreCase("info"))
			{
				MessageWriter.modeStatus(i);
			}
			else if (args[0].equalsIgnoreCase("toggle"))
			{
				twl.executor(i, args);
			}
			else if (args[0].equalsIgnoreCase("override"))
			{
				ovr.executor(i, args);
			}
			else if (args[0].equalsIgnoreCase("limit"))
			{
				swl.executor(i, args);
			}
			else if (args[0].equalsIgnoreCase("list"))
			{
				wl.executor(i, args);
			}
		}
		else
		{
			sender.sendMessage(ChatColor.DARK_AQUA + "add" + ChatColor.BLUE + "- Adds a player to your group list");
			sender.sendMessage(ChatColor.DARK_AQUA + "rem" + ChatColor.BLUE + "- Removes a player from your group list");
			sender.sendMessage(ChatColor.DARK_AQUA + "toggle" + ChatColor.BLUE + "- Toggles player list on or off");
			sender.sendMessage(ChatColor.DARK_AQUA + "info" + ChatColor.BLUE + "- Lists all players you currently have added");
			sender.sendMessage(ChatColor.DARK_AQUA + "limit" + ChatColor.BLUE + "- Gets or sets the value of the limit");
			sender.sendMessage(ChatColor.DARK_AQUA + "list" + ChatColor.BLUE + "- \n"
					+ ChatColor.DARK_AQUA +"/wl list " + ChatColor.WHITE + "-" + ChatColor.BLUE +" Returns all users on your whisper list \n"
					+ ChatColor.DARK_AQUA +"/wl list <string> " + ChatColor.WHITE + "-" + ChatColor.BLUE + "searches for whole names or partial matches");
		}
		return false;
	}
}
