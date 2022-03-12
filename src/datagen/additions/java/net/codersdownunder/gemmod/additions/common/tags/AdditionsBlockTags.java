package net.codersdownunder.gemmod.additions.common.tags;

import net.codersdownunder.gemmod.additions.Additions;
import net.codersdownunder.gemmod.additions.init.BlockInit;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.ExistingFileHelper;

public class AdditionsBlockTags extends BlockTagsProvider {

    public AdditionsBlockTags(DataGenerator generator, ExistingFileHelper helper) {
        super(generator, Additions.MODID, helper);
    }

    @Override
    protected void addTags() {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(BlockInit.DARK_PRISMARINE_WALL.get())
        		.add(BlockInit.PRISMARINE_BRICKS_WALL.get())
        		.add(BlockInit.PURPUR_PILLAR_WALL.get())
        		.add(BlockInit.PURPUR_WALL.get());
				
        tag(BlockTags.NEEDS_IRON_TOOL)
        	.add(BlockInit.DARK_PRISMARINE_WALL.get())
        	.add(BlockInit.PRISMARINE_BRICKS_WALL.get())
        	.add(BlockInit.PURPUR_PILLAR_WALL.get())
        	.add(BlockInit.PURPUR_WALL.get());
        
        tag(BlockTags.WALLS)
        .add(BlockInit.DARK_PRISMARINE_WALL.get())
    	.add(BlockInit.PRISMARINE_BRICKS_WALL.get())
    	.add(BlockInit.PURPUR_PILLAR_WALL.get())
    	.add(BlockInit.PURPUR_WALL.get());

    }

    @Override
    public String getName() {
        return "Geomancy Additions Tags";
    }
}