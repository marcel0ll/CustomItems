package com.Otho.customItems.handler;

import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraftforge.common.util.EnumHelper;






import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.Otho.customItems.lib.constants;
import com.Otho.customItems.mod.items.armor.CustomArmor;
import com.Otho.customItems.util.logHelper;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class ArmorHandler {
	public static void init()
	{
		JSONObject armors = ConfigurationHandler.armor;
		
		JSONArray helmets = (JSONArray) armors.get("helmets");
		JSONArray chestplates = (JSONArray) armors.get("chestplates");
		JSONArray leggings = (JSONArray) armors.get("leggings");
		JSONArray boots = (JSONArray) armors.get("boots");
		
		if(helmets != null)
			NewArmors(helmets, 0);
		if(chestplates != null)
			NewArmors(chestplates, 1);
		if(leggings != null)
			NewArmors(leggings, 2);
		if(boots != null)
			NewArmors(boots, 3);
		
	}
	
	private static void NewArmors(JSONArray armors, int type)
	{
		int i;
		
		for(i=0;i<armors.size();i++)
		{
			//Get Armor Json
			JSONObject data = (JSONObject) armors.get(i);
			logHelper.log(constants.MOD_ID, logHelper.debug, data.toJSONString());
			
			//Parse Armor attributes
			String name = (String) data.get("name");
        	String textureName = (String) data.get("textureName");
        	
        	String durability = (String) data.get("durability");
        	String reductionNum = (String) data.get("reduction");
        	String enchantability = (String) data.get("enchantability");
        	
			//Make Custom Armor
        	int reduction[] = {0,0,0,0};
        	reduction[type] = (int) Float.parseFloat(reductionNum);
        	ItemArmor.ArmorMaterial material = EnumHelper.addArmorMaterial(textureName, (int) Float.parseFloat(durability), reduction, (int) Float.parseFloat(enchantability));
        	CustomArmor armor = new CustomArmor(material, 0, type, textureName);
			//Register Armor
        	
        	GameRegistry.registerItem(armor, name);
            armor.setUnlocalizedName(constants.MOD_ID.toLowerCase()+":"+name);
            LanguageRegistry.instance().addStringLocalization(armor.getUnlocalizedName()+".name","en_US",name.substring(0, 1).toUpperCase()+name.substring(1));        	 	
		}
	}
}
