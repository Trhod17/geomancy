package net.codersdownunder.gemmod.compat.jei;

import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.ingredient.IGuiItemStackGroup;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.codersdownunder.gemmod.GemMod;
import net.codersdownunder.gemmod.crafting.recipe.infusing.InfusingRecipe;
import net.codersdownunder.gemmod.init.BlockInit;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

public class InfusingRecipeCategory implements IRecipeCategory<InfusingRecipe>
{
    public static final ResourceLocation ID = new ResourceLocation(GemMod.MODID, ".infusion_recipe_category");
    public static final ResourceLocation GUI = new ResourceLocation(GemMod.MODID, "textures/gui/infusion_table.png");
    private final IDrawable back;
    private final IDrawable icon;
    
    public InfusingRecipeCategory(IGuiHelper helper) {
        this.back = helper.drawableBuilder(GUI, 0, 0, 190, 120).trim(3, 0, 20, 35).build();
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM, new ItemStack(BlockInit.INFUSION_TABLE.get()));
    }

    @Override
    public ResourceLocation getUid() {
        return ID;
    }

    @Override
    public Class<? extends InfusingRecipe> getRecipeClass() {
        return InfusingRecipe.class;
    }

    @Override
    public Component getTitle() {
        return new TranslatableComponent("category." + GemMod.MODID + ".infusing_recipe");
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
    public void setIngredients(InfusingRecipe recipe, IIngredients ingredients) {
        ingredients.setInputIngredients(recipe.getIngredients());
        ingredients.setOutput(VanillaTypes.ITEM, recipe.getResultItem());
    }
    
    @Override
    public void setRecipe(IRecipeLayout recipeLayout, InfusingRecipe recipe, IIngredients ingredients) {
        IGuiItemStackGroup itemStackGroup = recipeLayout.getItemStacks();
        
        itemStackGroup.init(0, true, 59, 86);
        itemStackGroup.init(1, true, 23, 68);
        itemStackGroup.init(2, true, 95, 68);
        itemStackGroup.init(3, true, 95, 32);
        itemStackGroup.init(4, true, 23, 32);
        itemStackGroup.init(5, true, 59, 14);
        itemStackGroup.init(6, false, 59, 50);
        
        itemStackGroup.set(ingredients);
    }
}
