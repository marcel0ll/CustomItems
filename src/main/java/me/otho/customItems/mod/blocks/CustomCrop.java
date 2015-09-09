package me.otho.customItems.mod.blocks;

import java.util.ArrayList;

import me.otho.customItems.mod.items.CustomSeed;
import me.otho.customItems.reference.Reference;
import me.otho.customItems.utility.LogHelper;
import net.minecraft.block.Block;
import net.minecraft.block.BlockCrops;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class CustomCrop extends BlockCrops {
    private String fruit;
    private Item seed;

    private boolean dropSeedWhenMature;
    private boolean acceptBoneMeal;

    private int minFruitDrop;
    private int maxFruitDrop;
    private int eachExtraFruitDropChance;

    private int minSeedDrop;
    private int maxSeedDrop;
    private int eachExtraSeedDropChance;

    private IIcon[] icons;
    private int renderType;
    private int dropFruitDamage;

    public CustomCrop(String fruit, int renderType) {
        super();
        this.fruit = fruit;
        this.renderType = renderType;
        this.setCreativeTab(null);
    }

    @Override
    public boolean func_149851_a(World p_149851_1_, int p_149851_2_, int p_149851_3_, int p_149851_4_,
            boolean p_149851_5_) {
        if (this.acceptBoneMeal) {
            return p_149851_1_.getBlockMetadata(p_149851_2_, p_149851_3_, p_149851_4_) != 7;
        } else {
            return false;
        }
    }

    private int getFruitDropQuantity(World world, int fortune) {
        int ret = 0;
        int i;
        for (i = 0; i < this.maxFruitDrop + fortune; i++) {
            boolean willDrop = world.rand.nextInt(100) < this.eachExtraFruitDropChance;
            if (willDrop)
                ret++;
        }
        if (ret < this.minFruitDrop)
            ret = this.minFruitDrop;

        return ret;
    }

    private int getSeedDropQuantity(World world, int fortune) {
        int ret = 0;
        int i;
        ret = this.minSeedDrop;

        for (i = this.minSeedDrop; i < this.maxSeedDrop + fortune; i++) {
            boolean willDrop = world.rand.nextInt(100) < this.eachExtraSeedDropChance;
            if (willDrop)
                ret++;
        }

        return ret;
    }

    @Override
    public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int metadata, int fortune) {
        ArrayList<ItemStack> drops = new ArrayList();

        int seedQuantity = getSeedDropQuantity(world, fortune);
        int fruitQuantity = getFruitDropQuantity(world, fortune);

        // Growing
        if (metadata < 7) {
            drops.add(new ItemStack(this.seed));
        }
        // Mature
        else {
            String[] parser = fruit.split(":");
            Item item = GameRegistry.findItem(parser[0], parser[1]);

            int damage;

            if (parser.length > 2) {
                damage = Integer.parseInt(parser[2]);
            } else {
                damage = 0;
            }

            if (fruitQuantity > 0)
                drops.add(new ItemStack(item, fruitQuantity, damage));
            if (this.dropSeedWhenMature)
                if (seedQuantity > 0)
                    drops.add(new ItemStack(this.seed, seedQuantity, dropFruitDamage));
        }

        return drops;
    }

    public void setAcceptBoneMeal(boolean acceptBoneMeal) {
        this.acceptBoneMeal = acceptBoneMeal;
    }

    public void setEachExtraFruitDropChance(int eachExtraFruitDropChance) {
        this.eachExtraFruitDropChance = eachExtraFruitDropChance;
    }

    public void setEachExtraSeedDropChance(int eachExtraSeedDropChance) {
        this.eachExtraSeedDropChance = eachExtraSeedDropChance;
    }

    public void setDropSeedWhenMature(boolean bool) {
        this.dropSeedWhenMature = bool;
    }

    public void setFruitQuantityDropRange(int min, int max) {
        if (min <= 0)
            min = 0;
        if (max < min)
            max = min;

        this.maxFruitDrop = max;
        this.minFruitDrop = min;
    }

    public void setSeedQuantityDropRange(int min, int max) {
        if (min <= 0)
            min = 0;
        if (max < min)
            max = min;

        this.maxSeedDrop = max;
        this.minSeedDrop = min;
    }

    public void setSeed(CustomSeed seed) {
        this.seed = seed;
    }

    @Override
    protected Item func_149866_i() {
        return this.seed;
    }

    @Override
    protected Item func_149865_P() {
        String[] parser = fruit.split(":");
        Item item = GameRegistry.findItem(parser[0], parser[1]);

        return item;
    }

    // neighboring blocks get updated
    @Override
    public void onNeighborBlockChange(World world, int x, int y, int z, Block block) {
        // check if crops can stay
        if (!this.canBlockStay(world, x, y, z)) {
            // the crop will be destroyed
            this.dropBlockAsItem(world, x, y, z, world.getBlockMetadata(x, y, z), 0);
            world.setBlockToAir(x, y, z);
        }
    }

    // see if the block can stay
    @Override
    public boolean canBlockStay(World world, int x, int y, int z) {
        Block soil = world.getBlock(x, y - 1, z);
        return soil instanceof net.minecraft.block.BlockFarmland;
    }

    @Override
    public int getRenderType() {
        return this.renderType;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister) {
        LogHelper.debug("registering icon for: " + this.getUnlocalizedName());
        this.icons = new IIcon[4];
        for (int i = 1; i < this.icons.length + 1; i++) {
            this.icons[i - 1] = iconRegister.registerIcon(Reference.MOD_ID.toLowerCase() + ":" + this.textureName + i);
        }
    }

    @Override
    public IIcon getIcon(int side, int meta) {
        switch (meta) {
        case 0:
            return this.icons[0];
        case 1:
            return this.icons[0];
        case 2:
            return this.icons[1];
        case 3:
            return this.icons[1];
        case 4:
            return this.icons[1];
        case 5:
            return this.icons[2];
        case 6:
            return this.icons[2];
        case 7:
            return this.icons[3];
        }
        return this.icons[(int) Math.floor(meta / 5)];
    }

    public void setFruitItemDamage(int dropFruitDamage) {
        this.dropFruitDamage = dropFruitDamage;
    }

}
