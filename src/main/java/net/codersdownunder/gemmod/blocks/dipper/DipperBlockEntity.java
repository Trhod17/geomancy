package net.codersdownunder.gemmod.blocks.dipper;

import java.util.List;
import java.util.Objects;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import net.codersdownunder.gemmod.Config;
import net.codersdownunder.gemmod.crafting.recipe.ModRecipeTypes;
import net.codersdownunder.gemmod.crafting.recipe.dipping.DippingRecipe;
import net.codersdownunder.gemmod.init.TileEntityInit;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Connection;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.capability.CapabilityFluidHandler;
import net.minecraftforge.fluids.capability.IFluidHandler;
import net.minecraftforge.fluids.capability.IFluidHandler.FluidAction;
import net.minecraftforge.fluids.capability.templates.FluidTank;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;

public class DipperBlockEntity extends BlockEntity {

	private final ItemStackHandler itemHandler = createHandler();
    private FluidTank tank;

	private final LazyOptional<IItemHandler> handler = LazyOptional.of(() -> itemHandler);
	private final LazyOptional<IFluidHandler> fluidHandler = LazyOptional.of(() -> tank);
	
	private CompoundTag updateTag;
	
	public static int capacity = 4000;

	private static int processTime = Config.SERVER.dipperTime.get();
	public int counter;
	public int totalTime;
	private boolean valid;
	private boolean crafting;
	private ItemStack output;
	private int outputQuantity;
	private int fluidamount;

	public DipperBlockEntity(BlockPos pWorldPosition, BlockState pBlockState) {
		super(TileEntityInit.DIPPER_BE.get(), pWorldPosition, pBlockState);

		updateTag = getTileData();
		
		 this.tank = new FluidTank(capacity) {
	            @Override
	            public int fill(FluidStack resource, FluidAction action) {
	                int filled = super.fill(resource, action);
	                return resource.isFluidEqual(this.getFluid()) ? resource.getAmount() : filled;
	            }

	            @Override
	            protected void onContentsChanged() {
	            	setChanged();
	            	clientSync();
	            }
	        };

	}

	@SuppressWarnings("resource")
	public void clientSync() {
		if (Objects.requireNonNull(this.getLevel()).isClientSide) {
			return;
		}
		ServerLevel world = (ServerLevel) this.getLevel();
		List<ServerPlayer> entities = world.getChunkSource().chunkMap.getPlayers(new ChunkPos(this.worldPosition),
				false);
		ClientboundBlockEntityDataPacket updatePacket = this.getUpdatePacket();
		entities.forEach(e -> {
			if (updatePacket != null) {
				e.connection.send(updatePacket);
			}
		});
	}


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
					
					if (tank.getFluidAmount() >= fluidamount) {
					attemptCraft(output, fluidamount);
					level.sendBlockUpdated(worldPosition, getBlockState(), getBlockState(), 2);
					totalTime = 0;
					crafting = false;
					setChanged();
					}
				}
			}
			
			if (isRecipeValid() && !crafting) {
				counter = processTime;
				outputQuantity = outputQuantity();
				totalTime = counter;
				crafting = true;
				setChanged();
			}
		}
		
		
	}
	
	private int outputQuantity() {
		
		ItemStack concoction1 = itemHandler.getStackInSlot(21);
		ItemStack concoction2 = itemHandler.getStackInSlot(20);
		ItemStack concoction3 = itemHandler.getStackInSlot(19);
		ItemStack concoction4 = itemHandler.getStackInSlot(18);
		
		if (concoction1.isEmpty()) {
			return 1;
		} else {
			if (concoction2.isEmpty()) {
				shrink(21, 1);
				return 2;
			}
			
			if (concoction3.isEmpty()) {
				shrink(21, 1);
				shrink(20, 1);
				return 4;
			}
			
			if (concoction4.isEmpty()) {
				shrink(21, 1);
				shrink(20, 1);
				shrink(19, 1);
				return 8;
			}
			
			if (!concoction1.isEmpty() && !concoction2.isEmpty() && !concoction3.isEmpty() && !concoction4.isEmpty()) {
				shrink(21, 1);
				shrink(20, 1);
				shrink(19, 1);
				shrink(18, 1);
				return 16;
			}
		}

		
		return processTime;
	}
	
	private void shrink(int slot, int amount) {
		ItemStack stack = itemHandler.getStackInSlot(slot);
		if (stack.isDamageableItem()) {
			if (stack.getDamageValue() > 1 || !stack.isDamaged()) {
			stack.setDamageValue(stack.getDamageValue() - 1);
			} else {
				itemHandler.extractItem(slot, 1, false);
			}
		} else {
			itemHandler.extractItem(slot, 1, false);
		}
	}

	private boolean isRecipeValid() {

		SimpleContainer inv = new SimpleContainer(itemHandler.getSlots());
		
		inv.setItem(0, itemHandler.getStackInSlot(4));
		inv.setItem(1, itemHandler.getStackInSlot(5));
		inv.setItem(2, itemHandler.getStackInSlot(6));
		inv.setItem(3, itemHandler.getStackInSlot(7));
		inv.setItem(4, itemHandler.getStackInSlot(8));
		inv.setItem(5, itemHandler.getStackInSlot(9));
		inv.setItem(6, itemHandler.getStackInSlot(10));
		inv.setItem(7, itemHandler.getStackInSlot(11));
		inv.setItem(8, itemHandler.getStackInSlot(12));
		inv.setItem(9, itemHandler.getStackInSlot(13));
		inv.setItem(10, itemHandler.getStackInSlot(14));
		inv.setItem(11, itemHandler.getStackInSlot(15));
		inv.setItem(12, itemHandler.getStackInSlot(16));
		inv.setItem(13, itemHandler.getStackInSlot(17));

		if (level == null) {
			valid = false;
			
			return false;
			
		}
		//System.out.println(inv);
		DippingRecipe recipe = level.getRecipeManager().getRecipeFor(ModRecipeTypes.DIPPING_RECIPE, inv, level)
				.orElse(null);
		//System.out.print(recipe);
		if (recipe == null) {
			valid = false;
			
			return false;
		}
		
		if (!itemHandler.getStackInSlot(0).isEmpty() && !itemHandler.getStackInSlot(1).isEmpty() && !itemHandler.getStackInSlot(2).isEmpty() && !itemHandler.getStackInSlot(3).isEmpty()) {
		
			valid = true;
			output = recipe.getResultItem();
			fluidamount = recipe.getFluidAmount();
			return true;
		} else {
			return false;
		}
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
		itemHandler.insertItem(22, new ItemStack(output.getItem(), outputQuantity), false);
		tank.drain(fluidamount, FluidAction.EXECUTE);
		//tank.getFluidInTank(1).shrink(fluidamount);
		
		//tank.drain(1000, FluidAction.EXECUTE);
		counter = 0;
	}
	
	  @Override
	    public CompoundTag getUpdateTag() {
	        this.saveAdditional(updateTag);
	        return updateTag;
	    }

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
	        this.load(pkt.getTag());
	    }

	    @SuppressWarnings("resource")
		public void sendToClients() {
	        if (this.getLevel().isClientSide()) {
	            return;
	        }

	        ServerLevel world = (ServerLevel) this.getLevel();
	        List<ServerPlayer> entities = world.getChunkSource().chunkMap.getPlayers(new ChunkPos(this.getBlockPos()), false);
	        ClientboundBlockEntityDataPacket packet = this.getUpdatePacket();
	        entities.forEach(e -> e.connection.send(packet));
	        setChanged();
	    }

	    @Override
	    public void load(CompoundTag tag) {
	        super.load(tag);
	        itemHandler.deserializeNBT(tag.getCompound("inventory"));
	        counter = tag.getInt("counter");
	        crafting = tag.getBoolean("crafting");
	        valid = tag.getBoolean("valid");
	        tank.readFromNBT(tag.getCompound("fluid"));
	    }
	    
//	    @Override
//	    public CompoundTag save(CompoundTag tag) {
//	    	super.saveAdditional(tag);
//	    	return tag;
//	    }

	    @Override
	    protected void saveAdditional(CompoundTag pTag) {
	    	 //super.save(pTag);
	    	 CompoundTag fluid = new CompoundTag();
		     pTag.put("inventory", itemHandler.serializeNBT());
		     pTag.putInt("counter", counter);
		     pTag.putBoolean("crafting", crafting);
		     pTag.putBoolean("valid", valid);
		     tank.writeToNBT(fluid);
		     pTag.put("fluid", fluid);
		     super.saveAdditional(pTag);
		    
	    }

	
	@Override
	public void onLoad() {
		super.onLoad();
	}

    public FluidStack getFluid() {
        return this.tank.getFluid();
    }
//
//	public FluidTank getTank() {
//		return this.tank;
//	}

	private ItemStackHandler createHandler() {
		return new ItemStackHandler(24) {

			@Override
			protected void onContentsChanged(int slot) {
				setChanged();
				level.sendBlockUpdated(worldPosition, getBlockState(), getBlockState(), 2 | 4);
				counter = 0;
				crafting = false;
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

    public FluidTank getTank() {
        return this.tank;
    }

//	@Override
//	public int getTanks() {
//
//		return 1;
//	}
//
//	@Override
//	public FluidStack getFluidInTank(int tank) {
//
//		return this.tank.getFluid();
//	}
//
//	@Override
//	public int getTankCapacity(int tank) {
//
//		return capacity;
//	}
//
//	@Override
//	public boolean isFluidValid(int tank, FluidStack stack) {
//
//		return true;
//	}
//
//	public boolean interactWithItemFluidHandler(IFluidHandlerItem fluidHandler) {
//		if (fluidHandler.getTanks() == 0)
//			return false;
//
//		FluidStack tankFluid = fluidHandler.getFluidInTank(1);
//
//		if (tankFluid.isEmpty()) {
//			if (!this.tank.isEmpty()) {
//				int amount = fluidHandler.fill(this.tank.getFluid(), FluidAction.SIMULATE);
//				if (amount > 0) {
//					amount = fluidHandler.fill(this.tank.getFluid(), FluidAction.EXECUTE);
//					fluidHandler.drain(amount, FluidAction.EXECUTE);
//					this.setChanged();
//					level.sendBlockUpdated(worldPosition, getBlockState(), getBlockState(), 3);
//					return true;
//				}
//			}
//		} else if (this.tank.isEmpty()) {
//			tankFluid = tankFluid.copy();
//			tankFluid.setAmount(this.tank.getCapacity() - this.tank.getFluidAmount());
//			FluidStack amount = fluidHandler.drain(tankFluid, FluidAction.EXECUTE);
//			if (!amount.isEmpty() && (this.tank.isEmpty())) {
//				amount.grow(this.tank.getFluidAmount());
//				this.fluidStack = amount;
//				this.setChanged();
//				level.sendBlockUpdated(worldPosition, getBlockState(), getBlockState(), 3);
//				return true;
//			}
//		}
//		return false;
//	}

}
