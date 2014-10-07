package com.Otho.customItems.mod.fluids;

import com.Otho.customItems.mod.blocks.CustomFluidBlock;
import com.Otho.customItems.lib.ModReference;
import com.Otho.customItems.util.LogHelper;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import net.minecraftforge.fluids.Fluid;

public class CustomFluid extends Fluid {
    public IIcon stillIcon;
    public IIcon flowingIcon;
    public CustomFluid(String s) {
        super(s);
    }

    public void setIcons(CustomFluidBlock block) {
        this.stillIcon = block.getIcon(3,0);
        this.flowingIcon = block.getIcon(0,0);
    }

    @Override
    public IIcon getStillIcon() {
        return this.stillIcon;
    }

    @Override
    public IIcon getFlowingIcon() {
        return this.flowingIcon;
    }
}
