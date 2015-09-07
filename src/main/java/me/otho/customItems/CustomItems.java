package me.otho.customItems;

import java.io.File;
import java.io.IOException;

import net.minecraftforge.common.MinecraftForge;

import me.otho.customItems.compability.Integration;
import me.otho.customItems.configuration.Forge.ForgeConfig;
import me.otho.customItems.configuration.Json.JsonConfigurationHandler;
import me.otho.customItems.mod.creativeTab.customItemsTab;
import me.otho.customItems.mod.handler.BlockDropHandler;
import me.otho.customItems.mod.handler.EntityDropHandler;
import me.otho.customItems.mod.worldGen.CustomWorldGenerator;
import me.otho.customItems.proxy.IProxy;
import me.otho.customItems.reference.Reference;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(dependencies=Reference.DEPENDENCIES, modid  = Reference.MOD_ID, version = Reference.VERSION, name=Reference.MOD_NAME)
public class CustomItems
{	
	@Instance(Reference.MOD_ID)
	public static CustomItems instance;
	
    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)   
    public static IProxy proxy;
	
	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) throws IOException
	{			
		String configFolderPath = event.getModConfigurationDirectory().toString()+File.separator+Reference.MOD_ID+File.separator;
		
		ForgeConfig.init(event.getSuggestedConfigurationFile());		
		
		Integration.init();
		
		customItemsTab.init();
				
		JsonConfigurationHandler.init(configFolderPath, event.getSourceFile());
		
		GameRegistry.registerWorldGenerator(new CustomWorldGenerator(), 1);		
		
    	proxy.registerTileEntities();
    	proxy.Integration_NEI();
    	
    	MinecraftForge.EVENT_BUS.register(new EntityDropHandler());
    	MinecraftForge.EVENT_BUS.register(new BlockDropHandler());
    	
	}	
    
    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
    	JsonConfigurationHandler.post_init();
    }
}