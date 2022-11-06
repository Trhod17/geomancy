package net.codersdownunder.gemmod.events;

import net.codersdownunder.gemmod.init.BlockInit;
import net.codersdownunder.gemmod.utils.GeomancyTags;
import net.codersdownunder.gemmod.utils.TagUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.event.entity.player.PlayerWakeUpEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.Random;

public class DreamCatcherEventHandler {

	private static Random rand = new Random();

	@SubscribeEvent
	public static void sleepEvent(PlayerWakeUpEvent event) {

		if (!event.getEntity().level.isClientSide) {
			Level world = event.getEntity().level;
			BlockPos pos = event.getEntity().getOnPos();
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

					insert(chest, TagUtils.getValues(GeomancyTags.Items.DREAM_RARE).get(rand.nextInt(TagUtils.getValues(GeomancyTags.Items.DREAM_RARE).size())), 1);
				}
				
				if (val < 70D) {
					int items = rand.nextInt(5);
					
					for (int i = 0; i < items; i++) {
						insert(chest, TagUtils.getValues(GeomancyTags.Items.DREAM_COMMON).get(rand.nextInt(TagUtils.getValues(GeomancyTags.Items.DREAM_RARE).size())), rand.nextInt(3));
					}
				}

			}

		}
	}

	private static void insert(BlockEntity entity, Item item, int count) {

		int slot = rand.nextInt(15);
		entity.getCapability(ForgeCapabilities.ITEM_HANDLER).ifPresent(itemHandler -> {
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
