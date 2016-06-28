package me.otho.customItems.mod.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import me.otho.customItems.CustomItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;

public class CustomFlowerBlock extends BlockBush implements IMMBlock {

  public CustomFlowerBlock() {
    this.setCreativeTab(null);
  }

  private IIcon[] icons = new IIcon[6];
  private boolean canSilkHarvest;

  private String[] textureNames;
  protected boolean breaks;

  @Override
  @SideOnly(Side.CLIENT)
  public boolean shouldSideBeRendered(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5) {
    Block i1 = par1IBlockAccess.getBlock(par2, par3, par4);
    if (i1 instanceof CustomSlabBlock) {
      return super.shouldSideBeRendered(par1IBlockAccess, par2, par3, par4, par5);
    } else {
      return i1 == this ? false : super.shouldSideBeRendered(par1IBlockAccess, par2, par3, par4, par5);
    }

  }

  @Override
  @SideOnly(Side.CLIENT)
  public int getRenderBlockPass() {
    return 1;
  }

  @Override
  public void setOpaque(boolean isOpaque) {
    this.opaque = isOpaque;
    this.lightOpacity = this.isOpaqueCube() ? 255 : 0;
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
  public boolean renderAsNormalBlock() {
    return false;
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
  public boolean isOpaqueCube() {
    return false;
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
