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
import net.codersdownunder.gemmod.server.world.GeomancyBiomeModifierProvider;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;


@EventBusSubscriber(modid = Geomancy.MODID, bus = Bus.MOD)
public class GeomancyDataProvider {

    private GeomancyDataProvider() {
    }

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator gen = event.getGenerator();
        
        	gen.addProvider(event.includeClient(), new GeomancyLanguageProvider(gen));
        	gen.addProvider(event.includeClient(), new GeomancyBlockStates(gen, event.getExistingFileHelper()));
        	gen.addProvider(event.includeClient(), new GeomancyItemModelProvider(gen, event.getExistingFileHelper()));

         	gen.addProvider(event.includeServer(), new GeomancyRecipeProvider(gen));
         	gen.addProvider(event.includeServer(), new GeomancyCuttingRecipeProvider(gen));
         	gen.addProvider(event.includeServer(), new GeomancyDippingRecipeProvider(gen));
         	gen.addProvider(event.includeServer(), new GeomancyInfusionRecipeProvider(gen));
         	gen.addProvider(event.includeServer(), new GeomancyUpgradeRecipeProvider(gen));
        	gen.addProvider(event.includeServer(), new GeomancyLootTableProvider(gen));
        	GeomancyBlockTags blockTags = new GeomancyBlockTags(gen, event.getExistingFileHelper());
            gen.addProvider(event.includeServer(), blockTags);
            gen.addProvider(event.includeServer(), new GeomancyItemTags(gen, blockTags, event.getExistingFileHelper()));
            gen.addProvider(event.includeServer(), new GeomancyFluidTags(gen, event.getExistingFileHelper()));
			gen.addProvider(event.includeServer(), new GeomancyEntityTags(gen, event.getExistingFileHelper()));
			gen.addProvider(event.includeServer(), new GeomancyBiomeModifierProvider(gen, event.getExistingFileHelper()));


    }

}
