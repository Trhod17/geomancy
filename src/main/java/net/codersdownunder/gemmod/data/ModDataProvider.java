//package net.codersdownunder.gemmod.data;
//
//import net.codersdownunder.gemmod.GemMod;
//import net.minecraft.data.DataGenerator;
//import net.minecraftforge.eventbus.api.SubscribeEvent;
//import net.minecraftforge.fml.common.Mod;
//import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;
//
//@Mod.EventBusSubscriber(modid = GemMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
//public class ModDataProvider {
//    
//     @SubscribeEvent
//        public static void gatherData(GatherDataEvent event) {
//            DataGenerator generator = event.getGenerator();
//            
//            if (event.includeClient()) {
//                generator.addProvider(new GemModLanguageProvider(generator));
//            }
//        }
//    
//}