package me.otho.customItems.mod.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import me.otho.customItems.reference.Reference;
import net.minecraft.block.BlockButton;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class CustomButtonBlock extends BlockButton implements IMMBlock {

    private IIcon[] icons = new IIcon[6];
    private String[] textureNames;
    public int tickRate;

    public CustomButtonBlock() {
        super(true);
        // TODO Auto-generated constructor stub
    }

    @Override
    public int tickRate(World p_149738_1_) {
        return tickRate;
    }

    @Override
    public void setBreaks(boolean dropsItSelf) {
        // TODO Auto-generated method stub

    }

    @Override
    public void setCanSilkHarvest(boolean canSilkHarvest) {
        // TODO Auto-generated method stub

    }

    @Override
    public void setCollides(boolean collides) {
        // TODO Auto-generated method stub

    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister) {
        if (textureNames == null) {
            blockIcon = iconRegister.registerIcon(Reference.MOD_ID.toLowerCase() + ":" + this.textureName);
        } else {
            for (int i = 0; i < icons.length; i++) {
                icons[i] = iconRegister.registerIcon(Reference.MOD_ID.toLowerCase() + ":" + textureNames[i]);
            }
        }
    }

    public void registerBlockTextures(String[] textureNames) {
        this.textureNames = textureNames;
    }

    @Override
    public void setOpaque(boolean isOpaque) {
        // TODO Auto-generated method stub

    }

    @Override
    public void setDropItem(String dropId) {
        // TODO Auto-generated method stub

    }

    @Override
    public void setMaxItemDrop(int maxDrop) {
        // TODO Auto-generated method stub

    }

    @Override
    public void setMinItemDrop(int minDrop) {
        // TODO Auto-generated method stub

    }

    @Override
    public void setEachExtraItemDropChance(int dropChance) {
        // TODO Auto-generated method stub

    }

}
