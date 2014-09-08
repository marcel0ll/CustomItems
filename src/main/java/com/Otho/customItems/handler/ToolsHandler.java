package com.Otho.customItems.handler;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.Otho.customItems.lib.constants;
import com.Otho.customItems.util.logHelper;
import com.Otho.customItems.mod.items.tools.*;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.item.*;
import net.minecraftforge.common.util.EnumHelper;

public class ToolsHandler {
	
	public static void init()
	{
		JSONObject tools = ConfigurationHandler.tools;
		
		JSONArray shovels = (JSONArray) tools.get("shovels");
		JSONArray axes = (JSONArray) tools.get("axes");
		JSONArray pickaxes = (JSONArray) tools.get("pickaxes");
		JSONArray swords = (JSONArray) tools.get("swords");
		JSONArray hoes = (JSONArray) tools.get("hoes");
		
		logHelper.log(constants.MOD_ID, logHelper.debug, "Registering custom Tools");
		
		if(shovels != null)
			NewTools (shovels, "shovel");
		if(axes != null)
			NewTools (axes, "axe");
		if(pickaxes != null)
			NewTools (pickaxes, "pickaxe");
		if(swords != null)
			NewTools (swords, "sword");
		if(hoes != null)
			NewTools (hoes, "hoe");
		
		
	}
	
	private static void NewTools(JSONArray tools, String type)
	{
		int i;
		
		for(i=0;i<tools.size();i++)
		{
			//Get tool Json
			JSONObject data = (JSONObject) tools.get(i);
			logHelper.log(constants.MOD_ID, logHelper.debug, data.toJSONString());
			
			//Parse tool attributes			
			String name = (String) data.get("name");
        	String textureName = (String) data.get("textureName");
        	
        	int harvestLevel = ((Number) data.get("harvestLevel")).intValue();
        	int maxUses = ((Number) data.get("maxUses")).intValue();
        	float efficiencyOnProperMaterial = ((Number) data.get("efficiencyOnProperMaterial")).floatValue();
        	float damageVsEntity = ((Number) data.get("damageVsEntity")).floatValue();
        	int enchantability = ((Number) data.get("enchantability")).intValue();
			
			//Make Custom Tool
        	Item.ToolMaterial material = EnumHelper.addToolMaterial(textureName, harvestLevel, maxUses, efficiencyOnProperMaterial, damageVsEntity, enchantability);
        	Item tool;
        	
        	switch(type)
        	{
        	case "axe":
        		tool = new CustomAxe(material);
        		break;
        	case "shovel":
        		tool = new CustomShovel(material);
        		break;
        	case "pickaxe":
        		tool = new CustomPickaxe(material);
        		break;
        	case "hoe":
        		tool = new CustomHoe(material);
        		break;
        	case "sword":
        		tool = new CustomSword(material);
        		break;
			default: 
				tool = new CustomAxe(material);
        		break;
        	}
        	//Register Tool
        	
        	GameRegistry.registerItem(tool, name);
            tool.setUnlocalizedName(constants.MOD_ID.toLowerCase()+":"+name);
            LanguageRegistry.instance().addStringLocalization(tool.getUnlocalizedName()+".name","en_US",name.substring(0, 1).toUpperCase()+name.substring(1));
            
		}
	}
}
