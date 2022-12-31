package net.codersdownunder.gemmod.additions;

import net.codersdownunder.gemmod.additions.client.AdditionsLanguageProvider;
import net.codersdownunder.gemmod.additions.common.loottables.ModLootTables;
import net.codersdownunder.gemmod.additions.common.recipes.AdditionsRecipeProvider;
import net.codersdownunder.gemmod.additions.common.tags.AdditionsBlockTags;
import net.codersdownunder.gemmod.additions.common.tags.AdditionsItemTags;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@EventBusSubscriber(modid = Additions.MODID, bus = Bus.MOD)
public class AdditionsDataProvider {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        final var gen = event.getGenerator();
        final var packOutput = gen.getPackOutput();
        final var existingFileHelper = event.getExistingFileHelper();
        final var lookupProvider = event.getLookupProvider();
        
        	gen.addProvider(event.includeClient(), new AdditionsLanguageProvider(packOutput));
 
        	gen.addProvider(event.includeServer(), new AdditionsRecipeProvider(packOutput));
        	gen.addProvider(event.includeServer(), ModLootTables.create(packOutput));
        	AdditionsBlockTags blockTags = new AdditionsBlockTags(packOutput, lookupProvider, existingFileHelper);
            gen.addProvider(event.includeServer(), blockTags);
            gen.addProvider(event.includeServer(), new AdditionsItemTags(packOutput, lookupProvider, blockTags, existingFileHelper));
        
    }

}
