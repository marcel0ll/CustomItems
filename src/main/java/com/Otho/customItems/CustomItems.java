package com.Otho.customItems;

import java.io.File;

import com.Otho.customItems.configuration.JsonConfigurationHandler;
import com.Otho.customItems.configuration.Register;
import com.Otho.customItems.configuration.forgeCustomConfigHandler;
import com.Otho.customItems.lib.constants;
import com.Otho.customItems.util.LogHelper;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraft.client.audio.SoundRegistry;





@Mod(dependencies=constants.DEPENDENCIES, modid  = constants.MOD_ID, version = constants.VERSION, name=constants.MOD_NAME)
public class CustomItems
{	
	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{			
		String path = event.getModConfigurationDirectory().toString()+File.separator+constants.MOD_ID+".json";
		String folderPath = event.getModConfigurationDirectory().toString()+File.separator+constants.MOD_ID+File.separator;

		JsonConfigurationHandler.init(path, folderPath);
		forgeCustomConfigHandler.init(event.getSuggestedConfigurationFile());
		//Register.init();
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
