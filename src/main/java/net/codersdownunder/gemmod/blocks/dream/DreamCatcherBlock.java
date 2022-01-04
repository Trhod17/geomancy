package net.codersdownunder.gemmod.blocks.dream;

import java.util.EnumMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

import net.codersdownunder.gemmod.GemMod;
import net.codersdownunder.gemmod.utils.BlockUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
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
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
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
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.network.NetworkHooks;

public class DreamCatcherBlock extends HorizontalDirectionalBlock implements SimpleWaterloggedBlock, EntityBlock {

	
	public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
	private static final Map<Direction, VoxelShape> SHAPES = new EnumMap<>(Direction.class);
	
	private static final Optional<VoxelShape> SHAPE = Optional.of(Stream.of(
			Block.box(12.26329, -8.75, 7.01329, 13.51329, -5.5, 8.01329),
			Block.box(7.51329, 13, 7.51329, 8.51329, 16, 8.51329),
			Block.box(12.51329, -4, 7.51329, 13.51329, 2, 8.51329),
			Block.box(2.5132899999999996, -3, 7.51329, 3.5132899999999996, 2, 8.51329),
			Block.box(7.51329, -4, 7.51329, 8.51329, 0, 8.51329),
			Block.box(7.51329, -16, 7.51329, 8.51329, -10, 8.51329),
			Block.box(10.01329, -15, 7.51329, 11.01329, -9, 8.51329),
			Block.box(5.01329, -14, 7.51329, 6.01329, -9, 8.51329),
			Block.box(13.01329, 4, 7.01329, 15.01329, 9, 9.01329),
			Block.box(1.0132899999999996, 4, 7.01329, 3.0132899999999996, 9, 9.01329),
			Block.box(4.01329, 11, 7.01329, 12.01329, 13, 9.01329),
			Block.box(2.0132899999999996, 9, 7.01329, 4.01329, 11, 9.01329),
			Block.box(12.01329, 9, 7.01329, 14.01329, 11, 9.01329),
			Block.box(2.0132899999999996, 2, 7.01329, 4.01329, 4, 9.01329),
			Block.box(12.01329, 2, 7.01329, 14.01329, 4, 9.01329),
			Block.box(4.01329, 0, 7.01329, 12.01329, 2, 9.01329),
			Block.box(6.01329, -10, 7.51329, 10.01329, -9, 8.51329),
			Block.box(10.01329, -9, 7.51329, 11.01329, -5, 8.51329),
			Block.box(5.01329, -9, 7.51329, 6.01329, -5, 8.51329),
			Block.box(6.01329, -5, 7.51329, 10.01329, -4, 8.51329),
			Block.box(6.3976363255372775, 0.7833697771617576, 7.76329, 7.3976363255372775, 11.783369777161758, 7.76329),
			Block.box(8.626920392436872, 0.7731980515294925, 8.01329, 9.626920392436872, 11.773198051529493, 8.01329),
			Block.box(3.6269203924368707, 5.773198051529493, 8.26329, 14.62692039243687, 6.773198051529493, 8.26329),
			Block.box(1.3976363255372775, 5.783369777161757, 8.51329, 12.397636325537277, 6.783369777161757, 8.51329),
			Block.box(12.64219568298503, -4.286100784741091, 8.01329, 18.64219568298503, -3.286100784741091, 8.01329),
			Block.box(14.89219568298503, -7.036100784741091, 8.26329, 15.89219568298503, -1.036100784741091, 8.26329),
			Block.box(12.26329, -1, 7.26329, 13.76329, 0.5, 8.76329),
			Block.box(12.26329, -2.75, 7.26329, 13.76329, -1.25, 8.76329),
			Block.box(2.2632899999999996, -0.5, 7.26329, 3.7632899999999996, 1, 8.76329),
			Block.box(7.01329, 5.5, 7.01329, 9.01329, 7.5, 9.01329),
			Block.box(7.26329, -7.75, 7.26329, 8.76329, -6.25, 8.76329),
			Block.box(12.26329, -5.5, 7.26329, 13.76329, -4, 8.76329),
			Block.box(2.2632899999999996, -4.5, 7.26329, 3.7632899999999996, -3, 8.76329),
			Block.box(4.8959576213188285, 5.612069791076927, 7.51329, 6.3959576213188285, 7.112069791076927, 9.01329),
			Block.box(6.201804086868384, 8.627441328665881, 7.01329, 7.701804086868384, 10.127441328665881, 8.51329),
			Block.box(8.423879532511286, 2.4546165676349103, 7.26329, 9.923879532511286, 3.9546165676349103, 8.76329),
			Block.box(4.76329, -13, 7.26329, 6.26329, -11.5, 8.76329),
			Block.box(7.26329, -12.5, 7.26329, 8.76329, -11, 8.76329),
			Block.box(9.76329, -13.5, 7.26329, 11.26329, -12, 8.76329),
			Block.box(2.0132899999999996, -7, 8.01329, 3.2632899999999996, -4.5, 9.01329),
			Block.box(2.7632899999999996, -7.75, 7.01329, 4.01329, -4.5, 8.01329),
			Block.box(12.51329, -8, 8.01329, 13.76329, -5.5, 9.01329)
			).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get());
	
	public DreamCatcherBlock(Properties p_49795_) {
		super(p_49795_);
		registerDefaultState(this.stateDefinition.any().setValue(BlockStateProperties.WATERLOGGED, false).setValue(FACING, Direction.NORTH));
		runCalculation(SHAPE.orElse(Shapes.block()));
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
        return new DreamCatcherBlockEntity(pos, state);
    }

    
    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext)
    {
        return SHAPES.get(pState.getValue(FACING));
    }
    
    @Override
    public VoxelShape getCollisionShape(BlockState pState, BlockGetter pLevel, BlockPos pPos,
    		CollisionContext pContext) {
    	return SHAPE.get();
    }
    
    protected void runCalculation(VoxelShape shape) {
		for (Direction direction : Direction.values())
			SHAPES.put(direction, BlockUtils.calculateShapes(direction, shape));
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
    	// TODO Auto-generated method stub
    	return defaultBlockState().setValue(FACING, pContext.getHorizontalDirection().getOpposite());
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
                        return new TranslatableComponent("screen." + GemMod.MODID + ".dreamcatcher.text");
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
