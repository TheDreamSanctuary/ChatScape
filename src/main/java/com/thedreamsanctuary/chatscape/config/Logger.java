package com.thedreamsanctuary.chatscape.config;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import com.thedreamsanctuary.chatscape.data.Data;


public class Logger 
{
	private static String logLoc = Data.getDataLoc();
	
	public static void logIt(String error, String... fileName)
	{
		File saveDirPath;
		if(fileName.length < 2) 
		{
			saveDirPath = new File(logLoc);
		} 
		else
			saveDirPath = new File(logLoc + fileName[1]);
		
		if (!saveDirPath.exists())
			saveDirPath.mkdirs();
		try 
		{
			String time = String.format("[%1$TD | %1$TT] -", new Timestamp(new Date().getTime()));
			saveDirPath = new File(saveDirPath.getAbsolutePath() + "/" + fileName[0] +".log");
			FileWriter fw = new FileWriter(saveDirPath.getAbsoluteFile(),true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.append(time + " " + error +"\n");
			bw.close();
		} 
		catch (IOException ioe) 
		{
		}
	}
	public static String error()
	{
		return "RunLog";
	}
	public  static String playerInfo()
	{
		return "playerInfo";
	}
}
