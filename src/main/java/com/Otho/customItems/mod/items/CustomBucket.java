package com.Otho.customItems.mod.items;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemBucket;

import com.Otho.customItems.ModReference;
import com.Otho.customItems.mod.blocks.CustomFluidBlock;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class CustomBucket extends ItemBucket {
    public CustomBucket(CustomFluidBlock fluid) {
        super(fluid);        
    }
    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister) {
    	if(this.iconString == null)
    	{
    		itemIcon = iconRegister.registerIcon(this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".")+1));
    	}else
    	{
    		itemIcon = iconRegister.registerIcon(ModReference.MOD_ID.toLowerCase() + ":" + this.iconString);
    	}
    }
}
