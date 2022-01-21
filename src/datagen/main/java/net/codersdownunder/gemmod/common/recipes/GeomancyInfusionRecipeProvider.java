package net.codersdownunder.gemmod.common.recipes;

import java.util.function.Consumer;

import net.codersdownunder.gemmod.GemMod;
import net.codersdownunder.gemmod.common.recipes.builders.InfusionRecipeBuilder;
import net.codersdownunder.gemmod.init.ItemInit;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.item.Items;

public class GeomancyInfusionRecipeProvider extends RecipeProvider {
	
	public GeomancyInfusionRecipeProvider(DataGenerator generatorIn) {
        super(generatorIn);
    }

	@Override
	protected void buildCraftingRecipes(Consumer<FinishedRecipe> consumer) {
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
		
		InfusionRecipeBuilder.infusing(Items.BELL)
		.requires(Items.AMETHYST_SHARD)
		.requires(Items.AMETHYST_SHARD)
		.requires(Items.AMETHYST_SHARD)
		.requires(Items.AMETHYST_SHARD)
		// Item below is the item to be infused
		.requires(Items.GOLD_INGOT)
		.group(GemMod.MODID)
		.save(consumer);
		
		InfusionRecipeBuilder.infusing(Items.ENCHANTED_GOLDEN_APPLE)
		.requires(ItemInit.JASPER_DREAMING.get())
		.requires(ItemInit.SAPPHIRE_DREAMING.get())
		.requires(ItemInit.AMETHYST_DREAMING.get())
		.requires(ItemInit.SPINEL_DREAMING.get())
		.requires(ItemInit.SPINEL_DREAMING.get())
		.requires(ItemInit.SPHENE_DREAMING.get())
		// Item below is the item to be infused
		.requires(Items.GOLDEN_APPLE)
		.group(GemMod.MODID)
		.save(consumer);
		
		InfusionRecipeBuilder.infusing(ItemInit.CONCENTRATION.get())
		.requires(Items.PHANTOM_MEMBRANE)
		.requires(ItemInit.DREAM_DUST.get())
		// Item below is the item to be infused
		.requires(ItemInit.NETHER_CRUX.get())
		.group(GemMod.MODID)
		.save(consumer);
		
		//Add more below
	}
	
}