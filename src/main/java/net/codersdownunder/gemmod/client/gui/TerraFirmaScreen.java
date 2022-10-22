package net.codersdownunder.gemmod.client.gui;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.codersdownunder.gemmod.GemMod;
import net.codersdownunder.gemmod.blocks.terra.TerraFirmaMenu;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public class TerraFirmaScreen extends AbstractContainerScreen<TerraFirmaMenu>
{

    private ResourceLocation GUI = new ResourceLocation(GemMod.MODID, "textures/gui/terra.png");
    
    
	private float scrollOffs;
    private boolean scrolling;

    public TerraFirmaScreen(TerraFirmaMenu container, Inventory inv, Component name) {
        super(container, inv, name);

    }
    
    static final int FONT_Y_SPACING = 10;
    static final int PLAYER_INV_LABEL_XPOS = TerraFirmaMenu.PLAYER_INVENTORY_XPOS;
    static final int PLAYER_INV_LABEL_YPOS = TerraFirmaMenu.PLAYER_INVENTORY_YPOS - FONT_Y_SPACING;

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
        
        final int LABEL_XPOS = 38;
        final int LABEL_YPOS = -6;
        this.font.draw(matrixStack, this.title, LABEL_XPOS, LABEL_YPOS, Color.darkGray.getRGB()); 
        
        this.font.draw(matrixStack, this.playerInventoryTitle, PLAYER_INV_LABEL_XPOS, PLAYER_INV_LABEL_YPOS,
				Color.darkGray.getRGB());	
    }
    

    @Override
    protected void renderBg(PoseStack matrixStack, float partialTicks, int mouseX, int mouseY) {
        RenderSystem.setShaderTexture(0, GUI);
        int relX = (this.width - 200) / 2;
        int relY = (this.height - 190) / 2;
        this.blit(matrixStack, relX, relY, 0, 0, 175, 186);
        this.blit(matrixStack, relX + 4, relY + 76, 176 + (this.isScrollBarActive() ? 0 : 12), 0, 12, 15);
        renderButtons(matrixStack, mouseX, mouseY, relX + 24, relY + 63, 8);
        renderRecipes(matrixStack, relX + 24, relY + 63, 7);
    }
    
    private void renderButtons(PoseStack pPoseStack, int pMouseX, int pMouseY, int pX, int pY, int pLastVisibleElementIndex) {
        for(int i = 0; i < pLastVisibleElementIndex && i < 9; ++i) {
           int j = i;
           int k = pX + j % 8 * 16;
           int l = j / 8;
           int i1 = pY + l * 18;
           int j1 = this.imageHeight;
            if (i == i) {
              j1 += 18;
           } else if (pMouseX >= k && pMouseY >= i1 && pMouseX < k + 16 && pMouseY < i1 + 18) {
              j1 += 36;
           }

           this.blit(pPoseStack, k, i1 - 1, 0, j1 + 33, 16, 18);
        }

     }
    
    private void renderRecipes(PoseStack pPoseStack, int pLeft, int pTop, int pRecipeIndexOffsetMax) {
        List<Item> list = new ArrayList<Item>();
        
        list.add(Items.DIAMOND);
        list.add(Items.ACACIA_BOAT);
        list.add(Items.YELLOW_WOOL);
        list.add(Items.EMERALD);
        list.add(Items.IRON_INGOT);
        list.add(Items.OAK_LOG);
        list.add(Items.ARROW);
        list.add(Items.ARMOR_STAND);
        list.add(Items.DEEPSLATE);

        //
        
        for(int i = 0; i < pRecipeIndexOffsetMax && i < list.size(); ++i) {
           int j = i;
           int k = pLeft + j % 20 * 18;
           int l = j / 4;
           this.minecraft.getItemRenderer().renderAndDecorateItem(new ItemStack(list.get(i)), k, pTop);
          
        }

     }
    
    private boolean isScrollBarActive() {
        return true;
     }
}
