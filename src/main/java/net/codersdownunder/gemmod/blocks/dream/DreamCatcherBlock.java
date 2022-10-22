package net.codersdownunder.gemmod.blocks.dream;

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
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
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
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.network.NetworkHooks;

import java.util.Optional;
import java.util.stream.Stream;


public class DreamCatcherBlock extends Block implements SimpleWaterloggedBlock, EntityBlock {

	public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
	public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
	
	private static final Optional<VoxelShape> SHAPE = Optional.of(Stream.of(
			Block.box(12.26329, -8.75, 7.01329, 13.51329, -5.5, 8.01329),
			Block.box(7.51329, 13, 7.51329, 8.51329, 16, 8.51329),
			Block.box(12.51329, -4, 7.51329, 13.51329, 2, 8.51329),
			Block.box(2.51329, -3, 7.51329, 3.51329, 2, 8.51329),
			Block.box(7.51329, -4, 7.51329, 8.51329, 0, 8.51329),
			Block.box(7.51329, -16, 7.51329, 8.51329, -10, 8.51329),
			Block.box(10.01329, -15, 7.51329, 11.01329, -9, 8.51329),
			Block.box(5.01329, -14, 7.51329, 6.01329, -9, 8.51329),
			Block.box(13.01329, 4, 7.01329, 15.01329, 9, 9.01329),
			Block.box(1.01329, 4, 7.01329, 3.01329, 9, 9.01329),
			Block.box(4.01329, 11, 7.01329, 12.01329, 13, 9.01329),
			Block.box(2.01329, 9, 7.01329, 4.01329, 11, 9.01329),
			Block.box(12.01329, 9, 7.01329, 14.01329, 11, 9.01329),
			Block.box(2.01329, 2, 7.01329, 4.01329, 4, 9.01329),
			Block.box(12.01329, 2, 7.01329, 14.01329, 4, 9.01329),
			Block.box(4.01329, 0, 7.01329, 12.01329, 2, 9.01329),
			Block.box(6.01329, -10, 7.51329, 10.01329, -9, 8.51329),
			Block.box(10.01329, -9, 7.51329, 11.01329, -5, 8.51329),
			Block.box(5.01329, -9, 7.51329, 6.01329, -5, 8.51329),
			Block.box(6.01329, -5, 7.51329, 10.01329, -4, 8.51329),
			Block.box(6.39764, 0.78337, 7.76329, 7.39764, 11.78337, 7.76329),
			Block.box(8.62692, 0.7732, 8.01329, 9.62692, 11.7732, 8.01329),
			Block.box(3.62692, 5.7732, 8.26329, 14.62692, 6.7732, 8.26329),
			Block.box(1.39764, 5.78337, 8.51329, 12.39764, 6.78337, 8.51329),
			Block.box(12.6422, -4.2861, 8.01329, 18.6422, -3.2861, 8.01329),
			Block.box(14.8922, -7.0361, 8.26329, 15.8922, -1.0361, 8.26329),
			Block.box(12.26329, -1, 7.26329, 13.76329, 0.5, 8.76329),
			Block.box(12.26329, -2.75, 7.26329, 13.76329, -1.25, 8.76329),
			Block.box(2.26329, -0.5, 7.26329, 3.76329, 1, 8.76329),
			Block.box(7.01329, 5.5, 7.01329, 9.01329, 7.5, 9.01329),
			Block.box(7.26329, -7.75, 7.26329, 8.76329, -6.25, 8.76329),
			Block.box(12.26329, -5.5, 7.26329, 13.76329, -4, 8.76329),
			Block.box(2.26329, -4.5, 7.26329, 3.76329, -3, 8.76329),
			Block.box(4.89596, 5.61207, 7.51329, 6.39596, 7.11207, 9.01329),
			Block.box(6.2018, 8.62744, 7.01329, 7.7018, 10.12744, 8.51329),
			Block.box(8.42388, 2.45462, 7.26329, 9.92388, 3.95462, 8.76329),
			Block.box(4.76329, -13, 7.26329, 6.26329, -11.5, 8.76329),
			Block.box(7.26329, -12.5, 7.26329, 8.76329, -11, 8.76329),
			Block.box(9.76329, -13.5, 7.26329, 11.26329, -12, 8.76329),
			Block.box(2.01329, -7, 8.01329, 3.26329, -4.5, 9.01329),
			Block.box(2.76329, -7.75, 7.01329, 4.01329, -4.5, 8.01329),
			Block.box(12.51329, -8, 8.01329, 13.76329, -5.5, 9.01329)
			).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get());
	
	private static final Optional<VoxelShape> SHAPE_SOUTH = Optional.of(Stream.of(
			Block.box(2.4867100000000004, -8.75, 8.01329, 3.7367100000000004, -5.5, 9.01329),
			Block.box(7.48671, 13, 7.51329, 8.48671, 16, 8.51329),
			Block.box(2.4867100000000004, -4, 7.51329, 3.4867100000000004, 2, 8.51329),
			Block.box(12.48671, -3, 7.51329, 13.48671, 2, 8.51329),
			Block.box(7.48671, -4, 7.51329, 8.48671, 0, 8.51329),
			Block.box(7.48671, -16, 7.51329, 8.48671, -10, 8.51329),
			Block.box(4.98671, -15, 7.51329, 5.98671, -9, 8.51329),
			Block.box(9.98671, -14, 7.51329, 10.98671, -9, 8.51329),
			Block.box(0.9867100000000004, 4, 7.01329, 2.9867100000000004, 9, 9.01329),
			Block.box(12.98671, 4, 7.01329, 14.98671, 9, 9.01329),
			Block.box(3.9867100000000004, 11, 7.01329, 11.98671, 13, 9.01329),
			Block.box(11.98671, 9, 7.01329, 13.98671, 11, 9.01329),
			Block.box(1.9867100000000004, 9, 7.01329, 3.9867100000000004, 11, 9.01329),
			Block.box(11.98671, 2, 7.01329, 13.98671, 4, 9.01329),
			Block.box(1.9867100000000004, 2, 7.01329, 3.9867100000000004, 4, 9.01329),
			Block.box(3.9867100000000004, 0, 7.01329, 11.98671, 2, 9.01329),
			Block.box(5.98671, -10, 7.51329, 9.98671, -9, 8.51329),
			Block.box(4.98671, -9, 7.51329, 5.98671, -5, 8.51329),
			Block.box(9.98671, -9, 7.51329, 10.98671, -5, 8.51329),
			Block.box(5.98671, -5, 7.51329, 9.98671, -4, 8.51329),
			Block.box(8.602360000000001, 0.78337, 8.26329, 9.602360000000001, 11.78337, 8.26329),
			Block.box(6.37308, 0.7732, 8.01329, 7.37308, 11.7732, 8.01329),
			Block.box(1.3730799999999999, 5.7732, 7.76329, 12.37308, 6.7732, 7.76329),
			Block.box(3.602359999999999, 5.78337, 7.51329, 14.602360000000001, 6.78337, 7.51329),
			Block.box(-2.6422000000000008, -4.2861, 8.01329, 3.3577999999999992, -3.2861, 8.01329),
			Block.box(0.10779999999999923, -7.0361, 7.76329, 1.1077999999999992, -1.0361, 7.76329),
			Block.box(2.2367100000000004, -1, 7.26329, 3.7367100000000004, 0.5, 8.76329),
			Block.box(2.2367100000000004, -2.75, 7.26329, 3.7367100000000004, -1.25, 8.76329),
			Block.box(12.23671, -0.5, 7.26329, 13.73671, 1, 8.76329),
			Block.box(6.98671, 5.5, 7.01329, 8.98671, 7.5, 9.01329),
			Block.box(7.23671, -7.75, 7.26329, 8.73671, -6.25, 8.76329),
			Block.box(2.2367100000000004, -5.5, 7.26329, 3.7367100000000004, -4, 8.76329),
			Block.box(12.23671, -4.5, 7.26329, 13.73671, -3, 8.76329),
			Block.box(9.604040000000001, 5.61207, 7.01329, 11.104040000000001, 7.11207, 8.51329),
			Block.box(8.2982, 8.62744, 7.51329, 9.7982, 10.12744, 9.01329),
			Block.box(6.0761199999999995, 2.45462, 7.26329, 7.5761199999999995, 3.95462, 8.76329),
			Block.box(9.73671, -13, 7.26329, 11.23671, -11.5, 8.76329),
			Block.box(7.23671, -12.5, 7.26329, 8.73671, -11, 8.76329),
			Block.box(4.73671, -13.5, 7.26329, 6.23671, -12, 8.76329),
			Block.box(12.73671, -7, 7.01329, 13.98671, -4.5, 8.01329),
			Block.box(11.98671, -7.75, 8.01329, 13.23671, -4.5, 9.01329),
			Block.box(2.2367100000000004, -8, 7.01329, 3.4867100000000004, -5.5, 8.01329)
			).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get());
	
	private static final Optional<VoxelShape> SHAPE_WEST = Optional.of(Stream.of(
			Block.box(7, -8.75, 2.5, 8, -5.5, 3.75),
			Block.box(7.5, 13, 7.5, 8.5, 16, 8.5),
			Block.box(7.5, -4, 2.5, 8.5, 2, 3.5),
			Block.box(7.5, -3, 12.5, 8.5, 2, 13.5),
			Block.box(7.5, -4, 7.5, 8.5, 0, 8.5),
			Block.box(7.5, -16, 7.5, 8.5, -10, 8.5),
			Block.box(7.5, -15, 5, 8.5, -9, 6),
			Block.box(7.5, -14, 10, 8.5, -9, 11),
			Block.box(7, 4, 1, 9, 9, 3),
			Block.box(7, 4, 13, 9, 9, 15),
			Block.box(7, 11, 4, 9, 13, 12),
			Block.box(7, 9, 12, 9, 11, 14),
			Block.box(7, 9, 2, 9, 11, 4),
			Block.box(7, 2, 12, 9, 4, 14),
			Block.box(7, 2, 2, 9, 4, 4),
			Block.box(7, 0, 4, 9, 2, 12),
			Block.box(7.5, -10, 6, 8.5, -9, 10),
			Block.box(7.5, -9, 5, 8.5, -5, 6),
			Block.box(7.5, -9, 10, 8.5, -5, 11),
			Block.box(7.5, -5, 6, 8.5, -4, 10),
			Block.box(7.75, 0.78337, 8.61565, 7.75, 11.78337, 9.61565),
			Block.box(8, 0.7732, 6.386369999999999, 8, 11.7732, 7.386369999999999),
			Block.box(8.25, 5.7732, 1.3863699999999994, 8.25, 6.7732, 12.38637),
			Block.box(8.5, 5.78337, 3.6156499999999987, 8.5, 6.78337, 14.61565),
			Block.box(8, -4.2861, -2.628910000000001, 8, -3.2861, 3.371089999999999),
			Block.box(8.25, -7.0361, 0.12108999999999881, 8.25, -1.0361, 1.1210899999999988),
			Block.box(7.25, -1, 2.25, 8.75, 0.5, 3.75),
			Block.box(7.25, -2.75, 2.25, 8.75, -1.25, 3.75),
			Block.box(7.25, -0.5, 12.25, 8.75, 1, 13.75),
			Block.box(7, 5.5, 7, 9, 7.5, 9),
			Block.box(7.25, -7.75, 7.25, 8.75, -6.25, 8.75),
			Block.box(7.25, -5.5, 2.25, 8.75, -4, 3.75),
			Block.box(7.25, -4.5, 12.25, 8.75, -3, 13.75),
			Block.box(7.5, 5.61207, 9.61733, 9, 7.11207, 11.11733),
			Block.box(7, 8.62744, 8.31149, 8.5, 10.12744, 9.81149),
			Block.box(7.25, 2.45462, 6.089409999999999, 8.75, 3.95462, 7.589409999999999),
			Block.box(7.25, -13, 9.75, 8.75, -11.5, 11.25),
			Block.box(7.25, -12.5, 7.25, 8.75, -11, 8.75),
			Block.box(7.25, -13.5, 4.75, 8.75, -12, 6.25),
			Block.box(8, -7, 12.75, 9, -4.5, 14),
			Block.box(7, -7.75, 12, 8, -4.5, 13.25),
			Block.box(8, -8, 2.25, 9, -5.5, 3.5)
			).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get());
		
	private static final Optional<VoxelShape> SHAPE_EAST = Optional.of(Stream.of(
			Block.box(8, -8.75, 12.27658, 9, -5.5, 13.52658),
			Block.box(7.5, 13, 7.526579999999999, 8.5, 16, 8.52658),
			Block.box(7.5, -4, 12.52658, 8.5, 2, 13.52658),
			Block.box(7.5, -3, 2.526579999999999, 8.5, 2, 3.526579999999999),
			Block.box(7.5, -4, 7.526579999999999, 8.5, 0, 8.52658),
			Block.box(7.5, -16, 7.526579999999999, 8.5, -10, 8.52658),
			Block.box(7.5, -15, 10.02658, 8.5, -9, 11.02658),
			Block.box(7.5, -14, 5.026579999999999, 8.5, -9, 6.026579999999999),
			Block.box(7, 4, 13.02658, 9, 9, 15.02658),
			Block.box(7, 4, 1.0265799999999992, 9, 9, 3.026579999999999),
			Block.box(7, 11, 4.026579999999999, 9, 13, 12.02658),
			Block.box(7, 9, 2.026579999999999, 9, 11, 4.026579999999999),
			Block.box(7, 9, 12.02658, 9, 11, 14.02658),
			Block.box(7, 2, 2.026579999999999, 9, 4, 4.026579999999999),
			Block.box(7, 2, 12.02658, 9, 4, 14.02658),
			Block.box(7, 0, 4.026579999999999, 9, 2, 12.02658),
			Block.box(7.5, -10, 6.026579999999999, 8.5, -9, 10.02658),
			Block.box(7.5, -9, 10.02658, 8.5, -5, 11.02658),
			Block.box(7.5, -9, 5.026579999999999, 8.5, -5, 6.026579999999999),
			Block.box(7.5, -5, 6.026579999999999, 8.5, -4, 10.02658),
			Block.box(8.25, 0.78337, 6.41093, 8.25, 11.78337, 7.41093),
			Block.box(8, 0.7732, 8.64021, 8, 11.7732, 9.64021),
			Block.box(7.75, 5.7732, 3.6402099999999997, 7.75, 6.7732, 14.64021),
			Block.box(7.5, 5.78337, 1.4109299999999996, 7.5, 6.78337, 12.41093),
			Block.box(8, -4.2861, 12.65549, 8, -3.2861, 18.65549),
			Block.box(7.75, -7.0361, 14.90549, 7.75, -1.0361, 15.90549),
			Block.box(7.25, -1, 12.27658, 8.75, 0.5, 13.77658),
			Block.box(7.25, -2.75, 12.27658, 8.75, -1.25, 13.77658),
			Block.box(7.25, -0.5, 2.276579999999999, 8.75, 1, 3.776579999999999),
			Block.box(7, 5.5, 7.026579999999999, 9, 7.5, 9.02658),
			Block.box(7.25, -7.75, 7.276579999999999, 8.75, -6.25, 8.77658),
			Block.box(7.25, -5.5, 12.27658, 8.75, -4, 13.77658),
			Block.box(7.25, -4.5, 2.276579999999999, 8.75, -3, 3.776579999999999),
			Block.box(7, 5.61207, 4.909249999999999, 8.5, 7.11207, 6.409249999999999),
			Block.box(7.5, 8.62744, 6.21509, 9, 10.12744, 7.71509),
			Block.box(7.25, 2.45462, 8.43717, 8.75, 3.95462, 9.93717),
			Block.box(7.25, -13, 4.776579999999999, 8.75, -11.5, 6.276579999999999),
			Block.box(7.25, -12.5, 7.276579999999999, 8.75, -11, 8.77658),
			Block.box(7.25, -13.5, 9.77658, 8.75, -12, 11.27658),
			Block.box(7, -7, 2.026579999999999, 8, -4.5, 3.276579999999999),
			Block.box(8, -7.75, 2.776579999999999, 9, -4.5, 4.026579999999999),
			Block.box(7, -8, 12.52658, 8, -5.5, 13.77658)
			).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get());
	
	public DreamCatcherBlock(Properties p_49795_) {
		super(p_49795_);
		registerDefaultState(this.stateDefinition.any().setValue(BlockStateProperties.WATERLOGGED, false).setValue(FACING, Direction.NORTH));
	
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
        return new DreamCatcherBlockEntity(pos, state);
    }

    
    @Override
	public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
		switch(pState.getValue(FACING)) {
		case EAST:
			return SHAPE_EAST.get();
		case WEST:
			return SHAPE_WEST.get();
		case SOUTH:
			return SHAPE_SOUTH.get();
		default:
			return SHAPE.get();
		}
	}

	@Override
	public VoxelShape getCollisionShape(BlockState pState, BlockGetter pLevel, BlockPos pPos,
			CollisionContext pContext) {
		switch(pState.getValue(FACING)) {
		case EAST:
			return SHAPE_EAST.get();
		case WEST:
			return SHAPE_WEST.get();
		case SOUTH:
			return SHAPE_SOUTH.get();
		default:
			return SHAPE.get();
		}
	}

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
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
    	return defaultBlockState().setValue(FACING, pContext.getHorizontalDirection());
    }
    
    @Override
    @SuppressWarnings("deprecation")
    public FluidState getFluidState(BlockState state) {
        
        return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
        
    }
    
    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(WATERLOGGED).add(FACING);
     }
    
    @Override
    public InteractionResult use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult trace) {
        if (!world.isClientSide) {
            BlockEntity tileEntity = world.getBlockEntity(pos);
            if (tileEntity instanceof DreamCatcherBlockEntity) {
                MenuProvider containerProvider = new MenuProvider() {
                    
                    @Override
                    public AbstractContainerMenu createMenu(int p_createMenu_1_, Inventory p_createMenu_2_, Player p_createMenu_3_)
                    {
                        return new DreamCatcherMenu(p_createMenu_1_, world, pos, p_createMenu_2_, p_createMenu_3_);
                    }

                    @Override
                    public Component getDisplayName()
                    {
                        return Component.translatable("screen." + GemMod.MODID + ".dreamcatcher.text");
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
