package me.otho.customItems.configuration.jsonReaders.common;

import me.otho.customItems.reference.Reference;

public class Cfg_basicData 
{
	/**
	 * name is the identifier of the item/block to be registered
	 */
	public String name;
	/**
	 * texturename is the name of the image file of the item/block to be registered
	 */
	public String textureName;
	/**
	 * creativeTab is the identifier of the creativeTab that the item/block will be put on
	 */
	public String creativeTab = Reference.MOD_NAME;
	/**
	 * registerOrder is a variable to order the items/blocks before being registered. This should order items in creativetabs and NEI
	 */
	public Integer registerOrder = 0;
}
