package net.codersdownunder.gemmod.common.loottables;

import com.mojang.datafixers.util.Pair;
import net.codersdownunder.gemmod.init.BlockInit;
import net.codersdownunder.gemmod.init.ItemInit;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.loot.BlockLoot;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.ValidationContext;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSet;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.predicates.MatchTool;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraftforge.registries.RegistryObject;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;

public class GeomancyLootTableProvider extends LootTableProvider
{
    public GeomancyLootTableProvider(DataGenerator generator) { super(generator); }

    @Override
    protected void validate(Map<ResourceLocation, LootTable> map, ValidationContext tracker) { /*NOOP*/ }

    @Override
    protected List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, LootTable.Builder>>>, LootContextParamSet>> getTables()
    {
        return Collections.singletonList(Pair.of(BlockLootTable::new, LootContextParamSets.BLOCK));
    }

    private static class BlockLootTable extends BlockLoot
    {
        @Override
        protected Iterable<Block> getKnownBlocks() {
            return BlockInit.BLOCKS.getEntries().stream().map(RegistryObject::get).toList();
        }
        @Override
        protected void addTables()
        {
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
            dropSelf(BlockInit.CHASM_SAPLING.get());
            dropSelf(BlockInit.END_LANTERN.get());
            dropSelf(BlockInit.END_LANTERN_BLOCK.get());
            dropSelf(BlockInit.MULMUS_LANTERN.get());
            dropSelf(BlockInit.MULMUS_LANTERN_POLISHED.get());
            dropSelf(BlockInit.DREAM_CATCHER.get());
            dropSelf(BlockInit.TELEPAD.get());
            dropSelf(BlockInit.TELEPAD_SLAB.get());
            dropSelf(BlockInit.TERRA_FIRMA.get());
            dropSelf(BlockInit.INFUSION_STAND.get());
            dropSelf(BlockInit.TREADSTONE_1.get());
            dropSelf(BlockInit.TREADSTONE_2.get());
            dropSelf(BlockInit.TREADSTONE_3.get());
            dropSelf(BlockInit.TREADSTONE_4.get());
            dropSelf(BlockInit.TREADSTONE_5.get());
            dropSelf(BlockInit.TREADSTONE_6.get());
            dropSelf(BlockInit.TREADSTONE_7.get());
            dropSelf(BlockInit.TREADSTONE_SLAB_1.get());
            dropSelf(BlockInit.TREADSTONE_SLAB_2.get());
            dropSelf(BlockInit.TREADSTONE_SLAB_3.get());
            dropSelf(BlockInit.TREADSTONE_SLAB_4.get());
            dropSelf(BlockInit.TREADSTONE_SLAB_5.get());
            dropSelf(BlockInit.TREADSTONE_SLAB_6.get());
            dropSelf(BlockInit.TREADSTONE_SLAB_7.get());
            dropSelf(BlockInit.TREADSTONE_STAIR_1.get());
            dropSelf(BlockInit.TREADSTONE_STAIR_2.get());
            dropSelf(BlockInit.TREADSTONE_STAIR_3.get());
            dropSelf(BlockInit.TREADSTONE_STAIR_4.get());
            dropSelf(BlockInit.TREADSTONE_STAIR_5.get());
            dropSelf(BlockInit.TREADSTONE_STAIR_6.get());
            dropSelf(BlockInit.TREADSTONE_STAIR_7.get());
            dropSelf(BlockInit.TREADSTONE_CARPET_1.get());
            dropSelf(BlockInit.TREADSTONE_CARPET_2.get());
            dropSelf(BlockInit.TREADSTONE_CARPET_3.get());
            dropSelf(BlockInit.TREADSTONE_CARPET_4.get());
            dropSelf(BlockInit.TREADSTONE_CARPET_5.get());
            dropSelf(BlockInit.TREADSTONE_CARPET_6.get());
            dropSelf(BlockInit.TREADSTONE_CARPET_7.get());

            dropSelf(BlockInit.TRELLIS.get());

            dropOther(BlockInit.TRELLIS_CAVE_VINES.get(), BlockInit.TRELLIS.get());
            dropOther(BlockInit.TRELLIS_CRIMSON.get(), BlockInit.TRELLIS.get());
            dropOther(BlockInit.TRELLIS_CHORUS.get(), BlockInit.TRELLIS.get());
            dropOther(BlockInit.TRELLIS_LICHEN.get(), BlockInit.TRELLIS.get());
            dropOther(BlockInit.TRELLIS_MOSS.get(), BlockInit.TRELLIS.get());
            dropOther(BlockInit.TRELLIS_VINE.get(), BlockInit.TRELLIS.get());
            dropOther(BlockInit.TRELLIS_WARP.get(), BlockInit.TRELLIS.get());

            dropOther(BlockInit.CHASM_SIGN_WALL.get(), BlockInit.CHASM_SIGN.get());
            add(BlockInit.GEODE_ORE.get(), createOreDrop(BlockInit.GEODE_ORE.get(), ItemInit.GEODE.get()));
            add(BlockInit.CHASM_LEAVES.get(), createLeavesDrops(BlockInit.CHASM_LEAVES.get(), BlockInit.CHASM_SAPLING.get(), 0.1f));
            add(BlockInit.CHASM_DOOR.get(), createDoorTable(BlockInit.CHASM_DOOR.get()));
            add(BlockInit.INFUSION_TABLE.get(), createNameableBlockEntityTable(BlockInit.INFUSION_TABLE.get()));
            add(BlockInit.DIPPER.get(), createNameableBlockEntityTable(BlockInit.DIPPER.get()));
            add(BlockInit.CHASM_SLAB.get(), createSlabItemTable(BlockInit.CHASM_SLAB.get()));
            add(BlockInit.SONG_FORGE.get(), createNameableBlockEntityTable(BlockInit.SONG_FORGE.get()));

            //TODO: Covert to mcjtys system for loottables
            add(BlockInit.TRELLIS_VINE.get(), createShearsOnlyDrop(Items.VINE));
            add(BlockInit.TRELLIS_CAVE_VINES.get(), createShearsOnlyDrop(Items.GLOW_BERRIES));
            add(BlockInit.TRELLIS_CRIMSON.get(), createShearsOnlyDrop(Items.WEEPING_VINES));
            add(BlockInit.TRELLIS_CHORUS.get(), createShearsOnlyDrop(Items.CHORUS_FRUIT));
            add(BlockInit.TRELLIS_LICHEN.get(), createShearsOnlyDrop(Items.GLOW_LICHEN));
            add(BlockInit.TRELLIS_MOSS.get(), createShearsOnlyDrop(Items.MOSS_BLOCK));
            add(BlockInit.TRELLIS_WARP.get(), createShearsOnlyDrop(Items.TWISTING_VINES));
        }
    }
}
