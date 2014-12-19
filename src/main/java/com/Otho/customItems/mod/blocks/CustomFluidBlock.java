package com.Otho.customItems.mod.blocks;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;

import com.Otho.customItems.ModReference;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class CustomFluidBlock extends BlockFluidClassic {
    public CustomFluidBlock(Fluid fluid, Material material) {
        super(fluid, material);        
    }
    @SideOnly(Side.CLIENT)
    protected IIcon stillIcon;
    @SideOnly(Side.CLIENT)
    protected IIcon flowingIcon;

    @Override
    public IIcon getIcon(int side, int meta) {
        return (side==0||side==1)?this.stillIcon:this.flowingIcon;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void registerBlockIcons(IIconRegister iconRegister) {
           
        if(this.textureName == null)
    	{
        	stillIcon = iconRegister.registerIcon(this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".")+1));
        	flowingIcon = iconRegister.registerIcon(this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".")+1)+"_flowing");
        	
    	}else
    	{
    		blockIcon = iconRegister.registerIcon(ModReference.MOD_ID.toLowerCase() + ":" + this.textureName);
    		
    		stillIcon = iconRegister.registerIcon(ModReference.MOD_ID.toLowerCase() + ":" + this.textureName);
            flowingIcon = iconRegister.registerIcon(ModReference.MOD_ID.toLowerCase() + ":" + this.textureName + "_flowing");
    	}
        
    }

    @Override
    public boolean canDisplace(IBlockAccess world, int x, int y, int z) {
        if(world.getBlock(x,y,z).getMaterial().isLiquid()) {return false;}
        return super.canDisplace(world,x,y,z);
    }

    @Override
    public boolean displaceIfPossible(World world, int x, int y, int z) {
        if(world.getBlock(x,y,z).getMaterial().isLiquid()) {return false;}
        return super.displaceIfPossible(world,x,y,z);
    }
}
