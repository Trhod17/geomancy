package net.codersdownunder.gemmod.server.recipes;

import java.util.ArrayList;
import java.util.function.Consumer;

import net.codersdownunder.gemmod.DataUtils;
import net.codersdownunder.gemmod.Geomancy;
import net.codersdownunder.gemmod.server.recipes.builders.SingleItemRecipeBuilderCustom;
import net.codersdownunder.gemmod.init.BlockItemInit;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;

public class GeomancyCuttingRecipeProvider extends RecipeProvider {
	
	public GeomancyCuttingRecipeProvider(DataGenerator generatorIn) {
        super(generatorIn);
    }

	@Override
	public String getName() {
		return "Geomancy Stone Cutting Recipe Provider";
	}

	@Override
	protected void buildCraftingRecipes(Consumer<FinishedRecipe> consumer) {

		SingleItemRecipeBuilderCustom.stonecutting(Ingredient.of(BlockItemInit.TREADSTONE_1.get()), BlockItemInit.TREADSTONE_1.get()).save(consumer);
		SingleItemRecipeBuilderCustom.stonecutting(Ingredient.of(BlockItemInit.TREADSTONE_1.get()), BlockItemInit.TREADSTONE_2.get()).save(consumer);
		SingleItemRecipeBuilderCustom.stonecutting(Ingredient.of(BlockItemInit.TREADSTONE_1.get()), BlockItemInit.TREADSTONE_3.get()).save(consumer);
		SingleItemRecipeBuilderCustom.stonecutting(Ingredient.of(BlockItemInit.TREADSTONE_1.get()), BlockItemInit.TREADSTONE_4.get()).save(consumer);
		SingleItemRecipeBuilderCustom.stonecutting(Ingredient.of(BlockItemInit.TREADSTONE_1.get()), BlockItemInit.TREADSTONE_5.get()).save(consumer);
		SingleItemRecipeBuilderCustom.stonecutting(Ingredient.of(BlockItemInit.TREADSTONE_1.get()), BlockItemInit.TREADSTONE_6.get()).save(consumer);
		SingleItemRecipeBuilderCustom.stonecutting(Ingredient.of(BlockItemInit.TREADSTONE_1.get()), BlockItemInit.TREADSTONE_7.get()).save(consumer);

		SingleItemRecipeBuilderCustom.stonecutting(Ingredient.of(BlockItemInit.TREADSTONE_1.get()), BlockItemInit.TREADSTONE_STAIR_1.get()).save(consumer);
		SingleItemRecipeBuilderCustom.stonecutting(Ingredient.of(BlockItemInit.TREADSTONE_2.get()), BlockItemInit.TREADSTONE_STAIR_2.get()).save(consumer);
		SingleItemRecipeBuilderCustom.stonecutting(Ingredient.of(BlockItemInit.TREADSTONE_3.get()), BlockItemInit.TREADSTONE_STAIR_3.get()).save(consumer);
		SingleItemRecipeBuilderCustom.stonecutting(Ingredient.of(BlockItemInit.TREADSTONE_4.get()), BlockItemInit.TREADSTONE_STAIR_4.get()).save(consumer);
		SingleItemRecipeBuilderCustom.stonecutting(Ingredient.of(BlockItemInit.TREADSTONE_5.get()), BlockItemInit.TREADSTONE_STAIR_5.get()).save(consumer);
		SingleItemRecipeBuilderCustom.stonecutting(Ingredient.of(BlockItemInit.TREADSTONE_6.get()), BlockItemInit.TREADSTONE_STAIR_6.get()).save(consumer);
		SingleItemRecipeBuilderCustom.stonecutting(Ingredient.of(BlockItemInit.TREADSTONE_7.get()), BlockItemInit.TREADSTONE_STAIR_7.get()).save(consumer);
		
		SingleItemRecipeBuilderCustom.stonecutting(Ingredient.of(BlockItemInit.TREADSTONE_1.get()), BlockItemInit.TREADSTONE_SLAB_1.get(), 2).save(consumer);
		SingleItemRecipeBuilderCustom.stonecutting(Ingredient.of(BlockItemInit.TREADSTONE_2.get()), BlockItemInit.TREADSTONE_SLAB_2.get(), 2).save(consumer);
		SingleItemRecipeBuilderCustom.stonecutting(Ingredient.of(BlockItemInit.TREADSTONE_3.get()), BlockItemInit.TREADSTONE_SLAB_3.get(), 2).save(consumer);
		SingleItemRecipeBuilderCustom.stonecutting(Ingredient.of(BlockItemInit.TREADSTONE_4.get()), BlockItemInit.TREADSTONE_SLAB_4.get(), 2).save(consumer);
		SingleItemRecipeBuilderCustom.stonecutting(Ingredient.of(BlockItemInit.TREADSTONE_5.get()), BlockItemInit.TREADSTONE_SLAB_5.get(), 2).save(consumer);
		SingleItemRecipeBuilderCustom.stonecutting(Ingredient.of(BlockItemInit.TREADSTONE_6.get()), BlockItemInit.TREADSTONE_SLAB_6.get(), 2).save(consumer);
		SingleItemRecipeBuilderCustom.stonecutting(Ingredient.of(BlockItemInit.TREADSTONE_7.get()), BlockItemInit.TREADSTONE_SLAB_7.get(), 2).save(consumer);
		
		SingleItemRecipeBuilderCustom.stonecutting(Ingredient.of(BlockItemInit.TREADSTONE_1.get()), BlockItemInit.TREADSTONE_CARPET_1.get(), 3).save(consumer);
		SingleItemRecipeBuilderCustom.stonecutting(Ingredient.of(BlockItemInit.TREADSTONE_2.get()), BlockItemInit.TREADSTONE_CARPET_2.get(), 3).save(consumer);
		SingleItemRecipeBuilderCustom.stonecutting(Ingredient.of(BlockItemInit.TREADSTONE_3.get()), BlockItemInit.TREADSTONE_CARPET_3.get(), 3).save(consumer);
		SingleItemRecipeBuilderCustom.stonecutting(Ingredient.of(BlockItemInit.TREADSTONE_4.get()), BlockItemInit.TREADSTONE_CARPET_4.get(), 3).save(consumer);
		SingleItemRecipeBuilderCustom.stonecutting(Ingredient.of(BlockItemInit.TREADSTONE_5.get()), BlockItemInit.TREADSTONE_CARPET_5.get(), 3).save(consumer);
		SingleItemRecipeBuilderCustom.stonecutting(Ingredient.of(BlockItemInit.TREADSTONE_6.get()), BlockItemInit.TREADSTONE_CARPET_6.get(), 3).save(consumer);
		SingleItemRecipeBuilderCustom.stonecutting(Ingredient.of(BlockItemInit.TREADSTONE_7.get()), BlockItemInit.TREADSTONE_CARPET_7.get(), 3).save(consumer);
	}


}