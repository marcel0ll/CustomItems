package me.otho.customItems.mod.worldGen;

import java.util.Random;

import me.otho.customItems.configuration.JsonConfigurationHandler;
import me.otho.customItems.configuration.jsonReaders.worldGen.Cfg_oreGen;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;

public class CustomWorldGenerator implements IWorldGenerator {

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world,
			IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		
		int i;

		Cfg_oreGen[] oresToSpawn = JsonConfigurationHandler.allData.oreGen;
		
		
		for(i=0;i < oresToSpawn.length; i++)
		{
			Cfg_oreGen oreInfo = oresToSpawn[i];
			
			if(oreInfo.dimensionId == world.provider.dimensionId){
				Block oreBlock = (Block) Block.blockRegistry.getObject(oreInfo.blockToSpawn);
				Block toReplace = (Block) Block.blockRegistry.getObject(oreInfo.blockToReplace);
				
				this.addOreSpawn(oreBlock, toReplace, world, random, chunkX*16, chunkZ*16, oreInfo.minVeinSize, oreInfo.maxVeinSize, oreInfo.chancesToSpawn, oreInfo.minY, oreInfo.maxY); 
			}
		}
	}

	public void addOreSpawn(Block block, Block toReplace, World world, Random random, int blockXPos, int blockZPos, int minVeinSize, int maxVeinSize, int chancesToSpawn, int minY, int maxY )
    {
        WorldGenMinable minable = new WorldGenMinable(block, (minVeinSize + random.nextInt(maxVeinSize - minVeinSize)), toReplace);
        for(int i = 0; i < chancesToSpawn; i++)
        {
            int posX = blockXPos + random.nextInt(16);
            int posY = minY + random.nextInt(maxY - minY);
            int posZ = blockZPos + random.nextInt(16);
            minable.generate(world, random, posX, posY, posZ);
        }
    }


}
