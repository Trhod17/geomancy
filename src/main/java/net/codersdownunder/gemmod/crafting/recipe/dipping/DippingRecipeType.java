package net.codersdownunder.gemmod.crafting.recipe.dipping;

import net.codersdownunder.gemmod.GemMod;
import net.minecraft.world.item.crafting.RecipeType;

public class DippingRecipeType implements RecipeType<DippingRecipe> {
    
    @Override
    public String toString() {
        return GemMod.MODID + ":dipping";
    }

}