package com.thedreamsanctuary.dreamtools;

import java.util.logging.Level;

import net.milkbowl.vault.chat.Chat;
import net.milkbowl.vault.permission.Permission;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.RegisteredServiceProvider;

import com.thedreamsanctuary.dreamtools.Serialize.Serialize;
import com.thedreamsanctuary.dreamtools.commands.AddCustomPlayer;
import com.thedreamsanctuary.dreamtools.commands.CreateCustomGroup;
import com.thedreamsanctuary.dreamtools.commands.Private;
import com.thedreamsanctuary.dreamtools.commands.Public;
import com.thedreamsanctuary.dreamtools.commands.RemCustomPlayer;
import com.thedreamsanctuary.dreamtools.commands.ToggleGroupChat;
import com.thedreamsanctuary.dreamtools.commands.ToggleWhisperList;
import com.thedreamsanctuary.dreamtools.commands.WlAddg;
import com.thedreamsanctuary.dreamtools.commands.WlAddp;
import com.thedreamsanctuary.dreamtools.commands.WlRemg;
import com.thedreamsanctuary.dreamtools.commands.WlRemp;
import com.thedreamsanctuary.dreamtools.commands.listCustomGroups;
import com.thedreamsanctuary.dreamtools.data.Data;
import com.thedreamsanctuary.dreamtools.eventhandlers.ChatEventListener;
import com.thedreamsanctuary.dreamtools.eventhandlers.ConDiscon;
import com.thedreamsanctuary.dreamtools.eventhandlers.OnCommand;


public class DreamTools extends JavaPlugin
{
	Serialize ser = new Serialize();
	PluginManager p;
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
			//setups
			setupPermissions();
			setupChat();
			getLogger().info("hooked Vault!");
			ser.pluginData(this.getDataFolder().toString());
			Data.setDataLoc(this.getDataFolder().toString());
			Data.setChat(chat);
			//Data.setVersion(pdf.getVersion());
			
			ser.deserializeList();
			Data.setPerm(perms);
			//Data.setVersion(pdf.getVersion());
			//cev.setPermData(perms);
			
			getServer().getPluginManager().registerEvents(new ChatEventListener(), this);
			getServer().getPluginManager().registerEvents(new ConDiscon(), this);
			getServer().getPluginManager().registerEvents(new OnCommand(), this);
			//---------------------------------------------------//
			getServer().getPluginCommand("togglegl").setExecutor(new ToggleGroupChat());
			getServer().getPluginCommand("private").setExecutor(new Private());
			getServer().getPluginCommand("public").setExecutor(new Public());
			getServer().getPluginCommand("togglewl").setExecutor(new ToggleWhisperList());
			getServer().getPluginCommand("wladdcg").setExecutor(new AddCustomPlayer());
			getServer().getPluginCommand("wladdg").setExecutor(new WlAddg());
			getServer().getPluginCommand("wladdp").setExecutor(new WlAddp());	
			getServer().getPluginCommand("wlcreateg").setExecutor(new CreateCustomGroup());
			getServer().getPluginCommand("wllistcg").setExecutor(new listCustomGroups());
			getServer().getPluginCommand("wlremcg").setExecutor(new RemCustomPlayer());
			getServer().getPluginCommand("wlremg").setExecutor(new WlRemg());
			getServer().getPluginCommand("wlremp").setExecutor(new WlRemp());
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
    private boolean setupChat() 
    {
        RegisteredServiceProvider<Chat> rsp = getServer().getServicesManager().getRegistration(Chat.class);
        chat = rsp.getProvider();
        return chat != null;
    }

		
}
