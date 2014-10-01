package com.Otho.customItems.mod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;

import com.Otho.customItems.lib.constants;
import com.Otho.customItems.mod.creativeTab.customItemsTab;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class CustomBlock extends Block {
    public CustomBlock() {
        this(Material.rock);
    }
    public CustomBlock(Material material) {
        super(material);        
    }

    @Override
    public String getUnlocalizedName() {
        return super.getUnlocalizedName();
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister) {        
        if(this.textureName == null)
    	{
        	blockIcon = iconRegister.registerIcon(this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".")+1));
    	}else
    	{
    		blockIcon = iconRegister.registerIcon(constants.MOD_ID.toLowerCase() + ":" + this.textureName);
    	}
    }
}
