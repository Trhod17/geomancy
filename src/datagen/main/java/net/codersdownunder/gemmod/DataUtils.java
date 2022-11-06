package net.codersdownunder.gemmod;

import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.ForgeRegistries;

public class DataUtils {

    public static String getItemRegistryName(Item item) {
        return ForgeRegistries.ITEMS.getKey(item).getPath();
    }

    public static String getBlockRegistryName(Block block) {
        return ForgeRegistries.BLOCKS.getKey(block).getPath();
    }
}
