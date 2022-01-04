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
        		.add(BlockInit.DREAM_CATCHER.get());
				
        tag(BlockTags.NEEDS_STONE_TOOL)
                .add(BlockInit.DIPPER.get())
        		.add(BlockInit.INFUSION_TABLE.get())
        		.add(BlockInit.END_LANTERN.get())
        		.add(BlockInit.END_LANTERN_BLOCK.get())
        		.add(BlockInit.MULMUS_LANTERN.get())
        		.add(BlockInit.MULMUS_LANTERN_POLISHED.get())
        		.add(BlockInit.TELEPAD.get())
        		.add(BlockInit.TELEPAD_SLAB.get())
        		.add(BlockInit.DREAM_CATCHER.get());
        
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
        		.add(BlockInit.CHASM_TRAPDOOR.get());
        
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
    }

    @Override
    public String getName() {
        return "Geomancy Tags";
    }
}