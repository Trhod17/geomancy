package net.codersdownunder.gemmod.client.renderer.entities;

import net.codersdownunder.gemmod.Geomancy;
import net.codersdownunder.gemmod.entities.CupidArrowEntity;
import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;

public class CupidArrowRenderer extends ArrowRenderer<CupidArrowEntity>
{

    public static final ResourceLocation TEXTURE = new ResourceLocation(Geomancy.MODID,
            "textures/entity/arrow_cupid.png");

    public CupidArrowRenderer(EntityRendererProvider.Context manager) {
        super(manager);
    }

    @Override
    public ResourceLocation getTextureLocation(CupidArrowEntity arrow) {
        return TEXTURE;
    }
}