package net.codersdownunder.gemmod.utils.slots;

import net.codersdownunder.gemmod.utils.AutomatableItemStackHandler;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.items.SlotItemHandler;

import javax.annotation.Nonnull;
import java.util.List;

public class AutomatableSlot extends SlotItemHandler
{
    private AutomatableItemStackHandler handler;
    private List<Item> list;

    public AutomatableSlot(AutomatableItemStackHandler itemHandler, int index, int xPosition, int yPosition) {
        super(itemHandler, index, xPosition, yPosition);
        handler = itemHandler;
    }

    public AutomatableSlot(AutomatableItemStackHandler itemHandler, int index, int xPosition, int yPosition, List<Item> list) {
        this(itemHandler, index, xPosition, yPosition);
        this.list = list;
    }

    @Override
    public boolean mayPlace(@Nonnull ItemStack stack) {
        return handler.isItemValid(this.getSlotIndex(), stack, false) && (list == null || list.contains(stack.getItem()));
    }

    @Override
    public boolean mayPickup(Player playerIn) {
        return !this.handler.extractItem(this.getSlotIndex(), 1, true, false).isEmpty();
    }

    @Override
    @Nonnull
    public ItemStack remove(int amount) {
        return this.handler.extractItem(this.getSlotIndex(), amount, false, false);
    }
}
