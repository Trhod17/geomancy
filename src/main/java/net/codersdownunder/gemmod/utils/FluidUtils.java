package net.codersdownunder.gemmod.utils;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.mojang.blaze3d.systems.RenderSystem;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.core.BlockPos;
import net.minecraft.world.inventory.InventoryMenu;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.material.Fluids;
import net.minecraftforge.client.extensions.common.IClientFluidTypeExtensions;
import net.minecraftforge.fluids.FluidStack;

public class FluidUtils {
	
	//Render liquid
    public static float getRed(int color) {
        return (color >> 16 & 0xFF) / 255.0F;
    }

    public static float getGreen(int color) {
        return (color >> 8 & 0xFF) / 255.0F;
    }

    public static float getBlue(int color) {
        return (color & 0xFF) / 255.0F;
    }

    public static float getAlpha(int color) {
        return (color >> 24 & 0xFF) / 255.0F;
    }

    public static void color(int color) {
        RenderSystem.setShaderColor(getRed(color), getGreen(color), getBlue(color), getAlpha(color));
    }

    @Nullable
    public static TextureAtlasSprite getFluidTexture(@Nonnull FluidStack stack) {
        return Minecraft.getInstance().getTextureAtlas(InventoryMenu.BLOCK_ATLAS).apply(IClientFluidTypeExtensions.of(stack.getFluid()).getStillTexture());
    }

    public static int getLiquidColorWithBiome(@Nonnull FluidStack fluid, Level world, BlockPos pos) {
        if(world.isClientSide) {
            if (fluid.isFluidEqual(new FluidStack(Fluids.WATER, 1000))) {
                return BiomeColors.getAverageWaterColor(world, pos) | 0xFF000000;
            }
        }
        return IClientFluidTypeExtensions.of(fluid.getFluid()).getTintColor();
    }

    public static int getLiquidColorWithBiome(@Nonnull FluidStack fluid, @Nonnull BlockEntity tileEntity) {
        return getLiquidColorWithBiome(fluid, tileEntity.getLevel(), tileEntity.getBlockPos());
    }

    public static int getFluidScaled(int pixels, FluidStack fluid, int maxLiquidAmount) {
        if(maxLiquidAmount == 0)
            return pixels;
        long currentLiquidAmount = (long) fluid.getAmount();
        long x = currentLiquidAmount * pixels / maxLiquidAmount;
        return pixels - (int) x;
    }
}
