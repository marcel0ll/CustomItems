package me.otho.customItems;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.zip.ZipEntry;

import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLiving;
import net.minecraftforge.common.MinecraftForge;

import org.apache.commons.io.FileUtils;
import org.apache.commons.logging.Log;

import me.otho.customItems.compability.Integration;
import me.otho.customItems.configuration.ForgeConfig;
import me.otho.customItems.configuration.JsonConfigurationHandler;
import me.otho.customItems.mod.creativeTab.customItemsTab;
import me.otho.customItems.mod.handler.BlockDropHandler;
import me.otho.customItems.mod.handler.EntityDropHandler;
import me.otho.customItems.mod.worldGen.CustomWorldGenerator;
import me.otho.customItems.proxy.IProxy;
import me.otho.customItems.proxy.ServerProxy;
import me.otho.customItems.utility.LogHelper;
import cpw.mods.fml.client.FMLFileResourcePack;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(dependencies=ModReference.DEPENDENCIES, modid  = ModReference.MOD_ID, version = ModReference.VERSION, name=ModReference.MOD_NAME)
public class CustomItems
{	
	@Instance(ModReference.MOD_ID)
	public static CustomItems instance;
	
    @SidedProxy(clientSide = ModReference.CLIENT_PROXY_CLASS, serverSide = ModReference.SERVER_PROXY_CLASS)   
    public static IProxy proxy;
	
	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) throws IOException
	{			
		String configFolderPath = event.getModConfigurationDirectory().toString()+File.separator+ModReference.MOD_ID+File.separator;
		
		ForgeConfig.init(event.getSuggestedConfigurationFile());		
		
		customItemsTab.init();
				
		JsonConfigurationHandler.init(configFolderPath, event.getSourceFile());
		
		GameRegistry.registerWorldGenerator(new CustomWorldGenerator(), 1);		
		
    	proxy.registerTileEntities();
    	
    	MinecraftForge.EVENT_BUS.register(new EntityDropHandler());
    	MinecraftForge.EVENT_BUS.register(new BlockDropHandler());
    	
	}	
    
    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
    	JsonConfigurationHandler.post_init();
        
    	Integration.init();
    }
}