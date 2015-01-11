package me.otho.customItems.compability;

import me.otho.customItems.reference.Reference;
import me.otho.customItems.utility.LogHelper;
import codechicken.nei.api.API;
import codechicken.nei.api.IConfigureNEI;

public class NEICustomItemsConfig implements IConfigureNEI {

	private static final String name = Reference.MOD_ID + "_NEI";
	private static final String version = "0.0.1";
	
	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getVersion() {
		return version;
	}

	@Override
	public void loadConfig() {
		if(Integration.isNEI()) {            
            hideItems();
        }		
	}
	
	public void hideItems(){
		//Hide Crops
		LogHelper.info("Hiding Crops From NEI");
		
		//Hide Slabs
		LogHelper.info("Hiding Slabs From NEI");
	}


}
