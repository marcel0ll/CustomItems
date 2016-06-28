package me.otho.customItems.configuration.jsonReaders.blocks;

import me.otho.customItems.configuration.jsonReaders.common.Cfg_basicData;
import me.otho.customItems.configuration.jsonReaders.items.Cfg_item;

public class Cfg_fluid extends Cfg_basicData {
  public int luminosity = 0;
  // public float lightLevel = 0.0f;
  public int density = 1000;
  public int temperature = 300;
  public int viscosity = 1000;
  public String material = "water";
  public boolean isGas = false;

  public int flowLength = 8;
  public String color = "000000";

  public Cfg_item bucket = new Cfg_item();

  // public boolean fireSource = false;
  public Cfg_fluid() {
    bucket.name = null;
    bucket.maxStackSize = 1;
    bucket.creativeTab = null;
    bucket.textureName = null;
  }
}
