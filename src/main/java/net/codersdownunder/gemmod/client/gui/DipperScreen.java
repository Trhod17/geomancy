package net.codersdownunder.gemmod.client.gui;

import com.google.common.collect.Lists;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.codersdownunder.gemmod.Config;
import net.codersdownunder.gemmod.GemMod;
import net.codersdownunder.gemmod.blocks.dipper.DipperBlockEntity;
import net.codersdownunder.gemmod.blocks.dipper.DipperMenu;
import net.codersdownunder.gemmod.utils.FluidUtils;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.InventoryMenu;
import net.minecraftforge.fluids.FluidStack;

import java.awt.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;


public class DipperScreen extends AbstractContainerScreen<DipperMenu> {

    final static int FONT_Y_SPACING = 10;
    final static int PLAYER_INV_LABEL_XPOS = DipperMenu.PLAYER_INVENTORY_XPOS;
    final static int PLAYER_INV_LABEL_YPOS = DipperMenu.PLAYER_INVENTORY_YPOS - FONT_Y_SPACING;

    private ResourceLocation GUI = new ResourceLocation(GemMod.MODID, "textures/gui/dipper.png");
    public DipperMenu container;
    private DipperBlockEntity ent;

    public DipperScreen(DipperMenu container, Inventory inv, Component name) {
        super(container, inv, name);
        ent = container.tile;
        this.container = container;
        imageHeight = 222;
    }

    public void init() {
        super.init();
    }

    @Override
    public void render(PoseStack matrixStack, int mouseX, int mouseY, float partialTicks) {
        this.renderBackground(matrixStack);
        super.render(matrixStack, mouseX, mouseY, partialTicks);
        this.renderTooltip(matrixStack, mouseX, mouseY);

        // Fluid tooltip
        if (mouseX >= this.leftPos + 152 && mouseX <= this.leftPos + 167 && mouseY >= this.topPos + 81 && mouseY <= this.topPos + 124) {
            List<Component> tooltip = new ArrayList<>();
            tooltip.add(ent.getFluid().isEmpty() ? new TranslatableComponent("screen." + GemMod.MODID + ".tank_empty") : ent.getFluid().getDisplayName());
            DecimalFormat f = new DecimalFormat("#,##0");
            tooltip.add(new TranslatableComponent("screen." + GemMod.MODID + ".liquid_amount", f.format(ent.getFluid().getAmount()), f.format(DipperBlockEntity.capacity)));
            float percentage;
            if (DipperBlockEntity.capacity == 0) {
                percentage = 0;
            } else {
                percentage = ent.getFluid().getAmount() * 100.0F / DipperBlockEntity.capacity;
            }
            tooltip.add(new TranslatableComponent("screen." + GemMod.MODID + ".liquid_percentage", String.format("%.2f", percentage)).append("%").withStyle(percentage < 60 ? ChatFormatting.GREEN : percentage < 90 ? ChatFormatting.YELLOW : ChatFormatting.RED));
            this.renderTooltip(matrixStack, Lists.transform(tooltip, Component::getVisualOrderText), mouseX, mouseY);
        }
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

        int[] BUBBLELENGTHS = new int[]{29, 24, 22, 20, 18, 16, 13, 11, 9, 6, 3, 0};

        int relX = (this.width - this.imageWidth) / 2;
        int relY = (this.height - this.imageHeight) / 2;
        if (container.getBlockEntity().counter > 0) {
            int k = BUBBLELENGTHS[container.getBlockEntity().counter / 6 % 12];
            blit(matrixStack, relX + 150, relY + 43 - k, 176, 27 - k, 12, k);
        }
        if (container.getBlockEntity().counter > 0) {
            int k = (int) (27F - ((1.0F * container.getBlockEntity().counter) / (1.0F * Config.SERVER.dipperTime.get())) * 27F);
            blit(matrixStack, relX + 163, relY + 43 - k, 188, 27 - k, 5, k);
        }

        // Fluid in tank
        FluidStack fluid = ent.getFluid();
        int index = FluidUtils.getFluidScaled(43, fluid, DipperBlockEntity.capacity);
        TextureAtlasSprite fluidTexture = FluidUtils.getFluidTexture(fluid);
        RenderSystem.setShaderTexture(0, InventoryMenu.BLOCK_ATLAS);
        FluidUtils.color(FluidUtils.getLiquidColorWithBiome(fluid, this.menu.getBlockEntity()));
        blit(matrixStack, getGuiLeft() + 152, this.topPos + 81 + index, 176, 15, 43 - index, fluidTexture);
    }
}
