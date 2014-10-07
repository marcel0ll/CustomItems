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
		int baseY = -h*9 + 26;
				
		
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
		 int baseY = 115;
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
        int size = tileEntity.getSizeInventory();
        int maxStackSize = tileEntity.getInventoryStackLimit();
        
        if (slot != null && slot.getHasStack())
        {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();
            if (i < size)
            {
                if (!mergeItemStack(itemstack1, size, inventorySlots.size(), true))
                {
                    return null;
                }
            }	            
            else if (!mergeItemStack(itemstack1, 0, size, false))
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

}
