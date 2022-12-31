package net.codersdownunder.gemmod.server.world;

import net.codersdownunder.gemmod.Geomancy;
import net.codersdownunder.gemmod.server.world.worldgen.ModPlacedFeatures;
import net.minecraft.core.*;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ForgeBiomeModifiers.AddFeaturesBiomeModifier;
import net.minecraftforge.registries.ForgeRegistries;


public class GeomancyBiomeModifierProvider {
//    private final DataGenerator generator;
//    private final ExistingFileHelper existingFileHelper;
//    private final CompletableFuture<HolderLookup.Provider> lookupProvider;
//    private final Map<ResourceLocation, BiomeModifier> toSerialize = new HashMap<>();
//
//    public GeomancyBiomeModifierProvider(final DataGenerator generator, final ExistingFileHelper existingFileHelper, final CompletableFuture<HolderLookup.Provider> lookupProvider) {
//        this.generator = generator;
//        this.existingFileHelper = existingFileHelper;
//        this.lookupProvider = lookupProvider;
//    }

    public static final ResourceKey<BiomeModifier> darkstone_geode = key("darkstone_geode");
    public static final ResourceKey<BiomeModifier> chasm_tree = key("chasm_tree");


    public static void bootstrap(final BootstapContext<BiomeModifier> context) {
        final var biomes = context.lookup(Registries.BIOME);
        final var features = context.lookup(Registries.PLACED_FEATURE);

        context.register(
                darkstone_geode,
                new AddFeaturesBiomeModifier(
                        tag(biomes, BiomeTags.IS_OVERWORLD),
                        feature(features, ModPlacedFeatures.DARKSTONE_GEODE),
                        GenerationStep.Decoration.UNDERGROUND_ORES
                )
        );

        context.register(
                chasm_tree,
                new AddFeaturesBiomeModifier(
                        tag(biomes, BiomeTags.IS_END),
                        feature(features, ModPlacedFeatures.CHASM_TREE),
                        GenerationStep.Decoration.VEGETAL_DECORATION
                )
        );
    }

    private static ResourceKey<BiomeModifier> key(final String name) {
        return ResourceKey.create(ForgeRegistries.Keys.BIOME_MODIFIERS, new ResourceLocation(Geomancy.MODID, name));
    }

    private static HolderSet<Biome> tag(final HolderGetter<Biome> holderGetter, final TagKey<Biome> key) {
        return holderGetter.getOrThrow(key);
    }

    private static HolderSet<PlacedFeature> feature(final HolderGetter<PlacedFeature> holderGetter, final ResourceKey<PlacedFeature> feature) {
        return HolderSet.direct(holderGetter.getOrThrow(feature));
    }

}

