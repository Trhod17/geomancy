package net.codersdownunder.gemmod.blocks.endtorch;

import net.codersdownunder.gemmod.init.ParticlesInit;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.TorchBlock;
import net.minecraft.world.level.block.state.BlockState;

public class EndTorchBlock extends TorchBlock {

    public EndTorchBlock(Properties pProperties) {
        super(pProperties, ParticleTypes.FLAME);
    }

    @Override
    public void animateTick(BlockState pState, Level pLevel, BlockPos pPos, RandomSource pRandom) {
        double d0 = (double)pPos.getX() + 0.5D;
        double d1 = (double)pPos.getY() + 0.7D;
        double d2 = (double)pPos.getZ() + 0.5D;
        pLevel.addParticle(ParticleTypes.SMOKE, d0, d1, d2, 0.0D, 0.0D, 0.0D);
        pLevel.addParticle(ParticlesInit.PURPLE_FLAME.get(), d0, d1, d2, 0.0D, 0.0D, 0.0D);
    }
}
