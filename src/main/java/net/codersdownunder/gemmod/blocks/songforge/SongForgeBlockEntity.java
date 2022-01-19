package net.codersdownunder.gemmod.blocks.songforge;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import net.codersdownunder.gemmod.init.TileEntityInit;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.crafting.SmeltingRecipe;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;

public class SongForgeBlockEntity extends BlockEntity {

	private static final int INPUT_SLOTS = 3;
	private static final int OUTPUT_SLOTS = 9;
	private static final int FUEL_SLOTS = 3;
	private static final int UPGRADE_SLOTS = 4;

	private static boolean valid;
	private static ItemStack output;
	private static int input;
	private static int counter;
	private static int burntime;
	private static int fuel;
	private static boolean crafting;
	

	private ItemStackHandler itemHandler = createHandler();

	private final LazyOptional<IItemHandler> handler = LazyOptional.of(() -> itemHandler);

	public int data;

	public SongForgeBlockEntity(BlockPos pos, BlockState blockState) {
		super(TileEntityInit.SONG_FORGE_BE.get(), pos, blockState);
	}

	public ItemStackHandler getItemStackHandler() {
		return itemHandler;
	}

	public static int getSlots() {
		return INPUT_SLOTS + OUTPUT_SLOTS + FUEL_SLOTS + UPGRADE_SLOTS + 1;
	}

	public void tickServer() {

		if (level.isClientSide)
			return;
		
		if (counter > 0) {
			counter--;
		}
		
		if (burntime != 0) {
			burntime--;
		}

		if (!valid) {
			isRecipeValid();
			
			if (valid) {
				burntime = getBurnTime();
				this.level.setBlock(this.worldPosition, this.level.getBlockState(this.worldPosition).setValue(BlockStateProperties.LIT, true), 3);
			}
		}
		
		if (burntime == 0) {
			counter = 0;
			this.level.setBlock(this.worldPosition, this.level.getBlockState(this.worldPosition).setValue(BlockStateProperties.LIT, false), 3);
		}
		
		if (counter <= 0) {
		
			if (valid && crafting) {
				attemptCraft(output);
				valid = false;
				crafting = false;
			} 
			
			
			if (!crafting) {
				crafting = true;
			}
		}
	}
	
	private int getBurnTime() {
	SimpleContainer inv = new SimpleContainer(itemHandler.getSlots());
		
		if (!itemHandler.getStackInSlot(3).isEmpty()) {
			inv.setItem(0, itemHandler.getStackInSlot(3));
			fuel = 0;
		}
		
		if (!itemHandler.getStackInSlot(4).isEmpty()) {
			inv.setItem(0, itemHandler.getStackInSlot(4));
			fuel = 1;
		}
		
		if (!itemHandler.getStackInSlot(5).isEmpty()) {
			inv.setItem(0, itemHandler.getStackInSlot(5));
			fuel = 4;
		}
		

		ItemStack item;

		
		item = itemHandler.getStackInSlot(fuel).copy();
		item.shrink(0);
		itemHandler.setStackInSlot(fuel, item);
		return ForgeHooks.getBurnTime(inv.getItem(0), RecipeType.SMELTING);
	}

	private boolean isRecipeValid() {

		SimpleContainer inv = new SimpleContainer(itemHandler.getSlots());
		
		if (!itemHandler.getStackInSlot(0).isEmpty()) {
			inv.setItem(0, itemHandler.getStackInSlot(0));
			input = 0;
		}
		
		if (!itemHandler.getStackInSlot(1).isEmpty()) {
			inv.setItem(0, itemHandler.getStackInSlot(1));
			input = 1;
		}
		
		if (!itemHandler.getStackInSlot(2).isEmpty()) {
			inv.setItem(0, itemHandler.getStackInSlot(2));
			input = 2;
		}

		if (level == null) {
			valid = false;
			return false;
		}
		// System.out.println(inv);

		
			SmeltingRecipe recipe = level.getRecipeManager().getRecipeFor(RecipeType.SMELTING, inv, level).orElse(null);
			// System.out.print(recipe);
			if (recipe == null) {
				valid = false;

				return false;
			}

			valid = true;
			output = recipe.getResultItem().copy();
			counter = recipe.getCookingTime();
			return true;


	}

	private void attemptCraft(ItemStack output) {

		itemHandler.extractItem(input, 1, false);

		getOuputSlot(output);
	}

//    private void handleOutput(int slot, ItemStack output) {
//    	
//    	if (itemHandler.getStackInSlot(slot).isEmpty()) {
//    		
//    	}
//    }
//    
//    private void setOuput(ItemStack output) {
//    	//TODO: figure out the item duplication bug
//    	var slot = getOuputSlot(output);
//    	
//    	
//    	
//
//    }

	private void getOuputSlot(ItemStack result) {
		var outputMin = 6;
		var outputMax = 14;

		//int slot = 0;

		ItemStack item;

		for (int i = outputMin; i <= outputMax; i++) {
			if (itemHandler.getStackInSlot(i).getCount() < 64) {
			if (itemHandler.getStackInSlot(i).isEmpty()) {
				itemHandler.insertItem(i, result, false);
				valid = false;
				break;
			} else if (!itemHandler.getStackInSlot(i).isEmpty() && itemHandler.getStackInSlot(i).is(result.getItem())) {
				item = itemHandler.getStackInSlot(i).copy();
				item.grow(1);
				itemHandler.setStackInSlot(i, item);
				valid = false;
				break;
			}
			}
			continue;
		}
		
//		
//			if (itemHandler.getStackInSlot(i).isEmpty()) {
//				slot = i;
//				itemHandler.insertItem(slot, output, false);
//				break;
//			} else if (!itemHandler.getStackInSlot(slot).isEmpty()
//					&& itemHandler.getStackInSlot(slot).is(output.getItem())) {
//				slot = i;
//				item = itemHandler.getStackInSlot(slot).copy();
//				item.grow(1);
//				itemHandler.setStackInSlot(slot, item);
//				valid = false;
//				break;
//			}
//		}
	}

	@Override
	public void setRemoved() {
		super.setRemoved();
		handler.invalidate();
	}

	@Override
	protected void saveAdditional(CompoundTag pTag) {
		pTag.put("inv", itemHandler.serializeNBT());
	}

	@Override
	public void load(CompoundTag tag) {
		itemHandler.deserializeNBT(tag.getCompound("inv"));

		super.load(tag);
	}

	private ItemStackHandler createHandler() {
		return new ItemStackHandler(SongForgeBlockEntity.getSlots()) {
			@Override
			protected void onContentsChanged(int slot) {
				super.onContentsChanged(slot);
				setChanged();
			}

			@Override
			public boolean isItemValid(int slot, @Nonnull ItemStack stack) {
				return true;
			}

			@Override
			public int getSlotLimit(int slot) {
				return 64;
			}

			@Nonnull
			@Override
			public ItemStack insertItem(int slot, @Nonnull ItemStack stack, boolean simulate) {
				if (!isItemValid(slot, stack)) {
					return stack;
				}

				return super.insertItem(slot, stack, simulate);
			}
		};
	}

	@Nonnull
	@Override
	public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
		if (cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
			return handler.cast();
		}
		return super.getCapability(cap, side);
	}

	public boolean canPlayerAccessInventory(Player playerIn) {
		if (this.level.getBlockEntity(this.worldPosition) != this) {
			return false;
		}

		final double X_CENTRE_OFFSET = 0.5;
		final double Y_CENTRE_OFFSET = 0.5;
		final double Z_CENTRE_OFFSET = 0.5;
		final double MAXIMUM_DIST_SQ = 8.0 * 8.0;

		return playerIn.distanceToSqr(worldPosition.getX() + X_CENTRE_OFFSET, worldPosition.getY() + Y_CENTRE_OFFSET,
				worldPosition.getZ() + Z_CENTRE_OFFSET) < MAXIMUM_DIST_SQ;
	}

}
