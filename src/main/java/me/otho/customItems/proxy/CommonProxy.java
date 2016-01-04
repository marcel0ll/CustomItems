package me.otho.customItems.proxy;

import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import me.otho.customItems.CustomItems;
import me.otho.customItems.mod.GUI.GuiHandler;
import me.otho.customItems.mod.tileentitys.TileEntityCustomChest;

public abstract class CommonProxy implements IProxy {

    @Override
    public void registerTileEntities() {
        GameRegistry.registerTileEntity(TileEntityCustomChest.class, TileEntityCustomChest.publicName);
        NetworkRegistry.INSTANCE.registerGuiHandler(CustomItems.instance, new GuiHandler());
    }
}
