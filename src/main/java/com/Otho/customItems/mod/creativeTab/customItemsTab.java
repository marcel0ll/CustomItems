package com.Otho.customItems.mod.creativeTab;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

import com.Otho.customItems.lib.constants;

public class customItemsTab {
    public static final CreativeTabs customItemsTab = new CreativeTabs(constants.MOD_ID.toLowerCase()) {
        @Override
        public Item getTabIconItem() {
            return Items.item_frame;
        }
        
        @Override
        public String getTabLabel() {
        	return constants.MOD_NAME;
        };
        
        @Override
        public String getTranslatedTabLabel() {
        	return constants.MOD_NAME;
        };
    };
}
