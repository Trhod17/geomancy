package net.codersdownunder.gemmod.crafting.recipe.infusing;

import net.codersdownunder.gemmod.GemMod;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeType;

public interface IInfusingRecipe extends Recipe<Inventory> {
    ResourceLocation TYPE_ID = new ResourceLocation(GemMod.MODID, "infusing");

    @Override
    default RecipeType<?> getType(){
        return Registry.RECIPE_TYPE.getOptional(TYPE_ID).get();
    }
    
    @Override
    default boolean canCraftInDimensions(int pWidth, int pHeight)
    {
        return true;
    }
    
    @Override
    default boolean isSpecial()
    {
        return true;
    }
}