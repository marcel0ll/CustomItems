package me.otho.customItems.mod.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import me.otho.customItems.ModReference;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;

public class CustomSlabBlock2 extends BlockSlab {

	public final boolean doubleSlab;
	public final String name;
	
	public CustomSlabBlock2(boolean p_i45410_1_, Material p_i45410_2_, String name) {
		super(p_i45410_1_, p_i45410_2_);
		
		this.doubleSlab = p_i45410_1_;
		this.name = name;

        if (p_i45410_1_)
        {
            this.opaque = true;
        }
        else
        {
        	this.setLightOpacity(0);
            this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
        }

       
	}
	
	@Override
	public String func_150002_b(int p_150002_1_) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public boolean isOpaqueCube()
    {
        return false;
    }
	
	public boolean renderAsNormalBlock()
    {
        return false;
    }
	
	@Override
    @SideOnly(Side.CLIENT)    
    public void registerBlockIcons(IIconRegister iconRegister) {   	
		blockIcon = iconRegister.registerIcon(ModReference.MOD_ID.toLowerCase() + ":" + this.textureName);	    
    }
	
	@Override
	public IIcon getIcon(int side, int meta) {
		return blockIcon;
	}

}
