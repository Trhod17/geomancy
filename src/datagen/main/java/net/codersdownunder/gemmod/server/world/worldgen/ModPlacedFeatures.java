package net.codersdownunder.gemmod.server.world.worldgen;

import net.codersdownunder.gemmod.Geomancy;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;

public class ModPlacedFeatures {
    public static final ResourceKey<PlacedFeature> DARKSTONE_GEODE = key("darkstone_geode");
    public static final ResourceKey<PlacedFeature> CHASM_TREE = key("chasm_tree");

    public static void bootstrap(final BootstapContext<PlacedFeature> context) {

        register(context, DARKSTONE_GEODE, ModConfiguredFeatures.DARKSTONE_GEODE,
                RarityFilter.onAverageOnceEvery(200), InSquarePlacement.spread(),
                HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(6), VerticalAnchor.absolute(50)),
                BiomeFilter.biome()
        );

        register(context, CHASM_TREE, ModConfiguredFeatures.CHASM_TREE,
                RarityFilter.onAverageOnceEvery(100), InSquarePlacement.spread(),
                BiomeFilter.biome()
        );
    }

    private static void register(
            final BootstapContext<PlacedFeature> context,
            final ResourceKey<PlacedFeature> key,
            final ResourceKey<ConfiguredFeature<?, ?>> feature,
            final PlacementModifier... placement
    ) {
        PlacementUtils.register(context, key, context.lookup(Registries.CONFIGURED_FEATURE).getOrThrow(feature), placement);
    }

    private static ResourceKey<PlacedFeature> key(final String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(Geomancy.MODID, name));
    }
}