package net.codersdownunder.gemmod.handlers;

import net.codersdownunder.gemmod.init.BlockInit;
import net.codersdownunder.gemmod.init.ItemInit;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.event.entity.player.PlayerWakeUpEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.items.CapabilityItemHandler;

public class DreamCatcherEventHandler {

	@SubscribeEvent
	public static void sleepEvent(PlayerWakeUpEvent event) {
		
		if (!event.getPlayer().level.isClientSide) {
			Level world = event.getPlayer().level;
			BlockPos pos = event.getPlayer().getOnPos();
			//BlockState block = world.getBlockState(pos);
			
			if (world.getBlockState(pos.below()).getBlock() == Blocks.CHEST) {
				System.out.println("chest");
				event.getPlayer().drop(new ItemStack(ItemInit.CHRYSOCOLLA.get(), 3), false);
				BlockEntity chest = world.getBlockEntity(pos.below());
				chest.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, Direction.UP)
						.ifPresent(itemHandler -> {
							itemHandler.insertItem(0, new ItemStack(ItemInit.AMETHYST.get(), 4), false);
							chest.setChanged();
			    });
				
			

				//System.out.println(itemhandler);
				
			}
			
			if (world.getBlockState(pos.above(2)).getBlock() == BlockInit.DREAM_CATCHER.get()) {
				System.out.println(world.getBlockState(pos.above(2)).getBlock());
				event.getPlayer().drop(new ItemStack(ItemInit.AGATE.get(), 3), false);
			}
			
		}
	}
}
