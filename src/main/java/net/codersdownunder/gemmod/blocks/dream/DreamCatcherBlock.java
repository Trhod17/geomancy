package net.codersdownunder.gemmod.blocks.dream;

import net.codersdownunder.gemmod.GemMod;
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
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.BaseEntityBlock;
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

public class DreamCatcherBlock extends BaseEntityBlock implements SimpleWaterloggedBlock, EntityBlock {

	
	public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
	
	public DreamCatcherBlock(Properties p_49795_) {
		super(p_49795_);
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
        return new DreamCatcherBlockEntity(pos, state);
    }

    
//    @Override
//    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext)
//    {
//        return V;
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
