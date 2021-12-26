package net.codersdownunder.gemmod.world;

import net.codersdownunder.gemmod.world.features.GeomancyFeatures;
import net.minecraft.world.level.levelgen.GenerationStep.Decoration;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class WorldGenerationEvents {
	
	@SubscribeEvent(priority = EventPriority.HIGH)
	public void biomeLoadingEvent(BiomeLoadingEvent event) {
		BiomeGenerationSettingsBuilder builder = event.getGeneration();

		
			builder.addFeature(Decoration.LOCAL_MODIFICATIONS, GeomancyFeatures.DARKSTONE_GEORE.getPlacedFeature());
	}
}
