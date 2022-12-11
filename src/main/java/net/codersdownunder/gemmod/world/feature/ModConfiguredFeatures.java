package net.codersdownunder.gemmod.world.feature;

import net.codersdownunder.gemmod.Geomancy;
import net.codersdownunder.gemmod.init.BlockInit;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.GeodeBlockSettings;
import net.minecraft.world.level.levelgen.GeodeCrackSettings;
import net.minecraft.world.level.levelgen.GeodeLayerSettings;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.WeightedPlacedFeature;
import net.minecraft.world.level.levelgen.feature.configurations.GeodeConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RandomFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

public class ModConfiguredFeatures {
    public static final DeferredRegister<ConfiguredFeature<?, ?>> CONFIGURED_FEATURES =
            DeferredRegister.create(Registries.CONFIGURED_FEATURE, Geomancy.MODID);

    public static final RegistryObject<ConfiguredFeature<?, ?>> DARKSTONE_GEODE = CONFIGURED_FEATURES.register("darkstone_geode",
            () -> new ConfiguredFeature<>(Feature.GEODE,
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
                            -16, 16, 0.05D, 1)));

    public static final RegistryObject<ConfiguredFeature<?, ?>> CHASM_TREE =
            CONFIGURED_FEATURES.register("chasm_tree", () ->
                    new ConfiguredFeature<>(Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                            BlockStateProvider.simple(BlockInit.CHASM_LOG.get()),
                            new StraightTrunkPlacer(5, 6, 3),
                            BlockStateProvider.simple(BlockInit.CHASM_LEAVES.get()),
                            new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 4),
                            new TwoLayersFeatureSize(1, 0, 2)).dirt(BlockStateProvider.simple(Blocks.END_STONE)).build()));

    public static final RegistryObject<ConfiguredFeature<?, ?>> CHASM_TREE_SPAWN =
            CONFIGURED_FEATURES.register("chasm_tree_spawn", () -> new ConfiguredFeature<>(Feature.RANDOM_SELECTOR,
                    new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(
                            ModPlacedFeatures.CHASM_TREE_CHECKED.getHolder().get(),
                            0.5F)), ModPlacedFeatures.CHASM_TREE_CHECKED.getHolder().get())));

    public static void register(IEventBus eventbus) {
        CONFIGURED_FEATURES.register(eventbus);
    }
}
