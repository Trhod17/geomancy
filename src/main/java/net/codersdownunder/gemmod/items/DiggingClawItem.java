package net.codersdownunder.gemmod.items;


import net.codersdownunder.gemmod.utils.GeomancyTags;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.DiggerItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CampfireBlock;
import net.minecraft.world.level.block.GrowingPlantHeadBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.TierSortingRegistry;
import net.minecraftforge.common.ToolAction;
import net.minecraftforge.common.ToolActions;


public class DiggingClawItem extends DiggerItem
{
	
	private Tier tier;

    public DiggingClawItem(float attackDamageBaseLine, float attackDamageBaseline, Tiers tier, TagKey<Block> blocks, Properties p_i48487_1_)
    {
        super(attackDamageBaseline, attackDamageBaseline, tier, blocks, p_i48487_1_);
        this.tier = tier;
    }
    
    
    
    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        Level level = pContext.getLevel();
        BlockPos blockpos = pContext.getClickedPos();
        BlockState blockstate = level.getBlockState(blockpos);
    	Block block = blockstate.getBlock();
    	
    	if (block instanceof GrowingPlantHeadBlock) {
            GrowingPlantHeadBlock growingplantheadblock = (GrowingPlantHeadBlock)block;
            if (!growingplantheadblock.isMaxAge(blockstate)) {
               Player player = pContext.getPlayer();
               ItemStack itemstack = pContext.getItemInHand();
               if (player instanceof ServerPlayer) {
                  CriteriaTriggers.ITEM_USED_ON_BLOCK.trigger((ServerPlayer)player, blockpos, itemstack);
               }

               level.playSound(player, blockpos, SoundEvents.GROWING_PLANT_CROP, SoundSource.BLOCKS, 1.0F, 1.0F);
               level.setBlockAndUpdate(blockpos, growingplantheadblock.getMaxAgeState(blockstate));
               if (player != null) {
                  itemstack.hurtAndBreak(1, player, (p_186374_) -> {
                     p_186374_.broadcastBreakEvent(pContext.getHand());
                  });
               }

               return InteractionResult.sidedSuccess(level.isClientSide);
            }
         }

    	
        if (pContext.getClickedFace() == Direction.DOWN) {
            return InteractionResult.PASS;
         } else {
            Player player = pContext.getPlayer();
            BlockState blockstate1 = blockstate.getToolModifiedState(pContext, net.minecraftforge.common.ToolActions.SHOVEL_FLATTEN, false);
            BlockState blockstate2 = null;
            if (blockstate1 != null && level.isEmptyBlock(blockpos.above())) {
               level.playSound(player, blockpos, SoundEvents.SHOVEL_FLATTEN, SoundSource.BLOCKS, 1.0F, 1.0F);
               blockstate2 = blockstate1;
            } else if (blockstate.getBlock() instanceof CampfireBlock && blockstate.getValue(CampfireBlock.LIT)) {
               if (!level.isClientSide()) {
                  level.levelEvent((Player)null, 1009, blockpos, 0);
               }

               CampfireBlock.dowse(pContext.getPlayer(), level, blockpos, blockstate);
               blockstate2 = blockstate.setValue(CampfireBlock.LIT, Boolean.valueOf(false));
            }

            if (blockstate2 != null) {
               if (!level.isClientSide) {
                  level.setBlock(blockpos, blockstate2, 11);
                  if (player != null) {
                     pContext.getItemInHand().hurtAndBreak(1, player, (p_43122_) -> {
                        p_43122_.broadcastBreakEvent(pContext.getHand());
                     });
                  }
               }

               return InteractionResult.sidedSuccess(level.isClientSide);
            } else {
               return InteractionResult.PASS;
            }
         }
    }
    
    @Override
    public boolean isCorrectToolForDrops(BlockState pBlock) {
        return pBlock.is(Blocks.COBWEB) || pBlock.is(Blocks.REDSTONE_WIRE) || pBlock.is(Blocks.TRIPWIRE);
     }

    
    @Override
    public net.minecraft.world.InteractionResult interactLivingEntity(ItemStack stack, net.minecraft.world.entity.player.Player playerIn, LivingEntity entity, net.minecraft.world.InteractionHand hand) {
       if (entity.level.isClientSide) return net.minecraft.world.InteractionResult.PASS;
       if (entity instanceof net.minecraftforge.common.IForgeShearable) {
           net.minecraftforge.common.IForgeShearable target = (net.minecraftforge.common.IForgeShearable)entity;
          BlockPos pos = new BlockPos(entity.getX(), entity.getY(), entity.getZ());
          if (target.isShearable(stack, entity.level, pos)) {
             java.util.List<ItemStack> drops = target.onSheared(playerIn, stack, entity.level, pos, stack.getEnchantmentLevel(Enchantments.BLOCK_FORTUNE));
             java.util.Random rand = new java.util.Random();
             drops.forEach(d -> {
                net.minecraft.world.entity.item.ItemEntity ent = entity.spawnAtLocation(d, 1.0F);
                ent.setDeltaMovement(ent.getDeltaMovement().add((double)((rand.nextFloat() - rand.nextFloat()) * 0.1F), (double)(rand.nextFloat() * 0.05F), (double)((rand.nextFloat() - rand.nextFloat()) * 0.1F)));
             });
             stack.hurtAndBreak(1, entity, e -> e.broadcastBreakEvent(hand));
          }
          return net.minecraft.world.InteractionResult.SUCCESS;
       }
       return net.minecraft.world.InteractionResult.PASS;
    }

    
    @Override
    public float getDestroySpeed(ItemStack stack, BlockState state)
    {
        if (state.is(BlockTags.MINEABLE_WITH_SHOVEL)) return speed;
        if (state.is(BlockTags.MINEABLE_WITH_PICKAXE)) return speed;
        return super.getDestroySpeed(stack, state);
    }

    @Override
    public boolean isCorrectToolForDrops(ItemStack stack, BlockState state)
    {
        if (state.is(BlockTags.MINEABLE_WITH_PICKAXE))
            return TierSortingRegistry.isCorrectTierForDrops(tier, state);
        if (state.is(BlockTags.MINEABLE_WITH_SHOVEL))
            return TierSortingRegistry.isCorrectTierForDrops(tier, state);
        if (state.is(GeomancyTags.Blocks.claw))
            return TierSortingRegistry.isCorrectTierForDrops(tier, state);
        return false;
    }

    @Override
    public boolean canPerformAction(ItemStack stack, ToolAction toolAction)
    {
        return ToolActions.DEFAULT_SHOVEL_ACTIONS.contains(toolAction) || ToolActions.DEFAULT_PICKAXE_ACTIONS.contains(toolAction) || ToolActions.DEFAULT_SHEARS_ACTIONS.contains(toolAction);
    }
    
    
    
}