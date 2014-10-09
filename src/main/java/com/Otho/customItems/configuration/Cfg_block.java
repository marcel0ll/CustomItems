package com.Otho.customItems.configuration;

import com.Otho.customItems.lib.ModReference;

public class Cfg_block extends Cfg_basicData
{
	public String material = "rock";
	public String toolClass = "pickaxe";
	public float resistance = 10;
	public float hardness = 2;
	public float lightLevel = 0;		
	public int harvestLevel = 0;	
	
	public String stepSound = "stone";
	
	public boolean falls = false;
	
	public boolean canSilkHarvest = false;
	
	public boolean isOpaque = true;
	public float slipperiness = 0.6f;
	public int maxStackSize = 64;
	
	public String dropItemName;
	public int minItemDrop = 1;
    public int maxItemDrop = 1;    
    public int eachExtraItemDropChance = 50;
}
