package com.Otho.customItems.configuration;

import com.Otho.customItems.lib.constants;

public class Block {
	public String name;
	public String textureName;
	public String creativeTab = constants.MOD_ID;
	
	public String material = "rock";
	public String toolClass = "pickaxe";
	public float resistance = 10;
	public float hardness = 2;
	public float lightLevel = 0;
	
	public int harvestLevel = 0;
}
