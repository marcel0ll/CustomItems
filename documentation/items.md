---
layout: wiki
title: Items
---

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
