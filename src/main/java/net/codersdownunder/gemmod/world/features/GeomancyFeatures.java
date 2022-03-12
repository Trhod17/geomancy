//package net.codersdownunder.gemmod.world.features;
//
//import java.util.List;
//
//import net.codersdownunder.gemmod.Config;
//import net.codersdownunder.gemmod.init.BlockInit;
//import net.minecraft.world.level.block.Blocks;
//import net.minecraft.world.level.levelgen.VerticalAnchor;
//import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
//import net.minecraft.world.level.levelgen.placement.PlacementModifier;
//import net.minecraft.core.Registry;
//import net.minecraft.core.RegistryAccess.RegistryEntry;
//import net.minecraft.data.BuiltinRegistries;
//import net.minecraft.data.worldgen.features.FeatureUtils;
//import net.minecraft.util.valueproviders.ConstantInt;
//import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
//import net.minecraft.world.level.levelgen.feature.Feature;
//import net.minecraft.world.level.levelgen.feature.WeightedPlacedFeature;
//import net.minecraft.world.level.levelgen.feature.configurations.*;
//import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
//import net.minecraft.world.level.levelgen.feature.foliageplacers.FancyFoliagePlacer;
//import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
//import net.minecraft.world.level.levelgen.feature.trunkplacers.FancyTrunkPlacer;
//
//
//public class GeomancyFeatures {
//	
//	public static void initialize() {}
//	
//	public static final PlacementModifier RNG_DECORATOR = HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.top());
//	
//		public static CustomGeode DARKSTONE_GEORE = new CustomGeode("darkstone", BlockInit.GEODE_ORE.get(), Blocks.COBBLED_DEEPSLATE, Blocks.ANDESITE, Config.SERVER.rarity::get);
//	
//
//	    public static final ConfiguredFeature<?, ?> CHASM = register("chasm", Feature.TREE.configuredCodec());
//
//	    public static final ConfiguredFeature<RandomFeatureConfiguration, ?> CHASM_TREE_CHECKED =
//	            FeatureUtils.register("chasm_feature",
//	                    Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(
//	                            CHASM.filteredByBlockSurvival(BlockInit.CHASM_SAPLING.get()), 0.1f)),
//	                            CHASM.filteredByBlockSurvival(BlockInit.CHASM_SAPLING.get()))));
//
//
//	    private static RegistryEntry<ConfiguredFeature<?, ?>> register(String id, ConfiguredFeature<?, ?> configuredFeature) {
//	        return BuiltinRegistries.add(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier(MoreGeodes.MODID, id), configuredFeature);
//	    }
//}
