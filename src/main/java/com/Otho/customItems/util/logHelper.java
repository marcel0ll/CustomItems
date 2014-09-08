package com.Otho.customItems.util;

public class logHelper {
	
	public static int permission = 0;
	
	public static String info = "INFO";
	public static String error = "ERROR";
	public static String alert = "ALERT";
	public static String debug = "DEBUG";
	
	public static void log(String id, String level, String text)
	{		
		System.out.println("("+level+") "+ id + ": " + text);
	}
}
