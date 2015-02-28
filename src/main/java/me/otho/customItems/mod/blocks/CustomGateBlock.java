package me.otho.customItems.mod.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import me.otho.customItems.reference.Reference;
import net.minecraft.block.BlockFenceGate;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;

public class CustomGateBlock extends BlockFenceGate{
	public CustomGateBlock (){
		this.setCreativeTab(null);
	}

    private IIcon[] icons = new IIcon[6];
	
	private String[] textureNames;
	protected boolean breaks;

	private boolean canSilkHarvest;
	
	@Override
	@SideOnly(Side.CLIENT)
    public int getRenderBlockPass()
    {
		return 1;
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
    public String getUnlocalizedName() {
        return super.getUnlocalizedName();
    }

    @Override
    @SideOnly(Side.CLIENT)    
    public void registerBlockIcons(IIconRegister iconRegister) {
    	if(textureNames == null)
    	{	        
    		blockIcon = iconRegister.registerIcon(Reference.MOD_ID.toLowerCase() + ":" + this.textureName);	    	
    	}else
    	{
    		for (int i = 0; i < icons.length; i++) {
    	        icons[i] = iconRegister.registerIcon(Reference.MOD_ID.toLowerCase() + ":" + textureNames[i]);
    	    }
    	}
    }
    
    public void registerBlockTextures(String[] textureNames)
    {
    	this.textureNames = textureNames;
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
