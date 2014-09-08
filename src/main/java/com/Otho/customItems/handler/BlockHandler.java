package com.Otho.customItems.handler;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.Otho.customItems.mod.blocks.CustomBlock;
import com.Otho.customItems.mod.materials.CI_Material;
import com.Otho.customItems.handler.ConfigurationHandler;
import com.Otho.customItems.lib.constants;
import com.Otho.customItems.util.logHelper;


import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.util.JsonBlendingMode;


public class BlockHandler {	
	
	public static void init() {
		JSONArray blocksData = ConfigurationHandler.blocks;    
		
		logHelper.log(constants.MOD_ID, logHelper.debug, "Registering custom Blocks");
        
        for(int i=0;i<blocksData.size();i++) {            
        	
        	//Get Block Json
        	JSONObject blockData = (JSONObject) blocksData.get(i);
        	logHelper.log(constants.MOD_ID, logHelper.info, blockData.toString());
        	
        	//Parse block attributes
        	String name = (String) blockData.get("name");
        	String textureName = (String) blockData.get("textureName");
        	String material = (String) blockData.get("material");
        	String hardness = (String) blockData.get("hardness");
        	String resistance = (String) blockData.get("resistance");
        	String lightLevel = (String) blockData.get("lightLevel");
        	String harvestLevel = (String) blockData.get("harvestLevel");
        	
        	//Make Custom Block
        	CustomBlock block = new CustomBlock(CI_Material.getMaterial(material));
        	
        	block.setHardness(Float.parseFloat((hardness)));
        	block.setResistance(Float.parseFloat((resistance)));
        	block.setLightLevel(Float.parseFloat((lightLevel)));
        	block.setHarvestLevel("pickaxe", (int) Float.parseFloat(harvestLevel));
        	
        	//Register Block
        	GameRegistry.registerBlock(block, name);
        	block.setBlockName(constants.MOD_ID.toLowerCase()+":"+textureName); 
        	LanguageRegistry.instance().addStringLocalization(block.getUnlocalizedName()+".name","en_US", name);
        }
    }
	
}

