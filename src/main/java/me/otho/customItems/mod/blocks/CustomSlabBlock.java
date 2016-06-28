package me.otho.customItems.mod.blocks;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import me.otho.customItems.CustomItems;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Facing;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class CustomSlabBlock extends CustomBlock {

  public final boolean doubleSlab;
  public final String name;

  public CustomSlabBlock(boolean p_i45410_1_, Material p_i45410_2_, String name) {
    super(p_i45410_2_);
    this.doubleSlab = p_i45410_1_;
    this.name = name;

    if (p_i45410_1_) {
      this.opaque = true;
    } else {
      this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
    }

    this.useNeighborBrightness = true;
    this.setLightOpacity(255);
  }

  @Override
  public void setOpaque(boolean isOpaque) {
    this.opaque = isOpaque;
  }

  @Override
  public int getLightOpacity() {
    if (this.opaque) {
      return 255;
    } else {
      return 0;
    }
  }

  @Override
  public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int metadata, int fortune) {
    ArrayList<ItemStack> drops = new ArrayList();

    if (dropItem != null) {
      String[] parser = dropItem.split(":");
      Item item = GameRegistry.findItem(parser[0], parser[1]);

      if (item != null) {
        int itemQuantity = getItemDropQuantity(world, fortune);
        int damage;

        if (parser.length > 2) {
          damage = Integer.parseInt(parser[2]);
        } else {
          damage = 0;
        }

      }
    } else {
      if (!breaks) {
        Item drop = Item.getItemFromBlock(GameRegistry.findBlock(CustomItems.MOD_ID, this.name));
        if (doubleSlab) {
          drops.add(new ItemStack(drop, 2));
        } else {
          drops.add(new ItemStack(drop));
        }
      }
    }

    return drops;
  }

  /**
   * Updates the blocks bounds based on its current state. Args: world, x, y, z
   */
  @Override
  public void setBlockBoundsBasedOnState(IBlockAccess p_149719_1_, int p_149719_2_, int p_149719_3_, int p_149719_4_) {
    if (this.doubleSlab) {
      this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
    } else {
      boolean flag = (p_149719_1_.getBlockMetadata(p_149719_2_, p_149719_3_, p_149719_4_) & 8) != 0;

      if (flag) {
        this.setBlockBounds(0.0F, 0.5F, 0.0F, 1.0F, 1.0F, 1.0F);
      } else {
        this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
      }
    }
  }

  /**
   * Sets the block's bounds for rendering it as an item
   */
  @Override
  public void setBlockBoundsForItemRender() {
    if (this.doubleSlab) {
      this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
    } else {
      this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
    }
  }

  /**
   * Adds all intersecting collision boxes to a list. (Be sure to only add boxes
   * to the list if they intersect the mask.) Parameters: World, X, Y, Z, mask,
   * list, colliding entity
   */
  @Override
  public void addCollisionBoxesToList(World p_149743_1_, int p_149743_2_, int p_149743_3_, int p_149743_4_,
      AxisAlignedBB p_149743_5_, List p_149743_6_, Entity p_149743_7_) {
    this.setBlockBoundsBasedOnState(p_149743_1_, p_149743_2_, p_149743_3_, p_149743_4_);
    super.addCollisionBoxesToList(p_149743_1_, p_149743_2_, p_149743_3_, p_149743_4_, p_149743_5_, p_149743_6_,
        p_149743_7_);
  }

  /**
   * Is this block (a) opaque and (b) a full 1m cube? This determines whether or
   * not to render the shared face of two adjacent blocks and also whether the
   * player can attach torches, redstone wire, etc to this block.
   */
  @Override
  public boolean isOpaqueCube() {
    if (!this.doubleSlab) {
      return false;
    } else {
      return this.opaque;
    }
  }

  /**
   * Called when a block is placed using its ItemBlock. Args: World, X, Y, Z,
   * side, hitX, hitY, hitZ, block metadata
   */
  @Override
  public int onBlockPlaced(World par1World, int blockX, int blockY, int blockZ, int side, float clickX, float clickY,
      float clickZ, int metadata) {
    if (side == 1) {
      return metadata;
    }
    if (side == 0 || clickY >= 0.5F) {
      return metadata | 8;
    }

    return metadata;
  }

  /**
   * Returns the quantity of items to drop on block destruction.
   */
  @Override
  public int quantityDropped(Random p_149745_1_) {
    return this.doubleSlab ? 2 : 1;
  }

  /**
   * Determines the damage on the item the block drops. Used in cloth and wood.
   */
  // public int damageDropped(int p_149692_1_)
  // {
  // return p_149692_1_ & 7;
  // }

  /**
   * If this block doesn't render as an ordinary block it will return False
   * (examples: signs, buttons, stairs, etc)
   */
  @Override
  public boolean renderAsNormalBlock() {
    return this.doubleSlab;
  }

  /**
   * Returns true if the given side of this block type should be rendered, if
   * the adjacent block is at the given coordinates. Args: blockAccess, x, y, z,
   * side
   */
  @Override
  @SideOnly(Side.CLIENT)
  public boolean shouldSideBeRendered(IBlockAccess p_149646_1_, int p_149646_2_, int p_149646_3_, int p_149646_4_,
      int p_149646_5_) {
    if (this.doubleSlab) {
      return super.shouldSideBeRendered(p_149646_1_, p_149646_2_, p_149646_3_, p_149646_4_, p_149646_5_);
    } else if (p_149646_5_ != 1 && p_149646_5_ != 0
        && !super.shouldSideBeRendered(p_149646_1_, p_149646_2_, p_149646_3_, p_149646_4_, p_149646_5_)) {
      return false;
    } else {
      int i1 = p_149646_2_ + Facing.offsetsXForSide[Facing.oppositeSide[p_149646_5_]];
      int j1 = p_149646_3_ + Facing.offsetsYForSide[Facing.oppositeSide[p_149646_5_]];
      int k1 = p_149646_4_ + Facing.offsetsZForSide[Facing.oppositeSide[p_149646_5_]];
      boolean flag = (p_149646_1_.getBlockMetadata(i1, j1, k1) & 8) != 0;
      return flag
          ? (p_149646_5_ == 0 ? true
              : (p_149646_5_ == 1
                  && super.shouldSideBeRendered(p_149646_1_, p_149646_2_, p_149646_3_, p_149646_4_, p_149646_5_)
                      ? true
                      : !func_150003_a(p_149646_1_.getBlock(p_149646_2_, p_149646_3_, p_149646_4_))
                          || (p_149646_1_.getBlockMetadata(p_149646_2_, p_149646_3_, p_149646_4_) & 8) == 0))
          : (p_149646_5_ == 1 ? true
              : (p_149646_5_ == 0
                  && super.shouldSideBeRendered(p_149646_1_, p_149646_2_, p_149646_3_, p_149646_4_, p_149646_5_) ? true
                      : !func_150003_a(p_149646_1_.getBlock(p_149646_2_, p_149646_3_, p_149646_4_))
                          || (p_149646_1_.getBlockMetadata(p_149646_2_, p_149646_3_, p_149646_4_) & 8) != 0));
    }
  }

  @SideOnly(Side.CLIENT)
  private static boolean func_150003_a(Block p_150003_0_) {
    if (p_150003_0_ instanceof CustomSlabBlock) {
      CustomSlabBlock block = (CustomSlabBlock) p_150003_0_;
      return block.doubleSlab;
    } else {
      return false;
    }

  }

  /**
   * Gets an item for the block being called on. Args: world, x, y, z
   */
  @Override
  @SideOnly(Side.CLIENT)
  public Item getItem(World p_149694_1_, int p_149694_2_, int p_149694_3_, int p_149694_4_) {
    return Item.getItemFromBlock(GameRegistry.findBlock(CustomItems.MOD_ID, this.name));
  }

}
