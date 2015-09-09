package me.otho.customItems.configuration;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.zip.ZipEntry;

import me.otho.customItems.configuration.jsonReaders.entities.Cfg_entityDrop;
import me.otho.customItems.registry.Registry;
import me.otho.customItems.utility.LogHelper;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.ArrayUtils;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

public class JsonConfigurationHandler {
    public static JsonSchema data;
    public static JsonSchema allData;

    public static void init(String folderPath, File source) throws IOException {
        if (ForgeConfig.remake) {
            remakeConfigFiles(source, folderPath);
        }

        File folder = new File(folderPath);
        allData = new JsonSchema();

        if (folder.exists()) {
            File[] listOfFiles = folder.listFiles();

            if (listOfFiles.length > 0) {
                Gson gson = new Gson();
                JsonReader reader;

                int i;

                for (i = 0; i < listOfFiles.length; i++) {
                    File file = listOfFiles[i];

                    if (file.isFile() && file.getName().endsWith(".json")) {
                        try {
                            reader = new JsonReader(new FileReader(file));
                            // reader.setLenient(true);

                            LogHelper.info("Reading json file:" + file.getName());

                            JsonSchema data = gson.fromJson(reader, JsonSchema.class);
                            mergeGson(data, allData);
                        } catch (FileNotFoundException e) {

                        }
                    }
                }
                if (listOfFiles.length > 0)
                    Registry.register(allData);
            }
        } else {
            folder.mkdir();
        }
    }

    public static void post_init() {
        Registry.change(allData);
    }

    private static void mergeGson(JsonSchema data, JsonSchema mergeTo) {
        mergeTo.blocks = ArrayUtils.addAll(data.blocks, mergeTo.blocks);
        mergeTo.chests = ArrayUtils.addAll(data.chests, mergeTo.chests);
        mergeTo.items = ArrayUtils.addAll(data.items, mergeTo.items);
        mergeTo.foods = ArrayUtils.addAll(data.foods, mergeTo.foods);
        mergeTo.pickaxes = ArrayUtils.addAll(data.pickaxes, mergeTo.pickaxes);
        mergeTo.axes = ArrayUtils.addAll(data.axes, mergeTo.axes);
        mergeTo.shovels = ArrayUtils.addAll(data.shovels, mergeTo.shovels);
        mergeTo.hoes = ArrayUtils.addAll(data.hoes, mergeTo.hoes);
        mergeTo.swords = ArrayUtils.addAll(data.swords, mergeTo.swords);
        mergeTo.helmets = ArrayUtils.addAll(data.helmets, mergeTo.helmets);
        mergeTo.chestplates = ArrayUtils.addAll(data.chestplates, mergeTo.chestplates);
        mergeTo.leggings = ArrayUtils.addAll(data.leggings, mergeTo.leggings);
        mergeTo.boots = ArrayUtils.addAll(data.boots, mergeTo.boots);
        mergeTo.fluids = ArrayUtils.addAll(data.fluids, mergeTo.fluids);
        mergeTo.creativeTabs = ArrayUtils.addAll(data.creativeTabs, mergeTo.creativeTabs);
        mergeTo.crops = ArrayUtils.addAll(data.crops, mergeTo.crops);

        mergeTo.changeBlocks = ArrayUtils.addAll(data.changeBlocks, mergeTo.changeBlocks);
        mergeTo.changeItems = ArrayUtils.addAll(data.changeItems, mergeTo.changeItems);
        mergeTo.changeFoods = ArrayUtils.addAll(data.changeFoods, mergeTo.changeFoods);

        mergeTo.oreGen = ArrayUtils.addAll(data.oreGen, mergeTo.oreGen);

        mergeTo.entitiesDrop = ArrayUtils.addAll(data.entitiesDrop, mergeTo.entitiesDrop);
        mergeTo.blocksDrop = ArrayUtils.addAll(data.blocksDrop, mergeTo.blocksDrop);
    }

    public static void remakeConfigFiles(File source, String configFolderPath) throws IOException {
        if (source.isFile()) {
            JarFile file = new JarFile(source);

            ZipEntry defaultConfigs = file.getEntry("defaultConfigs/");

            for (Enumeration<JarEntry> e = file.entries(); e.hasMoreElements();) {
                ZipEntry entry = (ZipEntry) e.nextElement();

                // System.out.println("File name: " + entry.getName()
                // + "; size: " + entry.getSize()
                // + "; compressed size: "
                // + entry.getCompressedSize());
                // System.out.println();
                if (entry.getName().contains("defaultConfigs/")) {
                    String[] parser = entry.getName().split("defaultConfigs/");
                    if (parser.length > 1) {
                        String fileName = parser[1];
                        if (fileName.endsWith(".json")) {
                            File configFile = new File(configFolderPath + parser[1]);
                            if (configFile.exists())
                                configFile.delete();
                            InputStream is = file.getInputStream(entry);

                            InputStreamReader isr = new InputStreamReader(is);

                            char[] buffer = new char[1];
                            while (isr.read(buffer, 0, buffer.length) != -1) {
                                String s = new String(buffer);
                                FileUtils.write(configFile, s, true);
                            }
                        }
                    }
                }
            }

            LogHelper.info("End of Default Config Files");
            file.close();
        }
    }
}