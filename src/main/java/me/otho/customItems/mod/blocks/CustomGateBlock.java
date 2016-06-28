package me.otho.customItems.mod.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import me.otho.customItems.CustomItems;
import net.minecraft.block.BlockFenceGate;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;

public class CustomGateBlock extends BlockFenceGate implements IMMBlock {
  public CustomGateBlock() {
    this.setCreativeTab(null);
  }

  private IIcon[] icons = new IIcon[6];

  private String[] textureNames;
  protected boolean breaks;

  private boolean canSilkHarvest;

  @Override
  @SideOnly(Side.CLIENT)
  public int getRenderBlockPass() {
    return 1;
  }

  @Override
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

  @Override
  public void registerBlockTextures(String[] textureNames) {
    this.textureNames = textureNames;
  }

  @Override
  public boolean canSilkHarvest() {
    return this.canSilkHarvest;
  }

  @Override
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
