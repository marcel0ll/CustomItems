package com.Otho.customItems.mod.tileentitys;

import java.util.ArrayList;
import java.util.UUID;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;

import net.minecraftforge.common.util.Constants;


public class TileEntityCustomChest extends TileEntity implements IInventory{
	
		public static final String publicName = "tileEntityCustomChest";
		
		private String owner = "null";
		private String name = "Custom Chest";
		private ItemStack[] inventory;
		private int width;
		private int height;
		private int slots;
		
		public TileEntityCustomChest ()
		{
			super();
		}
		
		public void setWidth(int width)
		{
			this.width = width;
		}
		public void setHeight(int height)
		{
			this.height = height;
		}
		public void setSlots()
		{
			this.slots = this.width * this.height;
			inventory = new ItemStack[this.slots];	
		}
		public void setName(String name)
		{
			this.name = name;
		}
		
		@Override
	    public void readFromNBT(NBTTagCompound nbttagcompound)
	    {
	        super.readFromNBT(nbttagcompound);
	        
	        this.name = nbttagcompound.getString("name");
	        this.owner = nbttagcompound.getString("owner");
	        this.width = nbttagcompound.getInteger("invWidth");
	        this.height = nbttagcompound.getInteger("invHeight");
	        this.setSlots();
	        
	        NBTTagList nbttaglist = nbttagcompound.getTagList("Items", Constants.NBT.TAG_COMPOUND);
	        inventory = new ItemStack[this.slots];
	        for (int i = 0; i < nbttaglist.tagCount(); i++)
	        {
	            NBTTagCompound nbttagcompound1 = nbttaglist.getCompoundTagAt(i);
	            int j = nbttagcompound1.getByte("Slot") & 0xff;
	            if (j >= 0 && j < inventory.length)
	            {
	            	inventory[j] = ItemStack.loadItemStackFromNBT(nbttagcompound1);
	            }
	        }	        
	    }

	    @Override
	    public void writeToNBT(NBTTagCompound nbttagcompound)
	    {
	        super.writeToNBT(nbttagcompound);
	        
	        nbttagcompound.setString("name", this.name);
	        nbttagcompound.setString("owner", this.owner);
	        nbttagcompound.setInteger("invWidth", this.width);
	        nbttagcompound.setInteger("invHeight", this.height);
	        
	        NBTTagList nbttaglist = new NBTTagList();
	        for (int i = 0; i < inventory.length; i++)
	        {
	            if (inventory[i] != null)
	            {
	                NBTTagCompound nbttagcompound1 = new NBTTagCompound();
	                nbttagcompound1.setByte("Slot", (byte) i);
	                inventory[i].writeToNBT(nbttagcompound1);
	                nbttaglist.appendTag(nbttagcompound1);
	            }
	        }
	        nbttagcompound.setTag("Items", nbttaglist);
	    }
	   
	   public void registerOwner(String owner)
	   {
		   this.owner = owner;
	   }
	   
	   public String getOwner()
	   {		   
		   return this.owner;
	   }
	   
	   	public int getWidth()
	   	{
	   		return this.width;
	   	}
	   	
	   	public int getHeight()
	   	{
	   		return this.height;
	   	}

		@Override
		public int getSizeInventory() {
			return this.slots;
		}
	
		@Override
		public ItemStack getStackInSlot(int slot) {
			return inventory[slot];
		}
	
		@Override
		public ItemStack decrStackSize(int slot, int amount) {
			if (inventory[slot] != null)
	        {
	            if (inventory[slot].stackSize <= amount)
	            {
	                ItemStack itemstack = inventory[slot];
	                inventory[slot] = null;
	                markDirty();
	                return itemstack;
	            }
	            ItemStack itemstack1 = inventory[slot].splitStack(amount);
	            if (inventory[slot].stackSize == 0)
	            {
	            	inventory[slot] = null;
	            }
	            markDirty();
	            return itemstack1;
	        }
	        else
	        {
	            return null;
	        }
		}
	
		@Override
		public ItemStack getStackInSlotOnClosing(int slot) {
			if (this.inventory[slot] != null)
	        {
	            ItemStack var2 = this.inventory[slot];
	            this.inventory[slot] = null;
	            return var2;
	        }
	        else
	        {
	            return null;
	        }
		}
	
		@Override
		public void setInventorySlotContents(int slot, ItemStack stack) {
			
				inventory[slot] = stack;
			
		}
	
		@Override
		public String getInventoryName() {
			// TODO Auto-generated method stub
			return this.name;
		}
	
		@Override
		public boolean hasCustomInventoryName() {			
			return false;
		}
	
		@Override
		public int getInventoryStackLimit() {			
			return 64;
		}
	
		@Override
		public boolean isUseableByPlayer(EntityPlayer player) {
			return worldObj.getTileEntity(xCoord, yCoord, zCoord) == this &&
	                player.getDistanceSq(xCoord + 0.5, yCoord + 0.5, zCoord + 0.5) < 64;
		}
	
		@Override
		public void openInventory() {
			// TODO Auto-generated method stub
			
		}
	
		@Override
		public void closeInventory() {
			// TODO Auto-generated method stub
			
		}
	
		@Override
		public boolean isItemValidForSlot(int p_94041_1_, ItemStack p_94041_2_) {
			// TODO Auto-generated method stub
			return true;
		}
		   
}