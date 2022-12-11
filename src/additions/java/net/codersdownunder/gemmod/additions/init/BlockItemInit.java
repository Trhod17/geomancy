package net.codersdownunder.gemmod.additions.init;

import net.codersdownunder.gemmod.additions.Additions;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BlockItemInit
{
    public static final DeferredRegister<Item> BLOCKITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Additions.MODID);

    public static final RegistryObject<BlockItem> PURPUR_WALL = BLOCKITEMS.register("purpur_wall", () -> new BlockItem(BlockInit.PURPUR_WALL.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> PURPUR_PILLAR_WALL = BLOCKITEMS.register("purpur_pillar_wall", () -> new BlockItem(BlockInit.PURPUR_PILLAR_WALL.get(), new Item.Properties()));
   
    public static final RegistryObject<BlockItem> DARK_PRISMARINE_WALL = BLOCKITEMS.register("dark_prismarine_wall", () -> new BlockItem(BlockInit.DARK_PRISMARINE_WALL.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> PRISMARINE_BRICKS_WALL = BLOCKITEMS.register("prismarine_bricks_wall", () -> new BlockItem(BlockInit.PRISMARINE_BRICKS_WALL.get(), new Item.Properties()));
   
}
