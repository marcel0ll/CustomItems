package me.otho.customItems.configuration.jsonReaders.common;

import me.otho.customItems.CustomItems;

public class Cfg_basicData {
  /**
   * id is the identifier of the item/block to be registered
   */
  public String id;
  /**
   * name is the default localized name for the item/block
   * If no id is passed name will also be used for identification
   */
  public String name;
  /**
   * textureName is the name of the image file of the item/block to be
   * registered
   */
  public String textureName;
  /**
   * creativeTab is the identifier of the creativeTab that the item/block will
   * be put on
   */
  public String creativeTab = CustomItems.MOD_NAME;
  /**
   * registerOrder is a variable to order the items/blocks before being
   * registered. This should order items in creativetabs and NEI
   */
  public Integer registerOrder = 0;
}
