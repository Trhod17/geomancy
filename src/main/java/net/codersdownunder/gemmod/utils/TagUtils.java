package net.codersdownunder.gemmod.utils;

import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Fluid;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("deprecation")
public class TagUtils {

	public static List<Item> getValues(TagKey<Item> itemTag) {

		Iterable<Holder<Item>> tags = Registry.ITEM.getTagOrEmpty(itemTag);
		List<Item> output = new ArrayList<Item>();

		for (Holder<Item> item : tags) {
			output.add(item.value());
		}

		return output;
	}
	
	public static List<Block> getValuesBlock(TagKey<Block> blockTag) {

		Iterable<Holder<Block>> tags = Registry.BLOCK.getTagOrEmpty(blockTag);
		List<Block> output = new ArrayList<Block>();

		for (Holder<Block> block : tags) {
			output.add(block.value());
		}

		return output;
	}
	
	public static List<Fluid> getValuesFluid(TagKey<Fluid> fluidTag) {

		Iterable<Holder<Fluid>> tags = Registry.FLUID.getTagOrEmpty(fluidTag);
		List<Fluid> output = new ArrayList<Fluid>();

		for (Holder<Fluid> fluid : tags) {
			output.add(fluid.value());
		}

		return output;
	}

}
