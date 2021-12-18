package net.codersdownunder.gemmod.init;

import net.codersdownunder.gemmod.GemMod;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SignItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BlockItemInit
{
    public static final DeferredRegister<Item> BLOCKITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, GemMod.MODID);
    
    public static final RegistryObject<BlockItem> CHASM_SIGN = BLOCKITEMS.register("chasm_sign", () -> new SignItem((new Item.Properties()).stacksTo(16).tab(GemMod.gemsmodblocktab), BlockInit.CHASM_SIGN.get(), BlockInit.CHASM_SIGN_WALL.get()));
    public static final RegistryObject<BlockItem> END_LANTERN = BLOCKITEMS.register("end_lantern", () -> new BlockItem(BlockInit.END_LANTERN.get(), new Item.Properties().tab(GemMod.gemsmodblocktab)));
    public static final RegistryObject<BlockItem> END_LANTERN_BLOCK = BLOCKITEMS.register("end_lantern_block", () -> new BlockItem(BlockInit.END_LANTERN_BLOCK.get(), new Item.Properties().tab(GemMod.gemsmodblocktab)));
    public static final RegistryObject<BlockItem> CHASM_BUTTON = BLOCKITEMS.register("chasm_button", () -> new BlockItem(BlockInit.CHASM_BUTTON.get(), new Item.Properties().tab(GemMod.gemsmodblocktab)));
    public static final RegistryObject<BlockItem> CHASM_DOOR = BLOCKITEMS.register("chasm_door", () -> new BlockItem(BlockInit.CHASM_DOOR.get(), new Item.Properties().tab(GemMod.gemsmodblocktab)));
    public static final RegistryObject<BlockItem> CHASM_FENCE = BLOCKITEMS.register("chasm_fence", () -> new BlockItem(BlockInit.CHASM_FENCE.get(), new Item.Properties().tab(GemMod.gemsmodblocktab)));
    public static final RegistryObject<BlockItem> CHASM_FENCE_GATE = BLOCKITEMS.register("chasm_fence_gate", () -> new BlockItem(BlockInit.CHASM_FENCE_GATE.get(), new Item.Properties().tab(GemMod.gemsmodblocktab)));
    public static final RegistryObject<BlockItem> CHASM_LOG = BLOCKITEMS.register("chasm_log", () -> new BlockItem(BlockInit.CHASM_LOG.get(), new Item.Properties().tab(GemMod.gemsmodblocktab)));
    public static final RegistryObject<BlockItem> CHASM_LOG_BARK = BLOCKITEMS.register("chasm_log_bark", () -> new BlockItem(BlockInit.CHASM_LOG_BARK.get(), new Item.Properties().tab(GemMod.gemsmodblocktab)));
    public static final RegistryObject<BlockItem> CHASM_LOG_STRIPPED = BLOCKITEMS.register("chasm_log_stripped", () -> new BlockItem(BlockInit.CHASM_LOG_STRIPPED.get(), new Item.Properties().tab(GemMod.gemsmodblocktab)));
    public static final RegistryObject<BlockItem> CHASM_LOG_STRIPPED_BARK = BLOCKITEMS.register("chasm_log_stripped_bark", () -> new BlockItem(BlockInit.CHASM_LOG_STRIPPED_BARK.get(), new Item.Properties().tab(GemMod.gemsmodblocktab)));
    public static final RegistryObject<BlockItem> CHASM_PLANKS = BLOCKITEMS.register("chasm_planks", () -> new BlockItem(BlockInit.CHASM_PLANKS.get(), new Item.Properties().tab(GemMod.gemsmodblocktab)));
    public static final RegistryObject<BlockItem> CHASM_PLATE = BLOCKITEMS.register("chasm_plate", () -> new BlockItem(BlockInit.CHASM_PLATE.get(), new Item.Properties().tab(GemMod.gemsmodblocktab)));
    public static final RegistryObject<BlockItem> CHASM_SLAB = BLOCKITEMS.register("chasm_slab", () -> new BlockItem(BlockInit.CHASM_SLAB.get(), new Item.Properties().tab(GemMod.gemsmodblocktab)));
    public static final RegistryObject<BlockItem> CHASM_STAIRS = BLOCKITEMS.register("chasm_stairs", () -> new BlockItem(BlockInit.CHASM_STAIRS.get(), new Item.Properties().tab(GemMod.gemsmodblocktab)));
    public static final RegistryObject<BlockItem> CHASM_TRAPDOOR = BLOCKITEMS.register("chasm_trapdoor", () -> new BlockItem(BlockInit.CHASM_TRAPDOOR.get(), new Item.Properties().tab(GemMod.gemsmodblocktab)));
    public static final RegistryObject<BlockItem> CHASM_LEAVES = BLOCKITEMS.register("chasm_leaves", () -> new BlockItem(BlockInit.CHASM_LEAVES.get(), new Item.Properties().tab(GemMod.gemsmodblocktab)));
    public static final RegistryObject<BlockItem> MULMUS_LANTERN = BLOCKITEMS.register("mulmus_lantern", () -> new BlockItem(BlockInit.MULMUS_LANTERN.get(), new Item.Properties().tab(GemMod.gemsmodblocktab)));
    public static final RegistryObject<BlockItem> MULMUS_LANTERN_POLISHED = BLOCKITEMS.register("mulmus_lantern_polished", () -> new BlockItem(BlockInit.MULMUS_LANTERN_POLISHED.get(), new Item.Properties().tab(GemMod.gemsmodblocktab)));
    public static final RegistryObject<BlockItem> INFUSION_TABLE = BLOCKITEMS.register("infusion_table", () -> new BlockItem(BlockInit.INFUSION_TABLE.get(), new Item.Properties().tab(GemMod.gemsmodblocktab)));
    public static final RegistryObject<BlockItem> DIPPER = BLOCKITEMS.register("dipper", () -> new BlockItem(BlockInit.DIPPER.get(), new Item.Properties().tab(GemMod.gemsmodblocktab)));
}
