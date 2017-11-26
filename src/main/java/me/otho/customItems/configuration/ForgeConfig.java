package me.otho.customItems.configuration;

import java.io.File;

import net.minecraftforge.common.config.Configuration;

public class ForgeConfig {
  public static Configuration config;

  public static boolean debug = true;
  public static boolean defaultTab;
  public static boolean entityIdLog = false;
  public static boolean idFile = false;
  public static boolean logFile = false;
  public static boolean generateBucket = true;


  public static void init(File configFile) {
    if (config == null) {
      config = new Configuration(configFile);
    }
    loadConfiguration();
  }

  private static void loadConfiguration() {
    defaultTab = config.getBoolean("defaultTab", "OPTIONS", true,
        "Set to false, if you dont want the default creative tab");
    idFile = config.getBoolean("idFile", "OPTIONS", false,
        "Enable this if you want the mod to make a log files with all entities ids, blocks ids and items ids.");
    logFile = config.getBoolean("logFile", "OPTIONS", false,
        "Enable this if you want the mod to make a separate log file for easier debugging");
    generateBucket = config.getBoolean("generateBucket", "OPTIONS", true,
        "Enable this if you want the mod to add buckets for each custom fluids");

    if (config.hasChanged()) {
      config.save();
    }
  }
}
