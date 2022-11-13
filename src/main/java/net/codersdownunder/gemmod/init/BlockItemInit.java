package net.codersdownunder.gemmod.init;

import net.codersdownunder.gemmod.Geomancy;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SignItem;
import net.minecraft.world.item.StandingAndWallBlockItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(modid = Geomancy.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class BlockItemInit {

    public static final DeferredRegister<Item> BLOCK_ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Geomancy.MODID);

    public static final RegistryObject<BlockItem> CHASM_SIGN = BLOCK_ITEMS.register("chasm_sign", () -> new SignItem((new Item.Properties()).stacksTo(16).tab(Geomancy.gemsmodblocktab), BlockInit.CHASM_SIGN.get(), BlockInit.CHASM_SIGN_WALL.get()));
    public static final RegistryObject<BlockItem> END_LANTERN = BLOCK_ITEMS.register("end_lantern", () -> new BlockItem(BlockInit.END_LANTERN.get(), new Item.Properties().tab(Geomancy.gemsmodblocktab)));
    public static final RegistryObject<BlockItem> END_LANTERN_BLOCK = BLOCK_ITEMS.register("end_lantern_block", () -> new BlockItem(BlockInit.END_LANTERN_BLOCK.get(), new Item.Properties().tab(Geomancy.gemsmodblocktab)));
    public static final RegistryObject<BlockItem> CHASM_BUTTON = BLOCK_ITEMS.register("chasm_button", () -> new BlockItem(BlockInit.CHASM_BUTTON.get(), new Item.Properties().tab(Geomancy.gemsmodblocktab)));
    public static final RegistryObject<BlockItem> CHASM_DOOR = BLOCK_ITEMS.register("chasm_door", () -> new BlockItem(BlockInit.CHASM_DOOR.get(), new Item.Properties().tab(Geomancy.gemsmodblocktab)));
    public static final RegistryObject<BlockItem> CHASM_FENCE = BLOCK_ITEMS.register("chasm_fence", () -> new BlockItem(BlockInit.CHASM_FENCE.get(), new Item.Properties().tab(Geomancy.gemsmodblocktab)));
    public static final RegistryObject<BlockItem> CHASM_FENCE_GATE = BLOCK_ITEMS.register("chasm_fence_gate", () -> new BlockItem(BlockInit.CHASM_FENCE_GATE.get(), new Item.Properties().tab(Geomancy.gemsmodblocktab)));
    public static final RegistryObject<BlockItem> CHASM_LOG = BLOCK_ITEMS.register("chasm_log", () -> new BlockItem(BlockInit.CHASM_LOG.get(), new Item.Properties().tab(Geomancy.gemsmodblocktab)));
    public static final RegistryObject<BlockItem> CHASM_LOG_BARK = BLOCK_ITEMS.register("chasm_log_bark", () -> new BlockItem(BlockInit.CHASM_LOG_BARK.get(), new Item.Properties().tab(Geomancy.gemsmodblocktab)));
    public static final RegistryObject<BlockItem> CHASM_LOG_STRIPPED = BLOCK_ITEMS.register("chasm_log_stripped", () -> new BlockItem(BlockInit.CHASM_LOG_STRIPPED.get(), new Item.Properties().tab(Geomancy.gemsmodblocktab)));
    public static final RegistryObject<BlockItem> CHASM_LOG_STRIPPED_BARK = BLOCK_ITEMS.register("chasm_log_stripped_bark", () -> new BlockItem(BlockInit.CHASM_LOG_STRIPPED_BARK.get(), new Item.Properties().tab(Geomancy.gemsmodblocktab)));
    public static final RegistryObject<BlockItem> CHASM_PLANKS = BLOCK_ITEMS.register("chasm_planks", () -> new BlockItem(BlockInit.CHASM_PLANKS.get(), new Item.Properties().tab(Geomancy.gemsmodblocktab)));
    public static final RegistryObject<BlockItem> CHASM_PLATE = BLOCK_ITEMS.register("chasm_plate", () -> new BlockItem(BlockInit.CHASM_PLATE.get(), new Item.Properties().tab(Geomancy.gemsmodblocktab)));
    public static final RegistryObject<BlockItem> CHASM_SLAB = BLOCK_ITEMS.register("chasm_slab", () -> new BlockItem(BlockInit.CHASM_SLAB.get(), new Item.Properties().tab(Geomancy.gemsmodblocktab)));
    public static final RegistryObject<BlockItem> CHASM_STAIRS = BLOCK_ITEMS.register("chasm_stairs", () -> new BlockItem(BlockInit.CHASM_STAIRS.get(), new Item.Properties().tab(Geomancy.gemsmodblocktab)));
    public static final RegistryObject<BlockItem> CHASM_TRAPDOOR = BLOCK_ITEMS.register("chasm_trapdoor", () -> new BlockItem(BlockInit.CHASM_TRAPDOOR.get(), new Item.Properties().tab(Geomancy.gemsmodblocktab)));
    public static final RegistryObject<BlockItem> CHASM_LEAVES = BLOCK_ITEMS.register("chasm_leaves", () -> new BlockItem(BlockInit.CHASM_LEAVES.get(), new Item.Properties().tab(Geomancy.gemsmodblocktab)));
    public static final RegistryObject<BlockItem> MULMUS_LANTERN = BLOCK_ITEMS.register("mulmus_lantern", () -> new BlockItem(BlockInit.MULMUS_LANTERN.get(), new Item.Properties().tab(Geomancy.gemsmodblocktab)));
    public static final RegistryObject<BlockItem> MULMUS_LANTERN_POLISHED = BLOCK_ITEMS.register("mulmus_lantern_polished", () -> new BlockItem(BlockInit.MULMUS_LANTERN_POLISHED.get(), new Item.Properties().tab(Geomancy.gemsmodblocktab)));
    public static final RegistryObject<BlockItem> INFUSION_TABLE = BLOCK_ITEMS.register("infusion_table", () -> new BlockItem(BlockInit.INFUSION_TABLE.get(), new Item.Properties().tab(Geomancy.gemsmodblocktab)));
    public static final RegistryObject<BlockItem> DIPPER = BLOCK_ITEMS.register("dipper", () -> new BlockItem(BlockInit.DIPPER.get(), new Item.Properties().tab(Geomancy.gemsmodblocktab)));
    public static final RegistryObject<BlockItem> DREAM_CATCHER = BLOCK_ITEMS.register("dream_catcher", () -> new BlockItem(BlockInit.DREAM_CATCHER.get(), new Item.Properties().tab(Geomancy.gemsmodblocktab)));
    public static final RegistryObject<BlockItem> GEODE_ORE = BLOCK_ITEMS.register("geode_ore", () -> new BlockItem(BlockInit.GEODE_ORE.get(), new Item.Properties().tab(Geomancy.gemsmodblocktab)));
    public static final RegistryObject<BlockItem> TELEPAD = BLOCK_ITEMS.register("telepad", () -> new BlockItem(BlockInit.TELEPAD.get(), new Item.Properties().tab(Geomancy.gemsmodblocktab)));
    public static final RegistryObject<BlockItem> TELEPAD_SLAB = BLOCK_ITEMS.register("telepad_slab", () -> new BlockItem(BlockInit.TELEPAD_SLAB.get(), new Item.Properties().tab(Geomancy.gemsmodblocktab)));
    public static final RegistryObject<BlockItem> TERRA_FIRMA = BLOCK_ITEMS.register("terra_firma", () -> new BlockItem(BlockInit.TERRA_FIRMA.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> INFUSION_STAND = BLOCK_ITEMS.register("infusion_stand", () -> new BlockItem(BlockInit.INFUSION_STAND.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> TREADSTONE_1 = BLOCK_ITEMS.register("treadstone_1", () -> new BlockItem(BlockInit.TREADSTONE_1.get(), new Item.Properties().tab(Geomancy.gemsmodblocktab)));
    public static final RegistryObject<BlockItem> TREADSTONE_2 = BLOCK_ITEMS.register("treadstone_2", () -> new BlockItem(BlockInit.TREADSTONE_2.get(), new Item.Properties().tab(Geomancy.gemsmodblocktab)));
    public static final RegistryObject<BlockItem> TREADSTONE_3 =  BLOCK_ITEMS.register("treadstone_3", () -> new BlockItem(BlockInit.TREADSTONE_3.get(), new Item.Properties().tab(Geomancy.gemsmodblocktab)));
    public static final RegistryObject<BlockItem> TREADSTONE_4 = BLOCK_ITEMS.register("treadstone_4", () -> new BlockItem(BlockInit.TREADSTONE_4.get(), new Item.Properties().tab(Geomancy.gemsmodblocktab)));
    public static final RegistryObject<BlockItem> TREADSTONE_5 = BLOCK_ITEMS.register("treadstone_5", () -> new BlockItem(BlockInit.TREADSTONE_5.get(), new Item.Properties().tab(Geomancy.gemsmodblocktab)));
    public static final RegistryObject<BlockItem> TREADSTONE_6 = BLOCK_ITEMS.register("treadstone_6", () -> new BlockItem(BlockInit.TREADSTONE_6.get(), new Item.Properties().tab(Geomancy.gemsmodblocktab)));
    public static final RegistryObject<BlockItem> TREADSTONE_7 = BLOCK_ITEMS.register("treadstone_7", () -> new BlockItem(BlockInit.TREADSTONE_7.get(), new Item.Properties().tab(Geomancy.gemsmodblocktab)));
    public static final RegistryObject<BlockItem> TREADSTONE_SLAB_1 = BLOCK_ITEMS.register("treadstone_slab_1", () -> new BlockItem(BlockInit.TREADSTONE_SLAB_1.get(), new Item.Properties().tab(Geomancy.gemsmodblocktab)));
    public static final RegistryObject<BlockItem> TREADSTONE_SLAB_2 = BLOCK_ITEMS.register("treadstone_slab_2", () -> new BlockItem(BlockInit.TREADSTONE_SLAB_2.get(), new Item.Properties().tab(Geomancy.gemsmodblocktab)));
    public static final RegistryObject<BlockItem> TREADSTONE_SLAB_3 =  BLOCK_ITEMS.register("treadstone_slab_3", () -> new BlockItem(BlockInit.TREADSTONE_SLAB_3.get(), new Item.Properties().tab(Geomancy.gemsmodblocktab)));
    public static final RegistryObject<BlockItem> TREADSTONE_SLAB_4 = BLOCK_ITEMS.register("treadstone_slab_4", () -> new BlockItem(BlockInit.TREADSTONE_SLAB_4.get(), new Item.Properties().tab(Geomancy.gemsmodblocktab)));
    public static final RegistryObject<BlockItem> TREADSTONE_SLAB_5 = BLOCK_ITEMS.register("treadstone_slab_5", () -> new BlockItem(BlockInit.TREADSTONE_SLAB_5.get(), new Item.Properties().tab(Geomancy.gemsmodblocktab)));
    public static final RegistryObject<BlockItem> TREADSTONE_SLAB_6 = BLOCK_ITEMS.register("treadstone_slab_6", () -> new BlockItem(BlockInit.TREADSTONE_SLAB_6.get(), new Item.Properties().tab(Geomancy.gemsmodblocktab)));
    public static final RegistryObject<BlockItem> TREADSTONE_SLAB_7 = BLOCK_ITEMS.register("treadstone_slab_7", () -> new BlockItem(BlockInit.TREADSTONE_SLAB_7.get(), new Item.Properties().tab(Geomancy.gemsmodblocktab)));
    public static final RegistryObject<BlockItem> TREADSTONE_STAIR_1 = BLOCK_ITEMS.register("treadstone_stair_1", () -> new BlockItem(BlockInit.TREADSTONE_STAIR_1.get(), new Item.Properties().tab(Geomancy.gemsmodblocktab)));
    public static final RegistryObject<BlockItem> TREADSTONE_STAIR_2 = BLOCK_ITEMS.register("treadstone_stair_2", () -> new BlockItem(BlockInit.TREADSTONE_STAIR_2.get(), new Item.Properties().tab(Geomancy.gemsmodblocktab)));
    public static final RegistryObject<BlockItem> TREADSTONE_STAIR_3 =  BLOCK_ITEMS.register("treadstone_stair_3", () -> new BlockItem(BlockInit.TREADSTONE_STAIR_3.get(), new Item.Properties().tab(Geomancy.gemsmodblocktab)));
    public static final RegistryObject<BlockItem> TREADSTONE_STAIR_4 = BLOCK_ITEMS.register("treadstone_stair_4", () -> new BlockItem(BlockInit.TREADSTONE_STAIR_4.get(), new Item.Properties().tab(Geomancy.gemsmodblocktab)));
    public static final RegistryObject<BlockItem> TREADSTONE_STAIR_5 = BLOCK_ITEMS.register("treadstone_stair_5", () -> new BlockItem(BlockInit.TREADSTONE_STAIR_5.get(), new Item.Properties().tab(Geomancy.gemsmodblocktab)));
    public static final RegistryObject<BlockItem> TREADSTONE_STAIR_6 = BLOCK_ITEMS.register("treadstone_stair_6", () -> new BlockItem(BlockInit.TREADSTONE_STAIR_6.get(), new Item.Properties().tab(Geomancy.gemsmodblocktab)));
    public static final RegistryObject<BlockItem> TREADSTONE_STAIR_7 = BLOCK_ITEMS.register("treadstone_stair_7", () -> new BlockItem(BlockInit.TREADSTONE_STAIR_7.get(), new Item.Properties().tab(Geomancy.gemsmodblocktab)));
    public static final RegistryObject<BlockItem> TREADSTONE_CARPET_1 = BLOCK_ITEMS.register("treadstone_carpet_1", () -> new BlockItem(BlockInit.TREADSTONE_CARPET_1.get(), new Item.Properties().tab(Geomancy.gemsmodblocktab)));
    public static final RegistryObject<BlockItem> TREADSTONE_CARPET_2 = BLOCK_ITEMS.register("treadstone_carpet_2", () -> new BlockItem(BlockInit.TREADSTONE_CARPET_2.get(), new Item.Properties().tab(Geomancy.gemsmodblocktab)));
    public static final RegistryObject<BlockItem> TREADSTONE_CARPET_3 =  BLOCK_ITEMS.register("treadstone_carpet_3", () -> new BlockItem(BlockInit.TREADSTONE_CARPET_3.get(), new Item.Properties().tab(Geomancy.gemsmodblocktab)));
    public static final RegistryObject<BlockItem> TREADSTONE_CARPET_4 = BLOCK_ITEMS.register("treadstone_carpet_4", () -> new BlockItem(BlockInit.TREADSTONE_CARPET_4.get(), new Item.Properties().tab(Geomancy.gemsmodblocktab)));
    public static final RegistryObject<BlockItem> TREADSTONE_CARPET_5 = BLOCK_ITEMS.register("treadstone_carpet_5", () -> new BlockItem(BlockInit.TREADSTONE_CARPET_5.get(), new Item.Properties().tab(Geomancy.gemsmodblocktab)));
    public static final RegistryObject<BlockItem> TREADSTONE_CARPET_6 = BLOCK_ITEMS.register("treadstone_carpet_6", () -> new BlockItem(BlockInit.TREADSTONE_CARPET_6.get(), new Item.Properties().tab(Geomancy.gemsmodblocktab)));
    public static final RegistryObject<BlockItem> TREADSTONE_CARPET_7 = BLOCK_ITEMS.register("treadstone_carpet_7", () -> new BlockItem(BlockInit.TREADSTONE_CARPET_7.get(), new Item.Properties().tab(Geomancy.gemsmodblocktab)));
    public static final RegistryObject<BlockItem> SONG_FORGE = BLOCK_ITEMS.register("song_forge", () -> new BlockItem(BlockInit.SONG_FORGE.get(), new Item.Properties().tab(Geomancy.gemsmodblocktab)));
    public static final RegistryObject<BlockItem> TRELLIS = BLOCK_ITEMS.register("trellis", () -> new BlockItem(BlockInit.TRELLIS.get(), new Item.Properties().tab(Geomancy.gemsmodblocktab)));
    public static final RegistryObject<BlockItem> CHASM_SAPLING = BLOCK_ITEMS.register("chasm_sapling", () -> new BlockItem(BlockInit.CHASM_SAPLING.get(), new Item.Properties().tab(Geomancy.gemsmodblocktab)));
    public static final RegistryObject<StandingAndWallBlockItem> END_TORCH = BLOCK_ITEMS.register("end_torch", () -> new StandingAndWallBlockItem(BlockInit.END_TORCH.get(), BlockInit.WALL_END_TORCH.get(), (new Item.Properties()).tab(Geomancy.gemsmodblocktab)));

    public static final RegistryObject<BlockItem> INFINITE_SOURCE_WATER = BLOCK_ITEMS.register("infinite_source_water",  () -> new BlockItem(BlockInit.INFINITE_SOURCE_WATER.get(), new Item.Properties().tab(Geomancy.gemsmodblocktab)));

    public static void register(IEventBus eventBus) {
        BLOCK_ITEMS.register(eventBus);
    }
}
