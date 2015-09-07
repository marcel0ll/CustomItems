package me.otho.customItems.configuration.Json.jsonReaders.items.tools;

import me.otho.customItems.configuration.Json.jsonReaders.common.Cfg_basicData;

public class Cfg_basicTool extends Cfg_basicData 
{
	/**
	 * harvestLevel is the level of "hardness" that this tool can mine
	 */
	public int harvestLevel = 0;
	/**
	 * maxUses is the amount of times that this tool can be used to mine or hit entities
	 */
	public int maxUses = 59;
	/**
	 * efficiencyOnProperMaterial is how fast can this tool mine the right blocks
	 */
	public float efficiencyOnProperMaterial = 2.0f;
	/**
	 * damageVsEntity is how much damage this does causes
	 */
	public float damageVsEntity = 0.0f;
	/**
	 * enchantability is how easy can this tool be enchanted
	 */
	public int enchantability = 15;
}
