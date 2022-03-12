package net.codersdownunder.gemmod.client.gui;

import java.awt.Color;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;

import net.codersdownunder.gemmod.GemMod;
import net.codersdownunder.gemmod.blocks.dream.DreamCatcherMenu;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class DreamCatcherScreen extends AbstractContainerScreen<DreamCatcherMenu>
{

    private ResourceLocation GUI = new ResourceLocation(GemMod.MODID, "textures/gui/dreamcatcher.png");
    public DreamCatcherMenu container;

    public DreamCatcherScreen(DreamCatcherMenu container, Inventory inv, Component name) {
        super(container, inv, name);
        this.container = container;

    }
    
    static final int FONT_Y_SPACING = 10;
    static final int PLAYER_INV_LABEL_XPOS = DreamCatcherMenu.PLAYER_INVENTORY_XPOS;
    static final int PLAYER_INV_LABEL_YPOS = DreamCatcherMenu.PLAYER_INVENTORY_YPOS - FONT_Y_SPACING;

    @Override
    public void render(PoseStack matrixStack, int mouseX, int mouseY, float partialTicks) {
        this.renderBackground(matrixStack);
        super.render(matrixStack, mouseX, mouseY, partialTicks);
        this.renderTooltip(matrixStack, mouseX, mouseY);
        
    }
    
    @Override
    protected void containerTick() {
    	// TODO Auto-generated method stub
    	super.containerTick();
    }

    @Override
    protected void renderLabels(PoseStack matrixStack, int mouseX, int mouseY) {
        
        final int LABEL_XPOS = 38;
        final int LABEL_YPOS = 13;
        this.font.draw(matrixStack, this.title, LABEL_XPOS, LABEL_YPOS, Color.darkGray.getRGB()); 
        
        this.font.draw(matrixStack, this.playerInventoryTitle, PLAYER_INV_LABEL_XPOS, PLAYER_INV_LABEL_YPOS,
				Color.darkGray.getRGB());	
    }
    

    @Override
    protected void renderBg(PoseStack matrixStack, float partialTicks, int mouseX, int mouseY) {
        RenderSystem.setShaderTexture(0, GUI);
        int relX = (this.width - 202) / 2;
        int relY = (this.height - 220) / 2;
        this.blit(matrixStack, relX, relY, 0, 0, 202, 220);
    }
}
