package net.codersdownunder.gemmod.additions.common.loottables;

import java.util.stream.Collectors;

import net.codersdownunder.gemmod.additions.Additions;
import net.codersdownunder.gemmod.additions.init.BlockInit;
import net.minecraft.data.loot.BlockLoot;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.ForgeRegistries;


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
            return ForgeRegistries.BLOCKS.getValues().stream()
                    .filter(block -> Additions.MODID.equals(block.getName()))
                    .collect(Collectors.toSet());
        }
}