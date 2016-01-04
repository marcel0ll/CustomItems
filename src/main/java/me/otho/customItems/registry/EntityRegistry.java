package me.otho.customItems.registry;

import java.util.HashMap;

import org.apache.commons.lang3.ArrayUtils;

import me.otho.customItems.configuration.jsonReaders.entities.Cfg_entityDrop;
import me.otho.customItems.utility.LogHelper;

public class EntityRegistry {

    public static HashMap<String, Cfg_entityDrop> drops = new HashMap<String, Cfg_entityDrop>();

    public static boolean registerEntityDrop(Cfg_entityDrop data) {

        if (drops.containsKey(data.id)) {

            Cfg_entityDrop drop = drops.get(data.id);

            drop.drops = ArrayUtils.addAll(drop.drops, data.drops);

            drops.put(data.id, drop);
        } else {
            drops.put(data.id, data);
        }

        return true;
    }

    public static boolean registerEntityDrop(Cfg_entityDrop[] data) {
        int i;

        for (i = 0; i < data.length; i++) {
            boolean registered = registerEntityDrop(data[i]);

            if (!registered) {
                LogHelper.error("Failed to register: Entity drop " + i);
                return false;
            }
        }

        return true;
    }
}
