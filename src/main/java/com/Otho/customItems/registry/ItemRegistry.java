package com.Otho.customItems.registry;

import org.apache.logging.log4j.Level;

import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraftforge.common.util.EnumHelper;

import com.Otho.customItems.ModReference;
import com.Otho.customItems.configuration.jsonReaders.items.Cfg_item;
import com.Otho.customItems.configuration.jsonReaders.items.armor.Cfg_boots;
import com.Otho.customItems.configuration.jsonReaders.items.armor.Cfg_chestplate;
import com.Otho.customItems.configuration.jsonReaders.items.armor.Cfg_helmet;
import com.Otho.customItems.configuration.jsonReaders.items.armor.Cfg_leggings;
import com.Otho.customItems.configuration.jsonReaders.items.food.Cfg_food;
import com.Otho.customItems.configuration.jsonReaders.items.tools.Cfg_axe;
import com.Otho.customItems.configuration.jsonReaders.items.tools.Cfg_hoe;
import com.Otho.customItems.configuration.jsonReaders.items.tools.Cfg_pickaxe;
import com.Otho.customItems.configuration.jsonReaders.items.tools.Cfg_shovel;
import com.Otho.customItems.configuration.jsonReaders.items.tools.Cfg_sword;
import com.Otho.customItems.configuration.jsonReaders.tileEntity.Cfg_chest;
import com.Otho.customItems.mod.items.CustomItem;
import com.Otho.customItems.mod.items.armor.CustomArmor;
import com.Otho.customItems.mod.items.food.CustomFood;
import com.Otho.customItems.mod.items.tools.CustomAxe;
import com.Otho.customItems.mod.items.tools.CustomHoe;
import com.Otho.customItems.mod.items.tools.CustomPickaxe;
import com.Otho.customItems.mod.items.tools.CustomShovel;
import com.Otho.customItems.mod.items.tools.CustomSword;
import com.Otho.customItems.util.LogHelper;
import com.Otho.customItems.util.StringUtil;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class ItemRegistry {

    public static boolean registerAxe(Cfg_axe data){
        
        LogHelper.info(data.name, 1);
        
        String registerName = StringUtil.parseRegisterName(data.name);
        
        Item.ToolMaterial material = EnumHelper.addToolMaterial(
                data.textureName, 
                data.harvestLevel, 
                data.maxUses, 
                data.efficiencyOnProperMaterial, 
                data.damageVsEntity, 
                data.enchantability);
        
        CustomAxe axe = new CustomAxe(material);
        
        Registry.itemsList.add(axe);
        Registry.itemsList.add(data.creativeTab);
        
        GameRegistry.registerItem(axe, registerName);
        axe.setUnlocalizedName(Registry.mod_id.toLowerCase()+":"+data.textureName);
        LanguageRegistry.instance().addStringLocalization(axe.getUnlocalizedName()+".name","en_US",data.name.substring(0, 1).toUpperCase()+data.name.substring(1));
        
        return true;
    }

    public static boolean registerAxe(Cfg_axe[] data){
        int i;

        for(i=0;i<data.length;i++){
            boolean registered = registerAxe(data[i]);

            if(!registered){
                LogHelper.error("Failed to register: Axe " + i);
                return false;
            }
        }

        return true;
    }

    public static boolean registerBoots(Cfg_boots data){
    	LogHelper.log(Level.INFO, data.name, 1);
		
		String registerName = StringUtil.parseRegisterName(data.name);
		
		
		//Make Custom Armor
		int reduction[] = {0,0,0,0};
		reduction[3] = data.reductionNum;
		
		ItemArmor.ArmorMaterial material = EnumHelper.addArmorMaterial(data.textureName, data.durability, reduction, data.enchantability);
		CustomArmor armor = new CustomArmor(material, 0, 3, data.textureName, data.durability);				
		//Register Armor
		
		Registry.itemsList.add(armor);
		Registry.itemsList.add(data.creativeTab);
		
		GameRegistry.registerItem(armor, registerName);
	    armor.setUnlocalizedName(Registry.mod_id.toLowerCase()+":"+data.name);
	    LanguageRegistry.instance().addStringLocalization(armor.getUnlocalizedName()+".name","en_US",data.name.substring(0, 1).toUpperCase()+data.name.substring(1));
    	return false;
    }

    public static boolean registerBoots(Cfg_boots[] data){
        int i;

        for(i=0;i<data.length;i++){
            boolean registered = registerBoots(data[i]);

            if(!registered){
                LogHelper.error("Failed to register: Boots " + i);
                return false;
            }
        }

        return true;
    }
 
    public static boolean registerChestplate(Cfg_chestplate data){
    	LogHelper.log(Level.INFO, data.name, 1);
		
		String registerName = StringUtil.parseRegisterName(data.name);
		
		
		//Make Custom Armor
		int reduction[] = {0,0,0,0};
		reduction[1] = data.reductionNum;
		
		ItemArmor.ArmorMaterial material = EnumHelper.addArmorMaterial(data.textureName, data.durability, reduction, data.enchantability);
		CustomArmor armor = new CustomArmor(material, 0, 1, data.textureName, data.durability);
		//Register Armor
		
		Registry.itemsList.add(armor);
		Registry.itemsList.add(data.creativeTab);
		
		GameRegistry.registerItem(armor, registerName);
	    armor.setUnlocalizedName(Registry.mod_id.toLowerCase()+":"+data.name);
	    LanguageRegistry.instance().addStringLocalization(armor.getUnlocalizedName()+".name","en_US",data.name.substring(0, 1).toUpperCase()+data.name.substring(1));
    	
    	return false;
    }

    public static boolean registerChestplate(Cfg_chestplate[] data){
        int i;

        for(i=0;i<data.length;i++){
            boolean registered = registerChestplate(data[i]);

            if(!registered){
                LogHelper.error("Failed to register: Chestplate " + i);
                return false;
            }
        }

        return true;
    }

    public static boolean registerFood(Cfg_food data){
    	LogHelper.log(Level.INFO, data.name, 1);
		
		String registerName = StringUtil.parseRegisterName(data.name);				

		CustomFood food = new CustomFood(data.healAmount, data.saturationModifier, data.isWolfFood);
		
		if(data.alwaysEdible)
			food.setAlwaysEdible();
		
		if(data.potionEffects != null){
			if(data.potionEffects.length > 0)
			{	
				food.setFoodEffectsArray(data.potionEffects);
			}
		}
		
		
		Registry.itemsList.add(food);
		Registry.itemsList.add(data.creativeTab);
		
		
		GameRegistry.registerItem(food, registerName);
		food.setUnlocalizedName(Registry.mod_id.toLowerCase() + ":"+registerName);
		food.setTextureName(data.textureName);
		LanguageRegistry.instance().addStringLocalization(food.getUnlocalizedName()+".name","en_US", data.name);
    	
        return false;
    }

    public static boolean registerFood(Cfg_food[] data){
        int i;

        for(i=0;i<data.length;i++){
            boolean registered = registerFood(data[i]);

            if(!registered){
                LogHelper.error("Failed to register: Food " + i);
                return false;
            }
        }

        return true;
    }

    public static boolean registerHelmet(Cfg_helmet data){
    	LogHelper.log(Level.INFO, data.name, 1);
		
		String registerName = StringUtil.parseRegisterName(data.name);
		
		
		//Make Custom Armor
		int reduction[] = {0,0,0,0};
		reduction[0] = data.reductionNum;
		
		ItemArmor.ArmorMaterial material = EnumHelper.addArmorMaterial(data.textureName, data.durability, reduction, data.enchantability);
		CustomArmor armor = new CustomArmor(material, 0, 0, data.textureName, data.durability);
		//Register Armor
		
		Registry.itemsList.add(armor);
		Registry.itemsList.add(data.creativeTab);
		
		GameRegistry.registerItem(armor, registerName);
	    armor.setUnlocalizedName(Registry.mod_id.toLowerCase()+":"+data.name);
	    LanguageRegistry.instance().addStringLocalization(armor.getUnlocalizedName()+".name","en_US",data.name.substring(0, 1).toUpperCase()+data.name.substring(1));
    	
    	return false;
    }

    public static boolean registerHelmet(Cfg_helmet[] data){
        int i;

        for(i=0;i<data.length;i++){
            boolean registered = registerHelmet(data[i]);

            if(!registered){
                LogHelper.error("Failed to register: Helmet " + i);
                return false;
            }
        }

        return true;
    }

    public static boolean registerHoe(Cfg_hoe data){
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
		
		Registry.itemsList.add(hoe);
		Registry.itemsList.add(data.creativeTab);
		
		GameRegistry.registerItem(hoe, registerName);
		hoe.setUnlocalizedName(Registry.mod_id.toLowerCase()+":"+data.textureName);
	    LanguageRegistry.instance().addStringLocalization(hoe.getUnlocalizedName()+".name","en_US",data.name.substring(0, 1).toUpperCase()+data.name.substring(1));
        
	    return true;
    }

    public static boolean registerHoe(Cfg_hoe[] data){
        int i;

        for(i=0;i<data.length;i++){
            boolean registered = registerHoe(data[i]);

            if(!registered){
                LogHelper.error("Failed to register: Hoe " + i);
                return false;
            }
        }

        return true;
    }

    public static boolean registerItem(Cfg_item data){
    	LogHelper.log(Level.INFO, data.name, 1);
		
		String registerName = StringUtil.parseRegisterName(data.name);
		
		CustomItem item = new CustomItem(data.maxStackSize);
	   
		Registry.itemsList.add(item);
		Registry.itemsList.add(data.creativeTab);
		
	    GameRegistry.registerItem(item, registerName);
	    item.setUnlocalizedName(Registry.mod_id.toLowerCase() + ":"+registerName);
	    item.setTextureName(data.textureName);
	    LanguageRegistry.instance().addStringLocalization(item.getUnlocalizedName()+".name","en_US",data.name);
    	
        return false;
    }

    public static boolean registerItem(Cfg_item[] data){
        int i;

        for(i=0;i<data.length;i++){
            boolean registered = registerItem(data[i]);

            if(!registered){
                LogHelper.error("Failed to register: Item " + i);
                return false;
            }
        }

        return true;
    }

    public static boolean registerLeggings(Cfg_leggings data){
    	LogHelper.log(Level.INFO, data.name, 1);
		
		String registerName = StringUtil.parseRegisterName(data.name);
		
		//Make Custom Armor
		int reduction[] = {0,0,0,0};
		reduction[2] = data.reductionNum;
		
		ItemArmor.ArmorMaterial material = EnumHelper.addArmorMaterial(data.textureName, data.durability, reduction, data.enchantability);
		CustomArmor armor = new CustomArmor(material, 0, 2, data.textureName, data.durability);
		//Register Armor
		
		Registry.itemsList.add(armor);
		Registry.itemsList.add(data.creativeTab);
		
		GameRegistry.registerItem(armor, registerName);
	    armor.setUnlocalizedName(Registry.mod_id.toLowerCase()+":"+data.name);
	    LanguageRegistry.instance().addStringLocalization(armor.getUnlocalizedName()+".name","en_US",data.name.substring(0, 1).toUpperCase()+data.name.substring(1));
	    
	    return true;
    }

    public static boolean registerLeggings(Cfg_leggings[] data){
        int i;

        for(i=0;i<data.length;i++){
            boolean registered = registerLeggings(data[i]);

            if(!registered){
                LogHelper.error("Failed to register: Leggings " + i);
                return false;
            }
        }

        return true;
    }

    public static boolean registerPickaxe(Cfg_pickaxe data){
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
		
		Registry.itemsList.add(pickaxe);
		Registry.itemsList.add(data.creativeTab);
		
		GameRegistry.registerItem(pickaxe, registerName);
		pickaxe.setUnlocalizedName(Registry.mod_id.toLowerCase()+":"+data.textureName);
	    LanguageRegistry.instance().addStringLocalization(pickaxe.getUnlocalizedName()+".name","en_US",data.name.substring(0, 1).toUpperCase()+data.name.substring(1));
	    
	    return true;
	}

    public static boolean registerPickaxe(Cfg_pickaxe[] data){
        int i;

        for(i=0;i<data.length;i++){
            boolean registered = registerPickaxe(data[i]);

            if(!registered){
                LogHelper.error("Failed to register: Pickaxe " + i);
                return false;
            }
        }

        return true;
    }

    public static boolean registerShovel(Cfg_shovel data){
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
		
		Registry.itemsList.add(shovel);
		Registry.itemsList.add(data.creativeTab);
		
		GameRegistry.registerItem(shovel, registerName);
		shovel.setUnlocalizedName(Registry.mod_id.toLowerCase()+":"+data.textureName);
	    LanguageRegistry.instance().addStringLocalization(shovel.getUnlocalizedName()+".name","en_US",data.name.substring(0, 1).toUpperCase()+data.name.substring(1));
	    
	    return true;
	}

    public static boolean registerShovel(Cfg_shovel[] data){
        int i;

        for(i=0;i<data.length;i++){
            boolean registered = registerShovel(data[i]);

            if(!registered){
                LogHelper.error("Failed to register: Shovel " + i);
                return false;
            }
        }

        return true;
    }

    public static boolean registerSword(Cfg_sword data){
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
		
		Registry.itemsList.add(sword);
		Registry.itemsList.add(data.creativeTab);
		
		GameRegistry.registerItem(sword, registerName);
		sword.setUnlocalizedName(Registry.mod_id.toLowerCase()+":"+data.textureName);
	    LanguageRegistry.instance().addStringLocalization(sword.getUnlocalizedName()+".name","en_US",data.name.substring(0, 1).toUpperCase()+data.name.substring(1));
    	
        return true;
    }

    public static boolean registerSword(Cfg_sword[] data){
        int i;

        for(i=0;i<data.length;i++){
            boolean registered = registerSword(data[i]);

            if(!registered){
                LogHelper.error("Failed to register: Sword " + i);
                return false;
            }
        }

        return true;
    }

}
