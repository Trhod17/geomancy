package net.codersdownunder.gemmod.server.tags;

import net.codersdownunder.gemmod.Geomancy;
import net.codersdownunder.gemmod.init.BlockInit;
import net.codersdownunder.gemmod.utils.GeomancyTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.concurrent.CompletableFuture;

public class GeomancyBlockTags extends BlockTagsProvider {

	public GeomancyBlockTags(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper)
	{
		super(output, lookupProvider, Geomancy.MODID, existingFileHelper);
	}

    @Override
	@NotNull
    public String getName() {
        return "Geomancy Block Tags";
    }

	@Override
	protected void addTags(final HolderLookup.Provider p_256380_) {
		tag(BlockTags.MINEABLE_WITH_PICKAXE)
				.add(BlockInit.DIPPER.get(),
				BlockInit.INFUSION_TABLE.get(),
				BlockInit.END_LANTERN.get(),
				BlockInit.END_LANTERN_BLOCK.get(),
				BlockInit.MULMUS_LANTERN.get(),
				BlockInit.MULMUS_LANTERN_POLISHED.get(),
				BlockInit.TELEPAD.get(),
				BlockInit.TELEPAD_SLAB.get(),
				BlockInit.DREAM_CATCHER.get(),
				BlockInit.SONG_FORGE.get(),
				BlockInit.TREADSTONE_1.get(),
				BlockInit.TREADSTONE_2.get(),
				BlockInit.TREADSTONE_3.get(),
				BlockInit.TREADSTONE_4.get(),
				BlockInit.TREADSTONE_5.get(),
				BlockInit.TREADSTONE_6.get(),
				BlockInit.TREADSTONE_7.get(),
				BlockInit.TREADSTONE_SLAB_1.get(),
				BlockInit.TREADSTONE_SLAB_2.get(),
				BlockInit.TREADSTONE_SLAB_3.get(),
				BlockInit.TREADSTONE_SLAB_4.get(),
				BlockInit.TREADSTONE_SLAB_5.get(),
				BlockInit.TREADSTONE_SLAB_6.get(),
				BlockInit.TREADSTONE_SLAB_7.get(),
				BlockInit.TREADSTONE_STAIR_1.get(),
				BlockInit.TREADSTONE_STAIR_2.get(),
				BlockInit.TREADSTONE_STAIR_3.get(),
				BlockInit.TREADSTONE_STAIR_4.get(),
				BlockInit.TREADSTONE_STAIR_5.get(),
				BlockInit.TREADSTONE_STAIR_6.get(),
				BlockInit.TREADSTONE_STAIR_7.get(),
				BlockInit.TREADSTONE_CARPET_1.get(),
				BlockInit.TREADSTONE_CARPET_2.get(),
				BlockInit.TREADSTONE_CARPET_3.get(),
				BlockInit.TREADSTONE_CARPET_4.get(),
				BlockInit.TREADSTONE_CARPET_5.get(),
				BlockInit.TREADSTONE_CARPET_6.get(),
				BlockInit.TREADSTONE_CARPET_7.get(),
				BlockInit.GEODE_ORE.get()
				);

		tag(BlockTags.NEEDS_IRON_TOOL)
				.add(BlockInit.GEODE_ORE.get());

		tag(BlockTags.NEEDS_STONE_TOOL)
				.add(BlockInit.DIPPER.get(),
				BlockInit.INFUSION_TABLE.get(),
				BlockInit.END_LANTERN.get(),
				BlockInit.END_LANTERN_BLOCK.get(),
				BlockInit.MULMUS_LANTERN.get(),
				BlockInit.MULMUS_LANTERN_POLISHED.get(),
				BlockInit.TELEPAD.get(),
				BlockInit.TELEPAD_SLAB.get(),
				BlockInit.DREAM_CATCHER.get(),
				BlockInit.SONG_FORGE.get()
				);

		tag(BlockTags.MINEABLE_WITH_AXE)
				.add(BlockInit.CHASM_BUTTON.get(),
				BlockInit.CHASM_DOOR.get(),
				BlockInit.CHASM_FENCE.get(),
				BlockInit.CHASM_FENCE_GATE.get(),
				BlockInit.CHASM_LOG.get(),
				BlockInit.CHASM_LOG_BARK.get(),
				BlockInit.CHASM_LOG_STRIPPED.get(),
				BlockInit.CHASM_LOG_STRIPPED_BARK.get(),
				BlockInit.CHASM_PLANKS.get(),
				BlockInit.CHASM_PLATE.get(),
				BlockInit.CHASM_SIGN.get(),
				BlockInit.CHASM_SIGN_WALL.get(),
				BlockInit.CHASM_SLAB.get(),
				BlockInit.CHASM_STAIRS.get(),
				BlockInit.CHASM_TRAPDOOR.get(),
				BlockInit.TRELLIS.get(),
				BlockInit.TRELLIS_CAVE_VINES.get(),
				BlockInit.TRELLIS_CHORUS.get(),
				BlockInit.TRELLIS_CRIMSON.get(),
				BlockInit.TRELLIS_LICHEN.get(),
				BlockInit.TRELLIS_VINE.get(),
				BlockInit.TRELLIS_MOSS.get(),
				BlockInit.TRELLIS_WARP.get()
				);

		tag(BlockTags.SAPLINGS)
				.add(BlockInit.CHASM_SAPLING.get());

		tag(BlockTags.LOGS)
				.add(BlockInit.CHASM_LOG.get(),
				BlockInit.CHASM_LOG_BARK.get(),
				BlockInit.CHASM_LOG_STRIPPED.get(),
				BlockInit.CHASM_LOG_STRIPPED_BARK.get()
				);

		tag(BlockTags.LOGS_THAT_BURN)
				.add(BlockInit.CHASM_LOG.get(),
				BlockInit.CHASM_LOG_BARK.get(),
				BlockInit.CHASM_LOG_STRIPPED.get(),
				BlockInit.CHASM_LOG_STRIPPED_BARK.get()
				);

		tag(BlockTags.PLANKS)
				.add(BlockInit.CHASM_PLANKS.get());

		tag(BlockTags.WOODEN_STAIRS)
				.add(BlockInit.CHASM_STAIRS.get());

		tag(BlockTags.WOODEN_SLABS)
				.add(BlockInit.CHASM_SLAB.get());

		tag(BlockTags.WOODEN_BUTTONS)
				.add(BlockInit.CHASM_BUTTON.get());

		tag(BlockTags.WOODEN_PRESSURE_PLATES)
				.add(BlockInit.CHASM_PLATE.get());

		tag(BlockTags.WOODEN_TRAPDOORS)
				.add(BlockInit.CHASM_TRAPDOOR.get());

		tag(BlockTags.WOODEN_DOORS)
				.add(BlockInit.CHASM_DOOR.get());

		tag(BlockTags.WOODEN_FENCES)
				.add(BlockInit.CHASM_FENCE.get());

		tag(BlockTags.FENCE_GATES)
				.add(BlockInit.CHASM_FENCE_GATE.get());

		tag(BlockTags.LEAVES)
				.add(BlockInit.CHASM_LEAVES.get());

		tag(BlockTags.SLABS)
				.add(BlockInit.TREADSTONE_SLAB_1.get(),
				BlockInit.TREADSTONE_SLAB_2.get(),
				BlockInit.TREADSTONE_SLAB_3.get(),
				BlockInit.TREADSTONE_SLAB_4.get(),
				BlockInit.TREADSTONE_SLAB_5.get(),
				BlockInit.TREADSTONE_SLAB_6.get(),
				BlockInit.TREADSTONE_SLAB_7.get()
				);

		tag(BlockTags.STAIRS)
				.add(BlockInit.TREADSTONE_STAIR_1.get(),
				BlockInit.TREADSTONE_STAIR_2.get(),
				BlockInit.TREADSTONE_STAIR_3.get(),
				BlockInit.TREADSTONE_STAIR_4.get(),
				BlockInit.TREADSTONE_STAIR_5.get(),
				BlockInit.TREADSTONE_STAIR_6.get(),
				BlockInit.TREADSTONE_STAIR_7.get()
				);

		tag(GeomancyTags.Blocks.CARPETS)
				.add(BlockInit.TREADSTONE_CARPET_1.get(),
				BlockInit.TREADSTONE_CARPET_2.get(),
				BlockInit.TREADSTONE_CARPET_3.get(),
				BlockInit.TREADSTONE_CARPET_4.get(),
				BlockInit.TREADSTONE_CARPET_5.get(),
				BlockInit.TREADSTONE_CARPET_6.get(),
				BlockInit.TREADSTONE_CARPET_7.get()
				);


		tag(BlockTags.CLIMBABLE)
				.add(BlockInit.TRELLIS.get(),
				BlockInit.TRELLIS_CAVE_VINES.get(),
				BlockInit.TRELLIS_CHORUS.get(),
				BlockInit.TRELLIS_CRIMSON.get(),
				BlockInit.TRELLIS_LICHEN.get(),
				BlockInit.TRELLIS_MOSS.get(),
				BlockInit.TRELLIS_VINE.get(),
				BlockInit.TRELLIS_WARP.get()
				);


	}
}