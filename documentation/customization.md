---
layout: wiki
title: Customization
---

# Changing Existing Properties
___

Tired of how the default Minecraft has done with its blocks or items.
You now can change the properties of default blocks and items.

### Change Existing Blocks
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
vanilla tools. ([harvestLevel list](harvest_level_list "wikilink"))

`[slipperiness]` - CommonBlocks: 0.6, ice: 0.98

`[isOpaque]` - Can light pass through this
block

`[stepSound]` - The sound that makes when you
walk on this block. ([ step sound
list](step_sound_list_1.0_beta_4 "wikilink"))

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

**Properties:**

`{name}` - The name that the item is registered.
Like: "minecraft:apple"

`{maxStackSize}` - The max stack size for an
item. Min:1, Max:64

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

### Block Drops
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
