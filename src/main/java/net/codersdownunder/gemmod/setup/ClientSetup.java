package net.codersdownunder.gemmod.setup;

import net.codersdownunder.gemmod.GemMod;
import net.codersdownunder.gemmod.client.gui.DipperScreen;
import net.codersdownunder.gemmod.client.gui.InfusionTableScreen;
import net.codersdownunder.gemmod.client.renderer.DipperBlockEntityRenderer;
import net.codersdownunder.gemmod.init.BlockInit;
import net.codersdownunder.gemmod.init.ContainerInit;
import net.codersdownunder.gemmod.init.TileEntityInit;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.renderer.blockentity.SignRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = GemMod.MODID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientSetup {
	
	  public static void doClientStuff(final FMLClientSetupEvent event) {
		  
	        MenuScreens.register(ContainerInit.INFUSION_TABLE_CONTAINER.get(), InfusionTableScreen::new);
	        MenuScreens.register(ContainerInit.DIPPER_CONTAINER.get(), DipperScreen::new);
	        
	        RenderType GppRender = RenderType.cutoutMipped();
	       
	        //RenderTypeLookup.setRenderLayer(BlockInit.CHASM_LEAVES.get(), RenderType.cutoutMipped());
	        
	        event.enqueueWork(() -> {
	        ItemBlockRenderTypes.setRenderLayer(BlockInit.END_LANTERN.get(), GppRender);
	        ItemBlockRenderTypes.setRenderLayer(BlockInit.INFUSION_TABLE.get(), GppRender);
	        ItemBlockRenderTypes.setRenderLayer(BlockInit.CHASM_LEAVES.get(), RenderType.cutoutMipped());
	        ItemBlockRenderTypes.setRenderLayer(BlockInit.DIPPER.get(), RenderType.cutout());     
	        });
	        
	        BlockEntityRenderers.register(TileEntityInit.CUSTOM_SIGN.get(), SignRenderer::new);
	        event.enqueueWork(() -> {
	            Sheets.addWoodType(GemMod.CHASM);
	        });
	        
	        BlockEntityRenderers.register(TileEntityInit.DIPPER_BE.get(), DipperBlockEntityRenderer::new);
	    }
}
