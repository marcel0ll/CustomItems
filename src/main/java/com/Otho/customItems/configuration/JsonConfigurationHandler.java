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
import com.Otho.customItems.util.logHelper;


public class JsonConfigurationHandler 
{
	public static JsonSchema data;
	
	public static void init (String filePath)
	{	
		try 
		{			
			InputStream is = new FileInputStream(filePath);
	        InputStreamReader isr = new InputStreamReader(is);
			 
	        Gson gson = new Gson();
	        
	        JsonReader reader = new JsonReader(isr);
	        
	        data = gson.fromJson(reader, JsonSchema.class);    
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
