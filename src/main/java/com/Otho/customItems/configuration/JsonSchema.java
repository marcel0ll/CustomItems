package com.Otho.customItems.configuration;

import com.Otho.customItems.configuration.jsonReaders.blocks.Cfg_block;
import com.Otho.customItems.configuration.jsonReaders.blocks.Cfg_crop;
import com.Otho.customItems.configuration.jsonReaders.blocks.Cfg_fluid;
import com.Otho.customItems.configuration.jsonReaders.common.Cfg_creativeTab;
import com.Otho.customItems.configuration.jsonReaders.items.Cfg_item;
import com.Otho.customItems.configuration.jsonReaders.items.armor.Cfg_boots;
import com.Otho.customItems.configuration.jsonReaders.items.armor.Cfg_chestplate;
import com.Otho.customItems.configuration.jsonReaders.items.armor.Cfg_helmet;
import com.Otho.customItems.configuration.jsonReaders.items.armor.Cfg_leggings;
import com.Otho.customItems.configuration.jsonReaders.items.food.Cfg_food;
import com.Otho.customItems.configuration.jsonReaders.items.tools.Cfg_axe;
import com.Otho.customItems.configuration.jsonReaders.items.tools.Cfg_hoe;
import com.Otho.customItems.configuration.jsonReaders.items.tools.Cfg_pickaxe;
import com.Otho.customItems.configuration.jsonReaders.items.tools.Cfg_shovel;
import com.Otho.customItems.configuration.jsonReaders.items.tools.Cfg_sword;
import com.Otho.customItems.configuration.jsonReaders.tileEntity.Cfg_chest;
import com.Otho.customItems.configuration.jsonReaders.tweakers.Cfg_change_block;
import com.Otho.customItems.configuration.jsonReaders.tweakers.Cfg_change_item;

public class JsonSchema 
{	
	public Cfg_block[] blocks;
	public Cfg_chest[] chests;
	public Cfg_item[] items;	
	public Cfg_food[] foods;
	public Cfg_pickaxe[] pickaxes;
	public Cfg_axe[] axes;
	public Cfg_shovel[] shovels;
	public Cfg_hoe[] hoes;
	public Cfg_sword[] swords;
	public Cfg_helmet[] helmets;
	public Cfg_chestplate[] chestplates;
	public Cfg_leggings[] leggings;
	public Cfg_boots[] boots;
	public Cfg_fluid[] fluids;
	public Cfg_creativeTab[] creativeTabs;
	public Cfg_crop[] crops;
	
	public Cfg_change_block[] changeBlocks;
	public Cfg_change_item[] changeItems;
	
	JsonSchema(){};
}
