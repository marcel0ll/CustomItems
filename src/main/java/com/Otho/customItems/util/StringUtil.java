package com.Otho.customItems.util;

public class StringUtil {
	
	public static String parseTextureName(String textureName)
	{
		textureName = textureName.replaceAll("\\s+","_");
		textureName = textureName.toLowerCase();
		
		return textureName;
	}
}
