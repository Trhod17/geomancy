package net.codersdownunder.gemmod.server.world.worldgen;

import net.codersdownunder.gemmod.Geomancy;
import net.codersdownunder.gemmod.init.BlockInit;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.GeodeBlockSettings;
import net.minecraft.world.level.levelgen.GeodeCrackSettings;
import net.minecraft.world.level.levelgen.GeodeLayerSettings;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.GeodeConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;

import java.util.List;

import static net.minecraft.data.worldgen.features.FeatureUtils.register;

public class ModConfiguredFeatures {


    public static final ResourceKey<ConfiguredFeature<?, ?>> DARKSTONE_GEODE = key("darkstone_geode");
    public static final ResourceKey<ConfiguredFeature<?, ?>> CHASM_TREE = key("chasm_tree");
    //public static final ResourceKey<ConfiguredFeature<?, ?>> CHASM_TREE_SPAWN = key("chasm_tree_spawn");

    public static void bootstrap(final BootstapContext<ConfiguredFeature<?, ?>> context) {

        register(context, DARKSTONE_GEODE, Feature.GEODE,
               new GeodeConfiguration(new GeodeBlockSettings(
                       BlockStateProvider.simple(Blocks.AIR),
                       BlockStateProvider.simple(Blocks.COBBLED_DEEPSLATE),
                       BlockStateProvider.simple(BlockInit.GEODE_ORE.get()),
                       BlockStateProvider.simple(Blocks.COBBLED_DEEPSLATE),
                       BlockStateProvider.simple(Blocks.ANDESITE),
                       List.of(BlockInit.GEODE_ORE.get().defaultBlockState()),
                       BlockTags.FEATURES_CANNOT_REPLACE, BlockTags.GEODE_INVALID_BLOCKS),
                       new GeodeLayerSettings(1.7D, 2.2D, 3.2D, 4.2D),
                       new GeodeCrackSettings(0.95D, 2.0D, 2),
                       0.35D, 0.083D, true,
                       UniformInt.of(4, 6),
                       UniformInt.of(3, 4),
                       UniformInt.of(1, 2),
                       -16, 16, 0.05D, 1)
        );

        register(context, CHASM_TREE, Feature.TREE,  new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(BlockInit.CHASM_LOG.get()),
                new StraightTrunkPlacer(5, 6, 3),
                BlockStateProvider.simple(BlockInit.CHASM_LEAVES.get()),
                new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 4),
                new TwoLayersFeatureSize(1, 0, 2)).dirt(BlockStateProvider.simple(Blocks.END_STONE)).build()
        );

//        register(context, CHASM_TREE_SPAWN, Feature.TREE, new ConfiguredFeature<>(Feature.RANDOM_SELECTOR,
//                new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(
//                        net.codersdownunder.gemmod.world.feature.ModPlacedFeatures.CHASM_TREE_CHECKED.getHolder().get(),
//                        0.5F)), ModPlacedFeatures.CHASM_TREE_CHECKED.getHolder().get()))
//        );
    }

    private static ResourceKey<ConfiguredFeature<?, ?>> key(final String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(Geomancy.MODID, name));
    }
}