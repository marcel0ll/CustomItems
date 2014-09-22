package com.Otho.customItems.util;

import com.Otho.customItems.lib.constants;

import cpw.mods.fml.common.FMLLog;
import org.apache.logging.log4j.Level;

public class LogHelper {
    public static void log(Level logLevel, Object object) {
    	if(constants.debug)
		{
    		FMLLog.log(constants.MOD_NAME, logLevel, String.valueOf(object));
		}
    }
    public static void log(Level logLevel, Object object, int tab)
    {
    	String spaces = "";
    	int i;
    	for(i=0; i<tab; i++)
    		spaces = spaces.concat("  ");
    	
    	log(logLevel, spaces.concat(object.toString()));
    }
    public static void all(Object object) {
        log(Level.ALL, object);
    }
    public static void debug(Object object) {
        log(Level.DEBUG, object);
    }
    public static void error(Object object) {
        log(Level.ERROR, object);
    }
    public static void fatal(Object object) {
        log(Level.FATAL, object);
    }
    public static void info(Object object) {
        log(Level.INFO, object);
    }
    public static void off(Object object) {
        log(Level.OFF, object);
    }
    public static void trace(Object object) {
        log(Level.TRACE, object);
    }
    public static void warn(Object object) {
        log(Level.WARN, object);
    }
}