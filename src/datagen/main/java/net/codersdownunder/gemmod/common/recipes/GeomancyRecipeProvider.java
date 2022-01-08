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
		.define('s', Items.GLASS_BOTTLE
				)
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
		
		ShapelessRecipeBuilder.shapeless(BlockInit.TELEPAD_SLAB.get())
		.requires(BlockInit.TELEPAD.get())
		.group(GemMod.MODID)
		.unlockedBy("telepad", InventoryChangeTrigger.TriggerInstance.hasItems(BlockInit.TELEPAD.get()))
		.save(consumer);
		
		ShapelessRecipeBuilder.shapeless(BlockInit.TELEPAD.get())
		.requires(BlockInit.TELEPAD_SLAB.get())
		.group(GemMod.MODID)
		.unlockedBy("telepad_slab", InventoryChangeTrigger.TriggerInstance.hasItems(BlockInit.TELEPAD_SLAB.get()))
		.save(consumer);
		
		ShapelessRecipeBuilder.shapeless(ItemInit.NETHERRITE_NUGGET.get(), 9)
		.requires(Items.NETHERITE_INGOT)
		.group(GemMod.MODID)
		.unlockedBy("netherite", InventoryChangeTrigger.TriggerInstance.hasItems(Items.NETHERITE_INGOT))
		.save(consumer);
		
		InfusionRecipes(consumer);
		DippingRecipes(consumer);
	}
	
	private void InfusionRecipes(Consumer<FinishedRecipe> consumer) {
		InfusionRecipeBuilder.infusing(ItemInit.CHAROITE_DREAMING.get())
		.requires(Items.STICK)
		.requires(Items.STICK)
		.requires(Items.STICK)
		.requires(Items.STICK)
		.requires(Items.STICK)
		.requires(ItemInit.AGATE.get())
		// Item below is the item to be infused
		.requires(ItemInit.CHAROITE.get())
		.group(GemMod.MODID)
		.save(consumer);
		
		//Add more below

	}
	
	private void DippingRecipes(Consumer<FinishedRecipe> consumer) {
		DippingRecipeBuilder.dipping(ItemInit.CITRINE_DREAMING.get(), 1000)
		.requires(Items.STICK)
		.requires(ItemInit.AMETHYST.get())
		.requires(Items.APPLE)
		.requires(Items.CARROT)
		.requires(Items.DIAMOND)
		.requires(ItemInit.AGATE.get())
		.requires(Items.CAKE)
		.requires(ItemInit.TOPAZ.get())
		.requires(Items.OAK_LOG)
		.requires(Items.REDSTONE)
		.requires(Items.IRON_INGOT)
		.requires(Items.BUCKET)
		.requires(ItemInit.CHAROITE.get())
		.requires(Items.POTATO)
		.requires(Items.EMERALD)
		.group(GemMod.MODID)
		.save(consumer);
		
		// Add more below
		
	}
}
