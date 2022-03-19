package net.codersdownunder.gemmod.blocks.infusion;

import net.codersdownunder.gemmod.blocks.dipper.DipperMenu;
import net.codersdownunder.gemmod.crafting.recipe.ModRecipeTypes;
import net.codersdownunder.gemmod.crafting.recipe.infusing.InfusingRecipe;
import net.codersdownunder.gemmod.init.TileEntityInit;
import net.codersdownunder.gemmod.utils.AutomatableItemStackHandler;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class InfusionTableBlockEntity extends BlockEntity {

    private AutomatableItemStackHandler itemHandler = createHandler();

    private final LazyOptional<IItemHandler> handler = LazyOptional.of(() -> itemHandler);

    public int data;
    public boolean crafting = false;

    public InfusionTableBlockEntity(BlockPos pos, BlockState blockState) {
        super(TileEntityInit.INFUSION_TABLE.get(), pos, blockState);
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

    public void craft() {
        if (level == null) {
            return;
        }

        SimpleContainer inv = new SimpleContainer(itemHandler.getSlots());

        inv.setItem(0, itemHandler.getStackInSlot(0));
        inv.setItem(1, itemHandler.getStackInSlot(1));
        inv.setItem(2, itemHandler.getStackInSlot(2));
        inv.setItem(3, itemHandler.getStackInSlot(3));
        inv.setItem(4, itemHandler.getStackInSlot(4));
        inv.setItem(5, itemHandler.getStackInSlot(5));
        inv.setItem(6, itemHandler.getStackInSlot(InfusionTableMenu.BASE_SLOT));

        InfusingRecipe recipe = level.getRecipeManager().getRecipeFor(ModRecipeTypes.INFUSING_RECIPE, inv, level).orElse(null);

        if (recipe == null) {
            return;
        }

        ItemStack output = recipe.getResultItem();
        ItemStack resultSlotStack = itemHandler.getStackInSlot(InfusionTableMenu.OUTPUT_SLOT);
        if (!resultSlotStack.isEmpty() && !output.getItem().equals(resultSlotStack.getItem())) {
            return;
        }

        if (resultSlotStack.isEmpty()) {
            resultSlotStack = output;
        } else {
            resultSlotStack.grow(output.getCount());
        }

        if (resultSlotStack.getCount() > resultSlotStack.getMaxStackSize()) {
            resultSlotStack.shrink(output.getCount());
            return;
        }

        itemHandler.setStackInSlot(InfusionTableMenu.OUTPUT_SLOT, resultSlotStack);

        for (int slot : new int[]{0, 1, 2, 3, 4, 5}) {
            itemHandler.extractItem(slot, 1, false, false);
        }
        itemHandler.extractItem(InfusionTableMenu.BASE_SLOT, 1, false, false);

        setChanged();
    }

    private AutomatableItemStackHandler createHandler() {
        return new AutomatableItemStackHandler(8) {
            @Override
            protected void onContentsChanged(int slot) {
                setChanged();
            }

            @Override
            public boolean isInputSlot(int slot) {
                return slot != InfusionTableMenu.OUTPUT_SLOT;
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
}
