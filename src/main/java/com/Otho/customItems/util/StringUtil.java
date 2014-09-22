package com.Otho.customItems.util;

public class StringUtil {
	
	public static String parseRegisterName(String name)
	{
		name = name.replaceAll("\\s+","_");
		name = name.toLowerCase();
		
		return name;
	}
}
