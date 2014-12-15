package com.Otho.customItems.registry;

import net.minecraft.block.Block;
import net.minecraft.item.Item;

import com.Otho.customItems.configuration.jsonReaders.tweakers.Cfg_change_block;
import com.Otho.customItems.configuration.jsonReaders.tweakers.Cfg_change_item;
import com.Otho.customItems.util.LogHelper;
import com.Otho.customItems.util.Util;

import cpw.mods.fml.common.registry.GameRegistry;

public class TweakerRegistry {

	public static boolean changeBlock(Cfg_change_block data)
	{
		String[] nameParsing = data.name.split(":");
		String modId = nameParsing[0];
		String name = nameParsing[1];
		
		if(data.toolClass != null)
		{
			data.toolClass = Util.validateToolClass(data.toolClass);
			if(!data.toolClass.equals("pickaxe"))
			{
				data.harvestLevel = 0;
			}       
		}
		
		if(modId != null && name != null)
		{
			Block block = GameRegistry.findBlock(modId, name);
			
			if(data.isOpaque != null)
				if(data.isOpaque)
					block.setLightOpacity(255);
				else
					block.setLightOpacity(0);
			
			if(data.hardness != null)
				block.setHardness(data.hardness);
			if(data.resistance != null)
			block.setResistance(data.resistance);
			if(data.lightLevel != null)
			block.setLightLevel(data.lightLevel);	
			if(data.harvestLevel != null)
			block.setHarvestLevel(data.toolClass, data.harvestLevel);
			if(data.slipperiness != null)
			block.slipperiness = data.slipperiness;
			if(data.stepSound != null)
			block.setStepSound(Util.parseSoundType(data.stepSound));
			
			if(data.maxStackSize != null)
			{
				Item itemBlock = Item.getItemFromBlock(block);
				
				int size = Util.range(data.maxStackSize, 1, 64);
				
		        itemBlock.setMaxStackSize(size);
			}
		}
		
		return true;
	}
	
	public static boolean changeBlock(Cfg_change_block[] data){
		int i;
		
		for(i=0;i<data.length;i++){
			boolean tweaked = changeBlock(data[i]);

            if(!tweaked){
                LogHelper.error("Failed to tweak: Block " + i);
                return false;
            }
		}
		
		return true;
	}
	
	public static boolean changeItem(Cfg_change_item data)
	{
		String[] nameParsing = data.name.split(":");
		String modId = nameParsing[0];
		String name = nameParsing[1];
		
		if(modId != null && name != null)
		{
			Item item = GameRegistry.findItem(modId, name);
			
			if(data.maxStackSize != null)
			{
				int size = Util.range(data.maxStackSize, 1, 64);
				
				item.setMaxStackSize(size);
			}
		}
		
		return true;
	}

	public static boolean changeItem(Cfg_change_item[] data){		
		int i;
		
		for(i=0;i<data.length;i++){
			boolean tweaked = changeItem(data[i]);

            if(!tweaked){
                LogHelper.error("Failed to tweak: Item " + i);
                return false;
            }
		}
		
		return true;
	}
}
