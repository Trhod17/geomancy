package net.codersdownunder.gemmod.common;

import net.codersdownunder.gemmod.GemMod;
import net.codersdownunder.gemmod.client.GeomancyBlockStates;
import net.codersdownunder.gemmod.client.GeomancyItemModelProvider;
import net.codersdownunder.gemmod.client.GeomancyLanguageProvider;
import net.codersdownunder.gemmod.common.loottables.ModLootTables;
import net.codersdownunder.gemmod.common.recipes.GeomancyCuttingRecipeProvider;
import net.codersdownunder.gemmod.common.recipes.GeomancyDippingRecipeProvider;
import net.codersdownunder.gemmod.common.recipes.GeomancyInfusionRecipeProvider;
import net.codersdownunder.gemmod.common.recipes.GeomancyRecipeProvider;
import net.codersdownunder.gemmod.common.recipes.GeomancyUpgradeRecipeProvider;
import net.codersdownunder.gemmod.common.tags.GeomancyBlockTags;
import net.codersdownunder.gemmod.common.tags.GeomancyFluidTags;
import net.codersdownunder.gemmod.common.tags.GeomancyItemTags;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;

@EventBusSubscriber(modid = GemMod.MODID, bus = Bus.MOD)
public class GeomancyDataProvider {

    private GeomancyDataProvider() {
    }

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator gen = event.getGenerator();
        
        if (event.includeClient()) {
        	gen.addProvider(new GeomancyLanguageProvider(gen));
        	gen.addProvider(new GeomancyBlockStates(gen, event.getExistingFileHelper()));
        	gen.addProvider(new GeomancyItemModelProvider(gen, event.getExistingFileHelper()));
        	
        }
        
         if (event.includeServer()) {
         	gen.addProvider(new GeomancyRecipeProvider(gen));
         	gen.addProvider(new GeomancyCuttingRecipeProvider(gen));
         	gen.addProvider(new GeomancyDippingRecipeProvider(gen));
         	gen.addProvider(new GeomancyInfusionRecipeProvider(gen));
         	gen.addProvider(new GeomancyUpgradeRecipeProvider(gen));
        	gen.addProvider(new ModLootTables(gen));
        	GeomancyBlockTags blockTags = new GeomancyBlockTags(gen, event.getExistingFileHelper());
            gen.addProvider(blockTags);
            gen.addProvider(new GeomancyItemTags(gen, blockTags, event.getExistingFileHelper()));
            gen.addProvider(new GeomancyFluidTags(gen, event.getExistingFileHelper()));
            
        }
    }
}
