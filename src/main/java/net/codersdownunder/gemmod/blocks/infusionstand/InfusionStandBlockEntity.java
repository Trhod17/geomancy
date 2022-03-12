package net.codersdownunder.gemmod.blocks.infusionstand;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import net.codersdownunder.gemmod.init.TileEntityInit;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;

public class InfusionStandBlockEntity extends BlockEntity {

    public static final int INPUT_SLOTS = 6;
    public static final int OUTPUT_SLOTS = 3;

    private ItemStackHandler itemHandler = createHandler();

    private final LazyOptional<IItemHandler> handler = LazyOptional.of(() -> itemHandler);
    
    public int data;
    public boolean crafting = false;

    public InfusionStandBlockEntity(BlockPos pos, BlockState blockState) {
        super(TileEntityInit.INFUSION_STAND_BE.get(), pos, blockState);
    }
    
    public ItemStackHandler getItemStackHandler() {
        return itemHandler;
    }
   
    public static int getInputSlots()
    {
        return 9;
    }
 
    @Override
    public void setRemoved() {
        super.setRemoved();
        handler.invalidate();
    }

    @Override
    protected void saveAdditional(CompoundTag pTag) {
    	super.saveAdditional(pTag);
    	 pTag.put("inv", itemHandler.serializeNBT());
    }
    

    
    @Override
    public void load(CompoundTag tag) {
        itemHandler.deserializeNBT(tag.getCompound("inv"));

        super.load(tag);
    }
    


//    @Nullable
//    @Override
//    public SUpdateTileEntityPacket getUpdatePacket() {
//
//        return new SUpdateTileEntityPacket(this.worldPosition, 24, getUpdateTag());
//
//    }
//
//    @Override
//    public void onDataPacket(NetworkManager net, SUpdateTileEntityPacket pkt) {
//        load(this.getBlockState(), pkt.getTag());
//    }
//
//    @Override
//    public CompoundNBT getUpdateTag() {
//        CompoundNBT nbt = new CompoundNBT();
//        save(nbt);
//        return nbt;
//    }
//
//    @Override
//    public void handleUpdateTag(BlockState state, CompoundNBT tag) {
//        load(state, tag);
//        
//    }


    private ItemStackHandler createHandler() {
        return new ItemStackHandler(9) {
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
                return 1;
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
        if (cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
            return handler.cast();
        }
        return super.getCapability(cap, side);
    }

    public void craft() {
       SimpleContainer inv = new SimpleContainer(itemHandler.getSlots());
            
            inv.setItem(0, itemHandler.getStackInSlot(0));
            inv.setItem(1, itemHandler.getStackInSlot(1));
            inv.setItem(2, itemHandler.getStackInSlot(2));
            inv.setItem(3, itemHandler.getStackInSlot(3));
            inv.setItem(4, itemHandler.getStackInSlot(4));
            inv.setItem(5, itemHandler.getStackInSlot(5));
            inv.setItem(6, itemHandler.getStackInSlot(6));
          
            //System.out.println(inv + " " + level);
          
          if (level == null) {
              return;
          }
          
//        InfusingRecipe recipe = level.getRecipeManager().getRecipeFor(ModRecipeTypes.INFUSING_RECIPE, inv, level).orElse(null);
//        
//            if (recipe == null) {
//                return;
//            }
//            
//            //if (InfusingRecipes.getAll(level).)
//            
//            ItemStack output = recipe.getResultItem();
//            craftTheItem(output);
//            setChanged();
//            //System.out.println(recipe.getIngredients());
////            crafting = false;
//            
////        recipe.ifPresent(iRecipe -> {
////            ItemStack output = iRecipe.getResultItem();
////            craftTheItem(output);
////            setChanged();
////        });
    }

    @SuppressWarnings("unused")
	private void craftTheItem(ItemStack output) {
        
        itemHandler.extractItem(0, 1, false);
        itemHandler.extractItem(1, 1, false);
        itemHandler.extractItem(2, 1, false);
        itemHandler.extractItem(3, 1, false);
        itemHandler.extractItem(4, 1, false);
        itemHandler.extractItem(5, 1, false);
        itemHandler.extractItem(6, 1, false);
        itemHandler.insertItem(6, output, false);
    }
    
    
    
    
//    @Nullable
//    @Override
//    public Container createMenu(int windowId, PlayerInventory playerIn, PlayerEntity playerEn) {
//        return InfusionTableContainer.createContainerServerSide(windowId, playerIn, tile,
//                inputContents, outputContents, infusionTableStateData);
//    }
//    
//    @Override
//    public ITextComponent getDisplayName() {
//        return new TranslationTextComponent("screen.gemmod.infusion_table.text");
//    }
//    
    

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
