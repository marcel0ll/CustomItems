package me.otho.customItems.configuration.Json.jsonReaders;

import com.google.gson.annotations.SerializedName;

public class PrototypeObject {

    @SerializedName("class")
    public String className;
    public String pid;
    public String prototype;
    public Boolean prototypeOnly = false;

}
