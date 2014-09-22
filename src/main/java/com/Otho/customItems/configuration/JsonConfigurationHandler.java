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

import com.google.gson.*;
import com.google.gson.stream.JsonReader;
import com.Otho.customItems.lib.constants;
import com.Otho.customItems.util.LogHelper;


public class JsonConfigurationHandler 
{
	public static JsonSchema data;
	
	public static void init (String filePath, String folderPath)
	{	
	
		File folder = new File(folderPath);
		
		
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
							Register.register(data, file.getName());
						}catch(FileNotFoundException e)
						{
							
						}
					}
				}				
			}
		}else
		{
			folder.mkdir();
		}
		
		
		
		
//		try 
//		{			
//			InputStream is = new FileInputStream(filePath);
//	        InputStreamReader isr = new InputStreamReader(is);
//			 
//	        Gson gson = new Gson();
//	        
//	        JsonReader reader = new JsonReader(isr);
//	        
//	        data = gson.fromJson(reader, JsonSchema.class);    
//		}catch (FileNotFoundException e) 
//		{
//			try 
//			{
//				File config = new File(filePath);
//				// create a new writer
//				PrintWriter pw = new PrintWriter(config);
//
//				// print object
//				pw.println("{}");
//				
//				pw.flush();
//				pw.close();
//
//			} catch (Exception ex) 
//			{
//				ex.printStackTrace();
//			}
//			 
//		}
	}
}
