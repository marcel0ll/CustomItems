package com.Otho.customItems.mod.items.armor;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

import com.Otho.customItems.lib.ModReference;
import com.Otho.customItems.mod.creativeTab.customItemsTab;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class CustomArmor extends ItemArmor {
    protected int type;
    private String typeName;
    protected String textureName = "";
    
    public CustomArmor(ArmorMaterial mat, int id,int type, String textureName, int durability) {
        super(mat,id,type);        
        this.type=type;
        this.textureName= textureName;  
        this.setMaxDamage(durability);
        
        if(type == 0){
        	typeName = "helmet";
        }else if(type == 1){
        	typeName = "chestplate";
        }else if(type == 2){
        	typeName = "leggings";
        }else if(type == 3){
        	typeName = "boots";
        }
        
        
    }

    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
        if(stack.getItem() instanceof CustomArmor) {
            String path = ModReference.MOD_ID.toLowerCase() + ":textures/models/armor/" + this.textureName + "_layer_";
            String end = slot == 2 ? "2.png" : "1.png";
            return path + end;
        }
        else {
            return null;
        }
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public void registerIcons(IIconRegister iconRegister) {        
        if(this.textureName == null)
    	{
        	itemIcon = iconRegister.registerIcon(this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".")+1));
    	}else
    	{
    		itemIcon = iconRegister.registerIcon(ModReference.MOD_ID.toLowerCase() + ":" + this.textureName + "_" + this.typeName);
    	}    	
    }
}
