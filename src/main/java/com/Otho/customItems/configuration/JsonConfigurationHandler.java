package com.Otho.customItems.configuration;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.file.Files;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.logging.log4j.Level;

import com.google.gson.*;
import com.google.gson.stream.JsonReader;
import com.Otho.customItems.lib.ModReference;
import com.Otho.customItems.util.LogHelper;


public class JsonConfigurationHandler 
{
	public static JsonSchema data;
	public static JsonSchema allData;
	
	public static void init (String folderPath)
	{	
	
		File folder = new File(folderPath);
		allData = new JsonSchema();
		
		if(folder.exists())
		{
			File[] listOfFiles = folder.listFiles();
			
			if(listOfFiles.length > 0)
			{
				Gson gson = new Gson();
				JsonReader reader;
				
				int i;
				
				for(i=0;i<listOfFiles.length;i++)
				{
					File file = listOfFiles[i];
					
					if(file.isFile() && file.getName().endsWith(".json"))
					{					
						try{
							reader = new JsonReader(new FileReader(file));
							
							JsonSchema data = gson.fromJson(reader, JsonSchema.class);
							mergeGson(data, allData);
							
						}catch(FileNotFoundException e)
						{
							
						}
					}
				}
				if(listOfFiles.length > 0)
					RegisterCustomItems.register(allData);
			}
		}else
		{
			folder.mkdir();
		}
	}
	
	public static void post_init() {
		Changer.change(allData);
	}
	
	private static void mergeGson(JsonSchema data, JsonSchema mergeTo)
	{
		mergeTo.blocks = ArrayUtils.addAll(data.blocks, mergeTo.blocks);
		mergeTo.chests = ArrayUtils.addAll(data.chests, mergeTo.chests);
		mergeTo.items = ArrayUtils.addAll(data.items, mergeTo.items);	
		mergeTo.foods = ArrayUtils.addAll(data.foods, mergeTo.foods);
		mergeTo.pickaxes = ArrayUtils.addAll(data.pickaxes, mergeTo.pickaxes);
		mergeTo.axes = ArrayUtils.addAll(data.axes, mergeTo.axes);
		mergeTo.shovels = ArrayUtils.addAll(data.shovels, mergeTo.shovels);
		mergeTo.hoes = ArrayUtils.addAll(data.hoes, mergeTo.hoes);
		mergeTo.swords = ArrayUtils.addAll(data.swords, mergeTo.swords);
		mergeTo.helmets = ArrayUtils.addAll(data.helmets, mergeTo.helmets);
		mergeTo.chestplates = ArrayUtils.addAll(data.chestplates, mergeTo.chestplates);
		mergeTo.leggings = ArrayUtils.addAll(data.leggings, mergeTo.leggings);
		mergeTo.boots = ArrayUtils.addAll(data.boots, mergeTo.boots);
		mergeTo.fluids = ArrayUtils.addAll(data.fluids, mergeTo.fluids);
		mergeTo.creativeTabs = ArrayUtils.addAll(data.creativeTabs, mergeTo.creativeTabs);
		mergeTo.crops = ArrayUtils.addAll(data.crops, mergeTo.crops);
		
		mergeTo.changeBlocks = ArrayUtils.addAll(data.changeBlocks, mergeTo.changeBlocks);
		mergeTo.changeItems = ArrayUtils.addAll(data.changeItems, mergeTo.changeItems);
	}

	
}
