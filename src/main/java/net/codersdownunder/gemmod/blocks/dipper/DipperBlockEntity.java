package net.codersdownunder.gemmod.blocks.dipper;

import net.codersdownunder.gemmod.Config;
import net.codersdownunder.gemmod.GemMod;
import net.codersdownunder.gemmod.crafting.recipe.ModRecipeTypes;
import net.codersdownunder.gemmod.crafting.recipe.dipping.DippingRecipe;
import net.codersdownunder.gemmod.init.TileEntityInit;
import net.codersdownunder.gemmod.utils.AutomatableItemStackHandler;
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
import org.apache.commons.lang3.ArrayUtils;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;
import java.util.Objects;

public class DipperBlockEntity extends BlockEntity {

    private final AutomatableItemStackHandler itemHandler = createHandler();
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
                if (attemptCraft(output, cachedRecipe.getFluidAmount())) {
                    isCrafting = false;
                    setChanged();
                    level.sendBlockUpdated(worldPosition, getBlockState(), getBlockState(), Block.UPDATE_CLIENTS);
                }
            }

            // Initiate crafting if valid recipe exists
            if (!isCrafting && hasValidRecipe() && (outputStack.isEmpty() || (outputStack.getItem().equals(cachedRecipe.getResultItem().getItem())))) {
                int qty = getOutputQuantity();
                if (outputStack.getCount() + qty <= outputStack.getMaxStackSize()) {
                    counter = Config.SERVER.dipperTime.get();
                    isCrafting = true;
                    setChanged();
                }
            }
        }
    }

    // TODO change to static and move to util class
    private void shrink(int slot, int amount) {
        ItemStack stack = itemHandler.getStackInSlot(slot);
        if (stack.isDamageableItem()) {
            if (stack.getDamageValue() + amount < stack.getMaxDamage() || !stack.isDamaged()) {
                stack.setDamageValue(stack.getDamageValue() + amount);
            } else {
                itemHandler.extractItem(slot, 1, false, false);
            }
        } else {
            itemHandler.extractItem(slot, 1, false, false);
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

    private boolean attemptCraft(ItemStack output, int fluidAmount) {
        int outputQuantity = getOutputQuantity();

        ItemStack resultSlotStack = itemHandler.getStackInSlot(DipperMenu.OUTPUT_SLOT);
        if (resultSlotStack.isEmpty()) {
            resultSlotStack = new ItemStack(output.getItem(), outputQuantity);
        } else {
            resultSlotStack.grow(outputQuantity);
        }

        // No crafting if the output slot is full
        if (resultSlotStack.getCount() > resultSlotStack.getMaxStackSize()) {
            resultSlotStack.shrink(outputQuantity);
            return false;
        }

        itemHandler.setStackInSlot(DipperMenu.OUTPUT_SLOT, resultSlotStack);

        for (int slot : DipperMenu.STRING_SLOTS) {
            itemHandler.extractItem(slot, 1, false, false);
        }
        for (int slot : DipperMenu.INPUT_SLOTS) {
            itemHandler.extractItem(slot, 1, false, false);
        }

        if (outputQuantity >= 2) {
            shrink(DipperMenu.CONCOCTION_1_SLOT, 1);
        }
        if (outputQuantity >= 4) {
            shrink(DipperMenu.CONCOCTION_2_SLOT, 1);
        }
        if (outputQuantity >= 8) {
            shrink(DipperMenu.CONCOCTION_3_SLOT, 1);
        }
        if (outputQuantity == 16) {
            shrink(DipperMenu.CONCOCTION_4_SLOT, 1);
        }

        tank.drain(fluidAmount, FluidAction.EXECUTE);

        counter = 0;

        return true;
    }

    private int getOutputQuantity() {
        ItemStack concoction1 = itemHandler.getStackInSlot(DipperMenu.CONCOCTION_1_SLOT);
        ItemStack concoction2 = itemHandler.getStackInSlot(DipperMenu.CONCOCTION_2_SLOT);
        ItemStack concoction3 = itemHandler.getStackInSlot(DipperMenu.CONCOCTION_3_SLOT);
        ItemStack concoction4 = itemHandler.getStackInSlot(DipperMenu.CONCOCTION_4_SLOT);

        int outputQuantity = 1;
        if (concoction1.is(GeomancyTags.Items.CONCOCTIONS_TIER_1)) {
            outputQuantity = 2;
        }
        if (outputQuantity == 2 && concoction2.is(GeomancyTags.Items.CONCOCTIONS_TIER_2)) {
            outputQuantity = 4;
        }
        if (outputQuantity == 4 && concoction3.is(GeomancyTags.Items.CONCOCTIONS_TIER_3)) {
            outputQuantity = 8;
        }
        if (outputQuantity == 8 && concoction4.is(GeomancyTags.Items.CONCOCTIONS_TIER_4)) {
            outputQuantity = 16;
        }

        return outputQuantity;
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

    private AutomatableItemStackHandler createHandler() {
        return new AutomatableItemStackHandler(24) {

            @Override
            protected void onContentsChanged(int slot) {
                if (!hasValidRecipe()) {
                    counter = 0;
                    isCrafting = false;
                }
                setChanged();
                level.sendBlockUpdated(worldPosition, getBlockState(), getBlockState(), Block.UPDATE_CLIENTS | Block.UPDATE_INVISIBLE);
            }

            @Override
            public boolean isInputSlot(int slot) {
                return slot != DipperMenu.OUTPUT_SLOT;
            }

            @Override
            public boolean isInputSlotItem(int slot, ItemStack stack) {
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

                return super.isInputSlotItem(slot, stack);
            }
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
}
