package com.thedreamsanctuary.dreamtools.configuration;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;


import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.Yaml;


import com.thedreamsanctuary.dreamtools.data.Data;

public class Config 
{	
	//Defaulted only change when modified
	private static final String serializeVer = "1.10";
	
	public static String getSerializeVer()
	{
		return serializeVer;
	}
	@SuppressWarnings("unchecked")
	public boolean createDefaults()
	{
		try 
		{
			File loc = new File(Data.getDataLoc());
			File f = new File(Data.getDataLoc() + "/config.yml");

			if (!loc.isDirectory())
				loc.mkdirs();
			
			if (!f.exists())
			{	
				FileWriter writer = new FileWriter(Data.getDataLoc() + "/config.yml");
				Map<String, Object> data = new HashMap<String, Object>();
				data.put("SerializeVer", serializeVer);
				data.put("wlLimits", 50);
				data.put("gListLimit", 50); 
				data.put("Max msg limit", 50);
				
				DumperOptions options = new DumperOptions();
				options.setDefaultFlowStyle(DumperOptions.FlowStyle.BLOCK);
			
				Yaml yaml = new Yaml(options);
				yaml.dump(data, writer);
				writer.close();
				
				
			}
			else
			{
				Yaml yaml = new Yaml();
				InputStream input = new FileInputStream(new File(Data.getDataLoc() + "/config.yml"));
				
				Map<String, Object> imConfig = (Map<String, Object>) yaml.load(input);
				Object[] arr = imConfig.values().toArray();
				Data.setGroupLimit((Integer) arr[0]);
				Data.setCustomError((Integer) arr[1]);
				Data.setWhisperLimit((Integer) arr[2]);
				Data.setConfigVer((String) arr[3]);
				
				System.out.println(Data.getGroupLimit() + " " + Data.getCustomError() + " " + Data.getWhisperLimit() + " " + Data.getConfigVer());
				input.close();
			}
				//yaml.dump(c);
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return false;
	
	}
	public boolean writeToConfig(String state, String input) throws IOException
	{
		FileWriter writer = new FileWriter(Data.getDataLoc() + "/config.yml");
		Map<String, Object> data = new HashMap<String, Object>();
		data.put(state, input);
		
		DumperOptions options = new DumperOptions();
		options.setDefaultFlowStyle(DumperOptions.FlowStyle.BLOCK);
		
		writer.close();
		return false;
	}
}
