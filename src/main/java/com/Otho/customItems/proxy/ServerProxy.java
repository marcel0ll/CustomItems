package com.Otho.customItems.proxy;

import com.Otho.customItems.CustomItems;
import com.Otho.customItems.ModReference;
import com.Otho.customItems.mod.GUI.GuiHandler;
import com.Otho.customItems.mod.tileentitys.TileEntityCustomChest;

import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

public class ServerProxy {

		
		
		public void registerTileEntities()
		{
			GameRegistry.registerTileEntity(TileEntityCustomChest.class, TileEntityCustomChest.publicName);
			NetworkRegistry.INSTANCE.registerGuiHandler(CustomItems.instance, new GuiHandler());
			
		}
}
