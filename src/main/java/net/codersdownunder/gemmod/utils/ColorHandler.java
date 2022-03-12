package net.codersdownunder.gemmod.utils;

import net.codersdownunder.gemmod.GemMod;
import net.codersdownunder.gemmod.init.BlockInit;
import net.codersdownunder.gemmod.init.ItemInit;
import net.minecraft.client.color.block.BlockColor;
import net.minecraft.client.color.item.ItemColor;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = GemMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ColorHandler {

	 	@SubscribeEvent
	    public static void registerBlockColors(ColorHandlerEvent.Block event){
	    	
	    	final BlockColor chasm = (pState, pLevel, pPos, pTintIndex) -> {
	    		return 0x654882;
	    	};
			event.getBlockColors().register(chasm, BlockInit.CHASM_LEAVES.get());
	    }
	 
		@SubscribeEvent
		public static void registerItemColor(ColorHandlerEvent.Item event) {
			final ItemColor chasm = (stack, tintIndex) -> {
				return 0x654882;
			};
			event.getItemColors().register(chasm, ItemInit.CHASM_LEAVES.get());
		}
	 
}
