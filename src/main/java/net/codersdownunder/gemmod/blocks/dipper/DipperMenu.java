package net.codersdownunder.gemmod.blocks.dipper;

import net.codersdownunder.gemmod.init.BlockInit;
import net.codersdownunder.gemmod.init.MenuInit;
import net.codersdownunder.gemmod.utils.AutomatableItemStackHandler;
import net.codersdownunder.gemmod.utils.GeomancyTags;
import net.codersdownunder.gemmod.utils.TagUtils;
import net.codersdownunder.gemmod.utils.slots.AutomatableSlot;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;
import net.minecraftforge.items.wrapper.InvWrapper;

public class DipperMenu extends AbstractContainerMenu {

    private BlockEntity blockEntity;
    private Player playerEntity;
    private IItemHandler playerInventory;

    public DipperBlockEntity tile;

    public int counter;

    public static final int PLAYER_INVENTORY_XPOS = 8;
    public static final int PLAYER_INVENTORY_YPOS = 140;

    private static final int CONTAINER_SIZE = 22;

    public static final int[] INPUT_SLOTS = new int[]{2, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17};
    public static final int[] STRING_SLOTS = new int[]{0, 1, 3};
    public static final int QUARTZ_SLOT = 2;
    public static final int OUTPUT_SLOT = 22;
    public static final int CONCOCTION_1_SLOT = 21;
    public static final int CONCOCTION_2_SLOT = 20;
    public static final int CONCOCTION_3_SLOT = 19;
    public static final int CONCOCTION_4_SLOT = 18;

    public DipperMenu(int windowId, Level world, BlockPos pos, Inventory playerInventory, Player player, DipperBlockEntity tile) {
        super(MenuInit.DIPPER_CONTAINER.get(), windowId);
        blockEntity = world.getBlockEntity(pos);
        this.playerEntity = player;
        this.playerInventory = new InvWrapper(playerInventory);
        this.tile = tile;

        if (blockEntity != null) {
            blockEntity.getCapability(ForgeCapabilities.ITEM_HANDLER).ifPresent(handler -> {
                if (handler instanceof AutomatableItemStackHandler h) {
                    //center line
                    addSlot(new AutomatableSlot(h, STRING_SLOTS[0], 80, 18, TagUtils.getValues(GeomancyTags.Items.STRING)));
                    addSlot(new AutomatableSlot(h, STRING_SLOTS[1], 80, 36, TagUtils.getValues(GeomancyTags.Items.STRING)));
                    addSlot(new AutomatableSlot(h, QUARTZ_SLOT, 80, 54));
                    addSlot(new AutomatableSlot(h, STRING_SLOTS[2], 80, 72, TagUtils.getValues(GeomancyTags.Items.STRING)));
                    addSlot(new AutomatableSlot(h, 4, 80, 90));
                    addSlot(new AutomatableSlot(h, 5, 80, 108));
                    //center left
                    addSlot(new AutomatableSlot(h, 6, 62, 36));
                    addSlot(new AutomatableSlot(h, 7, 62, 54));
                    addSlot(new AutomatableSlot(h, 8, 62, 72));
                    //left
                    addSlot(new AutomatableSlot(h, 9, 44, 54));
                    addSlot(new AutomatableSlot(h, 10, 44, 72));
                    addSlot(new AutomatableSlot(h, 11, 44, 90));
                    //center right
                    addSlot(new AutomatableSlot(h, 12, 98, 54));
                    addSlot(new AutomatableSlot(h, 13, 98, 72));
                    addSlot(new AutomatableSlot(h, 14, 98, 36));
                    //right
                    addSlot(new AutomatableSlot(h, 15, 116, 54));
                    addSlot(new AutomatableSlot(h, 16, 116, 72));
                    addSlot(new AutomatableSlot(h, 17, 116, 90));
                    //concoctions
                    addSlot(new AutomatableSlot(h, CONCOCTION_4_SLOT, 8, 54, TagUtils.getValues(GeomancyTags.Items.CONCOCTIONS_TIER_4)));
                    addSlot(new AutomatableSlot(h, CONCOCTION_3_SLOT, 8, 72, TagUtils.getValues(GeomancyTags.Items.CONCOCTIONS_TIER_3)));
                    addSlot(new AutomatableSlot(h, CONCOCTION_2_SLOT, 8, 90, TagUtils.getValues(GeomancyTags.Items.CONCOCTIONS_TIER_2)));
                    addSlot(new AutomatableSlot(h, CONCOCTION_1_SLOT, 8, 108, TagUtils.getValues(GeomancyTags.Items.CONCOCTIONS_TIER_1)));
                    //output
                    addSlot(new AutomatableSlot(h, OUTPUT_SLOT, 152, 54));
                }
            });
        }

        layoutPlayerInventorySlots(PLAYER_INVENTORY_XPOS, PLAYER_INVENTORY_YPOS);
    }

    public ItemStack quickMoveStack(Player pPlayer, int pIndex) {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = this.slots.get(pIndex);
        if (slot.hasItem()) {
            ItemStack itemstack1 = slot.getItem();
            itemstack = itemstack1.copy();
            if (pIndex < DipperMenu.CONTAINER_SIZE) {
                if (!this.moveItemStackTo(itemstack1, DipperMenu.CONTAINER_SIZE, this.slots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.moveItemStackTo(itemstack1, 0, DipperMenu.CONTAINER_SIZE, false)) {
                return ItemStack.EMPTY;
            }

            if (itemstack1.isEmpty()) {
                slot.set(ItemStack.EMPTY);
            } else {
                slot.setChanged();
            }
        }

        return itemstack;
    }

    private int addSlotRange(IItemHandler handler, int index, int x, int y, int amount, int dx) {
        for (int i = 0; i < amount; i++) {
            addSlot(new SlotItemHandler(handler, index, x, y));
            x += dx;
            index++;
        }
        return index;
    }

    private int addSlotBox(IItemHandler handler, int index, int x, int y, int horAmount, int dx, int verAmount, int dy) {
        for (int j = 0; j < verAmount; j++) {
            index = addSlotRange(handler, index, x, y, horAmount, dx);
            y += dy;
        }
        return index;
    }

    private void layoutPlayerInventorySlots(int leftCol, int topRow) {
        // Player inventory
        addSlotBox(playerInventory, 9, leftCol, topRow, 9, 18, 3, 18);

        // Hotbar
        topRow += 58;
        addSlotRange(playerInventory, 0, leftCol, topRow, 9, 18);
    }

    @Override
    public boolean stillValid(Player playerIn) {
        return stillValid(ContainerLevelAccess.create(blockEntity.getLevel(), blockEntity.getBlockPos()), playerEntity, BlockInit.DIPPER.get());
    }

    public DipperBlockEntity getBlockEntity() {
        return tile;
    }
}
