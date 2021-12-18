package net.codersdownunder.gemmod.crafting.recipe.infusing;

import java.util.stream.Collectors;

import javax.annotation.Nullable;

import net.codersdownunder.gemmod.crafting.recipe.ModRecipeTypes;
import net.minecraft.core.NonNullList;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;

public class InfusingRecipes
{
    public static boolean isEmpty(Level world)
    {
        return world.getRecipeManager().getRecipes().stream().noneMatch(recipe -> recipe.getType() == ModRecipeTypes.INFUSING_RECIPE);
    }

    public static NonNullList<InfusingRecipe> getAll(Level world)
    {
        return world.getRecipeManager().getRecipes().stream()
                .filter(recipe -> recipe.getType() == ModRecipeTypes.INFUSING_RECIPE)
                .map(recipe -> (InfusingRecipe) recipe)
                .collect(Collectors.toCollection(NonNullList::create));
    }

    @Nullable
    public static InfusingRecipe getRecipeById(Level world, ResourceLocation id)
    {
        return world.getRecipeManager().getRecipes().stream()
                .filter(recipe -> recipe.getType() == ModRecipeTypes.INFUSING_RECIPE)
                .map(recipe -> (InfusingRecipe) recipe)
                .filter(recipe -> recipe.getId().equals(id))
                .findFirst().orElse(null);
    }
}
