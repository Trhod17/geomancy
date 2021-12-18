package net.codersdownunder.gemmod.blocks.sign;

import net.codersdownunder.gemmod.init.TileEntityInit;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.SignBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class CustomSignBlockEntity extends SignBlockEntity
{
    public CustomSignBlockEntity(BlockPos pWorldPosition, BlockState pBlockState) {
		super(pWorldPosition, pBlockState);
    }

	@Override
    public BlockEntityType<CustomSignBlockEntity> getType()
    {
        return TileEntityInit.CUSTOM_SIGN.get();
    }
}