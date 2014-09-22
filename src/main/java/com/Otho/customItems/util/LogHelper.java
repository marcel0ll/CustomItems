package com.Otho.customItems.util;

import com.Otho.customItems.lib.constants;

public class LogHelper {	
	public static int permission = 0;	
	public static String info = "INFO";
	public static String error = "ERROR";
	public static String alert = "ALERT";
	public static String debug = "DEBUG";
	
	public static void log(String id, String level, String text)
	{		
		if(constants.debug)
		{
			System.out.println("("+level+") "+ id + ": " + text);
		}
	}
}
