package net.codersdownunder.gemmod.utils.slots;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.items.IItemHandler;

public class FuelSlot extends GenericSlot {

    public FuelSlot(IItemHandler inventory, int index, int x, int y) {
    	super(inventory, index, x, y);
    }

    @Override
    public boolean mayPlace(ItemStack stack) {
	return stack != null && container.canPlaceItem(getSlotIndex(), stack) && isFuel(stack);
    }


    protected boolean isFuel(ItemStack pStack) {
        return ForgeHooks.getBurnTime(pStack, RecipeType.SMELTING) > 0;
     }
    
    
    
//    @Override
//    public void setChanged() {
//    	tile.setChanged();
//    }

}
