package com.thedreamsanctuary.chatscape.executors;

import com.thedreamsanctuary.chatscape.data.Info;



public interface Executor 
{
	public String Name();
	public void executor(Info i, String[] args);
	public String permNode();
	
}
