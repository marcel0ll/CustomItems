---
layout: default
title: Documentation
permalink: /documentation/
---
#Documentation
{:.no_toc}
* TOC
{:toc}
___

#<a name="readme" href="#readme">Read Me</a>
___

All Properties inside {} are **REQUIRED** configurations.

All Properties inside \[] are **OPTIONAL** configurations.

Values after a '=' is a properties **DEFAULT** value.

All custom blocks and items have a special OPTIONAL properties called
`[registerOrder]` that can be used to sort
blocks and items ids while registering. The greater the registerOrder
the later the item will be registered.

#<a name="calculations" href="#calculations"> Calculations </a>
___

If you are looking for a formula to tell you how long it will take
something like a block breaking. Look no further, this is where you need
to be. The following are just a few that might help you.

[Block Breaking Formula](Block_Breaking_Formula "wikilink")

#<a name="custom_config" href="#custom_config"> Custom Configuration Files </a>
___

Before you start off making your own config files, I recommend using the
following template to get you started and familiar with how the
configurations work. ***[ The config template is on this
page.](Base_Config_File "wikilink")*** You could also use the default
config files when you set restore default config to true in CI's .cfg
file. By default it is set to false. CI has a .cfg file for general
configurations.

All files for CI should be saved as *`.json`*
file in
*`"minecraftInstance/config/customItems"`* Any
text editor can be used to make .json file, so long as you put it after
the name of the file. The mod allows multiple configuration files so can
group custom items instead of having a long list. The file name is not
used in the name, merely for you to know what custom items are where.

#<a name="armor" href="#armor"> Armor (Armour) </a>
___

### <a name="boots" href="#boots"> Boots </a>

___

**Properties:**

`{name}` - The name of the armor

`{textureName}` - The texture name of the armor.

`[creativeTab] = "Custom Items"` - What
creative tab the boots will show up in.

`[durability] = 5` - How much it can take
before breaking

`[reduction] = 2` - How much damage it reduces
when damaged

`[enchantability] = 15` - How easily this armor
will be enchanted

>**Observations:**
>
>-   The item texture will be textureName\_boots
>
>-   The armor texture must have two layers textureName\_layer\_1 and
>    textureName\_layer\_2

**Format Example:**


    {
        "boots":
        [
            {
                "name":"boots 1",
                "textureName":"boots1",
                "durability":1,
                "reduction":1,
                "enchantability":30
            },
            ...
            {
                "name":"boots X",
                "textureName":"bootsX",
                "durability":1,
                "reduction":1,
                "enchantability":30
            }
        ]
    }


### <a name="chestplates" href="#chestplates"> Chestplates </a>

___

**Properties:**

`{name}` - The name of the armor

`{textureName}` - The texture name of the armor.

`[creativeTab] = "Custom Items"` - What
creative tab the chestplate will show up in.

`[durability] = 5` - How much it can take
before breaking

`[reduction] = 2` - How much damage it reduces
when damaged

`[enchantability] = 15` - How easily this armor
will be enchanted

>**Observations:**
>
>-   The item texture will be textureName\_chestplate
>
>-   The armor texture must have two layers textureName\_layer\_1 and
>    textureName\_layer\_2

**Format Example:**

	{
	    "chestplates":
	    [
	        {
	            "name":"chestplate 1",
	            "textureName":"chestplate1",
	            "durability":1,
	            "reduction":1,
	            "enchantability":30
	        },
	        ...
	        {
	            "name":"chestplate X",
	            "textureName":"chestplateX",
	            "durability":1,
	            "reduction":1,
	            "enchantability":30
	        }
	    ]
	}

### <a name="helmets" href="#helmets" > Helmets </a>

___

**Properties:**

`{name}` - The name of the armor

`{textureName}` - The texture name of the armor.

`[creativeTab] = "Custom Items"` - What
creative tab the helmet will show up in.

`[durability] = 5` - How much it can take
before breaking

`[reduction] = 2` - How much damage it reduces
when damaged

`[enchantability] = 15` - How easily this armor
will be enchanted

>**Observations:**
>
>-   The item texture will be textureName\_helmet
>
>-   The armor texture must have two layers textureName\_layer\_1 and
>    textureName\_layer\_2

**Format Example:**

	{
	    "helmets":
	    [
	        {
	            "name":"Helmet 1",
	            "textureName":"Helmet1",
	            "durability":1,
	            "reduction":1,
	            "enchantability":30
	        },
	        ...
	        {
	            "name":"Helmet X",
	            "textureName":"HelmetX",
	            "durability":1,
	            "reduction":1,
	            "enchantability":30
	        }
	    ]
	}

### <a name="leggings" href="#leggings" > Leggings </a>

___

**Properties:**

`{name}` - The name of the armor

`{textureName}` - The texture name of the armor.

`[creativeTab] = "Custom Items"` - What
creative tab the leggings will show up in.

`[durability] = 5` - How much it can take
before breaking

`[reduction] = 2` - How much damage it reduces
when damaged

`[enchantability] = 15` - How easily this armor
will be enchanted

>**Observations:**
>
>-   The item texture will be textureName\_leggings
>
>-   The armor texture must have two layers textureName\_layer\_1 and
>    textureName\_layer\_2

**Format Example:**

	{
	    "leggings":
	    [
	        {
	            "name":"leggings 1",
	            "textureName":"leggings1",
	            "durability":1,
	            "reduction":1,
	            "enchantability":30
	        },
	        ...
	        {
	            "name":"leggings X",
	            "textureName":"leggingsX",
	            "durability":1,
	            "reduction":1,
	            "enchantability":30
	        }
	    ]
	}

#<a name="blocks" href="#blocks" > Blocks </a>
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
([ type list](type_list "wikilink"))

`[stepSound] = "stone"` - The sound that makes
when you walk on this block. ([ step sound
list](step_sound_list_1.0_beta_4 "wikilink"))

`[material] = "rock"` - The block material ([
material list](material_list_1.0_beta_4 "wikilink"))

`[toolClass]` - The tool to mine this block.
Can be left blank ([ toolClass
list](toolClass_list_1.0_beta_4 "wikilink"))

`[resistance] = 10` - How much the block is
resistant to explosion

`[hardness] = 2` - How hard is to mine this
block

`[lightLevel] = 0; ` - (min: 0.0, max: 1.0) -
The light level from a block. Glowstone = 1.0, Stone = 0.0

`[harvestLevel] = 0` - The level of the pickaxe
needed to mine the block. This doesn't apply to shovel blocks or axe
blocks. The following link shows the equivalent numerical value for
vanilla tools. ([harvestLevel list](harvestLevel_list "wikilink"))

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

	{
	    "blocks":
	    [
	        {
	            "name": "Block 1",
	            "textureName": "Block1TextureName",
	        },
	        {
	            "name": "Block2",
	            "material": "rock",
	            "hardness": 1,
	            "resistance": 2,
	            "lightLevel": 0.2,
	            "harvestLevel": 0,
	            "dropItemName": "minecraft:apple",
	            "minItemDrop": 5,
	            "maxItemDrop": 10,
	            "eachExtraItemDropChance": 75,
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
	            "name": "Block X",
	            "creativeTab": "Random Tab",
	            "textureName": "BlockXTextureName",
	            "material": "Material",
	            "toolClass":"ToolClass",
	            "hardness": 0,
	            "resistance": 0,
	            "lightLevel": 0,
	            "harvestLevel": 0
	        }
	    ]
	}

#<a name="chest_blocks" href="#chest_blocks" > Chest Blocks </a>
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

	{
	    "chests":[
	        {
	            "name": "Chest1",
	            "textureName": "chest1TextureName",
	        },
	        {
	            "name": "Chest2",
	            "textureName": "chest2TextureName",
	            "slotMaxStackSize": 16
	        },
	        ...
	        {
	            "name": "ChestN",
	            "textureName": "chestNTextureName",
	            "invWidth": 1,
	            "invHeight": 6,
	            "lightLevel": 1.0
	        }
	    ]
	}

#<a name="creative_tabs" href="#creative_tabs" > Creative Tabs </a>
___

**Properties:**

`{tabLabel}` - The label that will show when
passing the mouse over the tab

`[iconItem] = "minecraft:item_frame"` - The
item that will show on the creative tab

**Format Example:**

	{
	    "creativeTabs":[
	        {
	            "tabLabel":"newTab1",
	            "iconItem":"customItems:yourNewItem"
	        },
	        {
	            "tabLabel":"newTab2",
	            "iconItem":"minecraft:torch"
	        },
	        ...
	        {
	            "tabLabel":"newTabN",
	        }
	    ]
	}

#<a name="crops" href="#crops"> Crops </a>
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

	{
	    "crops":
	    [
	        {
	            "name": "ironia",
	            "textureName":"iron_crop",
	            "fruitName": "minecraft:iron_ingot",
	            "renderType": "crop",
	            "dropFromGrassChance": 10,
	            "dropSeedWhenMature": true,
	            "acceptBoneMeal": true,
	            "minFruitDrop": 1,
	            "maxFruitDrop": 1,
	            "minSeedDrop": 1,
	            "maxSeedDrop": 2,
	            "eachExtraSeedDropChance": 50,
	            "eachExtraFruitDropChance": 15
	        },
	        {
	            "name":"golduce",
	            "textureName":"gold",
	            "fruitName": "minecraft:gold_ingot",
	            "renderType": "flower",
	            "dropFromGrassChance": 5
	        }
	    ]
	}

#<a name="fluids" href="#fluids"> Fluids </a>
___

**Properties:**

`{name}` - The name of the fluid

`{textureName}` - The texture name of the fluid.
|***IMPORTANT:*** A total of five files are need to make the fluids
texture work correctly. If you do not know how to make a fluid texture
work correctly or what files are required go to this page. [How to setup
fluid textures.](Fluid_Texture_Tutorial "wikilink")

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

    {
	   "fluids":[
	       {
	       "name":"Fluid 1",
	       "textureName":"fluid1",
	       "luminosity": 0,
	       "density": 1,
	       "temperature": 1,
	       "viscosity": 1,
	       "isGas": false
	       },
	       {
	       "name":"Fluid 2",
	       "textureName":"fluid2",
	       "luminosity": 0,
	       "density": 1,
	       "temperature": 1,
	       "viscosity": 1,
	       "isGas": false
	       },
	       ...
	       {
	       "name":"Fluid X",
	       "textureName":"fluidX",
	       "creativeTab": "Custom Items",
	       "flowLength": 4,
	       "luminosity": 5,
	       "material": lava
	       "bucket":
	           {
	               "name":"bob",
	               "maxStackSize": 2
	           }
	       }
        ]
    }

#<a name="foods" href="#foods" > Foods </a>
___

**Properties:**

`{name}` - The name of the food

`{textureName}` - The texture name of the food.

`[creativeTab] = "Custom Items"` - What
creative tab the food will show up in.

`[healAmount] = 1` - How much hunger points
this food gives

`[saturationModifier] = 1.0` - It is a hidden
value that increases when you eat just like hunger. Your hungerbar will
only start to decrease after your saturation has reached 0. For further
info, check [minecraft wiki](http://minecraft.gamepedia.com/Hunger)

`[alwaysEdible] = false ` - Defines if you can
or not eat this food with a full hunger bar

`[isWolfFood] = false ` - Can a wolf/dog eat
this food

`[useAction] = eat` - Plays a eatting or
drinking sounds on consumption of food item. The two options are eat or
drink. `eat` - For solid foods like bread ,
porkchops, etc... `drink` - For liquids like
potions.

`[dropItemName] = ` - What is the returned item
or container after consuming food. Example: After having soup it return
a bowel.

`[potionEffects]` - Foods can have potion
effect, like raw chicken or zombie flesh. This is an OPTIONAL propertie,
that has its own properties. Each food can have multiple potionEffects,
each with its own properties.

***Potion Effect Properties:***

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;`[effect] = "moveSpeed"` - There is a list of
buffs/debuffs possible ([effects
list](effects_list_1.0_beta_4 "wikilink"))

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;`[potionDuration] = 20` - How many SECONDS the
effect will last

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;`[potionAmplifier] = 1` - Slow II ... II is the
amplifier. It makes the effect stronger

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;`[potionEffectProbability] = 1,0` - (min: 0.0,
max: 1.0) The chance of the potion effect happening when eating the food

**Format Example:**

	{
	    "foods":
	    [
	       {
	           "name":"food 1",
	           "textureName":"food1",
	               "healAmount": 1,
	           "saturationModifier":1,
	           "potionEffects":
	           [
	                    {
	               "effect": "effect",
	               "potionDuration": 1,
	               "potionAmplifier": 1,
	               "potionEffectProbability": 1.0
	                    }
	           ]
	       },
	       {
	           "name":"food 2",
	           "textureName":"food2",
	               "healAmount": 1,
	               "creativeTab": "Random Tab",
	           "saturationModifier": 1
	          "
	       },
	           ...
	       {
	           "name":"food X",
	           "textureName":"foodX",
	               "healAmount": 1,
	           "saturationModifier":1,
	           "potionEffects":
	           [
	                    {
	               "effect": "effect",
	               "potionDuration": 1,
	               "potionAmplifier": 1,
	               "potionEffectProbability": 1.0
	                    },
	                    {
	               "effect": "effect2",
	               "potionDuration": 1,
	               "potionAmplifier": 1,
	               "potionEffectProbability": 1.0
	                    }
	               ]
	       }
        ]
	}

#<a name="items" href="#items" > Items </a>
___

**Properties:**

`{name}` - The name of the item

`{textureName}` - The texture name of the item.

`[creativeTab] = "Custom Items"` - What
creative tab the item will show up in.

`[maxstackSize] = 64` - The maximum number on a
stack (min: 1, max: 64)

`[glows] = false` - Set to true gives the item
an enchanted sparkle.

**Format Example:**

	{
	    "items":
	    [
	        {
	            "name":"Item 1",
	            "textureName":"item1",
	            "creativeTab":"Custom Items",
	            "maxstackSize": 1-64
	        },
	        {
	            "name":"Item 2",
	            "textureName":"item2",
	            "creativeTab":"Custom Items",
	            "maxstackSize": 1-64
	        },
	        ...
	        {
	            "name":"Item X",
	            "textureName":"itemX",
	            "maxstackSize": 1-64
	        }
	    ]
	}

#<a name="tools" href="#tools" > Tools </a>
___

### <a name="axes" href="#axes" > Axes </a>

___

**Properties:**

`{name}` - The name of the tool

`{textureName}` - The texture name of the tool.

`[creativeTab] = "Custom Items"` - What
creative tab the tool will show up in.

`[maxUses] = 59` - How many times this item can
be used. Durability.

`[efficiencyOnProperMaterial] = 2` - How
efficient a tool is on the proper material. It is also know as the
Breaking Multiplier on Minecraft wiki
[here](http://minecraft.gamepedia.com/Breaking?cookieSetup=true#Speed).
The [Material Multiplier](Material_Multiplier "wikilink") page will show
you a relative number to Minecraft tools.

`[damageVsEntity] = 0` - How much damage it
does on entities (zombies, chickes, other players)

`[enchantability] = 15` - How easily this tool
will be enchanted

**Format Example:**

	{
	    "axes":
	    [
	        {
	            "name":"axe 1",
	            "textureName":"axe1",
	            "maxUses":1,
	            "efficiencyOnProperMaterial":1,
	            "damageVsEntity":0,
	            "enchantability":1
	        },
	        ...
	        {
	            "name":"axe X",
	            "textureName":"axeX",
	            "maxUses":1,
	            "efficiencyOnProperMaterial":1,
	            "damageVsEntity":0,
	            "enchantability":1
	        }
	    ]
	}

### <a name="hoes" href="#hoes" > Hoes </a>
___

**Properties:**

`{name}` - The name of the tool

`{textureName}` - The texture name of the tool.

`[creativeTab] = "Custom Items"` - What
creative tab the tool will show up in.

`[maxUses] = 59` - How many times this item can
be used. Durability.

`[efficiencyOnProperMaterial] = 2` - How
efficient a tool is on the proper material. It is also know as the
Breaking Multiplier on Minecraft wiki
[here](http://minecraft.gamepedia.com/Breaking?cookieSetup=true#Speed).
The [Material Multiplier](Material_Multiplier "wikilink") page will show
you a relative number to Minecraft tools.

`[damageVsEntity] = 0` - How much damage it
does on entities (zombies, chickes, other players)

`[enchantability] = 15` - How easily this tool
will be enchanted

**Format Example:**

	{
	    "hoes":
	    [
	        {
	            "name":"hoe 1",
	            "textureName":"hoe1",
	            "maxUses":1,
	            "efficiencyOnProperMaterial":1,
	            "damageVsEntity":0,
	            "enchantability":1
	        },
	        ...
	        {
	            "name":"hoe X",
	            "textureName":"hoeX",
	            "maxUses":1,
	            "efficiencyOnProperMaterial":1,
	            "damageVsEntity":0,
	            "enchantability":1
	        }
	    ]
	}

### <a name="pickaxes" href="#pickaxes" > Pickaxes </a>
___

**Properties:**

`{name}` - The name of the tool

`{textureName}` - The texture name of the tool.
path:resourcepack/customItems/textures/items/textureName.png

`[creativeTab] = "Custom Items"` - What
creative tab the tool will show up in.

`[harvestLevel] = 0` - The level that a pickaxe
can mine. The following link shows the equivalent numerical value for
vanilla tools. ([harvestLevel list](harvestLevel_list "wikilink"))

`[maxUses] = 59` - How many times this item can
be used. Durability.

`[efficiencyOnProperMaterial] = 2` - How
efficient a tool is on the proper material. It is also know as the
Breaking Multiplier on Minecraft wiki
[here](http://minecraft.gamepedia.com/Breaking?cookieSetup=true#Speed).
The [Material Multiplier](Material_Multiplier "wikilink") page will show
you a relative number to Minecraft tools.

`[damageVsEntity] = 0` - How much damage it
does on entities (zombies, chickes, other players)

`[enchantability] = 15` - How easily this tool
will be enchanted

**Format Example:**

	{
	    "pickaxes":
	    [
	        {
	            "name":"pickaxe 1",
	            "textureName":"pickaxe1",
	            "harvestLevel":1,
	            "maxUses":1,
	            "efficiencyOnProperMaterial":1,
	            "damageVsEntity":0,
	            "enchantability":1
	        },
	        ...
	        {
	            "name":"pickaxe X",
	            "textureName":"pickaxeX",
	            "harvestLevel":1,
	            "maxUses":1,
	            "efficiencyOnProperMaterial":1,
	            "damageVsEntity":0,
	            "enchantability":1
	        }
	    ]
	}

### <a name="shovels" href="#shovels" > Shovels </a>
___

**Properties:**

`{name}` - The name of the tool

`{textureName}` - The texture name of the tool.

`[creativeTab] = "Custom Items"` - What
creative tab the tool will show up in.

`[maxUses] = 59` - How many times this item can
be used. Durability.

`[efficiencyOnProperMaterial] = 2` - How
efficient a tool is on the proper material. It is also know as the
Breaking Multiplier on Minecraft wiki
[here](http://minecraft.gamepedia.com/Breaking?cookieSetup=true#Speed).
The [Material Multiplier](Material_Multiplier "wikilink") page will show
you a relative number to Minecraft tools.

`[damageVsEntity] = 0` - How much damage it
does on entities (zombies, chickes, other players)

`[enchantability] = 15` - How easily this tool
will be enchanted

**Format Example:**

	{
	    "shovels":
	    [
	        {
	            "name":"shovel 1",
	            "textureName":"shovel1",
	            "maxUses":1,
	            "efficiencyOnProperMaterial":1,
	            "damageVsEntity":0,
	            "enchantability":1
	        },
	        ...
	        {
	            "name":"shovel X",
	            "textureName":"shovelX",
	            "maxUses":1,
	            "efficiencyOnProperMaterial":1,
	            "damageVsEntity":0,
	            "enchantability":1
	        }
	    ]
	}

### <a name="swords" href="#swords" > Swords </a>
___

**Properties:**

`{name}` - The name of the tool

`{textureName}` - The texture name of the tool.

`[creativeTab] = "Custom Items"` - What
creative tab the tool will show up in.

`[maxUses] = 59` - How many times this item can
be used. Durability.

`[efficiencyOnProperMaterial] = 2` - How
efficient a tool is on the proper material. It is also know as the
Breaking Multiplier on Minecraft wiki
[here](http://minecraft.gamepedia.com/Breaking?cookieSetup=true#Speed).
The [Material Multiplier](Material_Multiplier "wikilink") page will show
you a relative number to Minecraft tools.

`[damageVsEntity] = 0` - How much damage it
does on entities (zombies, chickes, other players)

`[enchantability] = 15` - How easily this tool
will be enchanted

**Format Example:**

	{
	    "pickaxes":
	    [
	        {
	            "name":"sword 1",
	            "textureName":"sword1",
	            "maxUses":1,
	            "efficiencyOnProperMaterial":1,
	            "damageVsEntity":0,
	            "enchantability":1
	        },
	        ...
	        {
	            "name":"sword X",
	            "textureName":"swordX",
	            "maxUses":1,
	            "efficiencyOnProperMaterial":1,
	            "damageVsEntity":0,
	            "enchantability":1
	        }
	    ]
	}

#<a name="change_existing_properties" href="#change_existing_properties" > Changing Existing Properties </a>
___

Tired of how the default Minecraft has done with its blocks or items.
You now can change the properties of default blocks and items.

###<a name="change_existing_blocks" href="#change_existing_blocks" > Change Existing Blocks </a>
___

**Properties:**

`{name}` - The name that the item is registered.
Like: "minecraft:apple"

`{maxStackSize}` - The max stack size for an
item. Min:1, Max:64

`[toolClass]` - The tool to mine this block ([
toolClass list](toolClass_list_1.0_beta_4 "wikilink"))

`[resistance]` - How much the block is
resistant to explosion

`[hardness]` - How hard is to mine this block

`[lightLevel]` - (min: 0.0, max: 1.0) - The
light level from a block. Glowstone = 1.0, Stone = 0.0

`[harvestLevel]` - The level of the pickaxe
needed to mine the block. This doesn't apply to shovel blocks or axe
blocks. The following link shows the equivalent numerical value for
vanilla tools. ([harvestLevel list](harvestLevel_list "wikilink"))

`[slipperiness]` - CommonBlocks: 0.6, ice: 0.98

`[isOpaque]` - Can light pass through this
block

`[stepSound]` - The sound that makes when you
walk on this block. ([ step sound
list](step_sound_list_1.0_beta_4 "wikilink"))

**Format Example:**

	{
	    "changeBlocks":[
	        {
	            "name":"minecraft:cactus",
	            "maxStackSize": 6,
	            "stepSound": "glass",
	            "lightLevel": 0.5,
	            "harvestLevel": 3,
	            "toolClass": "shovel"
	        },
	        {
	            "name":"minecraft:gravel",
	            "maxStackSize": 17,
	            "slipperiness": 0.3
	        },
	        {
	            "name":"minecraft:stone",
	            "maxStackSize": 4,
	            "hardness": -1.0,
	            "resistance": 6000000.0
	        }
	    ]
	}

###<a name="change_existing_items" href="#change_existing_items" > Change Existing Items </a>
___

**Properties:**

`{name}` - The name that the item is registered.
Like: "minecraft:apple"

`{maxStackSize}` - The max stack size for an
item. Min:1, Max:64

**Format Example:**

	{
	    "changeItems":[
	        {
	            "name":"minecraft:apple",
	            "maxStackSize": 3
	        },
	        {
	            "name":"minecraft:cookie",
	            "maxStackSize": 17
	        },
	        {
	            "name":"customitems:coin",
	            "maxStackSize": 4
	        }
	    ]
	}

###<a name="change_existing_foods" href="#change_existing_foods" > Change Existing Foods </a>
___

**Properties:**

`{name} ` - The name of the food

`[maxStackSize] ` - The max stack size for an
item. Min:1, Max:64

`[healAmount] = 1 ` - How much hunger points
this food gives.

`[saturationModifier] = 1 ` - It is a hidden
value that increases when you eat just like hunger. Your hungerbar will
only start to decrease after your saturation has reached 0. For further
info, check [minecraft wiki](http://minecraft.gamepedia.com/Hunger).

`[alwaysEdible] = false ` - Defines if you can
or not eat this food with a full hunger bar.

`[isWolfFood] = false ` - Can a wolf/dog eat
this food.

`[potionEffects] ` - Foods can have potion
effect, like raw chicken or zombie flesh. This is an OPTIONAL propertie,
that has its own properties. Each food can have multiple potionEffects,
each with its own properties.

|**Potion Effect Properties:**

`[effect] = "moveSpeed"` - There is a list of
buffs/debuffs possible ([effects
list](effects_list_1.0_beta_4 "wikilink"))

`[potionDuration] = 20` - How many SECONDS the
effect will last

`[potionAmplifier] = 1` - Slow II ... II is the
amplifier. It makes the effect stronger

`[potionEffectProbability] = 1.0` - (min: 0.0,
max: 1.0) The chance of the potion effect happening when eating the food

**Format Example:**

	{
	   "changeFoods":[
	       {
	           "name": "minecraft:apple",
	           "maxStackSize": 16,
	           "healAmount":  1,
	           "saturationModifier":  1,
	           "alwaysEdible": true,
	           "isWolfFood": false
	       }
	   ]
	}

#<a name="modify_drops" href="#modify_drops" > Modify Drops </a>
___

Starting with CI 1.0.9b, you now can modify drops from pre-existing
block and NPC (mobs). |***&lt;u&gt; Important Notation&lt;/u&gt; :*** If
you are not familiar with the Block IDs & Item IDs names I suggest using
Minetweaker's built in commands to identify the block or look at the
[Mineacraft wiki Block IDs
page](http://minecraft.gamepedia.com/Data_values/Block_IDs) &
[Mineacraft wiki Item IDs
page](http://minecraft.gamepedia.com/Data_values/Item_IDs). For NPC
(mob) IDs, I suggest using [Mineacraft wiki Entity IDs
page](http://minecraft.gamepedia.com/Data_values/Entity_IDs).

###<a name="block_drops" href="#block_drops" > Block Drops </a>
___

**Properties:**

`{id}` - Which block do you wish to apply a drop
to. It is required to use the names of the Block IDs, not the numerical
value.

`[overrides] = false` - Do you want the
configuration for this drop to override the existing drops.

`{drops}` - Inside this property, additional
configurations are used to modify the behavior of the drops. A block can
have multiple drops.

|***Drop Properties***

`{id}` - What block or item is being dropped
after the original block being broken. It is required to use the names
of IDs not the numerical value.

`[min] = 1` - What is the minimum amount that
is dropped. Default is &lt;code&gt;1&lt;/code&gt;.

`[max] = 1`- What is the maximum amount that is
dropped.

`[chance] = 50` - What is the percentage chance
of the item being dropped.

**Format Example:**

    {
        "blocksDrop":[
            {
                "id": "minecraft:planks:3",
                "overrides": true,
                "drops":[
                    {
                        "id": "minecraft:sapling:4",
                        "min" : 2,
                        "max" : 4,
                        "chance" : 100.0
                    },
                    {
                       "id": "minecraft:sapling:5",
                       "min" : 1,
                       "max" : 3,
                       "chance" : 100.0
                    }
                ]
            }
        ]
    }

###<a name="entity_drop" href="#entity_drop" > Entity Drop </a>
___

**Properties:**

`{id}` - Which NPC (mob) do you wish to apply a
drop to. It is required to use the names of the Entity IDs.

`[overrides] = false` - Do you want the
configuration for this drop to override the existing drops.

`{drops}` - Inside this property, additional
configurations are used to modify the behavior of the drops. A block can
have multiple drops.

|***Drop Properties***

`{id}` - What block or item is being dropped
after the original block being broken. It is required to use the names
of IDs not the numerical value.

`[min] = 1` - What is the minimum amount that
is dropped.

`[max] = 1` - What is the maximum amount that is
dropped.

`[chance] = 50` - What is the percentage chance
of the item being dropped.

**Format Example:**

    {
        "entitiesDrop":[
            {
                "id":"Cow",
                "overrides": true,
                "drops":[
                    {
                        "id": "minecraft:sapling:1",
                        "min" : 1,
                        "max" : 3,
                        "chance" : 100.0
                    },
                    {
                        "id": "minecraft:sapling:2",
                        "min" : 1,
                        "max" : 5,
                        "chance" : 10.0
                    }
                ]
            }
        ]
    }

#<a name="ore_generation" href="#ore_generation" > Ore Generation </a>
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
ore generate to a specific biome. ([Biome \#
List](Biome_#_List "wikilink")) Use biome Id according to the dimension.

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

    {
        "oreGen":[
            {
                "blockToSpawn": "customitems:red_sand",
                "blockToReplace": "minecraft:sand",
                "dimensionId": 0,
                "minVeinSize": 10,
                "maxVeinSize": 15,
                "chancesToSpawn": 10,
                "minY": 40,
                "maxY": 90
            }
        ]
    }

&nbsp;
