package me.otho.customItems.mod.blocks;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import me.otho.customItems.CustomItems;
import net.minecraft.block.BlockCarpet;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class CustomCarpetBlock extends BlockCarpet implements IMMBlock {

    public CustomCarpetBlock() {
        this.setCreativeTab(null);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item p_149666_1_, CreativeTabs p_149666_2_, List p_149666_3_) {
        p_149666_3_.add(new ItemStack(p_149666_1_, 1, 0));
    }

    private IIcon[] icons = new IIcon[6];
    private boolean canSilkHarvest;

    private int maxItemDrop;

    private int minItemDrop;
    private int eachExtraItemDropChance;

    protected String dropItem;

    private String[] textureNames;
    protected boolean breaks;

    @Override
    @SideOnly(Side.CLIENT)
    public int getRenderBlockPass() {
        return 0;
    }

    public void setCanSilkHarvest(boolean canSilkHarvest) {
        this.canSilkHarvest = canSilkHarvest;
    }

    @Override
    public IIcon getIcon(int side, int meta) {
        if (this.textureName != null) {
            return blockIcon;
        } else {
            return icons[side];
        }
    }

    @Override
    public String getUnlocalizedName() {
        return super.getUnlocalizedName();
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister) {
        if (textureNames == null) {
            blockIcon = iconRegister.registerIcon(CustomItems.MOD_ID.toLowerCase() + ":" + this.textureName);
        } else {
            for (int i = 0; i < icons.length; i++) {
                icons[i] = iconRegister.registerIcon(CustomItems.MOD_ID.toLowerCase() + ":" + textureNames[i]);
            }
        }
    }

    public void registerBlockTextures(String[] textureNames) {
        this.textureNames = textureNames;
    }

    @Override
    public boolean canSilkHarvest() {
        return this.canSilkHarvest;
    }

    public void setBreaks(boolean breaks) {
        this.breaks = breaks;
    }

    @Override
    public void setCollides(boolean collides) {
        // TODO Auto-generated method stub

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
