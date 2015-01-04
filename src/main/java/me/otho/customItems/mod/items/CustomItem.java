package me.otho.customItems.mod.items;

import me.otho.customItems.ModReference;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class CustomItem extends Item {
    public CustomItem(int stackSize) {
        super();        
        this.setMaxStackSize(stackSize);
    }

    @Override
    public String getUnlocalizedName() {
        return super.getUnlocalizedName();
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister) {    	
    	itemIcon = iconRegister.registerIcon(ModReference.MOD_ID.toLowerCase() + ":" + this.iconString);
    }

}