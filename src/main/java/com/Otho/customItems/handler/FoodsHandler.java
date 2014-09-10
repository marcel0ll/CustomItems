package com.Otho.customItems.handler;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.Otho.customItems.lib.constants;
import com.Otho.customItems.mod.items.food.CustomFood;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class FoodsHandler {

	public static void init()
	{
		JSONArray foodsData = ConfigurationHandler.foods;
		
		int i;
		
		if(foodsData != null)
		{
			for(i=0;i<foodsData.size();i++)
			{
				JSONObject data = (JSONObject) foodsData.get(i);
				
				String name = (String) data.get("name");
				String textureName =(String) data.get("textureName");
				
				int healAmount = ((Number) data.get("healAmount")).intValue();
				float saturationModifier = ((Number) data.get("saturationModifier")).floatValue();
				boolean isWolfsFavoriteMeat = ((Boolean) data.get("isWolfsFavoriteMeat")).booleanValue();
				
				CustomFood food = new CustomFood(healAmount, saturationModifier, isWolfsFavoriteMeat);
				
				JSONObject potionEffect = (JSONObject) data.get("potionEffect");
				if(potionEffect != null)
				{
					String effect = (String) potionEffect.get("effect");
					int potionDuration = ((Number) potionEffect.get("potionDuration")).intValue();
					int potionAmplifier = ((Number) potionEffect.get("potionAmplifier")).intValue();
					float potionEffectProbability = ((Number) potionEffect.get("potionEffectProbability")).floatValue();
					
					food.setPotionEffect(potionEffectId(effect), potionDuration, potionAmplifier, potionEffectProbability);
				}
				
					
				
				GameRegistry.registerItem(food, textureName);
				food.setUnlocalizedName(constants.MOD_ID.toLowerCase() + ":"+textureName);
				LanguageRegistry.instance().addStringLocalization(food.getUnlocalizedName()+".name","en_US", name);
				
			}
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
