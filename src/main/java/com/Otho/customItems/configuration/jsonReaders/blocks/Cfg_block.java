package com.Otho.customItems.configuration.jsonReaders.blocks;

import com.Otho.customItems.ModReference;
import com.Otho.customItems.configuration.jsonReaders.common.Cfg_basicData;

public class Cfg_block extends Cfg_basicData
{
	public Cfg_sideTextures multipleTextures;
	
	public String material = "rock";
	public String toolClass;
	public float resistance = 10;
	public float hardness = 2;
	public float lightLevel = 0;		
	public int harvestLevel = 0;	
	public String stepSound = "stone";
	public boolean canSilkHarvest = false;
	public float slipperiness = 0.6f;
	public int maxStackSize = 64;
	
	public boolean dropsItSelf = false;
	public String dropItemName;
	public int minItemDrop = 1;
    public int maxItemDrop = 1;    
    public int eachExtraItemDropChance = 50;
	
    public boolean isCollidable = true;
	public boolean isOpaque = true;
	public boolean falls = false;	
	
	public String type = "NORMAL";
	public boolean renderAsNormalBlock = true;
}
