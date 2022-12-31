package net.codersdownunder.gemmod.additions.common.tags;

import net.codersdownunder.gemmod.additions.Additions;
import net.codersdownunder.gemmod.additions.init.BlockItemInit;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

import javax.annotation.Nullable;
import java.util.concurrent.CompletableFuture;

public class AdditionsItemTags extends ItemTagsProvider {

    public AdditionsItemTags(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, BlockTagsProvider provider, @Nullable ExistingFileHelper existingFileHelper)
    {
        super(output, lookupProvider, provider, Additions.MODID, existingFileHelper);
    }
    @Override
    protected void addTags(HolderLookup.Provider p_256380_) {
    	tag(ItemTags.WALLS)
        .add(BlockItemInit.DARK_PRISMARINE_WALL.get())
    	.add(BlockItemInit.PRISMARINE_BRICKS_WALL.get())
    	.add(BlockItemInit.PURPUR_PILLAR_WALL.get())
    	.add(BlockItemInit.PURPUR_WALL.get());

    }

    @Override
    public String getName() {
        return "Geomancy Additions Item Tags";
    }
}