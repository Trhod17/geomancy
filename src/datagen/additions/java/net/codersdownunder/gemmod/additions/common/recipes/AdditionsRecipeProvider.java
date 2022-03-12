package net.codersdownunder.gemmod.additions.common.recipes;

import java.util.function.Consumer;

import net.codersdownunder.gemmod.additions.Additions;
import net.codersdownunder.gemmod.additions.init.BlockInit;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.SingleItemRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Blocks;

public class AdditionsRecipeProvider extends RecipeProvider {

	public AdditionsRecipeProvider(DataGenerator generatorIn) {
        super(generatorIn);
    }

	@Override
	protected void buildCraftingRecipes(Consumer<FinishedRecipe> consumer) {
		
		ShapedRecipeBuilder.shaped(BlockInit.PURPUR_WALL.get(), 6)
		.pattern("xxx")
		.pattern("xxx")
		.define('x', Blocks.PURPUR_BLOCK)
		.group(Additions.MODID)
		.unlockedBy("purpur", InventoryChangeTrigger.TriggerInstance.hasItems(Blocks.PURPUR_BLOCK))
		.save(consumer, new ResourceLocation(Additions.MODID, "purpur_wall"));

		ShapedRecipeBuilder.shaped(BlockInit.PURPUR_PILLAR_WALL.get(), 6)
		.pattern("xxx")
		.pattern("xxx")
		.define('x', Blocks.PURPUR_PILLAR)
		.group(Additions.MODID)
		.unlockedBy("purpur_pillar", InventoryChangeTrigger.TriggerInstance.hasItems(Blocks.PURPUR_PILLAR))
		.save(consumer, new ResourceLocation(Additions.MODID, "purpur_pillar_wall"));
		
		ShapedRecipeBuilder.shaped(BlockInit.PRISMARINE_BRICKS_WALL.get(), 6)
		.pattern("xxx")
		.pattern("xxx")
		.define('x', Blocks.PRISMARINE_BRICKS)
		.group(Additions.MODID)
		.unlockedBy("prismarine_bricks", InventoryChangeTrigger.TriggerInstance.hasItems(Blocks.PRISMARINE_BRICKS))
		.save(consumer, new ResourceLocation(Additions.MODID, "prismarine_bricks_wall"));
		
		ShapedRecipeBuilder.shaped(BlockInit.DARK_PRISMARINE_WALL.get(), 6)
		.pattern("xxx")
		.pattern("xxx")
		.define('x', Blocks.DARK_PRISMARINE)
		.group(Additions.MODID)
		.unlockedBy("prismarine_dark", InventoryChangeTrigger.TriggerInstance.hasItems(Blocks.DARK_PRISMARINE))
		.save(consumer, new ResourceLocation(Additions.MODID, "dark_prismarine_wall"));
		
		SingleItemRecipeBuilder.stonecutting(Ingredient.of(Blocks.DARK_PRISMARINE), BlockInit.DARK_PRISMARINE_WALL.get(), 1).group(Additions.MODID)
		.unlockedBy("prismarine_dark", InventoryChangeTrigger.TriggerInstance.hasItems(Blocks.DARK_PRISMARINE))
		.save(consumer, new ResourceLocation(Additions.MODID, "dark_prismarine_wall_stonecutter"));
		SingleItemRecipeBuilder.stonecutting(Ingredient.of(Blocks.PRISMARINE_BRICKS), BlockInit.PRISMARINE_BRICKS_WALL.get(), 1).group(Additions.MODID)
		.unlockedBy("prismarine_bricks", InventoryChangeTrigger.TriggerInstance.hasItems(Blocks.PRISMARINE_BRICKS))
		.save(consumer, new ResourceLocation(Additions.MODID, "prismarine_bricks_wall_stonecutter"));
		SingleItemRecipeBuilder.stonecutting(Ingredient.of(Blocks.PURPUR_PILLAR), BlockInit.PURPUR_PILLAR_WALL.get(), 1).group(Additions.MODID)
		.unlockedBy("purpur_pillar", InventoryChangeTrigger.TriggerInstance.hasItems(Blocks.PURPUR_PILLAR))
		.save(consumer, new ResourceLocation(Additions.MODID, "purpur_pillar_wall_stonecutter"));
		SingleItemRecipeBuilder.stonecutting(Ingredient.of(Blocks.PURPUR_BLOCK), BlockInit.PURPUR_WALL.get(), 1).group(Additions.MODID)
		.unlockedBy("purpur_block", InventoryChangeTrigger.TriggerInstance.hasItems(Blocks.PURPUR_BLOCK))
		.save(consumer, new ResourceLocation(Additions.MODID, "purpur_block_wall_stonecutter"));
		
	}
}
