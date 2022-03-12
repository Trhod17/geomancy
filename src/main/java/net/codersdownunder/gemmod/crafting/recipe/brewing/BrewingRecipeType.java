package net.codersdownunder.gemmod.crafting.recipe.brewing;

import net.codersdownunder.gemmod.GemMod;
import net.minecraft.world.item.crafting.RecipeType;

public class BrewingRecipeType implements RecipeType<BrewingRecipe> {
    
    @Override
    public String toString() {
        return GemMod.MODID + ":brewing";
    }

}