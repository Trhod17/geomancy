package net.codersdownunder.gemmod.common;

import net.codersdownunder.gemmod.GemMod;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
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
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        if (event.includeClient()) {
        
        }
        
        if (event.includeServer()) {
        	
        }
    }
}
