package net.codersdownunder.gemmod.common.recipes;

import java.util.function.Consumer;

import net.codersdownunder.gemmod.init.ItemInit;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.item.crafting.Ingredient;

public class GeomancyCuttingRecipeProvider extends RecipeProvider {
	
	public GeomancyCuttingRecipeProvider(DataGenerator generatorIn) {
        super(generatorIn);
    }

	@Override
	protected void buildCraftingRecipes(Consumer<FinishedRecipe> consumer) {
		
		SingleItemRecipeBuilderCustom.stonecutting(Ingredient.of(ItemInit.TREADSTONE_1.get()), ItemInit.TREADSTONE_2.get()).save(consumer);
		SingleItemRecipeBuilderCustom.stonecutting(Ingredient.of(ItemInit.TREADSTONE_1.get()), ItemInit.TREADSTONE_3.get()).save(consumer);
		SingleItemRecipeBuilderCustom.stonecutting(Ingredient.of(ItemInit.TREADSTONE_1.get()), ItemInit.TREADSTONE_4.get()).save(consumer);
		SingleItemRecipeBuilderCustom.stonecutting(Ingredient.of(ItemInit.TREADSTONE_1.get()), ItemInit.TREADSTONE_5.get()).save(consumer);
		SingleItemRecipeBuilderCustom.stonecutting(Ingredient.of(ItemInit.TREADSTONE_1.get()), ItemInit.TREADSTONE_6.get()).save(consumer);
		SingleItemRecipeBuilderCustom.stonecutting(Ingredient.of(ItemInit.TREADSTONE_1.get()), ItemInit.TREADSTONE_7.get()).save(consumer);
		
		SingleItemRecipeBuilderCustom.stonecutting(Ingredient.of(ItemInit.TREADSTONE_1.get()), ItemInit.TREADSTONE_STAIR_1.get()).save(consumer);
		SingleItemRecipeBuilderCustom.stonecutting(Ingredient.of(ItemInit.TREADSTONE_1.get()), ItemInit.TREADSTONE_STAIR_2.get()).save(consumer);
		SingleItemRecipeBuilderCustom.stonecutting(Ingredient.of(ItemInit.TREADSTONE_1.get()), ItemInit.TREADSTONE_STAIR_3.get()).save(consumer);
		SingleItemRecipeBuilderCustom.stonecutting(Ingredient.of(ItemInit.TREADSTONE_1.get()), ItemInit.TREADSTONE_STAIR_4.get()).save(consumer);
		SingleItemRecipeBuilderCustom.stonecutting(Ingredient.of(ItemInit.TREADSTONE_1.get()), ItemInit.TREADSTONE_STAIR_5.get()).save(consumer);
		SingleItemRecipeBuilderCustom.stonecutting(Ingredient.of(ItemInit.TREADSTONE_1.get()), ItemInit.TREADSTONE_STAIR_6.get()).save(consumer);
		SingleItemRecipeBuilderCustom.stonecutting(Ingredient.of(ItemInit.TREADSTONE_1.get()), ItemInit.TREADSTONE_STAIR_7.get()).save(consumer);
		
		SingleItemRecipeBuilderCustom.stonecutting(Ingredient.of(ItemInit.TREADSTONE_1.get()), ItemInit.TREADSTONE_SLAB_1.get()).save(consumer);
		SingleItemRecipeBuilderCustom.stonecutting(Ingredient.of(ItemInit.TREADSTONE_1.get()), ItemInit.TREADSTONE_SLAB_2.get()).save(consumer);
		SingleItemRecipeBuilderCustom.stonecutting(Ingredient.of(ItemInit.TREADSTONE_1.get()), ItemInit.TREADSTONE_SLAB_3.get()).save(consumer);
		SingleItemRecipeBuilderCustom.stonecutting(Ingredient.of(ItemInit.TREADSTONE_1.get()), ItemInit.TREADSTONE_SLAB_4.get()).save(consumer);
		SingleItemRecipeBuilderCustom.stonecutting(Ingredient.of(ItemInit.TREADSTONE_1.get()), ItemInit.TREADSTONE_SLAB_5.get()).save(consumer);
		SingleItemRecipeBuilderCustom.stonecutting(Ingredient.of(ItemInit.TREADSTONE_1.get()), ItemInit.TREADSTONE_SLAB_6.get()).save(consumer);
		SingleItemRecipeBuilderCustom.stonecutting(Ingredient.of(ItemInit.TREADSTONE_1.get()), ItemInit.TREADSTONE_SLAB_7.get()).save(consumer);
		
		SingleItemRecipeBuilderCustom.stonecutting(Ingredient.of(ItemInit.TREADSTONE_1.get()), ItemInit.TREADSTONE_CARPET_1.get()).save(consumer);
		SingleItemRecipeBuilderCustom.stonecutting(Ingredient.of(ItemInit.TREADSTONE_1.get()), ItemInit.TREADSTONE_CARPET_2.get()).save(consumer);
		SingleItemRecipeBuilderCustom.stonecutting(Ingredient.of(ItemInit.TREADSTONE_1.get()), ItemInit.TREADSTONE_CARPET_3.get()).save(consumer);
		SingleItemRecipeBuilderCustom.stonecutting(Ingredient.of(ItemInit.TREADSTONE_1.get()), ItemInit.TREADSTONE_CARPET_4.get()).save(consumer);
		SingleItemRecipeBuilderCustom.stonecutting(Ingredient.of(ItemInit.TREADSTONE_1.get()), ItemInit.TREADSTONE_CARPET_5.get()).save(consumer);
		SingleItemRecipeBuilderCustom.stonecutting(Ingredient.of(ItemInit.TREADSTONE_1.get()), ItemInit.TREADSTONE_CARPET_6.get()).save(consumer);
		SingleItemRecipeBuilderCustom.stonecutting(Ingredient.of(ItemInit.TREADSTONE_1.get()), ItemInit.TREADSTONE_CARPET_7.get()).save(consumer);
	}

}