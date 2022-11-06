package net.codersdownunder.gemmod.events;

import net.codersdownunder.gemmod.init.BlockInit;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.HashMap;
import java.util.Map;

public class LogStrippingEvent
{
    public static Map<Block, Block> BLOCK_STRIPPING_MAP = new HashMap<>();

    static {
        BLOCK_STRIPPING_MAP.put(BlockInit.CHASM_LOG.get(), BlockInit.CHASM_LOG_STRIPPED.get());
    }

    @SubscribeEvent
    public static void onBlockClicked(PlayerInteractEvent.RightClickBlock event) {
        if (event.getItemStack().getItem() instanceof AxeItem) {
            Level world = event.getLevel();
            BlockPos blockpos = event.getPos();
            BlockState blockstate = world.getBlockState(blockpos);
            Block block = BLOCK_STRIPPING_MAP.get(blockstate.getBlock());
            if (block != null) {
                Player playerentity = event.getEntity();
                world.playSound(playerentity, blockpos, SoundEvents.AXE_STRIP, SoundSource.BLOCKS, 1.0F, 1.0F);
                if (!world.isClientSide) {
                    world.setBlockAndUpdate(blockpos, block.defaultBlockState());
                            
                    if (playerentity != null) {
                        event.getItemStack().hurtAndBreak(1, playerentity, (p_220040_1_) -> {
                            p_220040_1_.broadcastBreakEvent(event.getHand());
                        });
                    }
                }
            }
        }

    }



}