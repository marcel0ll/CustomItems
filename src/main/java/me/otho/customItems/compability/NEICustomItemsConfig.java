package me.otho.customItems.compability;

import java.util.ArrayList;

import net.minecraft.item.ItemStack;
import me.otho.customItems.CustomItems;
import me.otho.customItems.reference.Reference;
import me.otho.customItems.utility.LogHelper;
import codechicken.nei.api.API;
import codechicken.nei.api.IConfigureNEI;
import cpw.mods.fml.common.registry.GameRegistry;

public class NEICustomItemsConfig implements IConfigureNEI {

    private static final String name = Reference.MOD_ID + "_NEI";
    private static final String version = "0.0.1";
    private static ArrayList<ItemStack> stacks = new ArrayList<ItemStack>();

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
        if (Integration.isNEI()) {
            CustomItems.proxy.hideItemInNEI(stacks.toArray());
        }
    }

    public static void addItemToHide(String fullId) {

        String[] parser = fullId.split(":");
        String modId = parser[0];
        String id = parser[1];
        int damage = 0;
        if (parser.length > 2)
            damage = Integer.parseInt(parser[2]);

        LogHelper.info("Hide item in nei: " + fullId);
        stacks.add(new ItemStack(GameRegistry.findItem(modId, id), 1, damage));
    }
}
