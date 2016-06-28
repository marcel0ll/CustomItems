package me.otho.customItems.registry;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import me.otho.customItems.configuration.jsonReaders.items.Cfg_item;
import me.otho.customItems.configuration.jsonReaders.items.armor.Cfg_boots;
import me.otho.customItems.configuration.jsonReaders.items.armor.Cfg_chestplate;
import me.otho.customItems.configuration.jsonReaders.items.armor.Cfg_helmet;
import me.otho.customItems.configuration.jsonReaders.items.armor.Cfg_leggings;
import me.otho.customItems.configuration.jsonReaders.items.food.Cfg_food;
import me.otho.customItems.configuration.jsonReaders.items.tools.Cfg_axe;
import me.otho.customItems.configuration.jsonReaders.items.tools.Cfg_hammer;
import me.otho.customItems.configuration.jsonReaders.items.tools.Cfg_hoe;
import me.otho.customItems.configuration.jsonReaders.items.tools.Cfg_pickaxe;
import me.otho.customItems.configuration.jsonReaders.items.tools.Cfg_shovel;
import me.otho.customItems.configuration.jsonReaders.items.tools.Cfg_sword;
import me.otho.customItems.mod.items.CustomItem;
import me.otho.customItems.mod.items.armor.CustomArmor;
import me.otho.customItems.mod.items.food.CustomFood;
import me.otho.customItems.mod.items.tools.CustomAxe;
import me.otho.customItems.mod.items.tools.CustomHammer;
import me.otho.customItems.mod.items.tools.CustomHoe;
import me.otho.customItems.mod.items.tools.CustomPickaxe;
import me.otho.customItems.mod.items.tools.CustomShovel;
import me.otho.customItems.mod.items.tools.CustomSword;
import me.otho.customItems.utility.LogHelper;
import me.otho.customItems.utility.Util;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;

public class ItemRegistry {

  public static boolean registerAxe(Cfg_axe data) {
    LogHelper.info("Registering Axe: " + data.name, 1);

    String registerName = Util.parseRegisterName(data.name);

    Item.ToolMaterial material = EnumHelper.addToolMaterial(data.textureName, data.harvestLevel, data.maxUses,
        data.efficiencyOnProperMaterial, data.damageVsEntity, data.enchantability);

    CustomAxe axe = new CustomAxe(material);

    Registry.itemsList.add(axe);
    Registry.itemsList.add(data.creativeTab);

    axe.setTextureName(data.textureName);
    GameRegistry.registerItem(axe, registerName);
    axe.setUnlocalizedName(Registry.mod_id.toLowerCase() + ":" + registerName);
    LanguageRegistry.instance().addStringLocalization(axe.getUnlocalizedName() + ".name", "en_US",
        data.name.substring(0, 1).toUpperCase() + data.name.substring(1));

    return true;
  }

  public static boolean registerHammer(Cfg_hammer data) {
    LogHelper.info("Registering Hammer: " + data.name, 1);

    String registerName = Util.parseRegisterName(data.name);

    Item.ToolMaterial material = EnumHelper.addToolMaterial(data.textureName, data.harvestLevel, data.maxUses,
        data.efficiencyOnProperMaterial, data.damageVsEntity, data.enchantability);

    CustomHammer hammer = new CustomHammer(material);

    Registry.itemsList.add(hammer);
    Registry.itemsList.add(data.creativeTab);

    hammer.setTextureName(data.textureName);
    GameRegistry.registerItem(hammer, registerName);
    hammer.setUnlocalizedName(Registry.mod_id.toLowerCase() + ":" + registerName);
    LanguageRegistry.instance().addStringLocalization(hammer.getUnlocalizedName() + ".name", "en_US",
        data.name.substring(0, 1).toUpperCase() + data.name.substring(1));

    return true;
  }

  public static boolean registerBoots(Cfg_boots data) {
    LogHelper.info("Registering Boots: " + data.name, 1);

    String registerName = Util.parseRegisterName(data.name);

    // Make Custom Armor
    int reduction[] = { 0, 0, 0, 0 };
    reduction[3] = data.reduction;

    ItemArmor.ArmorMaterial material = EnumHelper.addArmorMaterial(data.textureName, data.durability, reduction,
        data.enchantability);
    CustomArmor armor = new CustomArmor(material, 0, 3, data.textureName, data.durability);
    // Register Armor

    Registry.itemsList.add(armor);
    Registry.itemsList.add(data.creativeTab);

    armor.setTextureName(data.textureName);
    GameRegistry.registerItem(armor, registerName);
    armor.setUnlocalizedName(Registry.mod_id.toLowerCase() + ":" + registerName);
    LanguageRegistry.instance().addStringLocalization(armor.getUnlocalizedName() + ".name", "en_US",
        data.name.substring(0, 1).toUpperCase() + data.name.substring(1));
    return false;
  }

  public static boolean registerChestplate(Cfg_chestplate data) {
    LogHelper.info("Registering Chestplate: " + data.name, 1);

    String registerName = Util.parseRegisterName(data.name);

    // Make Custom Armor
    int reduction[] = { 0, 0, 0, 0 };
    reduction[1] = data.reduction;

    ItemArmor.ArmorMaterial material = EnumHelper.addArmorMaterial(data.textureName, data.durability, reduction,
        data.enchantability);
    CustomArmor armor = new CustomArmor(material, 0, 1, data.textureName, data.durability);
    // Register Armor

    Registry.itemsList.add(armor);
    Registry.itemsList.add(data.creativeTab);

    armor.setTextureName(data.textureName);
    GameRegistry.registerItem(armor, registerName);
    armor.setUnlocalizedName(Registry.mod_id.toLowerCase() + ":" + registerName);
    LanguageRegistry.instance().addStringLocalization(armor.getUnlocalizedName() + ".name", "en_US",
        data.name.substring(0, 1).toUpperCase() + data.name.substring(1));

    return false;
  }

  public static boolean registerFood(Cfg_food data) {
    LogHelper.info("Registering Food: " + data.name, 1);

    String registerName = Util.parseRegisterName(data.name);

    CustomFood food = new CustomFood(data.healAmount, data.saturationModifier, data.isWolfFood);

    if (data.alwaysEdible) {
      food.setAlwaysEdible();
    }

    if (data.potionEffects != null) {
      if (data.potionEffects.length > 0) {
        food.setFoodEffectsArray(data.potionEffects);
      }
    }

    if (data.dropItemName != null) {
      String[] parser = data.dropItemName.split(":");
      String modId = parser[0];
      String name = parser[1];
      int damage = 0;
      if (parser.length > 2) {
        damage = Integer.parseInt(parser[2]);
      }

      food.setDropStack(new ItemStack(GameRegistry.findItem(modId, name), 1, damage));
    }
    food.setUseAction(data.useAction);

    Registry.itemsList.add(food);
    Registry.itemsList.add(data.creativeTab);

    GameRegistry.registerItem(food, registerName);
    food.setUnlocalizedName(Registry.mod_id.toLowerCase() + ":" + registerName);
    food.setTextureName(data.textureName);
    LanguageRegistry.instance().addStringLocalization(food.getUnlocalizedName() + ".name", "en_US", data.name);

    return false;
  }

  public static boolean registerHelmet(Cfg_helmet data) {
    LogHelper.info("Registering Helmet: " + data.name, 1);

    String registerName = Util.parseRegisterName(data.name);

    // Make Custom Armor
    int reduction[] = { 0, 0, 0, 0 };
    reduction[0] = data.reduction;

    ItemArmor.ArmorMaterial material = EnumHelper.addArmorMaterial(data.textureName, data.durability, reduction,
        data.enchantability);
    CustomArmor armor = new CustomArmor(material, 0, 0, data.textureName, data.durability);
    // Register Armor

    Registry.itemsList.add(armor);
    Registry.itemsList.add(data.creativeTab);

    armor.setTextureName(data.textureName);
    GameRegistry.registerItem(armor, registerName);
    armor.setUnlocalizedName(Registry.mod_id.toLowerCase() + ":" + registerName);
    LanguageRegistry.instance().addStringLocalization(armor.getUnlocalizedName() + ".name", "en_US",
        data.name.substring(0, 1).toUpperCase() + data.name.substring(1));

    return false;
  }

  public static boolean registerHoe(Cfg_hoe data) {
    LogHelper.info("Registering Hoe: " + data.name, 1);

    String registerName = Util.parseRegisterName(data.name);

    Item.ToolMaterial material = EnumHelper.addToolMaterial(data.textureName, data.harvestLevel, data.maxUses,
        data.efficiencyOnProperMaterial, data.damageVsEntity, data.enchantability);

    CustomHoe hoe = new CustomHoe(material);

    Registry.itemsList.add(hoe);
    Registry.itemsList.add(data.creativeTab);

    hoe.setTextureName(data.textureName);
    GameRegistry.registerItem(hoe, registerName);
    hoe.setUnlocalizedName(Registry.mod_id.toLowerCase() + ":" + registerName);
    LanguageRegistry.instance().addStringLocalization(hoe.getUnlocalizedName() + ".name", "en_US",
        data.name.substring(0, 1).toUpperCase() + data.name.substring(1));

    return true;
  }

  public static boolean registerItem(Cfg_item data) {
    LogHelper.info("Registering Item: " + data.name, 1);

    String registerName = Util.parseRegisterName(data.name);

    CustomItem item = new CustomItem(data.maxStackSize);

    item.setGlows(data.glows);

    Registry.itemsList.add(item);
    Registry.itemsList.add(data.creativeTab);

    GameRegistry.registerItem(item, registerName);
    item.setUnlocalizedName(Registry.mod_id.toLowerCase() + ":" + registerName);
    item.setTextureName(data.textureName);
    LanguageRegistry.instance().addStringLocalization(item.getUnlocalizedName() + ".name", "en_US", data.name);

    return false;
  }

  public static boolean registerLeggings(Cfg_leggings data) {
    LogHelper.info("Registering Leggings: " + data.name, 1);

    String registerName = Util.parseRegisterName(data.name);

    // Make Custom Armor
    int reduction[] = { 0, 0, 0, 0 };
    reduction[2] = data.reduction;

    ItemArmor.ArmorMaterial material = EnumHelper.addArmorMaterial(data.textureName, data.durability, reduction,
        data.enchantability);
    CustomArmor armor = new CustomArmor(material, 0, 2, data.textureName, data.durability);
    // Register Armor

    Registry.itemsList.add(armor);
    Registry.itemsList.add(data.creativeTab);

    armor.setTextureName(data.textureName);
    GameRegistry.registerItem(armor, registerName);
    armor.setUnlocalizedName(Registry.mod_id.toLowerCase() + ":" + registerName);
    LanguageRegistry.instance().addStringLocalization(armor.getUnlocalizedName() + ".name", "en_US",
        data.name.substring(0, 1).toUpperCase() + data.name.substring(1));

    return true;
  }

  public static boolean registerPickaxe(Cfg_pickaxe data) {
    LogHelper.info("Registering Pickaxe: " + data.name, 1);

    String registerName = Util.parseRegisterName(data.name);

    Item.ToolMaterial material = EnumHelper.addToolMaterial(data.textureName, data.harvestLevel, data.maxUses,
        data.efficiencyOnProperMaterial, data.damageVsEntity, data.enchantability);

    CustomPickaxe pickaxe = new CustomPickaxe(material);

    pickaxe.setTextureName(data.textureName);
    Registry.itemsList.add(pickaxe);
    Registry.itemsList.add(data.creativeTab);

    GameRegistry.registerItem(pickaxe, registerName);
    pickaxe.setUnlocalizedName(Registry.mod_id.toLowerCase() + ":" + registerName);
    LanguageRegistry.instance().addStringLocalization(pickaxe.getUnlocalizedName() + ".name", "en_US",
        data.name.substring(0, 1).toUpperCase() + data.name.substring(1));

    return true;
  }

  public static boolean registerShovel(Cfg_shovel data) {
    LogHelper.info("Registering Shovel: " + data.name, 1);

    String registerName = Util.parseRegisterName(data.name);

    Item.ToolMaterial material = EnumHelper.addToolMaterial(data.textureName, data.harvestLevel, data.maxUses,
        data.efficiencyOnProperMaterial, data.damageVsEntity, data.enchantability);

    CustomShovel shovel = new CustomShovel(material);

    shovel.setTextureName(data.textureName);
    Registry.itemsList.add(shovel);
    Registry.itemsList.add(data.creativeTab);

    GameRegistry.registerItem(shovel, registerName);
    shovel.setUnlocalizedName(Registry.mod_id.toLowerCase() + ":" + registerName);
    LanguageRegistry.instance().addStringLocalization(shovel.getUnlocalizedName() + ".name", "en_US",
        data.name.substring(0, 1).toUpperCase() + data.name.substring(1));

    return true;
  }

  public static boolean registerSword(Cfg_sword data) {
    LogHelper.info("Registering Sword: " + data.name, 1);

    String registerName = Util.parseRegisterName(data.name);

    Item.ToolMaterial material = EnumHelper.addToolMaterial(data.textureName, data.harvestLevel, data.maxUses,
        data.efficiencyOnProperMaterial, data.damageVsEntity, data.enchantability);

    CustomSword sword = new CustomSword(material);

    sword.setTextureName(data.textureName);
    Registry.itemsList.add(sword);
    Registry.itemsList.add(data.creativeTab);

    GameRegistry.registerItem(sword, registerName);
    sword.setUnlocalizedName(Registry.mod_id.toLowerCase() + ":" + registerName);
    LanguageRegistry.instance().addStringLocalization(sword.getUnlocalizedName() + ".name", "en_US",
        data.name.substring(0, 1).toUpperCase() + data.name.substring(1));

    return true;
  }
}
