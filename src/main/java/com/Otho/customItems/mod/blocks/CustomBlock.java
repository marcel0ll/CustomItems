package com.Otho.customItems.mod.blocks;

import java.util.ArrayList;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import com.Otho.customItems.lib.ModReference;
import com.Otho.customItems.mod.creativeTab.customItemsTab;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class CustomBlock extends Block {
	
	public CustomBlock() {
        this(Material.rock);
    }
    public CustomBlock(Material material) {
        super(material); 
    }
	
	private boolean canSilkHarvest = false;
	private int maxStackSize = 64;

	private boolean dropsItem = false;
	
	private int maxItemDrop;
	
	private int minItemDrop;
	private int eachExtraItemDropChance;
	
	private Item dropItem;
		
	private int getItemDropQuantity(World world, int fortune)
    {
    	int ret = 0;
    	int i;
    	for(i=0;i < this.maxItemDrop + fortune;i++)
    	{
    		boolean willDrop = world.rand.nextInt(100) < this.eachExtraItemDropChance;
    		if(willDrop)
    			ret++;
    	}
    	if(ret < this.minItemDrop)
    		ret = this.minItemDrop;
    	
    	return ret;
    }
	
	
	public void setMaxItemDrop(int maxItemDrop) {
		this.maxItemDrop = maxItemDrop;
	}

	public void setMinItemDrop(int minItemDrop) {
		this.minItemDrop = minItemDrop;
	}

	public void setEachExtraItemDropChance(int eachExtraItemDropChance) {
		this.eachExtraItemDropChance = eachExtraItemDropChance;
	}

	public void setDropItem(Item dropItem) {
		this.dropItem = dropItem;
	}
	public void setOpaque(boolean isOpaque)
	{
		this.opaque = isOpaque;
		this.lightOpacity = this.isOpaqueCube() ? 255 : 0;
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
    public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int metadata, int fortune)
    {
        ArrayList<ItemStack> drops = new ArrayList(); 
        
        if(dropItem == null)
        {
        	drops.add(new ItemStack(Item.getItemFromBlock(this)));
        }else
        {
        	int itemQuantity = getItemDropQuantity(world, fortune);
           	drops.add(new ItemStack(dropItem, itemQuantity));
        }          
        
        return drops;
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
