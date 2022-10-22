package net.codersdownunder.gemmod.utils.slots;

import net.codersdownunder.gemmod.utils.AutomatableItemStackHandler;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.items.IItemHandler;

public class OutputSlot extends AutomatableSlot {

	public OutputSlot(AutomatableItemStackHandler inventory, int index, int x, int y) {
		super(inventory, index, x, y);
		
	}
	
	@Override
	public boolean mayPlace(ItemStack stack) {
		return false;
	}
}
