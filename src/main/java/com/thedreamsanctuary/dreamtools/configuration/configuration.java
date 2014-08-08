package configuration;

import org.bukkit.plugin.Plugin;

public class configuration 
{
	Plugin plugin;
	
	public boolean createDefaults()
{
		plugin.getConfig().addDefault("dreamTools.whisperlimit", 15);
		plugin.getConfig().addDefault("dreamTools.groupLimit", 15);
		plugin.getConfig().addDefault("dreamTools.Vanish", true);
		plugin.getConfig().addDefault("dreamTools.groupChat", true);
		plugin.getConfig().addDefault("dreamTools.playerChat", true);
		plugin.getConfig().addDefault("dreamTools.list Limit", 15);
		plugin.getConfig().options().copyDefaults();
		return false;
	}


	public int getWhisperLimit() {
		return plugin.getConfig().getInt("dreamTools.whisperlimit");
	}


	public void setWhisperLimit(int whisperLimit) {
		plugin.getConfig().set("dreamTools.whisperlimit", whisperLimit);
	}


	public int getGroupLimit() {
		return plugin.getConfig().getInt("dreamTools.groupLimit");
	}


	public void setGroupLimit(int groupLimit) {
		plugin.getConfig().set("dreamTools.whisperlimit", groupLimit);
	}


	public boolean isChatLimit() {
		return plugin.getConfig().getBoolean("dreamTools.groupChat");
	}


	public void setChatLimit(boolean chatLimit) {
		plugin.getConfig().set("dreamTools.playerChat", chatLimit);
	}	
}
