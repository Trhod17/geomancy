package net.codersdownunder.gemmod.world.features;

import net.codersdownunder.gemmod.Config;
import net.codersdownunder.gemmod.init.BlockInit;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;

public class GeomancyFeatures {
	
	public static void initialize() {}
	
	public static final PlacementModifier RNG_DECORATOR = HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.top());
	//TODO: change to cobbled deepslate
	public static CustomGeode DARKSTONE_GEORE = new CustomGeode("darkstone", BlockInit.GEODE_ORE.get(), Blocks.BLACKSTONE, Blocks.ANDESITE, Config.SERVER.rarity::get);

}
