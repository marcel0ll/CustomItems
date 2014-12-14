package com.Otho.customItems.registry;

import net.minecraft.block.Block;
import net.minecraft.item.Item;

import com.Otho.customItems.configuration.JsonSchema;
import com.Otho.customItems.configuration.jsonReaders.tweakers.Cfg_change_block;
import com.Otho.customItems.configuration.jsonReaders.tweakers.Cfg_change_item;
import com.Otho.customItems.mod.blocks.CustomBlock;
import com.Otho.customItems.mod.materials.CI_Material;
import com.Otho.customItems.util.LogHelper;
import com.Otho.customItems.util.Util;

import cpw.mods.fml.common.registry.GameRegistry;

public class Changer {
	
	public static void change(JsonSchema data)
	{
		int i;
		LogHelper.info("Starting to change:");
		if(data.changeBlocks != null)
		{
			for(i=0; i<data.changeBlocks.length; i++)
			{
				LogHelper.info("Changing: " +data.changeBlocks[i].name);
				changeSingleBlock(data.changeBlocks[i]);
			}
		}
		
		if(data.changeItems != null)
		{
			for(i=0; i<data.changeItems.length; i++)
			{
				LogHelper.info("Changing: " +data.changeItems[i].name);
				changeSingleItem(data.changeItems[i]);
			}
		}
	}
	
	public static void changeSingleBlock(Cfg_change_block blockData)
	{
		String[] parsing = blockData.name.split(":");
		
		if(blockData.toolClass != null)
		{
			blockData.toolClass = Util.validateToolClass(blockData.toolClass);
			if(!blockData.toolClass.equals("pickaxe"))
			{
				blockData.harvestLevel = 0;
			}       
		}
		
		if(parsing[0] != null && parsing[1] != null)
		{
			Block block = GameRegistry.findBlock(parsing[0], parsing[1]);
			
			if(blockData.isOpaque != null)
				if(blockData.isOpaque)
					block.setLightOpacity(255);
				else
					block.setLightOpacity(0);
			
			if(blockData.hardness != null)
				block.setHardness(blockData.hardness);
			if(blockData.resistance != null)
			block.setResistance(blockData.resistance);
			if(blockData.lightLevel != null)
			block.setLightLevel(blockData.lightLevel);	
			if(blockData.harvestLevel != null)
			block.setHarvestLevel(blockData.toolClass, blockData.harvestLevel);
			if(blockData.slipperiness != null)
			block.slipperiness = blockData.slipperiness;
			if(blockData.stepSound != null)
			block.setStepSound(Util.parseSoundType(blockData.stepSound));
			
			if(blockData.maxStackSize != null)
			{
				Item itemBlock = Item.getItemFromBlock(block);
				
				blockData.maxStackSize = Math.max(blockData.maxStackSize, 0);
				blockData.maxStackSize = Math.min(blockData.maxStackSize, 64);
				
				
		        itemBlock.setMaxStackSize(blockData.maxStackSize);
			}
		}
	}
	
	public static void changeSingleItem(Cfg_change_item itemData)
	{
		String[] parsing = itemData.name.split(":");
		if(parsing[0] != null && parsing[1] != null)
		{
			Item item = GameRegistry.findItem(parsing[0], parsing[1]);
			
			if(itemData.maxStackSize != null)
			{
				itemData.maxStackSize = Math.max(itemData.maxStackSize, 1);
				itemData.maxStackSize = Math.min(itemData.maxStackSize, 64);
				
				
				item.setMaxStackSize(itemData.maxStackSize);
			}
		}
	}
}
