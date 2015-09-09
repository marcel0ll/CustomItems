package me.otho.customItems.mod.items.tools;

import me.otho.customItems.reference.Reference;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemSpade;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class CustomShovel extends ItemSpade {
    public CustomShovel(ToolMaterial mat) {
        super(mat);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void registerIcons(IIconRegister iconRegister) {
        itemIcon = iconRegister.registerIcon(Reference.MOD_ID.toLowerCase() + ":" + this.iconString);
    }
}
