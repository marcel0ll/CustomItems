package com.Otho.customItems;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

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
	public void preInit(FMLPreInitializationEvent event) throws IOException
	{			
		
		String folderPath = event.getModConfigurationDirectory().toString()+File.separator+ModReference.MOD_ID+File.separator;

		customItemsTab.init();
		
		
		forgeCustomConfigHandler.init(event.getSuggestedConfigurationFile());
		
//		if(ModReference.makeRP)
//		{
//			boolean makeRPFolder = false;
//			boolean makeCIFolder = false;
//			
//			File myFile = event.getSuggestedConfigurationFile();
//			File configFolder = myFile.getParentFile();
//			File mineFolder = configFolder.getParentFile();
//			File RPFolder = new File(mineFolder.getPath()+ File.separator + "resourcepacks");
//			
//			File CIfolder = myFile;
//			File meta;
//			
//			if(RPFolder.exists())
//			{
//				LogHelper.info("RPFolder already exist");
//				CIfolder = new File(RPFolder.getPath()+ File.separator + "CustomItemsPack");
//				if(!CIfolder.exists())
//				{
//					LogHelper.info("CIFolder does not exist");
//					makeCIFolder = true;
//				}else
//				{
//					LogHelper.info("CIFolder already exist");					
//				}
//			}else
//			{
//				LogHelper.info("RPFolder does not exist");
//				makeRPFolder = true;
//				makeCIFolder = true;
//			}
//			
//			if(makeRPFolder)
//			{
//				RPFolder.mkdir();
//			}
//			
//			if(makeCIFolder)
//			{
//				CIfolder.mkdir();
//				meta = new File(CIfolder.getPath() + File.separator + "pack.mcmeta");
//				
//				meta.createNewFile();
//				PrintWriter out = new PrintWriter(meta);
//				out.println('{');
//				out.println("\t"+'"'+"pack" +'"'+ ": {");
//				out.println("\t\t"+'"'+"pack_format" +'"'+ ": 1,");
//				out.println("\t\t"+'"'+"description" +'"'+ ": "+'"'+"Custom Items Pack"+'"');
//				out.println("\t}");
//				out.println("}");
//				
//				out.close();
//				
//				File assets = new File(CIfolder.getPath() + File.separator + "assets");
//				assets.mkdir();
//				File modId = new File(assets.getPath() + File.separator + "customitems");
//				modId.mkdir();
//				File textures = new File(modId.getPath() + File.separator + "textures");
//				textures.mkdir();
//				
//				File blocks = new File(textures.getPath() + File.separator + "blocks");
//				blocks.mkdir();
//				File gui = new File(textures.getPath() + File.separator + "gui");
//				gui.mkdir();
//				File items = new File(textures.getPath() + File.separator + "items");
//				items.mkdir();
//				File models = new File(textures.getPath() + File.separator + "models");
//				models.mkdir();
//			}
//		}
		
		JsonConfigurationHandler.init(folderPath);
		
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
