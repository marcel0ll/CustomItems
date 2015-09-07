package me.otho.customItems.configuration.Json.jsonReaders.blocks;

import me.otho.customItems.configuration.Json.jsonReaders.common.Cfg_basicData;

public class Cfg_block extends Cfg_basicData
{
	//ItemBlock
	public int maxStackSize = 64;
	
	//Visual and sound
	public Cfg_sideTextures multipleTextures;
	public boolean isOpaque = true;
	public String type = "NORMAL";
	public String stepSound = "stone";
		
	//Block Properties
	public String material = "rock";
	public String toolClass;
	public float resistance = 10;
	public float hardness = 2;
	public float lightLevel = 0;		
	public int harvestLevel = 0;		
	public float slipperiness = 0.6f;
    public boolean isCollidable = true;
	
	//Drop
	public boolean dropsItSelf = false;
	public boolean canSilkHarvest = false;
	
	public String dropItemName;
	public int dropItemDamage = 0;
	public int minItemDrop = 1;
    public int maxItemDrop = 1;    
    public int eachExtraItemDropChance = 50;
}
