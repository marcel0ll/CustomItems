package me.otho.customItems.mod.handler;

import java.util.Random;

import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.registry.GameData;
import cpw.mods.fml.common.registry.GameRegistry;
import me.otho.customItems.configuration.jsonReaders.blocks.Cfg_blockDrop;
import me.otho.customItems.configuration.jsonReaders.common.Cfg_drop;
import me.otho.customItems.registry.BlockRegistry;
import me.otho.customItems.utility.LogHelper;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.world.BlockEvent.HarvestDropsEvent;

public class BlockDropHandler {

  protected int getItemDropQuantity(Cfg_drop data) {
    Random rand = new Random();
    int ret = data.min;
    int i;

    // TODO: fortune effect
    for (i = data.min; i < data.max; i++) {
      boolean willDrop = rand.nextFloat() * 100 < data.chance;
      if (willDrop) {
        ret++;
      }
    }

    return ret;
  }

  @SubscribeEvent(priority = EventPriority.LOWEST)
  public void onBlockDrop(HarvestDropsEvent event) {
    Random random = new Random();
    Block block = event.block;

    // LogHelper.info("block before break: " + Block.getIdFromBlock(block));
    String uniqueIdentifier = GameData.getBlockRegistry().getNameForObject(block);
    if (uniqueIdentifier != null) {
      // LogHelper.info("block uid: "+
      // GameData.getBlockRegistry().getNameForObject(block));
      String blockId = uniqueIdentifier + ":" + event.blockMetadata;
      // LogHelper.info("Latest block breaked id: " + blockId);
      if (BlockRegistry.drops.containsKey(blockId)) {
        Cfg_blockDrop blockDrop = BlockRegistry.drops.get(blockId);

        //
        if (blockDrop.overrides) {
          event.drops.clear();
        }

        for (Cfg_drop drop : blockDrop.drops) {

          String[] parser = drop.id.split(":");
          String modId = parser[0];
          String name = parser[1];
          int damage = 0;
          if (parser.length > 2) {
            damage = Integer.parseInt(parser[2]);
          }

          Item item = GameRegistry.findItem(modId, name);
          int quantity = getItemDropQuantity(drop);

          event.drops.add(new ItemStack(item, quantity, damage));
        }
      }
    } else {
      LogHelper.warn("Block " + Block.getIdFromBlock(block) + " is missing in registry!");
    }

  }

}
