---
layout: wiki
title: Items
---

# Foods
___

**<u style="font-weight: bold;">Required Configuration:</u>**

`"name":` - The name of the food.

`"textureName":` - The texture name of the food.

**<u style="font-weight: bold;">Optional Configuration:</u>**

`"alwaysEdible":`- Defines if you can or can not eat the food item with a full hunger bar. Default value is `"false"`.

`"creativeTab":`- What creative tab the food will show up in. Default name is `"Custom Items"`.

`"dropItemName":` - Sets the id for the returned item or container after consuming food. A bowel is returned to you after having a soup. Example of id structure: `"minecraft:wheat"`, `"minecraft:stone"`.

`"glows":` - Set to `"true"` gives the item an enchanted sparkle, similiar to that of a Golden Apple. Default value is `"false"`.

`"healAmount":` - How much hunger points does the food item give. This is also known as food points. For hunger point reference for standard food, refer to the [Minecraft wiki here](http://minecraft.gamepedia.com/Hunger#Food_level_and_saturation_level_restoration). Default value is `1`.

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

`"useAction":` - Values: (`"eat"`,`"drink"`) - An eatting or drinking sound will play on consumption of a food item. `"eat"` - For solid foods like bread, porkchops, etc... `"drink"` - For liquids like potions. Default value is `"eat"`.


**Format Example:**

``` json
{
    "foods": [
        {
            "name": "food 1",
            "textureName": "food1",
            "healAmount": 1,
            "saturationModifier": 1,
            "potionEffects": [
                {
                    "effect": "effect",
                    "potionDuration": 1,
                    "potionAmplifier": 1,
                    "potionEffectProbability": 1
                }
            ]
        },
        {
            "name": "food 2",
            "textureName": "food2",
            "healAmount": 1,
            "creativeTab": "Random Tab",
            "saturationModifier": 1
        },
        {
            "name": "food X",
            "textureName": "foodX",
            "healAmount": 1,
            "saturationModifier": 1,
            "potionEffects": [
                {
                    "effect": "effect",
                    "potionDuration": 1,
                    "potionAmplifier": 1,
                    "potionEffectProbability": 1
                },
                {
                    "effect": "effect2",
                    "potionDuration": 1,
                    "potionAmplifier": 1,
                    "potionEffectProbability": 1
                }
            ]
        }
    ]
}
```


# Items
___

**<u style="font-weight: bold;">Required Configuration:</u>**

`"name":` - The name of the item.

`"textureName":` - The texture name of the item.

**<u style="font-weight: bold;">Optional Configuration:</u>**

`"creativeTab":`- What creative tab the food will show up in. Default name is `"Custom Items"`.

`"maxStackSize":` - Value Range:(Min:1, Max:64) - The max stack size for a block. Default value is `64`.

`"glows":` - Set to `"true"` gives the item an enchanted sparkle, similiar to that of a Golden Apple. Default value is `"false"`.


**Format Example:**

``` json
{
  "items": [
    {
      "name": "Item 1",
      "textureName": "item1",
      "creativeTab": "Custom Items",
      "maxstackSize": 35
    },
    {
      "name": "Item 2",
      "textureName": "item2",
      "creativeTab": "Custom Items",
      "maxstackSize": 23
    },
    {
      "name": "Item X",
      "textureName": "itemX",
      "maxstackSize": 42
    }
  ]
}
```

# Tools
___

### Axes

___

**<u style="font-weight: bold;">Required Configuration:</u>**

`"name":` - The name of the item.

`"textureName":` - The texture name of the item.

**<u style="font-weight: bold;">Optional Configuration:</u>**

`"creativeTab":`- What creative tab the food will show up in. Default name is `"Custom Items"`.

`"damageVsEntity":`- How much damage it inflicts on entities (zombies, chickens, other players) when used. Defaule value is `0`.

`"enchantability":` - How easily will the tool be enchanted. For information on the standard tools enchantability, refer to the [Minecraft wiki here](http://minecraft.gamepedia.com/Enchantment_mechanics#Step_One_-_Applying_modifiers_to_the_enchantment_level) Default value is `15`.

`"efficiencyOnProperMaterial":`- How efficient a tool is on the proper material. It is also know as the Breaking Multiplier on [Minecraft wiki here](http://minecraft.gamepedia.com/Breaking?cookieSetup=true#Speed). The [Material Multiplier](material_multiplier "wikilink") page will show you a relative number to Minecraft tools. Default value is `2`.

`"maxUses":` - How many times this item can be used. This is also known as durability. Default value is `59`.


**Format Example:**

``` json
{
    "axes": [
        {
            "name": "axe 1",
            "textureName": "axe1",
            "maxUses": 1,
            "efficiencyOnProperMaterial": 1,
            "damageVsEntity": 0,
            "enchantability": 1
        },
        {
            "name": "axe X",
            "textureName": "axeX",
            "maxUses": 1,
            "efficiencyOnProperMaterial": 1,
            "damageVsEntity": 0,
            "enchantability": 1
        }
    ]
}
```

### Hoes
___

**<u style="font-weight: bold;">Required Configuration:</u>**

`"name":` - The name of the item.

`"textureName":` - The texture name of the item.

**<u style="font-weight: bold;">Optional Configuration:</u>**

`"creativeTab":`- What creative tab the food will show up in. Default name is `"Custom Items"`.

`"damageVsEntity":`- How much damage it inflicts on entities (zombies, chickens, other players) when used. Defaule value is `0`.

`"enchantability":` - How easily will the tool be enchanted. For information on the standard tools enchantability, refer to the [Minecraft wiki here](http://minecraft.gamepedia.com/Enchantment_mechanics#Step_One_-_Applying_modifiers_to_the_enchantment_level) Default value is `15`.

`"efficiencyOnProperMaterial":`- How efficient a tool is on the proper material. It is also know as the Breaking Multiplier on [Minecraft wiki here](http://minecraft.gamepedia.com/Breaking?cookieSetup=true#Speed). The [Material Multiplier](material_multiplier "wikilink") page will show you a relative number to Minecraft tools. Default value is `2`.

`"maxUses":` - How many times this item can be used. This is also known as durability. Default value is `59`.


**Format Example:**

``` json
{
    "hoes": [
        {
            "name": "hoe 1",
            "textureName": "hoe1",
            "maxUses": 1,
            "efficiencyOnProperMaterial": 1,
            "damageVsEntity": 0,
            "enchantability": 1
        },
        {
            "name": "hoe X",
            "textureName": "hoeX",
            "maxUses": 1,
            "efficiencyOnProperMaterial": 1,
            "damageVsEntity": 0,
            "enchantability": 1
        }
    ]
}
```

### Pickaxes
___

**<u style="font-weight: bold;">Required Configuration:</u>**

`"name":` - The name of the item.

`"textureName":` - The texture name of the item.

**<u style="font-weight: bold;">Optional Configuration:</u>**

`"creativeTab":`- What creative tab the food will show up in. Default name is `"Custom Items"`.

`"damageVsEntity":`- How much damage it inflicts on entities (zombies, chickens, other players) when used. Defaule value is `0`.

`"enchantability":` - How easily will the tool be enchanted. For information on the standard tools enchantability, refer to the [Minecraft wiki here](http://minecraft.gamepedia.com/Enchantment_mechanics#Step_One_-_Applying_modifiers_to_the_enchantment_level) Default value is `15`.

`"efficiencyOnProperMaterial":`- How efficient a tool is on the proper material. It is also know as the Breaking Multiplier on [Minecraft wiki here](http://minecraft.gamepedia.com/Breaking?cookieSetup=true#Speed). The [Material Multiplier](material_multiplier "wikilink") page will show you a relative number to Minecraft tools. Default value is `2`.

`"harvestLevel":` - The level that a pickaxe can mine. The following link shows the equivalent numerical value for vanilla tools. ([Harvest level list](harvest_level_list "wikilink")). Default value is `0`.

`"maxUses":` - How many times this item can be used. This is also known as durability. Default value is `59`.


**Format Example:**

``` json
{
    "pickaxes": [
        {
            "name": "pickaxe 1",
            "textureName": "pickaxe1",
            "harvestLevel": 1,
            "maxUses": 1,
            "efficiencyOnProperMaterial": 1,
            "damageVsEntity": 0,
            "enchantability": 1
        },
        {
            "name": "pickaxe X",
            "textureName": "pickaxeX",
            "harvestLevel": 1,
            "maxUses": 1,
            "efficiencyOnProperMaterial": 1,
            "damageVsEntity": 0,
            "enchantability": 1
        }
    ]
}
```

### Shovels
___


**<u style="font-weight: bold;">Required Configuration:</u>**

`"name":` - The name of the item.

`"textureName":` - The texture name of the item.

**<u style="font-weight: bold;">Optional Configuration:</u>**

`"creativeTab":`- What creative tab the food will show up in. Default name is `"Custom Items"`.

`"damageVsEntity":`- How much damage it inflicts on entities (zombies, chickens, other players) when used. Defaule value is `0`.

`"enchantability":` - How easily will the tool be enchanted. For information on the standard tools enchantability, refer to the [Minecraft wiki here](http://minecraft.gamepedia.com/Enchantment_mechanics#Step_One_-_Applying_modifiers_to_the_enchantment_level) Default value is `15`.

`"efficiencyOnProperMaterial":`- How efficient a tool is on the proper material. It is also know as the Breaking Multiplier on [Minecraft wiki here](http://minecraft.gamepedia.com/Breaking?cookieSetup=true#Speed). The [Material Multiplier](material_multiplier "wikilink") page will show you a relative number to Minecraft tools. Default value is `2`.

`"maxUses":` - How many times this item can be used. This is also known as durability. Default value is `59`.


**Format Example:**

``` json
{
    "shovels": [
        {
            "name": "shovel 1",
            "textureName": "shovel1",
            "maxUses": 1,
            "efficiencyOnProperMaterial": 1,
            "damageVsEntity": 0,
            "enchantability": 1
        },
        {
            "name": "shovel X",
            "textureName": "shovelX",
            "maxUses": 1,
            "efficiencyOnProperMaterial": 1,
            "damageVsEntity": 0,
            "enchantability": 1
        }
    ]
}
```

### Swords
___


**<u style="font-weight: bold;">Required Configuration:</u>**

`"name":` - The name of the item.

`"textureName":` - The texture name of the item.

**<u style="font-weight: bold;">Optional Configuration:</u>**

`"creativeTab":`- What creative tab the food will show up in. Default name is `"Custom Items"`.

`"damageVsEntity":`- How much damage it inflicts on entities (zombies, chickens, other players) when used. Defaule value is `0`.

`"enchantability":` - How easily will the tool be enchanted. For information on the standard tools enchantability, refer to the [Minecraft wiki here](http://minecraft.gamepedia.com/Enchantment_mechanics#Step_One_-_Applying_modifiers_to_the_enchantment_level) Default value is `15`.

`"efficiencyOnProperMaterial":`- How efficient a tool is on the proper material. It is also know as the Breaking Multiplier on [Minecraft wiki here](http://minecraft.gamepedia.com/Breaking?cookieSetup=true#Speed). The [Material Multiplier](material_multiplier "wikilink") page will show you a relative number to Minecraft tools. Default value is `2`.

`"maxUses":` - How many times this item can be used. This is also known as durability. Default value is `59`.


**Format Example:**

``` json
{
    "pickaxes": [
        {
            "name": "sword 1",
            "textureName": "sword1",
            "maxUses": 1,
            "efficiencyOnProperMaterial": 1,
            "damageVsEntity": 0,
            "enchantability": 1
        },
        {
            "name": "sword X",
            "textureName": "swordX",
            "maxUses": 1,
            "efficiencyOnProperMaterial": 1,
            "damageVsEntity": 0,
            "enchantability": 1
        }
    ]
}
```

# Armor (Armour)
___

### Boots

___


**<u style="font-weight: bold;">Required Configuration:</u>**

`"name":` - The name of the item.

`"textureName":` - The texture name of the item.

**<u style="font-weight: bold;">Optional Configuration:</u>**

`"creativeTab":`- What creative tab the food will show up in. Default name is `"Custom Items"`.

`"durability":` - How much it can take before breaking. Default value is `5`. 

`"enchantability":` - How easily will the tool be enchanted. For information on the standard tools enchantability, refer to the [Minecraft wiki here](http://minecraft.gamepedia.com/Enchantment_mechanics#Step_One_-_Applying_modifiers_to_the_enchantment_level) Default value is `15`.

`"reduction":` - How much damage will be reduced when damaged. This is also know as Defence Points. For information on the standard armor damage reduction, refer to the [Minecraft wiki here](http://minecraft.gamepedia.com/Armor#Defense_points) Default value is `2`. 

>**Observations:**
>
>-   The item texture will be textureName\_boots
>
>-   The armor texture must have two layers textureName\_layer\_1 and
>    textureName\_layer\_2


**Format Example:**

``` json
{
    "boots": [
        {
            "name": "boots 1",
            "textureName": "boots1",
            "durability": 1,
            "reduction": 1,
            "enchantability": 30
        },
        {
            "name": "boots X",
            "textureName": "bootsX",
            "durability": 1,
            "reduction": 1,
            "enchantability": 30
        }
    ]
}
```

### Chestplates

___

**<u style="font-weight: bold;">Required Configuration:</u>**

`"name":` - The name of the item.

`"textureName":` - The texture name of the item.

**<u style="font-weight: bold;">Optional Configuration:</u>**

`"creativeTab":`- What creative tab the food will show up in. Default name is `"Custom Items"`.

`"durability":` - How much it can take before breaking. Default value is `5`. 

`"enchantability":` - How easily will the tool be enchanted. For information on the standard tools enchantability, refer to the [Minecraft wiki here](http://minecraft.gamepedia.com/Enchantment_mechanics#Step_One_-_Applying_modifiers_to_the_enchantment_level) Default value is `15`.

`"reduction":` - How much damage will be reduced when damaged. This is also know as Defence Points. For information on the standard armor damage reduction, refer to the [Minecraft wiki here](http://minecraft.gamepedia.com/Armor#Defense_points) Default value is `2`. 

>**Observations:**
>
>-   The item texture will be textureName\_chestplate
>
>-   The armor texture must have two layers textureName\_layer\_1 and
>    textureName\_layer\_2


**Format Example:**

``` json
{
    "boots": [
        {
            "name": "boots 1",
            "textureName": "boots1",
            "durability": 1,
            "reduction": 1,
            "enchantability": 30
        },
        {
            "name": "boots X",
            "textureName": "bootsX",
            "durability": 1,
            "reduction": 1,
            "enchantability": 30
        }
    ]
}
```

### Helmets

___

**<u style="font-weight: bold;">Required Configuration:</u>**

`"name":` - The name of the item.

`"textureName":` - The texture name of the item.

**<u style="font-weight: bold;">Optional Configuration:</u>**

`"creativeTab":`- What creative tab the food will show up in. Default name is `"Custom Items"`.

`"durability":` - How much it can take before breaking. Default value is `5`. 

`"enchantability":` - How easily will the tool be enchanted. For information on the standard tools enchantability, refer to the [Minecraft wiki here](http://minecraft.gamepedia.com/Enchantment_mechanics#Step_One_-_Applying_modifiers_to_the_enchantment_level) Default value is `15`.

`"reduction":` - How much damage will be reduced when damaged. This is also know as Defence Points. For information on the standard armor damage reduction, refer to the [Minecraft wiki here](http://minecraft.gamepedia.com/Armor#Defense_points) Default value is `2`. 

>**Observations:**
>
>-   The item texture will be textureName\_helmet
>
>-   The armor texture must have two layers textureName\_layer\_1 and
>    textureName\_layer\_2


**Format Example:**

``` json
{
    "helmets": [
        {
            "name": "Helmet 1",
            "textureName": "Helmet1",
            "durability": 1,
            "reduction": 1,
            "enchantability": 30
        },
        {
            "name": "Helmet X",
            "textureName": "HelmetX",
            "durability": 1,
            "reduction": 1,
            "enchantability": 30
        }
    ]
}
```

### Leggings

___

**<u style="font-weight: bold;">Required Configuration:</u>**

`"name":` - The name of the item.

`"textureName":` - The texture name of the item.

**<u style="font-weight: bold;">Optional Configuration:</u>**

`"creativeTab":`- What creative tab the food will show up in. Default name is `"Custom Items"`.

`"durability":` - How much it can take before breaking. Default value is `5`. 

`"enchantability":` - How easily will the tool be enchanted. For information on the standard tools enchantability, refer to the [Minecraft wiki here](http://minecraft.gamepedia.com/Enchantment_mechanics#Step_One_-_Applying_modifiers_to_the_enchantment_level) Default value is `15`.

`"reduction":` - How much damage will be reduced when damaged. This is also know as Defence Points. For information on the standard armor damage reduction, refer to the [Minecraft wiki here](http://minecraft.gamepedia.com/Armor#Defense_points) Default value is `2`. 

>**Observations:**
>
>-   The item texture will be textureName\_leggings
>
>-   The armor texture must have two layers textureName\_layer\_1 and
>    textureName\_layer\_2


**Format Example:**

```json
{
    "leggings": [
        {
            "name": "leggings 1",
            "textureName": "leggings1",
            "durability": 1,
            "reduction": 1,
            "enchantability": 30
        },
        {
            "name": "leggings X",
            "textureName": "leggingsX",
            "durability": 1,
            "reduction": 1,
            "enchantability": 30
        }
    ]
}
```