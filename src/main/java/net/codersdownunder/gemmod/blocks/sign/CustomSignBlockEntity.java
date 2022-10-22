package net.codersdownunder.gemmod.blocks.sign;

import net.codersdownunder.gemmod.init.BlockEntityInit;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.SignBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

import javax.annotation.Nonnull;

public class CustomSignBlockEntity extends SignBlockEntity
{
    public CustomSignBlockEntity(BlockPos pWorldPosition, BlockState pBlockState) {
		super(pWorldPosition, pBlockState);
    }

	@Override
    @Nonnull
    public BlockEntityType<CustomSignBlockEntity> getType()
    {
        return BlockEntityInit.CUSTOM_SIGN.get();
    }
}