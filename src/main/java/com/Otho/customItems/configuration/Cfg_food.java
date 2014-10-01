package com.Otho.customItems.configuration;

import com.Otho.customItems.lib.constants;

public class Cfg_food {
	public String name;
	public String textureName;
	public String creativeTab = constants.MOD_NAME;
	public int maxStackSize = 64;
	
	public int healAmount = 1;
	public float saturationModifier = 1;
	public PotionEffect potionEffect;
	
	public class PotionEffect{
		public String effect = "moveSpeed";
		public int potionDuration = 20;
		public int potionAmplifier = 1;
		public float potionEffectProbability = 1;		
	}
}