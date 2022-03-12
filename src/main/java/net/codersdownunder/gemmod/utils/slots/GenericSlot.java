package net.codersdownunder.gemmod.utils.slots;

import net.minecraft.world.item.ItemStack;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

public class GenericSlot extends SlotItemHandler {

    public GenericSlot(IItemHandler inventory, int index, int x, int y) {
    	super(inventory, index, x, y);
    }

    @Override
    public boolean mayPlace(ItemStack stack) {
	return stack != null && container.canPlaceItem(getSlotIndex(), stack);
    }
    
//    @Override
//    public void setChanged() {
//    	tile.setChanged();
//    }

}
