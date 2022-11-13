package net.codersdownunder.gemmod.blocks.source;

import net.codersdownunder.gemmod.init.BlockEntityInit;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluids;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.capability.IFluidHandler;
import net.minecraftforge.fluids.capability.templates.FluidTank;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;


public class SourceBlockEntity extends BlockEntity {

    public FluidTank tank;
    private final LazyOptional<IFluidHandler> optional = LazyOptional.of(() -> tank);

    public SourceBlockEntity(BlockPos pWorldPosition, BlockState pBlockState) {
        super(BlockEntityInit.SOURCE_BE.get(), pWorldPosition, pBlockState);

        tank = new FluidTank(Integer.MAX_VALUE) {
            @Override
            protected void onContentsChanged() {
                setChanged();
            }

            @Override
            public int fill(FluidStack resource, FluidAction action) {
                return 0;
            }
        };
        tank.setFluid(new FluidStack(Fluids.WATER, Integer.MAX_VALUE));
    }

    public FluidStack getFluid() {
        return this.tank.getFluid();
    }


    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
        if (cap == ForgeCapabilities.FLUID_HANDLER) {
            return optional.cast();
        }
        return super.getCapability(cap, side);
    }


}