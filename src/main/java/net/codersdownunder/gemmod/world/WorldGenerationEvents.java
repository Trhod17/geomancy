//package net.codersdownunder.gemmod.world;
//
//import java.util.Set;
//
//import net.codersdownunder.gemmod.GemMod;
//import net.codersdownunder.gemmod.world.features.GeomancyFeatures;
//import net.codersdownunder.gemmod.world.gen.ModTreeGeneration;
//import net.minecraft.core.Registry;
//import net.minecraft.resources.ResourceKey;
//import net.minecraft.world.level.biome.Biome;
//import net.minecraft.world.level.levelgen.GenerationStep.Decoration;
//import net.minecraftforge.common.BiomeDictionary;
//import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
//import net.minecraftforge.event.world.BiomeLoadingEvent;
//import net.minecraftforge.eventbus.api.EventPriority;
//import net.minecraftforge.eventbus.api.SubscribeEvent;
//import net.minecraftforge.fml.common.Mod;
//
//@Mod.EventBusSubscriber(modid = GemMod.MODID)
//public class WorldGenerationEvents {
//	
//	@SubscribeEvent(priority = EventPriority.HIGH)
//	public void biomeLoadingEvent(BiomeLoadingEvent event) {
//		BiomeGenerationSettingsBuilder builder = event.getGeneration();
//		
//		
//		   ResourceKey<Biome> key = ResourceKey.create(Registry.BIOME_REGISTRY, event.getName());
//	        Set<BiomeDictionary.Type> types = BiomeDictionary.getTypes(key);
//
//	        if(types.contains(BiomeDictionary.Type.OVERWORLD)) {
//			builder.addFeature(Decoration.LOCAL_MODIFICATIONS, GeomancyFeatures.DARKSTONE_GEORE.getPlacedFeature());
//	        }
//
//			ModTreeGeneration.generateTrees(event);
//	}
//	
//
//
//}
