---
layout: wiki
title: Blocks
---

# Blocks
___

**<u>Required Configuration:</u>**

`"name":` - The name of the block

`"textureName":` - The texture name of the block.

>***Note:*** If `"multipleTextures":` is used, this configuration is not required.

**<u>Optional Configuration:</u>**

`"breaks":` - If the block breaks when harvested without silkTouch, like glass. Default value is `"false"`.

`"canSilkHarvest":` - If harvested with a silktouch enchanted tool, will it drop the block or not? Set this to true in your glass like blocks.  Default value is `"false"`.

`"creativeTab":` - What creative tab the block will show up in.  Default value is `"Custom Items"`.

`"dropItemName":` - The name of the item that is dropped when harvesting this block. If there is a item set, the block won`t drop an item block of this block.

`"eachExtraItemDropChance":` - What is the chance to drop each item after the minimum ammount. Default value is `50`.

`"hardness":` - How hard is to mine this block. Default value is `2`.

`"harvestLevel":` - The level of the pickaxe needed to mine the block. This doesn't apply to shovel blocks or axe blocks. The following link shows the equivalent numerical value for vanilla tools. ([harvestLevel list](harvest_level_list "wikilink")) Default value is `0`.

`"isOpaque":` - This sets wheather the block *does not* allow light pass through it. Default value is `"true"`.

`"lightOpacity"` - Value Range: (min: 0, max: 255) - This sets how light travels trough a block. Default value is `2`. Example: Water has a value of 3.


`"lightLevel":` - Value Range: (min: 0, max: 15) - This sets the light level from a block. The values reflect light levels. Default value is `0`.

`"flammability":` - Value Range: (min: 0) - Set how quickly a block can potentially catch fire. Default value is `0`.

>***Note:*** These values are relative values, not exact time values. For more information click here. [Minecraft fire info.](http://minecraft.gamepedia.com/Fire#Burning_blocks)

`"fireEncouragement":` - Value Range: (min: 0) - Set the block's ability to sustain adjacent fire. Default value is `0`.

>***Note:*** These values are relative values, not exact time values. For more information click here. [Minecraft fire info.](http://minecraft.gamepedia.com/Fire#Burning_blocks)

`"material":` - Sets the block to a particular material. ([material list](block_material_list "wikilink")) Default value is `"rock"`.

`"maxItemDrop":` - The maximum ammount of items to drop from this block. Default value is `1`.

`"maxStackSize":` - Value Range:(Min:1, Max:64) - The max stack size for a block. Default value is `64`.

`"minItemDrop":` - The minimum ammount of items to drop from this block. Default value is `1`.

`"multipleTextures":` - Inside this property, additional configurations are used to make multiple textured blocks like wood, crafting tables, etc. If this properties is set, this block textureName will be ignored and each of the textures from the multipleTexture properties will be used.

<p style="padding-left:3%"><strong><em>Multiple Textures properties:</em></strong></p>

<div style="padding-left:4%">
<p><code>ypos</code> - The top side texture of the block</p>

<p><code>yneg</code> - The bottom side texture of the block</p>

<p><code>xpos</code> - The east side texture of the block</p>

<p><code>xneg</code> - The west side texture of the block</p>

<p><code>zpos</code> - The south texture of the block</p>

<p><code>zneg</code> - The north texture of the block</p>
</div>

`"resistance":` - How much the block is resistant to explosion. Default value is `10`.

`"slipperiness":` - Default value is `0.6`. Examples: Common Blocks: 0.6, ice: 0.98.

`"stepSound":` - The sound that makes when you walk on this block. ([ step sound list](step_sound_list "wikilink")) Default value is `"stone"`.

`"toolClass":` - The tool to mine this block.([toolClasslist](tool_class_list "wikilink"))

`"type":` - The type of the block. ([ type list](block_type_list "wikilink")) Default value is `"normal"`.


**<u>Example Configuration:</u>**

``` json
{
    "blocks":
    [
        {
            "name": "Block 1",
            "textureName": "Block1TextureName"
        },
        {
            "name": "Block2",
            "material": "rock",
            "hardness": 1,
            "resistance": 2,
            "lightLevel": 0.2,
            "harvestLevel": 0,
            "dropItemName": "minecraft:apple",
            "minItemDrop": 5,
            "maxItemDrop": 10,
            "eachExtraItemDropChance": 75,
            "multipleTextures":{
                "yneg":"side_1",
                "ypos":"side_2",
                "zneg":"side_3",
                "zpos":"side_4",
                "xneg":"side_5",
                "xpos":"side_6"
            }
        },
        ...
        {
            "name": "Block X",
            "creativeTab": "Random Tab",
            "textureName": "BlockXTextureName",
            "material": "Material",
            "toolClass":"ToolClass",
            "hardness": 0,
            "resistance": 0,
            "lightLevel": 0,
            "harvestLevel": 0
        }
    ]
}
```
# Chest Blocks
___

**<u>Required Configuration:</u>**

`"name":` - The name of the block

`"textureName":` - The texture name of the block.

**<u>Optional Configuration:</u>**

`"creativeTab":` - What creative tab the block will show up in.  Default value is `"Custom Items"`.

`"hasOwner":` - When this is true, only the person that put the chest down will be able to open it, but it will still interact with hoppers and stuff. Default value is `"false"`.

> ***WARNING:***  This is an experimental configuration, use at your own risk.

`"invHeight":` - Value Range(max: 6) - This sets the number of rows that the inventory has. Default value is `3`.

`"invName":` - This sets the chest name in the invetory UI. Default value is `"Custom Chest"`.

`"invWidth":` - Value Range(max: 9) - This sets the number of collumns that the inventory. Default value is `3`.

`"slotMaxStackSize":` - The size of the stack that can be stored per inventory slot. Default value is `64`.

>***Note:*** A chest block **IS** a block. So some properties from blocks are valid for a chest block. Like lightlevel. The following are aloud block configuration: hardness, resistance, lightLevel, harvestLevel, slipperiness, isOpaque, stepsound, and multipletextures. Please check the block configuration section for further info on each of these options. 

**Format Example:**

``` json
{
    "chests":[
        {
            "name": "Chest1",
            "textureName": "chest1TextureName",
        },
        {
            "name": "Chest2",
            "textureName": "chest2TextureName",
            "slotMaxStackSize": 16
        },
        ...
        {
            "name": "ChestN",
            "textureName": "chestNTextureName",
            "invWidth": 1,
            "invHeight": 6,
            "lightLevel": 1.0
        }
    ]
}
```

# Crops
___

**<u>Required Configuration:</u>**

`"name":` - The name of the block

`"textureName":` - The texture name of the block.

`"fruitName":` - Set the id for the item or block to be dropped when the crop is broken on maturity. Example of id structure: "minecraft:wheat", "minecraft:stone"

**<u>Optional Configuration:</u>**

`"acceptBoneMeal":` - Sets wheather a crop will except Bone Meal to grow. Default value is `"true"`.

`"creativeTab":` - What creative tab the block will show up in.  Default value is `"Custom Items"`.

`"dropFromGrassChance":` - Value Range:(Min:0, Max:100) - The chance to drop the seed from grass block. Default value is `10`.

`"dropSeedWhenMature":` - This enables seeds to be dropped from crops. If false, crops will not drop seeds when harvested. Default value is `"true"`.

`"eachExtraFruitDropChance":` - Value Range:(Min:0, Max:100) - Sets the percentage chance for an extra "fruit" to drop. Default value is `15`.

`"eachExtraSeedDropChance":` - Value Range:(Min:0, Max:100) - Sets the percentage chance for an extra seed to drop. Default value is `50`.

`"maxFruitDrop":` - The maximum ammount of "fruits" to drop when harveting a mature crop. Default value is `1`.

`"maxSeedDrop":` - The maximum ammount of seeds to drop when harveting a mature crop. Default value is `2`.

`"minFruitDrop":` - The minimum ammount of "fruits" to drop when harveting a mature crop. Default value is `1`.

`"minSeedDrop":` - The minimum ammount of seeds to drop when harveting a mature crop. Default value is `1`.

`"renderType":` - Value Options:(`"crops"`,`"flower"`) - This sets how crops block will render or look like. The `"crops"` value will render the crops similar how Wheat crops are layed out. The `"flower"` value will render the crops similar to a Minecraft Dandelion. Default value is `"crops"`.

>**Notes:**
>
>-   blocks/textureName\#.png will be the crops texture. The \# is for the different levels for crop growth. 4 different levels are required.
>
>-   items/textureName\_seed.png will be the seeds texture.

**Format Example:**

``` json
{
    "crops":
    [
        {
            "name": "ironia",
            "textureName":"iron_crop",
            "fruitName": "minecraft:iron_ingot",
            "renderType": "crop",
            "dropFromGrassChance": 10,
            "dropSeedWhenMature": true,
            "acceptBoneMeal": true,
            "minFruitDrop": 1,
            "maxFruitDrop": 1,
            "minSeedDrop": 1,
            "maxSeedDrop": 2,
            "eachExtraSeedDropChance": 50,
            "eachExtraFruitDropChance": 15
        },
        {
            "name":"golduce",
            "textureName":"gold",
            "fruitName": "minecraft:gold_ingot",
            "renderType": "flower",
            "dropFromGrassChance": 5
        }
    ]
}
```

# Fluids
___

**<u>Required Configuration:</u>**

`"name":` - The name of the block

`"textureName":` - The texture name of the block.

>***Note:*** A total of five files are need to make the fluids texture work correctly. If you do not know how to make a fluid texture work correctly or what files are required go to this page. [How to setup fluid textures.](fluid_texture_tutorial "wikilink")

**<u>Optional Configuration:</u>**

`"bucket":` - Inside this configuration, additional configurations are used to modify buckets. By default, all fluids come with a predefined name of a bucket. The fluids name with bucket after that. Example: <code>Custom name Bucket</code>. However, a buckets name can be edit with this configuration.</p>

<p style="padding-left:3%"><strong><em>Bucket Configuration:</em></strong></p>

<div style="padding-left:4%">
<p><code>"creativeTab":</code> - What tab the bucket will show up in.</p>

<p><code>"name":</code> - Name of the bucket without Bucket after it.</p>

<p><code>"maxStackSize":</code> - Value Range:(min: 1, max: 64) - The maximum number on a stack. Default value is <code>1</code>.</p>

<p><code>"textureName":</code> - Texture name for the bucket.</p>

***Note:*** The bucket can still get its texture from the default bucket texture.
</div>

`"creativeTab":` - What creative tab the block will show up in.  Default value is `"Custom Items"`.

`"density":` - Defines what liquids replace each other when they meet. Example: Water and oil. Default value is `1000`. 

`"flowLength": - Value Range:(min:0 max:16) - How far does the fluid flow. Default value is `8`. 

`"isGas":` - Define if the fluid as a gas or liquid. Set the value to true will cause your fluid to flow upward (like some gases). Default value is `false'

`"luminosity":` - Value Range: (min: 0.0, max: 1.0) - Set the light level from the fluid block. Default value is `0`. Examples: Glowstone = 1.0, Stone = 0.0

`"material":` - Value Options:(`'water"`,`"lava"`) - Setting it to `"lava"` will case the fluid to be destructive.`"water"` will be passive or non damaging. Default value `water`.

`"temperature":` - At moment this field does nothing. Default value `300`.

`"viscosity":` - How far/fast a liquid flows. Default value `1000`.


**Format Example:**

``` json
{
   "fluids":[
       {
       "name":"Fluid 1",
       "textureName":"fluid1",
       "luminosity": 0,
       "density": 1,
       "temperature": 1,
       "viscosity": 1,
       "isGas": false
       },
       {
       "name":"Fluid 2",
       "textureName":"fluid2",
       "luminosity": 0,
       "density": 1,
       "temperature": 1,
       "viscosity": 1,
       "isGas": false
       },
       ...
       {
       "name":"Fluid X",
       "textureName":"fluidX",
       "creativeTab": "Custom Items",
       "flowLength": 4,
       "luminosity": 5,
       "material": "lava",
       "bucket":
           {
               "name":"bob",
               "maxStackSize": 2
           }
       }
    ]
}
```
