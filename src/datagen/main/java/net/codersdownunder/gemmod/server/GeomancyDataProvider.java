package net.codersdownunder.gemmod.server;

import net.codersdownunder.gemmod.Geomancy;
import net.codersdownunder.gemmod.client.GeomancyBlockStates;
import net.codersdownunder.gemmod.client.GeomancyItemModelProvider;
import net.codersdownunder.gemmod.client.GeomancyLanguageProvider;
import net.codersdownunder.gemmod.server.loottables.GeomancyLootTableProvider;
import net.codersdownunder.gemmod.server.recipes.GeomancyCuttingRecipeProvider;
import net.codersdownunder.gemmod.server.recipes.GeomancyDippingRecipeProvider;
import net.codersdownunder.gemmod.server.recipes.GeomancyInfusionRecipeProvider;
import net.codersdownunder.gemmod.server.recipes.GeomancyRecipeProvider;
import net.codersdownunder.gemmod.server.recipes.GeomancyUpgradeRecipeProvider;
import net.codersdownunder.gemmod.server.tags.GeomancyBlockTags;
import net.codersdownunder.gemmod.server.tags.GeomancyEntityTags;
import net.codersdownunder.gemmod.server.tags.GeomancyFluidTags;
import net.codersdownunder.gemmod.server.tags.GeomancyItemTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

import java.util.concurrent.CompletableFuture;


@EventBusSubscriber(modid = Geomancy.MODID, bus = Bus.MOD)
public class GeomancyDataProvider {

    private GeomancyDataProvider() {
    }

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
		DataGenerator gen = event.getGenerator();
		PackOutput packOutput = gen.getPackOutput();
		CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();
        
        	gen.addProvider(event.includeClient(), new GeomancyLanguageProvider(gen));
        	gen.addProvider(event.includeClient(), new GeomancyBlockStates(gen, event.getExistingFileHelper()));
        	gen.addProvider(event.includeClient(), new GeomancyItemModelProvider(gen, event.getExistingFileHelper()));

         	gen.addProvider(event.includeServer(), new GeomancyRecipeProvider(packOutput));
         	gen.addProvider(event.includeServer(), new GeomancyCuttingRecipeProvider(packOutput));
         	gen.addProvider(event.includeServer(), new GeomancyDippingRecipeProvider(packOutput));
         	gen.addProvider(event.includeServer(), new GeomancyInfusionRecipeProvider(packOutput));
         	gen.addProvider(event.includeServer(), new GeomancyUpgradeRecipeProvider(packOutput));
        	gen.addProvider(event.includeServer(), new GeomancyLootTableProvider(gen));
        	GeomancyBlockTags blockTags = new GeomancyBlockTags(packOutput, lookupProvider, event.getExistingFileHelper());
            gen.addProvider(event.includeServer(), blockTags);
            gen.addProvider(event.includeServer(), new GeomancyItemTags(packOutput, lookupProvider, blockTags, event.getExistingFileHelper()));
            gen.addProvider(event.includeServer(), new GeomancyFluidTags(packOutput, lookupProvider, event.getExistingFileHelper()));
			gen.addProvider(event.includeServer(), new GeomancyEntityTags(packOutput, lookupProvider, event.getExistingFileHelper()));
			//gen.addProvider(event.includeServer(), new GeomancyBiomeModifierProvider(gen, event.getExistingFileHelper()));


    }

}
