package net.codersdownunder.gemmod.blocks.infusionstand;

import net.codersdownunder.gemmod.GemMod;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.network.NetworkHooks;

public class InfusionStandBlock extends Block implements SimpleWaterloggedBlock, EntityBlock {
    
//	private static final VoxelShape SHAPE = Stream.of(
//                Block.box(6, 1, 14, 10, 7, 14),
//                Block.box(1, 7, 1, 15, 12, 15),
//                Block.box(3, 2, 3, 13, 7, 13),
//                Block.box(2.5, 1, 2.5, 13.5, 2, 13.5),
//                Block.box(0, 8, 0, 16, 13, 16),
//                Block.box(2.5, 5, 2.5, 13.5, 6, 13.5),
//                Block.box(2.5, 2, 2.5, 13.5, 4, 13.5),
//                Block.box(0.25, 9, 0.25, 15.75, 11, 15.75),
//                Block.box(13, 2, 2, 14, 6, 3),
//                Block.box(2, 2, 13, 3, 6, 14),
//                Block.box(2, 2, 2, 3, 6, 3),
//                Block.box(13, 2, 13, 14, 6, 14),
//                Block.box(1, 0, 1, 3, 2, 3),
//                Block.box(13, 0, 1, 15, 2, 3),
//                Block.box(13, 0, 13, 15, 2, 15),
//                Block.box(1, 0, 13, 3, 2, 15),
//                Block.box(13, 6, 1, 15, 7, 3),
//                Block.box(1, 6, 1, 3, 7, 3),
//                Block.box(13, 6, 13, 15, 7, 15),
//                Block.box(1, 6, 13, 3, 7, 15),
//                Block.box(1.75, 0, 1.75, 14.25, 1, 14.25),
//                Block.box(2, 1, 6, 2, 7, 10),
//                Block.box(14, 1, 6, 14, 7, 10),
//                Block.box(6, 1, 2, 10, 7, 2)
//                ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();


    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

    public InfusionStandBlock(Properties propertiesIn) {
        super(propertiesIn);
        this.registerDefaultState(this.stateDefinition.any().setValue(BlockStateProperties.WATERLOGGED, false));
        
    }
    

	@Override
	public void onRemove(BlockState pState, Level pLevel, BlockPos pPos, BlockState pNewState, boolean pIsMoving) {
		 if (pState.hasBlockEntity() && pState.getBlock() != pNewState.getBlock()) {
	            // drops everything in the inventory
	            pLevel.getBlockEntity(pPos).getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY).ifPresent(h -> {
	                for (int i = 0; i < h.getSlots(); i++) {
	                	popResource(pLevel, pPos, h.getStackInSlot(i));
	                }
	            });
	            pLevel.removeBlockEntity(pPos);
	        }
	}

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state)
    {
        return new InfusionStandBlockEntity(pos, state);
    }

    
//    @Override
//    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext)
//    {
//        return SHAPE;
//    }
//    
//    @Override
//    public VoxelShape getCollisionShape(BlockState pState, BlockGetter pLevel, BlockPos pPos,
//    		CollisionContext pContext) {
//    	return SHAPE;
//    }
    
    public RenderShape getRenderShape(BlockState pState) {
        return RenderShape.MODEL;
     }
    
    @SuppressWarnings("deprecation")
    @Override
    public BlockState updateShape(BlockState pState, Direction pFacing, BlockState pFacingState, LevelAccessor pLevel, BlockPos pCurrentPos, BlockPos pFacingPos) {

           if (pState.getValue(WATERLOGGED)) {
              pLevel.getFluidTicks().hasScheduledTick(pCurrentPos, Fluids.WATER);
           }

           return super.updateShape(pState, pFacing, pFacingState, pLevel, pCurrentPos, pFacingPos);

     }
    
    @Override
    @SuppressWarnings("deprecation")
    public FluidState getFluidState(BlockState state) {
        
        return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
        
    }
    
    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(WATERLOGGED);
     }
    
    @Override
    public InteractionResult use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult trace) {
        if (!world.isClientSide) {
            BlockEntity tileEntity = world.getBlockEntity(pos);
            if (tileEntity instanceof InfusionStandBlockEntity) {
                MenuProvider containerProvider = new MenuProvider() {
                    
                    @Override
                    public AbstractContainerMenu createMenu(int p_createMenu_1_, Inventory p_createMenu_2_, Player p_createMenu_3_)
                    {
                        return new InfusionStandMenu(p_createMenu_1_, world, pos, p_createMenu_2_, p_createMenu_3_);
                    }

                    @Override
                    public Component getDisplayName()
                    {
                        return Component.translatable("screen." + GemMod.MODID + ".infusion_stand.text");
                    }
                };
                NetworkHooks.openGui((ServerPlayer) player, containerProvider, pos);
            } else {
                throw new IllegalStateException("Our named container provider is missing!");
            }
        }
        return InteractionResult.SUCCESS;
    }

}