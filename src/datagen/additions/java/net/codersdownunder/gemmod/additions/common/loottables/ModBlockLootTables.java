package net.codersdownunder.gemmod.additions.common.loottables;

import net.codersdownunder.gemmod.additions.init.BlockInit;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;

import java.util.Set;


public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    @NotNull
    protected Iterable<Block> getKnownBlocks() {
        return BlockInit.BLOCKS.getEntries().stream().map(RegistryObject::get).toList();
    }
    
        @Override
        public void generate() {
            dropSelf(BlockInit.PURPUR_WALL.get());
            dropSelf(BlockInit.PURPUR_PILLAR_WALL.get());
            dropSelf(BlockInit.PRISMARINE_BRICKS_WALL.get());
            dropSelf(BlockInit.DARK_PRISMARINE_WALL.get());
        }
}