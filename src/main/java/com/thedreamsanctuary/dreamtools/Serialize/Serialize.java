package com.thedreamsanctuary.dreamtools.Serialize;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Map;

import org.bukkit.Bukkit;

import com.thedreamsanctuary.dreamtools.configuration.Config;
import com.thedreamsanctuary.dreamtools.data.Data;
import com.thedreamsanctuary.dreamtools.data.Info;


public class Serialize extends Data 
{
	@SuppressWarnings("unused")
	private static final long serialVersionUID = 1L;
	// Data d = new Data();

	public void checkData() 
	{
		try 
		{
			File loc = new File(Data.getDataLoc());
			File f = new File(Data.getDataLoc());

			if (!loc.isDirectory())
				loc.mkdirs();

			if (!f.exists())
			{
				if (Config.getSerializeVer() == Data.getConfigVer())
					Bukkit.getLogger().warning("Serialize File is out of date");						
				serializeList();
			}
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

	public boolean serializeList() 
	{
		FileOutputStream outputStream;

		// if (!new File(pluginLoc + this.getName()).exists())

		try 
		{
			outputStream = new FileOutputStream(Data.getDataLoc() + "/DreamTools.ser");

			ObjectOutputStream out = new ObjectOutputStream(outputStream);

			out.writeObject(Data.getData());
			out.close();

			return true;
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
			// getLogger().log(Level.SEVERE,
			// "Error unable to serialize the group file" + d.getGroupName());
			return false;
		}

	}

	@SuppressWarnings("unchecked")
	public boolean deserializeList() 
	{
		checkData();
		try 
		{
			FileInputStream inputStream = new FileInputStream(Data.getDataLoc() + "/DreamTools.ser");
			ObjectInputStream in = new ObjectInputStream(inputStream);

			Data.setData((Map<String, Info>) in.readObject());

			in.close();
			inputStream.close();

			// this.d = localData;
			return true;
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		} 
		catch (ClassNotFoundException cnf) 
		{
			cnf.printStackTrace();
			return false;
		}
		return false;
	}
}
