package net.codersdownunder.gemmod.server.recipes;

import java.util.function.Consumer;

import net.codersdownunder.gemmod.init.ItemInit;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.UpgradeRecipeBuilder;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;

public class GeomancyUpgradeRecipeProvider extends RecipeProvider {
	
	public GeomancyUpgradeRecipeProvider(DataGenerator generatorIn) {
        super(generatorIn);
    }

	@Override
	protected void buildCraftingRecipes(Consumer<FinishedRecipe> consumer) {
		
		UpgradeRecipeBuilder.smithing(Ingredient.of(ItemInit.DIGGING_CLAW_DIAMOND.get()), Ingredient.of(Items.NETHERITE_INGOT), ItemInit.DIGGING_CLAW_NETHERITE.get()).unlocks("netherite", InventoryChangeTrigger.TriggerInstance.hasItems(Items.NETHERITE_INGOT, ItemInit.DIGGING_CLAW_NETHERITE.get())).save(consumer, "netherite_digging_claw");
		
	}

}