package com.Otho.customItems.configuration;

import java.util.ArrayList;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.audio.SoundCategory;
import net.minecraft.client.audio.SoundEventAccessorComposite;
import net.minecraft.creativetab.CreativeTabs;
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
import com.Otho.customItems.mod.blocks.CustomCrop;
import com.Otho.customItems.mod.blocks.CustomFluidBlock;
import com.Otho.customItems.mod.creativeTab.customItemsTab;
import com.Otho.customItems.mod.fluids.CustomFluid;
import com.Otho.customItems.mod.items.CustomBucket;
import com.Otho.customItems.mod.items.CustomItem;
import com.Otho.customItems.mod.items.CustomSeed;
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

public class RegisterCustomItems {
	
	private static  ArrayList<Object> itemsList = new ArrayList();
	private static  ArrayList<Object> blocksList = new ArrayList();
	
	public static int registerId = -1;
	
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
		registerCrops(data.crops);
		
		registerTabs(data.creativeTabs);
		
		setCreativeTabs();		
	}
	
	private static void registerTabs(Cfg_creativeTab[] input)
	{
		Cfg_creativeTab[] tabs = input;
		
		int i;
		
		if(tabs != null)
		{
			LogHelper.log(Level.INFO, "Registering Creative Tabs:");
			for(i=0;i<tabs.length;i++)
			{
				Cfg_creativeTab data = tabs[i];
				
				String[] itemName = data.iconItem.split(":");
				Item iconItem = GameRegistry.findItem(itemName[0], itemName[1]);
				
				customItemsTab tab = new customItemsTab(iconItem, data.tabLabel);
				customItemsTab.registerCreativeTab(tab);
			}
		}
	}
	
	private static void setCreativeTabs(){
		int i;
		
		for(i=0;i<itemsList.size();i+=2)
		{
			Item item = (Item) itemsList.get(i);
			item.setCreativeTab(customItemsTab.getTabByName((String) itemsList.get(i+1)));
		}
		
		for(i=0;i<blocksList.size();i+=2)
		{
			Block block = (Block) blocksList.get(i);			
			block.setCreativeTab(customItemsTab.getTabByName((String) blocksList.get(i+1)));
		}
	}
	
	private static void registerBlocks (Cfg_block[] input)
	{
		Cfg_block[] blocksData = input;
		
		int i;
		
		if(blocksData != null)
		{	        
			LogHelper.log(Level.INFO, "Registering Blocks:");
	        for(i=0;i<blocksData.length;i++) {            
	        	Cfg_block data = blocksData[i];
	        	
	        	LogHelper.log(Level.INFO, data.name, 1);
	        	
	        	String registerName = StringUtil.parseRegisterName(data.name);
	        	
	        	data.toolClass = validateToolClass(data.toolClass);
	        	if(!data.toolClass.equals("pickaxe"))
	        	{
	        		data.harvestLevel = 0;
	        	}       	
	        
	        	//Make Custom Block
	        	CustomBlock block = new CustomBlock(CI_Material.getMaterial(data.material));
	        	
	        	block.setHardness(data.hardness);
	        	block.setResistance(data.resistance);
	        	block.setLightLevel(data.lightLevel);	        	
	        	block.setHarvestLevel(data.toolClass, data.harvestLevel);
	        	block.setBlockTextureName(data.textureName);
	        	
	        	blocksList.add(block);
	        	blocksList.add(data.creativeTab);	        		        	
	        	
	        	//Register Block
	        	GameRegistry.registerBlock(block, registerName);	        	
	        	block.setBlockName(constants.MOD_ID.toLowerCase() + ":" + registerName);	
	        	
	        	LanguageRegistry.instance().addStringLocalization(block.getUnlocalizedName()+".name","en_US", data.name);
	        	
	        	registerId++;
	        }
		}
	}
	
	private static void registerCrops(Cfg_crop[] input) 
	{
        Cfg_crop[] cropsData = input;
        
        int i;
        if(cropsData!=null) 
        {
            LogHelper.info("Registering Crops");
            for(i=0;i<input.length;i++) 
            {	
            	Cfg_crop data = cropsData[i];
            	
            	LogHelper.log(Level.INFO, data.name, 1);
	        	
	        	String registerName = StringUtil.parseRegisterName(data.name);	        	
	        	
                CustomCrop crop = new CustomCrop((Item) Item.itemRegistry.getObject(data.fruitName), data.renderType);
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
                crop.setBlockName(constants.MOD_ID.toLowerCase()+":" + registerName + "_crop");
                LanguageRegistry.instance().addStringLocalization(crop.getUnlocalizedName()+".name","en_US", data.name);

                GameRegistry.registerItem(seed, registerName + "_seed");
                seed.setUnlocalizedName(constants.MOD_ID.toLowerCase()+":" + registerName + "_seed");
                LanguageRegistry.instance().addStringLocalization(seed.getUnlocalizedName()+".name","en_US", data.name + " Seeds");
                
                itemsList.add(seed);
				itemsList.add(data.creativeTab);

                if(cropsData[i].dropFromGrassChance > 0) 
                {
                    MinecraftForge.addGrassSeed(new ItemStack(seed), cropsData[i].dropFromGrassChance);
                }
            }
        }
    }
	
	private static void registerFoods(Cfg_food[] input)
	{
		Cfg_food[] foods = input;
		
		int i;		
		
		if(foods != null)
		{
			LogHelper.log(Level.INFO, "Registering Foods:");
			for(i=0;i<foods.length;i++)
			{
				Cfg_food data = foods[i];
				
				LogHelper.log(Level.INFO, data.name, 1);
				
				String registerName = StringUtil.parseRegisterName(data.name);				
			
				CustomFood food = new CustomFood(data.healAmount, data.saturationModifier, false);
				
				
				if(data.potionEffect != null)
				{	
					food.setPotionEffect(potionEffectId(data.potionEffect.effect), 
							data.potionEffect.potionDuration, 
							data.potionEffect.potionAmplifier, 
							data.potionEffect.potionEffectProbability);
				}
				
				
				itemsList.add(food);
				itemsList.add(data.creativeTab);
				
				
				GameRegistry.registerItem(food, registerName);
				food.setUnlocalizedName(constants.MOD_ID.toLowerCase() + ":"+registerName);
				food.setTextureName(data.textureName);
				LanguageRegistry.instance().addStringLocalization(food.getUnlocalizedName()+".name","en_US", data.name);	
				
				registerId++;
			}
		}
	}
	private static void registerItems(Cfg_item[] input){
		Cfg_item[] items = input;
		
		int i;
		
	
		if(items != null)
		{
			LogHelper.log(Level.INFO, "Registering Items:");
			for(i=0;i<items.length;i++)
			{
				Cfg_item data = items[i];
				
				LogHelper.log(Level.INFO, data.name, 1);
				
				String registerName = StringUtil.parseRegisterName(data.name);
				
				CustomItem item = new CustomItem(data.maxStackSize);
	           
				itemsList.add(item);
				itemsList.add(data.creativeTab);
				
	            GameRegistry.registerItem(item, registerName);
	            item.setUnlocalizedName(constants.MOD_ID.toLowerCase() + ":"+registerName);
	            item.setTextureName(data.textureName);
	            LanguageRegistry.instance().addStringLocalization(item.getUnlocalizedName()+".name","en_US",data.name);
	            
	            registerId++;

			}
		}
	}
	private static void registerFluids(Cfg_fluid[] input){
		Cfg_fluid[] fluids = input;
		int i;
		
		
		
		if(fluids != null)
		{
			LogHelper.log(Level.INFO, "Registering Fluids:");
			for(i=0;i<fluids.length;i++)
			{
				Cfg_fluid data = fluids[i];
				
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
				
				blocksList.add(fluidBlock);
	        	blocksList.add(data.creativeTab);	       
				
				fluidBlock.setBlockName(constants.MOD_ID.toLowerCase()+":"+data.name);
				GameRegistry.registerBlock(fluidBlock, registerName);
				
				
				fluid.setUnlocalizedName(fluidBlock.getUnlocalizedName().substring(fluidBlock.getUnlocalizedName().indexOf(":") + 1));
	            LanguageRegistry.instance().addStringLocalization(fluidBlock.getUnlocalizedName()+".name","en_US", data.name);
	            LanguageRegistry.instance().addStringLocalization(fluid.getUnlocalizedName(),"en_US", data.name);
	            fluid.setBlock(fluidBlock);
	            fluid.setIcons(fluidBlock);
				
				
				CustomBucket bucket = new CustomBucket(fluidBlock);
				
				
				bucket = new CustomBucket(fluidBlock);
				bucket.setUnlocalizedName(constants.MOD_ID.toLowerCase()+":"+data.name+"Bucket");
				bucket.setContainerItem(Items.bucket);
				
				itemsList.add(bucket);
				itemsList.add(data.creativeTab);
				
		        GameRegistry.registerItem(bucket,registerName+"Bucket");
		        
		        FluidContainerRegistry.registerFluidContainer(FluidRegistry.getFluidStack(fluid.getName(),FluidContainerRegistry.BUCKET_VOLUME),new ItemStack(bucket),new ItemStack(Items.bucket));
		        LanguageRegistry.instance().addStringLocalization(bucket.getUnlocalizedName()+".name","en_US",data.name+" Bucket");
		        BucketHandler.INSTANCE.buckets.put(fluidBlock, bucket);
		        MinecraftForge.EVENT_BUS.register(BucketHandler.INSTANCE);
				
		        registerId++;
			}
		}
	}
	private static void registerPickaxes(Cfg_pickaxe[] input)
	{
		Cfg_pickaxe[] pickaxes = input;
		
		int i;
		
		if(pickaxes != null)
		{
			LogHelper.log(Level.INFO, "Registering Pickaxes:");
			for(i=0;i<pickaxes.length;i++)
			{
				Cfg_pickaxe data = pickaxes[i];
				
				LogHelper.log(Level.INFO, data.name, 1);
				
				String registerName = StringUtil.parseRegisterName(data.name);
				
				Item.ToolMaterial material = EnumHelper.addToolMaterial(
						data.textureName, 
						data.harvestLevel, 
						data.maxUses, 
						data.efficiencyOnProperMaterial, 
						data.damageVsEntity, 
						data.enchantability);
				
				CustomPickaxe pickaxe = new CustomPickaxe(material);
				
				itemsList.add(pickaxe);
				itemsList.add(data.creativeTab);
				
				GameRegistry.registerItem(pickaxe, registerName);
				pickaxe.setUnlocalizedName(constants.MOD_ID.toLowerCase()+":"+data.textureName);
	            LanguageRegistry.instance().addStringLocalization(pickaxe.getUnlocalizedName()+".name","en_US",data.name.substring(0, 1).toUpperCase()+data.name.substring(1));
	            
	            registerId++;
			}
		}
	}
	private static void registerAxes(Cfg_axe[] input)
	{
		Cfg_axe[] axes = input;
		
		int i;
		
		if(axes != null)
		{
			LogHelper.log(Level.INFO, "Registering Axes:");
			for(i=0;i<axes.length;i++)
			{
				Cfg_axe data = axes[i];
				
				LogHelper.log(Level.INFO, data.name, 1);
				
				String registerName = StringUtil.parseRegisterName(data.name);
				
				Item.ToolMaterial material = EnumHelper.addToolMaterial(
						data.textureName, 
						data.harvestLevel, 
						data.maxUses, 
						data.efficiencyOnProperMaterial, 
						data.damageVsEntity, 
						data.enchantability);
				
				CustomAxe axe = new CustomAxe(material);
				
				itemsList.add(axe);
				itemsList.add(data.creativeTab);
				
				GameRegistry.registerItem(axe, registerName);
				axe.setUnlocalizedName(constants.MOD_ID.toLowerCase()+":"+data.textureName);
	            LanguageRegistry.instance().addStringLocalization(axe.getUnlocalizedName()+".name","en_US",data.name.substring(0, 1).toUpperCase()+data.name.substring(1));
	            
	            registerId++;
			}
		}
	}
	private static void registerShovels(Cfg_shovel[] input)
	{
		Cfg_shovel[] shovels = input;
		
		int i;
		
		if(shovels != null)
		{
			LogHelper.log(Level.INFO, "Registering Shovels:");		
			for(i=0;i<shovels.length;i++)
			{
				Cfg_shovel data = shovels[i];
				
				LogHelper.log(Level.INFO, data.name, 1);
				
				String registerName = StringUtil.parseRegisterName(data.name);
				
				Item.ToolMaterial material = EnumHelper.addToolMaterial(
						data.textureName, 
						data.harvestLevel, 
						data.maxUses, 
						data.efficiencyOnProperMaterial, 
						data.damageVsEntity, 
						data.enchantability);
				
				CustomShovel shovel = new CustomShovel(material);
				
				itemsList.add(shovel);
				itemsList.add(data.creativeTab);
				
				GameRegistry.registerItem(shovel, registerName);
				shovel.setUnlocalizedName(constants.MOD_ID.toLowerCase()+":"+data.textureName);
	            LanguageRegistry.instance().addStringLocalization(shovel.getUnlocalizedName()+".name","en_US",data.name.substring(0, 1).toUpperCase()+data.name.substring(1));
	            
	            registerId++;
			}
		}
	}
	private static void registerHoes(Cfg_hoe[] input)
	{
		Cfg_hoe[] hoes = input;
		
		int i;
		
		if(hoes != null)
		{
			LogHelper.log(Level.INFO, "Registering Hoes:");
			for(i=0;i<hoes.length;i++)
			{
				Cfg_hoe data = hoes[i];
				
				LogHelper.log(Level.INFO, data.name, 1);
				
				String registerName = StringUtil.parseRegisterName(data.name);
				
				Item.ToolMaterial material = EnumHelper.addToolMaterial(
						data.textureName, 
						data.harvestLevel, 
						data.maxUses, 
						data.efficiencyOnProperMaterial, 
						data.damageVsEntity, 
						data.enchantability);
				
				CustomHoe hoe = new CustomHoe(material);
				
				itemsList.add(hoe);
				itemsList.add(data.creativeTab);
				
				GameRegistry.registerItem(hoe, registerName);
				hoe.setUnlocalizedName(constants.MOD_ID.toLowerCase()+":"+data.textureName);
	            LanguageRegistry.instance().addStringLocalization(hoe.getUnlocalizedName()+".name","en_US",data.name.substring(0, 1).toUpperCase()+data.name.substring(1));
	            
	            registerId++;
			}
		}
	}
	private static void registerSwords(Cfg_sword[] input)
	{
		Cfg_sword[] swords = input;
		
		int i;
		if(swords != null)
		{
			LogHelper.log(Level.INFO, "Registering Swords:");
			for(i=0;i<swords.length;i++)
			{
				Cfg_sword data = swords[i];
				
				LogHelper.log(Level.INFO, data.name, 1);
				
				String registerName = StringUtil.parseRegisterName(data.name);
				
				Item.ToolMaterial material = EnumHelper.addToolMaterial(
						data.textureName, 
						data.harvestLevel, 
						data.maxUses, 
						data.efficiencyOnProperMaterial, 
						data.damageVsEntity, 
						data.enchantability);
				
				CustomSword sword = new CustomSword(material);
				
				itemsList.add(sword);
				itemsList.add(data.creativeTab);
				
				GameRegistry.registerItem(sword, registerName);
				sword.setUnlocalizedName(constants.MOD_ID.toLowerCase()+":"+data.textureName);
	            LanguageRegistry.instance().addStringLocalization(sword.getUnlocalizedName()+".name","en_US",data.name.substring(0, 1).toUpperCase()+data.name.substring(1));
	            
	            registerId++;
			}
		}
	}
	private static void registerHelmets(Cfg_helmet[] input)
	{
		Cfg_helmet[] helmets = input;
		int i;
		
		if(helmets != null)
		{
			LogHelper.log(Level.INFO, "Registering Helmets:");
			for(i=0;i<helmets.length;i++)
			{
				Cfg_helmet data = helmets[i];
				
				LogHelper.log(Level.INFO, data.name, 1);
				
				String registerName = StringUtil.parseRegisterName(data.name);
	        	
	        	
				//Make Custom Armor
	        	int reduction[] = {0,0,0,0};
	        	reduction[0] = data.reductionNum;
	        	
	        	ItemArmor.ArmorMaterial material = EnumHelper.addArmorMaterial(data.textureName, data.durability, reduction, data.enchantability);
	        	CustomArmor armor = new CustomArmor(material, 0, 0, data.textureName);
				//Register Armor
	        	
	        	itemsList.add(armor);
				itemsList.add(data.creativeTab);
	        	
	        	GameRegistry.registerItem(armor, registerName);
	            armor.setUnlocalizedName(constants.MOD_ID.toLowerCase()+":"+data.name);
	            LanguageRegistry.instance().addStringLocalization(armor.getUnlocalizedName()+".name","en_US",data.name.substring(0, 1).toUpperCase()+data.name.substring(1)); 
	            
	            registerId++;
			}
		}
	}
	
	private static void registerChestplates(Cfg_chestplate[] input)
	{
		Cfg_chestplate[] chestplates = input;
		int i;
		
		if(chestplates != null)
		{
			LogHelper.log(Level.INFO, "Registering Chestplates:");
			for(i=0;i<chestplates.length;i++)
			{
				Cfg_chestplate data = chestplates[i];
				
				LogHelper.log(Level.INFO, data.name, 1);
				
				String registerName = StringUtil.parseRegisterName(data.name);
	        	
	        	
				//Make Custom Armor
	        	int reduction[] = {0,0,0,0};
	        	reduction[1] = data.reductionNum;
	        	
	        	ItemArmor.ArmorMaterial material = EnumHelper.addArmorMaterial(data.textureName, data.durability, reduction, data.enchantability);
	        	CustomArmor armor = new CustomArmor(material, 0, 1, data.textureName);
				//Register Armor
	        	
	        	itemsList.add(armor);
				itemsList.add(data.creativeTab);
	        	
	        	GameRegistry.registerItem(armor, registerName);
	            armor.setUnlocalizedName(constants.MOD_ID.toLowerCase()+":"+data.name);
	            LanguageRegistry.instance().addStringLocalization(armor.getUnlocalizedName()+".name","en_US",data.name.substring(0, 1).toUpperCase()+data.name.substring(1)); 
	            
	            registerId++;
			}
		}
	}
	
	
	
	private static void registerLeggings(Cfg_leggings[] input)
	{
		Cfg_leggings[] leggings = input;
		int i;
		
		if(leggings != null)
		{
			LogHelper.log(Level.INFO, "Registering Leggings:");
			for(i=0;i<leggings.length;i++)
			{
				Cfg_leggings data = leggings[i];
				
				LogHelper.log(Level.INFO, data.name, 1);
				
				String registerName = StringUtil.parseRegisterName(data.name);
	        	
	        	
				//Make Custom Armor
	        	int reduction[] = {0,0,0,0};
	        	reduction[2] = data.reductionNum;
	        	
	        	ItemArmor.ArmorMaterial material = EnumHelper.addArmorMaterial(data.textureName, data.durability, reduction, data.enchantability);
	        	CustomArmor armor = new CustomArmor(material, 0, 2, data.textureName);
				//Register Armor
	        	
	        	itemsList.add(armor);
				itemsList.add(data.creativeTab);
	        	
	        	GameRegistry.registerItem(armor, registerName);
	            armor.setUnlocalizedName(constants.MOD_ID.toLowerCase()+":"+data.name);
	            LanguageRegistry.instance().addStringLocalization(armor.getUnlocalizedName()+".name","en_US",data.name.substring(0, 1).toUpperCase()+data.name.substring(1));   
	            
	            registerId++;
			}
		}
	}
	
	private static void registerBoots(Cfg_boots[] input)
	{
		Cfg_boots[] boots = input;
		int i;
		
		if(boots != null)
		{			
			LogHelper.log(Level.INFO, "Registering Boots:");
			for(i=0;i<boots.length;i++)
			{
				Cfg_boots data = boots[i];
				
				LogHelper.log(Level.INFO, data.name, 1);
				
				String registerName = StringUtil.parseRegisterName(data.name);
	        	
	        	
				//Make Custom Armor
	        	int reduction[] = {0,0,0,0};
	        	reduction[3] = data.reductionNum;
	        	
	        	ItemArmor.ArmorMaterial material = EnumHelper.addArmorMaterial(data.textureName, data.durability, reduction, data.enchantability);
	        	CustomArmor armor = new CustomArmor(material, 0, 3, data.textureName);
				//Register Armor
	        	
	        	itemsList.add(armor);
				itemsList.add(data.creativeTab);
	        	
	        	GameRegistry.registerItem(armor, registerName);
	            armor.setUnlocalizedName(constants.MOD_ID.toLowerCase()+":"+data.name);
	            LanguageRegistry.instance().addStringLocalization(armor.getUnlocalizedName()+".name","en_US",data.name.substring(0, 1).toUpperCase()+data.name.substring(1));  
	            
	            registerId++;
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
	//----------------------------------------------------------------------------------------------------------

	
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
