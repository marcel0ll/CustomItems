package me.otho.customItems.mod.blocks;

import me.otho.customItems.reference.Reference;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidBase;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class CustomFluidBlock extends BlockFluidClassic {
	
	private Fluid fluid;
	
	protected IIcon stillIcon;    
    protected IIcon flowingIcon;
	
    public CustomFluidBlock(Fluid fluid, Material material) {
        super(fluid, material);        
        this.fluid = fluid;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta) {
        if (side==0||side==1)        
        	return this.stillIcon;
        else
        	return this.flowingIcon;
    } 
    
    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister) {
    	stillIcon = iconRegister.registerIcon(Reference.MOD_ID.toLowerCase() + ":" + this.textureName + "_still");
        flowingIcon = iconRegister.registerIcon(Reference.MOD_ID.toLowerCase() + ":" + this.textureName + "_flow");
        
        fluid.setStillIcon(stillIcon);
        fluid.setFlowingIcon(flowingIcon);
    }

//    @Override
//    public boolean canDisplace(IBlockAccess world, int x, int y, int z) {
//        if(world.getBlock(x,y,z).getMaterial().isLiquid()) {return false;}
//        return super.canDisplace(world,x,y,z);
//    }
//
//    @Override
//    public boolean displaceIfPossible(World world, int x, int y, int z) {
//        if(world.getBlock(x,y,z).getMaterial().isLiquid()) {return false;}
//        return super.displaceIfPossible(world,x,y,z);
//    }
    
    @Override
    public BlockFluidBase setQuantaPerBlock(int quantaPerBlock)
    {
        if (quantaPerBlock > 16) quantaPerBlock = 16;
        if (quantaPerBlock < 1) quantaPerBlock = 1;
        
        this.quantaPerBlock = quantaPerBlock;
        this.quantaPerBlockFloat = quantaPerBlock;
        return this;
    }
}
