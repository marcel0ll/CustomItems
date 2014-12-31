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
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.zip.ZipEntry;

import org.apache.commons.io.FileUtils;

import me.otho.customItems.configuration.ForgeConfig;
import me.otho.customItems.configuration.JsonConfigurationHandler;
import me.otho.customItems.mod.creativeTab.customItemsTab;
import me.otho.customItems.mod.worldGen.CustomWorldGenerator;
import me.otho.customItems.proxy.ServerProxy;
import me.otho.customItems.util.LogHelper;
import cpw.mods.fml.client.FMLFileResourcePack;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

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
		String configFolderPath = event.getModConfigurationDirectory().toString()+File.separator+ModReference.MOD_ID+File.separator;
		
		ForgeConfig.init(event.getSuggestedConfigurationFile());		
		
		if(ForgeConfig.remake){
			remakeConfigFiles(event.getSourceFile(), configFolderPath);
		}
		
		customItemsTab.init();
				
		JsonConfigurationHandler.init(configFolderPath);
		
		GameRegistry.registerWorldGenerator(new CustomWorldGenerator(), 1);
		
    	proxy.registerTileEntities();
	}	
    
    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
    	JsonConfigurationHandler.post_init();
    }
    
    private void remakeConfigFiles(File source, String configFolderPath) throws IOException{    	
		if(source.isFile()){
			JarFile file = new JarFile(source);
			
			ZipEntry defaultConfigs = file.getEntry("defaultConfigs/");
			
			for (Enumeration<JarEntry> e = file.entries(); e.hasMoreElements();){
				ZipEntry entry = (ZipEntry) e.nextElement();
				
//                System.out.println("File name: " + entry.getName()
//                        + "; size: " + entry.getSize()
//                        + "; compressed size: "
//                        + entry.getCompressedSize());
//                System.out.println();
                if(entry.getName().contains("defaultConfigs/")){
                	String[] parser = entry.getName().split("defaultConfigs/");
                	if(parser.length > 1){
                		String fileName = parser[1];
                		if(fileName.endsWith(".json")){		                	
		                	File configFile = new File(configFolderPath + parser[1]);
		                	if(configFile.exists())
		                		configFile.delete();
			                InputStream is = file.getInputStream(entry);
			                
			                InputStreamReader isr = new InputStreamReader(is);		 
			                
			                char[] buffer = new char[1];
			                while (isr.read(buffer, 0, buffer.length) != -1) {
			                    String s = new String(buffer);
			                    FileUtils.write(configFile, s, true);		                    
			                }	 
                		}
                	}
                }
			}
			
			LogHelper.info("End of Default Config Files");
			file.close();
		}
    }
}