package net.codersdownunder.gemmod.server.loottables;

import com.mojang.datafixers.kinds.Const;
import com.mojang.datafixers.util.Pair;
import net.codersdownunder.gemmod.init.BlockInit;
import net.codersdownunder.gemmod.init.ItemInit;
import net.minecraft.advancements.critereon.EnchantmentPredicate;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.advancements.critereon.MinMaxBounds;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.loot.BlockLoot;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.state.properties.SlabType;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.ValidationContext;
import net.minecraft.world.level.storage.loot.entries.AlternativesEntry;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.ApplyExplosionDecay;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSet;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.predicates.*;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.common.Tags;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.function.*;

public class GeomancyLootTableProvider extends LootTableProvider {
    public GeomancyLootTableProvider(DataGenerator generator) {
        super(generator);
    }

    @Override
    protected void validate(Map<ResourceLocation, LootTable> map, ValidationContext tracker) { /*NOOP*/ }

    @Override
    protected List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, LootTable.Builder>>>, LootContextParamSet>> getTables() {
        return Collections.singletonList(Pair.of(BlockLootTable::new, LootContextParamSets.BLOCK));
    }


    private static class BlockLootTable extends BlockLoot {
        @Override
        protected Iterable<Block> getKnownBlocks() {
            return BlockInit.BLOCKS.getEntries().stream().map(RegistryObject::get).toList();
        }

        @Override
        protected void addTables() {
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

            dropOther(BlockInit.CHASM_SIGN_WALL.get(), BlockInit.CHASM_SIGN.get());
            add(BlockInit.GEODE_ORE.get(), createGeodeOreTable(BlockInit.GEODE_ORE.get(),
                    ItemInit.GEODE.get(), 2, 4,
                    ItemInit.RICH_GEODE.get(), 0, 2,
                    ItemInit.SPARSE_GEODE.get(), 4, 6));
//            add(BlockInit.GEODE_ORE.get(), createSilkTouchTable(BlockInit.GEODE_ORE.get(),
//                    ItemInit.GEODE.get(),
//                    ItemInit.RICH_GEODE.get(),
//                    ItemInit.SPARSE_GEODE.get(), 1f, 2f));
            add(BlockInit.CHASM_LEAVES.get(), createLeavesDrops(BlockInit.CHASM_LEAVES.get(), BlockInit.CHASM_SAPLING.get(), 0.1f));
            add(BlockInit.CHASM_DOOR.get(), createDoorTable(BlockInit.CHASM_DOOR.get()));
            add(BlockInit.INFUSION_TABLE.get(), createNameableBlockEntityTable(BlockInit.INFUSION_TABLE.get()));
            add(BlockInit.DIPPER.get(), createNameableBlockEntityTable(BlockInit.DIPPER.get()));
            add(BlockInit.CHASM_SLAB.get(), createSlabItemTable(BlockInit.CHASM_SLAB.get()));
            add(BlockInit.SONG_FORGE.get(), createNameableBlockEntityTable(BlockInit.SONG_FORGE.get()));


            add(BlockInit.TRELLIS_VINE.get(), createTrellisDrop(BlockInit.TRELLIS_VINE.get(), Items.VINE, BlockInit.TRELLIS.get().asItem()));
            add(BlockInit.TRELLIS_CAVE_VINES.get(), createTrellisDrop(BlockInit.TRELLIS_CAVE_VINES.get(), Items.GLOW_BERRIES, BlockInit.TRELLIS.get().asItem()));
            add(BlockInit.TRELLIS_CRIMSON.get(), createTrellisDrop(BlockInit.TRELLIS_CRIMSON.get(), Items.WEEPING_VINES, BlockInit.TRELLIS.get().asItem()));
            add(BlockInit.TRELLIS_CHORUS.get(), createTrellisDrop(BlockInit.TRELLIS_CHORUS.get(), Items.CHORUS_FRUIT, BlockInit.TRELLIS.get().asItem()));
            add(BlockInit.TRELLIS_LICHEN.get(), createTrellisDrop(BlockInit.TRELLIS_LICHEN.get(), Items.GLOW_LICHEN, BlockInit.TRELLIS.get().asItem()));
            add(BlockInit.TRELLIS_MOSS.get(), createTrellisDrop(BlockInit.TRELLIS_MOSS.get(), Items.MOSS_BLOCK, BlockInit.TRELLIS.get().asItem()));
            add(BlockInit.TRELLIS_WARP.get(), createTrellisDrop(BlockInit.TRELLIS_WARP.get(), Items.TWISTING_VINES, BlockInit.TRELLIS.get().asItem()));

            dropSelf(BlockInit.END_TORCH.get());
            dropOther(BlockInit.WALL_END_TORCH.get(), BlockInit.END_TORCH.get());

            add(BlockInit.HEALING_WATER_BLOCK.get(), noDrop());
            //add(BlockInit.SCORCH.get(), noDrop());
            dropSelf(BlockInit.INFINITE_SOURCE_WATER.get());
        }

        protected static LootTable.Builder createTrellisDrop(Block block, Item dropItem, Item trellis) {
            LootPool.Builder builder = LootPool.lootPool()
                    .name(block.getName().toString())
                    .setRolls(ConstantValue.exactly(1))
                    .add(LootItem.lootTableItem(dropItem)
                            .apply(ApplyBonusCount.addBonusBinomialDistributionCount(Enchantments.BLOCK_FORTUNE, 0.5714286F, 1))
                            .when(MatchTool.toolMatches(ItemPredicate.Builder.item().of(Tags.Items.SHEARS)))
                            .otherwise(LootItem.lootTableItem(trellis).apply(ApplyExplosionDecay.explosionDecay()))
                    );

            return LootTable.lootTable().withPool(builder);
        }

        private static String getBlockName(Block block) {
            return ForgeRegistries.BLOCKS.getKey(block).getPath();
        }

        protected LootTable.Builder createGeodeOreTable(Block block, Item lootItem, float min, float max,
                                                        Item lootItem2, float min2, float max2, Item lootItem3, float min3, float max3) {

            LootPool.Builder builder = LootPool.lootPool()
                    .name(getBlockName(block))
                    .setRolls(ConstantValue.exactly(1))
                    .add(AlternativesEntry.alternatives(
                                            LootItem.lootTableItem(block)
                                                    .when(MatchTool.toolMatches(ItemPredicate.Builder.item()
                                                            .hasEnchantment(new EnchantmentPredicate(Enchantments.SILK_TOUCH, MinMaxBounds.Ints.atLeast(1)))))

                                    ).otherwise(
                                            LootItem.lootTableItem(lootItem)
                                                    .when(LootItemRandomChanceCondition.randomChance(0.3f))
                                                    .apply(SetItemCountFunction.setCount(UniformGenerator.between(min, max)))
                                                    .apply(ApplyBonusCount.addUniformBonusCount(Enchantments.BLOCK_FORTUNE, 1))
                                                    .apply(ApplyExplosionDecay.explosionDecay())
                                    ).append(
                                            LootItem.lootTableItem(lootItem2)
                                                    .when(LootItemRandomChanceCondition.randomChance(0.1f))
                                                    .apply(SetItemCountFunction.setCount(UniformGenerator.between(min2, max2)))
                                                    .apply(ApplyBonusCount.addUniformBonusCount(Enchantments.BLOCK_FORTUNE, 1))
                                                    .apply(ApplyExplosionDecay.explosionDecay()))
                                    .append(
                                            LootItem.lootTableItem(lootItem3)
                                                    .when(LootItemRandomChanceCondition.randomChance(0.6f))
                                                    .apply(SetItemCountFunction.setCount(UniformGenerator.between(min3, max3)))
                                                    .apply(ApplyBonusCount.addUniformBonusCount(Enchantments.BLOCK_FORTUNE, 1))
                                                    .apply(ApplyExplosionDecay.explosionDecay()))
                    );
            return LootTable.lootTable().withPool(builder);
        }

        @NotNull
        protected static LootTable.Builder createSlabItemTable(Block slab) {
            return LootTable.lootTable().withPool(LootPool.lootPool()
                    .name(getBlockName(slab))
                    .setRolls(ConstantValue.exactly(1))
                    .add(applyExplosionDecay(slab, LootItem.lootTableItem(slab)
                                    .apply(SetItemCountFunction.setCount(ConstantValue.exactly(2))
                                            .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(slab)
                                                    .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(SlabBlock.TYPE, SlabType.DOUBLE)))
                                    )
                            )
                    )
            );
        }

    }

}
