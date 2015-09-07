package me.otho.customItems.configuration.Json;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.zip.ZipEntry;

import com.google.gson.JsonArray;
import me.otho.customItems.configuration.Forge.ForgeConfig;
import me.otho.customItems.configuration.Json.jsonReaders.PrototypeObject;
import me.otho.customItems.registry.Registry;
import me.otho.customItems.utility.LogHelper;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.ArrayUtils;

import com.google.gson.Gson;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;

public class JsonConfigurationHandler {
    public static PrototypeObject[] data;
    public static ArrayList<PrototypeObject> allData;

    public static void init(String folderPath, File source) throws IOException {
        if (ForgeConfig.remake) {
            remakeConfigFiles(source, folderPath);
        }

        File folder = new File(folderPath);
        allData = new ArrayList<PrototypeObject>();

        if (folder.exists()) {
            File[] listOfFiles = folder.listFiles();

            if (listOfFiles.length > 0) {
                Gson gson = new Gson();
                JsonReader reader;
                JsonParser parser = new JsonParser();
                ;

                int i;

                for (i = 0; i < listOfFiles.length; i++) {
                    File file = listOfFiles[i];

                    if (file.isFile() && file.getName().endsWith(".json")) {
                        try {
                            LogHelper.info("Parsing json file:" + file.getName());

                            reader = new JsonReader(new FileReader(file));
                            JsonArray array = parser.parse(reader).getAsJsonArray();

                            // reader.setLenient(true);

                            PrototypeObject[] data = gson.fromJson(reader, PrototypeObject[].class);
                            mergeGson(data);
                        } catch (FileNotFoundException e) {

                        }
                    }
                }
                LogHelper.info("Finished to read all JSON files");
                // Registry.register(allData);

            }
        } else {
            folder.mkdir();
        }
    }

    public static void post_init() {
        // Registry.change(allData);
    }

    private static void mergeGson(PrototypeObject[] data) {
        for (PrototypeObject cfg : data) {
            allData.add(cfg);
        }
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