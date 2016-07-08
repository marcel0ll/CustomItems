---
layout: wiki
title: Blocks
---

# Blocks
___

**Properties:**

`{name}` - The name of the block

`{textureName}` - The texture name of the block.

`[creativeTab] = "Custom Items"` - What
creative tab the block will show up in.

`[maxStackSize] = 64` - The max stack size for
a block. Min:1, Max:64

`[multipleTextures]` - Inside this property,
additional configurations are used to make multiple textured blocks like
wood, crafting tables, etc. If this properties is set, this block
textureName will be ignored and each of the textures from the
multipleTexture properties will be used.

***Multiple Textures properties:***

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;`{ypos}` - The top side texture of the block

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;`{yneg}` - The bottom side texture of the block

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;`{xpos}` - The east side texture of the block

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;`{xneg}` - The west side texture of the block

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;`{zpos}` - The south texture of the block

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;`{zneg}` - The north texture of the block

`[isOpaque] = true` - Can light pass through
this block

`[type] = "normal" ` - The type of the block.
([ type list](block_type_list "wikilink"))

`[stepSound] = "stone"` - The sound that makes
when you walk on this block. ([ step sound
list](step_sound_list "wikilink"))

`[material] = "rock"` - The block material ([
material list](block_material_list "wikilink"))

`[toolClass]` - The tool to mine this block.
Can be left blank ([ toolClass
list](tool_class_list "wikilink"))

`[resistance] = 10` - How much the block is
resistant to explosion

`[hardness] = 2` - How hard is to mine this
block

`[lightLevel] = 0; ` - (min: 0.0, max: 1.0) -
The light level from a block. Glowstone = 1.0, Stone = 0.0

`[harvestLevel] = 0` - The level of the pickaxe
needed to mine the block. This doesn't apply to shovel blocks or axe
blocks. The following link shows the equivalent numerical value for
vanilla tools. ([harvestLevel list](harvest_level_list "wikilink"))

`[slipperiness] = 0.6f` - CommonBlocks: 0.6,
ice: 0.98

`[breaks] = false` - If the block breaks when
harvested without silkTouch, like glass

`[canSilkHarvest] = false` - If harvested with
a silktouch enchanted tool, will it drop the block or not? Set this to
true in your glass like blocks

`[dropItemName]` - The name of the item that is
dropped when harvesting this block. If there is a item set, the block
won't drop an item block of this block.

`[minItemDrop] = 1` - The minimum ammount of
items to drop from this block

`[maxItemDrop] = 1` - The maximum ammount of
items to drop from this block

`[eachExtraItemDropChance] = 50` - What is the
chance to drop each item after the minimum ammount

**Format Example:**

``` json
{
    "blocks": [
        {
            "name": "Block 1",
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
            "multipleTextures": {
                "yneg": "side_1",
                "ypos": "side_2",
                "zneg": "side_3",
                "zpos": "side_4",
                "xneg": "side_5",
                "xpos": "side_6"
            }
        },
        {
            "name": "Block X",
            "creativeTab": "Random Tab",
            "textureName": "BlockXTextureName",
            "material": "Material",
            "toolClass": "ToolClass",
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

**Properties:**

`{name}` - The name of the block

`{textureName}` - The texture name of the block.

`[creativeTab] = "Custom Items"` - What
creative tab the chest block will show up in.

`[invName] = "Custom Chest"` - The chest name
that will appear inside the invetory UI

`[hasOwner] = false` - This is a test
propertie, use at your own risk. When this is true, only the person that
put the chest down will be able to open it, but it will still interact
with hoppers and stuff.

`[invWidth] = 3` - The number of collumns that
the inventory has. For now the limit is 9.

`[invHeight] = 3` - The number of rows that the
inventory has. For now the limit is 6.

`[slotMaxStackSize] = 64` - The size of the
stack that can be stored in the inventory slot. By the default it is 64
(a normal stack). But it can be set to store only 1 item per slot, or
124 or 75

>***IMPORTANT:*** A chest block **IS** a block. So some properties from
>blocks are valid for a chest block. Like lightlevel. Allowed block
>properties: hardness, resistance, lightLevel, harvestLevel,
>slipperiness, isOpaque, stepsound, and multipletextures. Please check
>the block properties section for further info.

**Format Example:**

``` json
{
    "chests": [
        {
            "name": "Chest1",
            "textureName": "chest1TextureName"
        },
        {
            "name": "Chest2",
            "textureName": "chest2TextureName",
            "slotMaxStackSize": 16
        },
        {
            "name": "ChestN",
            "textureName": "chestNTextureName",
            "invWidth": 1,
            "invHeight": 6,
            "lightLevel": 1
        }
    ]
}
```

# Crops
___

**Properties:**

`{name}` - The name of the crop and the seed

`{textureName}` - The texture name of the crop
block and the seed.

`[creativeTab] = "Custom Items"` - What
creative tab the crop and seeds will show up in.

`{fruitName}` - The item that will be dropped as
a fruit. Ex.: "minecraft:apple"

`[renderType] = "crops"` - The block render
type. How the block renders, like a torch or like a normal block. For
crops there is two options "crops" or "flower"

`[dropFromGrassChance] = 10` - The chance to
drop the seed from grass block. min:0 max:100

`[dropSeedWhenMature] = true` - If false the
crop wont drop seed when harvested

`[acceptBoneMeal] = true` - If false it wont be
possible to use bonemeal in this crop

`[minFruitDrop] = 1` - The minimum ammount of
fruits to drop when harveting a mature crop. min = 0

`[maxFruitDrop] = 1` - The maximum ammount of
fruits to drop when harveting a mature crop

`[minSeedDrop] = 1` - The minimum ammount of
seeds to drop when harveting a mature crop. min = 0

`[maxSeedDrop] = 2` - The maximum ammount of
seeds to drop when harveting a mature crop. min = 0

`[eachExtraSeedDropChance] = 50` - The chance
to drop each extra seed that is more than the min

`[eachExtraFruitDropChance] = 15` - The chance
to drop each extra fruit that is more than the min

>**Observations:**
>
>-   blocks/textureName\#.png will be the crops texture. The \# is for
>    the different levels for crop growth. 4 different levels
>    are required.
>
>-   items/textureName\_seed.png will be the seeds texture.

**Format Example:**

``` json
{
    "crops": [
        {
            "name": "ironia",
            "textureName": "iron_crop",
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
            "name": "golduce",
            "textureName": "gold",
            "fruitName": "minecraft:gold_ingot",
            "renderType": "flower",
            "dropFromGrassChance": 5
        }
    ]
}
```

# Fluids
___

**Properties:**

`{name}` - The name of the fluid

`{textureName}` - The texture name of the fluid.
|***IMPORTANT:*** A total of five files are need to make the fluids
texture work correctly. If you do not know how to make a fluid texture
work correctly or what files are required go to this page. [How to setup
fluid textures.](fluid_texture_tutorial "wikilink")

`[creativeTab] = "Custom Items"` - What
creative tab the fluid will show up in.

`[luminosity] = 0` - The light level from the
fluid block

`[density] = 1000` - Defines what liquids
replace each other when they meet. (like water and oil)

`[temperature] = 300` - At moment this field
makes nothing at all.

`[viscosity] = 1000` - How far/fast a liquid
flows

`[material] = water` - Whether you want it to
be `water` base or `lava`
base. Lava being destructive and water being passive or non damaging.

`[isGas] = false` - Define if the fluid is gas
or liquid

`[flowLength] = 8` - How far does the fluid
flow. The maximum distance is set a 16.

`[bucket]` - Inside this configuration,
additional configurations are used to modify buckets. By default, all
fluids come with a predefined name of a bucket. The fluids name with
bucket after that. Example: `Custom name Bucket`
However, a buckets name can be edit with this configuration.

***Bucket properties:***

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;`{name}` - Name of the bucket without Bucket
after it.

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;`[textureName]` - Texture name for the bucket.

<!-- ***Note:*** The bucket can still get its texture from the default
bucket texture. -->

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;`[maxStackSize] = 1` - The maximum number on a
stack (min: 1, max: 64).

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;`[creativeTab]` - What tab the bucket will show
up in.

**Format Example:**

``` json
{
    "fluids": [
        {
            "name": "Fluid 1",
            "textureName": "fluid1",
            "luminosity": 0,
            "density": 1,
            "temperature": 1,
            "viscosity": 1,
            "isGas": false
        },
        {
            "name": "Fluid 2",
            "textureName": "fluid2",
            "luminosity": 0,
            "density": 1,
            "temperature": 1,
            "viscosity": 1,
            "isGas": false
        },
        {
            "name": "Fluid X",
            "textureName": "fluidX",
            "creativeTab": "Custom Items",
            "flowLength": 4,
            "luminosity": 5,
            "material": "lava",
            "bucket": {
                "name": "bob",
                "maxStackSize": 2
            }
        }
    ]
}
```
