package me.otho.customItems.configuration.jsonReaders.blocks;

import me.otho.customItems.configuration.jsonReaders.common.Cfg_basicData;

public class Cfg_fluid extends Cfg_basicData
{
	public int luminosity = 0;
	//public float lightLevel = 0.0f;
	public int density = 1000;
	public int temperature = 300;
	public int viscosity = 1000;
	public boolean isGas = false;
	
	public int flowLength = 8;
	public String color = "000000";
	//public boolean fireSource = false;
}
