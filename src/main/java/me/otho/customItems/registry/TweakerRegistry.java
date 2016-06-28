package me.otho.customItems.registry;

import cpw.mods.fml.common.ObfuscationReflectionHelper;
import cpw.mods.fml.common.registry.GameRegistry;
import me.otho.customItems.configuration.jsonReaders.tweakers.Cfg_change_block;
import me.otho.customItems.configuration.jsonReaders.tweakers.Cfg_change_food;
import me.otho.customItems.configuration.jsonReaders.tweakers.Cfg_change_item;
import me.otho.customItems.utility.LogHelper;
import me.otho.customItems.utility.Util;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;

public class TweakerRegistry {

  public static boolean changeBlock(Cfg_change_block data) {
    LogHelper.info("Registering Block Change: " + data.name, 1);

    String[] nameParsing = data.name.split(":");
    String modId = nameParsing[0];
    String name = nameParsing[1];

    data.toolClass = Util.validateToolClass(data.toolClass);

    if (modId != null && name != null) {
      Block block = GameRegistry.findBlock(modId, name);

      if (data.isOpaque != null) {
        if (data.isOpaque) {
          block.setLightOpacity(255);
        } else {
          block.setLightOpacity(0);
        }
      }

      if (data.hardness != null) {
        block.setHardness(data.hardness);
      }
      if (data.resistance != null) {
        block.setResistance(data.resistance);
      }
      if (data.lightLevel != null) {
        block.setLightLevel(data.lightLevel);
      }
      if (data.harvestLevel != null) {
        block.setHarvestLevel(data.toolClass, data.harvestLevel);
      }
      if (data.slipperiness != null) {
        block.slipperiness = data.slipperiness;
      }
      if (data.stepSound != null) {
        block.setStepSound(Util.parseSoundType(data.stepSound));
      }

      if (data.maxStackSize != null) {
        Item itemBlock = Item.getItemFromBlock(block);

        int size = Util.range(data.maxStackSize, 1, 64);

        itemBlock.setMaxStackSize(size);
      }
    }

    return true;
  }

  public static boolean changeBlock(Cfg_change_block[] data) {
    int i;

    for (i = 0; i < data.length; i++) {
      boolean tweaked = changeBlock(data[i]);

      if (!tweaked) {
        LogHelper.error("Failed to tweak: Block " + i);
        return false;
      }
    }

    return true;
  }

  public static boolean changeItem(Cfg_change_item data) {
    LogHelper.info("Registering Item Change: " + data.name, 1);

    String[] nameParsing = data.name.split(":");
    String modId = nameParsing[0];
    String name = nameParsing[1];

    if (modId != null && name != null) {
      Item item = GameRegistry.findItem(modId, name);

      if (data.maxStackSize != null) {
        int size = Util.range(data.maxStackSize, 1, 64);

        item.setMaxStackSize(size);
      }
    }

    return true;
  }

  public static boolean changeItem(Cfg_change_item[] data) {
    int i;

    for (i = 0; i < data.length; i++) {
      boolean tweaked = changeItem(data[i]);

      if (!tweaked) {
        LogHelper.error("Failed to tweak: Item " + i);
        return false;
      }
    }

    return true;
  }

  private static boolean changeFood(Cfg_change_food data) {
    LogHelper.info("Registering Food Change: " + data.name, 1);

    String[] nameParsing = data.name.split(":");
    String modId = nameParsing[0];
    String name = nameParsing[1];

    ItemFood food = (ItemFood) GameRegistry.findItem(modId, name);

    // Dev
    ObfuscationReflectionHelper.setPrivateValue(ItemFood.class, food, data.healAmount, "healAmount");
    ObfuscationReflectionHelper.setPrivateValue(ItemFood.class, food, data.saturationModifier, "saturationModifier");
    ObfuscationReflectionHelper.setPrivateValue(ItemFood.class, food, data.isWolfFood, "isWolfsFavoriteMeat");

    // Release
    /*
     * ObfuscationReflectionHelper.setPrivateValue(ItemFood.class, food,
     * data.healAmount, "field_77853_b");
     * ObfuscationReflectionHelper.setPrivateValue(ItemFood.class, food,
     * data.saturationModifier, "field_77854_c");
     * ObfuscationReflectionHelper.setPrivateValue(ItemFood.class, food,
     * data.isWolfFood, "field_77856_bY");
     */

    if (data.alwaysEdible) {
      food.setAlwaysEdible();
    }

    if (data.potionEffect != null) {
      food.setPotionEffect(Util.potionEffectId(data.potionEffect.effect), data.potionEffect.potionDuration,
          data.potionEffect.potionAmplifier, data.potionEffect.potionEffectProbability);
    }

    if (data.maxStackSize != null) {
      int size = Util.range(data.maxStackSize, 1, 64);

      food.setMaxStackSize(size);
    }

    return true;
  }

  public static boolean changeFood(Cfg_change_food[] data) {
    int i;

    for (i = 0; i < data.length; i++) {
      boolean tweaked = changeFood(data[i]);

      if (!tweaked) {
        LogHelper.error("Failed to tweak: food " + i);
        return false;
      }
    }

    return true;
  }
}
