package com.thedreamsanctuary.dreamtools.data;


import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class Info implements Serializable //extends Data
{
	@SuppressWarnings("unused")
	private String serVer = "1.0";
	private static final long serialVersionUID = 1L;
	private String player = " ";
	private String args = " ";
	private Set<String> whisperList = new HashSet<String>();
	private Set<String> groupList = new HashSet<String>();
	private boolean isChatEnabled = true;
	private boolean whisperIsEnabled = true;
	private boolean groupIsEnabled = true;
	private boolean isVanished = false;
	private boolean isOverriding = false;
	private String Message = " ";
	
	//returns player
	public Player getPlayer() 
	{
		Player play = Bukkit.getPlayer(player);
		

		return play;
	}
	//converts to string
	public void setPlayer(Player playerName) 
	{
		this.player = playerName.getName();
	}
	public Set<String> getGroupList() 
	{
		return groupList;
	}
	public boolean isChatEnabled() 
	{
		return isChatEnabled;
	}
	public void setChatEnabled(boolean isChatEnabled) 
	{
		this.isChatEnabled = isChatEnabled;
	}
	public boolean isWhisperEnabled() {
		return whisperIsEnabled;
	}
	public void setWhisperEnabled(boolean whisperIsEnabled) 
	
	{
		this.whisperIsEnabled = whisperIsEnabled;
	}
	public boolean isGroupEnabled() {
		return groupIsEnabled;
	}
	public void setGroupEnabled(boolean groupIsEnabled) {
		this.groupIsEnabled = groupIsEnabled;
	}
	public boolean isVanished() {
		return isVanished;
	}
	public void setVanished(boolean isVanished) {
		this.isVanished = isVanished;
	}
	public boolean isOverriding() {
		return isOverriding;
	}
	public void setOverriding(boolean isOverriding) {
		this.isOverriding = isOverriding;
	}
	public String getArgs() {
		return args;
	}
	public void setArgs(String args) {
		this.args = args;
	}
	public Set<String> getWhisperList() {
		return whisperList;
	}
/*	public Set<Player> getWhisperList() 
	{
		Set<Player> whisper =new HashSet<Player>();
		for (String p : this.whisperList)
			whisper.add(Bukkit.getPlayer(p));
		
		return whisper;
	} */
	/*private Info(Player p, Player wl, boolean isChatEnabled, boolean groupEnabled, boolean whisperEnabled)
	{
		this.playerName = p;
		this.isChatEnabled = isChatEnabled;
		this.whisperIsEnabled = whisperEnabled;
		this.groupIsEnabled = groupEnabled;
		
	} */
	public String getMessage() {
		return Message;
	}
	public void setMessage(String message) {
		Message = message;
	}
	
}
