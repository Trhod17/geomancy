package net.codersdownunder.gemmod.blocks.dipper;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import net.codersdownunder.gemmod.crafting.recipe.ModRecipeTypes;
import net.codersdownunder.gemmod.crafting.recipe.dipping.DippingRecipe;
import net.codersdownunder.gemmod.init.TileEntityInit;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Connection;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.capability.CapabilityFluidHandler;
import net.minecraftforge.fluids.capability.IFluidHandler;
import net.minecraftforge.fluids.capability.IFluidHandlerItem;
import net.minecraftforge.fluids.capability.templates.FluidTank;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;

public class DipperBlockEntity extends BlockEntity implements IFluidHandler {

	private final ItemStackHandler itemHandler = createHandler();
	private final FluidTank tank = new FluidTank(capacity);
	private FluidStack fluidStack = FluidStack.EMPTY;

	private final LazyOptional<IItemHandler> handler = LazyOptional.of(() -> itemHandler);
	private final LazyOptional<IFluidHandler> fluidHandler = LazyOptional.of(() -> getTank());

	public static int capacity = 4000;

	private static int processTime = 2000;
	public int counter;
	public int totalTime;
	@SuppressWarnings("unused")
	private boolean valid;
	private boolean crafting;
	private ItemStack output;
	private int fluidamount;

	public DipperBlockEntity(BlockPos pWorldPosition, BlockState pBlockState) {
		super(TileEntityInit.DIPPER_BE.get(), pWorldPosition, pBlockState);

//		 this.tank = new FluidTank(capacity) {
//
//	            @Override
//	            public int fill(FluidStack resource, FluidAction action) {
//	               return this.fill(resource, action);
//	            }
//
//	            @Override
//	            protected void onContentsChanged() {
//	                DipperBlockEntity.this.setChanged();
//	                DipperBlockEntity.this.clientSync();
//	            }
//	        };

	}

//	@SuppressWarnings("resource")
//	public void clientSync() {
//		if (Objects.requireNonNull(this.getLevel()).isClientSide) {
//			return;
//		}
//		ServerLevel world = (ServerLevel) this.getLevel();
////		List<ServerPlayer> entities = world.getChunkSource().chunkMap.getPlayers(new ChunkPos(this.worldPosition),
////				false);
//		//ClientboundBlockEntityDataPacket updatePacket = this.getUpdatePacket();
////		entities.forEach(e -> {
////			if (updatePacket != null) {
////				e.connection.send(updatePacket);
////			}
////		});
//	}

	@Override
	public void setRemoved() {
		super.setRemoved();
		handler.invalidate();
		fluidHandler.invalidate();
	}

	public void tickServer() {
		
		if (level.isClientSide) return;

		if (counter > 0) {
			counter--;
			setChanged();
			level.sendBlockUpdated(worldPosition, getBlockState(), getBlockState(), 2);
			
			
		}
		
//		System.out.println(counter);

		if (counter <= 0) {

			if (isRecipeValid() && crafting) {
				if (itemHandler.getStackInSlot(22).isEmpty()) {
					if (tank.getFluid().getAmount() > fluidamount) {
					attemptCraft(output, fluidamount);
					level.sendBlockUpdated(worldPosition, getBlockState(), getBlockState(), 2);
					totalTime = 0;
					crafting = false;
					}
				}
			}
			
			if (isRecipeValid() && !crafting) {
				counter = processTime();
				totalTime = counter;
				crafting = true;
			}
		}
		
		
	}
	
	private int processTime() {
		
		ItemStack concoction1 = itemHandler.getStackInSlot(21);
		ItemStack concoction2 = itemHandler.getStackInSlot(20);
		ItemStack concoction3 = itemHandler.getStackInSlot(19);
		ItemStack concoction4 = itemHandler.getStackInSlot(18);
		
		if (concoction1.isEmpty()) {
			return processTime;
		} else {
			if (concoction2.isEmpty()) {
				itemHandler.extractItem(21, 1, false);
				return processTime - 100;
			}
			
			if (concoction3.isEmpty()) {
				itemHandler.extractItem(21, 1, false);
				itemHandler.extractItem(20, 1, false);
				return processTime - 200;
			}
			
			if (concoction4.isEmpty()) {
				itemHandler.extractItem(21, 1, false);
				itemHandler.extractItem(20, 1, false);
				itemHandler.extractItem(19, 1, false);
				return processTime - 300;
			}
			
			if (!concoction1.isEmpty() && !concoction2.isEmpty() && !concoction3.isEmpty() && !concoction4.isEmpty()) {
				return processTime - 400;
			}
		}

		
		return processTime;
	}

	private boolean isRecipeValid() {

		SimpleContainer inv = new SimpleContainer(itemHandler.getSlots() - 5);

		inv.setItem(0, itemHandler.getStackInSlot(0));
		inv.setItem(1, itemHandler.getStackInSlot(1));
		inv.setItem(2, itemHandler.getStackInSlot(2));
		inv.setItem(3, itemHandler.getStackInSlot(3));
		inv.setItem(4, itemHandler.getStackInSlot(4));
		inv.setItem(5, itemHandler.getStackInSlot(5));
		inv.setItem(6, itemHandler.getStackInSlot(6));
		inv.setItem(7, itemHandler.getStackInSlot(7));
		inv.setItem(8, itemHandler.getStackInSlot(8));
		inv.setItem(9, itemHandler.getStackInSlot(9));
		inv.setItem(10, itemHandler.getStackInSlot(10));
		inv.setItem(11, itemHandler.getStackInSlot(11));
		inv.setItem(12, itemHandler.getStackInSlot(12));
		inv.setItem(13, itemHandler.getStackInSlot(13));
		inv.setItem(14, itemHandler.getStackInSlot(14));
		inv.setItem(15, itemHandler.getStackInSlot(15));
		inv.setItem(16, itemHandler.getStackInSlot(16));
		inv.setItem(17, itemHandler.getStackInSlot(17));

		if (level == null) {
			valid = false;
			
			return false;
			
		}

		DippingRecipe recipe = level.getRecipeManager().getRecipeFor(ModRecipeTypes.DIPPING_RECIPE, inv, level)
				.orElse(null);

		if (recipe == null) {
			valid = false;
			
			return false;
		}
	
		
		valid = true;
		output = recipe.getResultItem();
		fluidamount = recipe.getFluidAmount();
		return true;
	}

	private void attemptCraft(ItemStack output, int fluidamount) {

		itemHandler.extractItem(0, 1, false);
		itemHandler.extractItem(1, 1, false);
		itemHandler.extractItem(2, 1, false);
		itemHandler.extractItem(3, 1, false);
		itemHandler.extractItem(4, 1, false);
		itemHandler.extractItem(5, 1, false);
		itemHandler.extractItem(6, 1, false);
		itemHandler.extractItem(7, 1, false);
		itemHandler.extractItem(8, 1, false);
		itemHandler.extractItem(9, 1, false);
		itemHandler.extractItem(10, 1, false);
		itemHandler.extractItem(11, 1, false);
		itemHandler.extractItem(12, 1, false);
		itemHandler.extractItem(13, 1, false);
		itemHandler.extractItem(14, 1, false);
		itemHandler.extractItem(15, 1, false);
		itemHandler.extractItem(16, 1, false);
		itemHandler.extractItem(17, 1, false);
		itemHandler.insertItem(22, output, false);
		tank.drain(1000, FluidAction.EXECUTE);
		counter = 0;
	}

	@Override
	public CompoundTag getUpdateTag() {
		return this.save(new CompoundTag());
	}

	@Nullable
	@Override
	public ClientboundBlockEntityDataPacket getUpdatePacket() {
		return ClientboundBlockEntityDataPacket.create(this);
	}

	@Override
	public void handleUpdateTag(CompoundTag tag) {
		this.load(tag);
		
	}

	@Override
	public void onDataPacket(Connection net, ClientboundBlockEntityDataPacket pkt) {
		  load(pkt.getTag());
	}
	
	@Override
	public void onLoad() {
		super.onLoad();
	}

	@Override
	public void load(CompoundTag tag) {

		if (tag.contains("inventory")) {
			itemHandler.deserializeNBT(tag.getCompound("inventory"));
		}
		
		if (tag.contains("counter")) {
			counter = tag.getInt("counter");
		}

		tank.readFromNBT(tag);
		tank.setCapacity(tag.getInt("fluid"));

		super.load(tag);
	}

	@Override
	public CompoundTag save(CompoundTag tag) {
		saveAdditional(tag);
		return super.save(tag);
	}

	@Override
	protected void saveAdditional(CompoundTag tag) {
		tag.put("inventory", itemHandler.serializeNBT());
		tank.writeToNBT(tag);
		tag.putInt("fluid", tank.getCapacity());
		tag.putInt("counter", counter);
	}

	public FluidStack getFluid() {
		return getFluidInTank(1);
	}

	public FluidTank getTank() {
		return this.tank;
	}

	private ItemStackHandler createHandler() {
		return new ItemStackHandler(24) {

			@Override
			protected void onContentsChanged(int slot) {
				setChanged();
				level.sendBlockUpdated(worldPosition, getBlockState(), getBlockState(), 2 | 4);
			}
			
			@Override
			public int getSlotLimit(int slot) {
				
				return 1;
			}
//
//	            @Override
//	            public boolean isItemValid(int slot, @Nonnull ItemStack stack) {
//	                return ForgeHooks.getBurnTime(stack, RecipeType.SMELTING) > 0;
//	            }
//
//	            @Nonnull
//	            @Override
//	            public ItemStack insertItem(int slot, @Nonnull ItemStack stack, boolean simulate) {
//	                if (ForgeHooks.getBurnTime(stack, RecipeType.SMELTING) <= 0) {
//	                    return stack;
//	                }
//	                return super.insertItem(slot, stack, simulate);
//	            }
		};
	}

	@Nonnull
	@Override
	public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
		if (cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
			return handler.cast();
		}
		if (cap == CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY) {
			return fluidHandler.cast();
		}
		return super.getCapability(cap, side);
	}

	public LazyOptional<IFluidHandler> getFluidCap() {
		return fluidHandler;
	}

	@Override
	public int getTanks() {

		return 1;
	}

	@Override
	public FluidStack getFluidInTank(int tank) {

		return this.fluidStack.copy();
	}

	@Override
	public int getTankCapacity(int tank) {

		return capacity;
	}

	@Override
	public boolean isFluidValid(int tank, FluidStack stack) {

		return true;
	}

	@Override
	public int fill(FluidStack resource, FluidAction action) {

		if (resource.isEmpty() || !(this.fluidStack.isEmpty() || this.fluidStack.isFluidEqual(resource)))
			return 0;

		int amount = Math.min(resource.getAmount(),
				this.getTankCapacity(this.getTanks()) - this.fluidStack.getAmount());
		if (action.execute()) {
			FluidStack newStack = resource.copy();
			newStack.setAmount(this.fluidStack.getAmount() + amount);
			this.fluidStack = newStack;
			this.setChanged();
		}
		return amount;

	}

	@Nonnull
	@Override
	public FluidStack drain(FluidStack resource, FluidAction action) {
		if (resource.isEmpty() || this.fluidStack.isEmpty() || !this.fluidStack.getFluid().isSame(resource.getFluid()))
			return FluidStack.EMPTY;
		int amount = Math.min(resource.getAmount(), this.fluidStack.getAmount());
		FluidStack returnStack = this.fluidStack.copy();

		returnStack.setAmount(amount);
		if (action.execute()) {
			this.fluidStack.shrink(amount);
			this.setChanged();
		}
		return returnStack;
	}

	@Override
	public FluidStack drain(int maxDrain, FluidAction action) {
		if (maxDrain <= 0 || this.fluidStack.isEmpty())
			return FluidStack.EMPTY;
		int amount = Math.min(maxDrain, this.fluidStack.getAmount());
		FluidStack returnStack = this.fluidStack.copy();
		returnStack.setAmount(amount);
		if (action.execute()) {
			this.fluidStack.shrink(amount);
			this.setChanged();
		}
		return returnStack;
	}

	public boolean interactWithItemFluidHandler(IFluidHandlerItem fluidHandler) {
		if (fluidHandler.getTanks() == 0)
			return false;

		FluidStack tankFluid = fluidHandler.getFluidInTank(1);

		if (tankFluid.isEmpty()) {
			if (!this.fluidStack.isEmpty()) {
				int amount = fluidHandler.fill(this.fluidStack.copy(), FluidAction.SIMULATE);
				if (amount > 0 && this.isFluidValid(1, this.fluidStack)) {
					amount = fluidHandler.fill(this.fluidStack.copy(), FluidAction.EXECUTE);
					this.fluidStack.shrink(amount);
					this.setChanged();
					level.sendBlockUpdated(worldPosition, getBlockState(), getBlockState(), 3);
					return true;
				}
			}
		} else if (this.fluidStack.isEmpty() || this.fluidStack.isFluidEqual(tankFluid)) {
			tankFluid = tankFluid.copy();
			tankFluid.setAmount(this.getTankCapacity(1) - this.fluidStack.getAmount());
			FluidStack amount = fluidHandler.drain(tankFluid, FluidAction.EXECUTE);
			if (!amount.isEmpty() && (this.fluidStack.isEmpty() || this.fluidStack.isFluidEqual(amount))) {
				amount.grow(this.fluidStack.getAmount());
				this.fluidStack = amount;
				this.setChanged();
				level.sendBlockUpdated(worldPosition, getBlockState(), getBlockState(), 3);
				return true;
			}
		}
		return false;
	}
}
