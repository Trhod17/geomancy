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
		
		InfusionRecipeBuilder.infusing(ItemInit.PLATE_FUEL_TIME.get())
		.requires(ItemInit.RHODONITE_DREAMING.get())
		.requires(ItemInit.CITRINE_DREAMING.get())
		.requires(ItemInit.SPHENE.get())
		.requires(ItemInit.SPHENE.get())
		.requires(ItemInit.GARNET.get())
		.requires(ItemInit.GARNET.get())
		// Item below is the item to be infused
		.requires(ItemInit.PLATE_FUEL_TIME.get())
		.group(GemMod.MODID)
		.save(consumer);
		
		InfusionRecipeBuilder.infusing(ItemInit.PLATE_FUEL_COAL.get())
		.requires(ItemInit.JASPER_DREAMING.get())
		.requires(ItemInit.RUBY.get())
		.requires(ItemInit.RUBY.get())
		// Item below is the item to be infused
		.requires(ItemInit.PLATE_FUEL_COAL.get())
		.group(GemMod.MODID)
		.save(consumer);
		
		InfusionRecipeBuilder.infusing(ItemInit.PLATE_SPEED_UP.get())
		.requires(ItemInit.TOPAZ_DREAMING.get())
		.requires(ItemInit.RUBY_DREAMING.get())
		// Item below is the item to be infused
		.requires(ItemInit.PLATE_SPEED_UP.get())
		.group(GemMod.MODID)
		.save(consumer);
		
		InfusionRecipeBuilder.infusing(ItemInit.PLATE_SPEED_OVERDRIVE.get())
		.requires(ItemInit.TOPAZ.get())
		.requires(ItemInit.TOPAZ.get())
		.requires(ItemInit.TOPAZ_DREAMING.get())
		.requires(ItemInit.MALACHITE.get())
		.requires(ItemInit.MALACHITE.get())
		.requires(ItemInit.MALACHITE_DREAMING.get())
		// Item below is the item to be infused
		.requires(ItemInit.PLATE_SPEED_OVERDRIVE.get())
		.group(GemMod.MODID)
		.save(consumer);
		
		InfusionRecipeBuilder.infusing(ItemInit.PLATE_YIELD_ORE.get())
		.requires(ItemInit.RHODONITE.get())
		.requires(ItemInit.ONYX_DREAMING.get())
		.requires(ItemInit.CHRYSOCOLLA.get())
		.requires(ItemInit.CHRYSOCOLLA.get())
		.requires(ItemInit.ONYX.get())
		.requires(ItemInit.ONYX.get())
		// Item below is the item to be infused
		.requires(ItemInit.PLATE_YIELD_ORE.get())
		.group(GemMod.MODID)
		.save(consumer);
		
		InfusionRecipeBuilder.infusing(ItemInit.PLATE_FAILSAFE.get())
		.requires(ItemInit.PERIDOT_DREAMING.get())
		.requires(ItemInit.PERIDOT.get())
		.requires(ItemInit.PERIDOT.get())
		.requires(ItemInit.PERIDOT.get())
		.requires(ItemInit.LILYSTAR.get())
		.requires(ItemInit.AMETHYST.get())
		// Item below is the item to be infused
		.requires(ItemInit.PLATE_FAILSAFE.get())
		.group(GemMod.MODID)
		.save(consumer);
		
		InfusionRecipeBuilder.infusing(Items.BUDDING_AMETHYST)
		.requires(ItemInit.AMETHYST.get())
		.requires(ItemInit.JADE.get())
		.requires(ItemInit.CITRINE.get())
		.requires(ItemInit.RHODONITE.get())
		// Item below is the item to be infused
		.requires(Items.AMETHYST_BLOCK)
		.group(GemMod.MODID)
		.save(consumer);
		
		//Add more below
	}
	
}