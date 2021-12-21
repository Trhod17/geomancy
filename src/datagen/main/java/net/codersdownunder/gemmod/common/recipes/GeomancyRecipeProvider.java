package net.codersdownunder.gemmod.common.recipes;

import java.util.function.Consumer;

import net.codersdownunder.gemmod.GemMod;
import net.codersdownunder.gemmod.init.BlockInit;
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
	}
}
