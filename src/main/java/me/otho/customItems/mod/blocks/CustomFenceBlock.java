package me.otho.customItems.mod.blocks;

import java.util.ArrayList;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import me.otho.customItems.ModReference;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFence;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class CustomFenceBlock extends BlockFence{

	public CustomFenceBlock(String p_i45406_1_, Material p_i45406_2_) {
		super(p_i45406_1_, p_i45406_2_);		
	}	
	
	private IIcon[] icons = new IIcon[6];
	private boolean canSilkHarvest;		

	private boolean dropsItem = false;
	
	private int maxItemDrop;
	
	private int minItemDrop;
	private int eachExtraItemDropChance;
	
	protected String dropItem;
	
	private String[] textureNames;
	protected boolean breaks;
	
	@Override
	@SideOnly(Side.CLIENT)
	public int getRenderBlockPass()
    {
		if(!this.opaque)
			return 1;
		else
			return 0;
    }	
	
	protected int getItemDropQuantity(World world, int fortune)
    {
    	int ret = 0;
    	int i;
    	ret = this.minItemDrop;
    	for(i= this.minItemDrop;i < this.maxItemDrop + fortune;i++)
    	{
    		boolean willDrop = world.rand.nextInt(100) < this.eachExtraItemDropChance;
    		if(willDrop)
    			ret++;
    	}
    	
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

	public void setDropItem(String dropItem) {
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
	
	@Override
	public IIcon getIcon(int side, int meta) {
		if(this.textureName != null)
		{
			return blockIcon;
		}else
		{
			return icons[side];
		}
	}
	
	@Override
	public boolean renderAsNormalBlock()
    {
        return false;
    }
			
	@Override
    public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int metadata, int fortune)
    {
        ArrayList<ItemStack> drops = new ArrayList(); 
       
        if(dropItem != null){
	        String[] parser = dropItem.split(":");
	        Item item = GameRegistry.findItem(parser[0], parser[1]);
	        
	        if(item != null)	        
	        {
	        	int itemQuantity = getItemDropQuantity(world, fortune);
	        	int damage;
	        	
	        	if(parser.length > 2){
	        		damage = Integer.parseInt(parser[2]);
	        	}else{
	        		damage = 0;
	        	}
	           	drops.add(new ItemStack(item, itemQuantity, damage));
	        }          
        }else{
        	if(!breaks)
        		drops.add(new ItemStack(Item.getItemFromBlock(this)));
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
    	if(textureNames == null)
    	{	       
	    	blockIcon = iconRegister.registerIcon(ModReference.MOD_ID.toLowerCase() + ":" + this.textureName);	    	
    	}else
    	{
    		for (int i = 0; i < icons.length; i++) {
    	        icons[i] = iconRegister.registerIcon(ModReference.MOD_ID.toLowerCase() + ":" + textureNames[i]);
    	    }
    	}
    }
    
    public void registerBlockTextures(String[] textureNames)
    {
    	this.textureNames = textureNames;
    }
	    
    @Override
    public boolean isOpaqueCube ()
    {
        return false;
    }
	
	
	@Override
	public boolean canSilkHarvest()
    {
		return this.canSilkHarvest;
    }
	public void setBreaks(boolean breaks) {
		this.breaks = breaks;
	}
}
