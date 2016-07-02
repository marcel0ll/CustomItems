---
layout: wiki
title: Ore Gen
---

# Ore Generation
___

**Properties:**

`{blockToSpawn}` - Here is where you place the
name of the block you want to generate in the world. Example:
customitems:red\_sand

`{blockToReplace}` - This is the block it will
look for to replace in the world. Example: minecraft:stone

`{dimensionId}` - What dimension will this block
generate in. The following numbers are what indicates the dimension.

> Overworld: 0, The Nether: -1, The End: 1

`[#]` - If you want to have the
ore generate to a specific biome. ([Biome id
List](biome_id_list "wikilink")) Use biome Id according to the dimension.

`{minVeinSize}` - This is the minimum amount of
the block to be generated in a spot.

`{maxVeinSize}` - This is the maximum amount of
the block to be generated in a spot.

`{chancesToSpawn}` - The percentage chance of the
block to be generated.

`{minY}` - This is the lowest level that the
block will generate.

> '**'Note:** Overworld and The Nether level 0 is pure bedrock, while
level 1 - 5 is a mixture of bedrock and other blocks. It may be best to
have the blocks start generating no lower than 6 unless you want the
blocks to generate between bedrock.

`{maxY}` - This is the highest level that the
block will generate.

> ***Note:** The default max height for the Overworld 256. The Nether
level 128 is pure bedrock, while level 124 - 127 is a mixture of bedrock
and Nether blocks. It may be best to have the blocks start generating no
higher than 125 unless you want the blocks to generate between bedrock.*

**Format Example:**

``` json
{
    "oreGen": [
        {
            "blockToSpawn": "customitems:red_sand",
            "blockToReplace": "minecraft:sand",
            "dimensionId": 0,
            "minVeinSize": 10,
            "maxVeinSize": 15,
            "chancesToSpawn": 10,
            "minY": 40,
            "maxY": 90
        }
    ]
}
```
