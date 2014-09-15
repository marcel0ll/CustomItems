package com.Otho.customItems.handler;

import net.minecraft.client.audio.SoundCategory;
import net.minecraft.client.audio.SoundEventAccessorComposite;
import net.minecraft.client.audio.SoundRegistry;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.EnumHelperClient;
import net.minecraftforge.common.util.EnumHelper;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.Otho.customItems.lib.constants;
import com.Otho.customItems.mod.items.disks.CustomDisk;
import com.Otho.customItems.util.StringUtil;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class DisksHandler {

	public static void init()
	{
		JsonArray disksData = ConfigurationHandler.musicDisks;
		
		int i;
		
		if(disksData != null)
		{
			for(i=0;i<disksData.size();i++)
			{
				JsonObject data = (JsonObject) disksData.get(i);
				
				String name =  data.get("name").getAsString();
				String textureName =  data.get("textureName").getAsString();
				textureName = StringUtil.parseTextureName(textureName);
				
				String music =  data.get("music").getAsString();
				
				CustomDisk disk = new CustomDisk(music);
				
				GameRegistry.registerItem(disk, textureName);
				disk.setUnlocalizedName(constants.MOD_ID.toLowerCase()+":"+name);
				
				ResourceLocation rl = new ResourceLocation(constants.MOD_ID.toLowerCase()+":sounds/records/"+textureName);
				SoundCategory a = SoundCategory.valueOf("RECORDS");
				SoundEventAccessorComposite b = new SoundEventAccessorComposite(rl, 2.0, 2.0, a);
				
				
				
				LanguageRegistry.instance().addStringLocalization(disk.getUnlocalizedName()+".name","en_US","Music Disc");				
			}
		}
	}
}
