package com.Otho.customItems.mod.items;

import com.Otho.customItems.mod.creativeTab.customItemsTab;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

public class CustomItem extends Item {
    public CustomItem(int stackSize) {
        super();
        this.setCreativeTab(customItemsTab.customItemsTab);
        this.setMaxStackSize(stackSize);
    }

    @Override
    public String getUnlocalizedName() {
        return super.getUnlocalizedName();
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister) {
        itemIcon = iconRegister.registerIcon(this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".")+1));
    }

}