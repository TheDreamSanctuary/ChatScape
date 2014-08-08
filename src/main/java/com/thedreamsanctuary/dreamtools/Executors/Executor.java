package com.thedreamsanctuary.dreamtools.Executors;

import com.thedreamsanctuary.dreamtools.data.Info;

public abstract interface Executor 
{
	public String Name();
	public void executor(Info i, String[] args);
	public String permNode();
	
}
