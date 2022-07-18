package net.codersdownunder.gemmod.client;

import net.codersdownunder.gemmod.GemMod;
import net.codersdownunder.gemmod.client.gui.DipperScreen;
import net.codersdownunder.gemmod.client.gui.DreamCatcherScreen;
import net.codersdownunder.gemmod.client.gui.InfusionStandScreen;
import net.codersdownunder.gemmod.client.gui.InfusionTableScreen;
import net.codersdownunder.gemmod.client.gui.SongForgeScreen;
import net.codersdownunder.gemmod.client.gui.TelepadScreen;
import net.codersdownunder.gemmod.client.gui.TerraFirmaScreen;
import net.codersdownunder.gemmod.client.renderer.DipperBlockEntityRenderer;
import net.codersdownunder.gemmod.init.MenuInit;
import net.codersdownunder.gemmod.init.TileEntityInit;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.renderer.blockentity.SignRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = GemMod.MODID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientSetup {
	
	  public static void doClientStuff(final FMLClientSetupEvent event) {
		  
	        MenuScreens.register(MenuInit.INFUSION_TABLE_CONTAINER.get(), InfusionTableScreen::new);
	        MenuScreens.register(MenuInit.DIPPER_CONTAINER.get(), DipperScreen::new);
	        MenuScreens.register(MenuInit.DREAM_CATCHER_MENU.get(), DreamCatcherScreen::new);
	        MenuScreens.register(MenuInit.TELEPAD_MENU.get(), TelepadScreen::new);
	        MenuScreens.register(MenuInit.TERRA_FIRMA_MENU.get(), TerraFirmaScreen::new);
	        MenuScreens.register(MenuInit.INFUSION_STAND_MENU.get(), InfusionStandScreen::new);
	        MenuScreens.register(MenuInit.SONG_FORGE_MENU.get(), SongForgeScreen::new);
	        
	        
	        BlockEntityRenderers.register(TileEntityInit.CUSTOM_SIGN.get(), SignRenderer::new);
	        event.enqueueWork(() -> {
	            Sheets.addWoodType(GemMod.CHASM);
	        });
	        
	        BlockEntityRenderers.register(TileEntityInit.DIPPER_BE.get(), DipperBlockEntityRenderer::new);
	    }
	  
}
