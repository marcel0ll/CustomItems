package com.Otho.customItems.mod.blocks;

import java.util.Random;

import com.Otho.customItems.lib.ModReference;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFalling;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityFallingBlock;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class CustomFallingBlock  extends BlockFalling
{
	private boolean canSilkHarvest = false;
	private int maxStackSize = 64;
	private int itemQuantityDrop = 1;
	
	public void setItemQuantityDrop(int itemQuantityDrop) {
		this.itemQuantityDrop = itemQuantityDrop;
		
	}
	
	public void setOpaque(boolean isOpaque)
	{
		this.opaque = isOpaque;
		this.lightOpacity = this.isOpaqueCube() ? 255 : 0;
	}
    public CustomFallingBlock() {
        this(Material.sand);
    }
    public CustomFallingBlock(Material material) {
        super(material); 
    }
    
    public void setCanSilkHarvest(boolean canSilkHarvest) {
		this.canSilkHarvest = canSilkHarvest;
	}

	public void setMaxStackSize(int maxStackSize) {
		this.maxStackSize = maxStackSize;
		
		Item itemBlock = Item.getItemFromBlock(this);
        itemBlock.setMaxStackSize(this.maxStackSize);
	}   
	
	@Override
	public int quantityDropped(Random rand)
    {
        return this.itemQuantityDrop;
    }
   
    @Override
    public String getUnlocalizedName() {
        return super.getUnlocalizedName();
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister) {        
        if(this.textureName == null)
    	{
        	blockIcon = iconRegister.registerIcon(this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".")+1));
    	}else
    	{
    		blockIcon = iconRegister.registerIcon(ModReference.MOD_ID.toLowerCase() + ":" + this.textureName);
    	}
    }
    
	
	
	@Override
	public boolean canSilkHarvest(World world, EntityPlayer player, int x, int y, int z, int metadata)
    {
		return this.canSilkHarvest;
    }
}
