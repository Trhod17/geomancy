package net.codersdownunder.gemmod.blocks.terra;

import net.codersdownunder.gemmod.Geomancy;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.network.NetworkHooks;


public class TerraFirmaBlock extends Block implements EntityBlock {

	
	//public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
//	private static final Map<Direction, VoxelShape> SHAPES = new EnumMap<>(Direction.class);
//	
//	private static final Optional<VoxelShape> SHAPE = Optional.of(Stream.of(
//			
//			).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get());
	
	public TerraFirmaBlock(Properties p_49795_) {
		super(p_49795_);
		//registerDefaultState(this.stateDefinition.any().setValue(BlockStateProperties.WATERLOGGED, false).setValue(FACING, Direction.NORTH));
		//runCalculation(SHAPE.orElse(Shapes.block()));
	}
	
	@Override
	public void onRemove(BlockState pState, Level pLevel, BlockPos pPos, BlockState pNewState, boolean pIsMoving) {
		 if (pState.hasBlockEntity() && pState.getBlock() != pNewState.getBlock()) {
	            // drops everything in the inventory
	            pLevel.getBlockEntity(pPos).getCapability(ForgeCapabilities.ITEM_HANDLER).ifPresent(h -> {
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
        return new TerraFirmaBlockEntity(pos, state);
    }

    
//    @Override
//    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext)
//    {
//        return SHAPES.get(pState.getValue(FACING));
//    }
//    
//    @Override
//    public VoxelShape getCollisionShape(BlockState pState, BlockGetter pLevel, BlockPos pPos,
//    		CollisionContext pContext) {
//    	return SHAPE.get();
//    }
//    
//    protected void runCalculation(VoxelShape shape) {
//		for (Direction direction : Direction.values())
//			SHAPES.put(direction, BlockUtils.calculateShapes(direction, shape));
//	}
    
    public RenderShape getRenderShape(BlockState pState) {
        return RenderShape.MODEL;
     }
    
//    @SuppressWarnings("deprecation")
//    @Override
//    public BlockState updateShape(BlockState pState, Direction pFacing, BlockState pFacingState, LevelAccessor pLevel, BlockPos pCurrentPos, BlockPos pFacingPos) {
//
//           if (pState.getValue(WATERLOGGED)) {
//              pLevel.getFluidTicks().hasScheduledTick(pCurrentPos, Fluids.WATER);
//           }
//
//           return super.updateShape(pState, pFacing, pFacingState, pLevel, pCurrentPos, pFacingPos);
//
//     }
//    
//    @Override
//    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
//    	//
//    	return defaultBlockState().setValue(FACING, pContext.getHorizontalDirection());
//    }
//    
//    @Override
//    @SuppressWarnings("deprecation")
//    public FluidState getFluidState(BlockState state) {
//        
//        return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
//        
//    }
//    
//    @Override
//    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
//        pBuilder.add(WATERLOGGED).add(FACING);
//     }
    
    @Override
    public InteractionResult use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult trace) {
        if (!world.isClientSide) {
            BlockEntity tileEntity = world.getBlockEntity(pos);
            if (tileEntity instanceof TerraFirmaBlockEntity) {
                MenuProvider containerProvider = new MenuProvider() {
                    
                    @Override
                    public AbstractContainerMenu createMenu(int p_createMenu_1_, Inventory p_createMenu_2_, Player p_createMenu_3_)
                    {
                        return new TerraFirmaMenu(p_createMenu_1_, world, pos, p_createMenu_2_, p_createMenu_3_);
                    }

                    @Override
                    public Component getDisplayName()
                    {
                        return Component.translatable("screen." + Geomancy.MODID + ".dreamcatcher.text");
                    }
                };
                NetworkHooks.openScreen((ServerPlayer) player, containerProvider, pos);
            } else {
                throw new IllegalStateException("Our named container provider is missing!");
            }
        }
        return InteractionResult.SUCCESS;
    }
	
}
