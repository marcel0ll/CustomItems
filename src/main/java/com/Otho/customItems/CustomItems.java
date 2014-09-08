package com.Otho.customItems;

import com.Otho.customItems.lib.constants;
import com.Otho.customItems.handler.ArmorHandler;
import com.Otho.customItems.handler.BlockHandler;
import com.Otho.customItems.handler.ConfigurationHandler;
import com.Otho.customItems.handler.ToolsHandler;
import com.Otho.customItems.util.logHelper;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemFood;


@Mod(dependencies=constants.DEPENDENCIES, modid  = constants.MOD_ID, version = constants.VERSION, name=constants.MOD_NAME)
public class CustomItems
{
	
	
	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		logHelper.permission = 5;
				
		String path = event.getModConfigurationDirectory().toString()+"\\"+constants.MOD_ID+".json";		
		logHelper.log(constants.MOD_ID, logHelper.debug, path);		
		ConfigurationHandler.init(path);
		BlockHandler.init();
		ToolsHandler.init();
		ArmorHandler.init();
		
		
		
		
	
	}	
	
    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {
		// some example code
    	
    	 
    }
    
    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
    	
    	
    }
}
