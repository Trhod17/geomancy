package net.codersdownunder.gemmod.blocks.trellis;

import java.util.Optional;
import java.util.Random;
import java.util.stream.Stream;

import javax.annotation.Nullable;

import net.codersdownunder.gemmod.GemMod;
import net.codersdownunder.gemmod.init.BlockInit;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class TrellisBlock extends Block implements SimpleWaterloggedBlock {

	public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
	public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
	
	private static final Optional<VoxelShape> SHAPE = Optional.of(Stream
			.of(Block.box(1.5, 0, 14, 3.5, 16, 16), Block.box(7, 0, 14, 9, 16, 16),
					Block.box(0, 12.5, 14.5, 16, 14.5, 15.5), Block.box(0, 7, 14.5, 16, 9, 15.5),
					Block.box(0, 1.5, 14.5, 16, 3.5, 15.5), Block.box(12.5, 0, 14, 14.5, 16, 16))
			.reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get());
	
	private static final Optional<VoxelShape> SHAPE_WEST = Optional.of(Stream
			.of(Block.box(14, 0, 12.5, 16, 16, 14.5),
					Block.box(14, 0, 7, 16, 16, 9),
					Block.box(14.5, 12.5, 0, 15.5, 14.5, 16),
					Block.box(14.5, 7, 0, 15.5, 9, 16),
					Block.box(14.5, 1.5, 0, 15.5, 3.5, 16),
					Block.box(14, 0, 1.5, 16, 16, 3.5))
			.reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get());
	
	private static final Optional<VoxelShape> SHAPE_EAST = Optional.of(Stream
			.of(Block.box(0, 0, 12.5, 2, 16, 14.5),
					Block.box(0, 0, 7, 2, 16, 9),
					Block.box(0.5, 12.5, 0, 1.5, 14.5, 16),
					Block.box(0.5, 7, 0, 1.5, 9, 16),
					Block.box(0.5, 1.5, 0, 1.5, 3.5, 16),
					Block.box(0, 0, 1.5, 2, 16, 3.5))
			.reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get());
	
	private static final Optional<VoxelShape> SHAPE_SOUTH = Optional.of(Stream
			.of(Block.box(1.5, 0, 0, 3.5, 16, 2),
					Block.box(7, 0, 0, 9, 16, 2),
					Block.box(0, 12.5, 0.5, 16, 14.5, 1.5),
					Block.box(0, 7, 0.5, 16, 9, 1.5),
					Block.box(0, 1.5, 0.5, 16, 3.5, 1.5),
					Block.box(12.5, 0, 0, 14.5, 16, 2))
			.reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get());

	public TrellisBlock(Properties p_49795_) {
		super(p_49795_);
		registerDefaultState(this.stateDefinition.any().setValue(BlockStateProperties.WATERLOGGED, false)
				.setValue(FACING, Direction.NORTH));
	}

	@Override
	public ItemStack getCloneItemStack(BlockState state, HitResult target, BlockGetter world, BlockPos pos,
			Player player) {

		return new ItemStack(BlockInit.TRELLIS.get());
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
	public BlockState updateShape(BlockState pState, Direction pFacing, BlockState pFacingState, LevelAccessor pLevel,
			BlockPos pCurrentPos, BlockPos pFacingPos) {

		if (pState.getValue(WATERLOGGED)) {
			pLevel.getFluidTicks().hasScheduledTick(pCurrentPos, Fluids.WATER);
		}

		return super.updateShape(pState, pFacing, pFacingState, pLevel, pCurrentPos, pFacingPos);

	}

	@Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
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
	
	static Random rand = new Random();
	
	@Override
	public void randomTick(BlockState pState, ServerLevel pLevel, BlockPos pPos, Random pRandom) {
		
		Block trellis = BlockInit.TRELLIS.get();
		Block current = this.defaultBlockState().getBlock();

		
		switch (pickDirection()) {
		case 0: {
			break;
		}
		case 1: {
			if (pLevel.getBlockState(pPos.above()).getBlock() == trellis) {
				if (spreadChance() <= 70) {
					pLevel.setBlockAndUpdate(pPos.above(), current.defaultBlockState()
							.setValue(FACING, pState.getValue(FACING)).setValue(WATERLOGGED, pState.getValue(WATERLOGGED)));
				}
			}
			break;
		}
		case 2: {
			break;
		}
		case 3: {
			
		}
		case 4: {
			if (pLevel.getBlockState(pPos.below()).getBlock() == trellis) {
				if (spreadChance() <= 70) {
					pLevel.setBlockAndUpdate(pPos.below(), current.defaultBlockState()
							.setValue(FACING, pState.getValue(FACING)).setValue(WATERLOGGED, pState.getValue(WATERLOGGED)));
				}
			}
			break;
		}
		case 5: {
			break;
		}
		case 6: {
			
		}
		case 7: {
			if (pLevel.getBlockState(pPos.east()).getBlock() == trellis) {
				if (spreadChance() <= 70) {
					pLevel.setBlockAndUpdate(pPos.east(), current.defaultBlockState()
							.setValue(FACING, pState.getValue(FACING)).setValue(WATERLOGGED, pState.getValue(WATERLOGGED)));
				}
			}
			break;
		}
		case 8: {
			break;
		}
		case 9: {
			
		}
		case 10: {
			if (pLevel.getBlockState(pPos.west()).getBlock() == trellis) {
				if (spreadChance() <= 70) {
					pLevel.setBlockAndUpdate(pPos.west(), current.defaultBlockState()
							.setValue(FACING, pState.getValue(FACING)).setValue(WATERLOGGED, pState.getValue(WATERLOGGED)));
				}
			}
			break;
		}
		case 11: {
			break;
		}
		case 12: {
			break;
		}
		default:
			GemMod.LOGGER.debug("Number outside direction range");
		}
	}
	
	private int spreadChance() {
		int spread = rand.nextInt(100);
		
		return spread;
	}
	
	private int pickDirection() {
		
		int number = rand.nextInt(12);
		
		return number;
		
	}

	@Override
	public InteractionResult use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand,
			BlockHitResult trace) {
		if (!world.isClientSide) {

			// Item item;

			if (player.getItemInHand(hand).getItem() == Items.VINE) {
				world.setBlockAndUpdate(pos, BlockInit.TRELLIS_VINE.get().defaultBlockState()
						.setValue(FACING, state.getValue(FACING)).setValue(WATERLOGGED, state.getValue(WATERLOGGED)));
			}
			
			if (player.getItemInHand(hand).getItem() == Items.MOSS_BLOCK || player.getItemInHand(hand).getItem() == Items.MOSS_CARPET) {
				world.setBlockAndUpdate(pos, BlockInit.TRELLIS_MOSS.get().defaultBlockState()
						.setValue(FACING, state.getValue(FACING)).setValue(WATERLOGGED, state.getValue(WATERLOGGED)));
			}
			
			if (player.getItemInHand(hand).getItem() == Items.WEEPING_VINES) {
				world.setBlockAndUpdate(pos, BlockInit.TRELLIS_CRIMSON.get().defaultBlockState()
						.setValue(FACING, state.getValue(FACING)).setValue(WATERLOGGED, state.getValue(WATERLOGGED)));
			}
			
			if (player.getItemInHand(hand).getItem() == Items.TWISTING_VINES) {
				world.setBlockAndUpdate(pos, BlockInit.TRELLIS_WARP.get().defaultBlockState()
						.setValue(FACING, state.getValue(FACING)).setValue(WATERLOGGED, state.getValue(WATERLOGGED)));
			}
			
			if (player.getItemInHand(hand).getItem() == Items.GLOW_BERRIES) {
				world.setBlockAndUpdate(pos, BlockInit.TRELLIS_CAVE_VINES.get().defaultBlockState()
						.setValue(FACING, state.getValue(FACING)).setValue(WATERLOGGED, state.getValue(WATERLOGGED)));
			}
			
			if (player.getItemInHand(hand).getItem() == Items.CHORUS_FRUIT) {
				world.setBlockAndUpdate(pos, BlockInit.TRELLIS_CHORUS.get().defaultBlockState()
						.setValue(FACING, state.getValue(FACING)).setValue(WATERLOGGED, state.getValue(WATERLOGGED)));
			}
			
			if (player.getItemInHand(hand).getItem() == Items.GLOW_LICHEN) {
				world.setBlockAndUpdate(pos, BlockInit.TRELLIS_LICHEN.get().defaultBlockState()
						.setValue(FACING, state.getValue(FACING)).setValue(WATERLOGGED, state.getValue(WATERLOGGED)));
			}

		}
		return InteractionResult.SUCCESS;
	}

}
