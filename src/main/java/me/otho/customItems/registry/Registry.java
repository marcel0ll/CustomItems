package me.otho.customItems.registry;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import me.otho.customItems.configuration.JsonSchema;
import me.otho.customItems.configuration.jsonReaders.blocks.Cfg_block;
import me.otho.customItems.configuration.jsonReaders.blocks.Cfg_crop;
import me.otho.customItems.configuration.jsonReaders.blocks.Cfg_fluid;
import me.otho.customItems.configuration.jsonReaders.common.Cfg_basicData;
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
import me.otho.customItems.configuration.jsonReaders.tileEntity.Cfg_chest;
import me.otho.customItems.mod.creativeTab.customItemsTab;
import me.otho.customItems.reference.Reference;
import me.otho.customItems.utility.LogHelper;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

import org.apache.logging.log4j.Level;

import cpw.mods.fml.common.Loader;

public class Registry {

    public static ArrayList<Object> itemsList = new ArrayList();
    public static ArrayList<Object> blocksList = new ArrayList();

    public static String mod_id = Reference.MOD_ID;
    public static String mod_name = Reference.MOD_NAME;

    public static int registerId = -1;

    private static void setCreativeTabs() {
        int i;

        for (i = 0; i < itemsList.size(); i += 2) {
            Item item = (Item) itemsList.get(i);
            CreativeTabs tab = customItemsTab.getTabByName((String) itemsList.get(i + 1));
            if (tab != null)
                item.setCreativeTab(tab);
        }

        for (i = 0; i < blocksList.size(); i += 2) {
            Block block = (Block) blocksList.get(i);
            CreativeTabs tab = customItemsTab.getTabByName((String) blocksList.get(i + 1));
            if (tab != null)
                block.setCreativeTab(tab);
        }
    }

    private static void mergeArrays(ArrayList<Cfg_basicData> arrL, Cfg_basicData[] arr) {
        for (int i = 0; i < arr.length; i++)
            arrL.add(arr[i]);
    }

    public static void register(JsonSchema data) {

        ArrayList<Cfg_basicData> allData = new ArrayList<Cfg_basicData>();

        if (data != null) {
            if (data.blocks != null)
                mergeArrays(allData, (Cfg_basicData[]) data.blocks);
            if (data.chests != null)
                mergeArrays(allData, (Cfg_basicData[]) data.chests);
            if (data.foods != null)
                mergeArrays(allData, (Cfg_basicData[]) data.foods);
            if (data.items != null)
                mergeArrays(allData, (Cfg_basicData[]) data.items);
            if (data.fluids != null)
                mergeArrays(allData, (Cfg_basicData[]) data.fluids);
            if (data.pickaxes != null)
                mergeArrays(allData, (Cfg_basicData[]) data.pickaxes);
            if (data.axes != null)
                mergeArrays(allData, (Cfg_basicData[]) data.axes);
            if (data.hammers != null)
                mergeArrays(allData, (Cfg_basicData[]) data.hammers);
            if (data.shovels != null)
                mergeArrays(allData, (Cfg_basicData[]) data.shovels);
            if (data.hoes != null)
                mergeArrays(allData, (Cfg_basicData[]) data.hoes);
            if (data.swords != null)
                mergeArrays(allData, (Cfg_basicData[]) data.swords);
            if (data.helmets != null)
                mergeArrays(allData, (Cfg_basicData[]) data.helmets);
            if (data.chestplates != null)
                mergeArrays(allData, (Cfg_basicData[]) data.chestplates);
            if (data.leggings != null)
                mergeArrays(allData, (Cfg_basicData[]) data.leggings);
            if (data.boots != null)
                mergeArrays(allData, (Cfg_basicData[]) data.boots);
            if (data.crops != null)
                mergeArrays(allData, (Cfg_basicData[]) data.crops);

            Collections.sort(allData, new Comparator<Cfg_basicData>() {
                @Override
                public int compare(Cfg_basicData d1, Cfg_basicData d2) {
                    return d1.registerOrder.compareTo(d2.registerOrder);
                }
            });

            for (int i = 0; i < allData.size(); i++) {
                LogHelper.log(Level.INFO, allData.get(i).getClass(), 1);

                Cfg_basicData toRegister = allData.get(i);

                try {
                    if (toRegister instanceof Cfg_chest) {
                        TileEntityRegistry.registerChest((Cfg_chest) toRegister);
                    } else if (toRegister instanceof Cfg_block) {
                        // TODO add switch based on block type
                        BlockRegistry.registerBlock((Cfg_block) toRegister);
                    } else if (toRegister instanceof Cfg_food) {
                        ItemRegistry.registerFood((Cfg_food) toRegister);
                    } else if (toRegister instanceof Cfg_item) {
                        ItemRegistry.registerItem((Cfg_item) toRegister);
                    } else if (toRegister instanceof Cfg_fluid) {
                        BlockRegistry.registerFluid((Cfg_fluid) toRegister);
                    } else if (toRegister instanceof Cfg_pickaxe) {
                        ItemRegistry.registerPickaxe((Cfg_pickaxe) toRegister);
                    } else if (toRegister instanceof Cfg_axe) {
                        ItemRegistry.registerAxe((Cfg_axe) toRegister);
                    } else if (toRegister instanceof Cfg_hammer) {
                        ItemRegistry.registerHammer((Cfg_hammer) toRegister);
                    } else if (toRegister instanceof Cfg_shovel) {
                        ItemRegistry.registerShovel((Cfg_shovel) toRegister);
                    } else if (toRegister instanceof Cfg_hoe) {
                        ItemRegistry.registerHoe((Cfg_hoe) toRegister);
                    } else if (toRegister instanceof Cfg_sword) {
                        ItemRegistry.registerSword((Cfg_sword) toRegister);
                    } else if (toRegister instanceof Cfg_helmet) {
                        ItemRegistry.registerHelmet((Cfg_helmet) toRegister);
                    } else if (toRegister instanceof Cfg_chestplate) {
                        ItemRegistry.registerChestplate((Cfg_chestplate) toRegister);
                    } else if (toRegister instanceof Cfg_leggings) {
                        ItemRegistry.registerLeggings((Cfg_leggings) toRegister);
                    } else if (toRegister instanceof Cfg_boots) {
                        ItemRegistry.registerBoots((Cfg_boots) toRegister);
                    } else if (toRegister instanceof Cfg_crop) {
                        BlockRegistry.registerCrop((Cfg_crop) toRegister);
                    }
                } catch (NoClassDefFoundError e) {

                }
            }

            CommonRegistry.registerCreativeTabs(data.creativeTabs);

            if (data.entitiesDrop != null)
                EntityRegistry.registerEntityDrop(data.entitiesDrop);
            if (data.blocksDrop != null)
                BlockRegistry.registerBlockDrop(data.blocksDrop);

            setCreativeTabs();
        }
    }

    public static void change(JsonSchema data) {
        int i;
        LogHelper.info("Starting to change:");
        LogHelper.info("Changing blocks:");
        if (data.changeBlocks != null) {
            TweakerRegistry.changeBlock(data.changeBlocks);
        }

        LogHelper.info("Changing items:");
        if (data.changeItems != null) {
            TweakerRegistry.changeItem(data.changeItems);
        }

        LogHelper.info("Changing foods:");
        if (data.changeFoods != null) {
            TweakerRegistry.changeFood(data.changeFoods);
        }
    }
}