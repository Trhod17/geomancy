package net.codersdownunder.gemmod.crafting.recipe.infusing;

import net.codersdownunder.gemmod.GemMod;
import net.minecraft.world.item.crafting.RecipeType;

public class InfusingRecipeType implements RecipeType<InfusingRecipe> {
    
    @Override
    public String toString() {
        return GemMod.MODID + ":infusing";
    }

}