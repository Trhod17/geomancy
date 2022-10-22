package net.codersdownunder.gemmod.client.gui;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.codersdownunder.gemmod.GemMod;
import net.codersdownunder.gemmod.blocks.songforge.SongForgeMenu;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

import java.awt.*;

public class SongForgeScreen extends AbstractContainerScreen<SongForgeMenu>
{

    private ResourceLocation GUI = new ResourceLocation(GemMod.MODID, "textures/gui/song_forge.png");

    public SongForgeScreen(SongForgeMenu menu, Inventory inv, Component name) {
        super(menu, inv, name);

    }
    
    static final int FONT_Y_SPACING = 10;
    static final int PLAYER_INV_LABEL_XPOS = -5;
    static final int PLAYER_INV_LABEL_YPOS = 57;

    @Override
    public void render(PoseStack pPoseStack, int mouseX, int mouseY, float partialTicks) {
        this.renderBackground(pPoseStack);
        super.render(pPoseStack, mouseX, mouseY, partialTicks);
        this.renderTooltip(pPoseStack, mouseX, mouseY);
        
    }
    
    public void init() {
		super.init();
	}

    @Override
    protected void renderLabels(PoseStack pPoseStack, int mouseX, int mouseY) {
        
        final int LABEL_XPOS = 48;
        final int LABEL_YPOS = -12;
        this.font.draw(pPoseStack, this.title, LABEL_XPOS, LABEL_YPOS, Color.darkGray.getRGB());
        
        this.font.draw(pPoseStack, this.playerInventoryTitle, PLAYER_INV_LABEL_XPOS, PLAYER_INV_LABEL_YPOS,
				Color.darkGray.getRGB());	
    }


    @Override
    protected void renderBg(PoseStack pPoseStack, float partialTicks, int mouseX, int mouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, GUI);
        int i = (this.width - 202) / 2;
        int j = (this.height - 200) / 2;
        this.blit(pPoseStack, i, j, 0, 0, 198, 200);

        renderProgressArrow(pPoseStack, i, j);
        //renderBurningProgress(pPoseStack, relX, relY);

        if (this.getMenu().isBurning()) {
            int k = this.getMenu().getLitProgress();
            //this.blit(pPoseStack, getGuiLeft() + 39, getGuiTop() + 36 + 12 - i, 176, 12 - i, 14, i + 1);
            this.blit(pPoseStack, getGuiLeft() + 26, getGuiTop() + 21 + 12 - k, 198, 18 - k, 14, k + 1);
        }

//        if(menu.isBurning()) {
//            //GemMod.LOGGER.info("Crafting");
//            int k = menu.getBurnLeftScaled(14);
//            //this.blit(pPoseStack, relX + 39, relY + 33 + 1 + k, 198, 12 - k, 14, k + 1);
//            this.blit(pPoseStack, relX + 39, relY + 33, 198, 6, 14, 14);
//            //blit(pPoseStack, relX + 39, relY + 36 + 12, 198, 12 - k, 14, k - 1);
//        }

    }

    private void renderProgressArrow(PoseStack pPoseStack, int x, int y) {
        //GemMod.LOGGER.info("Not Crafting " + menu.isCrafting());
        if(menu.isCrafting()) {
            //GemMod.LOGGER.info("Crafting");
            blit(pPoseStack, x + 79, y + 35, 198, 20, menu.getScaledProgress(), 15);
        }
    }

    private void renderBurningProgress(PoseStack pPoseStack, int x, int y) {
        //GemMod.LOGGER.info("Not Crafting " + menu.isCrafting());

    }
}
