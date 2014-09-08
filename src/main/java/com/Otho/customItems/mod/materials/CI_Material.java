package com.Otho.customItems.mod.materials;

import net.minecraft.block.material.*;
import net.minecraft.block.material.Material;

public class CI_Material {
	
	public static Material getMaterial (String material)
	{		
		switch(material)
		{	
			case "air":
				return Material.air;
			case "anvil":
				return Material.anvil;
			case "cactus":
				return Material.cactus;
			case "cake":
				return Material.cake;
			case "carpet":
				return Material.carpet;
			case "circuits":
				return Material.circuits;
			case "clay":
				return Material.clay;
			case "cloth":
				return Material.cloth;
			case "coral":
				return Material.coral;
			case "craftedSnow":
				return Material.craftedSnow;
			case "dragonEgg":
				return Material.dragonEgg;
			case "fire":
				return Material.fire;
			case "glass":
				return Material.glass;
			case "gourd":
				return Material.gourd;
			case "grass":
				return Material.grass;
			case "ground":
				return Material.ground;
			case "ice":
				return Material.ice;
			case "iron":
				return Material.iron;
			case "lava":
				return Material.lava;
			case "leaves":
				return Material.leaves;
			case "packedIce":
				return Material.packedIce;
			case "piston":
				return Material.piston;
			case "plants":
				return Material.plants;
			case "portal":
				return Material.portal;
			case "redstoneLight":
				return Material.redstoneLight;
			case "rock":
				return Material.rock;
			case "sand":
				return Material.sand;
			case "snow":
				return Material.snow;
			case "sponge":
				return Material.sponge;
			case "tnt":
				return Material.tnt;
			case "vine":
				return Material.vine;
			case "water":
				return Material.water;
			case "web":
				return Material.web;
			case "wood":
				return Material.wood;		
			default:
				return Material.rock;
		}
	}
}