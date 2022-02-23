package net.codersdownunder.gemmod.world.features;

import java.util.List;

import net.codersdownunder.gemmod.Config;
import net.codersdownunder.gemmod.init.BlockInit;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.WeightedPlacedFeature;
import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FancyFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.FancyTrunkPlacer;

public class GeomancyFeatures {
	
	public static void initialize() {}
	
	public static final PlacementModifier RNG_DECORATOR = HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.top());
	
	public static CustomGeode DARKSTONE_GEORE = new CustomGeode("darkstone", BlockInit.GEODE_ORE.get(), Blocks.COBBLED_DEEPSLATE, Blocks.ANDESITE, Config.SERVER.rarity::get);
	

	    public static final ConfiguredFeature<?, ?> CHASM = register("chasm", Feature.TREE.configured(
	            new TreeConfiguration.TreeConfigurationBuilder(
	                    BlockStateProvider.simple(BlockInit.CHASM_LOG.get()),
	                    new FancyTrunkPlacer(6, 2, 3),
	                    BlockStateProvider.simple(BlockInit.CHASM_LEAVES.get().defaultBlockState()),
	                    new FancyFoliagePlacer(ConstantInt.of(2), ConstantInt.of(1), 3),
	                    new TwoLayersFeatureSize(1, 0, 2)).dirt(BlockStateProvider.simple(Blocks.END_STONE)).build()));

	    public static final ConfiguredFeature<RandomFeatureConfiguration, ?> CHASM_TREE_CHECKED =
	            FeatureUtils.register("chasm_feature",
	                    Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(
	                            CHASM.filteredByBlockSurvival(BlockInit.CHASM_SAPLING.get()), 0.1f)),
	                            CHASM.filteredByBlockSurvival(BlockInit.CHASM_SAPLING.get()))));


	    private static <FC extends FeatureConfiguration>ConfiguredFeature<FC, ?> register(String name,
	                                                                                      ConfiguredFeature<FC, ?> configuredFeature) {
	        return Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, name, configuredFeature);
	    }
}
