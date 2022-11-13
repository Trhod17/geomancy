package net.codersdownunder.gemmod.init;

import net.codersdownunder.gemmod.Geomancy;
import net.codersdownunder.gemmod.items.*;
import net.codersdownunder.gemmod.utils.GeomancyTags;
import net.minecraft.world.food.Foods;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(modid = Geomancy.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ItemInit
{
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Geomancy.MODID);
    public static final RegistryObject<Item> AGATE = ITEMS.register("agate", () -> new GemItem(new Item.Properties().tab((Geomancy.gemsmoditemtab))));
    public static final RegistryObject<Item> CHRYSOCOLLA = ITEMS.register("chrysocolla", () -> new GemItem(new Item.Properties().tab((Geomancy.gemsmoditemtab))));
    public static final RegistryObject<Item> MALACHITE = ITEMS.register("malachite", () -> new GemItem(new Item.Properties().tab((Geomancy.gemsmoditemtab))));
    public static final RegistryObject<Item> JADE = ITEMS.register("jade", () -> new GemItem(new Item.Properties().tab((Geomancy.gemsmoditemtab))));
    public static final RegistryObject<Item> PERIDOT = ITEMS.register("peridot", () -> new GemItem(new Item.Properties().tab((Geomancy.gemsmoditemtab))));
    public static final RegistryObject<Item> TOPAZ = ITEMS.register("topaz", () -> new GemItem(new Item.Properties().tab((Geomancy.gemsmoditemtab))));
    public static final RegistryObject<Item> CITRINE = ITEMS.register("citrine", () -> new GemItem(new Item.Properties().tab((Geomancy.gemsmoditemtab))));
    public static final RegistryObject<Item> JASPER = ITEMS.register("jasper", () -> new GemItem(new Item.Properties().tab((Geomancy.gemsmoditemtab))));
    public static final RegistryObject<Item> RUBY = ITEMS.register("ruby", () -> new GemItem(new Item.Properties().tab((Geomancy.gemsmoditemtab))));
    public static final RegistryObject<Item> GARNET = ITEMS.register("garnet", () -> new GemItem(new Item.Properties().tab((Geomancy.gemsmoditemtab))));
    public static final RegistryObject<Item> SPINEL = ITEMS.register("spinel", () -> new GemItem(new Item.Properties().tab((Geomancy.gemsmoditemtab))));
    public static final RegistryObject<Item> AMETHYST = ITEMS.register("amethyst", () -> new GemItem(new Item.Properties().tab((Geomancy.gemsmoditemtab))));
    public static final RegistryObject<Item> CHAROITE = ITEMS.register("charoite", () -> new GemItem(new Item.Properties().tab((Geomancy.gemsmoditemtab))));
    public static final RegistryObject<Item> SAPPHIRE = ITEMS.register("sapphire", () -> new GemItem(new Item.Properties().tab((Geomancy.gemsmoditemtab))));
    public static final RegistryObject<Item> LILYSTAR = ITEMS.register("lilystar", () -> new GemItem(new Item.Properties().tab((Geomancy.gemsmoditemtab))));
    public static final RegistryObject<Item> ONYX = ITEMS.register("onyx", () -> new GemItem(new Item.Properties().tab((Geomancy.gemsmoditemtab))));
    public static final RegistryObject<Item> SPHENE = ITEMS.register("sphene", () -> new GemItem(new Item.Properties().tab((Geomancy.gemsmoditemtab))));
    public static final RegistryObject<Item> RHODONITE = ITEMS.register("rhodonite", () -> new GemItem(new Item.Properties().tab((Geomancy.gemsmoditemtab))));
    
    public static final RegistryObject<Item> AGATE_DREAMING = ITEMS.register("agate_dreaming", () -> new DreamingGemItem(new Item.Properties().tab((Geomancy.gemsmoditemtab))));
    public static final RegistryObject<Item> CHRYSOCOLLA_DREAMING = ITEMS.register("chrysocolla_dreaming", () -> new DreamingGemItem(new Item.Properties().tab((Geomancy.gemsmoditemtab))));
    public static final RegistryObject<Item> MALACHITE_DREAMING = ITEMS.register("malachite_dreaming", () -> new DreamingGemItem(new Item.Properties().tab((Geomancy.gemsmoditemtab))));
    public static final RegistryObject<Item> JADE_DREAMING = ITEMS.register("jade_dreaming", () -> new DreamingGemItem(new Item.Properties().tab((Geomancy.gemsmoditemtab))));
    public static final RegistryObject<Item> PERIDOT_DREAMING = ITEMS.register("peridot_dreaming", () -> new DreamingGemItem(new Item.Properties().tab((Geomancy.gemsmoditemtab))));
    public static final RegistryObject<Item> TOPAZ_DREAMING = ITEMS.register("topaz_dreaming", () -> new DreamingGemItem(new Item.Properties().tab((Geomancy.gemsmoditemtab))));
    public static final RegistryObject<Item> CITRINE_DREAMING = ITEMS.register("citrine_dreaming", () -> new DreamingGemItem(new Item.Properties().tab((Geomancy.gemsmoditemtab))));
    public static final RegistryObject<Item> JASPER_DREAMING = ITEMS.register("jasper_dreaming", () -> new DreamingGemItem(new Item.Properties().tab((Geomancy.gemsmoditemtab))));
    public static final RegistryObject<Item> RUBY_DREAMING = ITEMS.register("ruby_dreaming", () -> new DreamingGemItem(new Item.Properties().tab((Geomancy.gemsmoditemtab))));
    public static final RegistryObject<Item> GARNET_DREAMING = ITEMS.register("garnet_dreaming", () -> new DreamingGemItem(new Item.Properties().tab((Geomancy.gemsmoditemtab))));
    public static final RegistryObject<Item> SPINEL_DREAMING = ITEMS.register("spinel_dreaming", () -> new DreamingGemItem(new Item.Properties().tab((Geomancy.gemsmoditemtab))));
    public static final RegistryObject<Item> AMETHYST_DREAMING = ITEMS.register("amethyst_dreaming", () -> new DreamingGemItem(new Item.Properties().tab((Geomancy.gemsmoditemtab))));
    public static final RegistryObject<Item> CHAROITE_DREAMING = ITEMS.register("charoite_dreaming", () -> new DreamingGemItem(new Item.Properties().tab((Geomancy.gemsmoditemtab))));
    public static final RegistryObject<Item> SAPPHIRE_DREAMING = ITEMS.register("sapphire_dreaming", () -> new DreamingGemItem(new Item.Properties().tab((Geomancy.gemsmoditemtab))));
    public static final RegistryObject<Item> LILYSTAR_DREAMING = ITEMS.register("lilystar_dreaming", () -> new DreamingGemItem(new Item.Properties().tab((Geomancy.gemsmoditemtab))));
    public static final RegistryObject<Item> ONYX_DREAMING = ITEMS.register("onyx_dreaming", () -> new DreamingGemItem(new Item.Properties().tab((Geomancy.gemsmoditemtab))));
    public static final RegistryObject<Item> SPHENE_DREAMING = ITEMS.register("sphene_dreaming", () -> new DreamingGemItem(new Item.Properties().tab((Geomancy.gemsmoditemtab))));
    public static final RegistryObject<Item> RHODONITE_DREAMING = ITEMS.register("rhodonite_dreaming", () -> new DreamingGemItem(new Item.Properties().tab((Geomancy.gemsmoditemtab))));
    public static final RegistryObject<Item> EMERALD_DREAMING = ITEMS.register("emerald_dreaming", () -> new DreamingGemItem(new Item.Properties().tab((Geomancy.gemsmoditemtab))));
    
    public static final RegistryObject<Item> MULMUS_BULB = ITEMS.register("mulmus_bulb", () -> new MulmusItem(new Item.Properties().food(Foods.PORKCHOP).tab(Geomancy.gemsmoditemtab)));
    
    public static final RegistryObject<Item> CONCOCTION_ONE = ITEMS.register("concoction_one", () -> new Item(new Item.Properties().durability(16).tab((Geomancy.gemsmoditemtab))));
    public static final RegistryObject<Item> CONCOCTION_TWO = ITEMS.register("concoction_two", () -> new Item(new Item.Properties().durability(8).tab((Geomancy.gemsmoditemtab))));
    public static final RegistryObject<Item> CONCOCTION_THREE = ITEMS.register("concoction_three", () -> new Item(new Item.Properties().durability(4).tab((Geomancy.gemsmoditemtab))));
    public static final RegistryObject<Item> CONCOCTION_FOUR = ITEMS.register("concoction_four", () -> new Item(new Item.Properties().durability(2).tab((Geomancy.gemsmoditemtab))));

    public static final RegistryObject<Item> GEODE = ITEMS.register("geode", () -> new DreamingGemItem(new Item.Properties().tab((Geomancy.gemsmoditemtab))));
    public static final RegistryObject<Item> RICH_GEODE = ITEMS.register("rich_geode", () -> new DreamingGemItem(new Item.Properties().tab((Geomancy.gemsmoditemtab))));
    public static final RegistryObject<Item> SPARSE_GEODE = ITEMS.register("sparse_geode", () -> new DreamingGemItem(new Item.Properties().tab((Geomancy.gemsmoditemtab))));
    
    public static final RegistryObject<Item> TELE_CORE = ITEMS.register("tele_core", () -> new TeleCoreItem(new Item.Properties().tab(Geomancy.gemsmoditemtab)));
    public static final RegistryObject<Item> CATCHER_RING = ITEMS.register("catcher_ring", () -> new Item(new Item.Properties().tab(Geomancy.gemsmoditemtab)));
    
    public static final RegistryObject<Item> DREAM_DUST = ITEMS.register("dream_dust", () -> new Item(new Item.Properties().tab(Geomancy.gemsmoditemtab)));
    
    public static final RegistryObject<Item> EMPTY_DISK = ITEMS.register("empty_disk", () -> new Item(new Item.Properties().tab(Geomancy.gemsmoditemtab)));
    public static final RegistryObject<Item> CONCENTRATION = ITEMS.register("concentration", () -> new Item(new Item.Properties().tab(Geomancy.gemsmoditemtab)));
    public static final RegistryObject<Item> NETHERRITE_NUGGET = ITEMS.register("netherrite_nugget",  () -> new Item(new Item.Properties().tab(Geomancy.gemsmoditemtab)));
    
    public static final RegistryObject<Item> EMPTY_TOTEM = ITEMS.register("empty_totem", () -> new Item(new Item.Properties().tab(Geomancy.gemsmoditemtab)));
    public static final RegistryObject<Item> NETHER_CRUX = ITEMS.register("nether_crux", () -> new Item(new Item.Properties().tab(Geomancy.gemsmoditemtab)));
    
    public static final RegistryObject<Item> ROSE_QUARTZ = ITEMS.register("rose_quartz", () -> new Item(new Item.Properties().tab(Geomancy.gemsmoditemtab)));
    
    public static final RegistryObject<Item> PLATE_FAILSAFE = ITEMS.register("plate_failsafe", () -> new Item(new Item.Properties().tab(Geomancy.gemsmoditemtab).stacksTo(5)));
    public static final RegistryObject<Item> PLATE_FUEL_COAL = ITEMS.register("plate_fuel_coal", () -> new Item(new Item.Properties().tab(Geomancy.gemsmoditemtab).stacksTo(5)));
    public static final RegistryObject<Item> PLATE_FUEL_TIME = ITEMS.register("plate_fuel_time", () -> new Item(new Item.Properties().tab(Geomancy.gemsmoditemtab).stacksTo(5)));
    public static final RegistryObject<Item> PLATE_SPEED_OVERDRIVE = ITEMS.register("plate_speed_overdrive", () -> new Item(new Item.Properties().tab(Geomancy.gemsmoditemtab).stacksTo(5)));
    public static final RegistryObject<Item> PLATE_SPEED_UP = ITEMS.register("plate_speed_up", () -> new Item(new Item.Properties().tab(Geomancy.gemsmoditemtab).stacksTo(5)));
    public static final RegistryObject<Item> PLATE_YIELD_ORE = ITEMS.register("plate_yield_ore", () -> new Item(new Item.Properties().tab(Geomancy.gemsmoditemtab).stacksTo(5)));

    public static final RegistryObject<Item> PLATE_DING = ITEMS.register("plate_ding", () -> new Item(new Item.Properties().tab(Geomancy.gemsmoditemtab).stacksTo(5)));

    public static final RegistryObject<Item> DIGGING_CLAW_WOOD = ITEMS.register("digging_claw_wood", () -> new DiggingClawItem(1, -2.8F, Tiers.WOOD, GeomancyTags.Blocks.claw, new Item.Properties().tab(Geomancy.gemsmoditemtab)));
    public static final RegistryObject<Item> DIGGING_CLAW_STONE = ITEMS.register("digging_claw_stone", () -> new DiggingClawItem(1, -2.8F, Tiers.STONE, GeomancyTags.Blocks.claw, new Item.Properties().tab(Geomancy.gemsmoditemtab)));
    public static final RegistryObject<Item> DIGGING_CLAW_IRON = ITEMS.register("digging_claw_iron", () -> new DiggingClawItem(0, 0, Tiers.IRON, GeomancyTags.Blocks.claw, new Item.Properties().tab(Geomancy.gemsmoditemtab)));
    public static final RegistryObject<Item> DIGGING_CLAW_GOLD = ITEMS.register("digging_claw_gold", () -> new DiggingClawItem(1, -2.8F, Tiers.GOLD, GeomancyTags.Blocks.claw, new Item.Properties().tab(Geomancy.gemsmoditemtab)));
    public static final RegistryObject<Item> DIGGING_CLAW_DIAMOND = ITEMS.register("digging_claw_diamond", () -> new DiggingClawItem(1, -2.8F, Tiers.DIAMOND, GeomancyTags.Blocks.claw, new Item.Properties().tab(Geomancy.gemsmoditemtab)));
    public static final RegistryObject<Item> DIGGING_CLAW_NETHERITE = ITEMS.register("digging_claw_netherite", () -> new DiggingClawItem(1, -2.8F, Tiers.NETHERITE, GeomancyTags.Blocks.claw, new Item.Properties().tab(Geomancy.gemsmoditemtab)));

    public static final RegistryObject<Item> HEALING_WATER_BUCKET = ITEMS.register("healing_water_bucket",
            () -> new BucketItem(FluidInit.SOURCE_HEALING_WATER,
                    new Item.Properties().tab(Geomancy.gemsmoditemtab).craftRemainder(Items.BUCKET).stacksTo(1)));

    public static final RegistryObject<Item> CUPID_ARROW = ITEMS.register( "cupid_arrow",
            () -> new CupidArrowItem(new Item.Properties().tab(Geomancy.gemsmoditemtab)));





    /*
     * Block Items Only Below this point
     */


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
