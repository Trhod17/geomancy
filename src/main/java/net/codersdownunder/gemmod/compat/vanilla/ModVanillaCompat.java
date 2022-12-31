package net.codersdownunder.gemmod.compat.vanilla;

import net.codersdownunder.gemmod.init.BlockInit;
import net.codersdownunder.gemmod.init.ItemInit;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.ComposterBlock;
import net.minecraft.world.level.block.FireBlock;

public class ModVanillaCompat {
	
	public static void compat() {
        registerFlammable(BlockInit.CHASM_LEAVES.get(), 30, 60);
        registerFlammable(BlockInit.CHASM_LOG.get(), 5, 5);
        registerFlammable(BlockInit.CHASM_LOG_BARK.get(), 5, 5);
        registerFlammable(BlockInit.CHASM_LOG_STRIPPED.get(), 5, 5);
        registerFlammable(BlockInit.CHASM_LOG_STRIPPED_BARK.get(), 5, 5);
        registerFlammable(BlockInit.CHASM_PLANKS.get(), 5, 20);
        registerFlammable(BlockInit.CHASM_SLAB.get(), 5, 20);
        registerFlammable(BlockInit.CHASM_STAIRS.get(), 5, 20);
        registerFlammable(BlockInit.CHASM_FENCE.get(), 5, 20);
        registerFlammable(BlockInit.CHASM_FENCE_GATE.get(), 5, 20);
        
        registerCompostable(0.3F, BlockInit.CHASM_SAPLING.get().asItem());
        registerCompostable(0.3F, BlockInit.CHASM_LEAVES.get().asItem());
        registerCompostable(0.3F, ItemInit.MULMUS_BULB.get().asItem());
	}

	public static void registerCompostable(float chance, Item itemIn) {
		ComposterBlock.COMPOSTABLES.put(itemIn, chance);
	}

	public static void registerFlammable(Block blockIn, int encouragement, int flammability) {
		FireBlock fireblock = (FireBlock) Blocks.FIRE;
		fireblock.setFlammable(blockIn, encouragement, flammability);
	}
}
