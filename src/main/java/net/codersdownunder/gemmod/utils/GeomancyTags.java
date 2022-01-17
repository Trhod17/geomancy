package net.codersdownunder.gemmod.utils;

import net.codersdownunder.gemmod.GemMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.FluidTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.common.Tags;

@SuppressWarnings("unused")
public class GeomancyTags {

	public static class Blocks {
		
		private static Tags.IOptionalNamedTag<Block> createTag(String name) {
			return BlockTags.createOptional(new ResourceLocation(GemMod.MODID, name));
		}
		
		private static Tags.IOptionalNamedTag<Block> createForgeTag(String name) {
			return BlockTags.createOptional(new ResourceLocation("forge", name));
		}
	}
	
	public static class Items {
		
		public static final Tags.IOptionalNamedTag<Item> CONCOCTIONS_TIER_1 = createTag("concoctions/concoctions_tier_1");
		public static final Tags.IOptionalNamedTag<Item> CONCOCTIONS_TIER_2 = createTag("concoctions/concoctions_tier_2");
		public static final Tags.IOptionalNamedTag<Item> CONCOCTIONS_TIER_3 = createTag("concoctions/concoctions_tier_3");
		public static final Tags.IOptionalNamedTag<Item> CONCOCTIONS_TIER_4 = createTag("concoctions/concoctions_tier_4");
		
		public static final Tags.IOptionalNamedTag<Item> DREAM_COMMON = createTag("dream_common");
		public static final Tags.IOptionalNamedTag<Item> DREAM_RARE = createTag("dream_rare");
		
		public static final Tags.IOptionalNamedTag<Item> STRING = createTag("string");
		public static final Tags.IOptionalNamedTag<Item> SEED_CRYSTAL = createTag("seed_crystal");
		
		public static final Tags.IOptionalNamedTag<Item> DIPPING_FLUIDS = createTag("dipping_fluids");
		
		public static final Tags.IOptionalNamedTag<Item> QUARTZ = createForgeTag("gems/quartz");
		
		private static Tags.IOptionalNamedTag<Item> createTag(String name) {
			return ItemTags.createOptional(new ResourceLocation(GemMod.MODID, name));
		}
		
		private static Tags.IOptionalNamedTag<Item> createForgeTag(String name) {
			return ItemTags.createOptional(new ResourceLocation("forge", name));
		}
	}
	
	public static class Fluids {
		

		public static final Tags.IOptionalNamedTag<Fluid> DIPPING_FLUIDS = createTag("dipping_fluids");
		
		private static Tags.IOptionalNamedTag<Fluid> createTag(String name) {
			return FluidTags.createOptional(new ResourceLocation(GemMod.MODID, name));
		}
		
		private static Tags.IOptionalNamedTag<Fluid> createForgeTag(String name) {
			return FluidTags.createOptional(new ResourceLocation("forge", name));
		}
	}
}
