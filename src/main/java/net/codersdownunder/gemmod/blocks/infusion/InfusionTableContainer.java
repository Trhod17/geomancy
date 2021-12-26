package net.codersdownunder.gemmod.blocks.infusion;

import java.util.Objects;

import javax.annotation.Nullable;

import net.codersdownunder.gemmod.blocks.dipper.DipperMenu;
import net.codersdownunder.gemmod.init.BlockInit;
import net.codersdownunder.gemmod.init.ContainerInit;
import net.codersdownunder.gemmod.init.TileEntityInit;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.DataSlot;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraftforge.energy.CapabilityEnergy;
import net.minecraftforge.energy.IEnergyStorage;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;
import net.minecraftforge.items.wrapper.InvWrapper;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;
import net.minecraftforge.items.wrapper.InvWrapper;

@SuppressWarnings("unused")
public class InfusionTableContainer extends AbstractContainerMenu {

    private BlockEntity tileEntity;
    private Player playerEntity;
    private IItemHandler playerInventory;
    private Level world;
    private Player player;
    private InfusionTableBlockEntity table;
    private BlockPos pos;

    public static final int PLAYER_INVENTORY_XPOS = -5;
    public static final int PLAYER_INVENTORY_YPOS = 117;
    
//    public static final int INPUT_SLOTS_COUNT = 6;
//    public static final int OUTPUT_SLOTS_COUNT = 1;
//    public static final int FURNACE_SLOTS_COUNT = INPUT_SLOTS_COUNT + OUTPUT_SLOTS_COUNT;
    
    public static int id;
    private static int CONTAINER_SIZE = 6;
    
    public InfusionTableContainer() {
        super(ContainerInit.INFUSION_TABLE_CONTAINER.get(), id);
    }
    
    public InfusionTableContainer(int windowId, Level world, BlockPos pos, Inventory playerInventory, Player player)  {
        super(ContainerInit.INFUSION_TABLE_CONTAINER.get(), windowId);
        InfusionTableContainer.id = windowId;
        tileEntity = world.getBlockEntity(pos);
        this.playerEntity = player;
        this.playerInventory = new InvWrapper(playerInventory);
        this.pos = pos;


        if (tileEntity != null) {
            tileEntity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY).ifPresent(h -> {
                addSlot(new SlotItemHandler(h, 0, 67, 63));
                addSlot(new SlotItemHandler(h, 1, 31, 45));
                addSlot(new SlotItemHandler(h, 2, 103, 45));
                addSlot(new SlotItemHandler(h, 3, 103, 9));
                addSlot(new SlotItemHandler(h, 4, 31, 9));
                addSlot(new SlotItemHandler(h, 5, 67, -9));
                addSlot(new SlotItemHandler(h, 6, 67, 27) {
                    @Override
                    public boolean mayPlace(ItemStack pStack)
                    {
                        return false;
                    }
                    
                });
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
	         if (pIndex < InfusionTableContainer.CONTAINER_SIZE) {
	            if (!this.moveItemStackTo(itemstack1, InfusionTableContainer.CONTAINER_SIZE, this.slots.size(), true)) {
	               return ItemStack.EMPTY;
	            }
	         } else if (!this.moveItemStackTo(itemstack1, 0, InfusionTableContainer.CONTAINER_SIZE, false)) {
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
        return stillValid(ContainerLevelAccess.create(tileEntity.getLevel(), tileEntity.getBlockPos()), playerEntity, BlockInit.INFUSION_TABLE.get());
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
    
    public InfusionTableBlockEntity getTable()
    {
        return table;
    }


}