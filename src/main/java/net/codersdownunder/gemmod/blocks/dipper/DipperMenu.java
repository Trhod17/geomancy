package net.codersdownunder.gemmod.blocks.dipper;


import net.codersdownunder.gemmod.init.BlockInit;
import net.codersdownunder.gemmod.init.MenuInit;
import net.codersdownunder.gemmod.utils.GeomancyTags;
import net.codersdownunder.gemmod.utils.TagUtils;
import net.codersdownunder.gemmod.utils.slots.GenericSlot;
import net.codersdownunder.gemmod.utils.slots.OutputSlot;
import net.codersdownunder.gemmod.utils.slots.SlotRestricted;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.Tag;
import net.minecraft.tags.Tag.TagEntry;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;
import net.minecraftforge.items.wrapper.InvWrapper;
import net.minecraftforge.registries.ForgeRegistryEntry;
import net.minecraftforge.registries.IForgeRegistryEntry;

public class DipperMenu extends AbstractContainerMenu {

	private BlockEntity blockEntity;
	private Player playerEntity;
	private IItemHandler playerInventory;
	
	public DipperBlockEntity tile;
	
	public int counter;
	
	public static final int PLAYER_INVENTORY_XPOS = -5;
	public static final int PLAYER_INVENTORY_YPOS = 113;
	
	private static final int CONTAINER_SIZE = 22;

	public DipperMenu(int windowId, Level world, BlockPos pos, Inventory playerInventory, Player player, DipperBlockEntity tile) {
		super(MenuInit.DIPPER_CONTAINER.get(), windowId);
		blockEntity = world.getBlockEntity(pos);
		this.playerEntity = player;
		this.playerInventory = new InvWrapper(playerInventory);
		this.tile = tile;
		Item item;
		
		if (blockEntity != null) {
			blockEntity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY).ifPresent(h -> {
				//center line
				addSlot(new SlotRestricted(h, 0, 67, -9, TagUtils.getValues(GeomancyTags.Items.STRING)));
				addSlot(new SlotRestricted(h, 1, 67, 9, TagUtils.getValues(GeomancyTags.Items.STRING)));
				addSlot(new GenericSlot(h, 2, 67, 27));
				addSlot(new SlotRestricted(h, 3, 67, 45, TagUtils.getValues(GeomancyTags.Items.STRING)));
				addSlot(new GenericSlot(h, 4, 67, 63));
				addSlot(new GenericSlot(h, 5, 67, 81));
				//center left
				addSlot(new GenericSlot(h, 6, 49, 9));
				addSlot(new GenericSlot(h, 7, 49, 27));
				addSlot(new GenericSlot(h, 8, 49, 45));
				//left
				addSlot(new GenericSlot(h, 9, 31, 27));
				addSlot(new GenericSlot(h, 10, 31, 45));
				addSlot(new GenericSlot(h, 11, 31, 63));
				//center right
				addSlot(new GenericSlot(h, 12, 85, 27));
				addSlot(new GenericSlot(h, 13, 85, 45));
				addSlot(new GenericSlot(h, 14, 85, 9));
				//right
				addSlot(new GenericSlot(h, 15, 103, 27));
				addSlot(new GenericSlot(h, 16, 103, 45));
				addSlot(new GenericSlot(h, 17, 103, 63));
				//concoctions
				addSlot(new SlotRestricted(h, 18, -5, 27, TagUtils.getValues(GeomancyTags.Items.CONCOCTIONS_TIER_4)));
				addSlot(new SlotRestricted(h, 19, -5, 45, TagUtils.getValues(GeomancyTags.Items.CONCOCTIONS_TIER_3)));
				addSlot(new SlotRestricted(h, 20, -5, 63, TagUtils.getValues(GeomancyTags.Items.CONCOCTIONS_TIER_2)));
				addSlot(new SlotRestricted(h, 21, -5, 81, TagUtils.getValues(GeomancyTags.Items.CONCOCTIONS_TIER_1)));
				//output
				addSlot(new OutputSlot(h, 22, 139, 27));
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

	    @Override
	    public boolean stillValid(Player playerIn) {
	        return stillValid(ContainerLevelAccess.create(blockEntity.getLevel(), blockEntity.getBlockPos()), playerEntity, BlockInit.DIPPER.get());
	    }

	    public DipperBlockEntity getTable()
	    {
	        return tile;
	    }

}
