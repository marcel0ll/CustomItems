package me.otho.customItems.mod.GUI;

import me.otho.customItems.mod.containers.CustomChestContainer;
import me.otho.customItems.mod.tileentitys.TileEntityCustomChest;
import me.otho.customItems.reference.Reference;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

import org.lwjgl.opengl.GL11;

public class CustomChestGui extends GuiContainer{
	
	private TileEntityCustomChest tile;
	
	private int nxSize;
	private int nySize;
	private int xGap = 0;
	private int yGap = 0;
	private int leftGap = 3;
	private int rightGap = 3;
	private int topGap = 10;
	private int botGap = 3;
 
	
	public CustomChestGui (InventoryPlayer inventoryPlayer, TileEntityCustomChest tileEntity) {			
			super(new CustomChestContainer(inventoryPlayer, tileEntity));
			
			this.tile = tileEntity;
			
			this.nxSize = this.tile.getWidth() * 18 + 8;;
			this.nySize = this.tile.getHeight() * 18 + 8;
			this.ySize = 210;
	}

	@Override
    protected void drawGuiContainerForegroundLayer(int param1, int param2) {
            //draw text and stuff here
            //the parameters for drawString are: string, x, y, color
			int x0 = 7;
			int y0 = -6;
			
			int x = x0 + (9-tile.getWidth()) * 9;
			int y = y0 + (6-tile.getHeight()) * 9;
		
			//int x = ((width - nxSize) / 2)-3;
		
            fontRendererObj.drawString(tile.getName(), x, y, 4210752);
            //draws "Inventory" or your regional equivalent
            fontRendererObj.drawString(StatCollector.translateToLocal("container.inventory"), 8, 116 + 2, 4210752);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3) {
    	
    		int i, j;
    	
            //draw your Gui here, only thing you need to change is the path            
            ResourceLocation texture = new ResourceLocation(Reference.MOD_ID, "textures/gui/container/InventorySheet.png");
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
          
            this.mc.getTextureManager().bindTexture(texture); 
            
            //this.height = this.tile.getHeight() * 18 + 8 - 80;
            
            
            int x = ((width - nxSize) / 2)-3;
            int y = ((height - nySize) / 2)-58;
            
            int x2 = x+nxSize;
            int y2 = y+nySize;
            
            int playerInventoryX = (width - this.xSize) / 2;
//            int playerInventoryY = ((height - 99) / 2)+33+26;
            int playerInventoryY = (int)(Math.ceil((height - 99) / 2.0))+55;
            
            this.drawTexturedModalRect(playerInventoryX, playerInventoryY, 25, 0, 176, 99);
            
            this.drawTexturedModalRect(x, y, 0, 18, 4, 4);
            this.drawTexturedModalRect(x+nxSize-4+leftGap+rightGap, y, 4, 18, 4, 4);
            if(tile.getHeight() < 6)
            	this.drawTexturedModalRect(x, y+nySize-4+topGap+botGap, 0, 22, 4, 4);
            if(tile.getHeight() < 6)
            	this.drawTexturedModalRect(x+nxSize-4+leftGap+rightGap, y+nySize-4+topGap+botGap, 4, 22, 4, 4);
            
            
            for(i=4;i<nySize-4+topGap+botGap;i++)
            {
            	this.drawTexturedModalRect(x, y+i, 0, 30, 4, 1);
            	this.drawTexturedModalRect(x+nxSize-4+leftGap+rightGap, y+i, 0, 31, 4, 1);
            }
            for(i=4;i<nxSize-4+leftGap+rightGap;i++)
            {
            	this.drawTexturedModalRect(x+i, y, 0, 26, 1, 4);
            	if(tile.getHeight() < 6)
            		this.drawTexturedModalRect(x+i, y+nySize-4+topGap+botGap, 1, 26, 1, 4);
            }
            
            
            
            GL11.glEnable(GL11.GL_BLEND);
            GL11.glDisable(GL11.GL_LIGHTING);
            GL11.glDisable(GL11.GL_TEXTURE_2D);            
            GL11.glLineWidth(2);
            GL11.glColor4f(0.77F, 0.77F, 0.77F, 1.0F);
            GL11.glBegin(GL11.GL_QUADS);
	            GL11.glVertex2f(x+4, y+4); 
	            GL11.glVertex2f(x+4, y2-4+topGap+botGap);
	            GL11.glVertex2f(x2-4+leftGap+rightGap, y2-4+topGap+botGap); 
	            GL11.glVertex2f(x2-4+leftGap+rightGap, y+4);
	            
            GL11.glEnd();
            GL11.glDisable(GL11.GL_BLEND);
            //GL11.glEnable(GL11.GL_LIGHTING);
            GL11.glEnable(GL11.GL_TEXTURE_2D);
            
            GL11.glColor4f(1F, 1F, 1F, 1.0F);
            for(i=0;i<tile.getWidth();i++)
            {
            	for(j=0;j<tile.getHeight();j++)
            	{
            		this.drawTexturedModalRect(x+4+i*18+leftGap, y+4+j*18+topGap, 0, 0, 18, 18);
            	}
            }
            
            if(tile.getHeight() == 6 && tile.getWidth() == 9)
            	this.drawTexturedModalRect(playerInventoryX+3, playerInventoryY+3, 29, 3, 1, 1);
            
    }
    
    
	
	

}
