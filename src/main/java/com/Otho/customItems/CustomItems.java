package com.Otho.customItems;

import java.io.File;

import com.Otho.customItems.configuration.JsonConfigurationHandler;
import com.Otho.customItems.configuration.RegisterCustomItems;
import com.Otho.customItems.configuration.forgeCustomConfigHandler;
import com.Otho.customItems.lib.ModReference;
import com.Otho.customItems.mod.GUI.GuiHandler;
import com.Otho.customItems.mod.blocks.CustomChest;
import com.Otho.customItems.mod.creativeTab.customItemsTab;
import com.Otho.customItems.mod.tileentitys.TileEntityCustomChest;
import com.Otho.customItems.proxy.ServerProxy;
import com.Otho.customItems.util.LogHelper;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.client.audio.SoundRegistry;
import net.minecraftforge.common.IExtendedEntityProperties;







@Mod(dependencies=ModReference.DEPENDENCIES, modid  = ModReference.MOD_ID, version = ModReference.VERSION, name=ModReference.MOD_NAME)
public class CustomItems
{	
	@Instance(ModReference.MOD_ID)
	public static CustomItems instance;
	
    @SidedProxy(clientSide = ModReference.CLIENT_PROXY_CLASS, serverSide = ModReference.SERVER_PROXY_CLASS)
    public static ServerProxy proxy;
    
    
	
	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{			
		String path = event.getModConfigurationDirectory().toString()+File.separator+ModReference.MOD_ID+".json";
		String folderPath = event.getModConfigurationDirectory().toString()+File.separator+ModReference.MOD_ID+File.separator;

		customItemsTab.init();
		
		JsonConfigurationHandler.init(path, folderPath);
		forgeCustomConfigHandler.init(event.getSuggestedConfigurationFile());
		
    	proxy.registerTileEntities();
	}	
	
    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {
    }
    
    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
    }
}
