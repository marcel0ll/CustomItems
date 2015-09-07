package me.otho.customItems.configuration.Json.jsonReaders.items.food;

import me.otho.customItems.configuration.Json.jsonReaders.common.Cfg_PotionEffect;
import me.otho.customItems.configuration.Json.jsonReaders.items.Cfg_item;

public class Cfg_food extends Cfg_item
{
	public int healAmount = 1;
	public float saturationModifier = 1;
	public boolean alwaysEdible = false;
	public boolean isWolfFood = false;
	public String useAction = "eat";
	
	public String dropItemName;	
	
	public Cfg_PotionEffect[] potionEffects;
}