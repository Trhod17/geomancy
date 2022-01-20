package net.codersdownunder.gemmod.common.tags;

import net.codersdownunder.gemmod.GemMod;
import net.codersdownunder.gemmod.init.BlockInit;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.ExistingFileHelper;

public class GeomancyBlockTags extends BlockTagsProvider {

    public GeomancyBlockTags(DataGenerator generator, ExistingFileHelper helper) {
        super(generator, GemMod.MODID, helper);
    }

    @Override
    protected void addTags() {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(BlockInit.DIPPER.get())
        		.add(BlockInit.INFUSION_TABLE.get())
        		.add(BlockInit.END_LANTERN.get())
        		.add(BlockInit.END_LANTERN_BLOCK.get())
        		.add(BlockInit.MULMUS_LANTERN.get())
        		.add(BlockInit.MULMUS_LANTERN_POLISHED.get())
        		.add(BlockInit.TELEPAD.get())
        		.add(BlockInit.TELEPAD_SLAB.get())
        		.add(BlockInit.DREAM_CATCHER.get())
        		.add(BlockInit.SONG_FORGE.get())
        		.add(BlockInit.TREADSTONE_1.get())
        		.add(BlockInit.TREADSTONE_2.get())
        		.add(BlockInit.TREADSTONE_3.get())
        		.add(BlockInit.TREADSTONE_4.get())
        		.add(BlockInit.TREADSTONE_5.get())
        		.add(BlockInit.TREADSTONE_6.get())
        		.add(BlockInit.TREADSTONE_7.get())
        		.add(BlockInit.TREADSTONE_SLAB_1.get())
        		.add(BlockInit.TREADSTONE_SLAB_2.get())
        		.add(BlockInit.TREADSTONE_SLAB_3.get())
        		.add(BlockInit.TREADSTONE_SLAB_4.get())
        		.add(BlockInit.TREADSTONE_SLAB_5.get())
        		.add(BlockInit.TREADSTONE_SLAB_6.get())
        		.add(BlockInit.TREADSTONE_SLAB_7.get())
        		.add(BlockInit.TREADSTONE_STAIR_1.get())
        		.add(BlockInit.TREADSTONE_STAIR_2.get())
        		.add(BlockInit.TREADSTONE_STAIR_3.get())
        		.add(BlockInit.TREADSTONE_STAIR_4.get())
        		.add(BlockInit.TREADSTONE_STAIR_5.get())
        		.add(BlockInit.TREADSTONE_STAIR_6.get())
        		.add(BlockInit.TREADSTONE_STAIR_7.get())
        		.add(BlockInit.TREADSTONE_CARPET_1.get())
        		.add(BlockInit.TREADSTONE_CARPET_2.get())
        		.add(BlockInit.TREADSTONE_CARPET_3.get())
        		.add(BlockInit.TREADSTONE_CARPET_4.get())
        		.add(BlockInit.TREADSTONE_CARPET_5.get())
        		.add(BlockInit.TREADSTONE_CARPET_6.get())
        		.add(BlockInit.TREADSTONE_CARPET_7.get());
        		
        		
        tag(BlockTags.NEEDS_STONE_TOOL)
                .add(BlockInit.DIPPER.get())
        		.add(BlockInit.INFUSION_TABLE.get())
        		.add(BlockInit.END_LANTERN.get())
        		.add(BlockInit.END_LANTERN_BLOCK.get())
        		.add(BlockInit.MULMUS_LANTERN.get())
        		.add(BlockInit.MULMUS_LANTERN_POLISHED.get())
        		.add(BlockInit.TELEPAD.get())
        		.add(BlockInit.TELEPAD_SLAB.get())
        		.add(BlockInit.DREAM_CATCHER.get())
        		.add(BlockInit.SONG_FORGE.get());
        
        tag(BlockTags.MINEABLE_WITH_AXE)
        		.add(BlockInit.CHASM_BUTTON.get())
        		.add(BlockInit.CHASM_DOOR.get())
        		.add(BlockInit.CHASM_FENCE.get())
        		.add(BlockInit.CHASM_FENCE_GATE.get())
        		.add(BlockInit.CHASM_LOG.get())
        		.add(BlockInit.CHASM_LOG_BARK.get())
        		.add(BlockInit.CHASM_LOG_STRIPPED.get())
        		.add(BlockInit.CHASM_LOG_STRIPPED_BARK.get())
        		.add(BlockInit.CHASM_PLANKS.get())
        		.add(BlockInit.CHASM_PLATE.get())
        		.add(BlockInit.CHASM_SIGN.get())
        		.add(BlockInit.CHASM_SIGN_WALL.get())
        		.add(BlockInit.CHASM_SLAB.get())
        		.add(BlockInit.CHASM_STAIRS.get())
        		.add(BlockInit.CHASM_TRAPDOOR.get())
        		.add(BlockInit.TRELLIS.get())
        		.add(BlockInit.TRELLIS_CAVE_VINES.get())
        		.add(BlockInit.TRELLIS_CHORUS.get())
        		.add(BlockInit.TRELLIS_CRIMSON.get())
        		.add(BlockInit.TRELLIS_LICHEN.get())
        		.add(BlockInit.TRELLIS_VINE.get())
        		.add(BlockInit.TRELLIS_MOSS.get())
        		.add(BlockInit.TRELLIS_WARP.get());
        
        tag(BlockTags.LOGS)
        		.add(BlockInit.CHASM_LOG.get())
        		.add(BlockInit.CHASM_LOG_BARK.get())
        		.add(BlockInit.CHASM_LOG_STRIPPED.get())
        		.add(BlockInit.CHASM_LOG_STRIPPED_BARK.get());
        		
        tag(BlockTags.LOGS_THAT_BURN)
        		.add(BlockInit.CHASM_LOG.get())
        		.add(BlockInit.CHASM_LOG_BARK.get())
        		.add(BlockInit.CHASM_LOG_STRIPPED.get())
        		.add(BlockInit.CHASM_LOG_STRIPPED_BARK.get());
        
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
        .add(BlockInit.TREADSTONE_SLAB_1.get())
        .add(BlockInit.TREADSTONE_SLAB_2.get())
        .add(BlockInit.TREADSTONE_SLAB_3.get())
        .add(BlockInit.TREADSTONE_SLAB_4.get())
        .add(BlockInit.TREADSTONE_SLAB_5.get())
        .add(BlockInit.TREADSTONE_SLAB_6.get())
        .add(BlockInit.TREADSTONE_SLAB_7.get());
        
        tag(BlockTags.STAIRS)
        .add(BlockInit.TREADSTONE_STAIR_1.get())
        .add(BlockInit.TREADSTONE_STAIR_2.get())
        .add(BlockInit.TREADSTONE_STAIR_3.get())
        .add(BlockInit.TREADSTONE_STAIR_4.get())
        .add(BlockInit.TREADSTONE_STAIR_5.get())
        .add(BlockInit.TREADSTONE_STAIR_6.get())
        .add(BlockInit.TREADSTONE_STAIR_7.get());
        
        tag(BlockTags.CARPETS)
        .add(BlockInit.TREADSTONE_CARPET_1.get())
        .add(BlockInit.TREADSTONE_CARPET_2.get())
        .add(BlockInit.TREADSTONE_CARPET_3.get())
        .add(BlockInit.TREADSTONE_CARPET_4.get())
        .add(BlockInit.TREADSTONE_CARPET_5.get())
        .add(BlockInit.TREADSTONE_CARPET_6.get())
        .add(BlockInit.TREADSTONE_CARPET_7.get());
        
        
        tag(BlockTags.CLIMBABLE)
        	.add(BlockInit.TRELLIS.get())
        	.add(BlockInit.TRELLIS_CAVE_VINES.get())
        	.add(BlockInit.TRELLIS_CHORUS.get())
        	.add(BlockInit.TRELLIS_CRIMSON.get())
        	.add(BlockInit.TRELLIS_LICHEN.get())
        	.add(BlockInit.TRELLIS_MOSS.get())
        	.add(BlockInit.TRELLIS_VINE.get())
        	.add(BlockInit.TRELLIS_WARP.get());
    }

    @Override
    public String getName() {
        return "Geomancy Tags";
    }
}