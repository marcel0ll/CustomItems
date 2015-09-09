package me.otho.customItems.mod.items;

import me.otho.customItems.reference.Reference;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemSeeds;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class CustomSeed extends ItemSeeds {

    public CustomSeed(Block plant) {
        super(plant, Blocks.farmland);
    }

    @Override
    public String getUnlocalizedName() {
        return super.getUnlocalizedName();
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister) {
        itemIcon = iconRegister.registerIcon(Reference.MOD_ID.toLowerCase() + ":" + this.iconString);
    }
}
