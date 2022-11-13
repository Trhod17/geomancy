package net.codersdownunder.gemmod.blocks;

import net.minecraft.world.level.block.FireBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

public class ScorchBlock extends FireBlock {

    public ScorchBlock(BlockBehaviour.Properties p_56653_) {
        super(p_56653_);
    }


    @Override
    protected boolean canBurn(BlockState pState) {
        return true;
    }
}
