package me.otho.customItems.mod.items.disks;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import me.otho.customItems.CustomItems;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemRecord;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class CustomDisk extends ItemRecord {
    protected String song;

    public CustomDisk(String song) {
        super(song);
        this.song = song;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister) {
        itemIcon = iconRegister
                .registerIcon(this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1));
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean bool) {
        list.add("Testando  isso aqui");
    }

    @Override
    public ResourceLocation getRecordResource(String name) {
        ResourceLocation loc = new ResourceLocation(
                CustomItems.MOD_ID.toLowerCase() + ":sounds/records/" + name.substring(name.indexOf('.') + 1));

        return loc;
    }

}
