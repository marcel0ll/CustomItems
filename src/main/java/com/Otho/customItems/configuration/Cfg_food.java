package com.Otho.customItems.configuration;

import com.Otho.customItems.lib.ModReference;

public class Cfg_food extends Cfg_item
{
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