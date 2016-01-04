package me.otho.customItems.registry;

import cpw.mods.fml.common.registry.GameRegistry;
import me.otho.customItems.configuration.jsonReaders.common.Cfg_creativeTab;
import me.otho.customItems.mod.creativeTab.customItemsTab;
import me.otho.customItems.utility.LogHelper;
import net.minecraft.item.Item;

public class CommonRegistry {

    // Common
    public static boolean registerCreativeTabs(Cfg_creativeTab data) {
        LogHelper.info("Registering Creative Tab: " + data.tabLabel, 1);
        String[] itemName = data.iconItem.split(":");
        Item iconItem = GameRegistry.findItem(itemName[0], itemName[1]);

        customItemsTab tab = new customItemsTab(iconItem, data.tabLabel);
        customItemsTab.registerCreativeTab(tab);

        return true;
    }

    public static boolean registerCreativeTabs(Cfg_creativeTab[] data) {
        int i;

        if (data != null) {
            for (i = 0; i < data.length; i++) {
                boolean registered = registerCreativeTabs(data[i]);

                if (!registered) {
                    LogHelper.error("Failed to register: CreativeTabs " + data[i].tabLabel);
                    return false;
                }
            }
        }

        return true;
    }
}
