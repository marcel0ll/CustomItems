package me.otho.customItems.configuration;

import me.otho.customItems.configuration.jsonReaders.blocks.Cfg_block;
import me.otho.customItems.configuration.jsonReaders.blocks.Cfg_crop;
import me.otho.customItems.configuration.jsonReaders.blocks.Cfg_fluid;
import me.otho.customItems.configuration.jsonReaders.common.Cfg_creativeTab;
import me.otho.customItems.configuration.jsonReaders.items.Cfg_item;
import me.otho.customItems.configuration.jsonReaders.items.armor.Cfg_boots;
import me.otho.customItems.configuration.jsonReaders.items.armor.Cfg_chestplate;
import me.otho.customItems.configuration.jsonReaders.items.armor.Cfg_helmet;
import me.otho.customItems.configuration.jsonReaders.items.armor.Cfg_leggings;
import me.otho.customItems.configuration.jsonReaders.items.food.Cfg_food;
import me.otho.customItems.configuration.jsonReaders.items.tools.Cfg_axe;
import me.otho.customItems.configuration.jsonReaders.items.tools.Cfg_hoe;
import me.otho.customItems.configuration.jsonReaders.items.tools.Cfg_pickaxe;
import me.otho.customItems.configuration.jsonReaders.items.tools.Cfg_shovel;
import me.otho.customItems.configuration.jsonReaders.items.tools.Cfg_sword;
import me.otho.customItems.configuration.jsonReaders.tileEntity.Cfg_chest;
import me.otho.customItems.configuration.jsonReaders.tweakers.Cfg_change_block;
import me.otho.customItems.configuration.jsonReaders.tweakers.Cfg_change_item;

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
