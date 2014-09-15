package com.Otho.customItems.handler;

import net.minecraft.block.material.Material;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidRegistry;

import com.Otho.customItems.lib.constants;
import com.Otho.customItems.mod.blocks.CustomFluidBlock;
import com.Otho.customItems.mod.fluids.CustomFluid;
import com.Otho.customItems.mod.items.CustomBucket;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class FluidsHandler {

	public static void init()
	{
		JsonArray fluids = ConfigurationHandler.fluids;
		int i;
		
		
		
		if(fluids != null)
		{
			for(i=0;i<fluids.size();i++)
			{
				JsonObject data = (JsonObject) fluids.get(i);
				
				String name = data.get("name").getAsString();
				String textureName = data.get("textureName").getAsString();
				int luminosity = data.get("luminosity").getAsInt();
				int density = data.get("density").getAsInt();
				int temperature = data.get("temperature").getAsInt();
				int viscosity = data.get("viscosity").getAsInt();
				boolean isGas = data.get("isGas").getAsBoolean();
				
				
				
				CustomFluid fluid = new CustomFluid(name);
				
				fluid.setLuminosity(luminosity);
				fluid.setDensity(density);
				fluid.setTemperature(temperature);
				fluid.setViscosity(viscosity);
				fluid.setGaseous(isGas);
				FluidRegistry.registerFluid(fluid);
				
				CustomFluidBlock fluidBlock = new CustomFluidBlock(fluid, Material.water);
				fluidBlock.setBlockName(constants.MOD_ID.toLowerCase()+":"+name);
				GameRegistry.registerBlock(fluidBlock, name);
				
				fluid.setUnlocalizedName(fluidBlock.getUnlocalizedName().substring(fluidBlock.getUnlocalizedName().indexOf(":") + 1));
	            LanguageRegistry.instance().addStringLocalization(fluidBlock.getUnlocalizedName()+".name","en_US", name);
	            LanguageRegistry.instance().addStringLocalization(fluid.getUnlocalizedName(),"en_US", name);
	            fluid.setBlock(fluidBlock);
	            fluid.setIcons(fluidBlock);
				
				
				CustomBucket bucket = new CustomBucket(fluidBlock);
				
				
				bucket = new CustomBucket(fluidBlock);
				bucket.setUnlocalizedName(constants.MOD_ID.toLowerCase()+":"+name+"Bucket");
				bucket.setContainerItem(Items.bucket);
		        GameRegistry.registerItem(bucket,name+"Bucket");
		        
		        FluidContainerRegistry.registerFluidContainer(FluidRegistry.getFluidStack(fluid.getName(),FluidContainerRegistry.BUCKET_VOLUME),new ItemStack(bucket),new ItemStack(Items.bucket));
		        LanguageRegistry.instance().addStringLocalization(bucket.getUnlocalizedName()+".name","en_US",name+" Bucket");
		        BucketHandler.INSTANCE.buckets.put(fluidBlock, bucket);
		        MinecraftForge.EVENT_BUS.register(BucketHandler.INSTANCE);
				
			}
		}
	}	
}
