package com.Otho.customItems.handler;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;




import org.json.simple.*;
import org.json.simple.parser.*;

import com.Otho.customItems.lib.constants;
import com.Otho.customItems.util.logHelper;


public class ConfigurationHandler {
	
	public static JSONArray blocks;
	public static JSONObject items;
	public static JSONObject liquids;
	public static JSONObject tools;
	public static JSONObject armor;
	public static JSONObject musicDisks;
	
	
	public static void init (String filePath)
	{
		JSONParser parser = new JSONParser();
		
		try {
			 
			Object fileLoader = parser.parse(new FileReader(filePath));
			 
			JSONObject config = (JSONObject) fileLoader;
			
			logHelper.log(constants.MOD_ID, logHelper.debug, config.toJSONString());
			
			blocks = (JSONArray) config.get("blocks");
			items = (JSONObject) config.get("items");
			liquids = (JSONObject) config.get("liquids");
			tools = (JSONObject) config.get("tools");
			armor = (JSONObject) config.get("armor");
			musicDisks = (JSONObject) config.get("music_disks");
			 
		}catch (FileNotFoundException e) 
		{
			 e.printStackTrace();
		}catch (IOException e) 
		{
			 e.printStackTrace();
		} catch (ParseException e) 
		{
			 e.printStackTrace();
		}
	}
}
