package net.codersdownunder.gemmod.additions.common.loottables;

import net.codersdownunder.gemmod.additions.init.BlockInit;
import net.minecraft.data.loot.BlockLoot;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;


public class ModBlockLootTables extends BlockLoot {
    
        @Override
        public void addTables() {
            dropSelf(BlockInit.PURPUR_WALL.get());
            dropSelf(BlockInit.PURPUR_PILLAR_WALL.get());
            dropSelf(BlockInit.PRISMARINE_BRICKS_WALL.get());
            dropSelf(BlockInit.DARK_PRISMARINE_WALL.get());
        }

        @Override
        protected Iterable<Block> getKnownBlocks() {
        	return BlockInit.BLOCKS.getEntries().stream().map(RegistryObject::get).toList();
        }
}