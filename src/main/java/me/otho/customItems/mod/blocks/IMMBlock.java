package me.otho.customItems.mod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.Block.SoundType;

public interface IMMBlock {

    public Block setHardness(float hardness);

    public Block setResistance(float resistance);

    public void setBreaks(boolean dropsItSelf);

    public void setCanSilkHarvest(boolean canSilkHarvest);

    public void setCollides(boolean collides);

    public Block setLightLevel(float lightLevel);

    public void setHarvestLevel(String toolClass, int harvestLevel);

    public Block setBlockTextureName(String textureName);

    public void registerBlockTextures(String[] textureNames);

    public void setOpaque(boolean isOpaque);

    public Block setStepSound(SoundType soundType);

    public void setDropItem(String dropId);

    public void setMaxItemDrop(int maxDrop);

    public void setMinItemDrop(int minDrop);

    public void setEachExtraItemDropChance(int dropChance);

    public Block setBlockName(String blockName);

    public String getUnlocalizedName();
}
