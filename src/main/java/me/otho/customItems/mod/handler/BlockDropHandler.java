package me.otho.customItems.mod.handler;

import java.util.Random;

import me.otho.customItems.configuration.jsonReaders.common.Cfg_drop;
import me.otho.customItems.registry.BlockRegistry;
import me.otho.customItems.utility.LogHelper;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.world.BlockEvent.HarvestDropsEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.registry.GameRegistry;

public class BlockDropHandler {

	protected int getItemDropQuantity(Cfg_drop data)
    {
		Random rand = new Random();
    	int ret = data.min;
    	int i;
    	
    	//TODO: fortune effect
    	for(i= data.min;i < data.max ;i++)
    	{
    		boolean willDrop = rand.nextFloat()*100 < data.chance;
    		if(willDrop)
    			ret++;
    	}
    	
    	return ret;	
    }	
	

	@SubscribeEvent
	public void onBlockDrop(HarvestDropsEvent event){
		System.out.println(GameRegistry.findUniqueIdentifierFor(event.block));
		
        Random random = new Random();
        Block block = event.block;
        
    	String blockId = GameRegistry.findUniqueIdentifierFor(block).toString()+":"+event.blockMetadata;
    	//LogHelper.info("Latest block breaked id: " + blockId);    
        if(BlockRegistry.drops.containsKey(blockId)){
        	if(BlockRegistry.overrides.get(blockId))
        		event.drops.clear();
        	
        	Cfg_drop[] drops = BlockRegistry.drops.get(blockId);
        	
        	for(Cfg_drop drop : drops){
        		
        		String[] parser = drop.id.split(":");
        		String modId = parser[0];
        		String name = parser[1];
        		int damage = 0;
        		if(parser.length>2)
        			damage = Integer.parseInt(parser[2]);
        		
        		Item item = GameRegistry.findItem(modId, name);
        		int quantity = getItemDropQuantity(drop);
        		
        		event.drops.add(new ItemStack(item, quantity, damage));
        	}               
        }
    }
    
}
