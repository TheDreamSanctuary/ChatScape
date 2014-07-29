package com.thedreamsanctuary.dreamtools.Serialize;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Map;

import com.thedreamsanctuary.dreamtools.data.Data;
import com.thedreamsanctuary.dreamtools.data.Info;


public class Serialize extends Data 
{
	private static final long serialVersionUID = 1L;
	// Data d = new Data();

	private String pluginLoc;
	private String dataLoc;

	public void pluginData(String data) 
	{
		this.pluginLoc = data;
		this.dataLoc = data + "/" + "DreamTools.ser"; 
	}

	public void checkData() 
	{
		try 
		{
			File loc = new File(pluginLoc);
			File f = new File(dataLoc);

			if (!loc.isDirectory())
				loc.mkdirs();

			if (!f.exists())
				serializeList();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean serializeList() 
	{
		FileOutputStream outputStream;

		// if (!new File(pluginLoc + this.getName()).exists())

		try 
		{
			outputStream = new FileOutputStream(dataLoc);

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
			FileInputStream inputStream = new FileInputStream(dataLoc);
			ObjectInputStream in = new ObjectInputStream(inputStream);

			Data.setData((Map<String, Info>) in.readObject());

			if (Data.getData().isEmpty())
				System.out.println("~~~~~~~~~~~~Is empty #2");
			else
				System.out.println("~~~~~~~~~~~~Is full #2");

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
