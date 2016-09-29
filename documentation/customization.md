---
layout: wiki
title: Customization
---

# Changing Existing Properties
___

Tired of how the default Minecraft has done with its blocks or items. You now can change the properties of default blocks and items.

### Change Existing Blocks
___

**<u style="font-weight: bold;">Required Configuration:</u>**

`"name":` - The id name of the block that you wish to edit that is already registed in the game. Example: `"minecraft:stone"`

`"maxStackSize":` - Value Range: (Min:1, Max:64) - The max stack size for a block. Default value is `64`.

**<u style="font-weight: bold;">Optional Configuration:</u>**

`"hardness":` - How hard is to mine this block. Default value is `2`.

`"harvestLevel":` - The level of the pickaxe needed to mine the block. This doesn't apply to shovel blocks or axe blocks. The following link shows the equivalent numerical value for vanilla tools. ([harvestLevel list](harvest_level_list "wikilink")) Default value is `0`.

`"isOpaque":` - This sets wheather the block *does not* allow light pass through it. Default value is `"true"`.

`"lightLevel":` - Value Range: (min: 0, max: 15) - This sets the light level from a block. The values reflect light levels. Default value is `0`.

`"resistance":` - How much the block is resistant to explosion. Default value is `10`.

`"slipperiness":` - Default value is `0.6`. Examples: Common Blocks: 0.6, ice: 0.98.

`"stepSound":` - The sound that makes when you walk on this block. ([ step sound list](step_sound_list "wikilink")) Default value is `"stone"`.

`"toolClass":` - The tool to mine this block.([toolClasslist](tool_class_list "wikilink")).


**Format Example:**

``` json
{
    "changeBlocks": [
        {
            "name": "minecraft:cactus",
            "maxStackSize": 6,
            "stepSound": "glass",
            "lightLevel": 0.5,
            "harvestLevel": 3,
            "toolClass": "shovel"
        },
        {
            "name": "minecraft:gravel",
            "maxStackSize": 17,
            "slipperiness": 0.3
        },
        {
            "name": "minecraft:stone",
            "maxStackSize": 4,
            "hardness": -1,
            "resistance": 6000000
        }
    ]
}
```

### Change Existing Items
___

**<u style="font-weight: bold;">Required Configuration:</u>**

`"name":` - The id name of the block that you wish to edit that is already registed in the game. Example: `"minecraft:stone"`

`"maxStackSize":` - Value Range: (Min:1, Max:64) - The max stack size for a block. Default value is `64`.


**Format Example:**

``` json
{
    "changeItems": [
        {
            "name": "minecraft:apple",
            "maxStackSize": 3
        },
        {
            "name": "minecraft:cookie",
            "maxStackSize": 17
        },
        {
            "name": "customitems:coin",
            "maxStackSize": 4
        }
    ]
}
```

### Change Existing Foods

**<u style="font-weight: bold;">Required Configuration:</u>**

`"name":` - The id name of the block that you wish to edit that is already registed in the game. Example: `"minecraft:stone"`

**<u style="font-weight: bold;">Optional Configuration:</u>**

`"alwaysEdible":`- Defines if you can or can not eat the food item with a full hunger bar. Default value is `"false"`.

`"healAmount":` - How much hunger points does the food item give. This is also known as food points. For hunger point reference for standard food, refer to the [Minecraft wiki here](http://minecraft.gamepedia.com/Hunger#Food_level_and_saturation_level_restoration). Default value is `1`.

`"maxStackSize":` - Value Range: (Min:1, Max:64) - The max stack size for a block. Default value is `64`.

`"isWolfFood":` - Can a wolf/dog eat this food.  Default value is `"false"`.

`"potionEffects":` - This gives food items the ability to have potion effects. Each food can have multiple potion effects applied to it. Example: Golden Apple, Raw Chicken and Zombie Flesh.

<p style="padding-left:3%"><strong><em>Potion Effect Properties:</em></strong></p>

<div style="padding-left:4%">
<p><code>"effect":</code> - There is a list of buffs/debuffs possible and what they do.(<a href="effects_list" title="wikilink">Effects List</a>). The default value is <code>"moveSpeed"</code></p>

<p><code>"potionAmplifier":</code> - Slow II ... II is the amplifier. It makes the effect stronger Default value is <code>1</code>.</p>

<p><code>"potionDuration":</code> - How many SECONDS the effect will last. Default is <code>20</code> seconds.</p>

<p><code>"potionEffectProbability":</code> - Value Range: (min: 0.0, max: 1.0) - The chance of the potion effect happening when eating the food. The default values is <code>1.0</code>.</p>
</div>

`"saturationModifier":` - These configuration is a hidden value that increases when you consume foods. Your hungerbar will only start to increasing after you raise the saturation above 0. For further info, check [minecraft wiki](http://minecraft.gamepedia.com/Hunger). Default value is `1.0`.


**Format Example:**

``` json
{
    "changeFoods": [
        {
            "name": "minecraft:apple",
            "maxStackSize": 16,
            "healAmount": 1,
            "saturationModifier": 1,
            "alwaysEdible": true,
            "isWolfFood": false
        }
    ]
}
```

# Modify Drops
___

Starting with CI 1.0.9b, you now can modify drops from pre-existing block and NPC (mobs). If you are not familiar with the Block IDs & Item IDs names I suggest using Minetweaker's built in commands to identify the block or look at the [Mineacraft wiki Block IDs page](http://minecraft.gamepedia.com/Data_values/Block_IDs) & [Mineacraft wiki Item IDs page](http://minecraft.gamepedia.com/Data_values/Item_IDs). For NPC(mob) IDs, I suggest using [Mineacraft wiki Entity IDs page](http://minecraft.gamepedia.com/Data_values/Entity_IDs).


### Block Drops
___

**<u style="font-weight: bold;">Required Configuration:</u>**

`"id":` - Which block do you wish to apply a drop to. It is required to use the names of the Block IDs, not the numerical value.

`"drops"` - Inside this property, additional configurations are used to modify the behavior of the drops. A block can have multiple drops.

<p style="padding-left:3%"><strong><em>Drop Properties:</em></strong></p>

<div style="padding-left:4%">
<p><em><u style="font-weight: bold;">Required Configuration:</u></em></p>

<p><code>"id":</code> - What block or item is being dropped after the original block being broken. It is required to use the names of IDs not the numerical value.</p>

<p><em><u style="font-weight: bold;">Optional Configuration:</u></em></p>

<p><code>"chance":</code> - What is the percentage chance of the item being dropped. Default is <code>50</code>.

<p><code>"max":</code> - What is the maximum amount that is dropped. Default is <code>1</code>.

<p><code>"min":</code> - What is the minimum amount that is dropped. Default is <code>1</code>.
</div>

**<u style="font-weight: bold;">Optional Configuration:</u>**

`"overrides":` - Do you want the configuration for this drop to override the existing drops. Default value is `false`.


**Format Example:**

``` json
{
    "blocksDrop": [
        {
            "id": "minecraft:planks:3",
            "overrides": true,
            "drops": [
                {
                    "id": "minecraft:sapling:4",
                    "min": 2,
                    "max": 4,
                    "chance": 100
                },
                {
                    "id": "minecraft:sapling:5",
                    "min": 1,
                    "max": 3,
                    "chance": 100
                }
            ]
        }
    ]
}
```   

### Entity Drop
___

**<u style="font-weight: bold;">Required Configuration:</u>**

`"id":` - Which NPC (mob) do you wish to apply a drop to. It is required to use the names of the Entity IDs.

`"drops"` - Inside this property, additional configurations are used to modify the behavior of the drops. A block can have multiple drops.

<p style="padding-left:3%"><strong><em>Drop Properties:</em></strong></p>

<div style="padding-left:4%">
<p><em><u style="font-weight: bold;">Required Configuration:</u></em></p>

<p><code>"id":</code> - What block or item is being dropped after the original block being broken. It is required to use the names of IDs not the numerical value.</p>

<p><em><u style="font-weight: bold;">Optional Configuration:</u></em></p>

<p><code>"chance":</code> - What is the percentage chance of the item being dropped. Default is <code>50</code>.

<p><code>"max":</code> - What is the maximum amount that is dropped. Default is <code>1</code>.

<p><code>"min":</code> - What is the minimum amount that is dropped. Default is <code>1</code>.
</div>

**<u style="font-weight: bold;">Optional Configuration:</u>**

`"overrides":` - Do you want the configuration for this drop to override the existing drops. Default value is `false`.


**Format Example:**

``` json
{
    "entitiesDrop": [
        {
            "id": "Cow",
            "overrides": true,
            "drops": [
                {
                    "id": "minecraft:sapling:1",
                    "min": 1,
                    "max": 3,
                    "chance": 100
                },
                {
                    "id": "minecraft:sapling:2",
                    "min": 1,
                    "max": 5,
                    "chance": 10
                }
            ]
        }
    ]
}
```    