package me.otho.customItems.utility;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;

import me.otho.customItems.CustomItems;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.item.Item;
import net.minecraft.util.RegistryNamespaced;

public class IdDumper {
	
	private static File idFile;
	private static FileWriter writer;
	private static final String separator = "=========================================================================\n\n";
	
	public static void writeIdFile(File minecraftFolder) throws IOException {
		idFile = new File(minecraftFolder.toString() + File.separator + CustomItems.ID_FILE_NAME);
		writer = new FileWriter(idFile);
		writer.write( "IDs file\n");	
		
		//Dump block ids
		writer.write( "\nBlocks ids \n");
		writer.write( separator );
		
		Iterator<Block> blockIter = Block.blockRegistry.iterator();
		while (blockIter.hasNext() ) {
			Block block = blockIter.next();
			String name = Block.blockRegistry.getNameForObject(block);
			//String id = Integer.toString(Block.blockRegistry.getIDForObject(block));
			writer.write( name + "\n");						
		}	
		
		//Dump item ids
		writer.write( "\nItems ids \n");	
		writer.write( separator );
		
		Iterator<Item> itemIter = Item.itemRegistry.iterator();
		while (itemIter.hasNext() ) {
			Item item = itemIter.next();
			String name = Item.itemRegistry.getNameForObject(item);	
			writer.write( name + "\n");						
		}		
		
		//Dump entities ids
		writer.write( "\nEntities ids \n");
		writer.write( separator );
		
		Collection entities = EntityList.classToStringMapping.values();
		Iterator<String> entityIter = entities.iterator();
		while (entityIter.hasNext() ) {			
			String name = entityIter.next();			
			writer.write( name + "\n");						
		}	
		
		//close file
		writer.close();
	}
	
	
}
