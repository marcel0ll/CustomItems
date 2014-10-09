package com.Otho.customItems.lib;

public class ModReference {
	public static final String MOD_ID = "customitems";
	public static final String MOD_NAME = "Custom Items";
	public static final String DEPENDENCIES = "after:all"; 
	public static final String VERSION = "1.0";
	public static boolean debug = true;
	public static boolean makeRP = true;	
	
	public static final String CLIENT_PROXY_CLASS = "com.Otho.customItems.proxy.ClientProxy";
	public static final String SERVER_PROXY_CLASS = "com.Otho.customItems.proxy.ServerProxy";
}
