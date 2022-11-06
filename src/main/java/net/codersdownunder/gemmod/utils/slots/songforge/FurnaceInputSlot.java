package net.codersdownunder.gemmod.utils.slots.songforge;

import net.codersdownunder.gemmod.blocks.songforge.SongForgeBlockEntity;
import net.codersdownunder.gemmod.utils.AutomatableItemStackHandler;
import net.codersdownunder.gemmod.utils.slots.AutomatableSlot;
import net.minecraft.world.item.ItemStack;

public class FurnaceInputSlot extends AutomatableSlot {

    private SongForgeBlockEntity be;

    public FurnaceInputSlot(SongForgeBlockEntity be, AutomatableItemStackHandler inventory, int index, int x, int y) {
        super(inventory, index, x, y);
        this.be = be;
    }

    @Override
    public boolean mayPlace(ItemStack stack) {

        return be.hasRecipe(stack);
    }

}
