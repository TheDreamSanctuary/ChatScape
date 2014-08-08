package com.thedreamsanctuary.dreamtools.data;
 
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import net.milkbowl.vault.chat.Chat;
import net.milkbowl.vault.permission.Permission;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class Data
{

	private String serVer = "1.0";
	private static Map<String, Info> pInfo = new HashMap<String, Info>();
	private static String dataLoc;
	private static Chat chat;
	private static Permission  perm;
	private static String version;
	private static String ConfigVer;
	private static int WhisperLimit;
	private static int GroupLimit;
	private static int CustomError;

	// PlayerData pd = new PlayerData();
	// protected SerializedData sd = new SerializedData();

	/*--------Data Handlers *-----------*/

	public static int getSize() 
	{
		return pInfo.size();
	}

	public static void setData(Map<String, Info> map) 
	{
		pInfo = map;
	}

	public static Map<String, Info> getData() {
		return pInfo;
	}

	public static Info getInfo(Player sender) 
	{
		String playerName = ((Player) sender).getName();
		if (!pInfo.containsKey(playerName)) 
		{
			Info ia = new Info();
			//Defaulted
			ia.setPlayer(sender);
			//Creates the new player profile and also adds them to their own whisperlist
			pInfo.put(((Player) sender).getName(), new Info());
			Info i = Data.getInfo(sender);
			i.getWhisperList().add(sender.getName());
			i.setPlayer((Player) sender);
		} 
		else 
		{
			return pInfo.get(playerName);
		}
		for (Entry<String, Info> entry : pInfo.entrySet())
		{
			if (entry.getKey().equals(playerName))
				return (entry.getValue());
		}
		return null;
	}
	public static ArrayList<Player> getWList(Player player)
	{
		ArrayList<Player> whispList = new ArrayList<Player>();
		for (Player p : wlDisabled())
		{
			Info i = getInfo(p);
			
			if (i.getWhisperList().contains(player))
				whispList.add(p);
			else
			{}
			return whispList;

		}
		
		return whispList;
	}
	
	public static ArrayList<Player> wlDisabled() {
		ArrayList<Player> wlData = new ArrayList<Player>();

		for (Entry<String, Info> entry : pInfo.entrySet()) {
			if (!entry.getValue().isChatEnabled())
				wlData.add(Bukkit.getPlayer(entry.getKey()));
		}
		return wlData;

	}

	public static ArrayList<Player> searchGroups(String perm) 
	{
		ArrayList<Player> glData = new ArrayList<Player>();
		for (Entry<String, Info> entry : pInfo.entrySet()) {
			if (entry.getValue().getGroupList().contains(perm))
				glData.add(Bukkit.getPlayer(entry.getKey()));
		}
		return glData;
	}
	/*
	 * Gets Data from the Configuratoin file
	 */
	public static ArrayList<Player> nonWL(Player player)
	{
		ArrayList<Player> playerData = new ArrayList<Player>();
		for (Player p : Bukkit.getOnlinePlayers())
		{
			if (!wlDisabled().contains(p))
			{
				playerData.add(p);
			}
			else
			{}
		}
		return playerData;
	}
	public String getVer()
	{
		return this.serVer;
	}
	public static void setChat(Chat chat)
	{
		Data.chat = chat;
	}
	public Chat getChat()
	{
		return Data.chat;
		
	}

	public static Permission getPerm() {
		return perm;
	}

	public static void setPerm(Permission perm) {
		Data.perm = perm;
	}

	public static String getVersion() {
		return version;
	}

	public static void setVersion(String version) {
		Data.version = version;
	}

	public static String getDataLoc() {
		return dataLoc;
	}

	public static void setDataLoc(String dataLoc) {
		Data.dataLoc = dataLoc;
	}

	public static String getConfigVer() {
		return ConfigVer;
	}

	public static void setConfigVer(String configVer) {
		ConfigVer = configVer;
	}

	public static int getWhisperLimit() {
		return WhisperLimit;
	}

	public static void setWhisperLimit(int whisperLimit) {
		WhisperLimit = whisperLimit;
	}

	public static int getGroupLimit() {
		return GroupLimit;
	}

	public static void setGroupLimit(int groupLimit) {
		GroupLimit = groupLimit;
	}

	public static int getCustomError() {
		return CustomError;
	}

	public static void setCustomError(int customError) {
		CustomError = customError;
	}
}