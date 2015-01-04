package me.otho.customItems.registry;

import java.util.ArrayList;

import me.otho.customItems.configuration.jsonReaders.blocks.Cfg_block;
import me.otho.customItems.configuration.jsonReaders.blocks.Cfg_crop;
import me.otho.customItems.configuration.jsonReaders.blocks.Cfg_fluid;
import me.otho.customItems.mod.blocks.CustomBlock;
import me.otho.customItems.mod.blocks.CustomCrop;
import me.otho.customItems.mod.blocks.CustomFallingBlock;
import me.otho.customItems.mod.blocks.CustomFenceBlock;
import me.otho.customItems.mod.blocks.CustomFenceBlock;
import me.otho.customItems.mod.blocks.CustomFluidBlock;
import me.otho.customItems.mod.blocks.CustomPaneBlock;
import me.otho.customItems.mod.blocks.CustomRotatedPillar;
import me.otho.customItems.mod.blocks.CustomSlabBlock;
import me.otho.customItems.mod.blocks.CustomStairsBlock;
import me.otho.customItems.mod.blocks.CustomWallBlock;
import me.otho.customItems.mod.handler.BucketHandler;
import me.otho.customItems.mod.items.CustomBucket;
import me.otho.customItems.mod.items.CustomSeed;
import me.otho.customItems.mod.items.CustomSlabItem;
import me.otho.customItems.mod.materials.CI_Material;
import me.otho.customItems.util.LogHelper;
import me.otho.customItems.util.Util;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidRegistry;

import org.apache.logging.log4j.Level;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class BlockRegistry {
	
    public static boolean registerBlock(Cfg_block data){
    	LogHelper.log(Level.INFO, "Register Block: "+ data.name, 1);    	
    	
		data.toolClass = Util.validateToolClass(data.toolClass);				
		
		if(Util.validateType(data.type)){
			Util.BlockType blockType = Util.BlockType.valueOf(data.type.toUpperCase());
			switch(blockType){				
				case FENCE:
					registerFenceBlock(data);
					break;
				case LOG:
				case PILLARS:
					registerLogBlock(data);
					break;				
				case PANE:
					registerPaneBlock(data);
					break;				
				case SLAB:
					registerSlabBlock(data);
					break;
				case STAIRS:
					registerStairsBlock(data);
					break;
				case WALL:
					registerWallBlock(data);
					break;
				case FALLING:
					registerFallingBlock(data);
					break;
				case NORMAL:
				default:
					registerNormalBlock(data);					
					break;								
			}
		}
    	
        return true;
    }

    public static void registerWallBlock(Cfg_block data) {
    	String registerName = Util.parseRegisterName(data.name);
		
		CustomWallBlock block = new CustomWallBlock(new CustomBlock(CI_Material.getMaterial(data.material)));
		
		block.setHardness(data.hardness);
		block.setResistance(data.resistance);
		block.setBreaks(data.dropsItSelf);
		block.setCanSilkHarvest(data.canSilkHarvest);
		data.lightLevel = Util.range(data.lightLevel, 0, 1);
		
		block.setLightLevel(data.lightLevel);
		if(data.toolClass != null)
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
		
		if(data.dropItemName != null)
		{			
			block.setDropItem(data.dropItemName);				
			block.setMaxItemDrop(data.maxItemDrop);
			block.setMinItemDrop(data.minItemDrop);
			block.setEachExtraItemDropChance(data.eachExtraItemDropChance);
		}
		
		Registry.blocksList.add(block);
		Registry.blocksList.add(data.creativeTab);	
		
		//Register Block
		GameRegistry.registerBlock(block, registerName);			
		block.setBlockName(Registry.mod_id.toLowerCase() + ":" + registerName);			
		LanguageRegistry.instance().addStringLocalization(block.getUnlocalizedName()+".name","en_US", data.name);
		
		Item itemBlock = Item.getItemFromBlock(block);			
		int size = Util.range(data.maxStackSize, 1, 64);			
        itemBlock.setMaxStackSize(size);
		
	}

    public static void registerStairsBlock(Cfg_block data) {
		String registerName = Util.parseRegisterName(data.name);
		
		CustomStairsBlock block = new CustomStairsBlock(new CustomBlock(CI_Material.getMaterial(data.material)), 0);
		
		block.setHardness(data.hardness);
		block.setResistance(data.resistance);
		block.setBreaks(data.dropsItSelf);
		block.setCanSilkHarvest(data.canSilkHarvest);
		data.lightLevel = Util.range(data.lightLevel, 0, 1);
		
		block.setLightLevel(data.lightLevel);
		if(data.toolClass != null)
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
		
		if(data.dropItemName != null)
		{			
			block.setDropItem(data.dropItemName);				
			block.setMaxItemDrop(data.maxItemDrop);
			block.setMinItemDrop(data.minItemDrop);
			block.setEachExtraItemDropChance(data.eachExtraItemDropChance);
		}
		
		Registry.blocksList.add(block);
		Registry.blocksList.add(data.creativeTab);	
		
		//Register Block
		GameRegistry.registerBlock(block, registerName);			
		block.setBlockName(Registry.mod_id.toLowerCase() + ":" + registerName);			
		LanguageRegistry.instance().addStringLocalization(block.getUnlocalizedName()+".name","en_US", data.name);
		
		Item itemBlock = Item.getItemFromBlock(block);			
		int size = Util.range(data.maxStackSize, 1, 64);			
        itemBlock.setMaxStackSize(size);
		
	}

	public static void registerSlabBlock(Cfg_block data) {
		String registerName = Util.parseRegisterName(data.name);
		
		CustomSlabBlock slabBlock = new CustomSlabBlock(false, CI_Material.getMaterial(data.material), registerName);
		
		
		slabBlock.setHardness(data.hardness);
		slabBlock.setResistance(data.resistance);
		slabBlock.setBreaks(data.dropsItSelf);
		slabBlock.setCanSilkHarvest(data.canSilkHarvest);
		data.lightLevel = Util.range(data.lightLevel, 0, 1);
		
		slabBlock.setLightLevel(data.lightLevel);
		if(data.toolClass != null)
			slabBlock.setHarvestLevel(data.toolClass, data.harvestLevel);
		if(data.multipleTextures == null)
		{
			slabBlock.setBlockTextureName(data.textureName);
		}else
		{
			String[] textureNames = new String[6];
			textureNames[0] = data.multipleTextures.yneg;
			textureNames[1] = data.multipleTextures.ypos;
			textureNames[2] = data.multipleTextures.zneg;
			textureNames[3] = data.multipleTextures.zpos;
			textureNames[4] = data.multipleTextures.xneg;
			textureNames[5] = data.multipleTextures.xpos;
			slabBlock.registerBlockTextures(textureNames);
		}
		
		slabBlock.slipperiness = data.slipperiness;
		slabBlock.setOpaque(data.isOpaque);
		slabBlock.setStepSound(Util.parseSoundType(data.stepSound));
		
		if(data.dropItemName != null)
		{
			slabBlock.setDropItem(data.dropItemName);
			slabBlock.setMaxItemDrop(data.maxItemDrop);
			slabBlock.setMinItemDrop(data.minItemDrop);
			slabBlock.setEachExtraItemDropChance(data.eachExtraItemDropChance);
		}
		
		Registry.blocksList.add(slabBlock);
		Registry.blocksList.add(data.creativeTab);
		
		CustomSlabBlock doubleBlock = new CustomSlabBlock(true, CI_Material.getMaterial(data.material), registerName);
		
		
		doubleBlock.setHardness(data.hardness);
		doubleBlock.setResistance(data.resistance);
		doubleBlock.setBreaks(data.dropsItSelf);
		doubleBlock.setCanSilkHarvest(data.canSilkHarvest);
		data.lightLevel = Util.range(data.lightLevel, 0, 1);
		
		doubleBlock.setLightLevel(data.lightLevel);
		if(data.toolClass != null)
			doubleBlock.setHarvestLevel(data.toolClass, data.harvestLevel);
		if(data.multipleTextures == null)
		{
			doubleBlock.setBlockTextureName(data.textureName);
		}else
		{
			String[] textureNames = new String[6];
			textureNames[0] = data.multipleTextures.yneg;
			textureNames[1] = data.multipleTextures.ypos;
			textureNames[2] = data.multipleTextures.zneg;
			textureNames[3] = data.multipleTextures.zpos;
			textureNames[4] = data.multipleTextures.xneg;
			textureNames[5] = data.multipleTextures.xpos;
			doubleBlock.registerBlockTextures(textureNames);
		}
		
		//doubleBlock.setRenderNormaly(data);
		doubleBlock.slipperiness = data.slipperiness;
		doubleBlock.setOpaque(data.isOpaque);
		doubleBlock.setStepSound(Util.parseSoundType(data.stepSound));
		
		if(data.dropItemName != null)
		{
			doubleBlock.setDropItem(data.dropItemName);
			doubleBlock.setMaxItemDrop(data.maxItemDrop);
			doubleBlock.setMinItemDrop(data.minItemDrop);
			doubleBlock.setEachExtraItemDropChance(data.eachExtraItemDropChance);
		}
		
		//Register Block
		GameRegistry.registerBlock(slabBlock, CustomSlabItem.class, registerName, slabBlock, doubleBlock, false);
		
		slabBlock.setBlockName(Registry.mod_id.toLowerCase() + ":" + registerName);	
		
		LanguageRegistry.instance().addStringLocalization(slabBlock.getUnlocalizedName()+".name","en_US", data.name);
		
		Item itemBlock = Item.getItemFromBlock(slabBlock);			
		int size = Util.range(data.maxStackSize, 1, 64);			
        itemBlock.setMaxStackSize(size);
		

		GameRegistry.registerBlock(doubleBlock, CustomSlabItem.class, "double_" + registerName, slabBlock, doubleBlock, true);
		
		doubleBlock.setBlockName(Registry.mod_id.toLowerCase() + ":" + "double_" + registerName);	
		
		LanguageRegistry.instance().addStringLocalization(doubleBlock.getUnlocalizedName()+".name","en_US", data.name);
		
		itemBlock = Item.getItemFromBlock(slabBlock);			
		size = Util.range(data.maxStackSize, 1, 64);			
        itemBlock.setMaxStackSize(size);
		
	}

	public static void registerPaneBlock(Cfg_block data) {
		String registerName = Util.parseRegisterName(data.name);
		
		CustomPaneBlock block = new CustomPaneBlock("side", "top", Material.glass, true);
		
		block.setHardness(data.hardness);
		block.setResistance(data.resistance);
		block.setBreaks(data.dropsItSelf);
		block.setCanSilkHarvest(data.canSilkHarvest);
		data.lightLevel = Util.range(data.lightLevel, 0, 1);
		
		block.setLightLevel(data.lightLevel);
		if(data.toolClass != null)
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
		
		if(data.dropItemName != null)
		{			
			block.setDropItem(data.dropItemName);				
			block.setMaxItemDrop(data.maxItemDrop);
			block.setMinItemDrop(data.minItemDrop);
			block.setEachExtraItemDropChance(data.eachExtraItemDropChance);
		}
		
		Registry.blocksList.add(block);
		Registry.blocksList.add(data.creativeTab);	
		
		//Register Block
		GameRegistry.registerBlock(block, registerName);			
		block.setBlockName(Registry.mod_id.toLowerCase() + ":" + registerName);			
		LanguageRegistry.instance().addStringLocalization(block.getUnlocalizedName()+".name","en_US", data.name);
		
		Item itemBlock = Item.getItemFromBlock(block);			
		int size = Util.range(data.maxStackSize, 1, 64);			
        itemBlock.setMaxStackSize(size);
		
	}

	public static void registerFallingBlock(Cfg_block data) {
		String registerName = Util.parseRegisterName(data.name);		
		
		CustomFallingBlock block = new CustomFallingBlock(CI_Material.getMaterial(data.material));
		
		block.setHardness(data.hardness);
		block.setResistance(data.resistance);
		block.setBreaks(data.dropsItSelf);
		block.setCanSilkHarvest(data.canSilkHarvest);
		data.lightLevel = Util.range(data.lightLevel, 0, 1);
		
		block.setLightLevel(data.lightLevel);
		if(data.toolClass != null)
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
		
		if(data.dropItemName != null)
		{			
			block.setDropItem(data.dropItemName);				
			block.setMaxItemDrop(data.maxItemDrop);
			block.setMinItemDrop(data.minItemDrop);
			block.setEachExtraItemDropChance(data.eachExtraItemDropChance);
		}
		
		Registry.blocksList.add(block);
		Registry.blocksList.add(data.creativeTab);	
		
		//Register Block
		GameRegistry.registerBlock(block, registerName);			
		block.setBlockName(Registry.mod_id.toLowerCase() + ":" + registerName);			
		LanguageRegistry.instance().addStringLocalization(block.getUnlocalizedName()+".name","en_US", data.name);
		
		Item itemBlock = Item.getItemFromBlock(block);			
		int size = Util.range(data.maxStackSize, 1, 64);			
        itemBlock.setMaxStackSize(size);
        
		
	}

	public static void registerNormalBlock(Cfg_block data) {
		String registerName = Util.parseRegisterName(data.name);
		
		CustomBlock block = new CustomBlock(CI_Material.getMaterial(data.material));
		
		block.setHardness(data.hardness);
		block.setResistance(data.resistance);
		block.setBreaks(data.dropsItSelf);
		block.setCanSilkHarvest(data.canSilkHarvest);
		data.lightLevel = Util.range(data.lightLevel, 0, 1);
		
		block.setLightLevel(data.lightLevel);
		if(data.toolClass != null)
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
		
		if(data.dropItemName != null)
		{			
			block.setDropItem(data.dropItemName);				
			block.setMaxItemDrop(data.maxItemDrop);
			block.setMinItemDrop(data.minItemDrop);
			block.setEachExtraItemDropChance(data.eachExtraItemDropChance);
		}
		
		Registry.blocksList.add(block);
		Registry.blocksList.add(data.creativeTab);	
		
		//Register Block
		GameRegistry.registerBlock(block, registerName);			
		block.setBlockName(Registry.mod_id.toLowerCase() + ":" + registerName);			
		LanguageRegistry.instance().addStringLocalization(block.getUnlocalizedName()+".name","en_US", data.name);
		
		Item itemBlock = Item.getItemFromBlock(block);			
		int size = Util.range(data.maxStackSize, 1, 64);			
        itemBlock.setMaxStackSize(size);
		
	}

	public static void registerLogBlock(Cfg_block data) {
		String registerName = Util.parseRegisterName(data.name);
		
		CustomRotatedPillar block = new CustomRotatedPillar(CI_Material.getMaterial(data.material));
		
		block.setHardness(data.hardness);
		block.setResistance(data.resistance);
		block.setBreaks(data.dropsItSelf);
		block.setCanSilkHarvest(data.canSilkHarvest);
		data.lightLevel = Util.range(data.lightLevel, 0, 1);
		
		block.setLightLevel(data.lightLevel);
		if(data.toolClass != null)
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
		
		if(data.dropItemName != null)
		{			
			block.setDropItem(data.dropItemName);				
			block.setMaxItemDrop(data.maxItemDrop);
			block.setMinItemDrop(data.minItemDrop);
			block.setEachExtraItemDropChance(data.eachExtraItemDropChance);
		}
		
		Registry.blocksList.add(block);
		Registry.blocksList.add(data.creativeTab);	
		
		//Register Block
		GameRegistry.registerBlock(block, registerName);			
		block.setBlockName(Registry.mod_id.toLowerCase() + ":" + registerName);			
		LanguageRegistry.instance().addStringLocalization(block.getUnlocalizedName()+".name","en_US", data.name);
		
		Item itemBlock = Item.getItemFromBlock(block);			
		int size = Util.range(data.maxStackSize, 1, 64);			
        itemBlock.setMaxStackSize(size);
		
	}

	public static void registerFenceBlock(Cfg_block data) {
		String registerName = Util.parseRegisterName(data.name);
		
		CustomFenceBlock block = new CustomFenceBlock(data.textureName, CI_Material.getMaterial(data.material));
		
		block.setHardness(data.hardness);
		block.setResistance(data.resistance);
		block.setBreaks(data.dropsItSelf);
		block.setCanSilkHarvest(data.canSilkHarvest);
		data.lightLevel = Util.range(data.lightLevel, 0, 1);
		
		block.setLightLevel(data.lightLevel);
		if(data.toolClass != null)
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
		
		if(data.dropItemName != null)
		{			
			block.setDropItem(data.dropItemName);				
			block.setMaxItemDrop(data.maxItemDrop);
			block.setMinItemDrop(data.minItemDrop);
			block.setEachExtraItemDropChance(data.eachExtraItemDropChance);
		}
		
		Registry.blocksList.add(block);
		Registry.blocksList.add(data.creativeTab);	
		
		//Register Block
		GameRegistry.registerBlock(block, registerName);			
		block.setBlockName(Registry.mod_id.toLowerCase() + ":" + registerName);			
		LanguageRegistry.instance().addStringLocalization(block.getUnlocalizedName()+".name","en_US", data.name);
		
		Item itemBlock = Item.getItemFromBlock(block);			
		int size = Util.range(data.maxStackSize, 1, 64);			
        itemBlock.setMaxStackSize(size);
		
	}

	public static boolean registerBlock(Cfg_block[] data){
        int i;

        for(i=0;i<data.length;i++){
            boolean registered = registerBlock(data[i]);

            if(!registered){
                LogHelper.error("Failed to register: Block " + i);
                return false;
            }
        }

        return true;
    }

    public static boolean registerCrop(Cfg_crop data){
    	LogHelper.log(Level.INFO, data.name, 1);
		
		String registerName = Util.parseRegisterName(data.name);	        	
		
		int cropRender;
		
		if(data.renderType.equals("crops"))
		{
			cropRender = 6;
		}else if(data.renderType.equals("flower"))
		{
			cropRender = 1;
		}else{
			cropRender = 6;
		}
		
	    CustomCrop crop = new CustomCrop(data.fruitName, cropRender);
	    CustomSeed seed = new CustomSeed(crop);
	    crop.setSeed(seed);
	    
	    crop.setAcceptBoneMeal(data.acceptBoneMeal);
	    crop.setDropSeedWhenMature(data.dropSeedWhenMature);
	    crop.setEachExtraFruitDropChance(data.eachExtraFruitDropChance);
	    crop.setEachExtraSeedDropChance(data.eachExtraSeedDropChance);
	    crop.setFruitQuantityDropRange(data.minFruitDrop, data.maxFruitDrop);
	    crop.setSeedQuantityDropRange(data.minSeedDrop, data.maxSeedDrop);
	    crop.setFruitItemDamage(data.dropFruitDamage);
	    
	    crop.setBlockTextureName(data.textureName);
	    
	    seed.setTextureName(data.textureName+"_seed");
	    
	    GameRegistry.registerBlock(crop, registerName + "_crop");
	    crop.setBlockName(Registry.mod_id.toLowerCase()+":" + registerName + "_crop");
	    LanguageRegistry.instance().addStringLocalization(crop.getUnlocalizedName()+".name","en_US", data.name);

	    GameRegistry.registerItem(seed, registerName + "_seed");
	    seed.setUnlocalizedName(Registry.mod_id.toLowerCase()+":" + registerName + "_seed");
	    LanguageRegistry.instance().addStringLocalization(seed.getUnlocalizedName()+".name","en_US", data.name + " Seeds");
	    
	    Registry.itemsList.add(seed);
	    Registry.itemsList.add(data.creativeTab);

	    if(data.dropFromGrassChance > 0) 
	    {
	        MinecraftForge.addGrassSeed(new ItemStack(seed), data.dropFromGrassChance);
	    }
    	
    	return true;
    }

    public static boolean registerCrop(Cfg_crop[] data){
        int i;

        for(i=0;i<data.length;i++){
            boolean registered = registerCrop(data[i]);

            if(!registered){
                LogHelper.error("Failed to register: Crop " + i);
                return false;
            }
        }

        return true;
    }

    public static boolean registerFluid(Cfg_fluid data){
    	LogHelper.log(Level.INFO, data.name, 1);
		
		String registerName = Util.parseRegisterName(data.name);
		
						
		Fluid fluid = new Fluid(registerName);
		//fluid.setLuminosity(data.luminosity);
		
		fluid.setDensity(data.density);
		fluid.setTemperature(data.temperature);
		fluid.setViscosity(data.viscosity);
		fluid.setGaseous(data.isGas);		
		
		FluidRegistry.registerFluid(fluid);

		
		CustomFluidBlock fluidBlock = new CustomFluidBlock(fluid, Material.water);
		
		fluidBlock.setQuantaPerBlock(data.flowLength);
		fluidBlock.setLightLevel(data.lightLevel);
		
		fluidBlock.setBlockTextureName(data.textureName);

		Registry.blocksList.add(fluidBlock);
		Registry.blocksList.add(data.creativeTab);	       
		
		fluidBlock.setBlockName(Registry.mod_id.toLowerCase()+":"+data.name);
		GameRegistry.registerBlock(fluidBlock, registerName);
		
		
		fluid.setUnlocalizedName(fluidBlock.getUnlocalizedName().substring(fluidBlock.getUnlocalizedName().indexOf(":") + 1));
	    LanguageRegistry.instance().addStringLocalization(fluidBlock.getUnlocalizedName()+".name","en_US", data.name);
	    LanguageRegistry.instance().addStringLocalization(fluid.getUnlocalizedName(),"en_US", data.name);
	    fluid.setBlock(fluidBlock);
		
		CustomBucket bucket = new CustomBucket(fluidBlock, data.textureName);
		
		bucket.setUnlocalizedName(Registry.mod_id.toLowerCase()+":"+data.name+"_bucket");
		bucket.setContainerItem(Items.bucket);
		
		Registry.itemsList.add(bucket);
		Registry.itemsList.add(data.creativeTab);

		bucket.setTextureName(data.textureName+"Bucket");
	    GameRegistry.registerItem(bucket,registerName+"Bucket");
	    
	    FluidContainerRegistry.registerFluidContainer(FluidRegistry.getFluidStack(fluid.getName(),FluidContainerRegistry.BUCKET_VOLUME),new ItemStack(bucket),new ItemStack(Items.bucket));
	    LanguageRegistry.instance().addStringLocalization(bucket.getUnlocalizedName()+".name","en_US",data.name+"_bucket");
	    BucketHandler.INSTANCE.buckets.put(fluidBlock, bucket);
	    MinecraftForge.EVENT_BUS.register(BucketHandler.INSTANCE);
    	
        return true;
    }

    public static boolean registerFluid(Cfg_fluid[] data){
        int i;

        for(i=0;i<data.length;i++){
            boolean registered = registerFluid(data[i]);

            if(!registered){
                LogHelper.error("Failed to register: Fluid " + i);
                return false;
            }
        }

        return true;
    }
    
}
