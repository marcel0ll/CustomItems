package me.otho.customItems.proxy;

import net.minecraft.item.ItemStack;
import me.otho.customItems.CustomItems;
import me.otho.customItems.mod.GUI.GuiHandler;
import me.otho.customItems.mod.tileentitys.TileEntityCustomChest;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

public class ServerProxy extends CommonProxy{

	@Override
	public void Integration_NEI() {
		//Client Only
	}

	@Override
	public void hideItemInNEI(Object[] stack) {
		//Client Only
	}

	
}
