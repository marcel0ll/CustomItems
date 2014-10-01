package com.Otho.customItems.mod.items.tools;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;

import com.Otho.customItems.lib.constants;
import com.Otho.customItems.mod.creativeTab.customItemsTab;
import com.Otho.customItems.util.LogHelper;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class CustomSword extends ItemSword {
    public CustomSword(ToolMaterial mat) {
        super(mat);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void registerIcons(IIconRegister iconRegister) {
    	if(this.iconString == null)
    	{
    		itemIcon = iconRegister.registerIcon(this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".")+1));
    	}else
    	{
    		itemIcon = iconRegister.registerIcon(constants.MOD_ID.toLowerCase() + ":" + this.iconString);
    	}
    }
    
//    @Override
//    public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity)
//    {
//    	if(stack.getItemDamage() == stack.getMaxDamage())
//    	{
//    		return true;
//    	}else
//    	{
//    		return false;
//    	}
//        
//    }
    
}
