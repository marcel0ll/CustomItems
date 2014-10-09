package com.Otho.customItems.configuration;

import java.io.File;

import com.Otho.customItems.lib.ModReference;

import net.minecraftforge.common.config.Configuration;

public class forgeCustomConfigHandler 
{
	public static Configuration config;
	
	public static boolean debug;
	public static boolean makeRP;
	
	public static void init(File configFile)
	{
		if(config == null) {
            config = new Configuration(configFile);
        }
        loadConfiguration();
	}
	
	private static void loadConfiguration()
	{
		debug = config.getBoolean("debug", "DEBUG", false, "Set to true if you wish to output debug info");
		makeRP = config.getBoolean("makeCustomItemsResourcePack", "OPTIONS", false, "Set to false if you dont wish a CI ResourcePack");
		
		ModReference.debug = debug;
		ModReference.makeRP = makeRP;
		
		if(config.hasChanged()) {
            config.save();
        }
	}
}
