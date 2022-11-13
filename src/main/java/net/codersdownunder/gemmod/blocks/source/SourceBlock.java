package net.codersdownunder.gemmod.blocks.source;

import jdk.dynalink.beans.StaticClass;
import net.codersdownunder.gemmod.Geomancy;
import net.codersdownunder.gemmod.blocks.dipper.DipperBlockEntity;
import net.codersdownunder.gemmod.init.BlockEntityInit;
import net.codersdownunder.gemmod.init.BlockInit;
import net.codersdownunder.gemmod.utils.GeomancyTags;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.fluids.FluidActionResult;
import net.minecraftforge.fluids.FluidUtil;
import net.minecraftforge.items.wrapper.PlayerInvWrapper;
import org.jetbrains.annotations.Nullable;

import java.util.stream.Stream;

public class SourceBlock extends Block implements EntityBlock {

    private static final VoxelShape SHAPE = Stream.of(
            Block.box(0, 0, 15, 1, 16, 16),
            Block.box(15, 0, 15, 16, 16, 16),
            Block.box(15, 0, 0, 16, 16, 1),
            Block.box(0, 0, 0, 1, 16, 1),
            Block.box(1, 15, 15, 15, 16, 16),
            Block.box(1, 0, 15, 15, 1, 16),
            Block.box(1, 15, 0, 15, 16, 1),
            Block.box(1, 0, 0, 15, 1, 1),
            Block.box(0, 15, 1, 1, 16, 15),
            Block.box(0, 0, 1, 1, 1, 15),
            Block.box(15, 0, 1, 16, 1, 15),
            Block.box(15, 15, 1, 16, 16, 15),
            Block.box(1, 1, 0, 2, 2, 1),
            Block.box(14, 1, 0, 15, 2, 1),
            Block.box(1, 14, 0, 2, 15, 1),
            Block.box(14, 14, 0, 15, 15, 1),
            Block.box(1, 1, 15, 2, 2, 16),
            Block.box(14, 1, 15, 15, 2, 16),
            Block.box(1, 14, 15, 2, 15, 16),
            Block.box(14, 14, 15, 15, 15, 16),
            Block.box(0, 1, 14, 1, 2, 15),
            Block.box(0, 1, 1, 1, 2, 2),
            Block.box(0, 14, 14, 1, 15, 15),
            Block.box(0, 14, 1, 1, 15, 2),
            Block.box(15, 1, 14, 16, 2, 15),
            Block.box(15, 1, 1, 16, 2, 2),
            Block.box(15, 14, 14, 16, 15, 15),
            Block.box(15, 14, 1, 16, 15, 2),
            Block.box(14, 0, 14, 15, 1, 15),
            Block.box(14, 0, 1, 15, 1, 2),
            Block.box(1, 0, 14, 2, 1, 15),
            Block.box(1, 0, 1, 2, 1, 2),
            Block.box(14, 15, 14, 15, 16, 15),
            Block.box(14, 15, 1, 15, 16, 2),
            Block.box(1, 15, 14, 2, 16, 15),
            Block.box(1, 15, 1, 2, 16, 2),
            Block.box(1, 1, 0.5, 15, 15, 0.5),
            Block.box(1, 1, 15.5, 15, 15, 15.5),
            Block.box(15.5, 1, 1, 15.5, 15, 15),
            Block.box(0.5, 1, 1, 0.5, 15, 15),
            Block.box(1, 0.5, 1, 15, 0.5, 15),
            Block.box(1, 15.5, 1, 15, 15.5, 15)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

    private final Fluid fluid;

    public SourceBlock(Properties pProperties, Fluid fluid) {
        super(pProperties);
        this.fluid = fluid;
    }

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return SHAPE;
    }

    @Override
    public RenderShape getRenderShape(BlockState pState) {
        return RenderShape.MODEL;
    }

    @Override
    public VoxelShape getCollisionShape(BlockState pState, BlockGetter pLevel, BlockPos pPos,
                                        CollisionContext pContext) {

        return SHAPE;
    }

    @Override
    public VoxelShape getInteractionShape(BlockState pState, BlockGetter pLevel, BlockPos pPos) {
        return SHAPE;
    }

    public SourceBlockEntity getTank(BlockGetter world, BlockPos pos) {
        return (SourceBlockEntity) world.getBlockEntity(pos);
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos,
                                 Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {

        ItemStack held = pPlayer.getItemInHand(pHand);

        if (held.getCapability(ForgeCapabilities.ITEM_HANDLER).isPresent() ||
                FluidUtil.interactWithFluidHandler(pPlayer, pHand, pLevel, pPos, pHit.getDirection())) {
            getTank(pLevel, pPos).getCapability(ForgeCapabilities.FLUID_HANDLER).ifPresent( handler -> {
                PlayerInvWrapper invWrapper = new PlayerInvWrapper(pPlayer.getInventory());
                FluidActionResult fillResult = FluidUtil.tryFillContainerAndStow(held, handler, invWrapper, Integer.MAX_VALUE, pPlayer, true);
                if (fillResult.isSuccess() && !pLevel.isClientSide()) {
                    pPlayer.setItemInHand(pHand, fillResult.getResult());
                }
            });
            return InteractionResult.SUCCESS;
        }
        return InteractionResult.PASS;
    }



    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return BlockEntityInit.SOURCE_BE.get().create(pPos, pState);
    }
}
