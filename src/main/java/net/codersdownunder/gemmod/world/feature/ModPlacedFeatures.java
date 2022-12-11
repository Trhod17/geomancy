package net.codersdownunder.gemmod.world.feature;

import net.codersdownunder.gemmod.Geomancy;
import net.codersdownunder.gemmod.init.BlockInit;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

public class ModPlacedFeatures {
    public static final DeferredRegister<PlacedFeature> PLACED_FEATURES =
            DeferredRegister.create(Registries.PLACED_FEATURE, Geomancy.MODID);

    public static final RegistryObject<PlacedFeature> DARKSTONE_GEODE_PLACED = PLACED_FEATURES.register("darkstone_geode_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.DARKSTONE_GEODE.getHolder().get(), List.of(
                    RarityFilter.onAverageOnceEvery(200), InSquarePlacement.spread(),
                    HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(6), VerticalAnchor.absolute(50)),
                    BiomeFilter.biome())));

    public static final RegistryObject<PlacedFeature> CHASM_TREE_CHECKED = PLACED_FEATURES.register("chasm_tree_checked",
            () -> new PlacedFeature(ModConfiguredFeatures.CHASM_TREE.getHolder().get(),
                    List.of(PlacementUtils.filteredByBlockSurvival(BlockInit.CHASM_SAPLING.get()))));

    public static final RegistryObject<PlacedFeature> CHASM_TREE_PLACED = PLACED_FEATURES.register("chasm_tree_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.CHASM_TREE_SPAWN.getHolder().get(), VegetationPlacements.treePlacement(
                    PlacementUtils.countExtra(3, 0.1f, 2))));


    public static void register(IEventBus eventBus) {
        PLACED_FEATURES.register(eventBus);
    }
}
