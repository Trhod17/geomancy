package net.codersdownunder.gemmod.blocks.songforge;

import net.codersdownunder.gemmod.init.BlockEntityInit;
import net.codersdownunder.gemmod.utils.AutomatableItemStackHandler;
import net.codersdownunder.gemmod.utils.WrappedHandler;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.AirItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.crafting.SmeltingRecipe;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Map;
import java.util.Optional;

public class SongForgeBlockEntity extends BlockEntity implements MenuProvider {

    private final AutomatableItemStackHandler itemHandler = createHandler();
    private LazyOptional<IItemHandler> lazyItemHandler = LazyOptional.empty();
    protected final ContainerData data;
    private int progress = 0;
    private int maxProgress = 78;
    private static int currentInput = 0;
    private static int firstAvailableOutput = 0;
    private boolean isBurning = false;
    private int maxFuel = 0;
    private int fuel = 0;
    private int currentFuelSlot = 0;

    public SongForgeBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(BlockEntityInit.SONG_FORGE_BE.get(), pPos, pBlockState);
        this.data = new ContainerData() {
            @Override
            public int get(int pIndex) {
                return switch (pIndex) {
                    case 0 -> SongForgeBlockEntity.this.progress;
                    case 1 -> SongForgeBlockEntity.this.maxProgress;
                    case 2 -> SongForgeBlockEntity.this.fuel;
                    case 3 -> SongForgeBlockEntity.this.maxFuel;
                    default -> 0;
                };
            }

            @Override
            public void set(int pIndex, int pValue) {
                switch (pIndex) {
                    case 0 -> SongForgeBlockEntity.this.progress = pValue;
                    case 1 -> SongForgeBlockEntity.this.maxProgress = pValue;
                    case 2 -> SongForgeBlockEntity.this.fuel = pValue;
                    case 3 -> SongForgeBlockEntity.this.maxFuel = pValue;
                }
                ;
            }

            @Override
            public int getCount() {
                return 4;
            }
        };
    }

    @Override
    public Component getDisplayName() {
        return Component.translatable("screen.geomancy.song_forge.text");
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int pContainerId, Inventory pPlayerInventory, Player pPlayer) {
        return new SongForgeMenu(pContainerId, pPlayerInventory, this, this.data);
    }

    private AutomatableItemStackHandler createHandler() {
        return new AutomatableItemStackHandler(19) {

            @Override
            protected void onContentsChanged(int slot) {
                setChanged();
            }

            @Override
            public boolean isInputSlot(int slot) {
                return slot < 6 || slot > 14;
            }

            @Override
            public boolean isInsertableSlot(int slot) {
                return slot < 6;
            }

            @Override
            public boolean isInputSlotItem(int slot, ItemStack stack) {

                if (slot > 14) {
                    return SongForgeUpgrades.isValidUpgrade(stack.getItem());
                }

                return true;
            }
        };
    }

    private final Map<Direction, LazyOptional<WrappedHandler>> directionWrappedHandlerMap =
            Map.of(Direction.DOWN, LazyOptional.of(() -> new WrappedHandler(itemHandler, (i) -> i >= 6 && i <= 14, (i, s) -> false)),
                    Direction.UP, LazyOptional.of(() -> new WrappedHandler(itemHandler, (i) -> false, (i, s) -> i >= 0 && i <= 2)),
                    Direction.NORTH, LazyOptional.of(() -> new WrappedHandler(itemHandler, (i) -> false, (i, s) -> i >= 3 && i <= 5)),
                    Direction.SOUTH, LazyOptional.of(() -> new WrappedHandler(itemHandler, (i) -> false, (i, s) -> i >= 3 && i <= 5)),
                    Direction.EAST, LazyOptional.of(() -> new WrappedHandler(itemHandler, (i) -> false, (i, s) -> i >= 3 && i <= 5)),
                    Direction.WEST, LazyOptional.of(() -> new WrappedHandler(itemHandler, (i) -> false, (i, s) -> i >= 3 && i <= 5)));

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if (cap == ForgeCapabilities.ITEM_HANDLER) {
            if (side == null) {
                return lazyItemHandler.cast();
            }

            if (directionWrappedHandlerMap.containsKey(side)) {
                Direction localDir = this.getBlockState().getValue(SongForgeBlock.FACING);

                if (side == Direction.UP || side == Direction.DOWN) {
                    return directionWrappedHandlerMap.get(side).cast();
                }

                return switch (localDir) {
                    default -> directionWrappedHandlerMap.get(side).cast();
                    case EAST -> directionWrappedHandlerMap.get(side.getClockWise()).cast();
                    case WEST -> directionWrappedHandlerMap.get(side.getCounterClockWise()).cast();
                };
            }
        }

        return super.getCapability(cap, side);
    }

    @Override
    public void onLoad() {
        super.onLoad();
        lazyItemHandler = LazyOptional.of(() -> itemHandler);
    }

    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
        lazyItemHandler.invalidate();
    }

    @Override
    protected void saveAdditional(CompoundTag nbt) {
        nbt.put("inventory", itemHandler.serializeNBT());
        nbt.putInt("song_forge.progress", progress);
        nbt.putInt("song_forge.max_progress", maxProgress);
        nbt.putBoolean("song_forge.burning", isBurning);
        nbt.putInt("song_forge.fuel", fuel);
        nbt.putInt("song_forge.max_fuel", maxFuel);
        super.saveAdditional(nbt);
    }

    @Override
    public void load(CompoundTag nbt) {
        super.load(nbt);
        itemHandler.deserializeNBT(nbt.getCompound("inventory"));
        progress = nbt.getInt("song_forge.progress");
        maxProgress = nbt.getInt("song_forge.max_progress");
        isBurning = nbt.getBoolean("song_forge.burning");
        fuel = nbt.getInt("song_forge.fuel");
        maxFuel = nbt.getInt("song_forge.max_fuel");
    }

    public void drops() {
        SimpleContainer inventory = new SimpleContainer(itemHandler.getSlots());
        for (int i = 0; i < itemHandler.getSlots(); i++) {
            inventory.setItem(i, itemHandler.getStackInSlot(i));
        }

        Containers.dropContents(this.level, this.worldPosition, inventory);
    }


    public static <E extends BlockEntity> void tick(Level level, BlockPos blockPos, BlockState blockState, SongForgeBlockEntity pEntity) {
        if (level.isClientSide()) return;

        if (pEntity.isBurning) {
            pEntity.fuel--;
        }

        if (hasRecipe(pEntity)) {
            //GemMod.LOGGER.info(hasFuelInFuelSlot(pEntity) + " " + !isConsumingFuel(pEntity));
            if (hasFuelInFuelSlot(pEntity) && !isConsumingFuel(pEntity)) {
                pEntity.consumeFuel(pEntity);
                blockState = blockState.setValue(SongForgeBlock.LIT, pEntity.isBurning);
                level.setBlock(blockPos, blockState, 3);
            }
            if (isConsumingFuel(pEntity)) {
                pEntity.progress++;
                setChanged(level, blockPos, blockState);
                if (pEntity.progress >= pEntity.maxProgress) {
                    craftItem(pEntity);
                }
            }

        } else {
            pEntity.resetProgress();
            setChanged(level, blockPos, blockState);
        }

        if (pEntity.fuel == 0) {
            pEntity.isBurning = false;
            blockState = blockState.setValue(SongForgeBlock.LIT, pEntity.isBurning);
            level.setBlock(blockPos, blockState, 3);
        }
    }

    private static void consumeFuel(SongForgeBlockEntity pEntity) {
        SimpleContainer inventory = new SimpleContainer(pEntity.itemHandler.getSlots());
        for (int i = 0; i < pEntity.itemHandler.getSlots(); i++) {
            inventory.setItem(i, pEntity.itemHandler.getStackInSlot(i));
        }

        int fuel_val = ForgeHooks.getBurnTime(inventory.getItem(pEntity.currentFuelSlot), RecipeType.SMELTING);
        if (fuel_val == pEntity.maxFuel) {
            pEntity.itemHandler.extractItem(pEntity.currentFuelSlot, 1, false, false);
            pEntity.fuel = fuel_val;
            pEntity.isBurning = true;
        } else {
            pEntity.itemHandler.extractItem(pEntity.currentFuelSlot, 1, false, false);
            pEntity.maxFuel = fuel_val;
            pEntity.fuel = fuel_val;
            pEntity.isBurning = true;
        }
    }

    private static boolean isConsumingFuel(SongForgeBlockEntity pEntity) {
        return pEntity.isBurning;
    }

    private static boolean hasFuelInFuelSlot(SongForgeBlockEntity pEntity) {
        Level level = pEntity.level;
        SimpleContainer inventory = new SimpleContainer(pEntity.itemHandler.getSlots());
        boolean fuelFound = false;
        for (int i = 0; i < pEntity.itemHandler.getSlots(); i++) {
            inventory.setItem(i, pEntity.itemHandler.getStackInSlot(i));

            if (!inventory.getItem(i).isEmpty() && i > 2 && i < 6) {
                pEntity.currentFuelSlot = i;
                fuelFound = true;
                break;
            }

        }

        return fuelFound;
    }


    private void resetProgress() {
        this.progress = 0;
    }

    private static void craftItem(SongForgeBlockEntity pEntity) {
        if (!pEntity.hasLevel()) return;

        Level level = pEntity.level;
        SimpleContainer inventory = new SimpleContainer(pEntity.itemHandler.getSlots());

        inventory.setItem(0, pEntity.itemHandler.getStackInSlot(currentInput));

        Optional<SmeltingRecipe> recipe = level.getRecipeManager()
                .getRecipeFor(RecipeType.SMELTING, inventory, level);

        if (hasRecipe(pEntity)) {
            pEntity.itemHandler.extractItem(currentInput, 1, false, false);
            pEntity.itemHandler.setStackInSlot(firstAvailableOutput, new ItemStack(recipe.get().getResultItem().getItem(),
                    pEntity.itemHandler.getStackInSlot(firstAvailableOutput).getCount() + 1));

            pEntity.resetProgress();
        }
    }

    private static boolean hasRecipe(SongForgeBlockEntity entity) {
        if (!entity.hasLevel()) return false;

        Level level = entity.level;
        SimpleContainer inventory = new SimpleContainer(entity.itemHandler.getSlots());
        Optional<SmeltingRecipe> recipe = null;
        boolean inputSelected = false;
        for (int i = 0; i < entity.itemHandler.getSlots(); i++) {
            inventory.setItem(i, entity.itemHandler.getStackInSlot(i));

            if (!inventory.getItem(i).isEmpty() && i < 3 && !inputSelected) {
                SimpleContainer subInv = new SimpleContainer(3);
                subInv.setItem(0, inventory.getItem(i));
                currentInput = i;
                recipe = level.getRecipeManager().getRecipeFor(RecipeType.SMELTING, subInv, level);
                //break;
                inputSelected = true;
            }

        }

        if (recipe == null) return false;

        try {
            entity.maxProgress = recipe.get().getCookingTime();
        } catch (Exception e) {
            return false;
        }


        return recipe.isPresent() && canInsertIntoOutputSlot(inventory, recipe.get().getResultItem());
    }

    private static boolean canInsertIntoOutputSlot(SimpleContainer inventory, ItemStack resultItem) {
        boolean availableSlot = false;
        //GemMod.LOGGER.info(inventory);
        for (int slot = 6; slot < 15; slot++) {
            availableSlot = (inventory.getItem(slot).getMaxStackSize() > inventory.getItem(slot).getCount()) &&
                    (inventory.getItem(slot).getItem() == resultItem.getItem() || inventory.getItem(slot).isEmpty());

            if (availableSlot) {
                firstAvailableOutput = slot;
                break;
            }
        }

        return availableSlot;
    }

    public boolean isUpgrade(ItemStack stack) {

        if (stack == null) return false;

        //Geomancy.LOGGER.info(SongForgeUpgrades.isValidUpgrade(stack.getItem()));
        return SongForgeUpgrades.isValidUpgrade(stack.getItem());
    }

    /*
    *  Used in FurnaceInputSlot
    */
    public boolean hasRecipe(ItemStack stack) {
        return getRecipe(stack).isPresent();
    }


    protected Optional<SmeltingRecipe> getRecipe(ItemStack item) {
        return (item.getItem() instanceof AirItem)
                ? Optional.empty()
                : Optional.ofNullable(this.level.getRecipeManager().getRecipeFor(RecipeType.SMELTING, new SimpleContainer(item), this.level).orElse(null));
    }
}