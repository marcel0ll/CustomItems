package com.Otho.customItems.configuration;

public class Food {
	public String name;
	public String textureName;
	public int maxStackSize;
	
	public int healAmount;
	public float saturationModifier;
	public PotionEffect potionEffect;
	
	public class PotionEffect{
		public String effect;
		public int potionDuration;
		public int potionAmplifier;
		public float potionEffectProbability;		
	}
}