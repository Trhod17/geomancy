package net.codersdownunder.gemmod.blocks.terra;

import net.codersdownunder.gemmod.init.BlockEntityInit;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class TerraFirmaBlockEntity extends BlockEntity {

	private static final int INPUT_SLOTS = 2;
	private static final int OUTPUT_SLOTS = 1;

    private ItemStackHandler itemHandler = createHandler();

    private final LazyOptional<IItemHandler> handler = LazyOptional.of(() -> itemHandler);
    
    public int data;

    public TerraFirmaBlockEntity(BlockPos pos, BlockState blockState) {
        super(BlockEntityInit.TERRA_FIRMA_BE.get(), pos, blockState);
    }
    
    public ItemStackHandler getItemStackHandler() {
        return itemHandler;
    }
    
    public static int getOutputSlots() {
		return OUTPUT_SLOTS;
	}
   
    public static int getInputSlots()
    {
        return INPUT_SLOTS;
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
        return new ItemStackHandler(TerraFirmaBlockEntity.getInputSlots() + TerraFirmaBlockEntity.getOutputSlots()) {
            @Override
            protected void onContentsChanged(int slot) {
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
                if(!isItemValid(slot, stack)) {
                    return stack;
                }

                return super.insertItem(slot, stack, simulate);
            }
        };
    }
    

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
        if (cap == ForgeCapabilities.ITEM_HANDLER) {
            return handler.cast();
        }
        return super.getCapability(cap, side);
    }

    public boolean canPlayerAccessInventory(Player playerIn){
        if(this.level.getBlockEntity(this.worldPosition) != this){
            return false;
        }

        final double X_CENTRE_OFFSET = 0.5;
        final double Y_CENTRE_OFFSET = 0.5;
        final double Z_CENTRE_OFFSET = 0.5;
        final double MAXIMUM_DIST_SQ = 8.0 * 8.0;

        return playerIn.distanceToSqr(worldPosition.getX() + X_CENTRE_OFFSET,
                worldPosition.getY() + Y_CENTRE_OFFSET,
                worldPosition.getZ() + Z_CENTRE_OFFSET) < MAXIMUM_DIST_SQ;
    }
    

}
