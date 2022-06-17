package net.codersdownunder.gemmod.utils.slots;

import net.codersdownunder.gemmod.utils.AutomatableItemStackHandler;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraftforge.common.ForgeHooks;

public class FuelSlot extends AutomatableSlot {

    public FuelSlot(AutomatableItemStackHandler inventory, int index, int x, int y) {
    	super(inventory, index, x, y);
    }

    @Override
    public boolean mayPlace(ItemStack stack) {
	return stack != null && isFuel(stack);
    }


    protected boolean isFuel(ItemStack pStack) {
        return ForgeHooks.getBurnTime(pStack, RecipeType.SMELTING) > 0;
     }
    
}
