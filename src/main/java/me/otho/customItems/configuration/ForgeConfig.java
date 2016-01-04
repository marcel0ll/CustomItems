package me.otho.customItems.configuration;

import java.io.File;

import net.minecraftforge.common.config.Configuration;

public class ForgeConfig {
    public static Configuration config;

    public static boolean debug = true;
    public static boolean defaultTab;
    public static boolean remake = true;
    public static boolean entityIdLog = false;
    public static boolean idFile = false;
    public static boolean logFile = false;

    public static void init(File configFile) {
        if (config == null) {
            config = new Configuration(configFile);
        }
        loadConfiguration();
    }

    private static void loadConfiguration() {
        remake = config.getBoolean("remake", "OPTIONS", true,
                "Set true if you want to restore the default config on the next time the mod is loaded");
        defaultTab = config.getBoolean("defaultTab", "OPTIONS", true,
                "Set to false, if you dont want the default creative tab");
        entityIdLog = config.getBoolean("entityIdLog", "OPTIONS", false,
                "This allows you to see the latest mob killed id");
        idFile = config.getBoolean("idFile", "OPTIONS", false,
                "Enable this if you want the mod to make a log files with all entities ids, blocks ids and items ids.");
        logFile = config.getBoolean("logFile", "OPTIONS", false,
                "Enable this if you want the mod to make a separate log file for easier debugging");
        
        if (config.hasChanged()) {
            config.save();
        }
    }
}
