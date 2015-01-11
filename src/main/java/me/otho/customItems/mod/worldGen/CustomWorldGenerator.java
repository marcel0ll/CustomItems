package me.otho.customItems.mod.worldGen;

import java.util.Arrays;
import java.util.Random;

import org.apache.commons.lang3.ArrayUtils;

import me.otho.customItems.configuration.JsonConfigurationHandler;
import me.otho.customItems.configuration.jsonReaders.worldGen.Cfg_oreGen;
import me.otho.customItems.utility.LogHelper;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;
import cpw.mods.fml.common.registry.GameRegistry;

public class CustomWorldGenerator implements IWorldGenerator {
	
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world,
			IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		
		int i;

		Cfg_oreGen[] oresToSpawn = JsonConfigurationHandler.allData.oreGen;
		
		if(oresToSpawn != null){
			for(i=0;i < oresToSpawn.length; i++)
			{
				Cfg_oreGen oreInfo = oresToSpawn[i];
				
				if(oreInfo.dimensionId == world.provider.dimensionId){
					
					int toSpawnMetadata = 0;
					int toRelaceMetadata = 0;
					
					String[] parser = oreInfo.blockToSpawn.split(":");
					String modid = parser[0];
					String block = parser[1];
					if(parser.length > 2)
						toSpawnMetadata = Integer.parseInt(parser[2]);
					
					Block oreBlock = (Block) GameRegistry.findBlock(modid, block);
					
					parser = oreInfo.blockToReplace.split(":");
					modid = parser[0];
					block = parser[1];
					if(parser.length > 2)
						toRelaceMetadata = Integer.parseInt(parser[2]);
					
					Block toReplace = (Block) GameRegistry.findBlock(modid, block);
					
					BiomeGenBase biome = world.provider.getBiomeGenForCoords(chunkX*16, chunkZ*16);
					if(oreInfo.biomeId == null || Arrays.asList(oreInfo.biomeId).contains(biome.biomeID))					
						this.addOreSpawn(oreBlock, toSpawnMetadata, toReplace, world, random, chunkX*16, chunkZ*16, oreInfo.minVeinSize, oreInfo.maxVeinSize, oreInfo.chancesToSpawn, oreInfo.minY, oreInfo.maxY); 
				}
			}
		}
	}

	public void addOreSpawn(Block block, int metadata, Block toReplace, World world, Random random, int blockXPos, int blockZPos, int minVeinSize, int maxVeinSize, int chancesToSpawn, int minY, int maxY )
    {
		WorldGenMinable minable;
		
		if(metadata == 0){
			minable = new WorldGenMinable(block, (minVeinSize + random.nextInt(maxVeinSize - minVeinSize)), toReplace);
		}else{
			minable = new WorldGenMinable(block, (minVeinSize + random.nextInt(maxVeinSize - minVeinSize)), metadata, toReplace);
		}        
        
        for(int i = 0; i < chancesToSpawn; i++)
        {
            int posX = blockXPos + random.nextInt(16);
            int posY = minY + random.nextInt(maxY - minY);
            int posZ = blockZPos + random.nextInt(16);
            minable.generate(world, random, posX, posY, posZ);
        }
    }


}
