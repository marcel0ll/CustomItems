package com.Otho.customItems.util;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class FileGenerator {	
	 public static void generateResourcePack (File myFile) throws IOException
	    {
	    	boolean makeRPFolder = false;
			boolean makeCIFolder = false;		
			
			File configFolder = myFile.getParentFile();
			File mineFolder = configFolder.getParentFile();
			File RPFolder = new File(mineFolder.getPath()+ File.separator + "resourcepacks");
			
			File CIfolder = myFile;
			File meta;
			
			if(RPFolder.exists())
			{
				LogHelper.info("RPFolder already exist");
				CIfolder = new File(RPFolder.getPath()+ File.separator + "CustomItemsPack");
				if(!CIfolder.exists())
				{
					LogHelper.info("CIFolder does not exist");
					makeCIFolder = true;
				}else
				{
					LogHelper.info("CIFolder already exist");					
				}
			}else
			{
				LogHelper.info("RPFolder does not exist");
				makeRPFolder = true;
				makeCIFolder = true;
			}
			
			if(makeRPFolder)
			{
				RPFolder.mkdir();
			}
			
			if(makeCIFolder)
			{
				CIfolder.mkdir();
				meta = new File(CIfolder.getPath() + File.separator + "pack.mcmeta");
				
				meta.createNewFile();
				PrintWriter out = new PrintWriter(meta);
				out.println('{');
				out.println("\t"+'"'+"pack" +'"'+ ": {");
				out.println("\t\t"+'"'+"pack_format" +'"'+ ": 1,");
				out.println("\t\t"+'"'+"description" +'"'+ ": "+'"'+"Custom Items Pack"+'"');
				out.println("\t}");
				out.println("}");
				
				out.close();
				
				File assets = new File(CIfolder.getPath() + File.separator + "assets");
				assets.mkdir();
				File modId = new File(assets.getPath() + File.separator + "customitems");
				modId.mkdir();
				File textures = new File(modId.getPath() + File.separator + "textures");
				textures.mkdir();
				
				File blocks = new File(textures.getPath() + File.separator + "blocks");
				blocks.mkdir();
				File gui = new File(textures.getPath() + File.separator + "gui");
				gui.mkdir();
				File items = new File(textures.getPath() + File.separator + "items");
				items.mkdir();
				File models = new File(textures.getPath() + File.separator + "models");
				models.mkdir();
			}
	    }
	 public static void generateDefaultConfigFiles(File[] configs){
		 //TODO Generate default config files when called
	 }
}
