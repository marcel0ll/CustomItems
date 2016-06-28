package me.otho.customItems.mod.items.tools;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import me.otho.customItems.CustomItems;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemPickaxe;

public class CustomPickaxe extends ItemPickaxe {
  public CustomPickaxe(ToolMaterial mat) {
    super(mat);
  }

  @SideOnly(Side.CLIENT)
  @Override
  public void registerIcons(IIconRegister iconRegister) {
    itemIcon = iconRegister.registerIcon(CustomItems.MOD_ID.toLowerCase() + ":" + this.iconString);
  }
}
