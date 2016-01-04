package me.otho.customItems;

import java.io.File;
import java.io.IOException;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import me.otho.customItems.configuration.ForgeConfig;
import me.otho.customItems.configuration.JsonConfigurationHandler;
import me.otho.customItems.integration.Integration;
import me.otho.customItems.mod.creativeTab.customItemsTab;
import me.otho.customItems.mod.handler.BlockDropHandler;
import me.otho.customItems.mod.handler.EntityDropHandler;
import me.otho.customItems.mod.worldGen.CustomWorldGenerator;
import me.otho.customItems.proxy.IProxy;
import net.minecraftforge.common.MinecraftForge;

@Mod(dependencies = CustomItems.DEPENDENCIES, modid = CustomItems.MOD_ID, version = CustomItems.VERSION, name = CustomItems.MOD_NAME)
public class CustomItems {
    //Mod info
    public static final String MOD_ID = "customitems";
    public static final String MOD_NAME = "Meta Mod: Custom Items";
    public static final String DEPENDENCIES = "";
    public static final String VERSION = "1.0.10b";

    public static final String CLIENT_PROXY_CLASS = "me.otho.customItems.proxy.ClientProxy";
    public static final String SERVER_PROXY_CLASS = "me.otho.customItems.proxy.ServerProxy";
    
    @Instance(CustomItems.MOD_ID)
    public static CustomItems instance;

    @SidedProxy(clientSide = CustomItems.CLIENT_PROXY_CLASS, serverSide = CustomItems.SERVER_PROXY_CLASS)
    public static IProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) throws IOException {
        String configFolderPath = event.getModConfigurationDirectory().toString() + File.separator + CustomItems.MOD_ID
                + File.separator;

        ForgeConfig.init(event.getSuggestedConfigurationFile());

        Integration.init();

        customItemsTab.init();

        JsonConfigurationHandler.init(configFolderPath, event.getSourceFile());

        GameRegistry.registerWorldGenerator(new CustomWorldGenerator(), 1);

        proxy.registerTileEntities();
        proxy.Integration_NEI();

        MinecraftForge.EVENT_BUS.register(new EntityDropHandler());
        MinecraftForge.EVENT_BUS.register(new BlockDropHandler());

    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        JsonConfigurationHandler.post_init();
    }
}