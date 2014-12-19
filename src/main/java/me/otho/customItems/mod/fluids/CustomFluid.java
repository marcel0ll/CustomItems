package me.otho.customItems.mod.fluids;

import me.otho.customItems.mod.blocks.CustomFluidBlock;
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
