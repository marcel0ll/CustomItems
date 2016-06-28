package me.otho.customItems.mod.materials;

import net.minecraft.block.material.Material;

public class CI_Material {

  public static Material getMaterial(String material) {
    if (material.equals("air")) {
      return Material.air;
    } else if (material.equals("anvil")) {
      return Material.anvil;
    } else if (material.equals("cactus")) {
      return Material.cactus;
    } else if (material.equals("cake")) {
      return Material.cake;
    } else if (material.equals("carpet")) {
      return Material.carpet;
    } else if (material.equals("circuits")) {
      return Material.circuits;
    } else if (material.equals("clay")) {
      return Material.clay;
    } else if (material.equals("cloth")) {
      return Material.cloth;
    } else if (material.equals("coral")) {
      return Material.coral;
    } else if (material.equals("craftedSnow")) {
      return Material.craftedSnow;
    } else if (material.equals("dragonEgg")) {
      return Material.dragonEgg;
    } else if (material.equals("fire")) {
      return Material.fire;
    } else if (material.equals("glass")) {
      return Material.glass;
    } else if (material.equals("gourd")) {
      return Material.gourd;
    } else if (material.equals("grass")) {
      return Material.grass;
    } else if (material.equals("ground")) {
      return Material.ground;
    } else if (material.equals("ice")) {
      return Material.ice;
    } else if (material.equals("iron")) {
      return Material.iron;
    } else if (material.equals("lava")) {
      return Material.lava;
    } else if (material.equals("leaves")) {
      return Material.leaves;
    } else if (material.equals("packedIce")) {
      return Material.packedIce;
    } else if (material.equals("piston")) {
      return Material.piston;
    } else if (material.equals("plants")) {
      return Material.plants;
    } else if (material.equals("portal")) {
      return Material.portal;
    } else if (material.equals("redstoneLight")) {
      return Material.redstoneLight;
    } else if (material.equals("rock")) {
      return Material.rock;
    } else if (material.equals("sand")) {
      return Material.sand;
    } else if (material.equals("snow")) {
      return Material.snow;
    } else if (material.equals("sponge")) {
      return Material.sponge;
    } else if (material.equals("tnt")) {
      return Material.tnt;
    } else if (material.equals("vine")) {
      return Material.vine;
    } else if (material.equals("water")) {
      return Material.water;
    } else if (material.equals("web")) {
      return Material.web;
    } else if (material.equals("wood")) {
      return Material.wood;
    } else {
      return Material.rock;
    }
  }
}