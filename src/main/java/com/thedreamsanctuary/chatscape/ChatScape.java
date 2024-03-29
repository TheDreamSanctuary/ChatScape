package com.thedreamsanctuary.chatscape;

import java.util.logging.Level;

import net.milkbowl.vault.chat.Chat;
import net.milkbowl.vault.permission.Permission;

import org.bukkit.plugin.PluginDescriptionFile;

import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import com.thedreamsanctuary.chatscape.serialize.Serialize;
import com.thedreamsanctuary.chatscape.commands.GroupList;
import com.thedreamsanctuary.chatscape.commands.Private;
import com.thedreamsanctuary.chatscape.commands.Public;
import com.thedreamsanctuary.chatscape.commands.WhisperList;
import com.thedreamsanctuary.chatscape.config.Config;
import com.thedreamsanctuary.chatscape.data.Data;
import com.thedreamsanctuary.chatscape.eventhandlers.ChatEventListener;
import com.thedreamsanctuary.chatscape.eventhandlers.ConDiscon;
import com.thedreamsanctuary.chatscape.eventhandlers.OnCommand;


public class ChatScape extends JavaPlugin
{
	Serialize ser = new Serialize();
	Config cfg = new Config();
	//PluginManager p;
	public static Permission perms = null;
	public static Chat chat = null;
	ChatEventListener cev = new ChatEventListener();

	@Override
	public void onDisable() 
	{
	  ser.serializeList();
	  this.getLogger().log(Level.INFO, "Saving dreamIndex");	  
	}
	PluginDescriptionFile pdf = this.getDescription();
	
	@Override
	public void onEnable()
	{	
		if (getServer().getPluginManager().getPlugin("Vault") == null) 
		{
		   getLogger().log(Level.SEVERE, "Unable to hook vault");
		   getServer().getPluginManager().disablePlugin(this);
		}
		
		else
		{
			//Test

			
			//setups
			setupPermissions();
			getLogger().info("hooked Vault!");
			//ser.pluginData(this.getDataFolder().toString());
			getLogger().info("DATA FILE" + getDataFolder().toString());
			Data.setDataLoc(getDataFolder().toString());
			
			getLogger().log(Level.INFO, "importing serialized data");
			
			try
			{
				cfg.createDefaults();
				ser.deserializeList();
			} catch (Exception e)
			{
				e.printStackTrace();
				getLogger().log(Level.SEVERE, "Unable to import Serialized Data");
			}
			Data.setPerm(perms);
			//Data.setVersion(pdf.getVersion());
			//cev.setPermData(perms);
			
			getServer().getPluginManager().registerEvents(new ChatEventListener(), this);
			getServer().getPluginManager().registerEvents(new ConDiscon(), this);
			getServer().getPluginManager().registerEvents(new OnCommand(), this);
			//---------------------------------------------------//
			getServer().getPluginCommand("private").setExecutor(new Private());
			getServer().getPluginCommand("public").setExecutor(new Public());
			getServer().getPluginCommand("wl").setExecutor(new WhisperList());
			getServer().getPluginCommand("gl").setExecutor(new GroupList());
			//getServer().getPluginCommand("ctver").setExecutor(new Version());
			
			//---------------------------------------------------//

			//getServer().getPluginCommand("wlist").setExecutor(new wlList());
		}
		
		
	}
    private boolean setupPermissions()
    {
        RegisteredServiceProvider<Permission> permissionProvider = getServer().getServicesManager().getRegistration(net.milkbowl.vault.permission.Permission.class);
        if (permissionProvider != null) 
        {
            perms= permissionProvider.getProvider();
        }
        else
        	getLogger().log(Level.SEVERE,"Permission Hook null");
        return (perms != null);
    }


		
}
