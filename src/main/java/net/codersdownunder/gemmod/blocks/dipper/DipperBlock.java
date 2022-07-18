package net.codersdownunder.gemmod.blocks.dipper;

import net.codersdownunder.gemmod.GemMod;
import net.codersdownunder.gemmod.utils.GeomancyTags;
import net.codersdownunder.gemmod.utils.TextUtils;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
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
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.fluids.FluidUtil;
import net.minecraftforge.fluids.capability.CapabilityFluidHandler;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.network.NetworkHooks;

import javax.annotation.Nullable;
import java.util.List;
import java.util.stream.Stream;

public class DipperBlock extends BaseEntityBlock implements EntityBlock {

	private static final VoxelShape SHAPE = Stream.of(Block.box(2, 2, 15, 14, 14, 15.25), Block.box(1, 3, 1, 3, 14, 3),
			Block.box(13, 3, 1, 15, 14, 3), Block.box(1, 2, 1, 15, 3, 15), Block.box(0.75, 14, 3, 3, 15, 13),
			Block.box(13, 14, 3, 15.25, 15, 13), Block.box(0.75, 14, 13, 15.25, 15, 15.25),
			Block.box(0.75, 14, 0.75, 15.25, 15, 3), Block.box(0, 2, 14, 2, 15, 16), Block.box(0, 15, 14, 16, 16, 16),
			Block.box(0, 15, 2, 2, 16, 14), Block.box(0, 15, 0, 16, 16, 2), Block.box(0, 2, 0, 2, 15, 2),
			Block.box(0, 0, 0, 16, 2, 16), Block.box(14, 2, 0, 16, 15, 2), Block.box(14, 15, 2, 16, 16, 14),
			Block.box(14, 2, 14, 16, 15, 16), Block.box(15, 2, 2, 15.25, 14, 14), Block.box(2, 2, 0.75, 14, 14, 1),
			Block.box(0.75, 2, 2, 1, 14, 14), Block.box(2, 15, 7.5, 14, 16, 8.5),
			Block.box(7.75, 6, 7.75, 8.25, 15, 8.25), Block.box(1, 3, 13, 3, 14, 15), Block.box(13, 3, 13, 15, 14, 15))
			.reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

	public DipperBlock(Properties p_49795_) {
		super(p_49795_);
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
	public void appendHoverText(ItemStack pStack, BlockGetter pLevel, List<Component> pTooltip, TooltipFlag pFlag) {
		if (Screen.hasControlDown()) {
			pTooltip.add(TextUtils.FormattedTooltip(GemMod.MODID + ".dipper.tooltip.add_fluid", ChatFormatting.GREEN));
		} else {
			pTooltip.add(TextUtils.FormattedTooltip(GemMod.MODID + ".dipper.tooltip.add_fluid_unpressed", ChatFormatting.GREEN));
		}
		
		if (Screen.hasShiftDown()) {
			pTooltip.add(TextUtils.FormattedTooltip(GemMod.MODID + ".dipper.tooltip.use_case", ChatFormatting.GREEN));
		} else {
			pTooltip.add(TextUtils.FormattedTooltip(GemMod.MODID + ".dipper.tooltip.use_case_unpressed", ChatFormatting.GREEN));
		}
		
	}
	
	@Override
	public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
		return new DipperBlockEntity(pPos, pState);
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

	@Nullable
	@Override
	public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level pLevel, BlockState pState,
			BlockEntityType<T> pBlockEntityType) {
		if (pLevel.isClientSide()) {
			return null;
		}
		return (lvl, pos, blockState, t) -> {
			if (t instanceof DipperBlockEntity tile) {
				tile.tickServer();
			}
		};
	}
//
//    private void setRetainedFluidInTank(Level world, BlockPos pos, BlockState state, ItemStack stack) {
//        if (stack.hasTag()) {
//            final DipperBlockEntity tank = (DipperBlockEntity) world.getBlockEntity(pos);
//            if (tank != null) {
//                if (stack.getTag() != null) {
//                    CompoundTag tag = stack.getTag().getCompound("TileData");
//                    tag.putInt("x", pos.getX());
//                    tag.putInt("y", pos.getY());
//                    tag.putInt("z", pos.getZ());
//                    tank.load(tag);
//                }
//            }
//        }
//    }

	public DipperBlockEntity getTank(BlockGetter world, BlockPos pos) {
        return (DipperBlockEntity) world.getBlockEntity(pos);
    }
	
	  @Override
	    public InteractionResult use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
	        ItemStack held = player.getItemInHand(hand);

	        
	        if (FluidUtil.interactWithFluidHandler(player, hand, world, pos, hit.getDirection()) ||
	                held.getCapability(CapabilityFluidHandler.FLUID_HANDLER_ITEM_CAPABILITY).isPresent() && 
	                held.is(GeomancyTags.Items.DIPPING_FLUIDS)) {
	            return InteractionResult.SUCCESS;
	        } else {
				openGUI(state, world, pos, player, hand, hit);
				return InteractionResult.SUCCESS;
			}

	        //return InteractionResult.FAIL;
	    }

	public InteractionResult openGUI(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand,
			BlockHitResult pHit) {

		if (!pLevel.isClientSide) {
			BlockEntity blockEntity = pLevel.getBlockEntity(pPos);
			if (blockEntity instanceof DipperBlockEntity) {
				MenuProvider containerProvider = new MenuProvider() {

					@Override
					public AbstractContainerMenu createMenu(int pContainerId, Inventory pInventory,
							Player pPlayer) {
						return new DipperMenu(pContainerId, pLevel, pPos, pInventory, pPlayer, null);
					}

					@Override
					public Component getDisplayName() {
						return Component.translatable("screen.geomancy.dipper.text");
					}
				};
				NetworkHooks.openScreen((ServerPlayer) pPlayer, containerProvider, blockEntity.getBlockPos());
			} else {
				throw new IllegalStateException("Our named container provider is missing!");
			}
		}
		
		return InteractionResult.SUCCESS;
	}
//	
//	public InteractionResult empty(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand,
//			BlockHitResult pHit) {
//		
//		ItemStack stack = pPlayer.getItemInHand(pHand).copy();
//        ItemStack fillStack = stack.copy();
//        fillStack.setCount(1);
//        LazyOptional<IFluidHandlerItem> fluidHandlerOptional = fillStack.getCapability(CapabilityFluidHandler.FLUID_HANDLER_ITEM_CAPABILITY);
//        if(fluidHandlerOptional.isPresent()){
//            BlockEntity tileEntity = pLevel.getBlockEntity(pPos);
//            if(tileEntity instanceof DipperBlockEntity){
//                IFluidHandlerItem fluidHandler = fluidHandlerOptional.resolve().get();
//                if(((DipperBlockEntity)tileEntity).interactWithItemFluidHandler(fluidHandler)){
//                    stack.shrink(1);
//                    if(stack.isEmpty()) {
//                        pPlayer.setItemInHand(pHand, fluidHandler.getContainer());
//                    	//setRetainedFluidInTank(pLevel, pPos, pState, fillStack);
//                	} else {
//                        //pPlayer.setItemInHand(pHand, stack);
//                        if(!pPlayer.getInventory().add(fluidHandler.getContainer())) {
//                            //pPlayer.drop(fluidHandler.getContainer(), false);
//                        }
//                        
//                        setRetainedFluidInTank(pLevel, pPos, pState, fillStack);
//                    }
//                    return InteractionResult.sidedSuccess(pLevel.isClientSide);
//                }
//            }
//            return InteractionResult.CONSUME;
//        }
//        return InteractionResult.CONSUME;
//	}
//	
//	public InteractionResult fill(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand,
//			BlockHitResult pHit) {
//		 	ItemStack stack = pPlayer.getItemInHand(pHand).copy();
//	        ItemStack fillStack = stack.copy();
//	        fillStack.setCount(1);
//	        LazyOptional<IFluidHandlerItem> fluidHandlerOptional = fillStack.getCapability(CapabilityFluidHandler.FLUID_HANDLER_ITEM_CAPABILITY);
//	        if(fluidHandlerOptional.isPresent()){
//	            BlockEntity tileEntity = pLevel.getBlockEntity(pPos);
//	            if(tileEntity instanceof DipperBlockEntity){
//	                IFluidHandlerItem fluidHandler = fluidHandlerOptional.resolve().get();
//	                if(((DipperBlockEntity)tileEntity).interactWithItemFluidHandler(fluidHandler)){
//	                    stack.shrink(1);
//	                    if(stack.isEmpty())
//	                        pPlayer.setItemInHand(pHand, fluidHandler.getContainer());
//	                    	setRetainedFluidInTank(pLevel, pPos, pState, fillStack);
//	                	} else {
//	                        pPlayer.setItemInHand(pHand, stack);
//	                        if(!pPlayer.getInventory().add(fluidHandler.getContainer())) {
//	                            pPlayer.drop(fluidHandler.getContainer(), false);
//	                        }
//	                        
//	                        setRetainedFluidInTank(pLevel, pPos, pState, fillStack);
//	                    }
//	                    return InteractionResult.sidedSuccess(pLevel.isClientSide);
//	                }
//	            }
//	            return InteractionResult.CONSUME;
//
//	}

}
