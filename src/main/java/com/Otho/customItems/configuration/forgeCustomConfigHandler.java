package com.Otho.customItems.configuration;

import java.io.File;

import com.Otho.customItems.lib.constants;

import net.minecraftforge.common.config.Configuration;

public class forgeCustomConfigHandler {
	public static Configuration config;
	
	public static boolean debug;
	
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
		
		constants.debug = debug;
		
		if(config.hasChanged()) {
            config.save();
        }
	}
}
