package net.codersdownunder.gemmod.client.gui;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.codersdownunder.gemmod.GemMod;
import net.codersdownunder.gemmod.blocks.infusion.InfusionTableMenu;
import net.codersdownunder.gemmod.client.gui.widgets.GemModButton;
import net.codersdownunder.gemmod.network.GemModNetwork;
import net.codersdownunder.gemmod.network.messages.InfusionCraftingMessage;
import net.codersdownunder.gemmod.utils.TextUtils;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

import java.awt.*;

public class InfusionTableScreen extends AbstractContainerScreen<InfusionTableMenu> {
    final static int FONT_Y_SPACING = 10;
    final static int PLAYER_INV_LABEL_XPOS = InfusionTableMenu.PLAYER_INVENTORY_XPOS;
    final static int PLAYER_INV_LABEL_YPOS = InfusionTableMenu.PLAYER_INVENTORY_YPOS - FONT_Y_SPACING;

    private ResourceLocation GUI = new ResourceLocation(GemMod.MODID, "textures/gui/infusion_table.png");
    public InfusionTableMenu container;

    public InfusionTableScreen(InfusionTableMenu container, Inventory inv, Component name) {
        super(container, inv, name);
        this.container = container;
        imageHeight = 222;
    }

    @Override
    protected void init() {
        super.init();

        this.addRenderableWidget(new GemModButton(this.width / 2 - 42, this.height / 2 - 1, 84, 20, TextUtils.Tooltip("screen.geomancy.infusion_table.button.text"),
                button -> {
                    GemModNetwork.CHANNEL.sendToServer(new InfusionCraftingMessage(this.getMenu().getPos()));
                }));
    }

    @Override
    public void render(PoseStack matrixStack, int mouseX, int mouseY, float partialTicks) {
        this.renderBackground(matrixStack);
        super.render(matrixStack, mouseX, mouseY, partialTicks);
        this.renderTooltip(matrixStack, mouseX, mouseY);
    }

    @Override
    protected void renderLabels(PoseStack matrixStack, int mouseX, int mouseY) {
        this.font.draw(matrixStack, this.title, 8, 6, Color.darkGray.getRGB());
        this.font.draw(matrixStack, this.playerInventoryTitle, PLAYER_INV_LABEL_XPOS, PLAYER_INV_LABEL_YPOS, Color.darkGray.getRGB());
    }

    @Override
    protected void renderBg(PoseStack matrixStack, float partialTicks, int mouseX, int mouseY) {
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, GUI);

        this.blit(matrixStack, getGuiLeft(), getGuiTop(), 0, 0, getXSize(), getYSize());
    }
}
