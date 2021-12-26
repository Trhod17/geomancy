package net.codersdownunder.gemmod.world.features;

import java.util.function.Supplier;

import com.google.common.collect.ImmutableList;

import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.GeodeBlockSettings;
import net.minecraft.world.level.levelgen.GeodeCrackSettings;
import net.minecraft.world.level.levelgen.GeodeLayerSettings;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.GeodeConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.SimpleStateProvider;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.RarityFilter;


public class CustomGeode {
	
	protected final String NAME;
	
	protected final BlockState BLOCK;
	protected final BlockState BUDDING;
	protected final BlockState EXTERIOR;
	protected final BlockState INNER;
	protected final ConfiguredFeature<GeodeConfiguration, ?> GEODE;
	protected final Supplier<Integer> RARITY;

	public String getName() {
		return NAME;
	}

	public PlacedFeature getPlacedFeature() {
		return GEODE.placed(RarityFilter.onAverageOnceEvery(RARITY.get()), GeomancyFeatures.RNG_DECORATOR, InSquarePlacement.spread(),
				HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(-50), VerticalAnchor.absolute(30)), BiomeFilter.biome());
	}


	public CustomGeode(String name, Block blockReg, Block exterior, Block inner, Supplier<Integer> rarityConfig) {
		NAME = name;
		BLOCK = blockReg.defaultBlockState();
		BUDDING = blockReg.defaultBlockState();
		EXTERIOR = exterior.defaultBlockState();
		INNER = inner.defaultBlockState();
		RARITY = rarityConfig;
		
		GEODE = FeatureUtils.register(name + "_geode", Feature.GEODE.configured(new GeodeConfiguration(
				new GeodeBlockSettings(SimpleStateProvider.simple(Blocks.AIR.defaultBlockState()), SimpleStateProvider.simple(BLOCK),
						SimpleStateProvider.simple(BUDDING), SimpleStateProvider.simple(inner),
						SimpleStateProvider.simple(EXTERIOR),
						ImmutableList.of(blockReg.defaultBlockState(), blockReg.defaultBlockState(),
								blockReg.defaultBlockState(), blockReg.defaultBlockState()),
						BlockTags.FEATURES_CANNOT_REPLACE.getName(), BlockTags.GEODE_INVALID_BLOCKS.getName()),
				new GeodeLayerSettings(1.7D, 2.2D, 3.2D, 4.2D),
				new GeodeCrackSettings(0.95D, 2.0D, 2), 0.35D, 0.083D, true,
				UniformInt.of(4, 6), UniformInt.of(3, 4),
				UniformInt.of(1, 2), -16, 16, 0.05D, 1)));
	}
}
