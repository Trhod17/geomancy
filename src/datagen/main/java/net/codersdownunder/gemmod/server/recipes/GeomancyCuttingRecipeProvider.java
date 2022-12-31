package net.codersdownunder.gemmod.server.recipes;

import java.util.function.Consumer;

import net.codersdownunder.gemmod.server.recipes.builders.SingleItemRecipeBuilderCustom;
import net.codersdownunder.gemmod.init.BlockItemInit;
import net.codersdownunder.gemmod.utils.GeomancyTags;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import org.jetbrains.annotations.NotNull;

public class GeomancyCuttingRecipeProvider extends RecipeProvider {
	public GeomancyCuttingRecipeProvider(final PackOutput output) {
		super(output);

	}

	@Override
	@NotNull
	public String getName() {
		return "Geomancy Stone Cutting Recipe Provider";
	}

	@Override
	protected void buildRecipes(final Consumer<FinishedRecipe> consumer) {

		registerTreadstoneRecipeSets(consumer, GeomancyTags.Items.TREADSTONES, 0, BlockItemInit.TREADSTONE_1.get(),
				BlockItemInit.TREADSTONE_2.get(),
				BlockItemInit.TREADSTONE_3.get(),
				BlockItemInit.TREADSTONE_4.get(),
				BlockItemInit.TREADSTONE_5.get(),
				BlockItemInit.TREADSTONE_6.get(),
				BlockItemInit.TREADSTONE_7.get());

		registerTreadstoneRecipeSets(consumer, GeomancyTags.Items.TREADSTONES, 0, BlockItemInit.TREADSTONE_SLAB_1.get(),
				BlockItemInit.TREADSTONE_SLAB_2.get(),
				BlockItemInit.TREADSTONE_SLAB_3.get(),
				BlockItemInit.TREADSTONE_SLAB_4.get(),
				BlockItemInit.TREADSTONE_SLAB_5.get(),
				BlockItemInit.TREADSTONE_SLAB_6.get(),
				BlockItemInit.TREADSTONE_SLAB_7.get());

		registerTreadstoneRecipeSets(consumer, GeomancyTags.Items.TREADSTONES, 0, BlockItemInit.TREADSTONE_CARPET_1.get(),
				BlockItemInit.TREADSTONE_CARPET_2.get(),
				BlockItemInit.TREADSTONE_CARPET_3.get(),
				BlockItemInit.TREADSTONE_CARPET_4.get(),
				BlockItemInit.TREADSTONE_CARPET_5.get(),
				BlockItemInit.TREADSTONE_CARPET_6.get(),
				BlockItemInit.TREADSTONE_CARPET_7.get());

		registerTreadstoneRecipeSets(consumer, GeomancyTags.Items.TREADSTONES, 0, BlockItemInit.TREADSTONE_STAIR_1.get(),
				BlockItemInit.TREADSTONE_STAIR_2.get(),
				BlockItemInit.TREADSTONE_STAIR_3.get(),
				BlockItemInit.TREADSTONE_STAIR_4.get(),
				BlockItemInit.TREADSTONE_STAIR_5.get(),
				BlockItemInit.TREADSTONE_STAIR_6.get(),
				BlockItemInit.TREADSTONE_STAIR_7.get());

//		SingleItemRecipeBuilderCustom.stonecutting(Ingredient.of(GeomancyTags.Items.TREADSTONES), BlockItemInit.TREADSTONE_1.get()).save(consumer);
//		SingleItemRecipeBuilderCustom.stonecutting(Ingredient.of(GeomancyTags.Items.TREADSTONES), BlockItemInit.TREADSTONE_2.get()).save(consumer);
//		SingleItemRecipeBuilderCustom.stonecutting(Ingredient.of(GeomancyTags.Items.TREADSTONES), BlockItemInit.TREADSTONE_3.get()).save(consumer);
//		SingleItemRecipeBuilderCustom.stonecutting(Ingredient.of(GeomancyTags.Items.TREADSTONES), BlockItemInit.TREADSTONE_4.get()).save(consumer);
//		SingleItemRecipeBuilderCustom.stonecutting(Ingredient.of(GeomancyTags.Items.TREADSTONES), BlockItemInit.TREADSTONE_5.get()).save(consumer);
//		SingleItemRecipeBuilderCustom.stonecutting(Ingredient.of(GeomancyTags.Items.TREADSTONES), BlockItemInit.TREADSTONE_6.get()).save(consumer);
//		SingleItemRecipeBuilderCustom.stonecutting(Ingredient.of(GeomancyTags.Items.TREADSTONES), BlockItemInit.TREADSTONE_7.get()).save(consumer);
//
//		SingleItemRecipeBuilderCustom.stonecutting(Ingredient.of(GeomancyTags.Items.TREADSTONES), BlockItemInit.TREADSTONE_STAIR_1.get()).save(consumer);
//		SingleItemRecipeBuilderCustom.stonecutting(Ingredient.of(GeomancyTags.Items.TREADSTONES), BlockItemInit.TREADSTONE_STAIR_2.get()).save(consumer);
//		SingleItemRecipeBuilderCustom.stonecutting(Ingredient.of(GeomancyTags.Items.TREADSTONES), BlockItemInit.TREADSTONE_STAIR_3.get()).save(consumer);
//		SingleItemRecipeBuilderCustom.stonecutting(Ingredient.of(GeomancyTags.Items.TREADSTONES), BlockItemInit.TREADSTONE_STAIR_4.get()).save(consumer);
//		SingleItemRecipeBuilderCustom.stonecutting(Ingredient.of(GeomancyTags.Items.TREADSTONES), BlockItemInit.TREADSTONE_STAIR_5.get()).save(consumer);
//		SingleItemRecipeBuilderCustom.stonecutting(Ingredient.of(GeomancyTags.Items.TREADSTONES), BlockItemInit.TREADSTONE_STAIR_6.get()).save(consumer);
//		SingleItemRecipeBuilderCustom.stonecutting(Ingredient.of(GeomancyTags.Items.TREADSTONES), BlockItemInit.TREADSTONE_STAIR_7.get()).save(consumer);
//
//		SingleItemRecipeBuilderCustom.stonecutting(Ingredient.of(GeomancyTags.Items.TREADSTONES), BlockItemInit.TREADSTONE_SLAB_1.get(), 2).save(consumer);
//		SingleItemRecipeBuilderCustom.stonecutting(Ingredient.of(GeomancyTags.Items.TREADSTONES), BlockItemInit.TREADSTONE_SLAB_2.get(), 2).save(consumer);
//		SingleItemRecipeBuilderCustom.stonecutting(Ingredient.of(GeomancyTags.Items.TREADSTONES), BlockItemInit.TREADSTONE_SLAB_3.get(), 2).save(consumer);
//		SingleItemRecipeBuilderCustom.stonecutting(Ingredient.of(GeomancyTags.Items.TREADSTONES), BlockItemInit.TREADSTONE_SLAB_4.get(), 2).save(consumer);
//		SingleItemRecipeBuilderCustom.stonecutting(Ingredient.of(GeomancyTags.Items.TREADSTONES), BlockItemInit.TREADSTONE_SLAB_5.get(), 2).save(consumer);
//		SingleItemRecipeBuilderCustom.stonecutting(Ingredient.of(GeomancyTags.Items.TREADSTONES), BlockItemInit.TREADSTONE_SLAB_6.get(), 2).save(consumer);
//		SingleItemRecipeBuilderCustom.stonecutting(Ingredient.of(GeomancyTags.Items.TREADSTONES), BlockItemInit.TREADSTONE_SLAB_7.get(), 2).save(consumer);
//
//		SingleItemRecipeBuilderCustom.stonecutting(Ingredient.of(BlockItemInit.TREADSTONE_1.get()), BlockItemInit.TREADSTONE_CARPET_1.get(), 3).save(consumer);
//		SingleItemRecipeBuilderCustom.stonecutting(Ingredient.of(BlockItemInit.TREADSTONE_2.get()), BlockItemInit.TREADSTONE_CARPET_2.get(), 3).save(consumer);
//		SingleItemRecipeBuilderCustom.stonecutting(Ingredient.of(BlockItemInit.TREADSTONE_3.get()), BlockItemInit.TREADSTONE_CARPET_3.get(), 3).save(consumer);
//		SingleItemRecipeBuilderCustom.stonecutting(Ingredient.of(BlockItemInit.TREADSTONE_4.get()), BlockItemInit.TREADSTONE_CARPET_4.get(), 3).save(consumer);
//		SingleItemRecipeBuilderCustom.stonecutting(Ingredient.of(BlockItemInit.TREADSTONE_5.get()), BlockItemInit.TREADSTONE_CARPET_5.get(), 3).save(consumer);
//		SingleItemRecipeBuilderCustom.stonecutting(Ingredient.of(BlockItemInit.TREADSTONE_6.get()), BlockItemInit.TREADSTONE_CARPET_6.get(), 3).save(consumer);
//		SingleItemRecipeBuilderCustom.stonecutting(Ingredient.of(BlockItemInit.TREADSTONE_7.get()), BlockItemInit.TREADSTONE_CARPET_7.get(), 3).save(consumer);
	}


	public void registerTreadstoneRecipeSets(final Consumer<FinishedRecipe> consumer, TagKey<Item> tag, int count, ItemLike... output) {
		if (count <= 1) {
			for (ItemLike item : output)  {
				SingleItemRecipeBuilderCustom.stonecutting(Ingredient.of(tag), item).save(consumer);
			}
		} else {
			for (ItemLike item : output)  {
				SingleItemRecipeBuilderCustom.stonecutting(Ingredient.of(tag), item, count).save(consumer);
			}
		}
	}


}