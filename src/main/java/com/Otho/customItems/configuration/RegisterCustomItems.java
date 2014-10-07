package com.Otho.customItems.configuration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

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
import com.Otho.customItems.lib.ModReference;
import com.Otho.customItems.mod.blocks.CustomBlock;
import com.Otho.customItems.mod.blocks.CustomChest;
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

import scala.actors.threadpool.Arrays;

public class RegisterCustomItems {
	
	private static  ArrayList<Object> itemsList = new ArrayList();
	private static  ArrayList<Object> blocksList = new ArrayList();
	
	public static int registerId = -1;
	
	public static void register(JsonSchema data){
		
		ArrayList<Cfg_basicData> allData = new ArrayList<Cfg_basicData>();
		
		if(data.blocks != null)
			allData.addAll(Arrays.asList((Cfg_basicData[]) data.blocks));
		if(data.chests != null)
			allData.addAll(Arrays.asList((Cfg_basicData[]) data.chests));
		if(data.foods != null)
			allData.addAll(Arrays.asList((Cfg_basicData[]) data.foods));
		if(data.items != null)
			allData.addAll(Arrays.asList((Cfg_basicData[]) data.items));
		if(data.fluids != null)
			allData.addAll(Arrays.asList((Cfg_basicData[]) data.fluids));
		if(data.pickaxes != null)
			allData.addAll(Arrays.asList((Cfg_basicData[]) data.pickaxes));
		if(data.axes != null)
			allData.addAll(Arrays.asList((Cfg_basicData[]) data.axes));
		if(data.shovels != null)
			allData.addAll(Arrays.asList((Cfg_basicData[]) data.shovels));
		if(data.hoes != null)
			allData.addAll(Arrays.asList((Cfg_basicData[]) data.hoes));
		if(data.swords != null)
			allData.addAll(Arrays.asList((Cfg_basicData[]) data.swords));
		if(data.helmets != null)
			allData.addAll(Arrays.asList((Cfg_basicData[]) data.helmets));
		if(data.chestplates != null)
			allData.addAll(Arrays.asList((Cfg_basicData[]) data.chestplates));
		if(data.leggings != null)
			allData.addAll(Arrays.asList((Cfg_basicData[]) data.leggings));
		if(data.boots != null)
			allData.addAll(Arrays.asList((Cfg_basicData[]) data.boots));
		if(data.crops != null)
			allData.addAll(Arrays.asList((Cfg_basicData[]) data.crops));
		
		Collections.sort(allData, new Comparator<Cfg_basicData>()
		{
			@Override
			public int compare(Cfg_basicData d1, Cfg_basicData d2)
			{
				return d1.registerOrder - d2.registerOrder;
			}
		});
		
		for(int i = 0; i<allData.size();i++)
		{	
			LogHelper.log(Level.INFO,  allData.get(i).getClass(), 1);
			
			Cfg_basicData toRegister = allData.get(i);
			
			if(toRegister instanceof Cfg_chest)
			{
				registerSingleChest((Cfg_chest) toRegister);	
			}else if(toRegister instanceof Cfg_block)
			{
				registerSingleBlock((Cfg_block) toRegister);
			}else if(toRegister instanceof Cfg_food)
			{
				registerSingleFood((Cfg_food) toRegister);	
			}else if(toRegister instanceof Cfg_item)
			{
				registerSingleItem((Cfg_item) toRegister);	
			}else if(toRegister instanceof Cfg_fluid)
			{
				registerSingleFluid((Cfg_fluid) toRegister);	
			}else if(toRegister instanceof Cfg_pickaxe)
			{
				registerSinglePickaxe((Cfg_pickaxe) toRegister);	
			}else if(toRegister instanceof Cfg_axe)
			{
				registerSingleAxe((Cfg_axe) toRegister);	
			}else if(toRegister instanceof Cfg_shovel)
			{
				registerSingleShovel((Cfg_shovel) toRegister);	
			}else if(toRegister instanceof Cfg_hoe)
			{
				registerSingleHoe((Cfg_hoe) toRegister);	
			}else if(toRegister instanceof Cfg_sword)
			{
				registerSingleSword((Cfg_sword) toRegister);	
			}else if(toRegister instanceof Cfg_helmet)
			{
				registerSingleHelmet((Cfg_helmet) toRegister);	
			}else if(toRegister instanceof Cfg_chestplate)
			{
				registerSingleChestplate((Cfg_chestplate) toRegister);	
			}else if(toRegister instanceof Cfg_leggings)
			{
				registerSingleLeggings((Cfg_leggings) toRegister);	
			}else if(toRegister instanceof Cfg_boots)
			{
				registerSingleBoots((Cfg_boots) toRegister);	
			}else if(toRegister instanceof Cfg_crop)
			{
				registerSingleCrop((Cfg_crop) toRegister);
			}
			
		}
		
//		for(int i=0;i<3000;i++)
//		{
//			Cfg_block blocker = new Cfg_block();
//			blocker.name = "BlockNum" + i;
//			blocker.textureName = "none";
//			registerSingleBlock(blocker);
//		}
		
		registerTabs(data.creativeTabs);
		
		setCreativeTabs();		
	}
	
	private static void registerTabs(Cfg_creativeTab[] tabs)
	{
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
	
	private static void setCreativeTabs()
	{
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
	
	private static void registerBlocks (Cfg_block[] blocksData)
	{
		int i;

		if(blocksData != null)
		{
			LogHelper.log(Level.INFO, "Registering blocksData");
			for(i=0;i<blocksData.length;i++)
			{
				registerSingleBlock(blocksData[i]);
			}
		}	
	}
	
	private static void registerCrops(Cfg_crop[] cropsData) 
	{
		int i;

		if(cropsData != null)
		{
			LogHelper.log(Level.INFO, "Registering cropsData");
			for(i=0;i<cropsData.length;i++)
			{
				registerSingleCrop(cropsData[i]);
			}
		}	
	}
	private static void registerFoods(Cfg_food[] foods)
	{
		int i;

		if(foods != null)
		{
			LogHelper.log(Level.INFO, "Registering foods");
			for(i=0;i<foods.length;i++)
			{
				registerSingleFood(foods[i]);
			}
		}	
	}
	private static void registerItems(Cfg_item[] items)
	{
		int i;

		if(items != null)
		{
			LogHelper.log(Level.INFO, "Registering items");
			for(i=0;i<items.length;i++)
			{
				registerSingleItem(items[i]);
			}
		}	
	}
	private static void registerFluids(Cfg_fluid[] fluids)
	{
		int i;

		if(fluids != null)
		{
			LogHelper.log(Level.INFO, "Registering fluids");
			for(i=0;i<fluids.length;i++)
			{
				registerSingleFluid(fluids[i]);
			}
		}	
	}
	private static void registerPickaxes(Cfg_pickaxe[] pickaxes)
	{
		int i;

		if(pickaxes != null)
		{
			LogHelper.log(Level.INFO, "Registering pickaxes");
			for(i=0;i<pickaxes.length;i++)
			{
				registerSinglePickaxe(pickaxes[i]);
			}
		}	
	}
	private static void registerAxes(Cfg_axe[] axes)
	{
		int i;

		if(axes != null)
		{
			LogHelper.log(Level.INFO, "Registering axes");
			for(i=0;i<axes.length;i++)
			{
				registerSingleAxe(axes[i]);
			}
		}	
	}
	private static void registerShovels(Cfg_shovel[] shovels)
	{
		int i;

		if(shovels != null)
		{
			LogHelper.log(Level.INFO, "Registering shovels");
			for(i=0;i<shovels.length;i++)
			{
				registerSingleShovel(shovels[i]);
			}
		}	
	}
	private static void registerHoes(Cfg_hoe[] hoes)
	{
		int i;

		if(hoes != null)
		{
			LogHelper.log(Level.INFO, "Registering hoes");
			for(i=0;i<hoes.length;i++)
			{
				registerSingleHoe(hoes[i]);
			}
		}	
	}
	private static void registerSwords(Cfg_sword[] swords)
	{
		int i;

		if(swords != null)
		{
			LogHelper.log(Level.INFO, "Registering swords");
			for(i=0;i<swords.length;i++)
			{
				registerSingleSword(swords[i]);
			}
		}	
	}
	private static void registerHelmets(Cfg_helmet[] helmets)
	{
		int i;

		if(helmets != null)
		{
			LogHelper.log(Level.INFO, "Registering helmets");
			for(i=0;i<helmets.length;i++)
			{
				registerSingleHelmet(helmets[i]);
			}
		}	
	}
	private static void registerChestplates(Cfg_chestplate[] chestplates)
	{
		int i;

		if(chestplates != null)
		{
			LogHelper.log(Level.INFO, "Registering chestplates");
			for(i=0;i<chestplates.length;i++)
			{
				registerSingleChestplate(chestplates[i]);
			}
		}	
	}
	private static void registerLeggings(Cfg_leggings[] leggings)
	{
		int i;

		if(leggings != null)
		{
			LogHelper.log(Level.INFO, "Registering leggings");
			for(i=0;i<leggings.length;i++)
			{
				registerSingleLeggings(leggings[i]);
			}
		}	
	}
	private static void registerBoots(Cfg_boots[] boots)
	{
		int i;

		if(boots != null)
		{
			LogHelper.log(Level.INFO, "Registering boots");
			for(i=0;i<boots.length;i++)
			{
				registerSingleBoots(boots[i]);
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
	
	private static void registerSingleBlock (Cfg_block blockData)
	{        	
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
		block.setBlockTextureName(blockData.textureName);
		
		blocksList.add(block);
		blocksList.add(blockData.creativeTab);	        		        	
		
		//Register Block
		GameRegistry.registerBlock(block, registerName);	        	
		block.setBlockName(ModReference.MOD_ID.toLowerCase() + ":" + registerName);	
		
		LanguageRegistry.instance().addStringLocalization(block.getUnlocalizedName()+".name","en_US", blockData.name);
	}
	
	private static void registerSingleChest (Cfg_chest blockData)
	{        	
		LogHelper.log(Level.INFO, blockData.name, 1);
		
		String registerName = StringUtil.parseRegisterName(blockData.name);
		
		blockData.toolClass = validateToolClass(blockData.toolClass);
		if(!blockData.toolClass.equals("pickaxe"))
		{
			blockData.harvestLevel = 0;
		}       	

		//Make Custom Block
		CustomChest block = new CustomChest(CI_Material.getMaterial(blockData.material), blockData.invWidth, blockData.invHeight, blockData.invName);
		
		block.setHardness(blockData.hardness);
		block.setResistance(blockData.resistance);
		block.setLightLevel(blockData.lightLevel);	        	
		block.setHarvestLevel(blockData.toolClass, blockData.harvestLevel);
		block.setBlockTextureName(blockData.textureName);
		
		//Chest Stuff		
		block.setHasOwner(blockData.hasOwner);
		
		blocksList.add(block);
		blocksList.add(blockData.creativeTab);	        		        	
		
		//Register Block
		GameRegistry.registerBlock(block, registerName);	        	
		block.setBlockName(ModReference.MOD_ID.toLowerCase() + ":" + registerName);	
		
		LanguageRegistry.instance().addStringLocalization(block.getUnlocalizedName()+".name","en_US", blockData.name);
	}
	
	private static void registerSingleCrop(Cfg_crop cropData) 
	{        	
		LogHelper.log(Level.INFO, cropData.name, 1);
		
		String registerName = StringUtil.parseRegisterName(cropData.name);	        	
		
	    CustomCrop crop = new CustomCrop((Item) Item.itemRegistry.getObject(cropData.fruitName), cropData.renderType);
	    CustomSeed seed = new CustomSeed(crop);
	    crop.setSeed(seed);
	    
	    crop.setAcceptBoneMeal(cropData.acceptBoneMeal);
	    crop.setDropSeedWhenMature(cropData.dropSeedWhenMature);
	    crop.setEachExtraFruitDropChance(cropData.eachExtraFruitDropChance);
	    crop.setEachExtraSeedDropChance(cropData.eachExtraSeedDropChance);
	    crop.setFruitQuantityDropRange(cropData.minFruitDrop, cropData.maxFruitDrop);
	    crop.setSeedQuantityDropRange(cropData.minSeedDrop, cropData.maxSeedDrop);
	    
	    crop.setBlockTextureName(cropData.textureName);
	    
	    seed.setTextureName(cropData.textureName+"_seed");
	    
	    GameRegistry.registerBlock(crop, registerName + "_crop");
	    crop.setBlockName(ModReference.MOD_ID.toLowerCase()+":" + registerName + "_crop");
	    LanguageRegistry.instance().addStringLocalization(crop.getUnlocalizedName()+".name","en_US", cropData.name);

	    GameRegistry.registerItem(seed, registerName + "_seed");
	    seed.setUnlocalizedName(ModReference.MOD_ID.toLowerCase()+":" + registerName + "_seed");
	    LanguageRegistry.instance().addStringLocalization(seed.getUnlocalizedName()+".name","en_US", cropData.name + " Seeds");
	    
	    itemsList.add(seed);
		itemsList.add(cropData.creativeTab);

	    if(cropData.dropFromGrassChance > 0) 
	    {
	        MinecraftForge.addGrassSeed(new ItemStack(seed), cropData.dropFromGrassChance);
	    }
	}
	private static void registerSingleFood(Cfg_food foodData)
	{
		LogHelper.log(Level.INFO, foodData.name, 1);
		
		String registerName = StringUtil.parseRegisterName(foodData.name);				

		CustomFood food = new CustomFood(foodData.healAmount, foodData.saturationModifier, false);
		
		if(foodData.alwaysEdible)
			food.setAlwaysEdible();
		
		if(foodData.potionEffect != null)
		{	
			food.setPotionEffect(potionEffectId(foodData.potionEffect.effect), 
					foodData.potionEffect.potionDuration, 
					foodData.potionEffect.potionAmplifier, 
					foodData.potionEffect.potionEffectProbability);
		}
		
		
		itemsList.add(food);
		itemsList.add(foodData.creativeTab);
		
		
		GameRegistry.registerItem(food, registerName);
		food.setUnlocalizedName(ModReference.MOD_ID.toLowerCase() + ":"+registerName);
		food.setTextureName(foodData.textureName);
		LanguageRegistry.instance().addStringLocalization(food.getUnlocalizedName()+".name","en_US", foodData.name);	
	}
	private static void registerSingleItem(Cfg_item itemData)
	{					
		LogHelper.log(Level.INFO, itemData.name, 1);
		
		String registerName = StringUtil.parseRegisterName(itemData.name);
		
		CustomItem item = new CustomItem(itemData.maxStackSize);
	   
		itemsList.add(item);
		itemsList.add(itemData.creativeTab);
		
	    GameRegistry.registerItem(item, registerName);
	    item.setUnlocalizedName(ModReference.MOD_ID.toLowerCase() + ":"+registerName);
	    item.setTextureName(itemData.textureName);
	    LanguageRegistry.instance().addStringLocalization(item.getUnlocalizedName()+".name","en_US",itemData.name);
	}
	private static void registerSingleFluid(Cfg_fluid fluidData)
	{
		LogHelper.log(Level.INFO, fluidData.name, 1);
					
		String registerName = StringUtil.parseRegisterName(fluidData.name);
		
						
		CustomFluid fluid = new CustomFluid(fluidData.name);
		
		fluid.setLuminosity(fluidData.luminosity);
		fluid.setDensity(fluidData.density);
		fluid.setTemperature(fluidData.temperature);
		fluid.setViscosity(fluidData.viscosity);
		fluid.setGaseous(fluidData.isGas);
		FluidRegistry.registerFluid(fluid);
		
		CustomFluidBlock fluidBlock = new CustomFluidBlock(fluid, Material.water);
		
		blocksList.add(fluidBlock);
		blocksList.add(fluidData.creativeTab);	       
		
		fluidBlock.setBlockName(ModReference.MOD_ID.toLowerCase()+":"+fluidData.name);
		GameRegistry.registerBlock(fluidBlock, registerName);
		
		
		fluid.setUnlocalizedName(fluidBlock.getUnlocalizedName().substring(fluidBlock.getUnlocalizedName().indexOf(":") + 1));
	    LanguageRegistry.instance().addStringLocalization(fluidBlock.getUnlocalizedName()+".name","en_US", fluidData.name);
	    LanguageRegistry.instance().addStringLocalization(fluid.getUnlocalizedName(),"en_US", fluidData.name);
	    fluid.setBlock(fluidBlock);
	    fluid.setIcons(fluidBlock);
		
		
		CustomBucket bucket = new CustomBucket(fluidBlock);
		
		
		bucket = new CustomBucket(fluidBlock);
		bucket.setUnlocalizedName(ModReference.MOD_ID.toLowerCase()+":"+fluidData.name+"Bucket");
		bucket.setContainerItem(Items.bucket);
		
		itemsList.add(bucket);
		itemsList.add(fluidData.creativeTab);
		
	    GameRegistry.registerItem(bucket,registerName+"Bucket");
	    
	    FluidContainerRegistry.registerFluidContainer(FluidRegistry.getFluidStack(fluid.getName(),FluidContainerRegistry.BUCKET_VOLUME),new ItemStack(bucket),new ItemStack(Items.bucket));
	    LanguageRegistry.instance().addStringLocalization(bucket.getUnlocalizedName()+".name","en_US",fluidData.name+" Bucket");
	    BucketHandler.INSTANCE.buckets.put(fluidBlock, bucket);
	    MinecraftForge.EVENT_BUS.register(BucketHandler.INSTANCE);
	}
	private static void registerSinglePickaxe(Cfg_pickaxe pickaxeData)
	{
		LogHelper.log(Level.INFO, pickaxeData.name, 1);
					
		String registerName = StringUtil.parseRegisterName(pickaxeData.name);
		
		Item.ToolMaterial material = EnumHelper.addToolMaterial(
				pickaxeData.textureName, 
				pickaxeData.harvestLevel, 
				pickaxeData.maxUses, 
				pickaxeData.efficiencyOnProperMaterial, 
				pickaxeData.damageVsEntity, 
				pickaxeData.enchantability);
		
		CustomPickaxe pickaxe = new CustomPickaxe(material);
		
		itemsList.add(pickaxe);
		itemsList.add(pickaxeData.creativeTab);
		
		GameRegistry.registerItem(pickaxe, registerName);
		pickaxe.setUnlocalizedName(ModReference.MOD_ID.toLowerCase()+":"+pickaxeData.textureName);
	    LanguageRegistry.instance().addStringLocalization(pickaxe.getUnlocalizedName()+".name","en_US",pickaxeData.name.substring(0, 1).toUpperCase()+pickaxeData.name.substring(1));
	}
	private static void registerSingleAxe(Cfg_axe axeData)
	{
		LogHelper.log(Level.INFO, axeData.name, 1);
					
		String registerName = StringUtil.parseRegisterName(axeData.name);
		
		Item.ToolMaterial material = EnumHelper.addToolMaterial(
				axeData.textureName, 
				axeData.harvestLevel, 
				axeData.maxUses, 
				axeData.efficiencyOnProperMaterial, 
				axeData.damageVsEntity, 
				axeData.enchantability);
		
		CustomAxe axe = new CustomAxe(material);
		
		itemsList.add(axe);
		itemsList.add(axeData.creativeTab);
		
		GameRegistry.registerItem(axe, registerName);
		axe.setUnlocalizedName(ModReference.MOD_ID.toLowerCase()+":"+axeData.textureName);
	    LanguageRegistry.instance().addStringLocalization(axe.getUnlocalizedName()+".name","en_US",axeData.name.substring(0, 1).toUpperCase()+axeData.name.substring(1));
	}
	private static void registerSingleShovel(Cfg_shovel shovelData)
	{
		LogHelper.log(Level.INFO, shovelData.name, 1);
					
		String registerName = StringUtil.parseRegisterName(shovelData.name);
		
		Item.ToolMaterial material = EnumHelper.addToolMaterial(
				shovelData.textureName, 
				shovelData.harvestLevel, 
				shovelData.maxUses, 
				shovelData.efficiencyOnProperMaterial, 
				shovelData.damageVsEntity, 
				shovelData.enchantability);
		
		CustomShovel shovel = new CustomShovel(material);
		
		itemsList.add(shovel);
		itemsList.add(shovelData.creativeTab);
		
		GameRegistry.registerItem(shovel, registerName);
		shovel.setUnlocalizedName(ModReference.MOD_ID.toLowerCase()+":"+shovelData.textureName);
	    LanguageRegistry.instance().addStringLocalization(shovel.getUnlocalizedName()+".name","en_US",shovelData.name.substring(0, 1).toUpperCase()+shovelData.name.substring(1));
	}
	private static void registerSingleHoe(Cfg_hoe hoeData)
	{
		LogHelper.log(Level.INFO, hoeData.name, 1);
					
		String registerName = StringUtil.parseRegisterName(hoeData.name);
		
		Item.ToolMaterial material = EnumHelper.addToolMaterial(
				hoeData.textureName, 
				hoeData.harvestLevel, 
				hoeData.maxUses, 
				hoeData.efficiencyOnProperMaterial, 
				hoeData.damageVsEntity, 
				hoeData.enchantability);
		
		CustomHoe hoe = new CustomHoe(material);
		
		itemsList.add(hoe);
		itemsList.add(hoeData.creativeTab);
		
		GameRegistry.registerItem(hoe, registerName);
		hoe.setUnlocalizedName(ModReference.MOD_ID.toLowerCase()+":"+hoeData.textureName);
	    LanguageRegistry.instance().addStringLocalization(hoe.getUnlocalizedName()+".name","en_US",hoeData.name.substring(0, 1).toUpperCase()+hoeData.name.substring(1));
	}
	private static void registerSingleSword(Cfg_sword swordData)
	{
		LogHelper.log(Level.INFO, swordData.name, 1);
					
		String registerName = StringUtil.parseRegisterName(swordData.name);
		
		Item.ToolMaterial material = EnumHelper.addToolMaterial(
				swordData.textureName, 
				swordData.harvestLevel, 
				swordData.maxUses, 
				swordData.efficiencyOnProperMaterial, 
				swordData.damageVsEntity, 
				swordData.enchantability);
		
		CustomSword sword = new CustomSword(material);
		
		itemsList.add(sword);
		itemsList.add(swordData.creativeTab);
		
		GameRegistry.registerItem(sword, registerName);
		sword.setUnlocalizedName(ModReference.MOD_ID.toLowerCase()+":"+swordData.textureName);
	    LanguageRegistry.instance().addStringLocalization(sword.getUnlocalizedName()+".name","en_US",swordData.name.substring(0, 1).toUpperCase()+swordData.name.substring(1));
	}
	private static void registerSingleHelmet(Cfg_helmet helmetData)
	{
		LogHelper.log(Level.INFO, helmetData.name, 1);
					
		String registerName = StringUtil.parseRegisterName(helmetData.name);
		
		
		//Make Custom Armor
		int reduction[] = {0,0,0,0};
		reduction[0] = helmetData.reductionNum;
		
		ItemArmor.ArmorMaterial material = EnumHelper.addArmorMaterial(helmetData.textureName, helmetData.durability, reduction, helmetData.enchantability);
		CustomArmor armor = new CustomArmor(material, 0, 0, helmetData.textureName);
		//Register Armor
		
		itemsList.add(armor);
		itemsList.add(helmetData.creativeTab);
		
		GameRegistry.registerItem(armor, registerName);
	    armor.setUnlocalizedName(ModReference.MOD_ID.toLowerCase()+":"+helmetData.name);
	    LanguageRegistry.instance().addStringLocalization(armor.getUnlocalizedName()+".name","en_US",helmetData.name.substring(0, 1).toUpperCase()+helmetData.name.substring(1));
	}
	private static void registerSingleChestplate(Cfg_chestplate chestplateData)
	{
		LogHelper.log(Level.INFO, chestplateData.name, 1);
					
		String registerName = StringUtil.parseRegisterName(chestplateData.name);
		
		
		//Make Custom Armor
		int reduction[] = {0,0,0,0};
		reduction[1] = chestplateData.reductionNum;
		
		ItemArmor.ArmorMaterial material = EnumHelper.addArmorMaterial(chestplateData.textureName, chestplateData.durability, reduction, chestplateData.enchantability);
		CustomArmor armor = new CustomArmor(material, 0, 1, chestplateData.textureName);
		//Register Armor
		
		itemsList.add(armor);
		itemsList.add(chestplateData.creativeTab);
		
		GameRegistry.registerItem(armor, registerName);
	    armor.setUnlocalizedName(ModReference.MOD_ID.toLowerCase()+":"+chestplateData.name);
	    LanguageRegistry.instance().addStringLocalization(armor.getUnlocalizedName()+".name","en_US",chestplateData.name.substring(0, 1).toUpperCase()+chestplateData.name.substring(1));
	}
	private static void registerSingleLeggings(Cfg_leggings leggingData)
	{
		LogHelper.log(Level.INFO, leggingData.name, 1);
					
		String registerName = StringUtil.parseRegisterName(leggingData.name);
		
		//Make Custom Armor
		int reduction[] = {0,0,0,0};
		reduction[2] = leggingData.reductionNum;
		
		ItemArmor.ArmorMaterial material = EnumHelper.addArmorMaterial(leggingData.textureName, leggingData.durability, reduction, leggingData.enchantability);
		CustomArmor armor = new CustomArmor(material, 0, 2, leggingData.textureName);
		//Register Armor
		
		itemsList.add(armor);
		itemsList.add(leggingData.creativeTab);
		
		GameRegistry.registerItem(armor, registerName);
	    armor.setUnlocalizedName(ModReference.MOD_ID.toLowerCase()+":"+leggingData.name);
	    LanguageRegistry.instance().addStringLocalization(armor.getUnlocalizedName()+".name","en_US",leggingData.name.substring(0, 1).toUpperCase()+leggingData.name.substring(1));
	}
	private static void registerSingleBoots(Cfg_boots bootsData)
	{
		LogHelper.log(Level.INFO, bootsData.name, 1);
					
		String registerName = StringUtil.parseRegisterName(bootsData.name);
		
		
		//Make Custom Armor
		int reduction[] = {0,0,0,0};
		reduction[3] = bootsData.reductionNum;
		
		ItemArmor.ArmorMaterial material = EnumHelper.addArmorMaterial(bootsData.textureName, bootsData.durability, reduction, bootsData.enchantability);
		CustomArmor armor = new CustomArmor(material, 0, 3, bootsData.textureName);
		//Register Armor
		
		itemsList.add(armor);
		itemsList.add(bootsData.creativeTab);
		
		GameRegistry.registerItem(armor, registerName);
	    armor.setUnlocalizedName(ModReference.MOD_ID.toLowerCase()+":"+bootsData.name);
	    LanguageRegistry.instance().addStringLocalization(armor.getUnlocalizedName()+".name","en_US",bootsData.name.substring(0, 1).toUpperCase()+bootsData.name.substring(1));
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
