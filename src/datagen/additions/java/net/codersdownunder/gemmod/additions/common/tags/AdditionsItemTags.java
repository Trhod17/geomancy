package net.codersdownunder.gemmod.additions.common.tags;

import net.codersdownunder.gemmod.Geomancy;
import net.codersdownunder.gemmod.additions.init.BlockItemInit;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraftforge.common.data.ExistingFileHelper;

public class AdditionsItemTags extends ItemTagsProvider {

    public AdditionsItemTags(DataGenerator generator, BlockTagsProvider blockTags, ExistingFileHelper helper) {
        super(generator, blockTags, Geomancy.MODID, helper);
    }

    @Override
    protected void addTags() {
    	tag(ItemTags.WALLS)
        .add(BlockItemInit.DARK_PRISMARINE_WALL.get())
    	.add(BlockItemInit.PRISMARINE_BRICKS_WALL.get())
    	.add(BlockItemInit.PURPUR_PILLAR_WALL.get())
    	.add(BlockItemInit.PURPUR_WALL.get());

    }

    @Override
    public String getName() {
        return "Geomancy Tags";
    }
}