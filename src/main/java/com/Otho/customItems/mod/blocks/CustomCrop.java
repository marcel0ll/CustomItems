package com.Otho.customItems.mod.blocks;

import java.util.ArrayList;
import java.util.Random;

import com.Otho.customItems.lib.ModReference;
import com.Otho.customItems.mod.creativeTab.customItemsTab;
import com.Otho.customItems.mod.items.CustomSeed;
import com.Otho.customItems.util.LogHelper;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockCrops;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class CustomCrop extends BlockCrops {
    private Item fruit;
    private Item seed;
    
    private boolean dropSeedWhenMature;
    private boolean acceptBoneMeal;
    
    private int minFruitDrop;
    private int maxFruitDrop;
    private int eachExtraFruitDropChance;

	private int minSeedDrop;
    private int maxSeedDrop;
    private int eachExtraSeedDropChance;
    
    private IIcon[] icons;
    private int renderType;

    public CustomCrop(Item fruit, int renderType) {
        super();
        this.fruit = fruit;
        this.renderType = renderType;
        this.setCreativeTab(null);
    }
    

	@Override
    public boolean func_149851_a(World p_149851_1_, int p_149851_2_, int p_149851_3_, int p_149851_4_, boolean p_149851_5_)
    {
    	if(this.acceptBoneMeal)
    	{
    		return p_149851_1_.getBlockMetadata(p_149851_2_, p_149851_3_, p_149851_4_) != 7;
    	}else
    	{
    		return false;
    	}
    }
    
    private int getFruitDropQuantity(World world, int fortune)
    {
    	int ret = 0;
    	int i;
    	for(i=0;i < this.maxFruitDrop + fortune;i++)
    	{
    		boolean willDrop = world.rand.nextInt(100) < this.eachExtraFruitDropChance;
    		if(willDrop)
    			ret++;
    	}
    	if(ret < this.minFruitDrop)
    		ret = this.minFruitDrop;
    	
    	return ret;
    }
    
    private int getSeedDropQuantity(World world, int fortune)
    {
    	int ret = 0;
    	int i;
    	ret = this.minSeedDrop;
    	
    	for(i=this.minSeedDrop;i < this.maxSeedDrop + fortune;i++)
    	{
    		boolean willDrop = world.rand.nextInt(100) < this.eachExtraSeedDropChance;
    		if(willDrop)
    			ret++;
    	}
    	
    	return ret;
    }
    
    @Override
    public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int metadata, int fortune)
    {
        ArrayList<ItemStack> drops = new ArrayList(); 
        
        int seedQuantity = getSeedDropQuantity(world, fortune);
        int fruitQuantity = getFruitDropQuantity(world, fortune);
        
        
        //Growing
        if(metadata < 7)
        {
        	drops.add(new ItemStack(this.seed));
        }        
        //Mature
        else{
        	if(fruitQuantity > 0)
        		drops.add(new ItemStack(this.fruit, fruitQuantity));
        	if(this.dropSeedWhenMature)
        		if(seedQuantity > 0)
        			drops.add(new ItemStack(this.seed, seedQuantity));
        }        
        
        return drops;
    }
    
    public void setAcceptBoneMeal(boolean acceptBoneMeal) {
		this.acceptBoneMeal = acceptBoneMeal;
	}
    
    public void setEachExtraFruitDropChance(int eachExtraFruitDropChance) {
		this.eachExtraFruitDropChance = eachExtraFruitDropChance;
	}

	public void setEachExtraSeedDropChance(int eachExtraSeedDropChance) {
		this.eachExtraSeedDropChance = eachExtraSeedDropChance;
	}
    
    public void setDropSeedWhenMature(boolean bool)
    {
    	this.dropSeedWhenMature = bool;
    }
    
    public void setFruitQuantityDropRange(int min, int max)
    {
    	if(min <=0)
    		min = 0;
    	if(max < min)
    		max = min;
    	
    	this.maxFruitDrop = max;
    	this.minFruitDrop = min;
    }
    
    public void setSeedQuantityDropRange(int min, int max)
    {
    	if(min <=0)
    		min = 0;
    	if(max < min)
    		max = min;
    	
    	this.maxSeedDrop = max;
    	this.minSeedDrop = min;
    }
    
    public void setSeed(CustomSeed seed) {
        this.seed = seed;
    }

    @Override
    protected Item func_149866_i() {
        return this.seed;
    }

    @Override
    protected Item func_149865_P() {
        return this.fruit;
    }

    @Override
    public int getRenderType() {
        return this.renderType;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister) {
        LogHelper.debug("registering icon for: " + this.getUnlocalizedName());
        this.icons = new IIcon[4];
        for(int i=1;i<this.icons.length+1;i++) {
        	if(this.textureName == null)
        	{        		
        		this.icons[i-1] = iconRegister.registerIcon(this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf('.') + 1)+i);
        	}else
        	{
        		this.icons[i-1] = iconRegister.registerIcon(ModReference.MOD_ID.toLowerCase() + ":" + this.textureName+i);
        	}
            
        }
    }

    @Override
    public IIcon getIcon(int side, int meta) {
        switch(meta) {
            case 0: return this.icons[0];
            case 1: return this.icons[0];
            case 2: return this.icons[1];
            case 3: return this.icons[1];
            case 4: return this.icons[1];
            case 5: return this.icons[2];
            case 6: return this.icons[2];
            case 7: return this.icons[3];
        }
        return this.icons[(int)Math.floor(meta/5)];
    }

}
