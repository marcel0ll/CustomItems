package me.otho.customItems.compability;

import cpw.mods.fml.common.Loader;

public class Integration {

	private static boolean NEI;
	
	public static void init(){
		NEI = Loader.isModLoaded("NotEnoughItems");
	}
	
	public static boolean isNEI(){
		return NEI;
	}
}
