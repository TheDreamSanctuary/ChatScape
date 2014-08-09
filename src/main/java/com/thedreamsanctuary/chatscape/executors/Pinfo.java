package com.thedreamsanctuary.chatscape.executors;

import com.thedreamsanctuary.chatscape.data.Info;
import com.thedreamsanctuary.chatscape.data.MessageWriter;

public class Pinfo implements Executor 
{
	public String Name()
	{
		// TODO Auto-generated method stub
		return null;
	}

	public void executor(Info i, String[] args) 
	{
		try
		{
			if (args.length == 1)
			{
				MessageWriter.modeStatus(i);
			}
		} catch (Exception e)
		{
			
		}	
	}
	public String permNode() 
	{
		// TODO Auto-generated method stub
		return "chatScape.pInfo";
	}

}
