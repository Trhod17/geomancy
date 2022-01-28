package net.codersdownunder.gemmod.blocks.songforge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import net.codersdownunder.gemmod.init.TileEntityInit;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.crafting.SmeltingRecipe;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.wrapper.RangedWrapper;

public class SongForgeBlockEntity extends BlockEntity {

	private static final int INPUT_SLOTS = 3;
	private static final int OUTPUT_SLOTS = 9;
	private static final int FUEL_SLOTS = 3;
	private static final int UPGRADE_SLOTS = 4;

	public static boolean valid;
	public static ItemStack output;
	public static int input;
	public static int counter;
	// private int countermax;
	public static int burntime;
	// private int burntimemax;
	public static int fuel;
	public static boolean crafting;

//	private CompoundTag updateTag;

	public int getCounter() {
		return counter;
	}

	public int getBurn() {
		return burntime;
	}

	private ItemStackHandler itemHandler = createHandler();

	private final LazyOptional<IItemHandler> handler = LazyOptional.of(() -> itemHandler);

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
				// burntimemax = burntime;
				this.level.setBlock(this.worldPosition,
						this.level.getBlockState(this.worldPosition).setValue(BlockStateProperties.LIT, true), 3);
			}
		}

		if (burntime == 0) {
			burntime = getBurnTime();
			System.out.println(burntime);
			if (burntime == 0) {
			this.level.setBlock(this.worldPosition,
					this.level.getBlockState(this.worldPosition).setValue(BlockStateProperties.LIT, false), 3);
			}
		}
		
		

		if (counter <= 0) {

			if (valid && crafting && outputRoom()) {
				attemptCraft(output);
				valid = false;
				crafting = false;
				output = null;
			}

			if (valid && !crafting) {
				crafting = true;
			}
		}
	}
	
	private boolean outputRoom() {
		
		if (output != null) {
		SimpleContainer inv = new SimpleContainer(itemHandler.getSlots());
		
		inv.setItem(0, itemHandler.getStackInSlot(6));
		inv.setItem(0, itemHandler.getStackInSlot(7));
		inv.setItem(0, itemHandler.getStackInSlot(8));
		inv.setItem(0, itemHandler.getStackInSlot(9));
		inv.setItem(0, itemHandler.getStackInSlot(10));
		inv.setItem(0, itemHandler.getStackInSlot(11));
		inv.setItem(0, itemHandler.getStackInSlot(12));
		inv.setItem(0, itemHandler.getStackInSlot(13));
		inv.setItem(0, itemHandler.getStackInSlot(14));
		
		if (inv.isEmpty()) {
			return true;
		}
		
		if (inv.canAddItem(output)) {
			return true;
		}
		}
		
		return false;
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
		
		counter = recipe.getCookingTime();
		// countermax = counter;
		output = recipe.getResultItem().copy();
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
//
//    	var slot = getOuputSlot(output);
//    	
//    	
//    	
//
//    }

	private void getOuputSlot(ItemStack result) {
		var outputMin = 6;
		var outputMax = 14;

		// int slot = 0;

		ItemStack item;

		for (int i = outputMin; i <= outputMax; i++) {
			if (itemHandler.getStackInSlot(i).getCount() < 64) {
				if (itemHandler.getStackInSlot(i).isEmpty()) {
					itemHandler.insertItem(i, result, false);
					valid = false;
					output = null;
					break;
				} else if (!itemHandler.getStackInSlot(i).isEmpty()
						&& itemHandler.getStackInSlot(i).is(result.getItem())) {
					item = itemHandler.getStackInSlot(i).copy();
					item.grow(1);
					itemHandler.setStackInSlot(i, item);
					valid = false;
					output = null;
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
		pTag.putInt("counter", counter);
		pTag.putInt("burntime", burntime);
		pTag.putBoolean("crafting", crafting);
		pTag.putBoolean("valid", valid);
		
		super.saveAdditional(pTag);
	}

	@Override
	public void load(CompoundTag tag) {
		itemHandler.deserializeNBT(tag.getCompound("inv"));
		counter = tag.getInt("counter");
		burntime = tag.getInt("burntime");
		crafting = tag.getBoolean("crafting");
		valid = tag.getBoolean("valid");
		super.load(tag);
	}

//	@Override
//	public CompoundTag getUpdateTag() {
//		this.saveAdditional(updateTag);
//		return updateTag;
//	}

	@Override
	public ClientboundBlockEntityDataPacket getUpdatePacket() {
		return ClientboundBlockEntityDataPacket.create(this);
	}

	@Override
	public void handleUpdateTag(CompoundTag tag) {
		this.load(tag);
	}

//	@Override
//	public void onDataPacket(Connection net, ClientboundBlockEntityDataPacket pkt) {
//		this.load(pkt.getTag());
//	}

	@SuppressWarnings("resource")
	public void sendToClients() {
		if (this.getLevel().isClientSide()) {
			return;
		}

		ServerLevel world = (ServerLevel) this.getLevel();
		List<ServerPlayer> entities = world.getChunkSource().chunkMap.getPlayers(new ChunkPos(this.getBlockPos()),
				false);
		ClientboundBlockEntityDataPacket packet = this.getUpdatePacket();
		entities.forEach(e -> e.connection.send(packet));
		setChanged();
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
	
    ArrayList<LazyOptional<?>> capabilities = new ArrayList<>(Arrays.asList(
            LazyOptional.of(this::getItemStackHandler),
            LazyOptional.of(() -> new RangedWrapper(getItemStackHandler(), 3, 5)),
            LazyOptional.of(() -> new RangedWrapper(getItemStackHandler(), 0, 2)),
            LazyOptional.of(() -> new RangedWrapper(getItemStackHandler(), 6, 14))
    ));

	@Nonnull
	@Override
	public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
		if (cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {

			if (side == null) return capabilities.get(0).cast();
			return switch (side) {
			case UP -> capabilities.get(2).cast();
			case DOWN -> capabilities.get(3).cast();
			default -> capabilities.get(1).cast();
			};
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
