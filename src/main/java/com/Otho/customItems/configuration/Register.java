package com.Otho.customItems.configuration;

import net.minecraft.block.material.Material;
import net.minecraft.client.audio.SoundCategory;
import net.minecraft.client.audio.SoundEventAccessorComposite;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidRegistry;

import com.Otho.customItems.handler.BucketHandler;
import com.Otho.customItems.lib.constants;
import com.Otho.customItems.mod.blocks.CustomBlock;
import com.Otho.customItems.mod.blocks.CustomFluidBlock;
import com.Otho.customItems.mod.fluids.CustomFluid;
import com.Otho.customItems.mod.items.CustomBucket;
import com.Otho.customItems.mod.items.CustomItem;
import com.Otho.customItems.mod.items.armor.CustomArmor;
import com.Otho.customItems.mod.items.disks.CustomDisk;
import com.Otho.customItems.mod.items.food.CustomFood;
import com.Otho.customItems.mod.items.tools.CustomAxe;
import com.Otho.customItems.mod.items.tools.CustomHoe;
import com.Otho.customItems.mod.items.tools.CustomPickaxe;
import com.Otho.customItems.mod.items.tools.CustomShovel;
import com.Otho.customItems.mod.items.tools.CustomSword;
import com.Otho.customItems.mod.materials.CI_Material;
import com.Otho.customItems.util.StringUtil;
import com.Otho.customItems.util.LogHelper;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

import org.apache.logging.log4j.Level;

public class Register {
	
//	public static void init(){
//		registerBlocks();
//		registerFoods();
//		registerItems();
//		registerFluids();
//		registerPickaxes();
//		registerAxes();
//		registerShovels();
//		registerHoes();
//		registerSwords();
//		registerHelmets();
//		registerChestplates();
//		registerLeggings();
//		registerBoots();
//	}
	
	public static void register(JsonSchema data, String fileName){
		LogHelper.log(Level.INFO, fileName);
		
		registerBlocks(data.blocks);
		registerFoods(data.foods);
		registerItems(data.items);
		registerFluids(data.fluids);
		registerPickaxes(data.pickaxes);
		registerAxes(data.axes);
		registerShovels(data.shovels);
		registerHoes(data.hoes);
		registerSwords(data.swords);
		registerHelmets(data.helmets);
		registerChestplates(data.chestplates);
		registerLeggings(data.leggings);
		registerBoots(data.boots);
	}
	
	private static void registerBlocks (Block[] input)
	{
		Block[] blocksData = input;
		
		int i;
		
		if(blocksData != null)
		{	        
			LogHelper.log(Level.INFO, "Registering Blocks:");
	        for(i=0;i<blocksData.length;i++) {            
	        	Block blockData = blocksData[i];
	        	
	        	LogHelper.log(Level.INFO, blockData.name, 1);
	        	
	        	String registerName = StringUtil.parseRegisterName(blockData.name);
	        	
	        	blockData.toolClass = validateToolClass(blockData.toolClass);
	        	if(!blockData.toolClass.equals("pickaxe"))
	        	{
	        		blockData.harvestLevel = 0;
	        	}       	
	        
	        	//Make Custom Block
	        	CustomBlock block = new CustomBlock(CI_Material.getMaterial(blockData.material));
	        	
	        	block.setHardness(blockData.hardness);
	        	block.setResistance(blockData.resistance);
	        	block.setLightLevel(blockData.lightLevel);	        	
	        	block.setHarvestLevel(blockData.toolClass, blockData.harvestLevel);
	        	
	        	
	        	
	        	
	        	//Register Block
	        	GameRegistry.registerBlock(block, registerName);
	        	block.setBlockName(constants.MOD_ID.toLowerCase()+":"+blockData.textureName); 
	        	LanguageRegistry.instance().addStringLocalization(block.getUnlocalizedName()+".name","en_US", blockData.name);
	        }
		}
	}
	private static void registerFoods(Food[] input)
	{
		Food[] foods = input;
		
		int i;		
		
		if(foods != null)
		{
			LogHelper.log(Level.INFO, "Registering Foods:");
			for(i=0;i<foods.length;i++)
			{
				Food data = foods[i];
				
				LogHelper.log(Level.INFO, data.name, 1);
				
				data.textureName = StringUtil.parseRegisterName(data.textureName);				
			
				CustomFood food = new CustomFood(data.healAmount, data.saturationModifier, false);
				
				
				if(data.potionEffect != null)
				{	
					food.setPotionEffect(potionEffectId(data.potionEffect.effect), 
							data.potionEffect.potionDuration, 
							data.potionEffect.potionAmplifier, 
							data.potionEffect.potionEffectProbability);
				}
				
					
				
				GameRegistry.registerItem(food, data.textureName);
				food.setUnlocalizedName(constants.MOD_ID.toLowerCase() + ":"+data.textureName);
				LanguageRegistry.instance().addStringLocalization(food.getUnlocalizedName()+".name","en_US", data.name);				
			}
		}
	}
	private static void registerItems(ReaderItem[] input){
		ReaderItem[] items = input;
		
		int i;
		
	
		if(items != null)
		{
			LogHelper.log(Level.INFO, "Registering Items:");
			for(i=0;i<items.length;i++)
			{
				ReaderItem data = items[i];
				
				LogHelper.log(Level.INFO, data.name, 1);
				
				data.textureName = StringUtil.parseRegisterName(data.textureName);
				
				CustomItem item = new CustomItem(data.maxStackSize);
	           
	            GameRegistry.registerItem(item, data.textureName);
	            item.setUnlocalizedName(constants.MOD_ID.toLowerCase() + ":"+data.textureName);
	            LanguageRegistry.instance().addStringLocalization(item.getUnlocalizedName()+".name","en_US",data.name);
			}
		}
	}
	private static void registerFluids(Fluid[] input){
		Fluid[] fluids = input;
		int i;
		
		
		
		if(fluids != null)
		{
			LogHelper.log(Level.INFO, "Registering Fluids:");
			for(i=0;i<fluids.length;i++)
			{
				Fluid data = fluids[i];
				
				LogHelper.log(Level.INFO, data.name, 1);
				
				data.textureName = StringUtil.parseRegisterName(data.textureName);
				
								
				CustomFluid fluid = new CustomFluid(data.name);
				
				fluid.setLuminosity(data.luminosity);
				fluid.setDensity(data.density);
				fluid.setTemperature(data.temperature);
				fluid.setViscosity(data.viscosity);
				fluid.setGaseous(data.isGas);
				FluidRegistry.registerFluid(fluid);
				
				CustomFluidBlock fluidBlock = new CustomFluidBlock(fluid, Material.water);
				fluidBlock.setBlockName(constants.MOD_ID.toLowerCase()+":"+data.name);
				GameRegistry.registerBlock(fluidBlock, data.textureName);
				
				fluid.setUnlocalizedName(fluidBlock.getUnlocalizedName().substring(fluidBlock.getUnlocalizedName().indexOf(":") + 1));
	            LanguageRegistry.instance().addStringLocalization(fluidBlock.getUnlocalizedName()+".name","en_US", data.name);
	            LanguageRegistry.instance().addStringLocalization(fluid.getUnlocalizedName(),"en_US", data.name);
	            fluid.setBlock(fluidBlock);
	            fluid.setIcons(fluidBlock);
				
				
				CustomBucket bucket = new CustomBucket(fluidBlock);
				
				
				bucket = new CustomBucket(fluidBlock);
				bucket.setUnlocalizedName(constants.MOD_ID.toLowerCase()+":"+data.name+"Bucket");
				bucket.setContainerItem(Items.bucket);
		        GameRegistry.registerItem(bucket,data.textureName+"Bucket");
		        
		        FluidContainerRegistry.registerFluidContainer(FluidRegistry.getFluidStack(fluid.getName(),FluidContainerRegistry.BUCKET_VOLUME),new ItemStack(bucket),new ItemStack(Items.bucket));
		        LanguageRegistry.instance().addStringLocalization(bucket.getUnlocalizedName()+".name","en_US",data.name+" Bucket");
		        BucketHandler.INSTANCE.buckets.put(fluidBlock, bucket);
		        MinecraftForge.EVENT_BUS.register(BucketHandler.INSTANCE);
				
			}
		}
	}
	private static void registerPickaxes(Pickaxe[] input)
	{
		Pickaxe[] pickaxes = input;
		
		int i;
		
		if(pickaxes != null)
		{
			LogHelper.log(Level.INFO, "Registering Pickaxes:");
			for(i=0;i<pickaxes.length;i++)
			{
				Pickaxe data = pickaxes[i];
				
				LogHelper.log(Level.INFO, data.name, 1);
				
				data.textureName = StringUtil.parseRegisterName(data.textureName);
				
				Item.ToolMaterial material = EnumHelper.addToolMaterial(
						data.textureName, 
						data.harvestLevel, 
						data.maxUses, 
						data.efficiencyOnProperMaterial, 
						data.damageVsEntity, 
						data.enchantability);
				
				CustomPickaxe pickaxe = new CustomPickaxe(material);
				
				GameRegistry.registerItem(pickaxe, data.textureName);
				pickaxe.setUnlocalizedName(constants.MOD_ID.toLowerCase()+":"+data.textureName);
	            LanguageRegistry.instance().addStringLocalization(pickaxe.getUnlocalizedName()+".name","en_US",data.name.substring(0, 1).toUpperCase()+data.name.substring(1));
			}
		}
	}
	private static void registerAxes(Axe[] input)
	{
		Axe[] axes = input;
		
		int i;
		
		if(axes != null)
		{
			LogHelper.log(Level.INFO, "Registering Axes:");
			for(i=0;i<axes.length;i++)
			{
				Axe data = axes[i];
				
				LogHelper.log(Level.INFO, data.name, 1);
				
				data.textureName = StringUtil.parseRegisterName(data.textureName);
				
				Item.ToolMaterial material = EnumHelper.addToolMaterial(
						data.textureName, 
						data.harvestLevel, 
						data.maxUses, 
						data.efficiencyOnProperMaterial, 
						data.damageVsEntity, 
						data.enchantability);
				
				CustomAxe axe = new CustomAxe(material);
				
				GameRegistry.registerItem(axe, data.textureName);
				axe.setUnlocalizedName(constants.MOD_ID.toLowerCase()+":"+data.textureName);
	            LanguageRegistry.instance().addStringLocalization(axe.getUnlocalizedName()+".name","en_US",data.name.substring(0, 1).toUpperCase()+data.name.substring(1));
			}
		}
	}
	private static void registerShovels(Shovel[] input)
	{
		Shovel[] shovels = input;
		
		int i;
		
		if(shovels != null)
		{
			LogHelper.log(Level.INFO, "Registering Shovels:");		
			for(i=0;i<shovels.length;i++)
			{
				Shovel data = shovels[i];
				
				LogHelper.log(Level.INFO, data.name, 1);
				
				data.textureName = StringUtil.parseRegisterName(data.textureName);
				
				Item.ToolMaterial material = EnumHelper.addToolMaterial(
						data.textureName, 
						data.harvestLevel, 
						data.maxUses, 
						data.efficiencyOnProperMaterial, 
						data.damageVsEntity, 
						data.enchantability);
				
				CustomShovel shovel = new CustomShovel(material);
				
				GameRegistry.registerItem(shovel, data.textureName);
				shovel.setUnlocalizedName(constants.MOD_ID.toLowerCase()+":"+data.textureName);
	            LanguageRegistry.instance().addStringLocalization(shovel.getUnlocalizedName()+".name","en_US",data.name.substring(0, 1).toUpperCase()+data.name.substring(1));
			}
		}
	}
	private static void registerHoes(Hoe[] input)
	{
		Hoe[] hoes = input;
		
		int i;
		
		if(hoes != null)
		{
			LogHelper.log(Level.INFO, "Registering Hoes:");
			for(i=0;i<hoes.length;i++)
			{
				Hoe data = hoes[i];
				
				LogHelper.log(Level.INFO, data.name, 1);
				
				data.textureName = StringUtil.parseRegisterName(data.textureName);
				
				Item.ToolMaterial material = EnumHelper.addToolMaterial(
						data.textureName, 
						data.harvestLevel, 
						data.maxUses, 
						data.efficiencyOnProperMaterial, 
						data.damageVsEntity, 
						data.enchantability);
				
				CustomHoe hoe = new CustomHoe(material);
				
				GameRegistry.registerItem(hoe, data.textureName);
				hoe.setUnlocalizedName(constants.MOD_ID.toLowerCase()+":"+data.textureName);
	            LanguageRegistry.instance().addStringLocalization(hoe.getUnlocalizedName()+".name","en_US",data.name.substring(0, 1).toUpperCase()+data.name.substring(1));
			}
		}
	}
	private static void registerSwords(Sword[] input)
	{
		Sword[] swords = input;
		
		int i;
		if(swords != null)
		{
			LogHelper.log(Level.INFO, "Registering Swords:");
			for(i=0;i<swords.length;i++)
			{
				Sword data = swords[i];
				
				LogHelper.log(Level.INFO, data.name, 1);
				
				data.textureName = StringUtil.parseRegisterName(data.textureName);
				
				Item.ToolMaterial material = EnumHelper.addToolMaterial(
						data.textureName, 
						data.harvestLevel, 
						data.maxUses, 
						data.efficiencyOnProperMaterial, 
						data.damageVsEntity, 
						data.enchantability);
				
				CustomSword sword = new CustomSword(material);
				
				GameRegistry.registerItem(sword, data.textureName);
				sword.setUnlocalizedName(constants.MOD_ID.toLowerCase()+":"+data.textureName);
	            LanguageRegistry.instance().addStringLocalization(sword.getUnlocalizedName()+".name","en_US",data.name.substring(0, 1).toUpperCase()+data.name.substring(1));
			}
		}
	}
	private static void registerHelmets(Helmet[] input)
	{
		Helmet[] helmets = input;
		int i;
		
		if(helmets != null)
		{
			LogHelper.log(Level.INFO, "Registering Helmets:");
			for(i=0;i<helmets.length;i++)
			{
				Helmet data = helmets[i];
				
				LogHelper.log(Level.INFO, data.name, 1);
				
				data.textureName = StringUtil.parseRegisterName(data.textureName);
	        	
	        	
				//Make Custom Armor
	        	int reduction[] = {0,0,0,0};
	        	reduction[0] = data.reductionNum;
	        	
	        	ItemArmor.ArmorMaterial material = EnumHelper.addArmorMaterial(data.textureName, data.durability, reduction, data.enchantability);
	        	CustomArmor armor = new CustomArmor(material, 0, 0, data.textureName);
				//Register Armor
	        	
	        	GameRegistry.registerItem(armor, data.textureName+"_"+0);
	            armor.setUnlocalizedName(constants.MOD_ID.toLowerCase()+":"+data.name);
	            LanguageRegistry.instance().addStringLocalization(armor.getUnlocalizedName()+".name","en_US",data.name.substring(0, 1).toUpperCase()+data.name.substring(1));        	 	
			}
		}
	}
	
	private static void registerChestplates(Chestplate[] input)
	{
		Chestplate[] chestplates = input;
		int i;
		
		if(chestplates != null)
		{
			LogHelper.log(Level.INFO, "Registering Chestplates:");
			for(i=0;i<chestplates.length;i++)
			{
				Chestplate data = chestplates[i];
				
				LogHelper.log(Level.INFO, data.name, 1);
				
				data.textureName = StringUtil.parseRegisterName(data.textureName);
	        	
	        	
				//Make Custom Armor
	        	int reduction[] = {0,0,0,0};
	        	reduction[1] = data.reductionNum;
	        	
	        	ItemArmor.ArmorMaterial material = EnumHelper.addArmorMaterial(data.textureName, data.durability, reduction, data.enchantability);
	        	CustomArmor armor = new CustomArmor(material, 0, 1, data.textureName);
				//Register Armor
	        	
	        	GameRegistry.registerItem(armor, data.textureName+"_"+1);
	            armor.setUnlocalizedName(constants.MOD_ID.toLowerCase()+":"+data.name);
	            LanguageRegistry.instance().addStringLocalization(armor.getUnlocalizedName()+".name","en_US",data.name.substring(0, 1).toUpperCase()+data.name.substring(1));        	 	
			}
		}
	}
	
	
	
	private static void registerLeggings(Leggings[] input)
	{
		Leggings[] leggings = input;
		int i;
		
		if(leggings != null)
		{
			LogHelper.log(Level.INFO, "Registering Leggings:");
			for(i=0;i<leggings.length;i++)
			{
				Leggings data = leggings[i];
				
				LogHelper.log(Level.INFO, data.name, 1);
				
				data.textureName = StringUtil.parseRegisterName(data.textureName);
	        	
	        	
				//Make Custom Armor
	        	int reduction[] = {0,0,0,0};
	        	reduction[2] = data.reductionNum;
	        	
	        	ItemArmor.ArmorMaterial material = EnumHelper.addArmorMaterial(data.textureName, data.durability, reduction, data.enchantability);
	        	CustomArmor armor = new CustomArmor(material, 0, 2, data.textureName);
				//Register Armor
	        	
	        	GameRegistry.registerItem(armor, data.textureName+"_"+2);
	            armor.setUnlocalizedName(constants.MOD_ID.toLowerCase()+":"+data.name);
	            LanguageRegistry.instance().addStringLocalization(armor.getUnlocalizedName()+".name","en_US",data.name.substring(0, 1).toUpperCase()+data.name.substring(1));        	 	
			}
		}
	}
	
	private static void registerBoots(Boots[] input)
	{
		Boots[] boots = input;
		int i;
		
		if(boots != null)
		{			
			LogHelper.log(Level.INFO, "Registering Boots:");
			for(i=0;i<boots.length;i++)
			{
				Boots data = boots[i];
				
				LogHelper.log(Level.INFO, data.name, 1);
				
				data.textureName = StringUtil.parseRegisterName(data.textureName);
	        	
	        	
				//Make Custom Armor
	        	int reduction[] = {0,0,0,0};
	        	reduction[3] = data.reductionNum;
	        	
	        	ItemArmor.ArmorMaterial material = EnumHelper.addArmorMaterial(data.textureName, data.durability, reduction, data.enchantability);
	        	CustomArmor armor = new CustomArmor(material, 0, 3, data.textureName);
				//Register Armor
	        	
	        	GameRegistry.registerItem(armor, data.textureName+"_"+3);
	            armor.setUnlocalizedName(constants.MOD_ID.toLowerCase()+":"+data.name);
	            LanguageRegistry.instance().addStringLocalization(armor.getUnlocalizedName()+".name","en_US",data.name.substring(0, 1).toUpperCase()+data.name.substring(1));        	 	
			}
		}
	}
	
	private static void registerDisks(){
//		JsonArray disksData = JsonConfigurationHandler.musicDisks;
//		
//		int i;
//		
//		if(disksData != null)
//		{
//			for(i=0;i<disksData.size();i++)
//			{
//				JsonObject data = (JsonObject) disksData.get(i);
//				
//				String name =  data.get("name").getAsString();
//				String textureName =  data.get("textureName").getAsString();
//				textureName = StringUtil.parseTextureName(textureName);
//				
//				String music =  data.get("music").getAsString();
//				
//				CustomDisk disk = new CustomDisk(music);
//				
//				GameRegistry.registerItem(disk, textureName);
//				disk.setUnlocalizedName(constants.MOD_ID.toLowerCase()+":"+name);
//				
//				ResourceLocation rl = new ResourceLocation(constants.MOD_ID.toLowerCase()+":sounds/records/"+textureName);
//				SoundCategory a = SoundCategory.valueOf("RECORDS");
//				SoundEventAccessorComposite b = new SoundEventAccessorComposite(rl, 2.0, 2.0, a);
//				
//				
//				
//				LanguageRegistry.instance().addStringLocalization(disk.getUnlocalizedName()+".name","en_US","Music Disc");				
//			}
//		}
	}
	
	//Utils
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
	
	private static int potionEffectId (String effect)
	{
		if(effect.equals("moveSpeed"))
		{
			return 1;
		}
		else if(effect.equals("moveSlowdown"))
		{
			return 2;
		}
		else if(effect.equals("digSpeed"))
		{
			return 3;
		}
		else if(effect.equals("digSlowdown"))
		{
			return 4;
		}
		else if(effect.equals("damageBoost"))
		{
			return 5;
		}
		else if(effect.equals("heal"))
		{
			return 6;
		}
		else if(effect.equals("harm"))
		{
			return 7;
		}
		else if(effect.equals("jump"))
		{
			return 8;
		}
		else if(effect.equals("confusion"))
		{
			return 9;
		}
		else if(effect.equals("regeneration"))
		{
			return 10;
		}
		else if(effect.equals("resistance"))
		{
			return 11;
		}
		else if(effect.equals("fireResistance"))
		{
			return 12;
		}
		else if(effect.equals("waterBreathing"))
		{
			return 13;
		}
		else if(effect.equals("invisibility"))
		{
			return 14;
		}
		else if(effect.equals("blindness"))
		{
			return 15;
		}
		else if(effect .equals("nightVision"))
		{
			return 16;
		}
		else if(effect.equals("hunger"))
		{
			return 17;
		}
		else if(effect.equals("weakness"))
		{
			return 18;
		}
		else if(effect.equals("poison"))
		{
			return 19;
		}
		else if(effect.equals("wither"))
		{
			return 20;
		}
		else if(effect.equals("healthBoost"))
		{
		    return 21;
		}
		else if(effect.equals("healthBoost"))
		{
		    return 22;
		}
		else if(effect.equals("healthBoost"))
		{
		    return 23;
		}
		else
		{
			return 6;
		}		
	}

}
