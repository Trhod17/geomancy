package net.codersdownunder.gemmod.server.recipes;

import java.util.function.Consumer;

import net.codersdownunder.gemmod.Geomancy;
import net.codersdownunder.gemmod.server.recipes.builders.InfusionRecipeBuilder;
import net.codersdownunder.gemmod.init.ItemInit;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;

public class GeomancyInfusionRecipeProvider extends RecipeProvider {
	
	public GeomancyInfusionRecipeProvider(DataGenerator generatorIn) {
        super(generatorIn);
    }

	@Override
	protected void buildCraftingRecipes(Consumer<FinishedRecipe> consumer) {
//		InfusionRecipeBuilder.infusing(ItemInit.CHAROITE_DREAMING.get(), ItemInit.CHAROITE.get())
//		.requires(Items.STICK)
//		.requires(Items.STICK)
//		.requires(Items.STICK)
//		.requires(Items.STICK)
//		.requires(Items.STICK)
//		.requires(ItemInit.AGATE.get())
//		// Item below is the item to be infused
//		.requires(ItemInit.CHAROITE.get())
//		.group(GemMod.MODID)
//		.save(consumer);
		
		InfusionRecipeBuilder.infusing(Items.BELL, Items.GOLD_INGOT)
		.requires(Items.AMETHYST_SHARD, 4)
		.group(Geomancy.MODID)
		.save(consumer, new ResourceLocation(Geomancy.MODID, "infusing_bell"));
		
		InfusionRecipeBuilder.infusing(Items.ENCHANTED_GOLDEN_APPLE, Items.GOLDEN_APPLE)
		.requires(ItemInit.JASPER_DREAMING.get())
		.requires(ItemInit.SPHENE_DREAMING.get())
		.requires(ItemInit.SPINEL_DREAMING.get(), 2)
		.requires(ItemInit.SAPPHIRE_DREAMING.get())
		.requires(ItemInit.AMETHYST_DREAMING.get())
		.group(Geomancy.MODID)
		.save(consumer, new ResourceLocation(Geomancy.MODID, "infusing_enchanted_apple"));
		
		InfusionRecipeBuilder.infusing(ItemInit.CONCENTRATION.get(), ItemInit.NETHER_CRUX.get())
		.requires(Items.PHANTOM_MEMBRANE)
		.requires(ItemInit.DREAM_DUST.get())
		.group(Geomancy.MODID)
		.save(consumer);
	
		InfusionRecipeBuilder.infusing(ItemInit.PLATE_FUEL_TIME.get(), ItemInit.PLATE_FUEL_TIME.get())
		.requires(ItemInit.RHODONITE_DREAMING.get())
		.requires(ItemInit.CITRINE_DREAMING.get())
		.requires(ItemInit.SPHENE.get())
		.requires(ItemInit.SPHENE.get())
		.requires(ItemInit.GARNET.get())
		.requires(ItemInit.GARNET.get())
		.group(Geomancy.MODID)
		.save(consumer);
		
		InfusionRecipeBuilder.infusing(ItemInit.PLATE_FUEL_COAL.get(), ItemInit.PLATE_FUEL_COAL.get())
		.requires(ItemInit.JASPER_DREAMING.get())
		.requires(ItemInit.RUBY.get())
		.requires(ItemInit.RUBY.get())
		.group(Geomancy.MODID)
		.save(consumer);
		
		InfusionRecipeBuilder.infusing(ItemInit.PLATE_SPEED_UP.get(), ItemInit.PLATE_SPEED_UP.get())
		.requires(ItemInit.TOPAZ_DREAMING.get())
		.requires(ItemInit.RUBY_DREAMING.get())
		.group(Geomancy.MODID)
		.save(consumer);
		
		InfusionRecipeBuilder.infusing(ItemInit.PLATE_SPEED_OVERDRIVE.get(), ItemInit.PLATE_SPEED_OVERDRIVE.get())
		.requires(ItemInit.TOPAZ.get())
		.requires(ItemInit.TOPAZ.get())
		.requires(ItemInit.TOPAZ_DREAMING.get())
		.requires(ItemInit.MALACHITE.get())
		.requires(ItemInit.MALACHITE.get())
		.requires(ItemInit.MALACHITE_DREAMING.get())
		.group(Geomancy.MODID)
		.save(consumer);
		
		InfusionRecipeBuilder.infusing(ItemInit.PLATE_YIELD_ORE.get(), ItemInit.PLATE_YIELD_ORE.get())
		.requires(ItemInit.RHODONITE.get())
		.requires(ItemInit.ONYX_DREAMING.get())
		.requires(ItemInit.CHRYSOCOLLA.get())
		.requires(ItemInit.CHRYSOCOLLA.get())
		.requires(ItemInit.ONYX.get())
		.requires(ItemInit.ONYX.get())
		.group(Geomancy.MODID)
		.save(consumer);
		
		InfusionRecipeBuilder.infusing(ItemInit.PLATE_FAILSAFE.get(), ItemInit.PLATE_FAILSAFE.get())
		.requires(ItemInit.PERIDOT_DREAMING.get())
		.requires(ItemInit.PERIDOT.get())
		.requires(ItemInit.PERIDOT.get())
		.requires(ItemInit.PERIDOT.get())
		.requires(ItemInit.LILYSTAR.get())
		.requires(ItemInit.AMETHYST.get())
		.group(Geomancy.MODID)
		.save(consumer);
		
		InfusionRecipeBuilder.infusing(Items.BUDDING_AMETHYST, Items.AMETHYST_BLOCK)
		.requires(ItemInit.AMETHYST.get())
		.requires(ItemInit.JADE.get())
		.requires(ItemInit.CITRINE.get())
		.requires(ItemInit.RHODONITE.get())
		.group(Geomancy.MODID)
		.save(consumer);
		
		//Add more below
	}
	
}