package net.codersdownunder.gemmod.init;

import net.codersdownunder.gemmod.GemMod;
import net.codersdownunder.gemmod.items.DreamingGemItem;
import net.codersdownunder.gemmod.items.GemItem;
import net.codersdownunder.gemmod.items.MulmusItem;
import net.minecraft.world.food.Foods;
import net.minecraft.world.item.Item;
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
}