package net.codersdownunder.gemmod.blocks.songforge;

import net.codersdownunder.gemmod.GemMod;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.network.NetworkHooks;

import javax.annotation.Nullable;
import java.util.Random;


public class SongForgeBlock extends BaseEntityBlock implements EntityBlock {

	public static final BooleanProperty FORGE = BooleanProperty.create("forgefront");
	public static final BooleanProperty LIT = BooleanProperty.create("lit");
	public static final DirectionProperty FACING = BlockStateProperties.FACING;

	public SongForgeBlock(Properties p_49795_) {
		super(p_49795_);
		registerDefaultState(this.stateDefinition.any().setValue(LIT, false).setValue(FACING, Direction.NORTH));
		// .setValue(FORGE, false)
	}
	
	 public void animateTick(BlockState pState, Level pLevel, BlockPos pPos, Random pRand) {
	      if (pState.getValue(LIT)) {
	         double d0 = (double)pPos.getX() + 0.5D;
	         double d1 = (double)pPos.getY();
	         double d2 = (double)pPos.getZ() + 0.5D;
	         if (pRand.nextDouble() < 0.1D) {
	            pLevel.playLocalSound(d0, d1, d2, SoundEvents.FURNACE_FIRE_CRACKLE, SoundSource.BLOCKS, 1.0F, 1.0F, false);
	         }

	         Direction direction = pState.getValue(FACING);
	         Direction.Axis direction$axis = direction.getAxis();
	         double d4 = pRand.nextDouble() * 0.6D - 0.3D;
	         double d5 = direction$axis == Direction.Axis.X ? (double)direction.getStepX() * 0.52D : d4;
	         double d6 = pRand.nextDouble() * 6.0D / 16.0D;
	         double d7 = direction$axis == Direction.Axis.Z ? (double)direction.getStepZ() * 0.52D : d4;
	         pLevel.addParticle(ParticleTypes.SMOKE, d0 + d5, d1 + d6, d2 + d7, 0.0D, 0.0D, 0.0D);
	         pLevel.addParticle(ParticleTypes.FLAME, d0 + d5, d1 + d6, d2 + d7, 0.0D, 0.0D, 0.0D);
	      }
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
	
	@Nullable
	@Override
	public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level pLevel, BlockState pState,
			BlockEntityType<T> pBlockEntityType) {
		if (pLevel.isClientSide()) {
			return null;
		}
		return (lvl, pos, blockState, t) -> {
			if (t instanceof SongForgeBlockEntity tile) {
				tile.tickServer();
			}
		};
	}

	@Override
	public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
		return new SongForgeBlockEntity(pos, state);
	}


	@SuppressWarnings("deprecation")
	@Override
	public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
		return super.getShape(pState, pLevel, pPos, pContext);
	}

	@SuppressWarnings("deprecation")
	@Override
	public VoxelShape getCollisionShape(BlockState pState, BlockGetter pLevel, BlockPos pPos,
			CollisionContext pContext) {
		return super.getCollisionShape(pState, pLevel, pPos, pContext);
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

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
    	return defaultBlockState().setValue(FACING, pContext.getHorizontalDirection().getOpposite());
    }

//    @Override
//    @SuppressWarnings("deprecation")
//    public FluidState getFluidState(BlockState state) {
//        
//        return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
//        
//    }
//    
    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(LIT).add(FACING);//.add(FORGE);
     }

	@Override
	public InteractionResult use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand,
			BlockHitResult trace) {
		if (!world.isClientSide) {
			BlockEntity tileEntity = world.getBlockEntity(pos);
			if (tileEntity instanceof SongForgeBlockEntity) {
				MenuProvider containerProvider = new MenuProvider() {

					@Override
					public AbstractContainerMenu createMenu(int p_createMenu_1_, Inventory p_createMenu_2_,
							Player p_createMenu_3_) {
						return new SongForgeMenu(p_createMenu_1_, world, pos, p_createMenu_2_, p_createMenu_3_);
					}

					@Override
					public Component getDisplayName() {
						return Component.translatable("screen." + GemMod.MODID + ".song_forge.text");
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
