package com.Otho.customItems.mod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import com.Otho.customItems.CustomItems;
import com.Otho.customItems.ModReference;
import com.Otho.customItems.mod.tileentitys.TileEntityCustomChest;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class CustomChest extends Block implements ITileEntityProvider{ 

	private int invWidth = 3;
	private int invHeight = 3;
	private String name = "Custom Chest";
	private boolean hasOwner = false;
	private int slotMaxStackSize = 64;
	
	private String[] textureNames;
	private IIcon[] icons = new IIcon[6];
	
	public CustomChest(Material material,int w, int h, String name)
	{
		super(material);
		
		this.invWidth = (w<=9) ? w : 9;
		this.invHeight = (h<=6) ? h : 6;
		this.name = name;
	}
	
	public void setOpaque(boolean isOpaque)
	{
		this.opaque = isOpaque;
		this.lightOpacity = this.isOpaqueCube() ? 255 : 0;
	}
	
	public void setSlotMaxStackSize(int max)
	{
		this.slotMaxStackSize = max;
	}
	
	public void setHasOwner(boolean hasOwner)
	{
		this.hasOwner = hasOwner;
	}
	
	public boolean getHasOwner()
	{
		return this.hasOwner;
	}	
	
	public int getInvWidth() {
		return invWidth;
	}

	public int getInvHeight() {
		return invHeight;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
    @SideOnly(Side.CLIENT)    
    public void registerBlockIcons(IIconRegister iconRegister) {
    	if(textureNames == null)
    	{
	        if(this.textureName == null)
	    	{
	        	blockIcon = iconRegister.registerIcon(this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".")+1));
	    	}else
	    	{
	    		blockIcon = iconRegister.registerIcon(ModReference.MOD_ID.toLowerCase() + ":" + this.textureName);
	    	}
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
    public String getUnlocalizedName() {
        return super.getUnlocalizedName();
    }
    
    @Override
    public TileEntity createNewTileEntity(World world, int metadata)
    {
		TileEntityCustomChest customChest = new TileEntityCustomChest();
		
		customChest.setWidth(this.invWidth);
		customChest.setHeight(this.invHeight);
		customChest.setSlots();
		customChest.setName(this.name);
		customChest.setSlotMaxStackSize(this.slotMaxStackSize);
    	
    	return customChest;
    }
    
    @Override
    public boolean hasTileEntity(int metadata) {
 
        return true;
    }

    @Override
    public void onBlockPlacedBy(World p_149689_1_, int p_149689_2_, int p_149689_3_, int p_149689_4_, EntityLivingBase p_149689_5_, ItemStack p_149689_6_) 
    {
    	EntityPlayer player = (EntityPlayer) p_149689_5_;
    	
    	TileEntityCustomChest tile = (TileEntityCustomChest) p_149689_1_.getTileEntity(p_149689_2_, p_149689_3_, p_149689_4_);
    	
    	
    	if(tile != null)
    	{
    		tile.registerOwner(player.getUniqueID().toString());
    	}    	
    }
    
    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_)
    {
    	TileEntityCustomChest tile = (TileEntityCustomChest) world.getTileEntity(x, y, z);
    	
    	
    	if (tile == null || player.isSneaking()) {
            return false;
	    }
    	else
    	{
    		if(!this.hasOwner ||tile.getOwner().equals(player.getUniqueID().toString()))
    		{	    			
	    		player.openGui(CustomItems.instance, 0, world, x, y, z);
			    return true;
    		}else
    		{
    			player.addChatComponentMessage(new ChatComponentText("You can't open what is not yours"));
    			
    			return false;
    		}
    	}
    	
    }
    
    @Override
    public void breakBlock(World world, int p_149749_2_, int p_149749_3_, int p_149749_4_, Block p_149749_5_, int p_149749_6_)
    {
        TileEntityCustomChest tileentitychest = (TileEntityCustomChest)world.getTileEntity(p_149749_2_, p_149749_3_, p_149749_4_);

        if (tileentitychest != null)
        {
            for (int i1 = 0; i1 < tileentitychest.getSizeInventory(); ++i1)
            {
                ItemStack itemstack = tileentitychest.getStackInSlot(i1);

                if (itemstack != null)
                {
                    float f = world.rand.nextFloat() * 0.8F + 0.1F;
                    float f1 = world.rand.nextFloat() * 0.8F + 0.1F;
                    EntityItem entityitem;

                    for (float f2 = world.rand.nextFloat() * 0.8F + 0.1F; itemstack.stackSize > 0; world.spawnEntityInWorld(entityitem))
                    {
                        int j1 = world.rand.nextInt(21) + 10;

                        if (j1 > itemstack.stackSize)
                        {
                            j1 = itemstack.stackSize;
                        }

                        itemstack.stackSize -= j1;
                        entityitem = new EntityItem(world, (double)((float)p_149749_2_ + f), (double)((float)p_149749_3_ + f1), (double)((float)p_149749_4_ + f2), new ItemStack(itemstack.getItem(), j1, itemstack.getItemDamage()));
                        float f3 = 0.05F;
                        entityitem.motionX = (double)((float)world.rand.nextGaussian() * f3);
                        entityitem.motionY = (double)((float)world.rand.nextGaussian() * f3 + 0.2F);
                        entityitem.motionZ = (double)((float)world.rand.nextGaussian() * f3);

                        if (itemstack.hasTagCompound())
                        {
                            entityitem.getEntityItem().setTagCompound((NBTTagCompound)itemstack.getTagCompound().copy());
                        }
                    }
                }
            }

            world.func_147453_f(p_149749_2_, p_149749_3_, p_149749_4_, p_149749_5_);
        }

        super.breakBlock(world, p_149749_2_, p_149749_3_, p_149749_4_, p_149749_5_, p_149749_6_);
    }
    
	
}
