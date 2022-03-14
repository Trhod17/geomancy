package net.codersdownunder.gemmod.init;

import net.codersdownunder.gemmod.GemMod;
import net.codersdownunder.gemmod.items.*;
import net.codersdownunder.gemmod.utils.GeomancyTags;
import net.minecraft.world.food.Foods;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SignItem;
import net.minecraft.world.item.Tiers;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemInit
{
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, GemMod.MODID);
    
    public static final RegistryObject<Item> AGATE = ITEMS.register("agate", () -> new GemItem(new Item.Properties().tab((GemMod.gemsmoditemtab))));
    public static final RegistryObject<Item> CHRYSOCOLLA = ITEMS.register("chrysocolla", () -> new GemItem(new Item.Properties().tab((GemMod.gemsmoditemtab))));
    public static final RegistryObject<Item> MALACHITE = ITEMS.register("malachite", () -> new GemItem(new Item.Properties().tab((GemMod.gemsmoditemtab))));
    public static final RegistryObject<Item> JADE = ITEMS.register("jade", () -> new GemItem(new Item.Properties().tab((GemMod.gemsmoditemtab))));
    public static final RegistryObject<Item> PERIDOT = ITEMS.register("peridot", () -> new GemItem(new Item.Properties().tab((GemMod.gemsmoditemtab))));
    public static final RegistryObject<Item> TOPAZ = ITEMS.register("topaz", () -> new GemItem(new Item.Properties().tab((GemMod.gemsmoditemtab))));
    public static final RegistryObject<Item> CITRINE = ITEMS.register("citrine", () -> new GemItem(new Item.Properties().tab((GemMod.gemsmoditemtab))));
    public static final RegistryObject<Item> JASPER = ITEMS.register("jasper", () -> new GemItem(new Item.Properties().tab((GemMod.gemsmoditemtab))));
    public static final RegistryObject<Item> RUBY = ITEMS.register("ruby", () -> new GemItem(new Item.Properties().tab((GemMod.gemsmoditemtab))));
    public static final RegistryObject<Item> GARNET = ITEMS.register("garnet", () -> new GemItem(new Item.Properties().tab((GemMod.gemsmoditemtab))));
    public static final RegistryObject<Item> SPINEL = ITEMS.register("spinel", () -> new GemItem(new Item.Properties().tab((GemMod.gemsmoditemtab))));
    public static final RegistryObject<Item> AMETHYST = ITEMS.register("amethyst", () -> new GemItem(new Item.Properties().tab((GemMod.gemsmoditemtab))));
    public static final RegistryObject<Item> CHAROITE = ITEMS.register("charoite", () -> new GemItem(new Item.Properties().tab((GemMod.gemsmoditemtab))));
    public static final RegistryObject<Item> SAPPHIRE = ITEMS.register("sapphire", () -> new GemItem(new Item.Properties().tab((GemMod.gemsmoditemtab))));
    public static final RegistryObject<Item> LILYSTAR = ITEMS.register("lilystar", () -> new GemItem(new Item.Properties().tab((GemMod.gemsmoditemtab))));
    public static final RegistryObject<Item> ONYX = ITEMS.register("onyx", () -> new GemItem(new Item.Properties().tab((GemMod.gemsmoditemtab))));
    public static final RegistryObject<Item> SPHENE = ITEMS.register("sphene", () -> new GemItem(new Item.Properties().tab((GemMod.gemsmoditemtab))));
    public static final RegistryObject<Item> RHODONITE = ITEMS.register("rhodonite", () -> new GemItem(new Item.Properties().tab((GemMod.gemsmoditemtab))));
    
    public static final RegistryObject<Item> AGATE_DREAMING = ITEMS.register("agate_dreaming", () -> new DreamingGemItem(new Item.Properties().tab((GemMod.gemsmoditemtab))));
    public static final RegistryObject<Item> CHRYSOCOLLA_DREAMING = ITEMS.register("chrysocolla_dreaming", () -> new DreamingGemItem(new Item.Properties().tab((GemMod.gemsmoditemtab))));
    public static final RegistryObject<Item> MALACHITE_DREAMING = ITEMS.register("malachite_dreaming", () -> new DreamingGemItem(new Item.Properties().tab((GemMod.gemsmoditemtab))));
    public static final RegistryObject<Item> JADE_DREAMING = ITEMS.register("jade_dreaming", () -> new DreamingGemItem(new Item.Properties().tab((GemMod.gemsmoditemtab))));
    public static final RegistryObject<Item> PERIDOT_DREAMING = ITEMS.register("peridot_dreaming", () -> new DreamingGemItem(new Item.Properties().tab((GemMod.gemsmoditemtab))));
    public static final RegistryObject<Item> TOPAZ_DREAMING = ITEMS.register("topaz_dreaming", () -> new DreamingGemItem(new Item.Properties().tab((GemMod.gemsmoditemtab))));
    public static final RegistryObject<Item> CITRINE_DREAMING = ITEMS.register("citrine_dreaming", () -> new DreamingGemItem(new Item.Properties().tab((GemMod.gemsmoditemtab))));
    public static final RegistryObject<Item> JASPER_DREAMING = ITEMS.register("jasper_dreaming", () -> new DreamingGemItem(new Item.Properties().tab((GemMod.gemsmoditemtab))));
    public static final RegistryObject<Item> RUBY_DREAMING = ITEMS.register("ruby_dreaming", () -> new DreamingGemItem(new Item.Properties().tab((GemMod.gemsmoditemtab))));
    public static final RegistryObject<Item> GARNET_DREAMING = ITEMS.register("garnet_dreaming", () -> new DreamingGemItem(new Item.Properties().tab((GemMod.gemsmoditemtab))));
    public static final RegistryObject<Item> SPINEL_DREAMING = ITEMS.register("spinel_dreaming", () -> new DreamingGemItem(new Item.Properties().tab((GemMod.gemsmoditemtab))));
    public static final RegistryObject<Item> AMETHYST_DREAMING = ITEMS.register("amethyst_dreaming", () -> new DreamingGemItem(new Item.Properties().tab((GemMod.gemsmoditemtab))));
    public static final RegistryObject<Item> CHAROITE_DREAMING = ITEMS.register("charoite_dreaming", () -> new DreamingGemItem(new Item.Properties().tab((GemMod.gemsmoditemtab))));
    public static final RegistryObject<Item> SAPPHIRE_DREAMING = ITEMS.register("sapphire_dreaming", () -> new DreamingGemItem(new Item.Properties().tab((GemMod.gemsmoditemtab))));
    public static final RegistryObject<Item> LILYSTAR_DREAMING = ITEMS.register("lilystar_dreaming", () -> new DreamingGemItem(new Item.Properties().tab((GemMod.gemsmoditemtab))));
    public static final RegistryObject<Item> ONYX_DREAMING = ITEMS.register("onyx_dreaming", () -> new DreamingGemItem(new Item.Properties().tab((GemMod.gemsmoditemtab))));
    public static final RegistryObject<Item> SPHENE_DREAMING = ITEMS.register("sphene_dreaming", () -> new DreamingGemItem(new Item.Properties().tab((GemMod.gemsmoditemtab))));
    public static final RegistryObject<Item> RHODONITE_DREAMING = ITEMS.register("rhodonite_dreaming", () -> new DreamingGemItem(new Item.Properties().tab((GemMod.gemsmoditemtab))));
    public static final RegistryObject<Item> EMERALD_DREAMING = ITEMS.register("emerald_dreaming", () -> new DreamingGemItem(new Item.Properties().tab((GemMod.gemsmoditemtab))));
    
    public static final RegistryObject<Item> MULMUS_BULB = ITEMS.register("mulmus_bulb", () -> new MulmusItem(new Item.Properties().food(Foods.PORKCHOP).tab(GemMod.gemsmoditemtab)));
    
    public static final RegistryObject<Item> CONCOCTION_ONE = ITEMS.register("concoction_one", () -> new Item(new Item.Properties().durability(16).tab((GemMod.gemsmoditemtab))));
    public static final RegistryObject<Item> CONCOCTION_TWO = ITEMS.register("concoction_two", () -> new Item(new Item.Properties().durability(8).tab((GemMod.gemsmoditemtab))));
    public static final RegistryObject<Item> CONCOCTION_THREE = ITEMS.register("concoction_three", () -> new Item(new Item.Properties().durability(4).tab((GemMod.gemsmoditemtab))));
    public static final RegistryObject<Item> CONCOCTION_FOUR = ITEMS.register("concoction_four", () -> new Item(new Item.Properties().durability(2).tab((GemMod.gemsmoditemtab))));

    public static final RegistryObject<Item> GEODE = ITEMS.register("geode", () -> new DreamingGemItem(new Item.Properties().tab((GemMod.gemsmoditemtab))));
    public static final RegistryObject<Item> RICH_GEODE = ITEMS.register("rich_geode", () -> new DreamingGemItem(new Item.Properties().tab((GemMod.gemsmoditemtab))));
    public static final RegistryObject<Item> SPARSE_GEODE = ITEMS.register("sparse_geode", () -> new DreamingGemItem(new Item.Properties().tab((GemMod.gemsmoditemtab))));
    
    public static final RegistryObject<Item> TELE_CORE = ITEMS.register("tele_core", () -> new TeleCoreItem(new Item.Properties().tab(GemMod.gemsmoditemtab)));
    public static final RegistryObject<Item> CATCHER_RING = ITEMS.register("catcher_ring", () -> new Item(new Item.Properties().tab(GemMod.gemsmoditemtab)));
    
    public static final RegistryObject<Item> DREAM_DUST = ITEMS.register("dream_dust", () -> new Item(new Item.Properties().tab(GemMod.gemsmoditemtab)));
    
    public static final RegistryObject<Item> EMPTY_DISK = ITEMS.register("empty_disk", () -> new Item(new Item.Properties().tab(GemMod.gemsmoditemtab)));
    public static final RegistryObject<Item> CONCENTRATION = ITEMS.register("concentration", () -> new Item(new Item.Properties().tab(GemMod.gemsmoditemtab)));
    public static final RegistryObject<Item> NETHERRITE_NUGGET = ITEMS.register("netherrite_nugget",  () -> new Item(new Item.Properties().tab(GemMod.gemsmoditemtab)));
    
    public static final RegistryObject<Item> EMPTY_TOTEM = ITEMS.register("empty_totem", () -> new Item(new Item.Properties().tab(GemMod.gemsmoditemtab)));
    public static final RegistryObject<Item> NETHER_CRUX = ITEMS.register("nether_crux", () -> new Item(new Item.Properties().tab(GemMod.gemsmoditemtab)));
    
    public static final RegistryObject<Item> ROSE_QUARTZ = ITEMS.register("rose_quartz", () -> new Item(new Item.Properties().tab(GemMod.gemsmoditemtab)));
    
    public static final RegistryObject<Item> PLATE_FAILSAFE = ITEMS.register("plate_failsafe", () -> new Item(new Item.Properties().tab(GemMod.gemsmoditemtab)));
    public static final RegistryObject<Item> PLATE_FUEL_COAL = ITEMS.register("plate_fuel_coal", () -> new Item(new Item.Properties().tab(GemMod.gemsmoditemtab)));
    public static final RegistryObject<Item> PLATE_FUEL_TIME = ITEMS.register("plate_fuel_time", () -> new Item(new Item.Properties().tab(GemMod.gemsmoditemtab)));
    public static final RegistryObject<Item> PLATE_SPEED_OVERDRIVE = ITEMS.register("plate_speed_overdrive", () -> new Item(new Item.Properties().tab(GemMod.gemsmoditemtab)));
    public static final RegistryObject<Item> PLATE_SPEED_UP = ITEMS.register("plate_speed_up", () -> new Item(new Item.Properties().tab(GemMod.gemsmoditemtab)));
    public static final RegistryObject<Item> PLATE_YIELD_ORE = ITEMS.register("plate_yield_ore", () -> new Item(new Item.Properties().tab(GemMod.gemsmoditemtab)));
    
    public static final RegistryObject<Item> DIGGING_CLAW_WOOD = ITEMS.register("digging_claw_wood", () -> new DiggingClawItem(1, -2.8F, Tiers.WOOD, GeomancyTags.Blocks.claw, new Item.Properties().tab(GemMod.gemsmoditemtab)));
    public static final RegistryObject<Item> DIGGING_CLAW_STONE = ITEMS.register("digging_claw_stone", () -> new DiggingClawItem(1, -2.8F, Tiers.STONE, GeomancyTags.Blocks.claw, new Item.Properties().tab(GemMod.gemsmoditemtab)));
    public static final RegistryObject<Item> DIGGING_CLAW_IRON = ITEMS.register("digging_claw_iron", () -> new DiggingClawItem(0, 0, Tiers.IRON, GeomancyTags.Blocks.claw, new Item.Properties().tab(GemMod.gemsmoditemtab)));
    public static final RegistryObject<Item> DIGGING_CLAW_GOLD = ITEMS.register("digging_claw_gold", () -> new DiggingClawItem(1, -2.8F, Tiers.GOLD, GeomancyTags.Blocks.claw, new Item.Properties().tab(GemMod.gemsmoditemtab)));
    public static final RegistryObject<Item> DIGGING_CLAW_DIAMOND = ITEMS.register("digging_claw_diamond", () -> new DiggingClawItem(1, -2.8F, Tiers.DIAMOND, GeomancyTags.Blocks.claw, new Item.Properties().tab(GemMod.gemsmoditemtab)));
    public static final RegistryObject<Item> DIGGING_CLAW_NETHERITE = ITEMS.register("digging_claw_netherite", () -> new DiggingClawItem(1, -2.8F, Tiers.NETHERITE, GeomancyTags.Blocks.claw, new Item.Properties().tab(GemMod.gemsmoditemtab)));
    
    
    
    
    
    
    
    
    /*
     * Block Items Only Below this point
     */
    
    public static final RegistryObject<BlockItem> CHASM_SIGN = ITEMS.register("chasm_sign", () -> new SignItem((new Item.Properties()).stacksTo(16).tab(GemMod.gemsmodblocktab), BlockInit.CHASM_SIGN.get(), BlockInit.CHASM_SIGN_WALL.get()));
    public static final RegistryObject<BlockItem> END_LANTERN = ITEMS.register("end_lantern", () -> new BlockItem(BlockInit.END_LANTERN.get(), new Item.Properties().tab(GemMod.gemsmodblocktab)));
    public static final RegistryObject<BlockItem> END_LANTERN_BLOCK = ITEMS.register("end_lantern_block", () -> new BlockItem(BlockInit.END_LANTERN_BLOCK.get(), new Item.Properties().tab(GemMod.gemsmodblocktab)));
    public static final RegistryObject<BlockItem> CHASM_BUTTON = ITEMS.register("chasm_button", () -> new BlockItem(BlockInit.CHASM_BUTTON.get(), new Item.Properties().tab(GemMod.gemsmodblocktab)));
    public static final RegistryObject<BlockItem> CHASM_DOOR = ITEMS.register("chasm_door", () -> new BlockItem(BlockInit.CHASM_DOOR.get(), new Item.Properties().tab(GemMod.gemsmodblocktab)));
    public static final RegistryObject<BlockItem> CHASM_FENCE = ITEMS.register("chasm_fence", () -> new BlockItem(BlockInit.CHASM_FENCE.get(), new Item.Properties().tab(GemMod.gemsmodblocktab)));
    public static final RegistryObject<BlockItem> CHASM_FENCE_GATE = ITEMS.register("chasm_fence_gate", () -> new BlockItem(BlockInit.CHASM_FENCE_GATE.get(), new Item.Properties().tab(GemMod.gemsmodblocktab)));
    public static final RegistryObject<BlockItem> CHASM_LOG = ITEMS.register("chasm_log", () -> new BlockItem(BlockInit.CHASM_LOG.get(), new Item.Properties().tab(GemMod.gemsmodblocktab)));
    public static final RegistryObject<BlockItem> CHASM_LOG_BARK = ITEMS.register("chasm_log_bark", () -> new BlockItem(BlockInit.CHASM_LOG_BARK.get(), new Item.Properties().tab(GemMod.gemsmodblocktab)));
    public static final RegistryObject<BlockItem> CHASM_LOG_STRIPPED = ITEMS.register("chasm_log_stripped", () -> new BlockItem(BlockInit.CHASM_LOG_STRIPPED.get(), new Item.Properties().tab(GemMod.gemsmodblocktab)));
    public static final RegistryObject<BlockItem> CHASM_LOG_STRIPPED_BARK = ITEMS.register("chasm_log_stripped_bark", () -> new BlockItem(BlockInit.CHASM_LOG_STRIPPED_BARK.get(), new Item.Properties().tab(GemMod.gemsmodblocktab)));
    public static final RegistryObject<BlockItem> CHASM_PLANKS = ITEMS.register("chasm_planks", () -> new BlockItem(BlockInit.CHASM_PLANKS.get(), new Item.Properties().tab(GemMod.gemsmodblocktab)));
    public static final RegistryObject<BlockItem> CHASM_PLATE = ITEMS.register("chasm_plate", () -> new BlockItem(BlockInit.CHASM_PLATE.get(), new Item.Properties().tab(GemMod.gemsmodblocktab)));
    public static final RegistryObject<BlockItem> CHASM_SLAB = ITEMS.register("chasm_slab", () -> new BlockItem(BlockInit.CHASM_SLAB.get(), new Item.Properties().tab(GemMod.gemsmodblocktab)));
    public static final RegistryObject<BlockItem> CHASM_STAIRS = ITEMS.register("chasm_stairs", () -> new BlockItem(BlockInit.CHASM_STAIRS.get(), new Item.Properties().tab(GemMod.gemsmodblocktab)));
    public static final RegistryObject<BlockItem> CHASM_TRAPDOOR = ITEMS.register("chasm_trapdoor", () -> new BlockItem(BlockInit.CHASM_TRAPDOOR.get(), new Item.Properties().tab(GemMod.gemsmodblocktab)));
    public static final RegistryObject<BlockItem> CHASM_LEAVES = ITEMS.register("chasm_leaves", () -> new BlockItem(BlockInit.CHASM_LEAVES.get(), new Item.Properties().tab(GemMod.gemsmodblocktab)));
    public static final RegistryObject<BlockItem> MULMUS_LANTERN = ITEMS.register("mulmus_lantern", () -> new BlockItem(BlockInit.MULMUS_LANTERN.get(), new Item.Properties().tab(GemMod.gemsmodblocktab)));
    public static final RegistryObject<BlockItem> MULMUS_LANTERN_POLISHED = ITEMS.register("mulmus_lantern_polished", () -> new BlockItem(BlockInit.MULMUS_LANTERN_POLISHED.get(), new Item.Properties().tab(GemMod.gemsmodblocktab)));
    public static final RegistryObject<BlockItem> INFUSION_TABLE = ITEMS.register("infusion_table", () -> new BlockItem(BlockInit.INFUSION_TABLE.get(), new Item.Properties().tab(GemMod.gemsmodblocktab)));
    public static final RegistryObject<BlockItem> DIPPER = ITEMS.register("dipper", () -> new BlockItem(BlockInit.DIPPER.get(), new Item.Properties().tab(GemMod.gemsmodblocktab)));
    public static final RegistryObject<BlockItem> DREAM_CATCHER = ITEMS.register("dream_catcher", () -> new BlockItem(BlockInit.DREAM_CATCHER.get(), new Item.Properties().tab(GemMod.gemsmodblocktab)));
    public static final RegistryObject<BlockItem> GEODE_ORE = ITEMS.register("geode_ore", () -> new BlockItem(BlockInit.GEODE_ORE.get(), new Item.Properties().tab(GemMod.gemsmodblocktab)));
    public static final RegistryObject<BlockItem> TELEPAD = ITEMS.register("telepad", () -> new BlockItem(BlockInit.TELEPAD.get(), new Item.Properties().tab(GemMod.gemsmodblocktab)));
    public static final RegistryObject<BlockItem> TELEPAD_SLAB = ITEMS.register("telepad_slab", () -> new BlockItem(BlockInit.TELEPAD_SLAB.get(), new Item.Properties().tab(GemMod.gemsmodblocktab)));
    public static final RegistryObject<BlockItem> TERRA_FIRMA = ITEMS.register("terra_firma", () -> new BlockItem(BlockInit.TERRA_FIRMA.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> INFUSION_STAND = ITEMS.register("infusion_stand", () -> new BlockItem(BlockInit.INFUSION_STAND.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> TREADSTONE_1 = ITEMS.register("treadstone_1", () -> new BlockItem(BlockInit.TREADSTONE_1.get(), new Item.Properties().tab(GemMod.gemsmodblocktab)));
    public static final RegistryObject<BlockItem> TREADSTONE_2 = ITEMS.register("treadstone_2", () -> new BlockItem(BlockInit.TREADSTONE_2.get(), new Item.Properties().tab(GemMod.gemsmodblocktab)));
    public static final RegistryObject<BlockItem> TREADSTONE_3 =  ITEMS.register("treadstone_3", () -> new BlockItem(BlockInit.TREADSTONE_3.get(), new Item.Properties().tab(GemMod.gemsmodblocktab)));
    public static final RegistryObject<BlockItem> TREADSTONE_4 = ITEMS.register("treadstone_4", () -> new BlockItem(BlockInit.TREADSTONE_4.get(), new Item.Properties().tab(GemMod.gemsmodblocktab)));
    public static final RegistryObject<BlockItem> TREADSTONE_5 = ITEMS.register("treadstone_5", () -> new BlockItem(BlockInit.TREADSTONE_5.get(), new Item.Properties().tab(GemMod.gemsmodblocktab)));
    public static final RegistryObject<BlockItem> TREADSTONE_6 = ITEMS.register("treadstone_6", () -> new BlockItem(BlockInit.TREADSTONE_6.get(), new Item.Properties().tab(GemMod.gemsmodblocktab)));
    public static final RegistryObject<BlockItem> TREADSTONE_7 = ITEMS.register("treadstone_7", () -> new BlockItem(BlockInit.TREADSTONE_7.get(), new Item.Properties().tab(GemMod.gemsmodblocktab)));
    public static final RegistryObject<BlockItem> TREADSTONE_SLAB_1 = ITEMS.register("treadstone_slab_1", () -> new BlockItem(BlockInit.TREADSTONE_SLAB_1.get(), new Item.Properties().tab(GemMod.gemsmodblocktab)));
    public static final RegistryObject<BlockItem> TREADSTONE_SLAB_2 = ITEMS.register("treadstone_slab_2", () -> new BlockItem(BlockInit.TREADSTONE_SLAB_2.get(), new Item.Properties().tab(GemMod.gemsmodblocktab)));
    public static final RegistryObject<BlockItem> TREADSTONE_SLAB_3 =  ITEMS.register("treadstone_slab_3", () -> new BlockItem(BlockInit.TREADSTONE_SLAB_3.get(), new Item.Properties().tab(GemMod.gemsmodblocktab)));
    public static final RegistryObject<BlockItem> TREADSTONE_SLAB_4 = ITEMS.register("treadstone_slab_4", () -> new BlockItem(BlockInit.TREADSTONE_SLAB_4.get(), new Item.Properties().tab(GemMod.gemsmodblocktab)));
    public static final RegistryObject<BlockItem> TREADSTONE_SLAB_5 = ITEMS.register("treadstone_slab_5", () -> new BlockItem(BlockInit.TREADSTONE_SLAB_5.get(), new Item.Properties().tab(GemMod.gemsmodblocktab)));
    public static final RegistryObject<BlockItem> TREADSTONE_SLAB_6 = ITEMS.register("treadstone_slab_6", () -> new BlockItem(BlockInit.TREADSTONE_SLAB_6.get(), new Item.Properties().tab(GemMod.gemsmodblocktab)));
    public static final RegistryObject<BlockItem> TREADSTONE_SLAB_7 = ITEMS.register("treadstone_slab_7", () -> new BlockItem(BlockInit.TREADSTONE_SLAB_7.get(), new Item.Properties().tab(GemMod.gemsmodblocktab)));
    public static final RegistryObject<BlockItem> TREADSTONE_STAIR_1 = ITEMS.register("treadstone_stair_1", () -> new BlockItem(BlockInit.TREADSTONE_STAIR_1.get(), new Item.Properties().tab(GemMod.gemsmodblocktab)));
    public static final RegistryObject<BlockItem> TREADSTONE_STAIR_2 = ITEMS.register("treadstone_stair_2", () -> new BlockItem(BlockInit.TREADSTONE_STAIR_2.get(), new Item.Properties().tab(GemMod.gemsmodblocktab)));
    public static final RegistryObject<BlockItem> TREADSTONE_STAIR_3 =  ITEMS.register("treadstone_stair_3", () -> new BlockItem(BlockInit.TREADSTONE_STAIR_3.get(), new Item.Properties().tab(GemMod.gemsmodblocktab)));
    public static final RegistryObject<BlockItem> TREADSTONE_STAIR_4 = ITEMS.register("treadstone_stair_4", () -> new BlockItem(BlockInit.TREADSTONE_STAIR_4.get(), new Item.Properties().tab(GemMod.gemsmodblocktab)));
    public static final RegistryObject<BlockItem> TREADSTONE_STAIR_5 = ITEMS.register("treadstone_stair_5", () -> new BlockItem(BlockInit.TREADSTONE_STAIR_5.get(), new Item.Properties().tab(GemMod.gemsmodblocktab)));
    public static final RegistryObject<BlockItem> TREADSTONE_STAIR_6 = ITEMS.register("treadstone_stair_6", () -> new BlockItem(BlockInit.TREADSTONE_STAIR_6.get(), new Item.Properties().tab(GemMod.gemsmodblocktab)));
    public static final RegistryObject<BlockItem> TREADSTONE_STAIR_7 = ITEMS.register("treadstone_stair_7", () -> new BlockItem(BlockInit.TREADSTONE_STAIR_7.get(), new Item.Properties().tab(GemMod.gemsmodblocktab)));
    public static final RegistryObject<BlockItem> TREADSTONE_CARPET_1 = ITEMS.register("treadstone_carpet_1", () -> new BlockItem(BlockInit.TREADSTONE_CARPET_1.get(), new Item.Properties().tab(GemMod.gemsmodblocktab)));
    public static final RegistryObject<BlockItem> TREADSTONE_CARPET_2 = ITEMS.register("treadstone_carpet_2", () -> new BlockItem(BlockInit.TREADSTONE_CARPET_2.get(), new Item.Properties().tab(GemMod.gemsmodblocktab)));
    public static final RegistryObject<BlockItem> TREADSTONE_CARPET_3 =  ITEMS.register("treadstone_carpet_3", () -> new BlockItem(BlockInit.TREADSTONE_CARPET_3.get(), new Item.Properties().tab(GemMod.gemsmodblocktab)));
    public static final RegistryObject<BlockItem> TREADSTONE_CARPET_4 = ITEMS.register("treadstone_carpet_4", () -> new BlockItem(BlockInit.TREADSTONE_CARPET_4.get(), new Item.Properties().tab(GemMod.gemsmodblocktab)));
    public static final RegistryObject<BlockItem> TREADSTONE_CARPET_5 = ITEMS.register("treadstone_carpet_5", () -> new BlockItem(BlockInit.TREADSTONE_CARPET_5.get(), new Item.Properties().tab(GemMod.gemsmodblocktab)));
    public static final RegistryObject<BlockItem> TREADSTONE_CARPET_6 = ITEMS.register("treadstone_carpet_6", () -> new BlockItem(BlockInit.TREADSTONE_CARPET_6.get(), new Item.Properties().tab(GemMod.gemsmodblocktab)));
    public static final RegistryObject<BlockItem> TREADSTONE_CARPET_7 = ITEMS.register("treadstone_carpet_7", () -> new BlockItem(BlockInit.TREADSTONE_CARPET_7.get(), new Item.Properties().tab(GemMod.gemsmodblocktab)));
    public static final RegistryObject<BlockItem> SONG_FORGE = ITEMS.register("song_forge", () -> new BlockItem(BlockInit.SONG_FORGE.get(), new Item.Properties().tab(GemMod.gemsmodblocktab)));
    public static final RegistryObject<BlockItem> TRELLIS = ITEMS.register("trellis", () -> new BlockItem(BlockInit.TRELLIS.get(), new Item.Properties().tab(GemMod.gemsmodblocktab)));
    public static final RegistryObject<BlockItem> CHASM_SAPLING = ITEMS.register("chasm_sapling", () -> new BlockItem(BlockInit.CHASM_SAPLING.get(), new Item.Properties().tab(GemMod.gemsmodblocktab)));
}