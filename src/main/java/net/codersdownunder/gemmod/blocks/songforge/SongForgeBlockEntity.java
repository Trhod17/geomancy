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
	
    private ItemStackHandler itemHandler = createHandler();

    private final LazyOptional<IItemHandler> handler = LazyOptional.of(() -> itemHandler);
    
    public int data;

    public SongForgeBlockEntity(BlockPos pos, BlockState blockState) {
        super(TileEntityInit.SONG_FORGE_BE.get(), pos, blockState);
    }
    
    public ItemStackHandler getItemStackHandler() {
        return itemHandler;
    }
   
    public static int getSlots()
    {
        return INPUT_SLOTS + OUTPUT_SLOTS + FUEL_SLOTS + UPGRADE_SLOTS + 1;
    }
    
    public void tickServer() {
		
		if (level.isClientSide) return;
		
		
		
		if (!valid) {
			isRecipeValid();
		}
		
		if (valid) {
			attemptCraft(output);
			valid = false;
		}
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
		//System.out.println(inv);
		SmeltingRecipe recipe = level.getRecipeManager().getRecipeFor(RecipeType.SMELTING, inv, level)
				.orElse(null);
		//System.out.print(recipe);
		if (recipe == null) {
			valid = false;
			
			return false;
		}

			valid = true;
			output = recipe.getResultItem();
			return true;

	}
    
    private void attemptCraft(ItemStack output) {

		itemHandler.extractItem(input, 1, false);
		
		setOuput(output);
	}
    
    private void setOuput(ItemStack output) {
    	//TODO: figure out the item duplication bug
//    	var slot = ;
    	
    	if (itemHandler.getStackInSlot(getOuputSlot(output)).isEmpty()) {
    		itemHandler.insertItem(getOuputSlot(output), output, false);
    	}
    	
    	if (!itemHandler.getStackInSlot(getOuputSlot(output)).isEmpty() && itemHandler.getStackInSlot(getOuputSlot(output)) == output) {
    		if (itemHandler.getStackInSlot(getOuputSlot(output)).getCount() == 64) {
    			return;
    		} else {
    			itemHandler.getStackInSlot(getOuputSlot(output)).grow(1);
    		}
    	}
    }
    
    private int getOuputSlot(ItemStack output) {
    	var outputMin = 6;
    	var outputMax = 14;
    	
    	int slot = 0;
    	
    	for (int i = outputMin; i <= outputMax; i++) {
			if ((itemHandler.getStackInSlot(i).isEmpty() || itemHandler.getStackInSlot(i) == output) && itemHandler.getStackInSlot(i).getCount() < 64) {
				slot = i;
				break;
			}
		}
		return slot;
    	
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
        if (cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
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
