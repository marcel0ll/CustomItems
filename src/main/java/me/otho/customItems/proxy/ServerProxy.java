package me.otho.customItems.proxy;

import me.otho.customItems.CustomItems;
import me.otho.customItems.mod.GUI.GuiHandler;
import me.otho.customItems.mod.tileentitys.TileEntityCustomChest;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

public class ServerProxy {

		
		
		public void registerTileEntities()
		{
			GameRegistry.registerTileEntity(TileEntityCustomChest.class, TileEntityCustomChest.publicName);
			NetworkRegistry.INSTANCE.registerGuiHandler(CustomItems.instance, new GuiHandler());
			
		}
}
