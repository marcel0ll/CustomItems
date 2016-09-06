---
layout: wiki
title: Getting Starting Info
---

Before you start off making your own config files, I recommend using the following template to get you started and familiar with how the configurations work. ***[ The config template is on this page.](https://github.com/0tho/CustomItems/blob/master/configs/tests/all_blank.json)*** You could also use the default config files when you set restore default config to true in CI's .cfg file. By default it is set to false. CI has a .cfg file for general configurations.

All files for CI should be saved as *`.json`* file in*`"minecraftInstance/config/customItems"`* Any text editor can be used to make .json file, so long as you put it after the name of the file. The mod allows multiple configuration files so can group custom items instead of having a long list. The file name is not used in the name, merely for you to know what custom items are where.

As the site updates more, the tutorial section should help you with some questions you may have with the mod.  If there is not, feel free to add a tutorial page on Github or create a ticket on the the [BitBucket here](https://bitbucket.org/Otho/metamod-customitems/issues?status=new&status=open).


# Register Order

All custom blocks and items have a special configeration called `"registerOrder"`. `"registerOrder"` can be used to sort blocks and items in an id order of your choising. Blocks and items will be place in numerical order with `"registerOrder"` instead of a random order. `"registerOrder"` can be placed anywhere in the item or block configurations.

>***Note:*** Any item or block without a `"registerOrder"` will be placed at the end in a random order.


**<u>Example Configuration:</u>**

``` json
{
    "blocks":
    [
             {
            "name": "Block 1",
            "creativeTab": "Random Tab",
            "textureName": "BlockXTextureName",
            "registerOrder": 1,
            "material": "Material",
            "toolClass":"ToolClass",
            "hardness": 0,
            "resistance": 0,
            "lightLevel": 0,
            "harvestLevel": 0
        },
        {
            "name": "Block 2",
            "creativeTab": "Random Tab",
            "textureName": "BlockXTextureName",
            "material": "Material",
            "toolClass":"ToolClass",
            "hardness": 0,
            "resistance": 0,
            "lightLevel": 0,
            "registerOrder": 2,
            "harvestLevel": 0
        }
    ]
        
}
```