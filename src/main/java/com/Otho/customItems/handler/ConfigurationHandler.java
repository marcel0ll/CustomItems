package com.Otho.customItems.handler;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.file.Files;

import com.google.gson.*;
import com.google.gson.stream.JsonReader;
import com.Otho.customItems.lib.constants;
import com.Otho.customItems.util.logHelper;


public class ConfigurationHandler {
	
	public static JsonArray blocks;
	public static JsonArray items;
	public static JsonArray fluids;
	public static JsonObject tools;
	public static JsonObject armor;
	public static JsonArray musicDisks;
	public static JsonArray foods;	
	
	
	public static void init (String filePath)
	{	
		try 
		{			
			InputStream is = new FileInputStream(filePath);
	        InputStreamReader isr = new InputStreamReader(is);
			 
			JsonParser parser = new JsonParser();			
			  //create JsonReader object
	        JsonReader reader = new JsonReader(isr);
	        JsonObject config = (JsonObject) parser.parse(reader);
			
			blocks = (JsonArray) config.get("blocks");
			items = (JsonArray) config.get("items");
			fluids = (JsonArray) config.get("fluids");
			tools = (JsonObject) config.get("tools");
			armor = (JsonObject) config.get("armor");
			musicDisks = (JsonArray) config.get("music_disks");
			foods = (JsonArray) config.get("foods");
			 
		}catch (FileNotFoundException e) 
		{
			try 
			{
				File config = new File(filePath);
				// create a new writer
				PrintWriter pw = new PrintWriter(config);

				// print object
				pw.println("{}");
				
				pw.flush();
				pw.close();

			} catch (Exception ex) 
			{
				ex.printStackTrace();
			}
			 
		}
	}
}
