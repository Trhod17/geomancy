package net.codersdownunder.gemmod.world.features;

import java.util.List;

import net.codersdownunder.gemmod.Config;
import net.codersdownunder.gemmod.GemMod;
import net.codersdownunder.gemmod.init.BlockInit;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FancyFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;


public class GeomancyFeatures {
	
	public static void initialize() {}
	
	public static final PlacementModifier RNG_DECORATOR = HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.top());
	
		public static GeomancyCustomGeode DARKSTONE_GEORE = new GeomancyCustomGeode("darkstone", BlockInit.GEODE_ORE.get(), Blocks.COBBLED_DEEPSLATE, Blocks.ANDESITE, Config.COMMON.rarity::get, Config.COMMON.geodeMinY::get, Config.COMMON.geodeMaxY::get);
		
		public static final Holder<ConfiguredFeature<TreeConfiguration, ?>> CHASM_TREE = conf("chasm_tree", Feature.TREE, GeomancyFeatures.Configs.CHASM_TREE_CONFIG);

		public static final Holder<PlacedFeature> PLACABLE_CHASM_TREE = place("chasm_tree", GeomancyFeatures.CHASM_TREE, VegetationPlacements.treePlacement(PlacementUtils.countExtra(0, 0.05F, 1), BlockInit.CHASM_SAPLING.get()));
		
		
		private static Holder<PlacedFeature> place(String name, Holder<? extends ConfiguredFeature<?, ?>> feature, List<PlacementModifier> modifiers)
		{
			return PlacementUtils.register(GemMod.MODID + ":" + name, feature, modifiers);
		}

	    private static <FC extends FeatureConfiguration, F extends Feature<FC>> Holder<ConfiguredFeature<FC, ?>> conf(String nameIn, F feature, FC config)
		{
			return FeatureUtils.register(GemMod.MODID + ":" + nameIn, feature, config);
		}
	    
	    public static boolean doesBiomeMatch(ResourceLocation biomeNameIn, ResourceKey<Biome> biomeIn)
		{
			return biomeNameIn.getPath().matches(biomeIn.location().getPath());
		}


	    public static class Configs
		{
			public static final TreeConfiguration CHASM_TREE_CONFIG = (new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(BlockInit.CHASM_LOG.get()), new StraightTrunkPlacer(4, 2, 0), new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(BlockInit.CHASM_LEAVES.get().defaultBlockState(), 6).add(BlockInit.CHASM_LEAVES.get().defaultBlockState(), 1)), new FancyFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3), new TwoLayersFeatureSize(1, 0, 1))).dirt(BlockStateProvider.simple(Blocks.END_STONE.defaultBlockState())).ignoreVines().build();
		}

}
