package net.codersdownunder.gemmod.client;

import net.codersdownunder.gemmod.Geomancy;
import net.codersdownunder.gemmod.client.gui.DipperScreen;
import net.codersdownunder.gemmod.client.gui.DreamCatcherScreen;
import net.codersdownunder.gemmod.client.gui.InfusionStandScreen;
import net.codersdownunder.gemmod.client.gui.InfusionTableScreen;
import net.codersdownunder.gemmod.client.gui.SongForgeScreen;
import net.codersdownunder.gemmod.client.gui.TelepadScreen;
import net.codersdownunder.gemmod.client.gui.TerraFirmaScreen;
import net.codersdownunder.gemmod.client.renderer.DipperBlockEntityRenderer;
import net.codersdownunder.gemmod.client.renderer.InfiniteSourceEntityRenderer;
import net.codersdownunder.gemmod.client.renderer.entities.CupidArrowRenderer;
import net.codersdownunder.gemmod.init.*;
import net.codersdownunder.gemmod.particles.PurpleFlameParticle;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.renderer.blockentity.SignRenderer;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

public class ClientSetup {

	public static void subscribeClientEvents() {
		IEventBus forgeBus = MinecraftForge.EVENT_BUS;
		IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

		modEventBus.addListener(ClientSetup::doClientStuff);
		modEventBus.addListener(ClientSetup::registerParticleFactories);
	}
	
	  public static void doClientStuff(final FMLClientSetupEvent event) {
		  
	        MenuScreens.register(MenuInit.INFUSION_TABLE_CONTAINER.get(), InfusionTableScreen::new);
	        MenuScreens.register(MenuInit.DIPPER_CONTAINER.get(), DipperScreen::new);
	        MenuScreens.register(MenuInit.DREAM_CATCHER_MENU.get(), DreamCatcherScreen::new);
	        MenuScreens.register(MenuInit.TELEPAD_MENU.get(), TelepadScreen::new);
	        MenuScreens.register(MenuInit.TERRA_FIRMA_MENU.get(), TerraFirmaScreen::new);
	        MenuScreens.register(MenuInit.INFUSION_STAND_MENU.get(), InfusionStandScreen::new);
	        MenuScreens.register(MenuInit.SONG_FORGE_MENU.get(), SongForgeScreen::new);
	        
	        
	        BlockEntityRenderers.register(BlockEntityInit.CUSTOM_SIGN.get(), SignRenderer::new);
	        event.enqueueWork(() -> {
	            Sheets.addWoodType(Geomancy.CHASM);
	        });
	        
	        BlockEntityRenderers.register(BlockEntityInit.DIPPER_BE.get(), DipperBlockEntityRenderer::new);
		  	BlockEntityRenderers.register(BlockEntityInit.SOURCE_BE.get(), InfiniteSourceEntityRenderer::new);

		  	EntityRenderers.register(EntityInit.CUPID_ARROW.get(), CupidArrowRenderer::new);

		  	ItemBlockRenderTypes.setRenderLayer(FluidInit.SOURCE_HEALING_WATER.get(), RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(FluidInit.FLOWING_HEALING_WATER.get(), RenderType.translucent());

	  }

	public static void registerParticleFactories(RegisterParticleProvidersEvent event) {
		  event.register(ParticlesInit.PURPLE_FLAME.get(), PurpleFlameParticle.Provider::new);
	}
	  
}
