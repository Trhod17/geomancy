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
		.requires(ItemInit.CITRINE.get())
		.requires(ItemInit.CITRINE.get())
		.requires(ItemInit.SPHENE.get())
		.requires(ItemInit.SPHENE.get())
		.requires(ItemInit.GARNET.get())
		.requires(ItemInit.GARNET.get())
		// Item below is the item to be infused
		.requires(Items.QUARTZ_BLOCK)
		.group(GemMod.MODID)
		.save(consumer);
		
		InfusionRecipeBuilder.infusing(ItemInit.PLATE_FUEL_COAL.get())
		.requires(ItemInit.JASPER.get())
		.requires(ItemInit.JASPER.get())
		.requires(ItemInit.JASPER.get())
		.requires(ItemInit.RUBY.get())
		.requires(ItemInit.RUBY.get())
		.requires(ItemInit.RUBY.get())
		// Item below is the item to be infused
		.requires(Items.QUARTZ_BLOCK)
		.group(GemMod.MODID)
		.save(consumer);
		
		InfusionRecipeBuilder.infusing(ItemInit.PLATE_SPEED_UP.get())
		.requires(ItemInit.TOPAZ.get())
		.requires(ItemInit.TOPAZ.get())
		.requires(ItemInit.TOPAZ.get())
		.requires(ItemInit.CITRINE.get())
		.requires(ItemInit.CITRINE.get())
		.requires(ItemInit.JASPER.get())
		// Item below is the item to be infused
		.requires(Items.QUARTZ_BLOCK)
		.group(GemMod.MODID)
		.save(consumer);
		
		InfusionRecipeBuilder.infusing(ItemInit.PLATE_SPEED_OVERDRIVE.get())
		.requires(ItemInit.TOPAZ.get())
		.requires(ItemInit.TOPAZ.get())
		.requires(ItemInit.TOPAZ.get())
		.requires(ItemInit.MALACHITE.get())
		.requires(ItemInit.MALACHITE.get())
		.requires(ItemInit.MALACHITE.get())
		// Item below is the item to be infused
		.requires(Items.QUARTZ_BLOCK)
		.group(GemMod.MODID)
		.save(consumer);
		
		InfusionRecipeBuilder.infusing(ItemInit.PLATE_YIELD_ORE.get())
		.requires(ItemInit.RHODONITE.get())
		.requires(ItemInit.RHODONITE.get())
		.requires(ItemInit.CHRYSOCOLLA.get())
		.requires(ItemInit.CHRYSOCOLLA.get())
		.requires(ItemInit.ONYX.get())
		.requires(ItemInit.ONYX.get())
		// Item below is the item to be infused
		.requires(Items.QUARTZ_BLOCK)
		.group(GemMod.MODID)
		.save(consumer);
		
		InfusionRecipeBuilder.infusing(ItemInit.PLATE_FAILSAFE.get())
		.requires(ItemInit.PERIDOT.get())
		.requires(ItemInit.PERIDOT.get())
		.requires(ItemInit.PERIDOT.get())
		.requires(ItemInit.PERIDOT.get())
		.requires(ItemInit.LILYSTAR.get())
		.requires(ItemInit.AMETHYST.get())
		// Item below is the item to be infused
		.requires(Items.QUARTZ_BLOCK)
		.group(GemMod.MODID)
		.save(consumer);
		
		//Add more below
	}
	
}