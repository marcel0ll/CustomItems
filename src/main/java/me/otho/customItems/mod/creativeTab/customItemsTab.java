package me.otho.customItems.mod.creativeTab;

import java.util.ArrayList;

import me.otho.customItems.ModReference;
import me.otho.customItems.configuration.ForgeConfig;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

public class customItemsTab extends CreativeTabs{
    public Item iconItem;
    public String labelName;
    private static int tabId = 0;
    private static ArrayList<customItemsTab> customTabs = new ArrayList(); 
    
    public static void init(){
    	if(ForgeConfig.defaultTab){
	    	customTabs.add(new customItemsTab(Items.item_frame, "Custom Items"));
	    	tabId++;
    	}
    }

    public customItemsTab(Item iconItem, String labelName)
    {
    	super(ModReference.MOD_ID.toLowerCase()+tabId);
    	tabId++;
    	if(iconItem != null)
    	{
    		this.iconItem = iconItem;
    	}else
    	{
    		this.iconItem = Items.item_frame;
    	}
    	this.labelName = labelName;
    	
    }
    @Override
	public Item getTabIconItem() {
		return this.iconItem;
	}
       
	@Override
	public String getTabLabel() {
		return this.labelName;
	};
       
 	@Override
 	public String getTranslatedTabLabel() {
 		return this.labelName;
 	};
 	
 	public static void registerCreativeTab(customItemsTab tab)
 	{
 		customTabs.add(tab); 		
 	}
 	
 	public static CreativeTabs getTabByName(String label)
 	{
 		int i;
 		for(i=0;i<customTabs.size();i++)
 		{
 			customItemsTab tab = customTabs.get(i);
 			if(tab.labelName.equals(label))
 			{
 				return customTabs.get(i);
 			} 				
 		}
 		return null;
 	}
}
