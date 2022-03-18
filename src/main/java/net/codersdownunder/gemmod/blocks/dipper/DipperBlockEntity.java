package net.codersdownunder.gemmod.blocks.dipper;

import net.codersdownunder.gemmod.Config;
import net.codersdownunder.gemmod.crafting.recipe.ModRecipeTypes;
import net.codersdownunder.gemmod.crafting.recipe.dipping.DippingRecipe;
import net.codersdownunder.gemmod.init.TileEntityInit;
import net.codersdownunder.gemmod.utils.GeomancyTags;
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
import net.minecraft.world.level.block.Block;
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
import org.apache.commons.lang3.ArrayUtils;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;
import java.util.Objects;

public class DipperBlockEntity extends BlockEntity {

    private final ItemStackHandler itemHandler = createHandler();
    private FluidTank tank;

    private final LazyOptional<IItemHandler> handler = LazyOptional.of(() -> itemHandler);
    private final LazyOptional<IFluidHandler> fluidHandler = LazyOptional.of(() -> tank);

    private CompoundTag updateTag;

    public static int capacity = 4000;

    private DippingRecipe cachedRecipe = null;
    public int counter;
    private boolean valid;
    private boolean isCrafting;
    private ItemStack output;
    private int outputQuantity;

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
        if (level == null || level.isClientSide) return;

        if (counter > 0 && isCrafting) {
            counter--;
            setChanged();
            level.sendBlockUpdated(worldPosition, getBlockState(), getBlockState(), Block.UPDATE_CLIENTS);
        } else {
            ItemStack outputStack = itemHandler.getStackInSlot(DipperMenu.OUTPUT_SLOT);
            // Complete crafting
            if (isCrafting && hasValidRecipe() && cachedRecipe != null && (outputStack.isEmpty() || outputStack.getItem().equals(cachedRecipe.getResultItem().getItem()))) {
                isCrafting = false;
                attemptCraft(output, cachedRecipe.getFluidAmount());
                setChanged();
                level.sendBlockUpdated(worldPosition, getBlockState(), getBlockState(), Block.UPDATE_CLIENTS);
            }

            // Initiate crafting if valid recipe exists
            if (!isCrafting && hasValidRecipe() && (outputStack.isEmpty() || outputStack.getItem().equals(cachedRecipe.getResultItem().getItem()))) {
                counter = Config.SERVER.dipperTime.get();
                isCrafting = true;
                setChanged();
            }
        }
    }

    private void setOutputQuantity() {
        ItemStack concoction1 = itemHandler.getStackInSlot(21);
        ItemStack concoction2 = itemHandler.getStackInSlot(20);
        ItemStack concoction3 = itemHandler.getStackInSlot(19);
        ItemStack concoction4 = itemHandler.getStackInSlot(18);

        outputQuantity = 1;
        if (concoction1.is(GeomancyTags.Items.CONCOCTIONS_TIER_1)) {
            shrink(DipperMenu.CONCOCTION_1_SLOT, 1);
            outputQuantity = 2;
        }

        if (outputQuantity == 2 && concoction2.is(GeomancyTags.Items.CONCOCTIONS_TIER_2)) {
            shrink(DipperMenu.CONCOCTION_2_SLOT, 1);
            outputQuantity = 4;
        }

        if (outputQuantity == 4 && concoction3.is(GeomancyTags.Items.CONCOCTIONS_TIER_3)) {
            shrink(DipperMenu.CONCOCTION_3_SLOT, 1);
            outputQuantity = 8;
        }

        if (outputQuantity == 8 && concoction4.is(GeomancyTags.Items.CONCOCTIONS_TIER_4)) {
            shrink(DipperMenu.CONCOCTION_4_SLOT, 1);
            outputQuantity = 16;
        }
    }

    // TODO change to static and move to util class
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

    private boolean hasValidRecipe() {
        if (level == null) {
            return false;
        }
        valid = false;

        // Check if string slots have string
        for (int stringSlot : DipperMenu.STRING_SLOTS) {
            if (itemHandler.getStackInSlot(stringSlot).isEmpty()) {
                return false;
            }
        }

        SimpleContainer inv = new SimpleContainer(itemHandler.getSlots());
        int index = 0;
        for (int inputSlot : DipperMenu.INPUT_SLOTS) {
            inv.setItem(index++, itemHandler.getStackInSlot(inputSlot));
        }

        DippingRecipe recipe = cachedRecipe;
        if (recipe == null || !recipe.matches(inv, level)) {
            recipe = level.getRecipeManager().getRecipeFor(ModRecipeTypes.DIPPING_RECIPE, inv, level).orElse(null);
        }

        boolean hasValidFluid = false;
        if (recipe != null) {
            cachedRecipe = recipe;
            valid = true;
            output = recipe.getResultItem();

            for (FluidStack fluid : recipe.getFluids()) {
                hasValidFluid = hasValidFluid || (fluid.getFluid().equals(tank.getFluid().getFluid()) && recipe.getFluidAmount() <= tank.getFluidAmount());
            }
        }

        return valid && hasValidFluid;
    }

    private void attemptCraft(ItemStack output, int fluidAmount) {
        setOutputQuantity();

        for (int slot : DipperMenu.STRING_SLOTS) {
            itemHandler.extractItem(slot, 1, false);
        }
        for (int slot : DipperMenu.INPUT_SLOTS) {
            itemHandler.extractItem(slot, 1, false);
        }

        itemHandler.insertItem(DipperMenu.OUTPUT_SLOT, new ItemStack(output.getItem(), outputQuantity), false);

        tank.drain(fluidAmount, FluidAction.EXECUTE);

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
        isCrafting = tag.getBoolean("crafting");
        valid = tag.getBoolean("valid");
        tank.readFromNBT(tag.getCompound("fluid"));
    }

    @Override
    protected void saveAdditional(CompoundTag pTag) {
        CompoundTag fluid = new CompoundTag();
        pTag.put("inventory", itemHandler.serializeNBT());
        pTag.putInt("counter", counter);
        pTag.putBoolean("crafting", isCrafting);
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
                if (!hasValidRecipe()) {
                    counter = 0;
                    isCrafting = false;
                }
                setChanged();
                level.sendBlockUpdated(worldPosition, getBlockState(), getBlockState(), Block.UPDATE_CLIENTS | Block.UPDATE_INVISIBLE);
            }

            //            @Override
//            public int getSlotLimit(int slot) {
//                return ArrayUtils.contains(DipperMenu.STRING_SLOTS, slot) || slot == DipperMenu.QUARTZ_SLOT ? 1 : 64;
//            }
//
            @Override
            public boolean isItemValid(int slot, @Nonnull ItemStack stack) {
                if (slot == DipperMenu.CONCOCTION_1_SLOT && !stack.is(GeomancyTags.Items.CONCOCTIONS_TIER_1)) {
                    return false;
                }
                if (slot == DipperMenu.CONCOCTION_2_SLOT && !stack.is(GeomancyTags.Items.CONCOCTIONS_TIER_2)) {
                    return false;
                }
                if (slot == DipperMenu.CONCOCTION_3_SLOT && !stack.is(GeomancyTags.Items.CONCOCTIONS_TIER_3)) {
                    return false;
                }
                if (slot == DipperMenu.CONCOCTION_4_SLOT && !stack.is(GeomancyTags.Items.CONCOCTIONS_TIER_4)) {
                    return false;
                }
                if (ArrayUtils.contains(DipperMenu.STRING_SLOTS, slot) && !stack.is(GeomancyTags.Items.STRING)) {
                    return false;
                }

                return slot != DipperMenu.OUTPUT_SLOT;
            }
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
