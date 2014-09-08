package com.Otho.customItems.mod.items.tools;

import com.Otho.customItems.mod.creativeTab.customItemsTab;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemSword;

public class CustomSword extends ItemSword {
    public CustomSword(ToolMaterial mat) {
        super(mat);
        this.setCreativeTab(customItemsTab.customItemsTab);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void registerIcons(IIconRegister register) {
        this.itemIcon = register.registerIcon(this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".")+1));
    }
}
