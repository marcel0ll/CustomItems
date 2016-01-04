package me.otho.customItems.utility;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.logging.log4j.Level;

import cpw.mods.fml.common.FMLLog;
import me.otho.customItems.CustomItems;
import me.otho.customItems.configuration.ForgeConfig;

public class LogHelper {

    private static ArrayList<String> buffer = new ArrayList<String>();

    public static void log(Level logLevel, Object object) {
        if (ForgeConfig.debug) {
            FMLLog.log(CustomItems.MOD_NAME, logLevel, String.valueOf(object));
        }
        if (ForgeConfig.logFile) {
            buffer.add(String.valueOf(object));
        }
    }

    public static void log(Level logLevel, Object object, int tab) {
        String spaces = "";
        int i;
        for (i = 0; i < tab; i++)
            spaces = spaces.concat("  ");

        log(logLevel, spaces.concat(object.toString()));
    }

    public static void all(Object object) {
        log(Level.ALL, object);
    }

    public static void all(Object object, int tab) {
        log(Level.ALL, object, tab);
    }

    public static void debug(Object object) {
        log(Level.DEBUG, object);
    }

    public static void debug(Object object, int tab) {
        log(Level.DEBUG, object, tab);
    }

    public static void error(Object object) {
        log(Level.ERROR, object);
    }

    public static void error(Object object, int tab) {
        log(Level.ERROR, object, tab);
    }

    public static void fatal(Object object) {
        log(Level.FATAL, object);
    }

    public static void fatal(Object object, int tab) {
        log(Level.FATAL, object, tab);
    }

    public static void info(Object object) {
        log(Level.INFO, object);
    }

    public static void info(Object object, int tab) {
        log(Level.INFO, object, tab);
    }

    public static void off(Object object) {
        log(Level.OFF, object);
    }

    public static void off(Object object, int tab) {
        log(Level.OFF, object, tab);
    }

    public static void trace(Object object) {
        log(Level.TRACE, object);
    }

    public static void trace(Object object, int tab) {
        log(Level.TRACE, object, tab);
    }

    public static void warn(Object object) {
        log(Level.WARN, object);
    }

    public static void warn(Object object, int tab) {
        log(Level.WARN, object, tab);
    }

    public static void printLog(File minecraftFolder) throws IOException {
        if (ForgeConfig.logFile) {
            File logFile = new File(minecraftFolder.toString() + File.separator + CustomItems.LOG_FILE_NAME);
            if (logFile.exists())
                logFile.delete();

            FileWriter writer = new FileWriter(logFile);
            for (String str : buffer) {
                writer.write(str + "\n");
            }
            writer.close();
        }
    }

    public static void finishSection() {
        if (ForgeConfig.logFile) {
            buffer.add("\n");
        }
    }
}