package me.otho.customItems.mod.items.tools;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import exnihilo.items.hammers.ItemHammerBase;
import me.otho.customItems.reference.Reference;
import net.minecraft.client.renderer.texture.IIconRegister;

public class CustomHammer extends ItemHammerBase{
	public CustomHammer(ToolMaterial material){
		super(material);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IIconRegister iconRegister) {
		itemIcon = iconRegister.registerIcon(Reference.MOD_ID.toLowerCase() + ":" + this.iconString);
	}
}
