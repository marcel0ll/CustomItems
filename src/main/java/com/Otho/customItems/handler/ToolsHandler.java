package com.Otho.customItems.handler;

import net.minecraft.item.Item;
import net.minecraftforge.common.util.EnumHelper;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.Otho.customItems.lib.constants;
import com.Otho.customItems.mod.items.tools.CustomAxe;
import com.Otho.customItems.mod.items.tools.CustomHoe;
import com.Otho.customItems.mod.items.tools.CustomPickaxe;
import com.Otho.customItems.mod.items.tools.CustomShovel;
import com.Otho.customItems.mod.items.tools.CustomSword;
import com.Otho.customItems.util.logHelper;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

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
        	
        	GameRegistry.registerItem(tool, name);
            tool.setUnlocalizedName(constants.MOD_ID.toLowerCase()+":"+name);
            LanguageRegistry.instance().addStringLocalization(tool.getUnlocalizedName()+".name","en_US",name.substring(0, 1).toUpperCase()+name.substring(1));
            
		}
	}
}
