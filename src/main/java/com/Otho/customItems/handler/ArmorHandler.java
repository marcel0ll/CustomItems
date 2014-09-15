package com.Otho.customItems.handler;

import net.minecraft.item.ItemArmor;
import net.minecraftforge.common.util.EnumHelper;

import com.google.gson.*;
import com.Otho.customItems.lib.constants;
import com.Otho.customItems.mod.items.armor.CustomArmor;
import com.Otho.customItems.util.StringUtil;
import com.Otho.customItems.util.logHelper;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class ArmorHandler {
	public static void init()
	{
		JsonObject armors = ConfigurationHandler.armor;
		
		if(armors != null)
		{
			JsonArray helmets = (JsonArray) armors.get("helmets");
			JsonArray chestplates = (JsonArray) armors.get("chestplates");
			JsonArray leggings = (JsonArray) armors.get("leggings");
			JsonArray boots = (JsonArray) armors.get("boots");
			
			if(helmets != null)
				NewArmors(helmets, 0);
			if(chestplates != null)
				NewArmors(chestplates, 1);
			if(leggings != null)
				NewArmors(leggings, 2);
			if(boots != null)
				NewArmors(boots, 3);
		}
		
	}
	
	private static void NewArmors(JsonArray armors, int type)
	{
		int i;
		
		for(i=0;i<armors.size();i++)
		{
			//Get Armor Json
			JsonObject data = (JsonObject) armors.get(i);
			logHelper.log(constants.MOD_ID, logHelper.debug, data.toString());
			
			//Parse Armor attributes
			String name = data.get("name").getAsString();
        	String textureName = data.get("textureName").getAsString();
        	textureName = StringUtil.parseTextureName(textureName);
        	
        	int durability = data.get("durability").getAsInt();
        	int reductionNum = data.get("reduction").getAsInt();
        	int enchantability = data.get("enchantability").getAsInt();
        	
			//Make Custom Armor
        	int reduction[] = {0,0,0,0};
        	reduction[type] = reductionNum;
        	ItemArmor.ArmorMaterial material = EnumHelper.addArmorMaterial(textureName, durability, reduction, enchantability);
        	CustomArmor armor = new CustomArmor(material, 0, type, textureName);
			//Register Armor
        	
        	GameRegistry.registerItem(armor, textureName);
            armor.setUnlocalizedName(constants.MOD_ID.toLowerCase()+":"+name);
            LanguageRegistry.instance().addStringLocalization(armor.getUnlocalizedName()+".name","en_US",name.substring(0, 1).toUpperCase()+name.substring(1));        	 	
		}
	}
}
