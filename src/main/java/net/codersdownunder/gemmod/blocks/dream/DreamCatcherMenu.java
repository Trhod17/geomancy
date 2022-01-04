package net.codersdownunder.gemmod.blocks.dream;

import net.codersdownunder.gemmod.init.BlockInit;
import net.codersdownunder.gemmod.init.MenuInit;
import net.codersdownunder.gemmod.utils.slots.GenericSlot;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;
import net.minecraftforge.items.wrapper.InvWrapper;

public class DreamCatcherMenu extends AbstractContainerMenu {

    private BlockEntity tileEntity;
    private Player playerEntity;
    private IItemHandler playerInventory;
    private BlockPos pos;

    public static final int PLAYER_INVENTORY_XPOS = -5;
    public static final int PLAYER_INVENTORY_YPOS = 113;
    
    public static int id;
    private int CONTAINER_SIZE = 16;
    
    public DreamCatcherMenu() {
        super(MenuInit.DREAM_CATCHER_MENU.get(), id);
    }
    
    public DreamCatcherMenu(int windowId, Level world, BlockPos pos, Inventory playerInventory, Player player)  {
        super(MenuInit.DREAM_CATCHER_MENU.get(), windowId);
        DreamCatcherMenu.id = windowId;
        tileEntity = world.getBlockEntity(pos);
        this.playerEntity = player;
        this.playerInventory = new InvWrapper(playerInventory);
        this.pos = pos;


        if (tileEntity != null) {
            tileEntity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY).ifPresent(h -> {
            	addSlot(new GenericSlot(h, 0, 49, 27));
            	addSlot(new GenericSlot(h, 1, 67, 27));
            	addSlot(new GenericSlot(h, 2, 85, 27));
            	addSlot(new GenericSlot(h, 3, 31, 45));
            	addSlot(new GenericSlot(h, 4, 49, 45));
            	addSlot(new GenericSlot(h, 5, 67, 45));
            	addSlot(new GenericSlot(h, 6, 85, 45));
            	addSlot(new GenericSlot(h, 7, 103, 45));
            	addSlot(new GenericSlot(h, 8, 31, 63));
            	addSlot(new GenericSlot(h, 9, 49, 63));
            	addSlot(new GenericSlot(h, 10, 67, 63));
            	addSlot(new GenericSlot(h, 11, 85, 63));
            	addSlot(new GenericSlot(h, 12, 103, 63));
            	addSlot(new GenericSlot(h, 13, 49, 81));
            	addSlot(new GenericSlot(h, 14, 67, 81));
            	addSlot(new GenericSlot(h, 15, 85, 81));

            });
        }

        
        layoutPlayerInventorySlots(PLAYER_INVENTORY_XPOS, PLAYER_INVENTORY_YPOS);
    }
    
    public ItemStack quickMoveStack(Player pPlayer, int pIndex) {
	      ItemStack itemstack = ItemStack.EMPTY;
	      Slot slot = this.slots.get(pIndex);
	      if (slot != null && slot.hasItem()) {
	         ItemStack itemstack1 = slot.getItem();
	         itemstack = itemstack1.copy();
	         if (pIndex < this.CONTAINER_SIZE) {
	            if (!this.moveItemStackTo(itemstack1, this.CONTAINER_SIZE, this.slots.size(), true)) {
	               return ItemStack.EMPTY;
	            }
	         } else if (!this.moveItemStackTo(itemstack1, 0, this.CONTAINER_SIZE, false)) {
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
    
    public BlockPos getPos() {
        return this.pos;
    }


    @Override
    public boolean stillValid(Player playerIn) {
        return stillValid(ContainerLevelAccess.create(tileEntity.getLevel(), tileEntity.getBlockPos()), playerEntity, BlockInit.DREAM_CATCHER.get());
    }

    
    private int addSlotRange(IItemHandler handler, int index, int x, int y, int amount, int dx) {
        for (int i = 0 ; i < amount ; i++) {
            addSlot(new SlotItemHandler(handler, index, x, y));
            x += dx;
            index++;
        }
        return index;
    }

    private int addSlotBox(IItemHandler handler, int index, int x, int y, int horAmount, int dx, int verAmount, int dy) {
        for (int j = 0 ; j < verAmount ; j++) {
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
    
}
