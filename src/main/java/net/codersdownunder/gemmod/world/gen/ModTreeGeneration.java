//package net.codersdownunder.gemmod.world.gen;
//
//import java.util.List;
//import java.util.Set;
//import java.util.function.Supplier;
//
//import net.codersdownunder.gemmod.world.features.ModConfiguredFeatures;
//import net.minecraft.core.Registry;
//import net.minecraft.data.worldgen.features.TreeFeatures;
//import net.minecraft.data.worldgen.features.VegetationFeatures;
//import net.minecraft.data.worldgen.placement.PlacementUtils;
//import net.minecraft.data.worldgen.placement.VegetationPlacements;
//import net.minecraft.resources.ResourceKey;
//import net.minecraft.world.level.biome.Biome;
//import net.minecraft.world.level.block.Blocks;
//import net.minecraft.world.level.levelgen.GenerationStep;
//import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
//import net.minecraft.world.level.levelgen.feature.configurations.VegetationPatchConfiguration;
//import net.minecraft.world.level.levelgen.placement.PlacedFeature;
//import net.minecraftforge.common.BiomeDictionary;
//import net.minecraftforge.event.world.BiomeLoadingEvent;
//
//public class ModTreeGeneration {
//	
//    public static void generateTrees(final BiomeLoadingEvent event) {
//        ResourceKey<Biome> key = ResourceKey.create(Registry.BIOME_REGISTRY, event.getName());
//        Set<BiomeDictionary.Type> types = BiomeDictionary.getTypes(key);
//
//        if(types.contains(BiomeDictionary.Type.END)) {
//            List<Supplier<PlacedFeature>> base =
//                    event.getGeneration().getFeatures(GenerationStep.Decoration.VEGETAL_DECORATION);
//
//            
//            base.add(() -> ModConfiguredFeatures.CHASM
//                    .decorated(TreeFeatures.OAK.placed(VegetationPlacements.treePlacement(PlacementUtils.countExtra(5, 0.1F, 1), Blocks.OAK_SAPLING)))
//                    .decorated(FeatureDecorator.COUNT_EXTRA
//                            .configured(new FrequencyWithExtraChanceDecoratorConfiguration(
//                                    2, 0.1f, 1))));
//        }
//    }
//}