//TODO fix this when forge redoes this

//package net.codersdownunder.gemmod.server.world;
//

//import com.google.common.base.Preconditions;
//import com.google.gson.JsonElement;
//import com.mojang.serialization.JsonOps;
//import net.codersdownunder.gemmod.Geomancy;
//import net.codersdownunder.gemmod.world.feature.ModPlacedFeatures;
//import net.minecraft.core.HolderSet;
//import net.minecraft.core.Registry;
//import net.minecraft.core.RegistryAccess;
//import net.minecraft.core.registries.Registries;
//import net.minecraft.data.CachedOutput;
//import net.minecraft.data.DataGenerator;
//import net.minecraft.data.DataProvider;
//import net.minecraft.resources.RegistryOps;
//import net.minecraft.resources.ResourceLocation;
//import net.minecraft.tags.BiomeTags;
//import net.minecraft.tags.TagKey;
//import net.minecraft.world.level.biome.Biome;
//import net.minecraft.world.level.levelgen.GenerationStep;
//import net.minecraft.world.level.levelgen.placement.PlacedFeature;
//import net.minecraftforge.common.data.ExistingFileHelper;
//import net.minecraftforge.common.data.JsonCodecProvider;
//import net.minecraftforge.common.world.BiomeModifier;
//import net.minecraftforge.common.world.ForgeBiomeModifiers.AddFeaturesBiomeModifier;
//import net.minecraftforge.registries.ForgeRegistries;
//import net.minecraftforge.registries.RegistryObject;
//
//import java.io.IOException;
//import java.util.HashMap;
//import java.util.Map;
//
//public class GeomancyBiomeModifierProvider implements DataProvider {
//    private final DataGenerator generator;
//    private final ExistingFileHelper existingFileHelper;
//    private final Map<ResourceLocation, BiomeModifier> toSerialize = new HashMap<>();
//
//    public GeomancyBiomeModifierProvider(final DataGenerator generator, final ExistingFileHelper existingFileHelper) {
//        this.generator = generator;
//        this.existingFileHelper = existingFileHelper;
//    }
//
//    protected void addModifiers(final RegistryOps<JsonElement> ops) {
//        final var biomeRegistry = ops.getter(Registries.BIOME).orElseThrow();
//        final var featureRegistry = ops.registry(Registries.PLACED_FEATURE).orElseThrow();
//
//        addModifier(
//                "darkstone_geode",
//                new AddFeaturesBiomeModifier(
//                        tag(biomeRegistry, BiomeTags.IS_OVERWORLD),
//                        feature(featureRegistry, ModPlacedFeatures.DARKSTONE_GEODE_PLACED),
//                        GenerationStep.Decoration.UNDERGROUND_ORES
//                )
//        );
//
//        addModifier(
//                "chasm_tree",
//                new AddFeaturesBiomeModifier(
//                        tag(biomeRegistry, BiomeTags.IS_END),
//                        feature(featureRegistry, ModPlacedFeatures.CHASM_TREE_PLACED),
//                        GenerationStep.Decoration.VEGETAL_DECORATION
//                )
//        );
//    }
//
//    @Override
//    public void run(final CachedOutput cache) throws IOException {
//        final var ops = RegistryOps.create(JsonOps.INSTANCE, RegistryAccess.builtinCopy());
//
//        addModifiers(ops);
//
//        final JsonCodecProvider<BiomeModifier> provider = JsonCodecProvider.forDatapackRegistry(
//                generator,
//                existingFileHelper,
//                Geomancy.MODID,
//                ops,
//                ForgeRegistries.Keys.BIOME_MODIFIERS,
//                toSerialize
//        );
//
//        provider.run(cache);
//    }
//
//    protected <T extends BiomeModifier> void addModifier(final String modifier, final T instance) {
//        toSerialize.put(new ResourceLocation(Geomancy.MODID, modifier), instance);
//    }
//
//    @Override
//    public String getName() {
//        return "Geomancy BiomeModifiers";
//    }
//
//    protected HolderSet<Biome> tag(final Registry<Biome> registry, final TagKey<Biome> key) {
//        return new HolderSet.Named<>(registry, key);
//    }
//
//    protected HolderSet<PlacedFeature> feature(final Registry<PlacedFeature> registry, final RegistryObject<PlacedFeature> feature) {
//        final var key = Preconditions.checkNotNull(feature.getKey(), "%s has no registry key", feature.get());
//        return HolderSet.direct(registry.getHolderOrThrow(key));
//    }
//}
//
