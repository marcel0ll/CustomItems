package me.otho.customItems.mod.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import me.otho.customItems.CustomItems;
import me.otho.customItems.mod.blocks.CustomFluidBlock;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemBucket;

public class CustomBucket extends ItemBucket {
  public String textureName;

  public CustomBucket(CustomFluidBlock fluid, String textureName) {
    super(fluid);
    this.textureName = textureName;
  }

  @Override
  @SideOnly(Side.CLIENT)
  public void registerIcons(IIconRegister iconRegister) {
    itemIcon = iconRegister.registerIcon(CustomItems.MOD_ID.toLowerCase() + ":" + this.textureName);
  }
}
