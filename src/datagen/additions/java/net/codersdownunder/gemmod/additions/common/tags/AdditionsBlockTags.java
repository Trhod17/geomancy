package net.codersdownunder.gemmod.additions.common.tags;

import net.codersdownunder.gemmod.additions.Additions;
import net.codersdownunder.gemmod.additions.init.BlockInit;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.concurrent.CompletableFuture;

public class AdditionsBlockTags extends BlockTagsProvider {

    public AdditionsBlockTags(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper)
    {
        super(output, lookupProvider, Additions.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider p_256380_) {
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
    @NotNull
    public String getName() {
        return "Geomancy Additions Block Tags";
    }
}