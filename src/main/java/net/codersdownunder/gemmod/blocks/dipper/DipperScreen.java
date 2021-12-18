package net.codersdownunder.gemmod.blocks.dipper;

import java.awt.Color;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;


import com.google.common.collect.Lists;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;

import net.codersdownunder.gemmod.GemMod;
import net.codersdownunder.gemmod.utils.FluidUtils;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.components.Widget;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.InventoryMenu;
import net.minecraftforge.fluids.FluidStack;


public class DipperScreen extends AbstractContainerScreen<DipperContainer> {

	
	final static int FONT_Y_SPACING = 10;
	final static int PLAYER_INV_LABEL_XPOS = DipperContainer.PLAYER_INVENTORY_XPOS;
	final static int PLAYER_INV_LABEL_YPOS = DipperContainer.PLAYER_INVENTORY_YPOS - FONT_Y_SPACING;
	
	private ResourceLocation GUI = new ResourceLocation(GemMod.MODID, "textures/gui/dipper.png");
	public DipperContainer container;
	private DipperBlockEntity ent;

	public DipperScreen(DipperContainer container, Inventory inv, Component name) {
		super(container, inv, name);
		ent = container.tile;
		this.container = container;

	}


	public void init() {
		super.init();
	}
	
	@Override
	public void render(PoseStack matrixStack, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(matrixStack);
		super.render(matrixStack, mouseX, mouseY, partialTicks);
		this.renderTooltip(matrixStack, mouseX, mouseY);
		this.renderLabels(matrixStack, mouseX, mouseY);
		

		if(mouseX > this.leftPos + 140 && mouseX < this.leftPos + 160 && mouseY > this.topPos + 54 && mouseY < this.topPos + 100) {
            List<Component> tooltip = new ArrayList<>();
            tooltip.add(ent.getFluid().isEmpty() ? new TranslatableComponent(GemMod.MODID + ".tank_empty") : ent.getFluid().getDisplayName());
            DecimalFormat f = new DecimalFormat("#,##0");
            tooltip.add(new TranslatableComponent(GemMod.MODID + ".liquid_amount", f.format(ent.getFluid().getAmount()), f.format(DipperBlockEntity.capacity)));
            float percentage;
            if(DipperBlockEntity.capacity == 0)
                percentage = 0;
            else
                percentage = ent.getFluid().getAmount() * 100.0F / DipperBlockEntity.capacity;
            tooltip.add(new TranslatableComponent(GemMod.MODID + ".liquid_percentage", String.format("%.2f", percentage)).append("%").withStyle(percentage < 60 ? ChatFormatting.GREEN : percentage < 90 ? ChatFormatting.YELLOW : ChatFormatting.RED));
            this.renderTooltip(matrixStack, Lists.transform(tooltip, Component::getVisualOrderText), mouseX, mouseY);
        }
	}
	
	@Override
	protected void containerTick() {
		// TODO Auto-generated method stub
		super.containerTick();
		
	}

	@Override
	protected void renderLabels(PoseStack matrixStack, int mouseX, int mouseY) {

		final int LABEL_XPOS = 60;
		final int LABEL_YPOS = -23;
		this.font.draw(matrixStack, this.title, LABEL_XPOS, LABEL_YPOS, Color.darkGray.getRGB());

		this.font.draw(matrixStack, this.playerInventoryTitle, PLAYER_INV_LABEL_XPOS, PLAYER_INV_LABEL_YPOS,
				Color.darkGray.getRGB());	
	}
	
	@Override
	protected void renderBg(PoseStack matrixStack, float partialTicks, int mouseX, int mouseY) {

        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
		RenderSystem.setShaderTexture(0, GUI);
		int relX = (this.width - 202) / 2;
		int relY = (this.height - 220) / 2;
		this.blit(matrixStack, relX, relY, 0, 0, 175, 220);
		
		//if (container.getTable().counter > 0) {
			int d = 10000;
			double k = d / 100.0;
			//System.out.println((int)k);
			this.blit(matrixStack, relX + 150,  relY + 7 + 10 - (int) k, 176,  0 - (int) k, 17, 1 + (int)k);
			
			//System.out.println("test2");
		//}
		
		 FluidStack fluid = ent.getFluid();
	        int index = FluidUtils.getFluidScaled(43, fluid, DipperBlockEntity.capacity);
	        TextureAtlasSprite fluidTexture = FluidUtils.getFluidTexture(fluid);
	        RenderSystem.setShaderTexture(0, InventoryMenu.BLOCK_ATLAS);
	        FluidUtils.color(FluidUtils.getLiquidColorWithBiome(fluid, this.menu.getTable()));
	        blit(matrixStack, this.leftPos + 140, this.topPos + 54 + index, 176, 15, 43 - index, fluidTexture);
	}
	
	
}
