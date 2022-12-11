package net.codersdownunder.gemmod.utils;

import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.common.Tags;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.tags.ITag;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("deprecation")
public class TagUtils {

	public static List<Item> getValues(TagKey<Item> itemTag) {

		ITag<Item> tags = ForgeRegistries.ITEMS.tags().getTag(itemTag);
		List<Item> output = new ArrayList<Item>();

		for (Item item : tags) {
			output.add(item);
		}

		return output;
	}
	
	public static List<Block> getValuesBlock(TagKey<Block> blockTag) {

		ITag<Block> tags = ForgeRegistries.BLOCKS.tags().getTag(blockTag);
		List<Block> output = new ArrayList<Block>();

		for (Block block : tags) {
			output.add(block);
		}

		return output;
	}
	
	public static List<Fluid> getValuesFluid(TagKey<Fluid> fluidTag) {

		ITag<Fluid> tags = ForgeRegistries.FLUIDS.tags().getTag(fluidTag);
		List<Fluid> output = new ArrayList<Fluid>();

		for (Fluid fluid : tags) {
			output.add(fluid);
		}

		return output;
	}

}
