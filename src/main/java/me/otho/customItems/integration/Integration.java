package me.otho.customItems.integration;

import cpw.mods.fml.common.Loader;

public class Integration {

    private static boolean NEI;
    private static boolean ExNihilo;

    public static void init() {
        NEI = Loader.isModLoaded("NotEnoughItems");
        ExNihilo = Loader.isModLoaded("exnihilo");
    }

    public static boolean isNEI() {
        return NEI;
    }

    public static boolean isExNihilo() {
        return ExNihilo;
    }
}
