package me.otho.customItems.configuration;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import me.otho.customItems.registry.Registry;
import me.otho.customItems.util.LogHelper;

import org.apache.commons.lang3.ArrayUtils;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;


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
					Registry.register(allData);
			}
		}else
		{
			folder.mkdir();
		}
	}
	
	public static void post_init() {
		Registry.change(allData);
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
		
		mergeTo.oreGen = ArrayUtils.addAll(data.oreGen, mergeTo.oreGen);
	}

	public static boolean unpackConfigFile(Class obj, String path, String destinationPath) throws IOException, URISyntaxException
    {
		String[] resources = getResourceListing(obj, path);
		LogHelper.info(Arrays.deepToString(resources));
		int i;
		if(resources != null){
			for(i=0; i< resources.length; i++){			
				String resourceName = path + "/" + resources[i];
				
				if(resourceName.endsWith(".json")){
					File destination = new File(destinationPath +File.separator + resources[i]);
					
			    	Enumeration<URL> a = obj.getClassLoader().getResources(path);
			    	String b = a.nextElement().getPath();
			    	String c = b;
			        try
			            {
			        	    InputStream ex = obj.getClassLoader().getResourceAsStream(resourceName);
			                BufferedOutputStream streamOut = new BufferedOutputStream(new FileOutputStream(destination));
			                byte[] buffer = new byte[1024];
			                boolean len = false;
			                int len1;
		
			                while ((len1 = ex.read(buffer)) >= 0)
			                {
			                    streamOut.write(buffer, 0, len1);
			                }
		
			                ex.close();
			                streamOut.close();	                
			            }
			            catch (Exception var6)
			            {
			                throw new RuntimeException("Failed to unpack resource \'" + resourceName + "\'", var6);
			            }
				}
			}
		}
		
		LogHelper.info("Failed to load default config files - 2");
		return false;    	
    }
	
	public static String[] getResourceListing(Class clazz, String path) throws URISyntaxException, IOException {
	      URL dirURL = clazz.getClassLoader().getResource(path);
	      
	      if (dirURL != null && dirURL.getProtocol().equals("file")) {
	    	String[] list = new File(dirURL.toURI()).list();
	        return list;
	      }	
	      
	      if (dirURL == null) {
	          /* 
	           * In case of a jar file, we can't actually find a directory.
	           * Have to assume the same jar as clazz.
	           */
	          String me = clazz.getName().replace(".", "/")+".class";
	          dirURL = clazz.getClassLoader().getResource(me);
	        }
	        
	        if (dirURL.getProtocol().equals("jar")) {
	          /* A JAR path */
	          String jarPath = dirURL.getPath().substring(5, dirURL.getPath().indexOf("!")); //strip out only the JAR file
	          JarFile jar = new JarFile(URLDecoder.decode(jarPath, "UTF-8"));
	          Enumeration<JarEntry> entries = jar.entries(); //gives ALL entries in jar
	          Set<String> result = new HashSet<String>(); //avoid duplicates in case it is a subdirectory
	          while(entries.hasMoreElements()) {
	            String name = entries.nextElement().getName();
	            if (name.startsWith(path)) { //filter according to the path
	              String entry = name.substring(path.length());
	              int checkSubdir = entry.indexOf("/");
	              if (checkSubdir >= 0) {
	                // if it is a subdirectory, we just return the directory name
	                entry = entry.substring(0, checkSubdir);
	              }
	              result.add(entry);
	            }
	          }
	          jar.close();
	          String[] ret = result.toArray(new String[result.size()]);
	          LogHelper.info("Return: " + ret);
	          return ret;
	        } 
	      
	      LogHelper.info("Failed to load default config files");
	      throw new UnsupportedOperationException("Cannot list files for URL "+dirURL);
	  }
	
}
