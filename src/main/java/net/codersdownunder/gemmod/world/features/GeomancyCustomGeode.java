package net.codersdownunder.gemmod.world.features;

import java.util.List;
import java.util.function.Supplier;

import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.GeodeBlockSettings;
import net.minecraft.world.level.levelgen.GeodeCrackSettings;
import net.minecraft.world.level.levelgen.GeodeLayerSettings;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.GeodeConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.SimpleStateProvider;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.RarityFilter;

public class GeomancyCustomGeode {
	protected final String NAME;

	protected final Block BLOCK;
	protected final Block BUDDING;
	protected final Block INTERIOR;
	protected final Block EXTERIOR;
	protected final Holder<ConfiguredFeature<GeodeConfiguration, ?>> GEODE;
	protected final Holder<PlacedFeature> GEODE_PLACED;
	protected final Supplier<Integer> RARITY;
	protected final Supplier<Integer> MIN_Y;
	protected final Supplier<Integer> MAX_Y;

	public String getName() {
		return NAME;
	}

	public Holder<PlacedFeature> getPlacedFeature() {
		return GEODE_PLACED;
	}
	
	public GeomancyCustomGeode(String name, Block block, Block interior, Block exterior, Supplier<Integer> rarityConfig, Supplier<Integer> minYConfig, Supplier<Integer> maxYConfig) {
		NAME = name;
		BLOCK = block;
		BUDDING = block;
		INTERIOR = interior;
		EXTERIOR = exterior;
		RARITY = rarityConfig;
		MIN_Y = minYConfig;
		MAX_Y = maxYConfig;

		GEODE = FeatureUtils.register(name + "_geode", Feature.GEODE, new GeodeConfiguration(
				new GeodeBlockSettings(BlockStateProvider.simple(Blocks.AIR), SimpleStateProvider.simple(BLOCK),
						SimpleStateProvider.simple(BUDDING), BlockStateProvider.simple(interior),
						SimpleStateProvider.simple(exterior),
						List.of(block.defaultBlockState(), block.defaultBlockState()),
						BlockTags.FEATURES_CANNOT_REPLACE, BlockTags.GEODE_INVALID_BLOCKS),
				new GeodeLayerSettings(1.7D, 1.5D, 2.2D, 4.2D),
				new GeodeCrackSettings(0.95D, 2.0D, 2), 0.35D, 0.083D, true,
				UniformInt.of(4, 6), UniformInt.of(3, 4),
				UniformInt.of(1, 2), -16, 16, 0.05D, 1));

		GEODE_PLACED = PlacementUtils.register(name + "_geode", GEODE, RarityFilter.onAverageOnceEvery(RARITY.get()), GeomancyFeatures.RNG_DECORATOR, InSquarePlacement.spread(),
				HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(MIN_Y.get()), VerticalAnchor.absolute(MAX_Y.get())), BiomeFilter.biome());
	}
}