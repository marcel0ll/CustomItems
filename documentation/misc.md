---
layout: wiki
title: Misc
---

# Creative Tabs
___

**<u style="font-weight: bold;">Required Configuration:</u>**

`"tabLabe":` - The label that will show when passing the mouse over the tab.

**<u style="font-weight: bold;">Optional Configuration:</u>**

`"iconItem":` - The item that will display on the creative tab. Default is `"minecraft:item_frame"`.

**Format Example:**

``` json
{
    "creativeTabs": [
        {
            "tabLabel": "newTab1",
            "iconItem": "customItems:yourNewItem"
        },
        {
            "tabLabel": "newTab2",
            "iconItem": "minecraft:torch"
        },
        {
            "tabLabel": "newTabN"
        }
    ]
}
```