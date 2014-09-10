package com.Otho.customItems.handler;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.Otho.customItems.lib.constants;
import com.Otho.customItems.mod.items.CustomItem;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;



public class ItemsHandler {
	
	public static void init()
	{
		int i;
		
		JSONArray items = ConfigurationHandler.items;
		
		if(items != null)
		{
			for(i=0;i<items.size();i++)
			{
				JSONObject data = (JSONObject) items.get(i);
				
				String name = (String) data.get("name");
				String textureName = (String) data.get("textureName");
				int maxstackSize = ((Number) data.get("maxstackSize")).intValue();
				
				
				
				CustomItem item = new CustomItem(maxstackSize);
	           
	            GameRegistry.registerItem(item, textureName);
	            item.setUnlocalizedName(constants.MOD_ID.toLowerCase() + ":"+textureName);
	            LanguageRegistry.instance().addStringLocalization(item.getUnlocalizedName()+".name","en_US", name);
			}
		}
	}

}
