package me.otho.customItems.mod.handler;

import net.minecraftforge.event.world.BlockEvent.HarvestDropsEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.registry.GameRegistry;

public class BlockDropHandler {

	@SubscribeEvent
	public void onBlockDrop(HarvestDropsEvent event){
		System.out.println(GameRegistry.findUniqueIdentifierFor(event.block));
	}
}
