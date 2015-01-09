package me.otho.customItems.registry;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.commons.lang3.ArrayUtils;

import me.otho.customItems.configuration.jsonReaders.common.Cfg_drop;
import me.otho.customItems.configuration.jsonReaders.entities.Cfg_entityDrop;
import me.otho.customItems.util.LogHelper;
import me.otho.customItems.util.Util;

public class EntityRegistry {

	public static HashMap<String, Cfg_drop[]> drops = new HashMap<String, Cfg_drop[]>();
	public static HashMap<String, Boolean> overrides = new HashMap<String, Boolean>();
	
	
	public static boolean registerEntityDrop(Cfg_entityDrop data){
		
		if(drops.containsKey(data.id)){
			
			Cfg_drop[] arr = drops.get(data.id);
			
			arr = ArrayUtils.addAll(arr, data.drops);
			
			drops.replace(data.id, arr);			
		}else{
			drops.put(data.id, data.drops);
			overrides.put(data.id, data.overrides);
		}
		
		return true;
	}

	public static boolean registerEntityDrop(Cfg_entityDrop[] data){
		int i;

        for(i=0;i<data.length;i++){
            boolean registered = registerEntityDrop(data[i]);

            if(!registered){
                LogHelper.error("Failed to register: Entity drop " + i);
                return false;
            }
        }

        return true;
	}
}
