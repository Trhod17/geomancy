package net.codersdownunder.gemmod.server.recipes;

import java.util.function.Consumer;

import net.codersdownunder.gemmod.init.ItemInit;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.UpgradeRecipeBuilder;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import org.jetbrains.annotations.NotNull;

public class GeomancyUpgradeRecipeProvider extends RecipeProvider {


	public GeomancyUpgradeRecipeProvider(PackOutput p_248933_) {
		super(p_248933_);
	}

	@Override
	@NotNull
	public String getName() {
		return "Geomancy Upgrade Recipe Provider";
	}

	@Override
	protected void buildRecipes(final Consumer<FinishedRecipe> consumer) {
		
		UpgradeRecipeBuilder.smithing(Ingredient.of(ItemInit.DIGGING_CLAW_DIAMOND.get()), Ingredient.of(Items.NETHERITE_INGOT), RecipeCategory.TOOLS, ItemInit.DIGGING_CLAW_NETHERITE.get()).unlocks("netherite", InventoryChangeTrigger.TriggerInstance.hasItems(Items.NETHERITE_INGOT, ItemInit.DIGGING_CLAW_NETHERITE.get())).save(consumer, "netherite_digging_claw");
		
	}

}