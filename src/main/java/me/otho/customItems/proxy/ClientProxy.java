package me.otho.customItems.proxy;

import java.util.ArrayList;
import java.util.Iterator;

import codechicken.nei.api.API;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.ModContainer;
import net.minecraft.item.ItemStack;
import me.otho.customItems.compability.Integration;
import me.otho.customItems.compability.NEICustomItemsConfig;

public class ClientProxy extends CommonProxy{

	@Override
	public void Integration_NEI() {
		if(Integration.isNEI()){
			NEICustomItemsConfig neiConfig = new NEICustomItemsConfig();
			neiConfig.loadConfig();
		}	
	}	
	
	@Override
    public void hideItemInNEI(Object[] stacks) {
        Iterator mods = Loader.instance().getActiveModList().iterator();
        ModContainer modContainer;
        while(mods.hasNext()) {
            modContainer = (ModContainer) mods.next();
            if(modContainer.getModId().equalsIgnoreCase("NotEnoughItems")) {
                for(Object stack: stacks)
                	API.hideItem((ItemStack) stack);
            }
        }
    }
}
