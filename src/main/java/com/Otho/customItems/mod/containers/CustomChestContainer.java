package com.Otho.customItems.mod.containers;

import com.Otho.customItems.mod.tileentitys.TileEntityCustomChest;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import invtweaks.api.container.ChestContainer;

@ChestContainer(isLargeChest = true, rowSize = 7)
public class CustomChestContainer extends Container
{
	
	protected TileEntityCustomChest tileEntity;
	
	public CustomChestContainer(InventoryPlayer inventoryPlayer, TileEntityCustomChest tileEntity) {
		this.tileEntity = tileEntity;
		
		int w = tileEntity.getWidth();
		int h = tileEntity.getHeight();
		
		int width = w*18;
		int height = h*18;
		
		int maxW = 176;
		int maxH = 0;
		
		int baseX = ((maxW - width) /2)+1;
		int baseY = -h*9 + 58;
				
		
		for (int i = 0; i < h;i++) {
            for (int j = 0; j < w; j++) {
                    addSlotToContainer(new Slot(tileEntity, j + i * w, baseX + j * 18,  baseY + i * 18));
            }
    }

	    //commonly used vanilla code that adds the player's inventory
	    bindPlayerInventory(inventoryPlayer);
	}

	@Override
	public boolean canInteractWith(EntityPlayer player) {
		 return tileEntity.isUseableByPlayer(player);
	}
	
	 protected void bindPlayerInventory(InventoryPlayer inventoryPlayer) {
		 int baseY = 128;
		 int baseX = 8;
         for (int i = 0; i < 3; i++) {
                 for (int j = 0; j < 9; j++) {
                         addSlotToContainer(new Slot(inventoryPlayer, j + i * 9 + 9,
                        		 baseX + j * 18, baseY + i * 18));
                 }
         }

         for (int i = 0; i < 9; i++) {
                 addSlotToContainer(new Slot(inventoryPlayer, i, 8 + i * 18, baseY+58));
         }
	 }
	
	 @Override
	 public ItemStack transferStackInSlot(EntityPlayer player, int i) 
	 {
	 	ItemStack itemstack = null;
        Slot slot = (Slot) inventorySlots.get(i);
        int invSize = tileEntity.getSizeInventory();
        int maxStackSize = tileEntity.getInventoryStackLimit();
        
        if (slot != null && slot.getHasStack())
        {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();
            if (i < invSize)
            {
                if (!mergeItemStack(itemstack1, invSize, inventorySlots.size(), true))
                {
                    return null;
                }
            }	            
            else if (!mergeItemStack(itemstack1, 0, invSize, false))
            {
                return null;
            }
            if (itemstack1.stackSize == 0)
            {
                slot.putStack(null);
            	//mergeItemStack(itemstack1, size, inventorySlots.size(), true);
            }
            else
            {
                slot.onSlotChanged();
            }
        }
        return itemstack;
	 }
	 
	 @Override
	 protected boolean mergeItemStack(ItemStack incomingStack, int slotStartIndex, int maxInvSlotIndex, boolean isChestInventory)
	    {
	        boolean flag1 = false;
	        int k = slotStartIndex;

	        if (isChestInventory)
	        {
	            k = maxInvSlotIndex - 1;
	        }

	        Slot slot;
	        ItemStack itemstack1;

	        if (incomingStack.isStackable())
	        {
	            while (incomingStack.stackSize > 0 && (!isChestInventory && k < maxInvSlotIndex || isChestInventory && k >= slotStartIndex))
	            {
	                slot = (Slot)this.inventorySlots.get(k);
	                itemstack1 = slot.getStack();

	                if (itemstack1 != null && itemstack1.getItem() == incomingStack.getItem() && (!incomingStack.getHasSubtypes() || incomingStack.getItemDamage() == itemstack1.getItemDamage()) && ItemStack.areItemStackTagsEqual(incomingStack, itemstack1))
	                {
	                	if(isChestInventory)
	                	{
		                    int l = itemstack1.stackSize + incomingStack.stackSize;
	
		                    if (l <= incomingStack.getMaxStackSize())
		                    {
		                        incomingStack.stackSize = 0;
		                        itemstack1.stackSize = l;
		                        slot.onSlotChanged();
		                        flag1 = true;
		                    }
		                    else if (itemstack1.stackSize < incomingStack.getMaxStackSize())
		                    {
		                        incomingStack.stackSize -= incomingStack.getMaxStackSize() - itemstack1.stackSize;
		                        itemstack1.stackSize = incomingStack.getMaxStackSize();
		                        slot.onSlotChanged();
		                        flag1 = true;
		                    }
	                	}else
	                	{
                		 	int l = itemstack1.stackSize + incomingStack.stackSize;
                			
		                    if (l <= incomingStack.getMaxStackSize() && l <= tileEntity.getInventoryStackLimit())
		                    {
		                        incomingStack.stackSize = 0;
		                        itemstack1.stackSize = l;
		                        slot.onSlotChanged();
		                        flag1 = true;
		                    }
		                    else if (itemstack1.stackSize < tileEntity.getInventoryStackLimit())
		                    {
		                        incomingStack.stackSize -= tileEntity.getInventoryStackLimit() - itemstack1.stackSize;
		                        itemstack1.stackSize = tileEntity.getInventoryStackLimit();
		                        slot.onSlotChanged();
		                        flag1 = false;
		                    }else
		                    {
		                    	flag1 = false;
		                    	break;
		                    }
	                	}
	                }

	                if (isChestInventory)
	                {
	                    --k;
	                }
	                else
	                {
	                    ++k;
	                }
	            }
	        }

	        if (incomingStack.stackSize > 0)
	        {
	            if (isChestInventory)
	            {
	                k = maxInvSlotIndex - 1;
	            }
	            else
	            {
	                k = slotStartIndex;
	            }

	            while (!isChestInventory && k < maxInvSlotIndex || isChestInventory && k >= slotStartIndex)
	            {
	                slot = (Slot)this.inventorySlots.get(k);
	                itemstack1 = slot.getStack();

	                if (itemstack1 == null)
	                {
	                	if(isChestInventory)
	                	{
	                		 slot.putStack(incomingStack.copy());
	                         slot.onSlotChanged();
	                         incomingStack.stackSize = 0;
	                         flag1 = true;
	                         break;
	                	}else
	                	{
	                		if(incomingStack.stackSize == 0)
	                		{
	                			flag1 = true;
	                			break;
	                		}
		                	if(incomingStack.stackSize <= tileEntity.getInventoryStackLimit())
		                	{	                	
			                    slot.putStack(incomingStack.copy());
			                    slot.onSlotChanged();
			                    incomingStack.stackSize = 0;
			                    flag1 = true;
			                    break;
		                	}else
		                	{
		                		
		                		ItemStack newStack = incomingStack.copy();
		                		
		                		int diff = tileEntity.getInventoryStackLimit() - incomingStack.stackSize;
		                		
		                		if(diff > 0)
		                		{
		                			newStack.stackSize = tileEntity.getInventoryStackLimit() - diff;
		                			incomingStack.stackSize = 0;
		                		}else
		                		{
		                			newStack.stackSize = tileEntity.getInventoryStackLimit();
		                			incomingStack.stackSize = -diff;
		                		}
		                		
		                		slot.putStack(newStack);
			                    slot.onSlotChanged();		                    
			                    flag1 = true;			                    
		                	}
	                	}
	                }

	                if (isChestInventory)
	                {
	                    --k;
	                }
	                else
	                {
	                    ++k;
	                }
	            }
	        }

	        return flag1;
	    }

}
