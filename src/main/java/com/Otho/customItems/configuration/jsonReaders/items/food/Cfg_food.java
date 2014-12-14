package com.Otho.customItems.configuration.jsonReaders.items.food;

import com.Otho.customItems.ModReference;
import com.Otho.customItems.configuration.jsonReaders.common.Cfg_PotionEffect;
import com.Otho.customItems.configuration.jsonReaders.items.Cfg_item;

public class Cfg_food extends Cfg_item
{
	public int healAmount = 1;
	public float saturationModifier = 1;
	public boolean alwaysEdible = false;
	public boolean isWolfFood = false;
	
	public Cfg_PotionEffect[] potionEffects;
	
}