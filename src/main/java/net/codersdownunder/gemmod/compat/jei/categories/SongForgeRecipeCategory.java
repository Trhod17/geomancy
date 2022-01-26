package net.codersdownunder.gemmod.compat.jei.categories;

import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.ingredient.IGuiItemStackGroup;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.codersdownunder.gemmod.GemMod;
import net.codersdownunder.gemmod.init.BlockInit;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.SmeltingRecipe;

public class SongForgeRecipeCategory implements IRecipeCategory<SmeltingRecipe>
{
    public static final ResourceLocation ID = new ResourceLocation(GemMod.MODID, ".songforge_recipe_category");
    public static final ResourceLocation GUI = new ResourceLocation(GemMod.MODID, "textures/gui/song_forge.png");
    private final IDrawable back;
    private final IDrawable icon;
    
    public SongForgeRecipeCategory(IGuiHelper helper) {
        this.back = helper.drawableBuilder(GUI, 0, 0, 190, 70).trim(14, 0, 10, 20).build();
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM, new ItemStack(BlockInit.SONG_FORGE.get()));
        
    }

    @Override
    public ResourceLocation getUid() {
        return ID;
    }

    @Override
    public Class<? extends SmeltingRecipe> getRecipeClass() {
        return SmeltingRecipe.class;
    }

    @Override
    public Component getTitle() {
        return new TranslatableComponent("category." + GemMod.MODID + ".songforge_recipe");
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
    public void setIngredients(SmeltingRecipe recipe, IIngredients ingredients) {
    	
        ingredients.setInputIngredients(recipe.getIngredients());
        ingredients.setOutput(VanillaTypes.ITEM, recipe.getResultItem());
    }
    
    @Override
    public void setRecipe(IRecipeLayout recipeLayout, SmeltingRecipe recipe, IIngredients ingredients) {
        IGuiItemStackGroup itemStackGroup = recipeLayout.getItemStacks();
      
        itemStackGroup.init(0, true, 27, 4);
        itemStackGroup.init(1, false, 123, 20);


		itemStackGroup.set(ingredients);
    }
}
