package com.Otho.customItems.registry;

import org.apache.logging.log4j.Level;

import com.Otho.customItems.ModReference;
import com.Otho.customItems.configuration.jsonReaders.tileEntity.Cfg_chest;
import com.Otho.customItems.mod.blocks.CustomChest;
import com.Otho.customItems.mod.materials.CI_Material;
import com.Otho.customItems.util.LogHelper;
import com.Otho.customItems.util.Util;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class TileEntityRegistry {
	public static boolean registerChest(Cfg_chest data){
		LogHelper.log(Level.INFO, data.name, 1);
		
		String registerName = Util.parseRegisterName(data.name);
		
		if(data.toolClass != null)
		{
			data.toolClass = Util.validateToolClass(data.toolClass);
			if(!data.toolClass.equals("pickaxe"))
			{
				data.harvestLevel = 0;
			}
		}

		//Make Custom Block
		CustomChest block = new CustomChest(CI_Material.getMaterial(data.material), data.invWidth, data.invHeight, data.invName);
			
		block.setHardness(data.hardness);
		block.setResistance(data.resistance);
		block.setLightLevel(data.lightLevel);	        	
		block.setHarvestLevel(data.toolClass, data.harvestLevel);
		
		if(data.multipleTextures == null)
		{
			block.setBlockTextureName(data.textureName);
		}else
		{
			String[] textureNames = new String[6];
			textureNames[0] = data.multipleTextures.yneg;
			textureNames[1] = data.multipleTextures.ypos;
			textureNames[2] = data.multipleTextures.zneg;
			textureNames[3] = data.multipleTextures.zpos;
			textureNames[4] = data.multipleTextures.xneg;
			textureNames[5] = data.multipleTextures.xpos;
			block.registerBlockTextures(textureNames);
		}
		
		block.slipperiness = data.slipperiness;
		block.setOpaque(data.isOpaque);		
		block.setStepSound(Util.parseSoundType(data.stepSound));
		
		Registry.blocksList.add(block);
		Registry.blocksList.add(data.creativeTab);	        		
		
		//Chest Stuff		
		block.setHasOwner(data.hasOwner);
		if(data.slotMaxStackSize < 0)
			data.slotMaxStackSize = 0;
		if(data.slotMaxStackSize > 64)
			data.slotMaxStackSize = 64;
		block.setSlotMaxStackSize(data.slotMaxStackSize);
		
		Registry.blocksList.add(block);
		Registry.blocksList.add(data.creativeTab);	        		        	
		
		//Register Block
		GameRegistry.registerBlock(block, registerName);	        	
		block.setBlockName(ModReference.MOD_ID.toLowerCase() + ":" + registerName);	
		
		LanguageRegistry.instance().addStringLocalization(block.getUnlocalizedName()+".name","en_US", data.name);
		
        return false;
    }

    public static boolean registerChest(Cfg_chest[] data){
        int i;

        for(i=0;i<data.length;i++){
            boolean registered = registerChest(data[i]);

            if(!registered){
                LogHelper.error("Failed to register: Chest " + i);
                return false;
            }
        }

        return true;
    }
}
