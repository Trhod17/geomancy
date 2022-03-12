package net.codersdownunder.gemmod.additions.common;

import net.codersdownunder.gemmod.additions.Additions;
import net.codersdownunder.gemmod.additions.client.AdditionsLanguageProvider;
import net.codersdownunder.gemmod.additions.common.loottables.ModLootTables;
import net.codersdownunder.gemmod.additions.common.recipes.AdditionsRecipeProvider;
import net.codersdownunder.gemmod.additions.common.tags.AdditionsBlockTags;
import net.codersdownunder.gemmod.additions.common.tags.AdditionsItemTags;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;

@EventBusSubscriber(modid = Additions.MODID, bus = Bus.MOD)
public class AdditionsDataProvider {

    private AdditionsDataProvider() {
    }

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator gen = event.getGenerator();
        
        if (event.includeClient()) {
        	gen.addProvider(new AdditionsLanguageProvider(gen));
        }
        
         if (event.includeServer()) {
        	gen.addProvider(new AdditionsRecipeProvider(gen));
        	gen.addProvider(new ModLootTables(gen));
        	AdditionsBlockTags blockTags = new AdditionsBlockTags(gen, event.getExistingFileHelper());
            gen.addProvider(blockTags);
            gen.addProvider(new AdditionsItemTags(gen, blockTags, event.getExistingFileHelper()));
        }
    }
}
