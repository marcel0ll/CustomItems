package me.otho.customItems;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

import me.otho.customItems.configuration.ForgeConfig;
import me.otho.customItems.configuration.JsonConfigurationHandler;
import me.otho.customItems.mod.creativeTab.customItemsTab;
import me.otho.customItems.proxy.ServerProxy;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(dependencies=ModReference.DEPENDENCIES, modid  = ModReference.MOD_ID, version = ModReference.VERSION, name=ModReference.MOD_NAME)
public class CustomItems
{	
	@Instance(ModReference.MOD_ID)
	public static CustomItems instance;
	
    @SidedProxy(clientSide = ModReference.CLIENT_PROXY_CLASS, serverSide = ModReference.SERVER_PROXY_CLASS)
    public static ServerProxy proxy;
	
	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) throws IOException, URISyntaxException
	{			
		String folderPath = event.getModConfigurationDirectory().toString()+File.separator+ModReference.MOD_ID+File.separator;
		
		ForgeConfig.init(event.getSuggestedConfigurationFile());
		
//		if(ForgeConfig.remake)
//			JsonConfigurationHandler.unpackConfigFile(CustomItems.class, "defaultConfigs", folderPath);
		
		customItemsTab.init();
				
		JsonConfigurationHandler.init(folderPath);
		
    	proxy.registerTileEntities();
	}	
    
    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
    	JsonConfigurationHandler.post_init();
    }
}