package net.codersdownunder.gemmod.world.features.tree;

import java.util.Random;

import javax.annotation.Nullable;

import net.codersdownunder.gemmod.world.features.GeomancyFeatures;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;

public class ChasmTreeGrower extends AbstractTreeGrower {
    
	@SuppressWarnings("unchecked")
	@Nullable
    @Override
    protected ConfiguredFeature<TreeConfiguration, ?> getConfiguredFeature(Random pRandom, boolean pLargeHive) {
        return (ConfiguredFeature<TreeConfiguration, ?>)GeomancyFeatures.CHASM;
    }
}