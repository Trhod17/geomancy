package net.codersdownunder.gemmod.client.gui;

import java.awt.Color;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;

import net.codersdownunder.gemmod.GemMod;
import net.codersdownunder.gemmod.blocks.infusion.InfusionTableContainer;
import net.codersdownunder.gemmod.client.gui.widgets.GemModButton;
import net.codersdownunder.gemmod.network.GemModNetwork;
import net.codersdownunder.gemmod.network.messages.InfusionCraftingMessage;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class InfusionTableScreen extends AbstractContainerScreen<InfusionTableContainer>
{

    private ResourceLocation GUI = new ResourceLocation(GemMod.MODID, "textures/gui/infusion_table.png");
    public InfusionTableContainer container;

    public InfusionTableScreen(InfusionTableContainer container, Inventory inv, Component name) {
        super(container, inv, name);
        this.container = container;

    }
    
    final static int FONT_Y_SPACING = 10;
    final static int PLAYER_INV_LABEL_XPOS = InfusionTableContainer.PLAYER_INVENTORY_XPOS;
    final static int PLAYER_INV_LABEL_YPOS = InfusionTableContainer.PLAYER_INVENTORY_YPOS - FONT_Y_SPACING;

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
        
        final int LABEL_XPOS = 40;
        final int LABEL_YPOS = -23;
        this.font.draw(matrixStack, this.title, LABEL_XPOS, LABEL_YPOS, Color.darkGray.getRGB()); 
        
        this.font.draw(matrixStack, this.getTitle(),                  
                PLAYER_INV_LABEL_XPOS, PLAYER_INV_LABEL_YPOS, Color.darkGray.getRGB());

        this.addRenderableWidget(new GemModButton(this.width / 2 - 55, this.height / 2 + 3, 84, 20, new TranslatableComponent("screen.geomancy.infusion_table.button.text"), 
                button -> { 
                    //craft();
                    //this.container.getTable().crafting = true;
                    GemModNetwork.CHANNEL.sendToServer(new InfusionCraftingMessage(this.getMenu().getPos()));
                
                }));
    }
    

    @Override
    protected void renderBg(PoseStack matrixStack, float partialTicks, int mouseX, int mouseY) {
        RenderSystem.setShaderTexture(0, GUI);
        int relX = (this.width - 202) / 2;
        int relY = (this.height - 220) / 2;
        this.blit(matrixStack, relX, relY, 0, 0, 202, 220);
    }
}
