package net.codersdownunder.gemmod.blocks.songforge;

import net.codersdownunder.gemmod.init.BlockInit;
import net.codersdownunder.gemmod.init.MenuInit;
import net.codersdownunder.gemmod.utils.AutomatableItemStackHandler;
import net.codersdownunder.gemmod.utils.slots.*;
import net.codersdownunder.gemmod.utils.slots.songforge.FurnaceInputSlot;
import net.codersdownunder.gemmod.utils.slots.songforge.SongForgeUpgradeSlot;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.common.capabilities.ForgeCapabilities;

public class SongForgeMenu extends AbstractContainerMenu {
    public final SongForgeBlockEntity blockEntity;
    private final Level level;
    private final ContainerData data;

    public static final int[] INPUT_SLOTS = new int[]{0, 1, 2};
    public static final int[] OUTPUT_SLOTS = new int[]{3, 4, 5, 6, 7, 8, 9, 10, 11};
    public static final int[] FUEL_SLOTS = new int[]{12, 13, 14};
    public static final int[] UPGRADE_SLOTS = new int[]{15, 16, 17, 18};

    public SongForgeMenu(int id, Inventory inv, FriendlyByteBuf extraData) {
        this(id, inv, inv.player.level.getBlockEntity(extraData.readBlockPos()), new SimpleContainerData(4));
    }

    public SongForgeMenu(int id, Inventory inv, BlockEntity entity, ContainerData data) {
        super(MenuInit.SONG_FORGE_MENU.get(), id);
        checkContainerSize(inv,19);
        blockEntity = (SongForgeBlockEntity) entity;
        this.level = inv.player.level;
        this.data = data;

        addPlayerInventory(inv);
        addPlayerHotbar(inv);

        if (blockEntity != null) {
            blockEntity.getCapability(ForgeCapabilities.ITEM_HANDLER).ifPresent(handler -> {
                if (handler instanceof AutomatableItemStackHandler h) {
                    //input slot
                    addSlot(new FurnaceInputSlot(blockEntity, h, 0, 7, 0));
                    addSlot(new FurnaceInputSlot(blockEntity, h, 1, 25, 0));
                    addSlot(new FurnaceInputSlot(blockEntity, h, 2, 43, 0));

                    //fuel slots
                    addSlot(new FuelSlot(h, 3, 7, 36));
                    addSlot(new FuelSlot(h, 4, 25, 36));
                    addSlot(new FuelSlot(h, 5, 43, 36));

                    //output slots
                    addSlot(new OutputSlot(h, 6, 103, 0));
                    addSlot(new OutputSlot(h, 7, 121, 0));
                    addSlot(new OutputSlot(h, 8, 139, 0));
                    addSlot(new OutputSlot(h, 9, 103, 18));
                    addSlot(new OutputSlot(h, 10, 121, 18));
                    addSlot(new OutputSlot(h, 11, 139, 18));
                    addSlot(new OutputSlot(h, 12, 103, 36));
                    addSlot(new OutputSlot(h, 13, 121, 36));
                    addSlot(new OutputSlot(h, 14, 139, 36));

                    //upgrade slots
                    addSlot(new SongForgeUpgradeSlot(blockEntity, h, 15, 163, 49));
                    addSlot(new SongForgeUpgradeSlot(blockEntity, h, 16, 163, 67));
                    addSlot(new SongForgeUpgradeSlot(blockEntity, h, 17, 163, 85));
                    addSlot(new SongForgeUpgradeSlot(blockEntity, h, 18, 163, 103));
                }
            });
        }

        addDataSlots(data);
    }

    public boolean isCrafting() {
        return this.data.get(0) > 0;
    }

    public int getScaledProgress() {
        int progress = this.data.get(0);
        int maxProgress = this.data.get(1);
        int progressArrowSize = 24;
        return maxProgress != 0 && progress != 0 ? progress * progressArrowSize / maxProgress : 0;
    }

    public boolean isBurning() {
        return this.data.get(2) > 0;
    }


    public int getLitProgress() {
        int i = this.data.get(3);
        if (i == 0) {
            i = 200;
        }

        return this.data.get(2) * 13 / i;
    }

    // CREDIT GOES TO: diesieben07 | https://github.com/diesieben07/SevenCommons
    // must assign a slot number to each of the slots used by the GUI.
    // For this container, we can see both the tile inventory's slots as well as the player inventory slots and the hotbar.
    // Each time we add a Slot to the container, it automatically increases the slotIndex, which means
    //  0 - 8 = hotbar slots (which will map to the InventoryPlayer slot numbers 0 - 8)
    //  9 - 35 = player inventory slots (which map to the InventoryPlayer slot numbers 9 - 35)
    //  36 - 44 = TileInventory slots, which map to our TileEntity slot numbers 0 - 8)
    private static final int HOTBAR_SLOT_COUNT = 9;
    private static final int PLAYER_INVENTORY_ROW_COUNT = 3;
    private static final int PLAYER_INVENTORY_COLUMN_COUNT = 9;
    private static final int PLAYER_INVENTORY_SLOT_COUNT = PLAYER_INVENTORY_COLUMN_COUNT * PLAYER_INVENTORY_ROW_COUNT;
    private static final int VANILLA_SLOT_COUNT = HOTBAR_SLOT_COUNT + PLAYER_INVENTORY_SLOT_COUNT;
    private static final int VANILLA_FIRST_SLOT_INDEX = 0;
    private static final int TE_INVENTORY_FIRST_SLOT_INDEX = VANILLA_FIRST_SLOT_INDEX + VANILLA_SLOT_COUNT;

    // THIS YOU HAVE TO DEFINE!
    private static final int TE_INVENTORY_SLOT_COUNT = 19;  // must be the number of slots you have!


    @Override
    public ItemStack quickMoveStack(Player playerIn, int index) {
        Slot sourceSlot = slots.get(index);
        if (sourceSlot == null || !sourceSlot.hasItem()) return ItemStack.EMPTY;  //EMPTY_ITEM
        ItemStack sourceStack = sourceSlot.getItem();
        ItemStack copyOfSourceStack = sourceStack.copy();

        // Check if the slot clicked is one of the vanilla container slots
        if (index < VANILLA_FIRST_SLOT_INDEX + VANILLA_SLOT_COUNT) {
            // This is a vanilla container slot so merge the stack into the tile inventory

            if (!moveItemStackTo(sourceStack, TE_INVENTORY_FIRST_SLOT_INDEX, TE_INVENTORY_FIRST_SLOT_INDEX
                    + TE_INVENTORY_SLOT_COUNT, false)) {
                return ItemStack.EMPTY;  // EMPTY_ITEM
            }
        } else if (index < TE_INVENTORY_FIRST_SLOT_INDEX + TE_INVENTORY_SLOT_COUNT) {
            // This is a TE slot so merge the stack into the players inventory

            if (!moveItemStackTo(sourceStack, VANILLA_FIRST_SLOT_INDEX, VANILLA_FIRST_SLOT_INDEX + VANILLA_SLOT_COUNT, false)) {
                return ItemStack.EMPTY;
            }
        } else {
            System.out.println("Invalid slotIndex:" + index);
            return ItemStack.EMPTY;
        }
        // If stack size == 0 (the entire stack was moved) set slot contents to null
        if (sourceStack.getCount() == 0) {
            sourceSlot.set(ItemStack.EMPTY);
        } else {
            sourceSlot.setChanged();
        }
        sourceSlot.onTake(playerIn, sourceStack);
        return copyOfSourceStack;
    }
    @Override
    public boolean stillValid(Player pPlayer) {
        return stillValid(ContainerLevelAccess.create(level, blockEntity.getBlockPos()), pPlayer, BlockInit.SONG_FORGE.get());
    }

    private void addPlayerInventory(Inventory playerInventory) {
        for (int i = 0; i < 3; ++i) {
            for (int l = 0; l < 9; ++l) {
                this.addSlot(new Slot(playerInventory, l + i * 9 + 9, -5 + l * 18, 67 + i * 18));
            }
        }
    }

    private void addPlayerHotbar(Inventory playerInventory) {
        for (int i = 0; i < 9; ++i) {
            this.addSlot(new Slot(playerInventory, i, -5 + i * 18, 125));
        }
    }
}
