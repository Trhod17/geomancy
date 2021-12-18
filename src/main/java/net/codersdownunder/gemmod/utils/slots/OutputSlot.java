package net.codersdownunder.gemmod.utils.slots;

import net.minecraft.world.item.ItemStack;
import net.minecraftforge.items.IItemHandler;

public class OutputSlot extends GenericSlot {

	public OutputSlot(IItemHandler inventory, int index, int x, int y) {
		super(inventory, index, x, y);
	}
	
	@Override
	public boolean mayPlace(ItemStack stack) {
		return false;
	}
}
