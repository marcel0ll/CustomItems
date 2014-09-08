package com.Otho.customItems.mod.blocks;

import com.Otho.customItems.mod.creativeTab.customItemsTab;


import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;

public class CustomBlock extends Block {
    public CustomBlock() {
        this(Material.rock);
    }
    public CustomBlock(Material material) {
        super(material);
        this.setCreativeTab(customItemsTab.customItemsTab);
    }

    @Override
    public String getUnlocalizedName() {
        return super.getUnlocalizedName();
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister) {
        blockIcon = iconRegister.registerIcon(this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".")+1));
    }
}
