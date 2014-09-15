package com.Otho.customItems.handler;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.Otho.customItems.lib.constants;
import com.Otho.customItems.mod.items.CustomItem;
import com.Otho.customItems.util.StringUtil;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;



public class ItemsHandler {
	
	public static void init()
	{
		JsonArray items = ConfigurationHandler.items;
		
		int i;
		
	
		if(items != null)
		{
			for(i=0;i<items.size();i++)
			{
				JsonObject data = (JsonObject) items.get(i);
				
				String name = data.get("name").getAsString();
				String textureName = data.get("textureName").getAsString();
				textureName = StringUtil.parseTextureName(textureName);
				
				int maxstackSize = data.get("maxstackSize").getAsInt();
				
				
				
				CustomItem item = new CustomItem(maxstackSize);
	           
	            GameRegistry.registerItem(item, textureName);
	            item.setUnlocalizedName(constants.MOD_ID.toLowerCase() + ":"+textureName);
	            LanguageRegistry.instance().addStringLocalization(item.getUnlocalizedName()+".name","en_US", name);
			}
		}
	}

}
