package com.thedreamsanctuary.dreamtools.Executors;

import java.util.ArrayList;
import java.util.Arrays;

import com.thedreamsanctuary.dreamtools.data.Info;

public class CustomMessage implements Executor
{

	public String Name() {
		// TODO Auto-generated method stub
		return null;
	}

	public void executor(Info i, String[] args) 
	{
		String msg = " ";
		ArrayList<String> arg = new ArrayList<String>(Arrays.asList(args));
		arg.remove(0);
		try
		{
			if (i.getPlayer().hasPermission(permNode()))
			{
				if (arg.size() == 1)
				{
					if (!i.getMessage().isEmpty())
						i.getPlayer().sendMessage(i.getMessage());
					else
						i.getPlayer().sendMessage("This user is currently set to private and cannot be whispered.");
						
				}
				if (args.length >= 2)
				{
					for (String s : arg)
						 msg += s;
					
					i.setMessage(msg);
				}
			}
		} catch (Exception e)
		{
			
		}
		
	}

	public String permNode() {
		// TODO Auto-generated method stub
		return null;
	}

}
