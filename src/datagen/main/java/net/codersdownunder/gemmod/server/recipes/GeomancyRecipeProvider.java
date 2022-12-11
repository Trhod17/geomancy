package net.codersdownunder.gemmod.server.recipes;

import java.util.function.Consumer;

import net.codersdownunder.gemmod.DataUtils;
import net.codersdownunder.gemmod.Geomancy;
import net.codersdownunder.gemmod.init.BlockInit;
import net.codersdownunder.gemmod.init.BlockItemInit;
import net.codersdownunder.gemmod.init.ItemInit;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

public class GeomancyRecipeProvider extends RecipeProvider implements IConditionBuilder {
	public GeomancyRecipeProvider(PackOutput p_248933_) {
		super(p_248933_);
	}

//	@Override
//	public String getName() {
//		return "Geomancy Recipe Provider";
//	}

	@Override
	protected void buildRecipes(Consumer<FinishedRecipe> consumer) {
		ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, BlockInit.CHASM_PLANKS.get(), 4)
				.requires(BlockInit.CHASM_LOG.get())
				.group(Geomancy.MODID)
				.unlockedBy("chasm_log", InventoryChangeTrigger.TriggerInstance.hasItems(BlockInit.CHASM_LOG.get()))
				.save(consumer);

		ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, BlockInit.CHASM_STAIRS.get(), 8)
				.pattern("x  ")
				.pattern("xx ")
				.pattern("xxx")
				.define('x', BlockInit.CHASM_PLANKS.get())
				.group(Geomancy.MODID)
				.unlockedBy("chasm_planks", InventoryChangeTrigger.TriggerInstance.hasItems(BlockInit.CHASM_PLANKS.get()))
				.save(consumer);

		ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, BlockInit.CHASM_SLAB.get(), 6)
				.pattern("xxx")
				.define('x', BlockInit.CHASM_PLANKS.get())
				.group(Geomancy.MODID)
				.unlockedBy("chasm_planks", InventoryChangeTrigger.TriggerInstance.hasItems(BlockInit.CHASM_PLANKS.get()))
				.save(consumer);

		ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, BlockInit.CHASM_BUTTON.get(), 2)
				.requires(BlockInit.CHASM_PLANKS.get())
				.group(Geomancy.MODID)
				.unlockedBy("chasm_planks", InventoryChangeTrigger.TriggerInstance.hasItems(BlockInit.CHASM_PLANKS.get()))
				.save(consumer);

		ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, BlockInit.CHASM_PLATE.get(), 2)
				.pattern("xx")
				.define('x', BlockInit.CHASM_PLANKS.get())
				.group(Geomancy.MODID)
				.unlockedBy("chasm_planks", InventoryChangeTrigger.TriggerInstance.hasItems(BlockInit.CHASM_PLANKS.get()))
				.save(consumer);

		ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, BlockInit.CHASM_DOOR.get(), 3)
				.pattern("xx ")
				.pattern("xx ")
				.pattern("xx ")
				.define('x', BlockInit.CHASM_PLANKS.get())
				.group(Geomancy.MODID)
				.unlockedBy("chasm_planks", InventoryChangeTrigger.TriggerInstance.hasItems(BlockInit.CHASM_PLANKS.get()))
				.save(consumer);

		ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, BlockInit.CHASM_FENCE.get(), 3)
				.pattern("xsx")
				.pattern("xsx")
				.define('x', BlockInit.CHASM_PLANKS.get())
				.define('s', Items.STICK)
				.group(Geomancy.MODID)
				.unlockedBy("chasm_planks", InventoryChangeTrigger.TriggerInstance.hasItems(BlockInit.CHASM_PLANKS.get()))
				.save(consumer);

		ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, BlockInit.CHASM_FENCE_GATE.get(), 1)
				.pattern("sxs")
				.pattern("sxs")
				.define('x', BlockInit.CHASM_PLANKS.get())
				.define('s', Items.STICK)
				.group(Geomancy.MODID)
				.unlockedBy("chasm_planks", InventoryChangeTrigger.TriggerInstance.hasItems(BlockInit.CHASM_PLANKS.get()))
				.save(consumer);

		ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, BlockInit.CHASM_TRAPDOOR.get(), 3)
				.pattern("xxx")
				.pattern("xxx")
				.define('x', BlockInit.CHASM_PLANKS.get())
				.group(Geomancy.MODID)
				.unlockedBy("chasm_planks", InventoryChangeTrigger.TriggerInstance.hasItems(BlockInit.CHASM_PLANKS.get()))
				.save(consumer);

		ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, BlockInit.CHASM_LOG_BARK.get(), 3)
				.pattern("xx ")
				.pattern("xx ")
				.define('x', BlockInit.CHASM_LOG.get())
				.group(Geomancy.MODID)
				.unlockedBy("chasm_log", InventoryChangeTrigger.TriggerInstance.hasItems(BlockInit.CHASM_LOG.get()))
				.save(consumer);

		ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, BlockInit.CHASM_LOG_STRIPPED_BARK.get(), 3)
				.pattern("xx ")
				.pattern("xx ")
				.define('x', BlockInit.CHASM_LOG_STRIPPED.get())
				.group(Geomancy.MODID)
				.unlockedBy("chasm_log_stripped", InventoryChangeTrigger.TriggerInstance.hasItems(BlockInit.CHASM_LOG_STRIPPED.get()))
				.save(consumer);

		ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, BlockInit.CHASM_SIGN.get(), 3)
				.pattern("xxx")
				.pattern("xxx")
				.pattern(" s ")
				.define('x', BlockInit.CHASM_PLANKS.get())
				.define('s', Items.STICK)
				.group(Geomancy.MODID)
				.unlockedBy("chasm_planks", InventoryChangeTrigger.TriggerInstance.hasItems(BlockInit.CHASM_PLANKS.get()))
				.save(consumer);

		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ItemInit.CATCHER_RING.get(), 1)
				.pattern("xsx")
				.pattern("sts")
				.pattern("xsx")
				.define('x', ItemTags.WOOL)
				.define('s', Items.STICK)
				.define('t', Items.STRING)
				.group(Geomancy.MODID)
				.unlockedBy("catcherring", InventoryChangeTrigger.TriggerInstance.hasItems(Items.WHITE_WOOL, Items.STRING, Items.STICK))
				.save(consumer);

		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, BlockInit.DREAM_CATCHER.get(), 1)
				.pattern(" h ")
				.pattern("srs")
				.pattern("frf")
				.define('h', Items.TRIPWIRE_HOOK)
				.define('s', Items.STRING)
				.define('f', Items.FEATHER)
				.define('r', ItemInit.CATCHER_RING.get())
				.group(Geomancy.MODID)
				.unlockedBy("dreamcatcher", InventoryChangeTrigger.TriggerInstance.hasItems(Items.FEATHER, Items.STRING, Items.TRIPWIRE_HOOK, ItemInit.CATCHER_RING.get()))
				.save(consumer);

		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.BELL, 1)
				.pattern("lll")
				.pattern("gag")
				.pattern("gng")
				.define('l', Items.OAK_LOG)
				.define('g', Items.GOLD_INGOT)
				.define('a', Items.AMETHYST_BLOCK)
				.define('n', Items.GOLD_NUGGET)
				.group(Geomancy.MODID)
				.unlockedBy("bell", InventoryChangeTrigger.TriggerInstance.hasItems(Items.OAK_LOG, Items.GOLD_INGOT, Items.AMETHYST_BLOCK, Items.GOLD_NUGGET))
				.save(consumer);

		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, BlockInit.DIPPER.get(), 1)
				.pattern("pip")
				.pattern("lgl")
				.pattern("sss")
				.define('p', Items.OAK_PLANKS)
				.define('i', Items.IRON_INGOT)
				.define('l', Items.OAK_LOG)
				.define('g', Items.GLASS)
				.define('s', Items.SMOOTH_STONE)
				.group(Geomancy.MODID)
				.unlockedBy("dipper", InventoryChangeTrigger.TriggerInstance.hasItems(Items.OAK_PLANKS, Items.IRON_INGOT, Items.OAK_LOG, Items.GLASS, Items.SMOOTH_STONE))
				.save(consumer);

		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, BlockInit.INFUSION_TABLE.get(), 1)
				.pattern("epe")
				.pattern("sgs")
				.pattern("ede")
				.define('e', Items.EMERALD)
				.define('p', Items.DARK_OAK_SAPLING)
				.define('s', Items.STRIPPED_DARK_OAK_LOG)
				.define('g', Items.GOLDEN_APPLE)
				.define('d', Items.DARK_OAK_LOG)
				.group(Geomancy.MODID)
				.unlockedBy("infusion_table", InventoryChangeTrigger.TriggerInstance.hasItems(Items.EMERALD, Items.DARK_OAK_SAPLING, Items.STRIPPED_DARK_OAK_LOG, Items.GOLDEN_APPLE, Items.DARK_OAK_LOG))
				.save(consumer);

		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, BlockInit.TELEPAD.get(), 1)
				.pattern("ggg")
				.pattern("dld")
				.pattern("pap")
				.define('g', Items.GLASS)
				.define('d', Items.DARK_PRISMARINE)
				.define('l', Items.SEA_LANTERN)
				.define('p', Items.ENDER_PEARL)
				.define('a', Items.AMETHYST_SHARD)
				.group(Geomancy.MODID)
				.unlockedBy("telepad", InventoryChangeTrigger.TriggerInstance.hasItems(Items.GLASS, Items.DARK_PRISMARINE, Items.SEA_LANTERN, Items.ENDER_PEARL, Items.AMETHYST_SHARD))
				.save(consumer, new ResourceLocation("telepad"));

		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ItemInit.EMPTY_TOTEM.get(), 1)
				.pattern("gbg")
				.pattern("rar")
				.pattern("nbn")
				.define('g', Items.GOLD_INGOT)
				.define('b', Items.GOLD_BLOCK)
				.define('r', Items.BLAZE_ROD)
				.define('a', Items.ENCHANTED_GOLDEN_APPLE)
				.define('n', Items.GOLD_NUGGET)
				.group(Geomancy.MODID)
				.unlockedBy("empty_totem", InventoryChangeTrigger.TriggerInstance.hasItems(Items.GOLD_INGOT, Items.GOLD_BLOCK, Items.BLAZE_ROD, Items.ENCHANTED_GOLDEN_APPLE, Items.GOLD_NUGGET))
				.save(consumer);

		ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ItemInit.NETHER_CRUX.get())
				.requires(ItemInit.NETHERRITE_NUGGET.get())
				.requires(Items.END_CRYSTAL)
				.requires(Items.EMERALD)
				.group(Geomancy.MODID)
				.unlockedBy("nethercrux", InventoryChangeTrigger.TriggerInstance.hasItems(ItemInit.NETHERRITE_NUGGET.get(), Items.END_CRYSTAL, Items.EMERALD))
				.save(consumer, new ResourceLocation("nethercrux"));

		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.PHANTOM_MEMBRANE, 1)
				.pattern(" g ")
				.pattern("sbs")
				.pattern(" e ")
				.define('g', Items.GLOW_INK_SAC)
				.define('s', Items.SLIME_BALL)
				.define('b', Items.WHITE_DYE)
				.define('e', Items.EGG)
				.group(Geomancy.MODID)
				.unlockedBy("dipper", InventoryChangeTrigger.TriggerInstance.hasItems(Items.GLOW_INK_SAC, Items.SLIME_BALL, Items.WHITE_DYE, Items.EGG))
				.save(consumer);

		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, BlockItemInit.SONG_FORGE.get())
				.pattern("sps")
				.pattern("scs")
				.pattern("bgb")
				.define('s', Items.AMETHYST_SHARD)
				.define('p', Items.ENDER_PEARL)
				.define('c', Items.OXIDIZED_COPPER)
				.define('b', Items.AMETHYST_BLOCK)
				.define('g', Items.GLOW_INK_SAC)
				.group(Geomancy.MODID)
				.unlockedBy("song_forge", InventoryChangeTrigger.TriggerInstance.hasItems(Items.GLOW_INK_SAC, Items.AMETHYST_SHARD, Items.ENDER_PEARL, Items.OXIDIZED_COPPER, Items.AMETHYST_BLOCK, Items.GLOW_INK_SAC))
				.save(consumer);

		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ItemInit.PLATE_SPEED_UP.get(), 1)
				.pattern("xfx")
				.pattern("rcr")
				.pattern("xfx")
				.define('x', ItemInit.ROSE_QUARTZ.get())
				.define('f', Items.FLINT)
				.define('r', Items.REDSTONE_BLOCK)
				.define('c', Items.COAL_BLOCK)
				.group(Geomancy.MODID)
				.unlockedBy("plate_speed_up", InventoryChangeTrigger.TriggerInstance.hasItems(Items.FLINT, ItemInit.ROSE_QUARTZ.get(), Items.REDSTONE_BLOCK, Items.COAL_BLOCK))
				.save(consumer);

		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ItemInit.PLATE_FUEL_COAL.get(), 1)
				.pattern("xmx")
				.pattern("cfc")
				.pattern("xmx")
				.define('x', ItemInit.ROSE_QUARTZ.get())
				.define('m', Items.MAGMA_BLOCK)
				.define('f', Items.BLAST_FURNACE)
				.define('c', Items.COAL_BLOCK)
				.group(Geomancy.MODID)
				.unlockedBy("plate_coal", InventoryChangeTrigger.TriggerInstance.hasItems(Items.MAGMA_BLOCK, ItemInit.ROSE_QUARTZ.get(), Items.BLAST_FURNACE, Items.COAL_BLOCK))
				.save(consumer);

		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ItemInit.PLATE_FUEL_TIME.get(), 1)
				.pattern("xox")
				.pattern("aca")
				.pattern("xox")
				.define('x', ItemInit.ROSE_QUARTZ.get())
				.define('a', Items.AMETHYST_BLOCK)
				.define('o', Items.OXIDIZED_COPPER)
				.define('c', Items.CLOCK)
				.group(Geomancy.MODID)
				.unlockedBy("plate_time", InventoryChangeTrigger.TriggerInstance.hasItems(Items.AMETHYST_BLOCK, ItemInit.ROSE_QUARTZ.get(), Items.OXIDIZED_COPPER, Items.CLOCK))
				.save(consumer);

		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ItemInit.PLATE_YIELD_ORE.get(), 1)
				.pattern("xcx")
				.pattern("ogo")
				.pattern("xix")
				.define('x', ItemInit.ROSE_QUARTZ.get())
				.define('o', Items.OBSIDIAN)
				.define('c', Items.RAW_COPPER_BLOCK)
				.define('g', Items.RAW_GOLD_BLOCK)
				.define('i', Items.RAW_IRON_BLOCK)
				.group(Geomancy.MODID)
				.unlockedBy("plate_ore_yield", InventoryChangeTrigger.TriggerInstance.hasItems(ItemInit.ROSE_QUARTZ.get(), Items.OBSIDIAN, Items.RAW_COPPER_BLOCK, Items.RAW_GOLD_BLOCK, Items.RAW_IRON_BLOCK))
				.save(consumer);

		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ItemInit.PLATE_SPEED_OVERDRIVE.get(), 1)
				.pattern("xdx")
				.pattern("rcr")
				.pattern("xdx")
				.define('x', ItemInit.ROSE_QUARTZ.get())
				.define('r', Items.REDSTONE_BLOCK)
				.define('c', ItemInit.CONCENTRATION.get())
				.define('d', Items.DIAMOND)
				.group(Geomancy.MODID)
				.unlockedBy("plate_speed_overdrive", InventoryChangeTrigger.TriggerInstance.hasItems(ItemInit.ROSE_QUARTZ.get(), Items.REDSTONE_BLOCK, ItemInit.CONCENTRATION.get(), Items.DIAMOND))
				.save(consumer);

		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ItemInit.PLATE_FAILSAFE.get(), 1)
				.pattern("xnx")
				.pattern("crc")
				.pattern("xcx")
				.define('x', ItemInit.ROSE_QUARTZ.get())
				.define('n', ItemInit.NETHER_CRUX.get())
				.define('r', Items.RESPAWN_ANCHOR)
				.define('c', Items.HONEYCOMB_BLOCK)
				.group(Geomancy.MODID)
				.unlockedBy("dipper", InventoryChangeTrigger.TriggerInstance.hasItems(ItemInit.ROSE_QUARTZ.get(), Items.RESPAWN_ANCHOR, Items.HONEYCOMB_BLOCK, ItemInit.NETHER_CRUX.get()))
				.save(consumer);

		ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ItemInit.NETHER_CRUX.get(), 8)
				.requires(ItemInit.NETHERRITE_NUGGET.get())
				.requires(ItemInit.NETHERRITE_NUGGET.get())
				.requires(Items.NETHER_STAR)
				.requires(Items.END_CRYSTAL)
				.requires(Items.EMERALD)
				.group(Geomancy.MODID)
				.unlockedBy("nethercrux", InventoryChangeTrigger.TriggerInstance.hasItems(ItemInit.NETHERRITE_NUGGET.get(), Items.END_CRYSTAL, Items.EMERALD, Items.NETHER_STAR))
				.save(consumer, new ResourceLocation("nethercruxstar"));

				concoctionRecipe(consumer,
						ItemInit.CONCOCTION_ONE.get(),
						Items.BONE_MEAL,
						Items.GUNPOWDER,
						Items.GLASS_BOTTLE,
						Items.FERMENTED_SPIDER_EYE,
						Items.MILK_BUCKET);

				concoctionRecipe(consumer,
						ItemInit.CONCOCTION_TWO.get(),
						Items.PHANTOM_MEMBRANE,
						Items.LAPIS_LAZULI,
						Items.GLASS_BOTTLE,
						Items.INK_SAC,
						Items.SLIME_BALL);

				concoctionRecipe(consumer,
						ItemInit.CONCOCTION_THREE.get(),
						Items.HONEYCOMB,
						Items.GLOWSTONE_DUST,
						Items.HONEY_BOTTLE,
						Items.BLAZE_POWDER,
						Items.NETHER_WART);

				concoctionRecipe(consumer,
						ItemInit.CONCOCTION_FOUR.get(),
						Items.REDSTONE,
						Items.POPPED_CHORUS_FRUIT,
						Items.DRAGON_BREATH,
						Items.ENDER_EYE,
						Items.GHAST_TEAR);

				nuggetToIngotRecipe(consumer, Items.NETHERITE_INGOT, ItemInit.NETHERRITE_NUGGET.get());
				ingotToNuggetsRecipe(consumer, ItemInit.NETHERRITE_NUGGET.get(), Items.NETHERITE_INGOT);

				conversionRecipe(consumer, BlockItemInit.TELEPAD.get(), BlockItemInit.TELEPAD_SLAB.get());
				conversionRecipe(consumer, BlockItemInit.TELEPAD_SLAB.get(), BlockItemInit.TELEPAD.get());
	}

	/*
	 * Converts item1 to item2
	 */
	private void conversionRecipe(Consumer<FinishedRecipe> consumer, Item item1, Item item2) {
		ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, item1)
				.requires(item2)
				.group(Geomancy.MODID)
				.unlockedBy(DataUtils.getItemRegistryName(item1), InventoryChangeTrigger.TriggerInstance.hasItems(item2))
				.save(consumer);
	}

	private void ingotToNuggetsRecipe(Consumer<FinishedRecipe> consumer, Item nugget, Item ingot) {
		ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, nugget, 9)
				.requires(ingot)
				.group(Geomancy.MODID)
				.unlockedBy(DataUtils.getItemRegistryName(nugget), InventoryChangeTrigger.TriggerInstance.hasItems(ingot))
				.save(consumer, "geomancy:" + DataUtils.getItemRegistryName(ingot));
	}

	private void nuggetToIngotRecipe(Consumer<FinishedRecipe> consumer, Item ingot, Item nugget) {
		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ingot, 1)
				.pattern("xxx")
				.pattern("xxx")
				.pattern("xxx")
				.define('x', nugget)
				.group(Geomancy.MODID)
				.unlockedBy(DataUtils.getItemRegistryName(ingot), InventoryChangeTrigger.TriggerInstance.hasItems(nugget))
				.save(consumer, "geomancy:" + DataUtils.getItemRegistryName(nugget));
	}

	private void concoctionRecipe(Consumer<FinishedRecipe> consumer, Item concoction, Item item1, Item item2, Item item3, Item item4, Item item5) {
		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, concoction, 1)
				.pattern(" x ")
				.pattern("asd")
				.pattern(" f ")
				.define('x', item1)
				.define('a', item2)
				.define('s', item3)
				.define('d', item4)
				.define('f', item5)
				.group(Geomancy.MODID)
				.unlockedBy(DataUtils.getItemRegistryName(concoction), InventoryChangeTrigger.TriggerInstance.hasItems(Items.REDSTONE, Items.CHORUS_FLOWER, Items.DRAGON_BREATH, Items.ENDER_EYE, Items.GHAST_TEAR))
				.save(consumer);
	}
	
}
