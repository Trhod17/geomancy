package net.codersdownunder.gemmod.common.loottables;

import java.util.stream.Collectors;

import net.codersdownunder.gemmod.GemMod;
import net.codersdownunder.gemmod.init.BlockInit;
import net.codersdownunder.gemmod.init.ItemInit;
import net.minecraft.data.loot.BlockLoot;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.registries.ForgeRegistries;


public class ModBlockLootTables extends BlockLoot {
    
        @Override
        public void addTables() {
            dropSelf(BlockInit.CHASM_BUTTON.get());
            dropSelf(BlockInit.CHASM_FENCE.get());
            dropSelf(BlockInit.CHASM_FENCE_GATE.get());
            dropSelf(BlockInit.CHASM_LOG.get());
            dropSelf(BlockInit.CHASM_LOG_BARK.get());
            dropSelf(BlockInit.CHASM_LOG_STRIPPED.get());
            dropSelf(BlockInit.CHASM_LOG_STRIPPED_BARK.get());
            dropSelf(BlockInit.CHASM_PLANKS.get());
            dropSelf(BlockInit.CHASM_PLATE.get());
            dropSelf(BlockInit.CHASM_SIGN.get());
            dropSelf(BlockInit.CHASM_STAIRS.get());
            dropSelf(BlockInit.CHASM_TRAPDOOR.get());
            dropSelf(BlockInit.END_LANTERN.get());
            dropSelf(BlockInit.END_LANTERN_BLOCK.get());
            dropSelf(BlockInit.MULMUS_LANTERN.get());
            dropSelf(BlockInit.MULMUS_LANTERN_POLISHED.get());
            dropSelf(BlockInit.DREAM_CATCHER.get());
            dropSelf(BlockInit.TELEPAD.get());
            dropSelf(BlockInit.TELEPAD_SLAB.get());
            dropOther(BlockInit.CHASM_SIGN_WALL.get(), BlockInit.CHASM_SIGN.get());
            add(BlockInit.GEODE_ORE.get(), createOreDrop(BlockInit.GEODE_ORE.get(), ItemInit.GEODE.get()));
            add(BlockInit.CHASM_LEAVES.get(), createLeavesDrops(BlockInit.CHASM_LEAVES.get(), Blocks.OAK_SAPLING, 0.1f));
            add(BlockInit.CHASM_DOOR.get(), createDoorTable(BlockInit.CHASM_DOOR.get()));
            add(BlockInit.INFUSION_TABLE.get(), createNameableBlockEntityTable(BlockInit.INFUSION_TABLE.get()));
            add(BlockInit.DIPPER.get(), createNameableBlockEntityTable(BlockInit.DIPPER.get()));
            add(BlockInit.CHASM_SLAB.get(), createSlabItemTable(BlockInit.CHASM_SLAB.get()));

        }

        @Override
        protected Iterable<Block> getKnownBlocks() {
            return ForgeRegistries.BLOCKS.getValues().stream()
                    .filter(block -> GemMod.MODID.equals(block.getRegistryName().getNamespace()))
                    .collect(Collectors.toSet());
        }
}