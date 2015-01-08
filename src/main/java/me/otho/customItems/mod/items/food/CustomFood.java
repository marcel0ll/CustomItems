package me.otho.customItems.mod.items.food;

import me.otho.customItems.ModReference;
import me.otho.customItems.configuration.jsonReaders.common.Cfg_PotionEffect;
import me.otho.customItems.util.Util;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class CustomFood extends ItemFood{
	
	private EnumAction useAction = EnumAction.eat;
	private Cfg_PotionEffect[] effectsArray;
	
	public CustomFood (int healAmount, float saturationModifier, boolean isWolfsFavoriteMeat){
		super(healAmount, saturationModifier, isWolfsFavoriteMeat);   
	}
	
	@Override
    public String getUnlocalizedName() {
        return super.getUnlocalizedName();
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister) {
    	itemIcon = iconRegister.registerIcon(ModReference.MOD_ID.toLowerCase() + ":" + this.iconString);
    }
    
    @Override
    protected void onFoodEaten(ItemStack p_77849_1_, World p_77849_2_, EntityPlayer p_77849_3_)
    {
        if (!p_77849_2_.isRemote)
        {        	
        	if(effectsArray != null)
        	{
	        	for(int i = 0; i < effectsArray.length; i++){
	        		Cfg_PotionEffect effect = effectsArray[i];
	        		if(p_77849_2_.rand.nextFloat() < effect.potionEffectProbability){
	        			p_77849_3_.addPotionEffect(new PotionEffect(Util.potionEffectId(effect.effect), effect.potionDuration * 20, effect.potionAmplifier));
	        		}
	        	}
        	}
        }
    }
    
    public void setFoodEffectsArray(Cfg_PotionEffect[] effectsArray){
    	this.effectsArray = effectsArray;
    }
    
    public void setUseAction(String useAction){
    	if(Util.isInEnum(useAction.toLowerCase(), EnumAction.class)){
    		this.useAction = EnumAction.valueOf(useAction.toLowerCase());
    	}else
    	{
    		this.useAction = EnumAction.eat;
    	}
    }
    
    @Override
    public EnumAction getItemUseAction(ItemStack p_77661_1_)
    {
        return useAction;
    }

}
