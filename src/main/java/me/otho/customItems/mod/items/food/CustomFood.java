package me.otho.customItems.mod.items.food;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import me.otho.customItems.CustomItems;
import me.otho.customItems.configuration.jsonReaders.common.Cfg_PotionEffect;
import me.otho.customItems.utility.Util;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class CustomFood extends ItemFood {

  private ItemStack dropStack;
  private EnumAction useAction = EnumAction.eat;
  private Cfg_PotionEffect[] effectsArray;

  public CustomFood(int healAmount, float saturationModifier, boolean isWolfsFavoriteMeat) {
    super(healAmount, saturationModifier, isWolfsFavoriteMeat);
  }

  @Override
  public String getUnlocalizedName() {
    return super.getUnlocalizedName();
  }

  @Override
  @SideOnly(Side.CLIENT)
  public void registerIcons(IIconRegister iconRegister) {
    itemIcon = iconRegister.registerIcon(CustomItems.MOD_ID.toLowerCase() + ":" + this.iconString);
  }

  @Override
  protected void onFoodEaten(ItemStack p_77849_1_, World p_77849_2_, EntityPlayer p_77849_3_) {
    if (!p_77849_2_.isRemote) {
      if (effectsArray != null) {
        for (int i = 0; i < effectsArray.length; i++) {
          Cfg_PotionEffect effect = effectsArray[i];
          if (p_77849_2_.rand.nextFloat() < effect.potionEffectProbability) {
            p_77849_3_.addPotionEffect(new PotionEffect(Util.potionEffectId(effect.effect), effect.potionDuration * 20,
                effect.potionAmplifier));
          }
        }
      }
    }
  }

  @Override
  public ItemStack onEaten(ItemStack p_77654_1_, World p_77654_2_, EntityPlayer p_77654_3_) {
    if (dropStack != null) {
      boolean addedToInventory = p_77654_3_.inventory.addItemStackToInventory(dropStack.copy());
      if (!p_77654_2_.isRemote) {
        if (!addedToInventory) {
          double x = p_77654_3_.posX;
          double y = p_77654_3_.posY;
          double z = p_77654_3_.posZ;

          float f = 0.7F;
          double d0 = p_77654_2_.rand.nextFloat() * f + (1.0F - f) * 0.5D;
          double d1 = p_77654_2_.rand.nextFloat() * f + (1.0F - f) * 0.5D;
          double d2 = p_77654_2_.rand.nextFloat() * f + (1.0F - f) * 0.5D;
          EntityItem entityitem = new EntityItem(p_77654_2_, x, y, z, dropStack.copy());
          entityitem.delayBeforeCanPickup = 10;
          p_77654_2_.spawnEntityInWorld(entityitem);
        }
      }
    }

    return super.onEaten(p_77654_1_, p_77654_2_, p_77654_3_);
  }

  public void setFoodEffectsArray(Cfg_PotionEffect[] effectsArray) {
    this.effectsArray = effectsArray;
  }

  public void setUseAction(String useAction) {
    if (Util.isInEnum(useAction.toLowerCase(), EnumAction.class)) {
      this.useAction = EnumAction.valueOf(useAction.toLowerCase());
    } else {
      this.useAction = EnumAction.eat;
    }
  }

  public void setDropStack(ItemStack dropStack) {
    this.dropStack = dropStack;
  }

  @Override
  public EnumAction getItemUseAction(ItemStack p_77661_1_) {
    return useAction;
  }

}
