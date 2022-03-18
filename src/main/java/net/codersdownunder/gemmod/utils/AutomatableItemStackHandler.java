package net.codersdownunder.gemmod.utils;

import net.minecraft.world.item.ItemStack;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;

public class AutomatableItemStackHandler extends ItemStackHandler {
    public AutomatableItemStackHandler(int size) {
        super(size);
    }

    public boolean isInputSlot(int slot) {
        return true;
    }

    public boolean isInsertableSlot(int slot) {
        return isInputSlot(slot);
    }

    public boolean isInputSlotItem(int slot, ItemStack stack) {
        return true;
    }

    @Override
    public boolean isItemValid(int slot, @Nonnull ItemStack stack) {
        return isItemValid(slot, stack, true);
    }

    public boolean isItemValid(int slot, @Nonnull ItemStack stack, boolean fromAutomation) {
        // Always allow an input item into an input slot
        if (isInputSlotItem(slot, stack)) {
            return true;
        }

        return !fromAutomation && isInsertableSlot(slot);
    }

    @Nonnull
    @Override
    public ItemStack extractItem(int slot, int amount, boolean simulate) {
        return extractItem(slot, amount, simulate, true);
    }

    @Nonnull
    public ItemStack extractItem(int slot, int amount, boolean simulate, boolean fromAutomation) {
        // Do not extract from input slots
        if (fromAutomation && isInputSlot(slot)) {
            return ItemStack.EMPTY;
        }
        return super.extractItem(slot, amount, simulate);
    }

    @NotNull
    @Override
    public ItemStack insertItem(int slot, @NotNull ItemStack stack, boolean simulate) {
        return super.insertItem(slot, stack, simulate);
    }
}
