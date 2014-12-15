package com.Otho.customItems.registry;

import net.minecraft.block.material.Material;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidRegistry;

import org.apache.logging.log4j.Level;

import com.Otho.customItems.ModReference;
import com.Otho.customItems.configuration.jsonReaders.blocks.Cfg_block;
import com.Otho.customItems.configuration.jsonReaders.blocks.Cfg_crop;
import com.Otho.customItems.configuration.jsonReaders.blocks.Cfg_fluid;
import com.Otho.customItems.mod.blocks.CustomBlock;
import com.Otho.customItems.mod.blocks.CustomCrop;
import com.Otho.customItems.mod.blocks.CustomFallingBlock;
import com.Otho.customItems.mod.blocks.CustomFluidBlock;
import com.Otho.customItems.mod.fluids.CustomFluid;
import com.Otho.customItems.mod.handler.BucketHandler;
import com.Otho.customItems.mod.items.CustomBucket;
import com.Otho.customItems.mod.items.CustomSeed;
import com.Otho.customItems.mod.materials.CI_Material;
import com.Otho.customItems.util.LogHelper;
import com.Otho.customItems.util.StringUtil;
import com.Otho.customItems.util.Util;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class BlockRegistry {
	
    public static boolean registerBlock(Cfg_block data){
    	LogHelper.log(Level.INFO, "Register Block: "+ data.name, 1);
		
		String registerName = StringUtil.parseRegisterName(data.name);
		
		if(data.toolClass != null)
		{
			data.toolClass = Util.validateToolClass(data.toolClass);		
			if(!data.toolClass.equals("pickaxe"))
			{
				data.harvestLevel = 0;
			}     
		}
		
		//Make Custom Block
		if(!data.falls)
		{
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
			
			block.setRenderNormaly(data.renderAsNormalBlock);
			block.slipperiness = data.slipperiness;
			block.setOpaque(data.isOpaque);
			block.setStepSound(Util.parseSoundType(data.stepSound));
			
			if(data.dropItemName != null)
			{
				block.setDropItem((Item) Item.itemRegistry.getObject(data.dropItemName));
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
		else
		{
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
			
			block.setRenderNormaly(data.renderAsNormalBlock);
			block.slipperiness = data.slipperiness;
			block.setOpaque(data.isOpaque);
			block.setStepSound(Util.parseSoundType(data.stepSound));
			
			if(data.dropItemName != null)
			{
				block.setDropItem((Item) Item.itemRegistry.getObject(data.dropItemName));
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
    	
        return true;
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
		
		String registerName = StringUtil.parseRegisterName(data.name);	        	
		
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
		
	    CustomCrop crop = new CustomCrop((Item) Item.itemRegistry.getObject(data.fruitName), cropRender);
	    CustomSeed seed = new CustomSeed(crop);
	    crop.setSeed(seed);
	    
	    crop.setAcceptBoneMeal(data.acceptBoneMeal);
	    crop.setDropSeedWhenMature(data.dropSeedWhenMature);
	    crop.setEachExtraFruitDropChance(data.eachExtraFruitDropChance);
	    crop.setEachExtraSeedDropChance(data.eachExtraSeedDropChance);
	    crop.setFruitQuantityDropRange(data.minFruitDrop, data.maxFruitDrop);
	    crop.setSeedQuantityDropRange(data.minSeedDrop, data.maxSeedDrop);
	    
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
		
		String registerName = StringUtil.parseRegisterName(data.name);
		
						
		CustomFluid fluid = new CustomFluid(data.name);
		
		fluid.setLuminosity(data.luminosity);
		fluid.setDensity(data.density);
		fluid.setTemperature(data.temperature);
		fluid.setViscosity(data.viscosity);
		fluid.setGaseous(data.isGas);
		FluidRegistry.registerFluid(fluid);
		
		CustomFluidBlock fluidBlock = new CustomFluidBlock(fluid, Material.water);
		
		Registry.blocksList.add(fluidBlock);
		Registry.blocksList.add(data.creativeTab);	       
		
		fluidBlock.setBlockName(Registry.mod_id.toLowerCase()+":"+data.name);
		GameRegistry.registerBlock(fluidBlock, registerName);
		
		
		fluid.setUnlocalizedName(fluidBlock.getUnlocalizedName().substring(fluidBlock.getUnlocalizedName().indexOf(":") + 1));
	    LanguageRegistry.instance().addStringLocalization(fluidBlock.getUnlocalizedName()+".name","en_US", data.name);
	    LanguageRegistry.instance().addStringLocalization(fluid.getUnlocalizedName(),"en_US", data.name);
	    fluid.setBlock(fluidBlock);
	    fluid.setIcons(fluidBlock);
		
		
		CustomBucket bucket = new CustomBucket(fluidBlock);
		
		
		bucket = new CustomBucket(fluidBlock);
		bucket.setUnlocalizedName(Registry.mod_id.toLowerCase()+":"+data.name+"Bucket");
		bucket.setContainerItem(Items.bucket);
		
		Registry.itemsList.add(bucket);
		Registry.itemsList.add(data.creativeTab);
		
	    GameRegistry.registerItem(bucket,registerName+"Bucket");
	    
	    FluidContainerRegistry.registerFluidContainer(FluidRegistry.getFluidStack(fluid.getName(),FluidContainerRegistry.BUCKET_VOLUME),new ItemStack(bucket),new ItemStack(Items.bucket));
	    LanguageRegistry.instance().addStringLocalization(bucket.getUnlocalizedName()+".name","en_US",data.name+" Bucket");
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
