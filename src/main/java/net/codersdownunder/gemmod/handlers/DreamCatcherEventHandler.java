package net.codersdownunder.gemmod.handlers;

import java.util.Random;

import net.codersdownunder.gemmod.init.BlockInit;
import net.codersdownunder.gemmod.utils.GeomancyTags;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.event.entity.player.PlayerWakeUpEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.items.CapabilityItemHandler;

public class DreamCatcherEventHandler {

	private static Random rand = new Random();

	@SubscribeEvent
	public static void sleepEvent(PlayerWakeUpEvent event) {

		if (!event.getPlayer().level.isClientSide) {
			Level world = event.getPlayer().level;
			BlockPos pos = event.getPlayer().getOnPos();
			// BlockState block = world.getBlockState(pos);

			if (world.getBlockState(pos.above(2)).getBlock() == BlockInit.DREAM_CATCHER.get()) {

				// event.getPlayer().drop(new ItemStack(ItemInit.CHRYSOCOLLA.get(), 3), false);
				BlockEntity chest = world.getBlockEntity(pos.above(2));
				if (chest == null) {
					return;
				}
				
				//System.out.println((double)rand.nextInt(1000) / 10);
				
				double val = rand.nextDouble(1000) / 10;
				
				if (val > 90D) {

					insert(chest, GeomancyTags.Items.DREAM_RARE.getValues().get(rand.nextInt(GeomancyTags.Items.DREAM_RARE.getValues().size())), 1);
				}
				
				if (val < 70D) {
					int items = rand.nextInt(5);
					
					for (int i = 0; i < items; i++) {
						insert(chest, GeomancyTags.Items.DREAM_COMMON.getValues().get(rand.nextInt(GeomancyTags.Items.DREAM_COMMON.getValues().size())), rand.nextInt(3));
					}
				}

			}

		}
	}

	private static void insert(BlockEntity entity, Item item, int count) {

		int slot = rand.nextInt(15);
		entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY).ifPresent(itemHandler -> {
			for (int i = 0; i < 15; i++) {
				if (itemHandler.getStackInSlot(slot).isEmpty() || itemHandler.getStackInSlot(slot).getItem() == item) {
					itemHandler.insertItem(slot, new ItemStack(item, count), false);
					break;
				}
			}
			
			entity.setChanged();
		});
	}

}
