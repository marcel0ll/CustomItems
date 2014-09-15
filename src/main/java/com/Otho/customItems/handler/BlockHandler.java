package com.Otho.customItems.handler;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.Otho.customItems.lib.constants;
import com.Otho.customItems.mod.blocks.CustomBlock;
import com.Otho.customItems.mod.materials.CI_Material;
import com.Otho.customItems.util.StringUtil;
import com.Otho.customItems.util.logHelper;



import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;


public class BlockHandler {	
	
	public static void init() {
		JsonArray blocksData = ConfigurationHandler.blocks; 
		
		int i;
		
		if(blocksData != null)
		{		
			logHelper.log(constants.MOD_ID, logHelper.debug, "Registering custom Blocks");
	        
	        for(i=0;i<blocksData.size();i++) {            
	        	
	        	//Get Block Json
	        	JsonObject blockData = (JsonObject) blocksData.get(i);
	        	logHelper.log(constants.MOD_ID, logHelper.info, blockData.toString());
	        	
	        	//Parse block attributes
	        	String name = blockData.get("name").getAsString();
	        	String textureName = blockData.get("textureName").getAsString();
	        	textureName = StringUtil.parseTextureName(textureName);
	        	
	        	String material = blockData.get("material").getAsString();
	        	String toolClass = blockData.get("toolClass").getAsString();
	        	String TC = validateToolClass(toolClass);
	        	
	        	float hardness = blockData.get("hardness").getAsFloat();
	        	float resistance = blockData.get("resistance").getAsFloat();
	        	float lightLevel = blockData.get("lightLevel").getAsFloat();
	        	int harvestLevel;
	        	Object HL = blockData.get("harvestLevel");
	        	if(HL == null || !TC.equals("pickaxe"))
	        	{
	        		harvestLevel = 0;
	        	}else
	        	{
	        		harvestLevel = blockData.get("harvestLevel").getAsInt();
	        	}	        	
	        
	        	//Make Custom Block
	        	CustomBlock block = new CustomBlock(CI_Material.getMaterial(material));
	        	
	        	block.setHardness(hardness);
	        	block.setResistance(resistance);
	        	block.setLightLevel(lightLevel);	        	
	        	block.setHarvestLevel(TC, harvestLevel);
	        	
	        	
	        	
	        	
	        	//Register Block
	        	GameRegistry.registerBlock(block, textureName);
	        	block.setBlockName(constants.MOD_ID.toLowerCase()+":"+textureName); 
	        	LanguageRegistry.instance().addStringLocalization(block.getUnlocalizedName()+".name","en_US", name);
	        }
		}
    }
	
	private static String validateToolClass(String toolClass){		
		if(toolClass.equals("pickaxe"))
		{
			return toolClass;
		}else if(toolClass.equals("axe"))
		{
			return toolClass;
		}else if(toolClass.equals("shovel"))
		{
			return toolClass;
		}else
		{
			return "pickaxe";
		}
	}
	
}

