package net.codersdownunder.gemmod.common.recipes;

import java.util.function.Consumer;

import net.codersdownunder.gemmod.GemMod;
import net.codersdownunder.gemmod.init.BlockInit;
import net.codersdownunder.gemmod.init.ItemInit;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;

public class GeomancyRecipeProvider extends RecipeProvider {
	
	public GeomancyRecipeProvider(DataGenerator generatorIn) {
        super(generatorIn);
    }

	@Override
	protected void buildCraftingRecipes(Consumer<FinishedRecipe> consumer) {
		ShapelessRecipeBuilder.shapeless(BlockInit.CHASM_PLANKS.get(), 4)
		.requires(BlockInit.CHASM_LOG.get())
		.group(GemMod.MODID)
		.unlockedBy("chasm_log", InventoryChangeTrigger.TriggerInstance.hasItems(BlockInit.CHASM_LOG.get()))
		.save(consumer);
		
		ShapedRecipeBuilder.shaped(BlockInit.CHASM_STAIRS.get(), 8)
		.pattern("x  ")
		.pattern("xx ")
		.pattern("xxx")
		.define('x', BlockInit.CHASM_PLANKS.get())
		.group(GemMod.MODID)
		.unlockedBy("chasm_planks", InventoryChangeTrigger.TriggerInstance.hasItems(BlockInit.CHASM_PLANKS.get()))
		.save(consumer);
		
		ShapedRecipeBuilder.shaped(BlockInit.CHASM_SLAB.get(), 6)
		.pattern("xxx")
		.define('x', BlockInit.CHASM_PLANKS.get())
		.group(GemMod.MODID)
		.unlockedBy("chasm_planks", InventoryChangeTrigger.TriggerInstance.hasItems(BlockInit.CHASM_PLANKS.get()))
		.save(consumer);
		
		ShapelessRecipeBuilder.shapeless(BlockInit.CHASM_BUTTON.get(), 2)
		.requires(BlockInit.CHASM_PLANKS.get())
		.group(GemMod.MODID)
		.unlockedBy("chasm_planks", InventoryChangeTrigger.TriggerInstance.hasItems(BlockInit.CHASM_PLANKS.get()))
		.save(consumer);
		
		ShapedRecipeBuilder.shaped(BlockInit.CHASM_PLATE.get(), 2)
		.pattern("xx")
		.define('x', BlockInit.CHASM_PLANKS.get())
		.group(GemMod.MODID)
		.unlockedBy("chasm_planks", InventoryChangeTrigger.TriggerInstance.hasItems(BlockInit.CHASM_PLANKS.get()))
		.save(consumer);
		
		ShapedRecipeBuilder.shaped(BlockInit.CHASM_DOOR.get(), 3)
		.pattern("xx ")
		.pattern("xx ")
		.pattern("xx ")
		.define('x', BlockInit.CHASM_PLANKS.get())
		.group(GemMod.MODID)
		.unlockedBy("chasm_planks", InventoryChangeTrigger.TriggerInstance.hasItems(BlockInit.CHASM_PLANKS.get()))
		.save(consumer);
		
		ShapedRecipeBuilder.shaped(BlockInit.CHASM_FENCE.get(), 3)
		.pattern("xsx")
		.pattern("xsx")
		.define('x', BlockInit.CHASM_PLANKS.get())
		.define('s', Items.STICK)
		.group(GemMod.MODID)
		.unlockedBy("chasm_planks", InventoryChangeTrigger.TriggerInstance.hasItems(BlockInit.CHASM_PLANKS.get()))
		.save(consumer);
		
		ShapedRecipeBuilder.shaped(BlockInit.CHASM_FENCE_GATE.get(), 1)
		.pattern("sxs")
		.pattern("sxs")
		.define('x', BlockInit.CHASM_PLANKS.get())
		.define('s', Items.STICK)
		.group(GemMod.MODID)
		.unlockedBy("chasm_planks", InventoryChangeTrigger.TriggerInstance.hasItems(BlockInit.CHASM_PLANKS.get()))
		.save(consumer);
		
		ShapedRecipeBuilder.shaped(BlockInit.CHASM_TRAPDOOR.get(), 3)
		.pattern("xxx")
		.pattern("xxx")
		.define('x', BlockInit.CHASM_PLANKS.get())
		.group(GemMod.MODID)
		.unlockedBy("chasm_planks", InventoryChangeTrigger.TriggerInstance.hasItems(BlockInit.CHASM_PLANKS.get()))
		.save(consumer);
		
		ShapedRecipeBuilder.shaped(Items.NETHERITE_INGOT, 1)
		.pattern("xxx")
		.pattern("xxx")
		.pattern("xxx")
		.define('x', ItemInit.NETHERRITE_NUGGET.get())
		.group(GemMod.MODID)
		.unlockedBy("netherite_nugget", InventoryChangeTrigger.TriggerInstance.hasItems(ItemInit.NETHERRITE_NUGGET.get()))
		.save(consumer);

		ShapedRecipeBuilder.shaped(BlockInit.CHASM_LOG_BARK.get(), 3)
		.pattern("xx ")
		.pattern("xx ")
		.define('x', BlockInit.CHASM_LOG.get())
		.group(GemMod.MODID)
		.unlockedBy("chasm_log", InventoryChangeTrigger.TriggerInstance.hasItems(BlockInit.CHASM_LOG.get()))
		.save(consumer);
		
		ShapedRecipeBuilder.shaped(BlockInit.CHASM_LOG_STRIPPED_BARK.get(), 3)
		.pattern("xx ")
		.pattern("xx ")
		.define('x', BlockInit.CHASM_LOG_STRIPPED.get())
		.group(GemMod.MODID)
		.unlockedBy("chasm_log_stripped", InventoryChangeTrigger.TriggerInstance.hasItems(BlockInit.CHASM_LOG_STRIPPED.get()))
		.save(consumer);
		
		ShapedRecipeBuilder.shaped(BlockInit.CHASM_SIGN.get(), 3)
		.pattern("xxx")
		.pattern("xxx")
		.pattern(" s ")
		.define('x', BlockInit.CHASM_PLANKS.get())
		.define('s', Items.STICK)
		.group(GemMod.MODID)
		.unlockedBy("chasm_planks", InventoryChangeTrigger.TriggerInstance.hasItems(BlockInit.CHASM_PLANKS.get()))
		.save(consumer);
		
		ShapedRecipeBuilder.shaped(ItemInit.CONCOCTION_ONE.get(), 1)
		.pattern(" x ")
		.pattern("asd")
		.pattern(" f ")
		.define('x', Items.BONE_MEAL)
		.define('a', Items.GUNPOWDER)
		.define('s', Items.GLASS_BOTTLE)
		.define('d', Items.FERMENTED_SPIDER_EYE)
		.define('f', Items.MILK_BUCKET)
		.group(GemMod.MODID)
		.unlockedBy("concoction1", InventoryChangeTrigger.TriggerInstance.hasItems(Items.BONE_MEAL, Items.GUNPOWDER, Items.GLASS_BOTTLE, Items.FERMENTED_SPIDER_EYE, Items.MILK_BUCKET))
		.save(consumer);
		
		ShapedRecipeBuilder.shaped(ItemInit.CONCOCTION_TWO.get(), 1)
		.pattern(" x ")
		.pattern("asd")
		.pattern(" f ")
		.define('x', Items.PHANTOM_MEMBRANE)
		.define('a', Items.LAPIS_LAZULI)
		.define('s', Items.GLASS_BOTTLE)
		.define('d', Items.INK_SAC)
		.define('f', Items.SLIME_BALL)
		.group(GemMod.MODID)
		.unlockedBy("concoction2", InventoryChangeTrigger.TriggerInstance.hasItems(Items.PHANTOM_MEMBRANE, Items.LAPIS_LAZULI, Items.INK_SAC, Items.SLIME_BALL))
		.save(consumer);
		
		ShapedRecipeBuilder.shaped(ItemInit.CONCOCTION_THREE.get(), 1)
		.pattern(" x ")
		.pattern("asd")
		.pattern(" f ")
		.define('x', Items.HONEYCOMB)
		.define('a', Items.GLOWSTONE_DUST)
		.define('s', Items.HONEY_BOTTLE)
		.define('d', Items.BLAZE_POWDER)
		.define('f', Items.NETHER_WART)
		.group(GemMod.MODID)
		.unlockedBy("concoction3", InventoryChangeTrigger.TriggerInstance.hasItems(Items.HONEYCOMB, Items.GLOWSTONE_DUST, Items.HONEY_BOTTLE, Items.BLAZE_POWDER, Items.NETHER_WART))
		.save(consumer);
		
		ShapedRecipeBuilder.shaped(ItemInit.CONCOCTION_FOUR.get(), 1)
		.pattern(" x ")
		.pattern("asd")
		.pattern(" f ")
		.define('x', Items.REDSTONE)
		.define('a', Items.POPPED_CHORUS_FRUIT)
		.define('s', Items.DRAGON_BREATH)
		.define('d', Items.ENDER_EYE)
		.define('f', Items.GHAST_TEAR)
		.group(GemMod.MODID)
		.unlockedBy("concoction4", InventoryChangeTrigger.TriggerInstance.hasItems(Items.REDSTONE, Items.CHORUS_FLOWER, Items.DRAGON_BREATH, Items.ENDER_EYE, Items.GHAST_TEAR))
		.save(consumer);
		
		ShapedRecipeBuilder.shaped(ItemInit.CATCHER_RING.get(), 1)
		.pattern("xsx")
		.pattern("sts")
		.pattern("xsx")
		.define('x', ItemTags.WOOL)
		.define('s', Items.STICK)
		.define('t', Items.STRING)
		.group(GemMod.MODID)
		.unlockedBy("catcherring", InventoryChangeTrigger.TriggerInstance.hasItems(Items.WHITE_WOOL, Items.STRING, Items.STICK))
		.save(consumer);
		
		ShapedRecipeBuilder.shaped(BlockInit.DREAM_CATCHER.get(), 1)
		.pattern(" h ")
		.pattern("srs")
		.pattern("frf")
		.define('h', Items.TRIPWIRE_HOOK)
		.define('s', Items.STRING)
		.define('f', Items.FEATHER)
		.define('r', ItemInit.CATCHER_RING.get())
		.group(GemMod.MODID)
		.unlockedBy("dreamcatcher", InventoryChangeTrigger.TriggerInstance.hasItems(Items.FEATHER, Items.STRING, Items.TRIPWIRE_HOOK, ItemInit.CATCHER_RING.get()))
		.save(consumer);
		
		ShapedRecipeBuilder.shaped(Items.BELL, 1)
		.pattern("lll")
		.pattern("gag")
		.pattern("gng")
		.define('l', Items.OAK_LOG)
		.define('g', Items.GOLD_INGOT)
		.define('a', Items.AMETHYST_BLOCK)
		.define('n', Items.GOLD_NUGGET)
		.group(GemMod.MODID)
		.unlockedBy("bell", InventoryChangeTrigger.TriggerInstance.hasItems(Items.OAK_LOG, Items.GOLD_INGOT, Items.AMETHYST_BLOCK, Items.GOLD_NUGGET))
		.save(consumer);
		
		ShapedRecipeBuilder.shaped(BlockInit.DIPPER.get(), 1)
		.pattern("pip")
		.pattern("lgl")
		.pattern("sss")
		.define('p', Items.OAK_PLANKS)
		.define('i', Items.IRON_INGOT)
		.define('l', Items.OAK_LOG)
		.define('g', Items.GLASS)
		.define('s', Items.SMOOTH_STONE)
		.group(GemMod.MODID)
		.unlockedBy("dipper", InventoryChangeTrigger.TriggerInstance.hasItems(Items.OAK_PLANKS, Items.IRON_INGOT, Items.OAK_LOG, Items.GLASS, Items.SMOOTH_STONE))
		.save(consumer);
		
		ShapedRecipeBuilder.shaped(BlockInit.INFUSION_TABLE.get(), 1)
		.pattern("epe")
		.pattern("sgs")
		.pattern("ede")
		.define('e', Items.EMERALD)
		.define('p', Items.DARK_OAK_SAPLING)
		.define('s', Items.STRIPPED_DARK_OAK_LOG)
		.define('g', Items.GOLDEN_APPLE)
		.define('d', Items.DARK_OAK_LOG)
		.group(GemMod.MODID)
		.unlockedBy("infusion_table", InventoryChangeTrigger.TriggerInstance.hasItems(Items.EMERALD, Items.DARK_OAK_SAPLING, Items.STRIPPED_DARK_OAK_LOG, Items.GOLDEN_APPLE, Items.DARK_OAK_LOG))
		.save(consumer);
		
		ShapedRecipeBuilder.shaped(BlockInit.TELEPAD.get(), 1)
		.pattern("ggg")
		.pattern("dld")
		.pattern("pap")
		.define('g', Items.GLASS)
		.define('d', Items.DARK_PRISMARINE)
		.define('l', Items.SEA_LANTERN)
		.define('p', Items.ENDER_PEARL)
		.define('a', Items.AMETHYST_SHARD)
		.group(GemMod.MODID)
		.unlockedBy("telepad", InventoryChangeTrigger.TriggerInstance.hasItems(Items.GLASS, Items.DARK_PRISMARINE, Items.SEA_LANTERN, Items.ENDER_PEARL, Items.AMETHYST_SHARD))
		.save(consumer, new ResourceLocation("telepad"));
		
		ShapedRecipeBuilder.shaped(ItemInit.EMPTY_TOTEM.get(), 1)
		.pattern("gbg")
		.pattern("rar")
		.pattern("nbn")
		.define('g', Items.GOLD_INGOT)
		.define('b', Items.GOLD_BLOCK)
		.define('r', Items.BLAZE_ROD)
		.define('a', Items.ENCHANTED_GOLDEN_APPLE)
		.define('n', Items.GOLD_NUGGET)
		.group(GemMod.MODID)
		.unlockedBy("empty_totem", InventoryChangeTrigger.TriggerInstance.hasItems(Items.GOLD_INGOT, Items.GOLD_BLOCK, Items.BLAZE_ROD, Items.ENCHANTED_GOLDEN_APPLE, Items.GOLD_NUGGET))
		.save(consumer);
		
		ShapelessRecipeBuilder.shapeless(ItemInit.NETHER_CRUX.get())
		.requires(ItemInit.NETHERRITE_NUGGET.get())
		.requires(Items.END_CRYSTAL)
		.requires(Items.EMERALD)
		.group(GemMod.MODID)
		.unlockedBy("nethercrux", InventoryChangeTrigger.TriggerInstance.hasItems(ItemInit.NETHERRITE_NUGGET.get(),Items.END_CRYSTAL,Items.EMERALD))
		.save(consumer, new ResourceLocation("nethercrux"));
		
		ShapedRecipeBuilder.shaped(Items.PHANTOM_MEMBRANE, 1)
		.pattern(" g ")
		.pattern("sbs")
		.pattern(" e ")
		.define('g', Items.GLOW_INK_SAC)
		.define('s', Items.SLIME_BALL)
		.define('b', Items.WHITE_DYE)
		.define('e', Items.EGG)
		.group(GemMod.MODID)
		.unlockedBy("dipper", InventoryChangeTrigger.TriggerInstance.hasItems(Items.GLOW_INK_SAC, Items.SLIME_BALL, Items.WHITE_DYE, Items.EGG))
		.save(consumer);
		
		ShapedRecipeBuilder.shaped(ItemInit.SONG_FORGE.get())
		.pattern("sps")
		.pattern("scs")
		.pattern("bgb")
		.define('s', Items.AMETHYST_SHARD)
		.define('p', Items.ENDER_PEARL)
		.define('c', Items.OXIDIZED_COPPER)
		.define('b', Items.AMETHYST_BLOCK)
		.define('g', Items.GLOW_INK_SAC)
		.group(GemMod.MODID)
		.unlockedBy("song_forge", InventoryChangeTrigger.TriggerInstance.hasItems(Items.GLOW_INK_SAC, Items.AMETHYST_SHARD, Items.ENDER_PEARL, Items.OXIDIZED_COPPER, Items.AMETHYST_BLOCK, Items.GLOW_INK_SAC))
		.save(consumer);
		
		ShapelessRecipeBuilder.shapeless(ItemInit.NETHER_CRUX.get(), 8)
		.requires(ItemInit.NETHERRITE_NUGGET.get())
		.requires(ItemInit.NETHERRITE_NUGGET.get())
		.requires(Items.NETHER_STAR)
		.requires(Items.END_CRYSTAL)
		.requires(Items.EMERALD)
		.group(GemMod.MODID)
		.unlockedBy("nethercrux", InventoryChangeTrigger.TriggerInstance.hasItems(ItemInit.NETHERRITE_NUGGET.get(),Items.END_CRYSTAL,Items.EMERALD,Items.NETHER_STAR))
		.save(consumer, new ResourceLocation("nethercruxstar"));
		
		ShapelessRecipeBuilder.shapeless(BlockInit.TELEPAD_SLAB.get())
		.requires(BlockInit.TELEPAD.get())
		.group(GemMod.MODID)
		.unlockedBy("telepad", InventoryChangeTrigger.TriggerInstance.hasItems(BlockInit.TELEPAD.get()))
		.save(consumer);
		
		ShapelessRecipeBuilder.shapeless(BlockInit.TELEPAD.get())
		.requires(BlockInit.TELEPAD_SLAB.get())
		.group(GemMod.MODID)
		.unlockedBy("telepad_slab", InventoryChangeTrigger.TriggerInstance.hasItems(BlockInit.TELEPAD_SLAB.get()))
		.save(consumer, new ResourceLocation("telepad_recraft"));
		
		ShapelessRecipeBuilder.shapeless(ItemInit.NETHERRITE_NUGGET.get(), 9)
		.requires(Items.NETHERITE_INGOT)
		.group(GemMod.MODID)
		.unlockedBy("netherite", InventoryChangeTrigger.TriggerInstance.hasItems(Items.NETHERITE_INGOT))
		.save(consumer);
		
	}

	
//	private void InfusionStandRecipes(Consumer<FinishedRecipe> consumer) {
//		
//		
//		//BrewingRecipeBuilder.Brewing(IngredientNBTWrapper.fromItemStack(PotionUtils.setPotion(new ItemStack(Items.POTION), Potions.FIRE_RESISTANCE)));
//	}
	
}
