package com.Otho.customItems.handler;

import net.minecraft.item.Item;
import net.minecraftforge.common.util.EnumHelper;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonNull;
import com.Otho.customItems.lib.constants;
import com.Otho.customItems.mod.items.tools.CustomAxe;
import com.Otho.customItems.mod.items.tools.CustomHoe;
import com.Otho.customItems.mod.items.tools.CustomPickaxe;
import com.Otho.customItems.mod.items.tools.CustomShovel;
import com.Otho.customItems.mod.items.tools.CustomSword;
import com.Otho.customItems.util.StringUtil;
import com.Otho.customItems.util.logHelper;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class ToolsHandler {
	
	public static void init()
	{
		JsonObject tools = ConfigurationHandler.tools;
		
		if(tools != null)
		{
			JsonArray shovels = (JsonArray) tools.get("shovels");
			JsonArray axes = (JsonArray) tools.get("axes");
			JsonArray pickaxes = (JsonArray) tools.get("pickaxes");
			JsonArray swords = (JsonArray) tools.get("swords");
			JsonArray hoes = (JsonArray) tools.get("hoes");
		
		
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
	}
	
	private static void NewTools(JsonArray tools, String type)
	{
		int i;
		
		for(i=0;i<tools.size();i++)
		{
			//Get tool Json
			JsonObject data = (JsonObject) tools.get(i);
			logHelper.log(constants.MOD_ID, logHelper.debug, data.toString());
			
			//Parse tool attributes			
			String name = data.get("name").getAsString();
        	String textureName = data.get("textureName").getAsString();
        	textureName = StringUtil.parseTextureName(textureName);
        	
        	int harvestLevel = data.get("harvestLevel").getAsInt();
        	int maxUses = data.get("maxUses").getAsInt();
        	float efficiencyOnProperMaterial = data.get("efficiencyOnProperMaterial").getAsFloat();
        	float damageVsEntity = data.get("damageVsEntity").getAsFloat();
        	int enchantability = data.get("enchantability").getAsInt();
			
			//Make Custom Tool
        	Item.ToolMaterial material = EnumHelper.addToolMaterial(textureName, harvestLevel, maxUses, efficiencyOnProperMaterial, damageVsEntity, enchantability);
        	Item tool;
        	
        	
        	if(type.equals("axe"))
        	{
        		tool = new CustomAxe(material);        
        	}else if(type.equals("shovel"))
        	{
        		tool = new CustomShovel(material);        
        	}else if(type.equals("pickaxe"))
        	{
        		tool = new CustomPickaxe(material);        
        	}else if(type.equals("hoe"))
        	{
        		tool = new CustomHoe(material);        
        	}else if(type.equals("sword"))
        	{
        		tool = new CustomSword(material);        
        	}else 
        	{	
        		tool = new CustomAxe(material);
        	}
        	//Register Tool
        	
        	GameRegistry.registerItem(tool, textureName);
            tool.setUnlocalizedName(constants.MOD_ID.toLowerCase()+":"+textureName);
            LanguageRegistry.instance().addStringLocalization(tool.getUnlocalizedName()+".name","en_US",name.substring(0, 1).toUpperCase()+name.substring(1));
            
		}
	}
}
