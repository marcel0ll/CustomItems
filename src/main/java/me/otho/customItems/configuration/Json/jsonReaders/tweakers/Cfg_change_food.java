package me.otho.customItems.configuration.Json.jsonReaders.tweakers;

import me.otho.customItems.configuration.Json.jsonReaders.common.Cfg_PotionEffect;

public class Cfg_change_food extends Cfg_change_base{
	
	public int healAmount = 1;
	public float saturationModifier = 1;
	public boolean alwaysEdible = false;
	public boolean isWolfFood = false;
	
	public Cfg_PotionEffect potionEffect;
}
