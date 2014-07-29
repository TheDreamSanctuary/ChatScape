package com.thedreamsanctuary.dreamtools.data;


import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import org.bukkit.entity.Player;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

public class Info implements Serializable //extends Data
{
	@SuppressWarnings("unused")
	private String serVer = "1.0";
	private static final long serialVersionUID = 1L;
	private Player playerName;
	private Set<Player> whisperList = new HashSet<Player>();
	private Set<String> groupList = new HashSet<String>();
	private Multimap<String,Player> customGroups = ArrayListMultimap.create();
	private boolean isChatEnabled = true;
	private boolean whisperIsEnabled = true;
	private boolean groupIsEnabled = true;
	private boolean isVanished = false;
	private boolean isOverriding = false;
	
	public Player getPlayerName() {
		return playerName;
	}
	public void setPlayerName(Player playerName) {
		this.playerName = playerName;
	}
	public Set<Player> getWhisperList() {
		return whisperList;
	}
	public void setWhisperList(Set<Player> whisperList) {
		this.whisperList = whisperList;
	}
	public Set<String> getGroupList() {
		return groupList;
	}
	public void setGroupList(Set<String> groupList) {
		this.groupList = groupList;
	}
	public boolean isChatEnabled() {
		return isChatEnabled;
	}
	public void setChatEnabled(boolean isChatEnabled) {
		this.isChatEnabled = isChatEnabled;
	}
	public boolean isWhisperEnabled() {
		return whisperIsEnabled;
	}
	public void setWhisperEnabled(boolean whisperIsEnabled) {
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
	public Multimap<String,Player> getCustomGroups() {
		return customGroups;
	}
	public void setCustomGroups(Multimap<String,Player> customGroups) {
		this.customGroups = customGroups;
	}
	
	/*private Info(Player p, Player wl, boolean isChatEnabled, boolean groupEnabled, boolean whisperEnabled)
	{
		this.playerName = p;
		this.isChatEnabled = isChatEnabled;
		this.whisperIsEnabled = whisperEnabled;
		this.groupIsEnabled = groupEnabled;
		
	} */
	
}
