package net.codersdownunder.gemmod.compat.jei.categories;

import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.codersdownunder.gemmod.GemMod;
import net.codersdownunder.gemmod.init.BlockInit;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.SmeltingRecipe;

public class SongForgeRecipeCategory implements IRecipeCategory<SmeltingRecipe>
{
    public static final RecipeType<SmeltingRecipe> SMELTING = RecipeType.create(GemMod.MODID, "songforge_recipe", SmeltingRecipe.class);
    public static final ResourceLocation ID = new ResourceLocation(GemMod.MODID, "songforge_recipe");
    public static final ResourceLocation GUI = new ResourceLocation(GemMod.MODID, "textures/gui/song_forge.png");
    private final IDrawable back;
    private final IDrawable icon;

    public SongForgeRecipeCategory(IGuiHelper helper) {
        this.back = helper.drawableBuilder(GUI, 0, 0, 190, 70).trim(14, 0, 10, 20).build();
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(BlockInit.SONG_FORGE.get()));
    }

    @Override
    public RecipeType<SmeltingRecipe> getRecipeType() {
        return SMELTING;
    }

    @Override
    public Component getTitle() {
        return Component.translatable("category." + GemMod.MODID + ".songforge_recipe");
    }

    @Override
    public IDrawable getBackground() {
        return back;
    }

    @Override
    public IDrawable getIcon() {
        return icon;
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, SmeltingRecipe recipe, IFocusGroup focuses) {
        builder.addSlot(RecipeIngredientRole.INPUT, 28, 3)
                .addIngredients(recipe.getIngredients().get(0))
                .setSlotName("ingredient");
        builder.addSlot(RecipeIngredientRole.OUTPUT, 124, 21)
                .addIngredient(VanillaTypes.ITEM_STACK, recipe.getResultItem())
                .setSlotName("result");
    }
}
