package me.otho.customItems.configuration.jsonReaders.blocks;

import me.otho.customItems.configuration.jsonReaders.common.Cfg_basicData;

public class Cfg_crop extends Cfg_basicData
{
    public String fruitName;
    public int dropFruitDamage = 0;
    public String renderType = "crops";
    public int dropFromGrassChance = 10;
    public boolean dropSeedWhenMature = true;
    public boolean acceptBoneMeal = true;
    public int minFruitDrop = 1;
    public int maxFruitDrop = 1;
    public int minSeedDrop = 1;
    public int maxSeedDrop = 2;
    public int eachExtraSeedDropChance = 50;
    public int eachExtraFruitDropChance = 15;
}
