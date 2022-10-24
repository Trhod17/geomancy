package net.codersdownunder.gemmod.client.gui;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.codersdownunder.gemmod.Geomancy;
import net.codersdownunder.gemmod.blocks.infusionstand.InfusionStandMenu;
import net.codersdownunder.gemmod.client.gui.widgets.GemModButton;
import net.codersdownunder.gemmod.network.GemModNetwork;
import net.codersdownunder.gemmod.network.messages.InfusionCraftingMessage;
import net.codersdownunder.gemmod.utils.TextUtils;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

import java.awt.*;

public class InfusionStandScreen extends AbstractContainerScreen<InfusionStandMenu>
{

    private ResourceLocation GUI = new ResourceLocation(Geomancy.MODID, "textures/gui/infusion_stand.png");
    public InfusionStandMenu container;

    public InfusionStandScreen(InfusionStandMenu container, Inventory inv, Component name) {
        super(container, inv, name);
        this.container = container;

    }
    
    final static int FONT_Y_SPACING = 10;
    final static int PLAYER_INV_LABEL_XPOS = InfusionStandMenu.PLAYER_INVENTORY_XPOS;
    final static int PLAYER_INV_LABEL_YPOS = InfusionStandMenu.PLAYER_INVENTORY_YPOS - FONT_Y_SPACING;

    @Override
    public void render(PoseStack matrixStack, int mouseX, int mouseY, float partialTicks) {
        this.renderBackground(matrixStack);
        super.render(matrixStack, mouseX, mouseY, partialTicks);
        this.renderTooltip(matrixStack, mouseX, mouseY);
        
    }
    
    @Override
    protected void containerTick() {
    	super.containerTick();
    }

    @Override
    protected void renderLabels(PoseStack matrixStack, int mouseX, int mouseY) {
        
        final int LABEL_XPOS = 40;
        final int LABEL_YPOS = -23;
        this.font.draw(matrixStack, this.title, LABEL_XPOS, LABEL_YPOS, Color.darkGray.getRGB()); 
        
        this.font.draw(matrixStack, this.playerInventoryTitle, PLAYER_INV_LABEL_XPOS, PLAYER_INV_LABEL_YPOS,
				Color.darkGray.getRGB());	

        this.addRenderableWidget(new GemModButton(this.width / 2 - 55, this.height / 2 + 3, 84, 20, TextUtils.Tooltip("screen.geomancy.infusion_table.button.text"), 
                button ->
                    GemModNetwork.CHANNEL.sendToServer(new InfusionCraftingMessage(this.getMenu().getPos()))
        		));
    }
    

    @Override
    protected void renderBg(PoseStack matrixStack, float partialTicks, int mouseX, int mouseY) {
        RenderSystem.setShaderTexture(0, GUI);
        int relX = (this.width - 202) / 2;
        int relY = (this.height - 220) / 2;
        this.blit(matrixStack, relX, relY, 0, 0, 202, 225);
    }
}
