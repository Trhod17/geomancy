package net.codersdownunder.gemmod.utils;

import net.codersdownunder.gemmod.GemMod;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.FluidTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.Tag;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.common.Tags;

@SuppressWarnings("unused")
public class GeomancyTags {

	public static class Blocks {
		
		public static final TagKey<Block> claw = createTag("mineable/claw");
		
		private static TagKey<Block> createTag(String name) {
			return BlockTags.create(new ResourceLocation(GemMod.MODID, name));
		}
		
		private static TagKey<Block> createForgeTag(String name) {
			return BlockTags.create(new ResourceLocation("forge", name));
		}
	}
	
	public static class Items {
		
		public static final TagKey<Item> CONCOCTIONS_TIER_1 = createTag("concoctions/concoctions_tier_1");
		public static final TagKey<Item> CONCOCTIONS_TIER_2 = createTag("concoctions/concoctions_tier_2");
		public static final TagKey<Item> CONCOCTIONS_TIER_3 = createTag("concoctions/concoctions_tier_3");
		public static final TagKey<Item> CONCOCTIONS_TIER_4 = createTag("concoctions/concoctions_tier_4");
		
		public static final TagKey<Item> DREAM_COMMON = createTag("dream_common");
		public static final TagKey<Item> DREAM_RARE = createTag("dream_rare");
		
		public static final TagKey<Item> STRING = createTag("string");
		public static final TagKey<Item> SEED_CRYSTAL = createTag("seed_crystal");
		
		public static final TagKey<Item> DIPPING_FLUIDS = createTag("dipping_fluids");
		
		public static final TagKey<Item> QUARTZ = createForgeTag("gems/quartz");
		
		private static TagKey<Item> createTag(String name) {
			return ItemTags.create(new ResourceLocation(GemMod.MODID, name));
		}
		
		private static TagKey<Item> createForgeTag(String name) {
			return ItemTags.create(new ResourceLocation("forge", name));
		}
	}
	
	public static class Fluids {
		

		public static final TagKey<Fluid> DIPPING_FLUIDS = createTag("dipping_fluids");
		
		private static TagKey<Fluid> createTag(String name) {
			return FluidTags.create(new ResourceLocation(GemMod.MODID, name));
		}
		
		private static TagKey<Fluid> createForgeTag(String name) {
			return FluidTags.create(new ResourceLocation("forge", name));
		}
	}
}
