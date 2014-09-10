package com.Otho.customItems.handler;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.Otho.customItems.lib.constants;
import com.Otho.customItems.mod.items.disks.CustomDisk;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class DisksHandler {

	public static void init()
	{
		JSONArray blocksData = ConfigurationHandler.musicDisks;
		
		int i;
		
		if(blocksData != null)
		{
			for(i=0;i<blocksData.size();i++)
			{
				JSONObject data = (JSONObject) blocksData.get(i);
				
				String name = (String) data.get("name");
				String textureName = (String) data.get("textureName");
				String music = (String) data.get("music");
				
				CustomDisk disk = new CustomDisk(music);
				
				 GameRegistry.registerItem(disk, textureName);
				 disk.setUnlocalizedName(constants.MOD_ID.toLowerCase()+":"+name);
				 LanguageRegistry.instance().addStringLocalization(disk.getUnlocalizedName()+".name","en_US","Music Disc");				
			}
		}
	}
}
