package net.codersdownunder.gemmod.blocks.songforge;

import net.codersdownunder.gemmod.init.BlockInit;
import net.codersdownunder.gemmod.init.MenuInit;
import net.codersdownunder.gemmod.utils.AutomatableItemStackHandler;
import net.codersdownunder.gemmod.utils.slots.AutomatableSlot;
import net.codersdownunder.gemmod.utils.slots.FuelSlot;
import net.codersdownunder.gemmod.utils.slots.GenericSlot;
import net.codersdownunder.gemmod.utils.slots.OutputSlot;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;
import net.minecraftforge.items.wrapper.InvWrapper;

public class SongForgeMenu extends AbstractContainerMenu {

    private SongForgeBlockEntity tileEntity;
    private Player playerEntity;
    private IItemHandler playerInventory;
    private BlockPos pos;

    public static final int PLAYER_INVENTORY_XPOS = -5;
    public static final int PLAYER_INVENTORY_YPOS = 57;
    
    public static int id;
    private int CONTAINER_SIZE = 19;
    
    private int counter;
    public int burntime;
    
    public SongForgeMenu() {
        super(MenuInit.SONG_FORGE_MENU.get(), id);
    }
    
    public SongForgeMenu(int windowId, Level world, BlockPos pos, Inventory playerInventory, Player player)  {
        super(MenuInit.SONG_FORGE_MENU.get(), windowId);
        SongForgeMenu.id = windowId;
        this.tileEntity = (SongForgeBlockEntity) world.getBlockEntity(pos);
        this.playerEntity = player;
        this.playerInventory = new InvWrapper(playerInventory);
        this.pos = pos;
        this.counter = tileEntity.getCounter();
        this.burntime = tileEntity.getBurn();
        

        if (tileEntity != null) {
            tileEntity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY).ifPresent(handler -> {
                if (handler instanceof AutomatableItemStackHandler h) {
                    //input slot
                    addSlot(new AutomatableSlot(h, 0, 7, -10));
                    addSlot(new AutomatableSlot(h, 1, 25, -10));
                    addSlot(new AutomatableSlot(h, 2, 43, -10));

                    //fuel slots
                    addSlot(new FuelSlot(h, 3, 7, 26));
                    addSlot(new FuelSlot(h, 4, 25, 26));
                    addSlot(new FuelSlot(h, 5, 43, 26));

                    //output slots
                    addSlot(new AutomatableSlot(h, 6, 103, -10));
                    addSlot(new AutomatableSlot(h, 7, 121, -10));
                    addSlot(new AutomatableSlot(h, 8, 139, -10));
                    addSlot(new AutomatableSlot(h, 9, 103, 8));
                    addSlot(new AutomatableSlot(h, 10, 121, 8));
                    addSlot(new AutomatableSlot(h, 11, 139, 8));
                    addSlot(new AutomatableSlot(h, 12, 103, 26));
                    addSlot(new AutomatableSlot(h, 13, 121, 26));
                    addSlot(new AutomatableSlot(h, 14, 139, 26));

                    //upgrade slots
                    addSlot(new AutomatableSlot(h, 15, 163, 39));
                    addSlot(new AutomatableSlot(h, 16, 163, 57));
                    addSlot(new AutomatableSlot(h, 17, 163, 75));
                    addSlot(new AutomatableSlot(h, 18, 163, 93));
                }
            });
        }

        
        layoutPlayerInventorySlots(PLAYER_INVENTORY_XPOS, PLAYER_INVENTORY_YPOS);
    }
    
    public int getCookScaled(int pixels) {
        int i = SongForgeBlockEntity.counter;
        int j = this.counter - 10;
        return j != 0 && i != 0 ? i * pixels / j : 0;
    }

    public int getBurnLeftScaled(int pixels) {
        int i = this.burntime;
        if (i == 0) {
            i = 200;
        }

        return this.burntime * pixels / i;
    }
    
    public boolean isLit() {
        return this.burntime > 0;
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
        return stillValid(ContainerLevelAccess.create(tileEntity.getLevel(), tileEntity.getBlockPos()), playerEntity, BlockInit.SONG_FORGE.get());
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
    
    public SongForgeBlockEntity getTable()
    {
        return tileEntity;
    }
    
}
