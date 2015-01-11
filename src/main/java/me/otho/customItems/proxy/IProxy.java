package me.otho.customItems.proxy;

import net.minecraft.item.ItemStack;

public interface IProxy {
	
	public void registerTileEntities();
	
	public void Integration_NEI();

	public void hideItemInNEI(Object[] stack);
	
	
}
